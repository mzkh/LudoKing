package com.tapjoy.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* renamed from: com.tapjoy.internal.o */
public final class C3250o extends C3248m {

    /* renamed from: c */
    private final String f7772c = null;

    public C3250o(SharedPreferences sharedPreferences, String str) {
        super(sharedPreferences, str);
    }

    /* renamed from: a */
    public final String mo30368a() {
        return this.f7770a.getString(this.f7771b, this.f7772c);
    }

    /* renamed from: a */
    public final void mo30369a(String str) {
        this.f7770a.edit().putString(this.f7771b, str).apply();
    }

    /* renamed from: a */
    public final Editor mo30367a(Editor editor, String str) {
        return str != null ? editor.putString(this.f7771b, str) : editor.remove(this.f7771b);
    }
}
