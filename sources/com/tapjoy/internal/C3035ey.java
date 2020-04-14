package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.ey */
public enum C3035ey implements C3009em {
    APP(0),
    CAMPAIGN(1),
    CUSTOM(2),
    USAGES(3);
    
    public static final C2991ej ADAPTER = null;

    /* renamed from: a */
    private final int f7046a;

    /* renamed from: com.tapjoy.internal.ey$a */
    static final class C3036a extends C2985ef {
        C3036a() {
            super(C3035ey.class);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final /* bridge */ /* synthetic */ C3009em mo29979a(int i) {
            return C3035ey.m7044a(i);
        }
    }

    static {
        ADAPTER = new C3036a();
    }

    private C3035ey(int i) {
        this.f7046a = i;
    }

    /* renamed from: a */
    public static C3035ey m7044a(int i) {
        if (i == 0) {
            return APP;
        }
        if (i == 1) {
            return CAMPAIGN;
        }
        if (i == 2) {
            return CUSTOM;
        }
        if (i != 3) {
            return null;
        }
        return USAGES;
    }

    /* renamed from: a */
    public final int mo30009a() {
        return this.f7046a;
    }
}
