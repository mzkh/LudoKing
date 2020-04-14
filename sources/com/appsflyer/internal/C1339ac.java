package com.appsflyer.internal;

import android.content.Context;
import java.lang.ref.WeakReference;

/* renamed from: com.appsflyer.internal.ac */
public final class C1339ac {

    /* renamed from: ʽ */
    private boolean f3420;

    /* renamed from: ˊ */
    private String f3421 = "";

    /* renamed from: ˋ */
    public String f3422;

    /* renamed from: ˎ */
    boolean f3423 = true;

    /* renamed from: ˏ */
    boolean f3424 = true;

    /* renamed from: ॱ */
    private boolean f3425;

    /* renamed from: ॱॱ */
    private WeakReference<Context> f3426;

    public C1339ac(Context context, boolean z) {
        this.f3426 = new WeakReference<>(context);
        this.f3425 = z;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x014f  */
    /* renamed from: ˋ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.net.HttpURLConnection mo10792(java.lang.String r12) {
        /*
            r11 = this;
            boolean r0 = r11.f3425
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 1
            java.net.URL r2 = new java.net.URL     // Catch:{ Throwable -> 0x0126 }
            r2.<init>(r12)     // Catch:{ Throwable -> 0x0126 }
            boolean r3 = r11.f3424     // Catch:{ Throwable -> 0x0126 }
            java.lang.String r4 = "UTF-8"
            r5 = 0
            if (r3 == 0) goto L_0x0068
            com.appsflyer.internal.am r3 = com.appsflyer.internal.C1356am.f3467     // Catch:{ Throwable -> 0x0126 }
            if (r3 != 0) goto L_0x001e
            com.appsflyer.internal.am r3 = new com.appsflyer.internal.am     // Catch:{ Throwable -> 0x0126 }
            r3.<init>()     // Catch:{ Throwable -> 0x0126 }
            com.appsflyer.internal.C1356am.f3467 = r3     // Catch:{ Throwable -> 0x0126 }
        L_0x001e:
            com.appsflyer.internal.am r3 = com.appsflyer.internal.C1356am.f3467     // Catch:{ Throwable -> 0x0126 }
            java.lang.String r6 = r2.toString()     // Catch:{ Throwable -> 0x0126 }
            java.lang.String r7 = r11.f3422     // Catch:{ Throwable -> 0x0126 }
            java.lang.String r8 = "server_request"
            java.lang.String[] r9 = new java.lang.String[r0]     // Catch:{ Throwable -> 0x0126 }
            r9[r5] = r7     // Catch:{ Throwable -> 0x0126 }
            r3.mo10812(r8, r6, r9)     // Catch:{ Throwable -> 0x0126 }
            java.lang.String r3 = r11.f3422     // Catch:{ Throwable -> 0x0126 }
            byte[] r3 = r3.getBytes(r4)     // Catch:{ Throwable -> 0x0126 }
            int r3 = r3.length     // Catch:{ Throwable -> 0x0126 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0126 }
            java.lang.String r7 = "call = "
            r6.<init>(r7)     // Catch:{ Throwable -> 0x0126 }
            r6.append(r2)     // Catch:{ Throwable -> 0x0126 }
            java.lang.String r7 = "; size = "
            r6.append(r7)     // Catch:{ Throwable -> 0x0126 }
            r6.append(r3)     // Catch:{ Throwable -> 0x0126 }
            java.lang.String r7 = " byte"
            r6.append(r7)     // Catch:{ Throwable -> 0x0126 }
            if (r3 <= r0) goto L_0x0052
            java.lang.String r3 = "s"
            goto L_0x0054
        L_0x0052:
            java.lang.String r3 = ""
        L_0x0054:
            r6.append(r3)     // Catch:{ Throwable -> 0x0126 }
            java.lang.String r3 = "; body = "
            r6.append(r3)     // Catch:{ Throwable -> 0x0126 }
            java.lang.String r3 = r11.f3422     // Catch:{ Throwable -> 0x0126 }
            r6.append(r3)     // Catch:{ Throwable -> 0x0126 }
            java.lang.String r3 = r6.toString()     // Catch:{ Throwable -> 0x0126 }
            com.appsflyer.AFFacebookDeferredDeeplink.C13194.m3166(r3)     // Catch:{ Throwable -> 0x0126 }
        L_0x0068:
            java.lang.String r3 = "AppsFlyer"
            int r3 = r3.hashCode()     // Catch:{ Throwable -> 0x0126 }
            android.net.TrafficStats.setThreadStatsTag(r3)     // Catch:{ Throwable -> 0x0126 }
            java.net.URLConnection r3 = r2.openConnection()     // Catch:{ Throwable -> 0x0126 }
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ Throwable -> 0x0126 }
            r1 = 30000(0x7530, float:4.2039E-41)
            r3.setReadTimeout(r1)     // Catch:{ Throwable -> 0x0124 }
            r3.setConnectTimeout(r1)     // Catch:{ Throwable -> 0x0124 }
            java.lang.String r1 = "POST"
            r3.setRequestMethod(r1)     // Catch:{ Throwable -> 0x0124 }
            r3.setDoInput(r0)     // Catch:{ Throwable -> 0x0124 }
            r3.setDoOutput(r0)     // Catch:{ Throwable -> 0x0124 }
            java.lang.String r1 = "Content-Type"
            java.lang.String r6 = "application/json"
            r3.setRequestProperty(r1, r6)     // Catch:{ Throwable -> 0x0124 }
            java.io.OutputStream r1 = r3.getOutputStream()     // Catch:{ Throwable -> 0x0124 }
            java.io.BufferedWriter r6 = new java.io.BufferedWriter     // Catch:{ Throwable -> 0x0124 }
            java.io.OutputStreamWriter r7 = new java.io.OutputStreamWriter     // Catch:{ Throwable -> 0x0124 }
            r7.<init>(r1, r4)     // Catch:{ Throwable -> 0x0124 }
            r6.<init>(r7)     // Catch:{ Throwable -> 0x0124 }
            java.lang.String r4 = r11.f3422     // Catch:{ Throwable -> 0x0124 }
            r6.write(r4)     // Catch:{ Throwable -> 0x0124 }
            r6.flush()     // Catch:{ Throwable -> 0x0124 }
            r6.close()     // Catch:{ Throwable -> 0x0124 }
            r1.close()     // Catch:{ Throwable -> 0x0124 }
            r3.connect()     // Catch:{ Throwable -> 0x0124 }
            int r1 = r3.getResponseCode()     // Catch:{ Throwable -> 0x0124 }
            boolean r4 = r11.f3423     // Catch:{ Throwable -> 0x0124 }
            if (r4 == 0) goto L_0x00c1
            com.appsflyer.AppsFlyerLibCore.getInstance()     // Catch:{ Throwable -> 0x0124 }
            java.lang.String r4 = com.appsflyer.AppsFlyerLibCore.m3215(r3)     // Catch:{ Throwable -> 0x0124 }
            r11.f3421 = r4     // Catch:{ Throwable -> 0x0124 }
        L_0x00c1:
            boolean r4 = r11.f3424     // Catch:{ Throwable -> 0x0124 }
            if (r4 == 0) goto L_0x00e8
            com.appsflyer.internal.am r4 = com.appsflyer.internal.C1356am.f3467     // Catch:{ Throwable -> 0x0124 }
            if (r4 != 0) goto L_0x00d0
            com.appsflyer.internal.am r4 = new com.appsflyer.internal.am     // Catch:{ Throwable -> 0x0124 }
            r4.<init>()     // Catch:{ Throwable -> 0x0124 }
            com.appsflyer.internal.C1356am.f3467 = r4     // Catch:{ Throwable -> 0x0124 }
        L_0x00d0:
            com.appsflyer.internal.am r4 = com.appsflyer.internal.C1356am.f3467     // Catch:{ Throwable -> 0x0124 }
            java.lang.String r6 = r2.toString()     // Catch:{ Throwable -> 0x0124 }
            java.lang.String r7 = r11.f3421     // Catch:{ Throwable -> 0x0124 }
            java.lang.String r8 = "server_response"
            r9 = 2
            java.lang.String[] r9 = new java.lang.String[r9]     // Catch:{ Throwable -> 0x0124 }
            java.lang.String r10 = java.lang.String.valueOf(r1)     // Catch:{ Throwable -> 0x0124 }
            r9[r5] = r10     // Catch:{ Throwable -> 0x0124 }
            r9[r0] = r7     // Catch:{ Throwable -> 0x0124 }
            r4.mo10812(r8, r6, r9)     // Catch:{ Throwable -> 0x0124 }
        L_0x00e8:
            r4 = 200(0xc8, float:2.8E-43)
            if (r1 != r4) goto L_0x0121
            java.lang.String r1 = "Status 200 ok"
            com.appsflyer.AFLogger.afInfoLog(r1)     // Catch:{ Throwable -> 0x0124 }
            java.lang.ref.WeakReference<android.content.Context> r1 = r11.f3426     // Catch:{ Throwable -> 0x0124 }
            java.lang.Object r1 = r1.get()     // Catch:{ Throwable -> 0x0124 }
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ Throwable -> 0x0124 }
            java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x0124 }
            java.lang.String r4 = "https://%sregister.%s/api/v4.11/androidevent?buildnumber=5.1.1&app_id="
            java.lang.String r4 = com.appsflyer.ServerConfigHandler.getUrl(r4)     // Catch:{ Throwable -> 0x0124 }
            boolean r2 = r2.startsWith(r4)     // Catch:{ Throwable -> 0x0124 }
            if (r2 == 0) goto L_0x0137
            if (r1 == 0) goto L_0x0137
            android.content.SharedPreferences r1 = com.appsflyer.AppsFlyerLibCore.m3225(r1)     // Catch:{ Throwable -> 0x0124 }
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ Throwable -> 0x0124 }
            java.lang.String r2 = "sentRegisterRequestToAF"
            r1.putBoolean(r2, r0)     // Catch:{ Throwable -> 0x0124 }
            r1.apply()     // Catch:{ Throwable -> 0x0124 }
            java.lang.String r1 = "Successfully registered for Uninstall Tracking"
            com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ Throwable -> 0x0124 }
            goto L_0x0137
        L_0x0121:
            r11.f3420 = r0     // Catch:{ Throwable -> 0x0124 }
            goto L_0x0137
        L_0x0124:
            r2 = move-exception
            goto L_0x0128
        L_0x0126:
            r2 = move-exception
            r3 = r1
        L_0x0128:
            java.lang.String r12 = java.lang.String.valueOf(r12)
            java.lang.String r1 = "Error while calling "
            java.lang.String r12 = r1.concat(r12)
            com.appsflyer.AFLogger.afErrorLog(r12, r2)
            r11.f3420 = r0
        L_0x0137:
            boolean r12 = r11.f3420
            if (r12 == 0) goto L_0x014f
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "Connection error: "
            r12.<init>(r0)
            java.lang.String r0 = r11.f3421
            r12.append(r0)
            java.lang.String r12 = r12.toString()
            com.appsflyer.AFLogger.afInfoLog(r12)
            goto L_0x0162
        L_0x014f:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "Connection call succeeded: "
            r12.<init>(r0)
            java.lang.String r0 = r11.f3421
            r12.append(r0)
            java.lang.String r12 = r12.toString()
            com.appsflyer.AFLogger.afInfoLog(r12)
        L_0x0162:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1339ac.mo10792(java.lang.String):java.net.HttpURLConnection");
    }
}
