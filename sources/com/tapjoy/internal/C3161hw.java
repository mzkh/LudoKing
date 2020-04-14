package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.hw */
final class C3161hw extends C1843ho implements C3112gp {

    /* renamed from: a */
    public static final C2896bi f7495a = new C2896bi() {
        /* renamed from: a */
        public final /* synthetic */ Object mo18189a(C1812bn bnVar) {
            bnVar.mo18067h();
            String str = "";
            String str2 = str;
            String str3 = str2;
            while (bnVar.mo18069j()) {
                String l = bnVar.mo18071l();
                if ("campaign_id".equals(l)) {
                    str2 = bnVar.mo18057c(str);
                } else if ("product_id".equals(l)) {
                    str3 = bnVar.mo18057c(str);
                } else {
                    bnVar.mo18078s();
                }
            }
            bnVar.mo18068i();
            return new C3161hw(str2, str3);
        }
    };

    /* renamed from: b */
    private final String f7496b;

    /* renamed from: c */
    private final String f7497c;

    C3161hw(String str, String str2) {
        this.f7496b = str;
        this.f7497c = str2;
    }

    /* renamed from: a */
    public final String mo30188a() {
        return this.f7496b;
    }

    /* renamed from: b */
    public final String mo30189b() {
        return this.f7497c;
    }
}
