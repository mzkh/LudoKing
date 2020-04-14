package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.e */
public final class C2979e {

    /* renamed from: a */
    public String f6873a;

    /* renamed from: b */
    public String f6874b;

    /* renamed from: c */
    public String f6875c;

    /* renamed from: d */
    public String f6876d;

    /* renamed from: e */
    public String f6877e;

    /* renamed from: f */
    public String f6878f;

    /* renamed from: g */
    public long f6879g;

    public C2979e(String str) {
        C1812bn b = C1812bn.m3464b(str);
        b.mo18067h();
        while (b.mo18069j()) {
            String l = b.mo18071l();
            if ("productId".equals(l)) {
                this.f6873a = b.mo18072m();
            } else if ("type".equals(l)) {
                this.f6874b = b.mo18072m();
            } else if ("price".equals(l)) {
                this.f6875c = b.mo18072m();
            } else if ("title".equals(l)) {
                this.f6876d = b.mo18072m();
            } else if ("description".equals(l)) {
                this.f6877e = b.mo18072m();
            } else if ("price_currency_code".equals(l)) {
                this.f6878f = b.mo18072m();
            } else if ("price_amount_micros".equals(l)) {
                this.f6879g = b.mo18076q();
            } else {
                b.mo18078s();
            }
        }
        b.mo18068i();
    }
}
