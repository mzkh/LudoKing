package com.tapjoy.internal;

import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tapjoy.internal.C3026ev.C3027a;
import com.tapjoy.internal.C3032ex.C3033a;
import com.tapjoy.internal.C3050fd.C3051a;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.gy */
public final class C1830gy {

    /* renamed from: a */
    final C1835hc f3808a;

    /* renamed from: b */
    final C3125gx f3809b;

    /* renamed from: c */
    long f3810c;

    /* renamed from: d */
    private int f3811d = 1;

    /* renamed from: e */
    private final C3033a f3812e = new C3033a();

    C1830gy(C1835hc hcVar, C3125gx gxVar) {
        this.f3808a = hcVar;
        this.f3809b = gxVar;
    }

    /* renamed from: a */
    public final void mo18115a(String str, String str2, double d, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        double d2;
        C1835hc hcVar = this.f3808a;
        synchronized (hcVar) {
            Editor a = hcVar.f3843c.mo30217a();
            int i = 1;
            if (str2.equals(hcVar.f3843c.f7439l.mo30368a())) {
                i = 1 + hcVar.f3843c.f7440m.mo30349b();
                hcVar.f3843c.f7440m.mo30345a(a, i);
                d2 = hcVar.f3843c.f7441n.mo30231a() + d;
                hcVar.f3843c.f7441n.mo30233a(a, d2);
                a.apply();
            } else {
                hcVar.f3843c.f7439l.mo30367a(a, str2);
                hcVar.f3843c.f7440m.mo30345a(a, 1);
                hcVar.f3843c.f7441n.mo30233a(a, d);
                hcVar.f3843c.f7442o.mo30363a(a);
                hcVar.f3843c.f7443p.mo30232a(a);
                a.apply();
                hcVar.f3842b.f7215l = str2;
                hcVar.f3842b.f7218o = null;
                hcVar.f3842b.f7219p = null;
                d2 = d;
            }
            hcVar.f3842b.f7216m = Integer.valueOf(i);
            hcVar.f3842b.f7217n = Double.valueOf(d2);
        }
        C3027a a2 = mo18113a(C3035ey.APP, "purchase");
        C3051a aVar = new C3051a();
        aVar.f7133c = str;
        if (str2 != null) {
            aVar.f7136f = str2;
        }
        aVar.f7135e = Double.valueOf(d);
        if (str5 != null) {
            aVar.f7143m = str5;
        }
        if (str3 != null) {
            aVar.f7145o = str3;
        }
        if (str4 != null) {
            aVar.f7146p = str4;
        }
        a2.f7023p = aVar.mo30106b();
        mo18114a(a2);
        C1835hc hcVar2 = this.f3808a;
        long longValue = a2.f7012e.longValue();
        synchronized (hcVar2) {
            Editor a3 = hcVar2.f3843c.mo30217a();
            hcVar2.f3843c.f7442o.mo30364a(a3, longValue);
            hcVar2.f3843c.f7443p.mo30233a(a3, d);
            a3.apply();
            hcVar2.f3842b.f7218o = Long.valueOf(longValue);
            hcVar2.f3842b.f7219p = Double.valueOf(d);
        }
    }

    /* renamed from: a */
    public final void mo18117a(String str, String str2, String str3, String str4, Map map) {
        C3027a a = mo18113a(C3035ey.CUSTOM, str2);
        a.f7027t = str;
        a.f7028u = str3;
        a.f7029v = str4;
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                a.f7030w.add(new C3037ez((String) entry.getKey(), (Long) entry.getValue()));
            }
        }
        mo18114a(a);
    }

    /* renamed from: a */
    public final void mo18116a(String str, String str2, int i, long j, long j2, Map map) {
        C3027a a = mo18113a(C3035ey.USAGES, str);
        a.f7031x = str2;
        a.f7032y = Integer.valueOf(i);
        a.f7033z = Long.valueOf(j);
        a.f7009A = Long.valueOf(j2);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                a.f7030w.add(new C3037ez((String) entry.getKey(), (Long) entry.getValue()));
            }
        }
        mo18114a(a);
    }

    /* renamed from: a */
    public final C3027a mo18113a(C3035ey eyVar, String str) {
        C3044fb b = this.f3808a.mo18163b();
        C3027a aVar = new C3027a();
        aVar.f7014g = C1835hc.f3840a;
        aVar.f7010c = eyVar;
        aVar.f7011d = str;
        if (C3256v.m7570c()) {
            aVar.f7012e = Long.valueOf(C3256v.m7569b());
            aVar.f7013f = Long.valueOf(System.currentTimeMillis());
        } else {
            aVar.f7012e = Long.valueOf(System.currentTimeMillis());
            aVar.f7015h = Long.valueOf(SystemClock.elapsedRealtime());
        }
        aVar.f7017j = b.f7101d;
        aVar.f7018k = b.f7102e;
        aVar.f7019l = b.f7103f;
        return aVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:12|13|15|16|17|18|19|20) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006a A[SYNTHETIC, Splitter:B:37:0x006a] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo18114a(com.tapjoy.internal.C3026ev.C3027a r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.tapjoy.internal.ey r0 = r5.f7010c     // Catch:{ all -> 0x0075 }
            com.tapjoy.internal.ey r1 = com.tapjoy.internal.C3035ey.USAGES     // Catch:{ all -> 0x0075 }
            if (r0 == r1) goto L_0x0033
            int r0 = r4.f3811d     // Catch:{ all -> 0x0075 }
            int r1 = r0 + 1
            r4.f3811d = r1     // Catch:{ all -> 0x0075 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0075 }
            r5.f7021n = r0     // Catch:{ all -> 0x0075 }
            com.tapjoy.internal.ex$a r0 = r4.f3812e     // Catch:{ all -> 0x0075 }
            com.tapjoy.internal.ey r0 = r0.f7042c     // Catch:{ all -> 0x0075 }
            if (r0 == 0) goto L_0x0021
            com.tapjoy.internal.ex$a r0 = r4.f3812e     // Catch:{ all -> 0x0075 }
            com.tapjoy.internal.ex r0 = r0.mo30091b()     // Catch:{ all -> 0x0075 }
            r5.f7022o = r0     // Catch:{ all -> 0x0075 }
        L_0x0021:
            com.tapjoy.internal.ex$a r0 = r4.f3812e     // Catch:{ all -> 0x0075 }
            com.tapjoy.internal.ey r1 = r5.f7010c     // Catch:{ all -> 0x0075 }
            r0.f7042c = r1     // Catch:{ all -> 0x0075 }
            com.tapjoy.internal.ex$a r0 = r4.f3812e     // Catch:{ all -> 0x0075 }
            java.lang.String r1 = r5.f7011d     // Catch:{ all -> 0x0075 }
            r0.f7043d = r1     // Catch:{ all -> 0x0075 }
            com.tapjoy.internal.ex$a r0 = r4.f3812e     // Catch:{ all -> 0x0075 }
            java.lang.String r1 = r5.f7027t     // Catch:{ all -> 0x0075 }
            r0.f7044e = r1     // Catch:{ all -> 0x0075 }
        L_0x0033:
            com.tapjoy.internal.gx r0 = r4.f3809b     // Catch:{ all -> 0x0075 }
            com.tapjoy.internal.ev r5 = r5.mo30085b()     // Catch:{ all -> 0x0075 }
            com.tapjoy.internal.hl r1 = r0.f7371a     // Catch:{ Exception -> 0x0073 }
            java.lang.Object r2 = r1.f3853a     // Catch:{ Exception -> 0x0073 }
            monitor-enter(r2)     // Catch:{ Exception -> 0x0073 }
            com.tapjoy.internal.ax r3 = r1.f3854b     // Catch:{ Exception -> 0x0046 }
            r3.add(r5)     // Catch:{ Exception -> 0x0046 }
            goto L_0x004e
        L_0x0044:
            r5 = move-exception
            goto L_0x0071
        L_0x0046:
            r1.mo18176a()     // Catch:{ all -> 0x0044 }
            com.tapjoy.internal.ax r1 = r1.f3854b     // Catch:{ Exception -> 0x004e }
            r1.add(r5)     // Catch:{ Exception -> 0x004e }
        L_0x004e:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            com.tapjoy.internal.cd r1 = r0.f7372b     // Catch:{ all -> 0x0075 }
            if (r1 == 0) goto L_0x006a
            boolean r1 = com.tapjoy.internal.C3124gw.f7370a     // Catch:{ all -> 0x0075 }
            if (r1 != 0) goto L_0x0064
            com.tapjoy.internal.ey r5 = r5.f6996n     // Catch:{ all -> 0x0075 }
            com.tapjoy.internal.ey r1 = com.tapjoy.internal.C3035ey.CUSTOM     // Catch:{ all -> 0x0075 }
            if (r5 == r1) goto L_0x005e
            goto L_0x0064
        L_0x005e:
            r5 = 0
            r0.mo30200a(r5)     // Catch:{ all -> 0x0075 }
            monitor-exit(r4)
            return
        L_0x0064:
            r5 = 1
            r0.mo30200a(r5)     // Catch:{ all -> 0x0075 }
            monitor-exit(r4)
            return
        L_0x006a:
            com.tapjoy.internal.hl r5 = r0.f7371a     // Catch:{ all -> 0x0075 }
            r5.flush()     // Catch:{ all -> 0x0075 }
            monitor-exit(r4)
            return
        L_0x0071:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            throw r5     // Catch:{ Exception -> 0x0073 }
        L_0x0073:
            monitor-exit(r4)
            return
        L_0x0075:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C1830gy.mo18114a(com.tapjoy.internal.ev$a):void");
    }
}
