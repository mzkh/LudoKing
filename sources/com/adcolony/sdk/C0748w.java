package com.adcolony.sdk;

/* renamed from: com.adcolony.sdk.w */
class C0748w {

    /* renamed from: a */
    static C0748w f1165a = new C0748w(3, false);

    /* renamed from: b */
    static C0748w f1166b = new C0748w(3, true);

    /* renamed from: c */
    static C0748w f1167c = new C0748w(2, false);

    /* renamed from: d */
    static C0748w f1168d = new C0748w(2, true);

    /* renamed from: e */
    static C0748w f1169e = new C0748w(1, false);

    /* renamed from: f */
    static C0748w f1170f = new C0748w(1, true);

    /* renamed from: g */
    static C0748w f1171g = new C0748w(0, false);

    /* renamed from: h */
    static C0748w f1172h = new C0748w(0, true);

    /* renamed from: i */
    private int f1173i;

    /* renamed from: j */
    private boolean f1174j;

    /* renamed from: com.adcolony.sdk.w$a */
    static class C0749a {

        /* renamed from: a */
        StringBuilder f1175a = new StringBuilder();

        C0749a() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C0749a mo8722a(char c) {
            if (c != 10) {
                this.f1175a.append(c);
            }
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C0749a mo8726a(String str) {
            this.f1175a.append(str);
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C0749a mo8725a(Object obj) {
            if (obj != null) {
                this.f1175a.append(obj.toString());
            } else {
                this.f1175a.append("null");
            }
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C0749a mo8723a(double d) {
            C0543at.m304a(d, 2, this.f1175a);
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C0749a mo8724a(int i) {
            this.f1175a.append(i);
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C0749a mo8727a(boolean z) {
            this.f1175a.append(z);
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo8728a(C0748w wVar) {
            wVar.m927a(this.f1175a.toString());
        }
    }

    C0748w(int i, boolean z) {
        this.f1173i = i;
        this.f1174j = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m927a(String str) {
        C0752y.m954a(this.f1173i, str, this.f1174j);
    }
}
