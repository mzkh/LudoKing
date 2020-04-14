package com.appsflyer.internal;

/* renamed from: com.appsflyer.internal.x */
public final class C1393x {

    /* renamed from: ˊ */
    private C1394e f3625;

    /* renamed from: ˋ */
    public boolean f3626;

    /* renamed from: ॱ */
    public String f3627;

    /* renamed from: com.appsflyer.internal.x$e */
    enum C1394e {
        GOOGLE(0),
        AMAZON(1);
        

        /* renamed from: ॱ */
        private int f3631;

        private C1394e(int i) {
            this.f3631 = i;
        }

        public final String toString() {
            return String.valueOf(this.f3631);
        }
    }

    C1393x(C1394e eVar, String str, boolean z) {
        this.f3625 = eVar;
        this.f3627 = str;
        this.f3626 = z;
    }

    public final String toString() {
        return String.format("%s,%s", new Object[]{this.f3627, Boolean.valueOf(this.f3626)});
    }
}
