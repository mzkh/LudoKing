package com.iab.omid.library.inmobi.p034d;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

/* renamed from: com.iab.omid.library.inmobi.d.f */
public final class C2098f {
    /* renamed from: a */
    public static float m4057a(View view) {
        if (VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    /* renamed from: b */
    public static View m4058b(View view) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }

    /* renamed from: c */
    public static boolean m4059c(View view) {
        if ((VERSION.SDK_INT >= 19 && !view.isAttachedToWindow()) || !view.isShown()) {
            return false;
        }
        while (view != null) {
            if (view.getAlpha() == 0.0f) {
                return false;
            }
            view = m4058b(view);
        }
        return true;
    }

    /* renamed from: d */
    public static boolean m4060d(View view) {
        return m4061e(view) == null;
    }

    /* renamed from: e */
    public static String m4061e(View view) {
        if (VERSION.SDK_INT >= 19 && !view.isAttachedToWindow()) {
            return "notAttached";
        }
        int visibility = view.getVisibility();
        if (visibility != 0) {
            return visibility != 4 ? visibility != 8 ? "viewNotVisible" : "viewGone" : "viewInvisible";
        }
        if (view.getAlpha() == 0.0f) {
            return "viewAlphaZero";
        }
        return null;
    }
}
