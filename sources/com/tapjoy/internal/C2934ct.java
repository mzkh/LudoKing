package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.ct */
public final class C2934ct {

    /* renamed from: a */
    public final C2937cw f6756a;

    /* renamed from: b */
    public final C2937cw f6757b;

    /* renamed from: c */
    public final boolean f6758c;

    private C2934ct(C2937cw cwVar, C2937cw cwVar2) {
        this.f6756a = cwVar;
        if (cwVar2 == null) {
            this.f6757b = C2937cw.NONE;
        } else {
            this.f6757b = cwVar2;
        }
        this.f6758c = false;
    }

    /* renamed from: a */
    public static C2934ct m6691a(C2937cw cwVar, C2937cw cwVar2) {
        C2960do.m6754a((Object) cwVar, "Impression owner is null");
        if (!cwVar.equals(C2937cw.NONE)) {
            return new C2934ct(cwVar, cwVar2);
        }
        throw new IllegalArgumentException("Impression owner is none");
    }
}
