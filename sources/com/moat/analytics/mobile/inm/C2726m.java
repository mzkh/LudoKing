package com.moat.analytics.mobile.inm;

import android.util.Log;

/* renamed from: com.moat.analytics.mobile.inm.m */
class C2726m extends Exception {

    /* renamed from: a */
    private static final Long f6113a = Long.valueOf(60000);

    /* renamed from: b */
    private static Long f6114b;

    /* renamed from: c */
    private static Exception f6115c = null;

    C2726m(String str) {
        super(str);
    }

    /* renamed from: a */
    static String m6272a(String str, Exception exc) {
        if (exc instanceof C2726m) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" failed: ");
            sb.append(exc.getMessage());
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" failed unexpectedly");
        return sb2.toString();
    }

    /* renamed from: a */
    static void m6273a() {
        Exception exc = f6115c;
        if (exc != null) {
            m6275b(exc);
            f6115c = null;
        }
    }

    /* renamed from: a */
    static void m6274a(Exception exc) {
        if (C2750w.m6348a().f6156b) {
            Log.e("MoatException", Log.getStackTraceString(exc));
            return;
        }
        m6275b(exc);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(21:7|(4:9|10|11|(1:13))|14|(1:16)(1:17)|18|19|20|21|(1:23)(2:24|25)|26|27|29|30|31|32|33|34|40|41|(1:45)|46) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x00d8 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m6275b(java.lang.Exception r13) {
        /*
            java.lang.String r0 = ""
            com.moat.analytics.mobile.inm.w r1 = com.moat.analytics.mobile.inm.C2750w.m6348a()     // Catch:{ Exception -> 0x017e }
            com.moat.analytics.mobile.inm.w$d r1 = r1.f6155a     // Catch:{ Exception -> 0x017e }
            com.moat.analytics.mobile.inm.w$d r2 = com.moat.analytics.mobile.inm.C2750w.C2758d.ON     // Catch:{ Exception -> 0x017e }
            if (r1 != r2) goto L_0x017c
            com.moat.analytics.mobile.inm.w r1 = com.moat.analytics.mobile.inm.C2750w.m6348a()     // Catch:{ Exception -> 0x017e }
            int r1 = r1.f6159e     // Catch:{ Exception -> 0x017e }
            if (r1 != 0) goto L_0x0015
            return
        L_0x0015:
            r2 = 100
            if (r1 >= r2) goto L_0x0029
            double r2 = (double) r1
            r4 = 4636737291354636288(0x4059000000000000, double:100.0)
            java.lang.Double.isNaN(r2)
            double r2 = r2 / r4
            double r4 = java.lang.Math.random()     // Catch:{ Exception -> 0x017e }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0029
            return
        L_0x0029:
            java.lang.String r2 = "https://px.moatads.com/pixel.gif?e=0&i=MOATSDK1&ac=1"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017e }
            r3.<init>(r2)     // Catch:{ Exception -> 0x017e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017e }
            java.lang.String r4 = "&zt="
            r2.<init>(r4)     // Catch:{ Exception -> 0x017e }
            boolean r4 = r13 instanceof com.moat.analytics.mobile.inm.C2726m     // Catch:{ Exception -> 0x017e }
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x003f
            r4 = 1
            goto L_0x0040
        L_0x003f:
            r4 = 0
        L_0x0040:
            r2.append(r4)     // Catch:{ Exception -> 0x017e }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x017e }
            r3.append(r2)     // Catch:{ Exception -> 0x017e }
            java.lang.String r2 = "&zr="
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x017e }
            java.lang.String r1 = r2.concat(r1)     // Catch:{ Exception -> 0x017e }
            r3.append(r1)     // Catch:{ Exception -> 0x017e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r2 = "&zm="
            r1.<init>(r2)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r2 = r13.getMessage()     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r4 = "UTF-8"
            if (r2 != 0) goto L_0x0069
            java.lang.String r2 = "null"
            goto L_0x0079
        L_0x0069:
            java.lang.String r2 = r13.getMessage()     // Catch:{ Exception -> 0x00a4 }
            byte[] r2 = r2.getBytes(r4)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r2 = android.util.Base64.encodeToString(r2, r6)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r2 = java.net.URLEncoder.encode(r2, r4)     // Catch:{ Exception -> 0x00a4 }
        L_0x0079:
            r1.append(r2)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00a4 }
            r3.append(r1)     // Catch:{ Exception -> 0x00a4 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r2 = "&k="
            r1.<init>(r2)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r13 = android.util.Log.getStackTraceString(r13)     // Catch:{ Exception -> 0x00a4 }
            byte[] r13 = r13.getBytes(r4)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r13 = android.util.Base64.encodeToString(r13, r6)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r13 = java.net.URLEncoder.encode(r13, r4)     // Catch:{ Exception -> 0x00a4 }
            r1.append(r13)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r13 = r1.toString()     // Catch:{ Exception -> 0x00a4 }
            r3.append(r13)     // Catch:{ Exception -> 0x00a4 }
        L_0x00a4:
            java.lang.String r13 = "INM"
            java.lang.String r1 = "&zMoatMMAKv=c334ae83accfebb8da23104450c896463c9cfab7"
            r3.append(r1)     // Catch:{ Exception -> 0x00d3 }
            java.lang.String r1 = "2.5.0"
            com.moat.analytics.mobile.inm.s$a r2 = com.moat.analytics.mobile.inm.C2738s.m6324d()     // Catch:{ Exception -> 0x00d1 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r7 = "&zMoatMMAKan="
            r4.<init>(r7)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r7 = r2.mo29084a()     // Catch:{ Exception -> 0x00d1 }
            r4.append(r7)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00d1 }
            r3.append(r4)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r2 = r2.mo29085b()     // Catch:{ Exception -> 0x00d1 }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r0 = java.lang.Integer.toString(r4)     // Catch:{ Exception -> 0x00d8 }
            goto L_0x00d8
        L_0x00d1:
            r2 = r0
            goto L_0x00d8
        L_0x00d3:
            r1 = r0
            goto L_0x00d7
        L_0x00d5:
            r13 = r0
            r1 = r13
        L_0x00d7:
            r2 = r1
        L_0x00d8:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017e }
            java.lang.String r7 = "&d=Android:"
            r4.<init>(r7)     // Catch:{ Exception -> 0x017e }
            r4.append(r13)     // Catch:{ Exception -> 0x017e }
            java.lang.String r13 = ":"
            r4.append(r13)     // Catch:{ Exception -> 0x017e }
            r4.append(r2)     // Catch:{ Exception -> 0x017e }
            java.lang.String r13 = ":-"
            r4.append(r13)     // Catch:{ Exception -> 0x017e }
            java.lang.String r13 = r4.toString()     // Catch:{ Exception -> 0x017e }
            r3.append(r13)     // Catch:{ Exception -> 0x017e }
            java.lang.String r13 = "&bo="
            java.lang.String r13 = r13.concat(r1)     // Catch:{ Exception -> 0x017e }
            r3.append(r13)     // Catch:{ Exception -> 0x017e }
            java.lang.String r13 = "&bd="
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x017e }
            java.lang.String r13 = r13.concat(r0)     // Catch:{ Exception -> 0x017e }
            r3.append(r13)     // Catch:{ Exception -> 0x017e }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x017e }
            java.lang.Long r13 = java.lang.Long.valueOf(r0)     // Catch:{ Exception -> 0x017e }
            java.lang.String r0 = "&t="
            java.lang.String r1 = java.lang.String.valueOf(r13)     // Catch:{ Exception -> 0x017e }
            java.lang.String r0 = r0.concat(r1)     // Catch:{ Exception -> 0x017e }
            r3.append(r0)     // Catch:{ Exception -> 0x017e }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017e }
            java.lang.String r1 = "&de="
            r0.<init>(r1)     // Catch:{ Exception -> 0x017e }
            java.util.Locale r1 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x017e }
            java.lang.String r2 = "%.0f"
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x017e }
            double r7 = java.lang.Math.random()     // Catch:{ Exception -> 0x017e }
            r9 = 4621819117588971520(0x4024000000000000, double:10.0)
            r11 = 4622945017495814144(0x4028000000000000, double:12.0)
            double r9 = java.lang.Math.pow(r9, r11)     // Catch:{ Exception -> 0x017e }
            double r7 = r7 * r9
            double r7 = java.lang.Math.floor(r7)     // Catch:{ Exception -> 0x017e }
            java.lang.Double r5 = java.lang.Double.valueOf(r7)     // Catch:{ Exception -> 0x017e }
            r4[r6] = r5     // Catch:{ Exception -> 0x017e }
            java.lang.String r1 = java.lang.String.format(r1, r2, r4)     // Catch:{ Exception -> 0x017e }
            r0.append(r1)     // Catch:{ Exception -> 0x017e }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x017e }
            r3.append(r0)     // Catch:{ Exception -> 0x017e }
            java.lang.String r0 = "&cs=0"
            r3.append(r0)     // Catch:{ Exception -> 0x017e }
            java.lang.Long r0 = f6114b     // Catch:{ Exception -> 0x017e }
            if (r0 == 0) goto L_0x0172
            long r0 = r13.longValue()     // Catch:{ Exception -> 0x017e }
            java.lang.Long r2 = f6114b     // Catch:{ Exception -> 0x017e }
            long r4 = r2.longValue()     // Catch:{ Exception -> 0x017e }
            long r0 = r0 - r4
            java.lang.Long r2 = f6113a     // Catch:{ Exception -> 0x017e }
            long r4 = r2.longValue()     // Catch:{ Exception -> 0x017e }
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x017b
        L_0x0172:
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x017e }
            com.moat.analytics.mobile.inm.C2736q.m6317b(r0)     // Catch:{ Exception -> 0x017e }
            f6114b = r13     // Catch:{ Exception -> 0x017e }
        L_0x017b:
            return
        L_0x017c:
            f6115c = r13     // Catch:{ Exception -> 0x017e }
        L_0x017e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moat.analytics.mobile.inm.C2726m.m6275b(java.lang.Exception):void");
    }
}
