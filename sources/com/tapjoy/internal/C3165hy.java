package com.tapjoy.internal;

import com.google.firebase.analytics.FirebaseAnalytics.Param;

/* renamed from: com.tapjoy.internal.hy */
final class C3165hy extends C1843ho implements C3113gq {

    /* renamed from: a */
    public static final C2896bi f7504a = new C2896bi() {
        /* renamed from: a */
        public final /* synthetic */ Object mo18189a(C1812bn bnVar) {
            bnVar.mo18067h();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i = 1;
            while (bnVar.mo18069j()) {
                String l = bnVar.mo18071l();
                if ("id".equals(l)) {
                    str = bnVar.mo18072m();
                } else if ("name".equals(l)) {
                    str2 = bnVar.mo18072m();
                } else if (Param.QUANTITY.equals(l)) {
                    i = bnVar.mo18077r();
                } else if ("token".equals(l)) {
                    str3 = bnVar.mo18072m();
                } else {
                    bnVar.mo18078s();
                }
            }
            bnVar.mo18068i();
            return new C3165hy(str, str2, i, str3);
        }
    };

    /* renamed from: b */
    private final String f7505b;

    /* renamed from: c */
    private final String f7506c;

    /* renamed from: d */
    private final int f7507d;

    /* renamed from: e */
    private final String f7508e;

    C3165hy(String str, String str2, int i, String str3) {
        this.f7505b = str;
        this.f7506c = str2;
        this.f7507d = i;
        this.f7508e = str3;
    }

    /* renamed from: a */
    public final String mo30190a() {
        return this.f7505b;
    }

    /* renamed from: b */
    public final String mo30191b() {
        return this.f7506c;
    }

    /* renamed from: c */
    public final int mo30192c() {
        return this.f7507d;
    }

    /* renamed from: d */
    public final String mo30193d() {
        return this.f7508e;
    }
}
