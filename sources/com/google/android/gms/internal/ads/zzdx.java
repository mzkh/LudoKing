package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzdx {
    private static final String TAG = "zzdx";
    protected Context zzlk;
    private volatile boolean zzwo = false;
    private ExecutorService zzxr;
    private DexClassLoader zzxs;
    private zzdh zzxt;
    private byte[] zzxu;
    private volatile AdvertisingIdClient zzxv = null;
    private Future zzxw = null;
    private boolean zzxx;
    /* access modifiers changed from: private */
    public volatile com.google.android.gms.internal.ads.zzbo.zza zzxy = null;
    private Future zzxz = null;
    private zzda zzya;
    protected boolean zzyb = false;
    private boolean zzyc = false;
    private Map<Pair<String, String>, zzfj> zzyd;
    private boolean zzye = false;
    /* access modifiers changed from: private */
    public boolean zzyf;
    private boolean zzyg;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    final class zza extends BroadcastReceiver {
        private zza() {
        }

        public final void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                zzdx.this.zzyf = true;
                return;
            }
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                zzdx.this.zzyf = false;
            }
        }

        /* synthetic */ zza(zzdx zzdx, zzea zzea) {
            this();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(33:0|1|2|(1:4)|5|6|7|8|(1:10)(1:11)|12|(1:14)(1:15)|16|17|18|(2:20|(1:22)(2:23|24))|25|26|27|28|29|(2:31|(1:33)(2:34|35))|36|(1:38)|39|40|41|42|43|44|45|(1:47)|48|69) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004d */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056 A[Catch:{ zzdk -> 0x0150, zzdw -> 0x0157 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0089 A[Catch:{ all -> 0x011f, FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b4 A[Catch:{ all -> 0x011f, FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00fa A[Catch:{ zzdk -> 0x0150, zzdw -> 0x0157 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzdx zza(android.content.Context r9, java.lang.String r10, java.lang.String r11, boolean r12) {
        /*
            java.lang.String r0 = "%s/%s.dex"
            com.google.android.gms.internal.ads.zzdx r1 = new com.google.android.gms.internal.ads.zzdx
            r1.<init>(r9)
            com.google.android.gms.internal.ads.zzea r9 = new com.google.android.gms.internal.ads.zzea     // Catch:{ zzdw -> 0x0157 }
            r9.<init>()     // Catch:{ zzdw -> 0x0157 }
            java.util.concurrent.ExecutorService r9 = java.util.concurrent.Executors.newCachedThreadPool(r9)     // Catch:{ zzdw -> 0x0157 }
            r1.zzxr = r9     // Catch:{ zzdw -> 0x0157 }
            r1.zzwo = r12     // Catch:{ zzdw -> 0x0157 }
            if (r12 == 0) goto L_0x0023
            java.util.concurrent.ExecutorService r9 = r1.zzxr     // Catch:{ zzdw -> 0x0157 }
            com.google.android.gms.internal.ads.zzdz r12 = new com.google.android.gms.internal.ads.zzdz     // Catch:{ zzdw -> 0x0157 }
            r12.<init>(r1)     // Catch:{ zzdw -> 0x0157 }
            java.util.concurrent.Future r9 = r9.submit(r12)     // Catch:{ zzdw -> 0x0157 }
            r1.zzxw = r9     // Catch:{ zzdw -> 0x0157 }
        L_0x0023:
            java.util.concurrent.ExecutorService r9 = r1.zzxr     // Catch:{ zzdw -> 0x0157 }
            com.google.android.gms.internal.ads.zzeb r12 = new com.google.android.gms.internal.ads.zzeb     // Catch:{ zzdw -> 0x0157 }
            r12.<init>(r1)     // Catch:{ zzdw -> 0x0157 }
            r9.execute(r12)     // Catch:{ zzdw -> 0x0157 }
            r9 = 1
            r12 = 0
            com.google.android.gms.common.GoogleApiAvailabilityLight r2 = com.google.android.gms.common.GoogleApiAvailabilityLight.getInstance()     // Catch:{ Throwable -> 0x004d }
            android.content.Context r3 = r1.zzlk     // Catch:{ Throwable -> 0x004d }
            int r3 = r2.getApkVersion(r3)     // Catch:{ Throwable -> 0x004d }
            if (r3 <= 0) goto L_0x003d
            r3 = 1
            goto L_0x003e
        L_0x003d:
            r3 = 0
        L_0x003e:
            r1.zzyb = r3     // Catch:{ Throwable -> 0x004d }
            android.content.Context r3 = r1.zzlk     // Catch:{ Throwable -> 0x004d }
            int r2 = r2.isGooglePlayServicesAvailable(r3)     // Catch:{ Throwable -> 0x004d }
            if (r2 != 0) goto L_0x004a
            r2 = 1
            goto L_0x004b
        L_0x004a:
            r2 = 0
        L_0x004b:
            r1.zzyc = r2     // Catch:{ Throwable -> 0x004d }
        L_0x004d:
            r1.zza(r12, r9)     // Catch:{ zzdw -> 0x0157 }
            boolean r2 = com.google.android.gms.internal.ads.zzee.isMainThread()     // Catch:{ zzdw -> 0x0157 }
            if (r2 == 0) goto L_0x0071
            com.google.android.gms.internal.ads.zzyp<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzza.zzcnj     // Catch:{ zzdw -> 0x0157 }
            com.google.android.gms.internal.ads.zzyw r3 = com.google.android.gms.internal.ads.zzuv.zzon()     // Catch:{ zzdw -> 0x0157 }
            java.lang.Object r2 = r3.zzd(r2)     // Catch:{ zzdw -> 0x0157 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ zzdw -> 0x0157 }
            boolean r2 = r2.booleanValue()     // Catch:{ zzdw -> 0x0157 }
            if (r2 != 0) goto L_0x0069
            goto L_0x0071
        L_0x0069:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ zzdw -> 0x0157 }
            java.lang.String r10 = "Task Context initialization must not be called from the UI thread."
            r9.<init>(r10)     // Catch:{ zzdw -> 0x0157 }
            throw r9     // Catch:{ zzdw -> 0x0157 }
        L_0x0071:
            com.google.android.gms.internal.ads.zzdh r2 = new com.google.android.gms.internal.ads.zzdh     // Catch:{ zzdw -> 0x0157 }
            r3 = 0
            r2.<init>(r3)     // Catch:{ zzdw -> 0x0157 }
            r1.zzxt = r2     // Catch:{ zzdw -> 0x0157 }
            com.google.android.gms.internal.ads.zzdh r2 = r1.zzxt     // Catch:{ zzdk -> 0x0150 }
            byte[] r10 = r2.zzaq(r10)     // Catch:{ zzdk -> 0x0150 }
            r1.zzxu = r10     // Catch:{ zzdk -> 0x0150 }
            android.content.Context r10 = r1.zzlk     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            java.io.File r10 = r10.getCacheDir()     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            if (r10 != 0) goto L_0x009a
            android.content.Context r10 = r1.zzlk     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            java.lang.String r2 = "dex"
            java.io.File r10 = r10.getDir(r2, r12)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            if (r10 == 0) goto L_0x0094
            goto L_0x009a
        L_0x0094:
            com.google.android.gms.internal.ads.zzdw r9 = new com.google.android.gms.internal.ads.zzdw     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            r9.<init>()     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            throw r9     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
        L_0x009a:
            java.lang.String r2 = "1561154238473"
            java.io.File r4 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            java.lang.String r5 = "%s/%s.jar"
            r6 = 2
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            r7[r12] = r10     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            r7[r9] = r2     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            java.lang.String r5 = java.lang.String.format(r5, r7)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            boolean r5 = r4.exists()     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            if (r5 != 0) goto L_0x00cb
            com.google.android.gms.internal.ads.zzdh r5 = r1.zzxt     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            byte[] r7 = r1.zzxu     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            byte[] r11 = r5.zza(r7, r11)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            r4.createNewFile()     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            r5.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            int r7 = r11.length     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            r5.write(r11, r12, r7)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            r5.close()     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
        L_0x00cb:
            r1.zzb(r10, r2)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            dalvik.system.DexClassLoader r11 = new dalvik.system.DexClassLoader     // Catch:{ all -> 0x011f }
            java.lang.String r5 = r4.getAbsolutePath()     // Catch:{ all -> 0x011f }
            java.lang.String r7 = r10.getAbsolutePath()     // Catch:{ all -> 0x011f }
            android.content.Context r8 = r1.zzlk     // Catch:{ all -> 0x011f }
            java.lang.ClassLoader r8 = r8.getClassLoader()     // Catch:{ all -> 0x011f }
            r11.<init>(r5, r7, r3, r8)     // Catch:{ all -> 0x011f }
            r1.zzxs = r11     // Catch:{ all -> 0x011f }
            zzb(r4)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            r1.zza(r10, r2)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            java.lang.Object[] r11 = new java.lang.Object[r6]     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            r11[r12] = r10     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            r11[r9] = r2     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            java.lang.String r10 = java.lang.String.format(r0, r11)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            zzar(r10)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            boolean r10 = r1.zzyg     // Catch:{ zzdw -> 0x0157 }
            if (r10 != 0) goto L_0x0115
            android.content.IntentFilter r10 = new android.content.IntentFilter     // Catch:{ zzdw -> 0x0157 }
            r10.<init>()     // Catch:{ zzdw -> 0x0157 }
            java.lang.String r11 = "android.intent.action.USER_PRESENT"
            r10.addAction(r11)     // Catch:{ zzdw -> 0x0157 }
            java.lang.String r11 = "android.intent.action.SCREEN_OFF"
            r10.addAction(r11)     // Catch:{ zzdw -> 0x0157 }
            android.content.Context r11 = r1.zzlk     // Catch:{ zzdw -> 0x0157 }
            com.google.android.gms.internal.ads.zzdx$zza r12 = new com.google.android.gms.internal.ads.zzdx$zza     // Catch:{ zzdw -> 0x0157 }
            r12.<init>(r1, r3)     // Catch:{ zzdw -> 0x0157 }
            r11.registerReceiver(r12, r10)     // Catch:{ zzdw -> 0x0157 }
            r1.zzyg = r9     // Catch:{ zzdw -> 0x0157 }
        L_0x0115:
            com.google.android.gms.internal.ads.zzda r10 = new com.google.android.gms.internal.ads.zzda     // Catch:{ zzdw -> 0x0157 }
            r10.<init>(r1)     // Catch:{ zzdw -> 0x0157 }
            r1.zzya = r10     // Catch:{ zzdw -> 0x0157 }
            r1.zzye = r9     // Catch:{ zzdw -> 0x0157 }
            goto L_0x0157
        L_0x011f:
            r11 = move-exception
            zzb(r4)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            r1.zza(r10, r2)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            r3[r12] = r10     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            r3[r9] = r2     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            java.lang.String r9 = java.lang.String.format(r0, r3)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            zzar(r9)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
            throw r11     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzdk -> 0x013b, NullPointerException -> 0x0134 }
        L_0x0134:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzdw r10 = new com.google.android.gms.internal.ads.zzdw     // Catch:{ zzdw -> 0x0157 }
            r10.<init>(r9)     // Catch:{ zzdw -> 0x0157 }
            throw r10     // Catch:{ zzdw -> 0x0157 }
        L_0x013b:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzdw r10 = new com.google.android.gms.internal.ads.zzdw     // Catch:{ zzdw -> 0x0157 }
            r10.<init>(r9)     // Catch:{ zzdw -> 0x0157 }
            throw r10     // Catch:{ zzdw -> 0x0157 }
        L_0x0142:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzdw r10 = new com.google.android.gms.internal.ads.zzdw     // Catch:{ zzdw -> 0x0157 }
            r10.<init>(r9)     // Catch:{ zzdw -> 0x0157 }
            throw r10     // Catch:{ zzdw -> 0x0157 }
        L_0x0149:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzdw r10 = new com.google.android.gms.internal.ads.zzdw     // Catch:{ zzdw -> 0x0157 }
            r10.<init>(r9)     // Catch:{ zzdw -> 0x0157 }
            throw r10     // Catch:{ zzdw -> 0x0157 }
        L_0x0150:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzdw r10 = new com.google.android.gms.internal.ads.zzdw     // Catch:{ zzdw -> 0x0157 }
            r10.<init>(r9)     // Catch:{ zzdw -> 0x0157 }
            throw r10     // Catch:{ zzdw -> 0x0157 }
        L_0x0157:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdx.zza(android.content.Context, java.lang.String, java.lang.String, boolean):com.google.android.gms.internal.ads.zzdx");
    }

    public final Context getContext() {
        return this.zzlk;
    }

    public final boolean isInitialized() {
        return this.zzye;
    }

    public final ExecutorService zzce() {
        return this.zzxr;
    }

    public final DexClassLoader zzcf() {
        return this.zzxs;
    }

    public final zzdh zzcg() {
        return this.zzxt;
    }

    public final byte[] zzch() {
        return this.zzxu;
    }

    public final boolean zzci() {
        return this.zzyb;
    }

    public final zzda zzcj() {
        return this.zzya;
    }

    public final boolean zzck() {
        return this.zzyc;
    }

    public final boolean zzcl() {
        return this.zzyf;
    }

    public final com.google.android.gms.internal.ads.zzbo.zza zzcm() {
        return this.zzxy;
    }

    public final Future zzcn() {
        return this.zzxz;
    }

    private zzdx(Context context) {
        boolean z = true;
        this.zzyf = true;
        this.zzyg = false;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            z = false;
        }
        this.zzxx = z;
        if (this.zzxx) {
            context = applicationContext;
        }
        this.zzlk = context;
        this.zzyd = new HashMap();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:20|21|22|23|24|25|26|27|28|30) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00c0 */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d2 A[SYNTHETIC, Splitter:B:39:0x00d2] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d7 A[SYNTHETIC, Splitter:B:43:0x00d7] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e1 A[SYNTHETIC, Splitter:B:52:0x00e1] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e6 A[SYNTHETIC, Splitter:B:56:0x00e6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(java.io.File r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "test"
            java.io.File r1 = new java.io.File
            r2 = 2
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 0
            r3[r4] = r10
            r5 = 1
            r3[r5] = r11
            java.lang.String r6 = "%s/%s.tmp"
            java.lang.String r3 = java.lang.String.format(r6, r3)
            r1.<init>(r3)
            boolean r3 = r1.exists()
            if (r3 == 0) goto L_0x001d
            return
        L_0x001d:
            java.io.File r3 = new java.io.File
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r10
            r2[r5] = r11
            java.lang.String r10 = "%s/%s.dex"
            java.lang.String r10 = java.lang.String.format(r10, r2)
            r3.<init>(r10)
            boolean r10 = r3.exists()
            if (r10 != 0) goto L_0x0035
            return
        L_0x0035:
            long r5 = r3.length()
            r7 = 0
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 > 0) goto L_0x0040
            return
        L_0x0040:
            int r10 = (int) r5
            byte[] r10 = new byte[r10]
            r2 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00ce }
            r5.<init>(r3)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00ce }
            int r6 = r5.read(r10)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            if (r6 > 0) goto L_0x0056
            r5.close()     // Catch:{ IOException -> 0x0052 }
        L_0x0052:
            zzb(r3)
            return
        L_0x0056:
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            r6.print(r0)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            r6.print(r0)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            r6.print(r0)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            com.google.android.gms.internal.ads.zzbo$zzd$zza r0 = com.google.android.gms.internal.ads.zzbo.zzd.zzbb()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            byte[] r6 = r6.getBytes()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            com.google.android.gms.internal.ads.zzdpm r6 = com.google.android.gms.internal.ads.zzdpm.zzy(r6)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            com.google.android.gms.internal.ads.zzbo$zzd$zza r0 = r0.zzl(r6)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            byte[] r11 = r11.getBytes()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            com.google.android.gms.internal.ads.zzdpm r11 = com.google.android.gms.internal.ads.zzdpm.zzy(r11)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            com.google.android.gms.internal.ads.zzbo$zzd$zza r11 = r0.zzk(r11)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            com.google.android.gms.internal.ads.zzdh r0 = r9.zzxt     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            byte[] r6 = r9.zzxu     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            java.lang.String r10 = r0.zzb(r6, r10)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            byte[] r10 = r10.getBytes()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            com.google.android.gms.internal.ads.zzdpm r0 = com.google.android.gms.internal.ads.zzdpm.zzy(r10)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            com.google.android.gms.internal.ads.zzbo$zzd$zza r0 = r11.zzi(r0)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            byte[] r10 = com.google.android.gms.internal.ads.zzci.zzb(r10)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            com.google.android.gms.internal.ads.zzdpm r10 = com.google.android.gms.internal.ads.zzdpm.zzy(r10)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            r0.zzj(r10)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            r1.createNewFile()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            r10.<init>(r1)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            com.google.android.gms.internal.ads.zzdsg r11 = r11.zzazr()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzdqw r11 = (com.google.android.gms.internal.ads.zzdqw) r11     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzbo$zzd r11 = (com.google.android.gms.internal.ads.zzbo.zzd) r11     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c7 }
            byte[] r11 = r11.toByteArray()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c7 }
            int r0 = r11.length     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c7 }
            r10.write(r11, r4, r0)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c7 }
            r10.close()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c7 }
            r5.close()     // Catch:{ IOException -> 0x00c0 }
        L_0x00c0:
            r10.close()     // Catch:{ IOException -> 0x00c3 }
        L_0x00c3:
            zzb(r3)
            return
        L_0x00c7:
            r11 = move-exception
            r2 = r10
            goto L_0x00d0
        L_0x00ca:
            r2 = r10
            goto L_0x00df
        L_0x00cc:
            r11 = move-exception
            goto L_0x00d0
        L_0x00ce:
            r11 = move-exception
            r5 = r2
        L_0x00d0:
            if (r5 == 0) goto L_0x00d5
            r5.close()     // Catch:{ IOException -> 0x00d5 }
        L_0x00d5:
            if (r2 == 0) goto L_0x00da
            r2.close()     // Catch:{ IOException -> 0x00da }
        L_0x00da:
            zzb(r3)
            throw r11
        L_0x00de:
            r5 = r2
        L_0x00df:
            if (r5 == 0) goto L_0x00e4
            r5.close()     // Catch:{ IOException -> 0x00e4 }
        L_0x00e4:
            if (r2 == 0) goto L_0x00e9
            r2.close()     // Catch:{ IOException -> 0x00e9 }
        L_0x00e9:
            zzb(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdx.zza(java.io.File, java.lang.String):void");
    }

    private static void zzar(String str) {
        zzb(new File(str));
    }

    private static void zzb(File file) {
        if (!file.exists()) {
            Log.d(TAG, String.format("File %s not found. No need for deletion", new Object[]{file.getAbsolutePath()}));
            return;
        }
        file.delete();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00cc */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e2 A[SYNTHETIC, Splitter:B:52:0x00e2] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e7 A[SYNTHETIC, Splitter:B:56:0x00e7] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ee A[SYNTHETIC, Splitter:B:64:0x00ee] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f3 A[SYNTHETIC, Splitter:B:68:0x00f3] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzb(java.io.File r10, java.lang.String r11) {
        /*
            r9 = this;
            java.io.File r0 = new java.io.File
            r1 = 2
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            r2[r3] = r10
            r4 = 1
            r2[r4] = r11
            java.lang.String r5 = "%s/%s.tmp"
            java.lang.String r2 = java.lang.String.format(r5, r2)
            r0.<init>(r2)
            boolean r2 = r0.exists()
            if (r2 != 0) goto L_0x001b
            return r3
        L_0x001b:
            java.io.File r2 = new java.io.File
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r3] = r10
            r1[r4] = r11
            java.lang.String r10 = "%s/%s.dex"
            java.lang.String r10 = java.lang.String.format(r10, r1)
            r2.<init>(r10)
            boolean r10 = r2.exists()
            if (r10 == 0) goto L_0x0033
            return r3
        L_0x0033:
            r10 = 0
            long r5 = r0.length()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00eb, all -> 0x00de }
            r7 = 0
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 > 0) goto L_0x0042
            zzb(r0)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00eb, all -> 0x00de }
            return r3
        L_0x0042:
            int r1 = (int) r5     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00eb, all -> 0x00de }
            byte[] r1 = new byte[r1]     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00eb, all -> 0x00de }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00eb, all -> 0x00de }
            r5.<init>(r0)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00eb, all -> 0x00de }
            int r6 = r5.read(r1)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            if (r6 > 0) goto L_0x005e
            java.lang.String r11 = TAG     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            java.lang.String r1 = "Cannot read the cache data."
            android.util.Log.d(r11, r1)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            zzb(r0)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            r5.close()     // Catch:{ IOException -> 0x005d }
        L_0x005d:
            return r3
        L_0x005e:
            com.google.android.gms.internal.ads.zzdqj r6 = com.google.android.gms.internal.ads.zzdqj.zzazb()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            com.google.android.gms.internal.ads.zzbo$zzd r1 = com.google.android.gms.internal.ads.zzbo.zzd.zzc(r1, r6)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            java.lang.String r6 = new java.lang.String     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            com.google.android.gms.internal.ads.zzdpm r7 = r1.zzaz()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r7 = r7.toByteArray()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            r6.<init>(r7)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            boolean r11 = r11.equals(r6)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            if (r11 == 0) goto L_0x00d5
            com.google.android.gms.internal.ads.zzdpm r11 = r1.zzay()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r11 = r11.toByteArray()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            com.google.android.gms.internal.ads.zzdpm r6 = r1.zzax()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r6 = r6.toByteArray()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r6 = com.google.android.gms.internal.ads.zzci.zzb(r6)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            boolean r11 = java.util.Arrays.equals(r11, r6)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            if (r11 == 0) goto L_0x00d5
            com.google.android.gms.internal.ads.zzdpm r11 = r1.zzba()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r11 = r11.toByteArray()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r6 = r6.getBytes()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            boolean r11 = java.util.Arrays.equals(r11, r6)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            if (r11 != 0) goto L_0x00a8
            goto L_0x00d5
        L_0x00a8:
            com.google.android.gms.internal.ads.zzdh r11 = r9.zzxt     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r0 = r9.zzxu     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            java.lang.String r6 = new java.lang.String     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            com.google.android.gms.internal.ads.zzdpm r1 = r1.zzax()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r1 = r1.toByteArray()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            r6.<init>(r1)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r11 = r11.zza(r0, r6)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            r2.createNewFile()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            r0.<init>(r2)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            int r10 = r11.length     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00d0 }
            r0.write(r11, r3, r10)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00d0 }
            r5.close()     // Catch:{ IOException -> 0x00cc }
        L_0x00cc:
            r0.close()     // Catch:{ IOException -> 0x00cf }
        L_0x00cf:
            return r4
        L_0x00d0:
            r11 = move-exception
            r10 = r0
            goto L_0x00e0
        L_0x00d3:
            r10 = r0
            goto L_0x00ec
        L_0x00d5:
            zzb(r0)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            r5.close()     // Catch:{ IOException -> 0x00db }
        L_0x00db:
            return r3
        L_0x00dc:
            r11 = move-exception
            goto L_0x00e0
        L_0x00de:
            r11 = move-exception
            r5 = r10
        L_0x00e0:
            if (r5 == 0) goto L_0x00e5
            r5.close()     // Catch:{ IOException -> 0x00e5 }
        L_0x00e5:
            if (r10 == 0) goto L_0x00ea
            r10.close()     // Catch:{ IOException -> 0x00ea }
        L_0x00ea:
            throw r11
        L_0x00eb:
            r5 = r10
        L_0x00ec:
            if (r5 == 0) goto L_0x00f1
            r5.close()     // Catch:{ IOException -> 0x00f1 }
        L_0x00f1:
            if (r10 == 0) goto L_0x00f6
            r10.close()     // Catch:{ IOException -> 0x00f6 }
        L_0x00f6:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdx.zzb(java.io.File, java.lang.String):boolean");
    }

    public final boolean zza(String str, String str2, Class<?>... clsArr) {
        if (this.zzyd.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.zzyd.put(new Pair(str, str2), new zzfj(this, str, str2, clsArr));
        return true;
    }

    public final Method zzc(String str, String str2) {
        zzfj zzfj = (zzfj) this.zzyd.get(new Pair(str, str2));
        if (zzfj == null) {
            return null;
        }
        return zzfj.zzcz();
    }

    /* access modifiers changed from: private */
    public final void zzco() {
        try {
            if (this.zzxv == null && this.zzxx) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zzlk);
                advertisingIdClient.start();
                this.zzxv = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.zzxv = null;
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public final void zza(int i, boolean z) {
        if (this.zzyc) {
            Future submit = this.zzxr.submit(new zzec(this, i, z));
            if (i == 0) {
                this.zzxz = submit;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public final com.google.android.gms.internal.ads.zzbo.zza zzb(int i, boolean z) {
        if (i > 0 && z) {
            try {
                Thread.sleep((long) (i * 1000));
            } catch (InterruptedException unused) {
            }
        }
        return zzcp();
    }

    /* access modifiers changed from: private */
    public static boolean zza(int i, com.google.android.gms.internal.ads.zzbo.zza zza2) {
        if (i >= 4 || (zza2 != null && zza2.zzah() && !zza2.zzad().equals("0000000000000000000000000000000000000000000000000000000000000000") && zza2.zzaj() && zza2.zzak().zzbd() && zza2.zzak().zzbe() != -2)) {
            return false;
        }
        return true;
    }

    @VisibleForTesting
    private final com.google.android.gms.internal.ads.zzbo.zza zzcp() {
        try {
            return zzczd.zzj(this.zzlk, this.zzlk.getPackageName(), Integer.toString(this.zzlk.getPackageManager().getPackageInfo(this.zzlk.getPackageName(), 0).versionCode));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final AdvertisingIdClient zzcq() {
        if (!this.zzwo) {
            return null;
        }
        if (this.zzxv != null) {
            return this.zzxv;
        }
        Future future = this.zzxw;
        if (future != null) {
            try {
                future.get(2000, TimeUnit.MILLISECONDS);
                this.zzxw = null;
            } catch (InterruptedException | ExecutionException unused) {
            } catch (TimeoutException unused2) {
                this.zzxw.cancel(true);
            }
        }
        return this.zzxv;
    }

    public final int zzbz() {
        if (this.zzya != null) {
            return zzda.zzbz();
        }
        return Integer.MIN_VALUE;
    }
}
