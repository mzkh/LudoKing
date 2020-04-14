package com.tapjoy.internal;

import android.content.SharedPreferences;

/* renamed from: com.tapjoy.internal.h */
public final class C3127h extends C3248m {

    /* renamed from: c */
    private final boolean f7377c = false;

    public C3127h(SharedPreferences sharedPreferences, String str) {
        super(sharedPreferences, str);
    }

    /* renamed from: a */
    public final void mo30204a(boolean z) {
        this.f7770a.edit().putBoolean(this.f7771b, z).apply();
    }

    /* renamed from: a */
    public final Boolean mo30203a() {
        return Boolean.valueOf(this.f7770a.getBoolean(this.f7771b, this.f7377c));
    }
}
