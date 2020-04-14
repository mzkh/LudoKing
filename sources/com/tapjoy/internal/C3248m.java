package com.tapjoy.internal;

import android.content.SharedPreferences;

/* renamed from: com.tapjoy.internal.m */
public abstract class C3248m {

    /* renamed from: a */
    protected SharedPreferences f7770a;

    /* renamed from: b */
    protected String f7771b;

    public C3248m(SharedPreferences sharedPreferences, String str) {
        this.f7770a = sharedPreferences;
        this.f7771b = str;
    }

    /* renamed from: c */
    public final void mo30366c() {
        this.f7770a.edit().remove(this.f7771b).apply();
    }
}
