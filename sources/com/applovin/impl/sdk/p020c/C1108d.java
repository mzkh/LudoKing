package com.applovin.impl.sdk.p020c;

import android.annotation.TargetApi;
import android.app.Activity;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p020c.C1103c.C1106b;
import com.applovin.impl.sdk.utils.C1245f;
import com.applovin.impl.sdk.utils.C1246g;

/* renamed from: com.applovin.impl.sdk.c.d */
public class C1108d {

    /* renamed from: a */
    private final C1192i f2633a;

    /* renamed from: b */
    private final C1114h f2634b;

    /* renamed from: c */
    private final C1106b f2635c;

    /* renamed from: d */
    private final Object f2636d = new Object();

    /* renamed from: e */
    private final long f2637e;

    /* renamed from: f */
    private long f2638f;

    /* renamed from: g */
    private long f2639g;

    /* renamed from: h */
    private long f2640h;

    /* renamed from: i */
    private long f2641i;

    /* renamed from: j */
    private boolean f2642j;

    public C1108d(AppLovinAdBase appLovinAdBase, C1192i iVar) {
        if (appLovinAdBase == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (iVar != null) {
            this.f2633a = iVar;
            this.f2634b = iVar.mo10186L();
            this.f2635c = iVar.mo10198X().mo9993a(appLovinAdBase);
            this.f2635c.mo10001a(C1102b.f2594a, (long) appLovinAdBase.getSource().ordinal()).mo10003a();
            this.f2637e = appLovinAdBase.getCreatedAtMillis();
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* renamed from: a */
    public static void m2211a(long j, AppLovinAdBase appLovinAdBase, C1192i iVar) {
        if (appLovinAdBase != null && iVar != null) {
            iVar.mo10198X().mo9993a(appLovinAdBase).mo10001a(C1102b.f2595b, j).mo10003a();
        }
    }

    /* renamed from: a */
    public static void m2212a(AppLovinAdBase appLovinAdBase, C1192i iVar) {
        if (appLovinAdBase != null && iVar != null) {
            iVar.mo10198X().mo9993a(appLovinAdBase).mo10001a(C1102b.f2596c, appLovinAdBase.getFetchLatencyMillis()).mo10001a(C1102b.f2597d, appLovinAdBase.getFetchResponseSize()).mo10003a();
        }
    }

    /* renamed from: a */
    private void m2213a(C1102b bVar) {
        synchronized (this.f2636d) {
            if (this.f2638f > 0) {
                this.f2635c.mo10001a(bVar, System.currentTimeMillis() - this.f2638f).mo10003a();
            }
        }
    }

    /* renamed from: a */
    public static void m2214a(C1109e eVar, AppLovinAdBase appLovinAdBase, C1192i iVar) {
        if (appLovinAdBase != null && iVar != null && eVar != null) {
            iVar.mo10198X().mo9993a(appLovinAdBase).mo10001a(C1102b.f2598e, eVar.mo10023c()).mo10001a(C1102b.f2599f, eVar.mo10024d()).mo10001a(C1102b.f2615v, eVar.mo10027g()).mo10001a(C1102b.f2616w, eVar.mo10028h()).mo10001a(C1102b.f2619z, eVar.mo10022b() ? 1 : 0).mo10003a();
        }
    }

    @TargetApi(24)
    /* renamed from: a */
    public void mo10005a() {
        this.f2635c.mo10001a(C1102b.f2603j, this.f2634b.mo10036a(C1113g.f2657b)).mo10001a(C1102b.f2602i, this.f2634b.mo10036a(C1113g.f2659d));
        synchronized (this.f2636d) {
            long j = 0;
            if (this.f2637e > 0) {
                this.f2638f = System.currentTimeMillis();
                long G = this.f2638f - this.f2633a.mo10181G();
                long j2 = this.f2638f - this.f2637e;
                long j3 = C1246g.m2947a(this.f2633a.mo10179D()) ? 1 : 0;
                Activity a = this.f2633a.mo10217aa().mo9735a();
                if (C1245f.m2937h() && a != null && a.isInMultiWindowMode()) {
                    j = 1;
                }
                this.f2635c.mo10001a(C1102b.f2601h, G).mo10001a(C1102b.f2600g, j2).mo10001a(C1102b.f2609p, j3).mo10001a(C1102b.f2587A, j);
            }
        }
        this.f2635c.mo10003a();
    }

    /* renamed from: a */
    public void mo10006a(long j) {
        this.f2635c.mo10001a(C1102b.f2611r, j).mo10003a();
    }

    /* renamed from: b */
    public void mo10007b() {
        synchronized (this.f2636d) {
            if (this.f2639g < 1) {
                this.f2639g = System.currentTimeMillis();
                if (this.f2638f > 0) {
                    this.f2635c.mo10001a(C1102b.f2606m, this.f2639g - this.f2638f).mo10003a();
                }
            }
        }
    }

    /* renamed from: b */
    public void mo10008b(long j) {
        this.f2635c.mo10001a(C1102b.f2610q, j).mo10003a();
    }

    /* renamed from: c */
    public void mo10009c() {
        m2213a(C1102b.f2604k);
    }

    /* renamed from: c */
    public void mo10010c(long j) {
        this.f2635c.mo10001a(C1102b.f2612s, j).mo10003a();
    }

    /* renamed from: d */
    public void mo10011d() {
        m2213a(C1102b.f2607n);
    }

    /* renamed from: d */
    public void mo10012d(long j) {
        synchronized (this.f2636d) {
            if (this.f2640h < 1) {
                this.f2640h = j;
                this.f2635c.mo10001a(C1102b.f2613t, j).mo10003a();
            }
        }
    }

    /* renamed from: e */
    public void mo10013e() {
        m2213a(C1102b.f2608o);
    }

    /* renamed from: e */
    public void mo10014e(long j) {
        synchronized (this.f2636d) {
            if (!this.f2642j) {
                this.f2642j = true;
                this.f2635c.mo10001a(C1102b.f2617x, j).mo10003a();
            }
        }
    }

    /* renamed from: f */
    public void mo10015f() {
        m2213a(C1102b.f2605l);
    }

    /* renamed from: g */
    public void mo10016g() {
        this.f2635c.mo10001a(C1102b.f2614u, 1).mo10003a();
    }

    /* renamed from: h */
    public void mo10017h() {
        this.f2635c.mo10000a(C1102b.f2588B).mo10003a();
    }

    /* renamed from: i */
    public void mo10018i() {
        synchronized (this.f2636d) {
            if (this.f2641i < 1) {
                this.f2641i = System.currentTimeMillis();
                if (this.f2638f > 0) {
                    this.f2635c.mo10001a(C1102b.f2618y, this.f2641i - this.f2638f).mo10003a();
                }
            }
        }
    }
}
