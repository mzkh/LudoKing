package com.tapjoy.internal;

import com.tapjoy.internal.C2991ej.C3006a;

/* renamed from: com.tapjoy.internal.ef */
public abstract class C2985ef extends C2991ej {
    /* renamed from: a */
    public abstract C3009em mo29979a(int i);

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ int mo29978a(Object obj) {
        return C3008el.m6874a(((C3009em) obj).mo30009a());
    }

    /* renamed from: a */
    public final /* synthetic */ void mo29981a(C3008el elVar, Object obj) {
        elVar.mo30005c(((C3009em) obj).mo30009a());
    }

    protected C2985ef(Class cls) {
        super(C2986eg.VARINT, cls);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo29980a(C3007ek ekVar) {
        int d = ekVar.mo29999d();
        C3009em a = mo29979a(d);
        if (a != null) {
            return a;
        }
        throw new C3006a(d, this.f6914a);
    }
}
