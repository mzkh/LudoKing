package com.appsflyer;

public class ServerConfigHandler {
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c9  */
    @androidx.annotation.Nullable
    /* renamed from: ˊ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static org.json.JSONObject m3265(java.lang.String r5) {
        /*
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00b4, Throwable -> 0x008a }
            r1.<init>(r5)     // Catch:{ JSONException -> 0x00b4, Throwable -> 0x008a }
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
            java.lang.String r2 = "disableProxy"
            r3 = 0
            boolean r5 = r5.getBoolean(r2, r3)     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
            java.lang.String r2 = "monitor"
            boolean r2 = r1.optBoolean(r2, r3)     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
            if (r2 == 0) goto L_0x002c
            if (r5 != 0) goto L_0x002c
            com.appsflyer.internal.am r5 = com.appsflyer.internal.C1356am.f3467     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
            if (r5 != 0) goto L_0x0026
            com.appsflyer.internal.am r5 = new com.appsflyer.internal.am     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
            r5.<init>()     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
            com.appsflyer.internal.C1356am.f3467 = r5     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
        L_0x0026:
            com.appsflyer.internal.am r5 = com.appsflyer.internal.C1356am.f3467     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
            r5.mo10817()     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
            goto L_0x004c
        L_0x002c:
            com.appsflyer.internal.am r5 = com.appsflyer.internal.C1356am.f3467     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
            if (r5 != 0) goto L_0x0037
            com.appsflyer.internal.am r5 = new com.appsflyer.internal.am     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
            r5.<init>()     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
            com.appsflyer.internal.C1356am.f3467 = r5     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
        L_0x0037:
            com.appsflyer.internal.am r5 = com.appsflyer.internal.C1356am.f3467     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
            r5.mo10816()     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
            com.appsflyer.internal.am r5 = com.appsflyer.internal.C1356am.f3467     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
            if (r5 != 0) goto L_0x0047
            com.appsflyer.internal.am r5 = new com.appsflyer.internal.am     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
            r5.<init>()     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
            com.appsflyer.internal.C1356am.f3467 = r5     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
        L_0x0047:
            com.appsflyer.internal.am r5 = com.appsflyer.internal.C1356am.f3467     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
            r5.mo10813()     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
        L_0x004c:
            java.lang.String r5 = "ol_id"
            boolean r5 = r1.has(r5)     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
            if (r5 == 0) goto L_0x00d5
            java.lang.String r5 = "ol_scheme"
            java.lang.String r5 = r1.optString(r5, r0)     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
            java.lang.String r2 = "ol_domain"
            java.lang.String r2 = r1.optString(r2, r0)     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
            java.lang.String r3 = "ol_ver"
            java.lang.String r0 = r1.optString(r3, r0)     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
            if (r5 == 0) goto L_0x0071
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
            java.lang.String r4 = "onelinkScheme"
            r3.set(r4, r5)     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
        L_0x0071:
            if (r2 == 0) goto L_0x007c
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
            java.lang.String r3 = "onelinkDomain"
            r5.set(r3, r2)     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
        L_0x007c:
            if (r0 == 0) goto L_0x00d5
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
            java.lang.String r2 = "onelinkVersion"
            r5.set(r2, r0)     // Catch:{ JSONException -> 0x00b5, Throwable -> 0x0088 }
            goto L_0x00d5
        L_0x0088:
            r5 = move-exception
            goto L_0x008c
        L_0x008a:
            r5 = move-exception
            r1 = r0
        L_0x008c:
            java.lang.String r0 = r5.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r0, r5)
            com.appsflyer.internal.am r5 = com.appsflyer.internal.C1356am.f3467
            if (r5 != 0) goto L_0x009e
            com.appsflyer.internal.am r5 = new com.appsflyer.internal.am
            r5.<init>()
            com.appsflyer.internal.C1356am.f3467 = r5
        L_0x009e:
            com.appsflyer.internal.am r5 = com.appsflyer.internal.C1356am.f3467
            r5.mo10816()
            com.appsflyer.internal.am r5 = com.appsflyer.internal.C1356am.f3467
            if (r5 != 0) goto L_0x00ae
            com.appsflyer.internal.am r5 = new com.appsflyer.internal.am
            r5.<init>()
            com.appsflyer.internal.C1356am.f3467 = r5
        L_0x00ae:
            com.appsflyer.internal.am r5 = com.appsflyer.internal.C1356am.f3467
            r5.mo10813()
            goto L_0x00d5
        L_0x00b4:
            r1 = r0
        L_0x00b5:
            com.appsflyer.internal.am r5 = com.appsflyer.internal.C1356am.f3467
            if (r5 != 0) goto L_0x00c0
            com.appsflyer.internal.am r5 = new com.appsflyer.internal.am
            r5.<init>()
            com.appsflyer.internal.C1356am.f3467 = r5
        L_0x00c0:
            com.appsflyer.internal.am r5 = com.appsflyer.internal.C1356am.f3467
            r5.mo10816()
            com.appsflyer.internal.am r5 = com.appsflyer.internal.C1356am.f3467
            if (r5 != 0) goto L_0x00d0
            com.appsflyer.internal.am r5 = new com.appsflyer.internal.am
            r5.<init>()
            com.appsflyer.internal.C1356am.f3467 = r5
        L_0x00d0:
            com.appsflyer.internal.am r5 = com.appsflyer.internal.C1356am.f3467
            r5.mo10813()
        L_0x00d5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.ServerConfigHandler.m3265(java.lang.String):org.json.JSONObject");
    }

    public static String getUrl(String str) {
        return String.format(str, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AppsFlyerLibCore.getInstance().getHostName()});
    }
}
