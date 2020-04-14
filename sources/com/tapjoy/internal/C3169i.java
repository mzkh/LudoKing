package com.tapjoy.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* renamed from: com.tapjoy.internal.i */
public final class C3169i extends C3248m {

    /* renamed from: c */
    private final double f7523c = 0.0d;

    public C3169i(SharedPreferences sharedPreferences, String str) {
        super(sharedPreferences, str);
    }

    /* renamed from: a */
    public final double mo30231a() {
        String string = this.f7770a.getString(this.f7771b, null);
        if (string != null) {
            try {
                return Double.parseDouble(string);
            } catch (NumberFormatException unused) {
            }
        }
        return this.f7523c;
    }

    /* renamed from: a */
    public final Editor mo30232a(Editor editor) {
        return editor.remove(this.f7771b);
    }

    /* renamed from: a */
    public final Editor mo30233a(Editor editor, double d) {
        return editor.putString(this.f7771b, Double.toString(d));
    }
}
