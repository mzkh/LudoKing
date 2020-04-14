package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;

/* renamed from: com.tapjoy.internal.fr */
public final class C3079fr {

    /* renamed from: a */
    private static final C3088fz f7263a = new C3088fz() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final /* bridge */ /* synthetic */ String mo30139a(Object obj) {
            return "InsufficientCurrency";
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final /* synthetic */ TJPlacement mo30138a(Context context, TJPlacementListener tJPlacementListener, Object obj) {
            return TJPlacementManager.createPlacement(context, "InsufficientCurrency", true, tJPlacementListener);
        }
    };

    /* renamed from: a */
    public static void m7112a() {
        f7263a.mo30154c(null);
    }
}
