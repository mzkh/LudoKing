package com.iab.omid.library.adcolony.p026b;

import android.annotation.SuppressLint;
import android.content.Context;

/* renamed from: com.iab.omid.library.adcolony.b.c */
public class C2035c {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a */
    private static C2035c f4032a = new C2035c();

    /* renamed from: b */
    private Context f4033b;

    private C2035c() {
    }

    /* renamed from: a */
    public static C2035c m3779a() {
        return f4032a;
    }

    /* renamed from: a */
    public void mo27404a(Context context) {
        this.f4033b = context != null ? context.getApplicationContext() : null;
    }

    /* renamed from: b */
    public Context mo27405b() {
        return this.f4033b;
    }
}
