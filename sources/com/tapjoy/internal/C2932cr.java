package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.cr */
public final class C2932cr {

    /* renamed from: a */
    private final C2940cz f6755a;

    private C2932cr(C2940cz czVar) {
        this.f6755a = czVar;
    }

    /* renamed from: a */
    public static C2932cr m6685a(C2933cs csVar) {
        C2940cz czVar = (C2940cz) csVar;
        C2960do.m6754a((Object) csVar, "AdSession is null");
        if (czVar.f6781c.f6831b == null) {
            C2960do.m6753a(czVar);
            C2932cr crVar = new C2932cr(czVar);
            czVar.f6781c.f6831b = crVar;
            return crVar;
        }
        throw new IllegalStateException("AdEvents already exists for AdSession");
    }

    /* renamed from: a */
    public final void mo29920a() {
        C2960do.m6753a(this.f6755a);
        if (C2937cw.NATIVE == this.f6755a.f6779a.f6756a) {
            if (!this.f6755a.mo29927d()) {
                try {
                    this.f6755a.mo29921a();
                } catch (Exception unused) {
                }
            }
            if (this.f6755a.mo29927d()) {
                C2940cz czVar = this.f6755a;
                if (!czVar.f6785g) {
                    C2949dg.m6726a().mo29948a(czVar.f6781c.mo29961c(), "publishImpressionEvent", new Object[0]);
                    czVar.f6785g = true;
                    return;
                }
                throw new IllegalStateException("Impression event can only be sent once");
            }
            return;
        }
        throw new IllegalStateException("Impression event is not expected from the Native AdSession");
    }
}
