package com.tapjoy.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* renamed from: com.tapjoy.internal.k */
public final class C3236k extends C3248m {

    /* renamed from: c */
    private final int f7745c;

    public C3236k(SharedPreferences sharedPreferences, String str, int i) {
        super(sharedPreferences, str);
        this.f7745c = i;
    }

    /* renamed from: a */
    public final Integer mo30346a() {
        return Integer.valueOf(mo30349b());
    }

    /* renamed from: b */
    public final int mo30349b() {
        return this.f7770a.getInt(this.f7771b, this.f7745c);
    }

    /* renamed from: a */
    public final void mo30348a(Integer num) {
        if (num != null) {
            mo30347a(num.intValue());
        } else {
            mo30366c();
        }
    }

    /* renamed from: a */
    public final void mo30347a(int i) {
        this.f7770a.edit().putInt(this.f7771b, i).apply();
    }

    /* renamed from: a */
    public final Editor mo30345a(Editor editor, int i) {
        return editor.putInt(this.f7771b, i);
    }
}
