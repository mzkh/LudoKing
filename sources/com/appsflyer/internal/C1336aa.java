package com.appsflyer.internal;

import android.content.ContentResolver;
import android.os.Build;
import android.provider.Settings.Secure;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;

/* renamed from: com.appsflyer.internal.aa */
public final class C1336aa {

    /* renamed from: com.appsflyer.internal.aa$a */
    static class C1337a extends IllegalStateException {
        C1337a(String str) {
            super(str);
        }
    }

    C1336aa() {
    }

    /* renamed from: ˋ */
    public static C1393x m3269(ContentResolver contentResolver) {
        String str;
        C1393x xVar = null;
        if (contentResolver == null) {
            return null;
        }
        if (AppsFlyerProperties.getInstance().getString("amazon_aid") == null) {
            if ("Amazon".equals(Build.MANUFACTURER)) {
                int i = Secure.getInt(contentResolver, "limit_ad_tracking", 2);
                String str2 = "advertising_id";
                if (i == 0) {
                    xVar = new C1393x(C1394e.AMAZON, Secure.getString(contentResolver, str2), false);
                } else if (i != 2) {
                    try {
                        str = Secure.getString(contentResolver, str2);
                    } catch (Throwable th) {
                        AFLogger.afErrorLog("Couldn't fetch Amazon Advertising ID (Ad-Tracking is limited!)", th);
                        str = "";
                    }
                    xVar = new C1393x(C1394e.AMAZON, str, true);
                }
            }
        }
        return xVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        if (r8.length() == 0) goto L_0x0047;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008e A[SYNTHETIC, Splitter:B:34:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0135 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* renamed from: ॱ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m3270(android.content.Context r13, java.util.Map<java.lang.String, java.lang.Object> r14) {
        /*
            java.lang.String r0 = "advertiserIdEnabled"
            java.lang.String r1 = "advertiserId"
            java.lang.String r2 = "Trying to fetch GAID.."
            com.appsflyer.AFLogger.afInfoLog(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.google.android.gms.common.GoogleApiAvailability r3 = com.google.android.gms.common.GoogleApiAvailability.getInstance()     // Catch:{ Throwable -> 0x0017 }
            int r3 = r3.isGooglePlayServicesAvailable(r13)     // Catch:{ Throwable -> 0x0017 }
            goto L_0x0020
        L_0x0017:
            r3 = move-exception
            java.lang.String r4 = r3.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r4, r3)
            r3 = -1
        L_0x0020:
            r4 = 0
            r5 = 0
            r6 = 1
            java.lang.String r7 = "com.google.android.gms.ads.identifier.AdvertisingIdClient"
            java.lang.Class.forName(r7)     // Catch:{ Throwable -> 0x0062 }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r7 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r13)     // Catch:{ Throwable -> 0x0062 }
            if (r7 == 0) goto L_0x0055
            java.lang.String r8 = r7.getId()     // Catch:{ Throwable -> 0x0062 }
            boolean r7 = r7.isLimitAdTrackingEnabled()     // Catch:{ Throwable -> 0x0052 }
            if (r7 != 0) goto L_0x003a
            r7 = 1
            goto L_0x003b
        L_0x003a:
            r7 = 0
        L_0x003b:
            java.lang.String r4 = java.lang.Boolean.toString(r7)     // Catch:{ Throwable -> 0x0052 }
            if (r8 == 0) goto L_0x0047
            int r7 = r8.length()     // Catch:{ Throwable -> 0x004e }
            if (r7 != 0) goto L_0x00ef
        L_0x0047:
            java.lang.String r7 = "emptyOrNull |"
            r2.append(r7)     // Catch:{ Throwable -> 0x004e }
            goto L_0x00ef
        L_0x004e:
            r7 = move-exception
            r9 = r4
            r4 = 1
            goto L_0x0066
        L_0x0052:
            r7 = move-exception
            r9 = r4
            goto L_0x0065
        L_0x0055:
            java.lang.String r7 = "gpsAdInfo-null |"
            r2.append(r7)     // Catch:{ Throwable -> 0x0062 }
            com.appsflyer.internal.aa$a r7 = new com.appsflyer.internal.aa$a     // Catch:{ Throwable -> 0x0062 }
            java.lang.String r8 = "GpsAdIndo is null"
            r7.<init>(r8)     // Catch:{ Throwable -> 0x0062 }
            throw r7     // Catch:{ Throwable -> 0x0062 }
        L_0x0062:
            r7 = move-exception
            r8 = r4
            r9 = r8
        L_0x0065:
            r4 = 0
        L_0x0066:
            java.lang.String r10 = r7.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r10, r7)
            java.lang.Class r7 = r7.getClass()
            java.lang.String r7 = r7.getSimpleName()
            r2.append(r7)
            java.lang.String r7 = " |"
            r2.append(r7)
            java.lang.String r10 = "WARNING: Google Play Services is missing."
            com.appsflyer.AFLogger.afInfoLog(r10)
            com.appsflyer.AppsFlyerProperties r10 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r11 = "enableGpsFallback"
            boolean r10 = r10.getBoolean(r11, r6)
            if (r10 == 0) goto L_0x00ed
            com.appsflyer.internal.v$c r8 = com.appsflyer.internal.C1384v.m3350(r13)     // Catch:{ Throwable -> 0x00ae }
            java.lang.String r9 = r8.f3601     // Catch:{ Throwable -> 0x00ae }
            boolean r8 = r8.f3600     // Catch:{ Throwable -> 0x00ae }
            if (r8 != 0) goto L_0x0099
            r5 = 1
        L_0x0099:
            java.lang.String r5 = java.lang.Boolean.toString(r5)     // Catch:{ Throwable -> 0x00ae }
            if (r9 == 0) goto L_0x00a5
            int r6 = r9.length()     // Catch:{ Throwable -> 0x00ae }
            if (r6 != 0) goto L_0x00aa
        L_0x00a5:
            java.lang.String r6 = "emptyOrNull (bypass) |"
            r2.append(r6)     // Catch:{ Throwable -> 0x00ae }
        L_0x00aa:
            r6 = r4
            r4 = r5
            r8 = r9
            goto L_0x00ef
        L_0x00ae:
            r5 = move-exception
            java.lang.String r6 = r5.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r6, r5)
            java.lang.Class r6 = r5.getClass()
            java.lang.String r6 = r6.getSimpleName()
            r2.append(r6)
            r2.append(r7)
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r8 = r6.getString(r1)
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r6 = r6.getString(r0)
            java.lang.String r7 = r5.getLocalizedMessage()
            if (r7 == 0) goto L_0x00e2
            java.lang.String r5 = r5.getLocalizedMessage()
            com.appsflyer.AFLogger.afInfoLog(r5)
            goto L_0x00e9
        L_0x00e2:
            java.lang.String r5 = r5.toString()
            com.appsflyer.AFLogger.afInfoLog(r5)
        L_0x00e9:
            r12 = r6
            r6 = r4
            r4 = r12
            goto L_0x00ef
        L_0x00ed:
            r6 = r4
            r4 = r9
        L_0x00ef:
            java.lang.Class r13 = r13.getClass()
            java.lang.String r13 = r13.getName()
            java.lang.String r5 = "android.app.ReceiverRestrictedContext"
            boolean r13 = r13.equals(r5)
            if (r13 == 0) goto L_0x0114
            com.appsflyer.AppsFlyerProperties r13 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r8 = r13.getString(r1)
            com.appsflyer.AppsFlyerProperties r13 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r4 = r13.getString(r0)
            java.lang.String r13 = "context = android.app.ReceiverRestrictedContext |"
            r2.append(r13)
        L_0x0114:
            int r13 = r2.length()
            if (r13 <= 0) goto L_0x0133
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r3)
            java.lang.String r3 = ": "
            r13.append(r3)
            r13.append(r2)
            java.lang.String r13 = r13.toString()
            java.lang.String r2 = "gaidError"
            r14.put(r2, r13)
        L_0x0133:
            if (r8 == 0) goto L_0x0154
            if (r4 == 0) goto L_0x0154
            r14.put(r1, r8)
            r14.put(r0, r4)
            com.appsflyer.AppsFlyerProperties r13 = com.appsflyer.AppsFlyerProperties.getInstance()
            r13.set(r1, r8)
            com.appsflyer.AppsFlyerProperties r13 = com.appsflyer.AppsFlyerProperties.getInstance()
            r13.set(r0, r4)
            java.lang.String r13 = java.lang.String.valueOf(r6)
            java.lang.String r0 = "isGaidWithGps"
            r14.put(r0, r13)
        L_0x0154:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1336aa.m3270(android.content.Context, java.util.Map):void");
    }
}
