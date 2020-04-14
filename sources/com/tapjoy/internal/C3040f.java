package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.f */
public final class C3040f {

    /* renamed from: a */
    public String f7053a;

    /* renamed from: b */
    public String f7054b;

    /* renamed from: c */
    public String f7055c;

    /* renamed from: d */
    public long f7056d;

    /* renamed from: e */
    public int f7057e;

    /* renamed from: f */
    public String f7058f;

    /* renamed from: g */
    public String f7059g;

    public C3040f(String str) {
        C1812bn b = C1812bn.m3464b(str);
        b.mo18067h();
        while (b.mo18069j()) {
            String l = b.mo18071l();
            if ("orderId".equals(l)) {
                this.f7053a = b.mo18072m();
            } else if ("packageName".equals(l)) {
                this.f7054b = b.mo18072m();
            } else if ("productId".equals(l)) {
                this.f7055c = b.mo18072m();
            } else if ("purchaseTime".equals(l)) {
                this.f7056d = b.mo18076q();
            } else if ("purchaseState".equals(l)) {
                this.f7057e = b.mo18077r();
            } else if ("developerPayload".equals(l)) {
                this.f7058f = b.mo18072m();
            } else if ("purchaseToken".equals(l)) {
                this.f7059g = b.mo18072m();
            } else {
                b.mo18078s();
            }
        }
        b.mo18068i();
    }
}
