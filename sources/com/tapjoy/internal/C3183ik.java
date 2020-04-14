package com.tapjoy.internal;

import com.tapjoy.internal.C3029ew.C3030a;
import java.util.Map;

/* renamed from: com.tapjoy.internal.ik */
public final class C3183ik extends C1850ii {

    /* renamed from: c */
    private final C3030a f7581c = new C3030a();

    /* renamed from: d */
    private C3035ey f7582d = null;

    /* renamed from: c */
    public final String mo18084c() {
        return this.f7582d == C3035ey.USAGES ? "api/v1/usages" : "api/v1/cevs";
    }

    /* renamed from: a */
    public final boolean mo30255a(C3026ev evVar) {
        if (this.f7582d == null) {
            this.f7582d = evVar.f6996n;
        } else if (evVar.f6996n != this.f7582d) {
            return false;
        }
        this.f7581c.f7036c.add(evVar);
        return true;
    }

    /* renamed from: g */
    public final int mo30256g() {
        return this.f7581c.f7036c.size();
    }

    /* renamed from: e */
    public final Map mo18086e() {
        Map e = super.mo18086e();
        e.put("events", new C2902bm(C3149hp.m7284a(this.f7581c.mo30088b())));
        return e;
    }
}
