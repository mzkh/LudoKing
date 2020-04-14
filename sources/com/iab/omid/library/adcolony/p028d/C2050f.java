package com.iab.omid.library.adcolony.p028d;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

/* renamed from: com.iab.omid.library.adcolony.d.f */
public final class C2050f {
    /* renamed from: a */
    public static float m3851a(View view) {
        if (VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    /* renamed from: b */
    public static View m3852b(View view) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }

    /* renamed from: c */
    public static boolean m3853c(View view) {
        if ((VERSION.SDK_INT >= 19 && !view.isAttachedToWindow()) || !view.isShown()) {
            return false;
        }
        while (view != null) {
            if (view.getAlpha() == 0.0f) {
                return false;
            }
            view = m3852b(view);
        }
        return true;
    }

    /* renamed from: d */
    public static boolean m3854d(View view) {
        return (VERSION.SDK_INT < 19 || view.isAttachedToWindow()) && view.getVisibility() == 0 && view.getAlpha() != 0.0f;
    }
}
