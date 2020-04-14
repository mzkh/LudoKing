package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacementListener;

/* renamed from: com.tapjoy.internal.gc */
abstract class C3102gc {

    /* renamed from: a */
    private static final C3102gc f7321a;

    /* renamed from: b */
    private static C3102gc f7322b;

    /* renamed from: a */
    public abstract Object mo30180a(Context context, String str, TJPlacementListener tJPlacementListener);

    C3102gc() {
    }

    static {
        C3103gd gdVar = new C3103gd();
        f7321a = gdVar;
        f7322b = gdVar;
    }

    /* renamed from: a */
    static C3102gc m7156a() {
        return f7322b;
    }
}
