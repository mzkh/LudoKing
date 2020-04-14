package com.applovin.impl.sdk;

import com.applovin.impl.sdk.p018ad.C1082d;
import com.applovin.impl.sdk.p018ad.C1087g;
import com.applovin.impl.sdk.p018ad.C1090j;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p021d.C1122a;
import com.applovin.impl.sdk.p021d.C1159r.C1161a;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.q */
abstract class C1230q implements C1205l, AppLovinNativeAdLoadListener {

    /* renamed from: a */
    protected final C1192i f3108a;

    /* renamed from: b */
    protected final C1227o f3109b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Object f3110c = new Object();

    /* renamed from: d */
    private final Map<C1082d, C1232r> f3111d = new HashMap();

    /* renamed from: e */
    private final Map<C1082d, C1232r> f3112e = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Map<C1082d, Object> f3113f = new HashMap();

    /* renamed from: g */
    private final Set<C1082d> f3114g = new HashSet();

    C1230q(C1192i iVar) {
        this.f3108a = iVar;
        this.f3109b = iVar.mo10249v();
    }

    /* renamed from: b */
    private void m2871b(final C1082d dVar, Object obj) {
        synchronized (this.f3110c) {
            if (this.f3113f.containsKey(dVar)) {
                this.f3109b.mo10381d("PreloadManager", "Possibly missing prior registered preload callback.");
            }
            this.f3113f.put(dVar, obj);
        }
        final int intValue = ((Integer) this.f3108a.mo10202a(C1096c.f2311aZ)).intValue();
        if (intValue > 0) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    synchronized (C1230q.this.f3110c) {
                        Object obj = C1230q.this.f3113f.get(dVar);
                        if (obj != null) {
                            C1230q.this.f3113f.remove(dVar);
                            StringBuilder sb = new StringBuilder();
                            sb.append("Load callback for zone ");
                            sb.append(dVar);
                            sb.append(" timed out after ");
                            sb.append(intValue);
                            sb.append(" seconds");
                            C1230q.this.f3109b.mo10382e("PreloadManager", sb.toString());
                            C1230q.this.mo9975a(obj, dVar, AppLovinErrorCodes.FETCH_AD_TIMEOUT);
                        }
                    }
                }
            }, TimeUnit.SECONDS.toMillis((long) intValue));
        }
    }

    /* renamed from: c */
    private void m2872c(C1090j jVar) {
        mo9987i(mo9971a(jVar));
    }

    /* renamed from: j */
    private C1232r m2873j(C1082d dVar) {
        return (C1232r) this.f3111d.get(dVar);
    }

    /* renamed from: k */
    private C1232r m2874k(C1082d dVar) {
        return (C1232r) this.f3112e.get(dVar);
    }

    /* renamed from: l */
    private boolean m2875l(C1082d dVar) {
        boolean z;
        synchronized (this.f3110c) {
            C1232r j = m2873j(dVar);
            z = j != null && j.mo10391c();
        }
        return z;
    }

    /* renamed from: m */
    private C1232r m2876m(C1082d dVar) {
        synchronized (this.f3110c) {
            C1232r k = m2874k(dVar);
            if (k != null && k.mo10387a() > 0) {
                return k;
            }
            C1232r j = m2873j(dVar);
            return j;
        }
    }

    /* renamed from: n */
    private boolean m2877n(C1082d dVar) {
        boolean contains;
        synchronized (this.f3110c) {
            contains = this.f3114g.contains(dVar);
        }
        return contains;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract C1082d mo9971a(C1090j jVar);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract C1122a mo9972a(C1082d dVar);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo9975a(Object obj, C1082d dVar, int i);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo9976a(Object obj, C1090j jVar);

    /* renamed from: a */
    public void mo9977a(LinkedHashSet<C1082d> linkedHashSet) {
        Map<C1082d, Object> map = this.f3113f;
        if (map != null && !map.isEmpty()) {
            synchronized (this.f3110c) {
                Iterator it = this.f3113f.keySet().iterator();
                while (it.hasNext()) {
                    C1082d dVar = (C1082d) it.next();
                    if (!dVar.mo9858j() && !linkedHashSet.contains(dVar)) {
                        Object obj = this.f3113f.get(dVar);
                        it.remove();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed to load ad for zone (");
                        sb.append(dVar.mo9846a());
                        sb.append("). Please check that the zone has been added to your AppLovin account and given at least 30 minutes to fully propagate.");
                        C1227o.m2841i("AppLovinAdService", sb.toString());
                        mo9975a(obj, dVar, -7);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo9978a(C1082d dVar, Object obj) {
        boolean z;
        synchronized (this.f3110c) {
            if (!m2877n(dVar)) {
                m2871b(dVar, obj);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: b */
    public void mo9979b(C1082d dVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            mo9987i(dVar);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo10384b(C1090j jVar) {
        Object obj;
        C1227o oVar;
        String str;
        String sb;
        C1082d a = mo9971a(jVar);
        boolean i = a.mo9857i();
        synchronized (this.f3110c) {
            obj = this.f3113f.get(a);
            this.f3113f.remove(a);
            this.f3114g.add(a);
            if (obj != null) {
                if (!i) {
                    oVar = this.f3109b;
                    str = "PreloadManager";
                    sb = "Additional callback found or dummy ads are enabled; skipping enqueue...";
                    oVar.mo10378b(str, sb);
                }
            }
            m2873j(a).mo10389a(jVar);
            oVar = this.f3109b;
            str = "PreloadManager";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Ad enqueued: ");
            sb2.append(jVar);
            sb = sb2.toString();
            oVar.mo10378b(str, sb);
        }
        if (obj != null) {
            C1227o oVar2 = this.f3109b;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Called additional callback regarding ");
            sb3.append(jVar);
            oVar2.mo10378b("PreloadManager", sb3.toString());
            if (i) {
                try {
                    mo9976a(obj, (C1090j) new C1087g(a, this.f3108a));
                } catch (Throwable th) {
                    C1227o.m2837c("PreloadManager", "Encountered throwable while notifying user callback", th);
                }
            } else {
                mo9976a(obj, jVar);
                m2872c(jVar);
            }
        }
        C1227o oVar3 = this.f3109b;
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Pulled ad from network and saved to preload cache: ");
        sb4.append(jVar);
        oVar3.mo10378b("PreloadManager", sb4.toString());
    }

    /* renamed from: b */
    public boolean mo9980b(C1082d dVar) {
        return this.f3113f.containsKey(dVar);
    }

    /* renamed from: c */
    public C1090j mo9981c(C1082d dVar) {
        C1090j f;
        synchronized (this.f3110c) {
            C1232r m = m2876m(dVar);
            f = m != null ? m.mo10394f() : null;
        }
        return f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo10385c(C1082d dVar, int i) {
        Object remove;
        C1227o oVar = this.f3109b;
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to pre-load an ad of zone ");
        sb.append(dVar);
        sb.append(", error code ");
        sb.append(i);
        oVar.mo10378b("PreloadManager", sb.toString());
        synchronized (this.f3110c) {
            remove = this.f3113f.remove(dVar);
            this.f3114g.add(dVar);
        }
        if (remove != null) {
            try {
                mo9975a(remove, dVar, i);
            } catch (Throwable th) {
                C1227o.m2837c("PreloadManager", "Encountered exception while invoking user callback", th);
            }
        }
    }

    /* renamed from: d */
    public C1090j mo9982d(C1082d dVar) {
        C1090j e;
        synchronized (this.f3110c) {
            C1232r m = m2876m(dVar);
            e = m != null ? m.mo10393e() : null;
        }
        return e;
    }

    /* renamed from: e */
    public C1090j mo9983e(C1082d dVar) {
        C1090j jVar;
        String str;
        StringBuilder sb;
        C1227o oVar;
        C1090j gVar;
        synchronized (this.f3110c) {
            C1232r j = m2873j(dVar);
            jVar = null;
            if (j != null) {
                if (dVar.mo9857i()) {
                    C1232r k = m2874k(dVar);
                    if (k.mo10391c()) {
                        gVar = new C1087g(dVar, this.f3108a);
                    } else if (j.mo10387a() > 0) {
                        k.mo10389a(j.mo10393e());
                        gVar = new C1087g(dVar, this.f3108a);
                    } else if (k.mo10387a() > 0 && ((Boolean) this.f3108a.mo10202a(C1096c.f2418cb)).booleanValue()) {
                        gVar = new C1087g(dVar, this.f3108a);
                    }
                    jVar = gVar;
                } else {
                    jVar = j.mo10393e();
                }
            }
        }
        if (jVar != null) {
            oVar = this.f3109b;
            sb = new StringBuilder();
            str = "Retrieved ad of zone ";
        } else {
            oVar = this.f3109b;
            sb = new StringBuilder();
            str = "Unable to retrieve ad of zone ";
        }
        sb.append(str);
        sb.append(dVar);
        sb.append("...");
        oVar.mo10378b("PreloadManager", sb.toString());
        return jVar;
    }

    /* renamed from: f */
    public void mo9984f(C1082d dVar) {
        if (dVar != null) {
            int i = 0;
            synchronized (this.f3110c) {
                C1232r j = m2873j(dVar);
                if (j != null) {
                    i = j.mo10390b() - j.mo10387a();
                }
            }
            mo9979b(dVar, i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        return r3;
     */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo9985g(com.applovin.impl.sdk.p018ad.C1082d r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f3110c
            monitor-enter(r0)
            com.applovin.impl.sdk.r r1 = r4.m2874k(r5)     // Catch:{ all -> 0x0032 }
            com.applovin.impl.sdk.i r2 = r4.f3108a     // Catch:{ all -> 0x0032 }
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r3 = com.applovin.impl.sdk.p019b.C1096c.f2419cc     // Catch:{ all -> 0x0032 }
            java.lang.Object r2 = r2.mo10202a(r3)     // Catch:{ all -> 0x0032 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x0032 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x0032 }
            r3 = 1
            if (r2 == 0) goto L_0x0022
            if (r1 == 0) goto L_0x0022
            int r1 = r1.mo10387a()     // Catch:{ all -> 0x0032 }
            if (r1 <= 0) goto L_0x0022
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return r3
        L_0x0022:
            com.applovin.impl.sdk.r r5 = r4.m2873j(r5)     // Catch:{ all -> 0x0032 }
            if (r5 == 0) goto L_0x002f
            boolean r5 = r5.mo10392d()     // Catch:{ all -> 0x0032 }
            if (r5 != 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r3 = 0
        L_0x0030:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return r3
        L_0x0032:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1230q.mo9985g(com.applovin.impl.sdk.ad.d):boolean");
    }

    /* renamed from: h */
    public void mo9986h(C1082d dVar) {
        synchronized (this.f3110c) {
            C1232r j = m2873j(dVar);
            if (j != null) {
                j.mo10388a(dVar.mo9851e());
            } else {
                this.f3111d.put(dVar, new C1232r(dVar.mo9851e()));
            }
            C1232r k = m2874k(dVar);
            if (k != null) {
                k.mo10388a(dVar.mo9853f());
            } else {
                this.f3112e.put(dVar, new C1232r(dVar.mo9853f()));
            }
        }
    }

    /* renamed from: i */
    public void mo9987i(C1082d dVar) {
        if (((Boolean) this.f3108a.mo10202a(C1096c.f2365ba)).booleanValue() && !m2875l(dVar)) {
            C1227o oVar = this.f3109b;
            StringBuilder sb = new StringBuilder();
            sb.append("Preloading ad for zone ");
            sb.append(dVar);
            sb.append("...");
            oVar.mo10378b("PreloadManager", sb.toString());
            this.f3108a.mo10185K().mo10132a(mo9972a(dVar), C1161a.MAIN, 500);
        }
    }
}
