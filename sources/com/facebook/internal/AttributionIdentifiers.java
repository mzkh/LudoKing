package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;
import com.facebook.FacebookSdk;
import com.tapjoy.TapjoyConstants;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class AttributionIdentifiers {
    private static final String ANDROID_ID_COLUMN_NAME = "androidid";
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER = "com.facebook.katana.provider.AttributionIdProvider";
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI = "com.facebook.wakizashi.provider.AttributionIdProvider";
    private static final int CONNECTION_RESULT_SUCCESS = 0;
    private static final long IDENTIFIER_REFRESH_INTERVAL_MILLIS = 3600000;
    private static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
    private static final String TAG = "com.facebook.internal.AttributionIdentifiers";
    private static AttributionIdentifiers recentlyFetchedIdentifiers;
    private String androidAdvertiserId;
    private String androidInstallerPackage;
    private String attributionId;
    private long fetchTime;
    private boolean limitTracking;

    private static final class GoogleAdInfo implements IInterface {
        private static final int FIRST_TRANSACTION_CODE = 1;
        private static final int SECOND_TRANSACTION_CODE = 2;
        private IBinder binder;

        GoogleAdInfo(IBinder iBinder) {
            this.binder = iBinder;
        }

        public IBinder asBinder() {
            return this.binder;
        }

        public String getAdvertiserId() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.binder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean isTrackingLimited() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                obtain.writeInt(1);
                this.binder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    private static final class GoogleAdServiceConnection implements ServiceConnection {
        private AtomicBoolean consumed;
        private final BlockingQueue<IBinder> queue;

        public void onServiceDisconnected(ComponentName componentName) {
        }

        private GoogleAdServiceConnection() {
            this.consumed = new AtomicBoolean(false);
            this.queue = new LinkedBlockingDeque();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                try {
                    this.queue.put(iBinder);
                } catch (InterruptedException unused) {
                }
            }
        }

        public IBinder getBinder() throws InterruptedException {
            if (!this.consumed.compareAndSet(true, true)) {
                return (IBinder) this.queue.take();
            }
            throw new IllegalStateException("Binder already consumed");
        }
    }

    private static AttributionIdentifiers getAndroidId(Context context) {
        AttributionIdentifiers androidIdViaReflection = getAndroidIdViaReflection(context);
        if (androidIdViaReflection != null) {
            return androidIdViaReflection;
        }
        AttributionIdentifiers androidIdViaService = getAndroidIdViaService(context);
        return androidIdViaService == null ? new AttributionIdentifiers() : androidIdViaService;
    }

    private static AttributionIdentifiers getAndroidIdViaReflection(Context context) {
        try {
            if (!isGooglePlayServicesAvailable(context)) {
                return null;
            }
            Method methodQuietly = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", (Class<?>[]) new Class[]{Context.class});
            if (methodQuietly == null) {
                return null;
            }
            Object invokeMethodQuietly = Utility.invokeMethodQuietly(null, methodQuietly, context);
            if (invokeMethodQuietly == null) {
                return null;
            }
            Method methodQuietly2 = Utility.getMethodQuietly(invokeMethodQuietly.getClass(), "getId", (Class<?>[]) new Class[0]);
            Method methodQuietly3 = Utility.getMethodQuietly(invokeMethodQuietly.getClass(), "isLimitAdTrackingEnabled", (Class<?>[]) new Class[0]);
            if (methodQuietly2 != null) {
                if (methodQuietly3 != null) {
                    AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                    attributionIdentifiers.androidAdvertiserId = (String) Utility.invokeMethodQuietly(invokeMethodQuietly, methodQuietly2, new Object[0]);
                    attributionIdentifiers.limitTracking = ((Boolean) Utility.invokeMethodQuietly(invokeMethodQuietly, methodQuietly3, new Object[0])).booleanValue();
                    return attributionIdentifiers;
                }
            }
            return null;
        } catch (Exception e) {
            Utility.logd(TapjoyConstants.TJC_ANDROID_ID, e);
            return null;
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public static boolean isTrackingLimited(Context context) {
        AttributionIdentifiers attributionIdentifiers = getAttributionIdentifiers(context);
        return attributionIdentifiers != null && attributionIdentifiers.isTrackingLimited();
    }

    private static boolean isGooglePlayServicesAvailable(Context context) {
        Method methodQuietly = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{Context.class});
        if (methodQuietly == null) {
            return false;
        }
        Object invokeMethodQuietly = Utility.invokeMethodQuietly(null, methodQuietly, context);
        return (invokeMethodQuietly instanceof Integer) && ((Integer) invokeMethodQuietly).intValue() == 0;
    }

    private static AttributionIdentifiers getAndroidIdViaService(Context context) {
        GoogleAdServiceConnection googleAdServiceConnection = new GoogleAdServiceConnection();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, googleAdServiceConnection, 1)) {
            try {
                GoogleAdInfo googleAdInfo = new GoogleAdInfo(googleAdServiceConnection.getBinder());
                AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                attributionIdentifiers.androidAdvertiserId = googleAdInfo.getAdvertiserId();
                attributionIdentifiers.limitTracking = googleAdInfo.isTrackingLimited();
                return attributionIdentifiers;
            } catch (Exception e) {
                Utility.logd(TapjoyConstants.TJC_ANDROID_ID, e);
            } finally {
                context.unbindService(googleAdServiceConnection);
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0076 A[Catch:{ Exception -> 0x00e6, all -> 0x00e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007a A[Catch:{ Exception -> 0x00e6, all -> 0x00e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007f A[Catch:{ Exception -> 0x00e6, all -> 0x00e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x010c  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.internal.AttributionIdentifiers getAttributionIdentifiers(android.content.Context r13) {
        /*
            java.lang.String r0 = "limit_tracking"
            java.lang.String r1 = "androidid"
            java.lang.String r2 = "aid"
            com.facebook.internal.AttributionIdentifiers r3 = getAndroidId(r13)
            r4 = 0
            android.os.Looper r5 = android.os.Looper.myLooper()     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            android.os.Looper r6 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            if (r5 == r6) goto L_0x00dc
            com.facebook.internal.AttributionIdentifiers r5 = recentlyFetchedIdentifiers     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            if (r5 == 0) goto L_0x002c
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            com.facebook.internal.AttributionIdentifiers r7 = recentlyFetchedIdentifiers     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            long r7 = r7.fetchTime     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            long r5 = r5 - r7
            r7 = 3600000(0x36ee80, double:1.7786363E-317)
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x002c
            com.facebook.internal.AttributionIdentifiers r13 = recentlyFetchedIdentifiers     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            return r13
        L_0x002c:
            r5 = 3
            java.lang.String[] r8 = new java.lang.String[r5]     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            r5 = 0
            r8[r5] = r2     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            r6 = 1
            r8[r6] = r1     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            r6 = 2
            r8[r6] = r0     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            android.content.pm.PackageManager r6 = r13.getPackageManager()     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            java.lang.String r7 = "com.facebook.katana.provider.AttributionIdProvider"
            android.content.pm.ProviderInfo r6 = r6.resolveContentProvider(r7, r5)     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            android.content.pm.PackageManager r7 = r13.getPackageManager()     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            java.lang.String r9 = "com.facebook.wakizashi.provider.AttributionIdProvider"
            android.content.pm.ProviderInfo r5 = r7.resolveContentProvider(r9, r5)     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            if (r6 == 0) goto L_0x005e
            java.lang.String r6 = r6.packageName     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            boolean r6 = com.facebook.internal.FacebookSignatureValidator.validateSignature(r13, r6)     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            if (r6 == 0) goto L_0x005e
            java.lang.String r5 = "content://com.facebook.katana.provider.AttributionIdProvider"
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
        L_0x005c:
            r7 = r5
            goto L_0x0070
        L_0x005e:
            if (r5 == 0) goto L_0x006f
            java.lang.String r5 = r5.packageName     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            boolean r5 = com.facebook.internal.FacebookSignatureValidator.validateSignature(r13, r5)     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            if (r5 == 0) goto L_0x006f
            java.lang.String r5 = "content://com.facebook.wakizashi.provider.AttributionIdProvider"
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            goto L_0x005c
        L_0x006f:
            r7 = r4
        L_0x0070:
            java.lang.String r5 = getInstallerPackageName(r13)     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            if (r5 == 0) goto L_0x0078
            r3.androidInstallerPackage = r5     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
        L_0x0078:
            if (r7 != 0) goto L_0x007f
            com.facebook.internal.AttributionIdentifiers r13 = cacheAndReturnIdentifiers(r3)     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            return r13
        L_0x007f:
            android.content.ContentResolver r6 = r13.getContentResolver()     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r13 = r6.query(r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            if (r13 == 0) goto L_0x00c9
            boolean r5 = r13.moveToFirst()     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            if (r5 != 0) goto L_0x0093
            goto L_0x00c9
        L_0x0093:
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            int r0 = r13.getColumnIndex(r0)     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            r3.attributionId = r2     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            if (r1 <= 0) goto L_0x00bf
            if (r0 <= 0) goto L_0x00bf
            java.lang.String r2 = r3.getAndroidAdvertiserId()     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            if (r2 != 0) goto L_0x00bf
            java.lang.String r1 = r13.getString(r1)     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            r3.androidAdvertiserId = r1     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            java.lang.String r0 = r13.getString(r0)     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            r3.limitTracking = r0     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
        L_0x00bf:
            if (r13 == 0) goto L_0x00c4
            r13.close()
        L_0x00c4:
            com.facebook.internal.AttributionIdentifiers r13 = cacheAndReturnIdentifiers(r3)
            return r13
        L_0x00c9:
            com.facebook.internal.AttributionIdentifiers r0 = cacheAndReturnIdentifiers(r3)     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            if (r13 == 0) goto L_0x00d2
            r13.close()
        L_0x00d2:
            return r0
        L_0x00d3:
            r0 = move-exception
            r4 = r13
            r13 = r0
            goto L_0x010a
        L_0x00d7:
            r0 = move-exception
            r12 = r0
            r0 = r13
            r13 = r12
            goto L_0x00e8
        L_0x00dc:
            com.facebook.FacebookException r13 = new com.facebook.FacebookException     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            java.lang.String r0 = "getAttributionIdentifiers cannot be called on the main thread."
            r13.<init>(r0)     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
            throw r13     // Catch:{ Exception -> 0x00e6, all -> 0x00e4 }
        L_0x00e4:
            r13 = move-exception
            goto L_0x010a
        L_0x00e6:
            r13 = move-exception
            r0 = r4
        L_0x00e8:
            java.lang.String r1 = TAG     // Catch:{ all -> 0x0108 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0108 }
            r2.<init>()     // Catch:{ all -> 0x0108 }
            java.lang.String r3 = "Caught unexpected exception in getAttributionId(): "
            r2.append(r3)     // Catch:{ all -> 0x0108 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0108 }
            r2.append(r13)     // Catch:{ all -> 0x0108 }
            java.lang.String r13 = r2.toString()     // Catch:{ all -> 0x0108 }
            com.facebook.internal.Utility.logd(r1, r13)     // Catch:{ all -> 0x0108 }
            if (r0 == 0) goto L_0x0107
            r0.close()
        L_0x0107:
            return r4
        L_0x0108:
            r13 = move-exception
            r4 = r0
        L_0x010a:
            if (r4 == 0) goto L_0x010f
            r4.close()
        L_0x010f:
            throw r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.AttributionIdentifiers.getAttributionIdentifiers(android.content.Context):com.facebook.internal.AttributionIdentifiers");
    }

    public static AttributionIdentifiers getCachedIdentifiers() {
        return recentlyFetchedIdentifiers;
    }

    private static AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers attributionIdentifiers) {
        attributionIdentifiers.fetchTime = System.currentTimeMillis();
        recentlyFetchedIdentifiers = attributionIdentifiers;
        return attributionIdentifiers;
    }

    public String getAttributionId() {
        return this.attributionId;
    }

    public String getAndroidAdvertiserId() {
        if (!FacebookSdk.isInitialized() || !FacebookSdk.getAdvertiserIDCollectionEnabled()) {
            return null;
        }
        return this.androidAdvertiserId;
    }

    public String getAndroidInstallerPackage() {
        return this.androidInstallerPackage;
    }

    public boolean isTrackingLimited() {
        return this.limitTracking;
    }

    @Nullable
    private static String getInstallerPackageName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            return packageManager.getInstallerPackageName(context.getPackageName());
        }
        return null;
    }
}
