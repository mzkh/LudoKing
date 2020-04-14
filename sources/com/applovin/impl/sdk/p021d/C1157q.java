package com.applovin.impl.sdk.p021d;

import android.app.Activity;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p018ad.C1082d;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.p021d.C1159r.C1161a;
import com.applovin.impl.sdk.utils.C1243d;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.d.q */
public class C1157q extends C1122a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1192i f2798a;

    public C1157q(C1192i iVar) {
        super("TaskInitializeSdk", iVar);
        this.f2798a = iVar;
    }

    /* renamed from: a */
    private void m2448a(C1096c<Boolean> cVar) {
        if (((Boolean) this.f2798a.mo10202a(cVar)).booleanValue()) {
            this.f2798a.mo10194T().mo9984f(C1082d.m1996a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED, this.f2798a));
        }
    }

    /* renamed from: b */
    private void m2449b() {
        if (!this.f2798a.mo10251x().mo9543a()) {
            Activity ae = this.f2798a.mo10221ae();
            if (ae != null) {
                this.f2798a.mo10251x().mo9540a(ae);
            } else {
                this.f2798a.mo10185K().mo10132a(new C1127ac(this.f2798a, true, new Runnable() {
                    public void run() {
                        C1157q.this.f2798a.mo10251x().mo9540a(C1157q.this.f2798a.mo10217aa().mo9735a());
                    }
                }), C1161a.MAIN, TimeUnit.SECONDS.toMillis(1));
            }
        }
    }

    /* renamed from: c */
    private void m2450c() {
        this.f2798a.mo10185K().mo10131a((C1122a) new C1131b(this.f2798a), C1161a.MAIN);
    }

    /* renamed from: d */
    private void m2451d() {
        this.f2798a.mo10194T().mo9973a();
        this.f2798a.mo10195U().mo10383a();
    }

    /* renamed from: i */
    private void m2452i() {
        m2453j();
        m2454k();
        m2455l();
    }

    /* renamed from: j */
    private void m2453j() {
        LinkedHashSet a = this.f2798a.mo10197W().mo9860a();
        if (!a.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Scheduling preload(s) for ");
            sb.append(a.size());
            sb.append(" zone(s)");
            mo10068a(sb.toString());
            Iterator it = a.iterator();
            while (it.hasNext()) {
                C1082d dVar = (C1082d) it.next();
                if (dVar.mo9850d()) {
                    this.f2798a.mo10242p().preloadAds(dVar);
                } else {
                    this.f2798a.mo10241o().preloadAds(dVar);
                }
            }
        }
    }

    /* renamed from: k */
    private void m2454k() {
        C1096c<Boolean> cVar = C1096c.f2367bc;
        String str = (String) this.f2798a.mo10202a(C1096c.f2366bb);
        boolean z = false;
        if (str.length() > 0) {
            for (String fromString : C1243d.m2924a(str)) {
                AppLovinAdSize fromString2 = AppLovinAdSize.fromString(fromString);
                if (fromString2 != null) {
                    this.f2798a.mo10194T().mo9984f(C1082d.m1996a(fromString2, AppLovinAdType.REGULAR, this.f2798a));
                    if (AppLovinAdSize.INTERSTITIAL.getLabel().equals(fromString2.getLabel())) {
                        m2448a(cVar);
                        z = true;
                    }
                }
            }
        }
        if (!z) {
            m2448a(cVar);
        }
    }

    /* renamed from: l */
    private void m2455l() {
        if (((Boolean) this.f2798a.mo10202a(C1096c.f2368bd)).booleanValue()) {
            this.f2798a.mo10195U().mo9984f(C1082d.m2010h(this.f2798a));
        }
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2692a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x013f, code lost:
        if (r12.f2798a.mo10230d() == false) goto L_0x0142;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0142, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0143, code lost:
        r8.append(r2);
        r8.append(r1);
        r8.append(java.lang.System.currentTimeMillis() - r6);
        r8.append(r0);
        mo10068a(r8.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x015b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x00e8, code lost:
        if (r12.f2798a.mo10230d() != false) goto L_0x0143;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r12 = this;
            java.lang.String r0 = "ms"
            java.lang.String r1 = " in "
            java.lang.String r2 = "succeeded"
            java.lang.String r3 = "failed"
            java.lang.String r4 = " initialization "
            java.lang.String r5 = "AppLovin SDK "
            long r6 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Initializing AppLovin SDK "
            r8.append(r9)
            java.lang.String r9 = com.applovin.sdk.AppLovinSdk.VERSION
            r8.append(r9)
            java.lang.String r9 = "..."
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r12.mo10068a(r8)
            com.applovin.impl.sdk.i r8 = r12.f2798a     // Catch:{ Throwable -> 0x00ed }
            com.applovin.impl.sdk.c.h r8 = r8.mo10186L()     // Catch:{ Throwable -> 0x00ed }
            r8.mo10044d()     // Catch:{ Throwable -> 0x00ed }
            com.applovin.impl.sdk.i r8 = r12.f2798a     // Catch:{ Throwable -> 0x00ed }
            com.applovin.impl.sdk.c.h r8 = r8.mo10186L()     // Catch:{ Throwable -> 0x00ed }
            com.applovin.impl.sdk.c.g r9 = com.applovin.impl.sdk.p020c.C1113g.f2657b     // Catch:{ Throwable -> 0x00ed }
            r8.mo10043c(r9)     // Catch:{ Throwable -> 0x00ed }
            com.applovin.impl.sdk.i r8 = r12.f2798a     // Catch:{ Throwable -> 0x00ed }
            com.applovin.impl.sdk.m r8 = r8.mo10196V()     // Catch:{ Throwable -> 0x00ed }
            android.content.Context r9 = r12.mo10075g()     // Catch:{ Throwable -> 0x00ed }
            r8.mo10276a(r9)     // Catch:{ Throwable -> 0x00ed }
            com.applovin.impl.sdk.i r8 = r12.f2798a     // Catch:{ Throwable -> 0x00ed }
            com.applovin.impl.sdk.m r8 = r8.mo10196V()     // Catch:{ Throwable -> 0x00ed }
            android.content.Context r9 = r12.mo10075g()     // Catch:{ Throwable -> 0x00ed }
            r8.mo10279b(r9)     // Catch:{ Throwable -> 0x00ed }
            r12.m2451d()     // Catch:{ Throwable -> 0x00ed }
            r12.m2452i()     // Catch:{ Throwable -> 0x00ed }
            r12.m2449b()     // Catch:{ Throwable -> 0x00ed }
            com.applovin.impl.sdk.i r8 = r12.f2798a     // Catch:{ Throwable -> 0x00ed }
            com.applovin.impl.sdk.c.c r8 = r8.mo10198X()     // Catch:{ Throwable -> 0x00ed }
            r8.mo9994a()     // Catch:{ Throwable -> 0x00ed }
            r12.m2450c()     // Catch:{ Throwable -> 0x00ed }
            com.applovin.impl.sdk.i r8 = r12.f2798a     // Catch:{ Throwable -> 0x00ed }
            com.applovin.impl.sdk.j r8 = r8.mo10189O()     // Catch:{ Throwable -> 0x00ed }
            r8.mo10263e()     // Catch:{ Throwable -> 0x00ed }
            com.applovin.impl.sdk.i r8 = r12.f2798a     // Catch:{ Throwable -> 0x00ed }
            r9 = 1
            r8.mo10216a(r9)     // Catch:{ Throwable -> 0x00ed }
            com.applovin.impl.sdk.i r8 = r12.f2798a     // Catch:{ Throwable -> 0x00ed }
            com.applovin.impl.sdk.network.e r8 = r8.mo10188N()     // Catch:{ Throwable -> 0x00ed }
            r8.mo10337a()     // Catch:{ Throwable -> 0x00ed }
            com.applovin.impl.sdk.i r8 = r12.f2798a     // Catch:{ Throwable -> 0x00ed }
            com.applovin.sdk.AppLovinEventService r8 = r8.mo10243q()     // Catch:{ Throwable -> 0x00ed }
            com.applovin.impl.sdk.EventServiceImpl r8 = (com.applovin.impl.sdk.EventServiceImpl) r8     // Catch:{ Throwable -> 0x00ed }
            r8.maybeTrackAppOpenEvent()     // Catch:{ Throwable -> 0x00ed }
            com.applovin.impl.sdk.i r8 = r12.f2798a     // Catch:{ Throwable -> 0x00ed }
            com.applovin.impl.mediation.j r8 = r8.mo10177B()     // Catch:{ Throwable -> 0x00ed }
            r8.mo9620a()     // Catch:{ Throwable -> 0x00ed }
            com.applovin.impl.sdk.i r8 = r12.f2798a     // Catch:{ Throwable -> 0x00ed }
            com.applovin.impl.mediation.a.a r8 = r8.mo10253z()     // Catch:{ Throwable -> 0x00ed }
            boolean r8 = r8.mo9305a()     // Catch:{ Throwable -> 0x00ed }
            if (r8 == 0) goto L_0x00af
            com.applovin.impl.sdk.i r8 = r12.f2798a     // Catch:{ Throwable -> 0x00ed }
            com.applovin.impl.mediation.a.a r8 = r8.mo10253z()     // Catch:{ Throwable -> 0x00ed }
            r8.mo9306b()     // Catch:{ Throwable -> 0x00ed }
        L_0x00af:
            com.applovin.impl.sdk.i r8 = r12.f2798a
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r9 = com.applovin.impl.sdk.p019b.C1096c.f2330as
            java.lang.Object r8 = r8.mo10202a(r9)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x00d2
            com.applovin.impl.sdk.i r8 = r12.f2798a
            com.applovin.impl.sdk.b.c<java.lang.Long> r9 = com.applovin.impl.sdk.p019b.C1096c.f2331at
            java.lang.Object r8 = r8.mo10202a(r9)
            java.lang.Long r8 = (java.lang.Long) r8
            long r8 = r8.longValue()
            com.applovin.impl.sdk.i r10 = r12.f2798a
            r10.mo10206a(r8)
        L_0x00d2:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r5)
            java.lang.String r5 = com.applovin.sdk.AppLovinSdk.VERSION
            r8.append(r5)
            r8.append(r4)
            com.applovin.impl.sdk.i r4 = r12.f2798a
            boolean r4 = r4.mo10230d()
            if (r4 == 0) goto L_0x0142
            goto L_0x0143
        L_0x00eb:
            r8 = move-exception
            goto L_0x015c
        L_0x00ed:
            r8 = move-exception
            java.lang.String r9 = "Unable to initialize SDK."
            r12.mo10069a(r9, r8)     // Catch:{ all -> 0x00eb }
            com.applovin.impl.sdk.i r8 = r12.f2798a     // Catch:{ all -> 0x00eb }
            r9 = 0
            r8.mo10216a(r9)     // Catch:{ all -> 0x00eb }
            com.applovin.impl.sdk.i r8 = r12.f2798a     // Catch:{ all -> 0x00eb }
            com.applovin.impl.sdk.c.j r8 = r8.mo10187M()     // Catch:{ all -> 0x00eb }
            com.applovin.impl.sdk.c.i r9 = r12.mo9338a()     // Catch:{ all -> 0x00eb }
            r8.mo10047a(r9)     // Catch:{ all -> 0x00eb }
            com.applovin.impl.sdk.i r8 = r12.f2798a
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r9 = com.applovin.impl.sdk.p019b.C1096c.f2330as
            java.lang.Object r8 = r8.mo10202a(r9)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0129
            com.applovin.impl.sdk.i r8 = r12.f2798a
            com.applovin.impl.sdk.b.c<java.lang.Long> r9 = com.applovin.impl.sdk.p019b.C1096c.f2331at
            java.lang.Object r8 = r8.mo10202a(r9)
            java.lang.Long r8 = (java.lang.Long) r8
            long r8 = r8.longValue()
            com.applovin.impl.sdk.i r10 = r12.f2798a
            r10.mo10206a(r8)
        L_0x0129:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r5)
            java.lang.String r5 = com.applovin.sdk.AppLovinSdk.VERSION
            r8.append(r5)
            r8.append(r4)
            com.applovin.impl.sdk.i r4 = r12.f2798a
            boolean r4 = r4.mo10230d()
            if (r4 == 0) goto L_0x0142
            goto L_0x0143
        L_0x0142:
            r2 = r3
        L_0x0143:
            r8.append(r2)
            r8.append(r1)
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r6
            r8.append(r1)
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            r12.mo10068a(r0)
            return
        L_0x015c:
            com.applovin.impl.sdk.i r9 = r12.f2798a
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r10 = com.applovin.impl.sdk.p019b.C1096c.f2330as
            java.lang.Object r9 = r9.mo10202a(r10)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x017f
            com.applovin.impl.sdk.i r9 = r12.f2798a
            com.applovin.impl.sdk.b.c<java.lang.Long> r10 = com.applovin.impl.sdk.p019b.C1096c.f2331at
            java.lang.Object r9 = r9.mo10202a(r10)
            java.lang.Long r9 = (java.lang.Long) r9
            long r9 = r9.longValue()
            com.applovin.impl.sdk.i r11 = r12.f2798a
            r11.mo10206a(r9)
        L_0x017f:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r5)
            java.lang.String r5 = com.applovin.sdk.AppLovinSdk.VERSION
            r9.append(r5)
            r9.append(r4)
            com.applovin.impl.sdk.i r4 = r12.f2798a
            boolean r4 = r4.mo10230d()
            if (r4 == 0) goto L_0x0198
            goto L_0x0199
        L_0x0198:
            r2 = r3
        L_0x0199:
            r9.append(r2)
            r9.append(r1)
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r6
            r9.append(r1)
            r9.append(r0)
            java.lang.String r0 = r9.toString()
            r12.mo10068a(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.p021d.C1157q.run():void");
    }
}
