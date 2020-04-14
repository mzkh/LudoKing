package com.tapjoy.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* renamed from: com.tapjoy.internal.l */
public final class C3247l extends C3248m {

    /* renamed from: c */
    private final long f7769c = 0;

    public C3247l(SharedPreferences sharedPreferences, String str) {
        super(sharedPreferences, str);
    }

    /* renamed from: a */
    public final long mo30362a() {
        return this.f7770a.getLong(this.f7771b, this.f7769c);
    }

    /* renamed from: a */
    public final void mo30365a(long j) {
        this.f7770a.edit().putLong(this.f7771b, j).apply();
    }

    /* renamed from: a */
    public final Editor mo30363a(Editor editor) {
        return editor.remove(this.f7771b);
    }

    /* renamed from: a */
    public final Editor mo30364a(Editor editor, long j) {
        return editor.putLong(this.f7771b, j);
    }
}
