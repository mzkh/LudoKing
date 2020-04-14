package com.iab.omid.library.inmobi.p032b;

import android.annotation.SuppressLint;
import android.content.Context;

/* renamed from: com.iab.omid.library.inmobi.b.c */
public class C2083c {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a */
    private static C2083c f4131a = new C2083c();

    /* renamed from: b */
    private Context f4132b;

    private C2083c() {
    }

    /* renamed from: a */
    public static C2083c m3983a() {
        return f4131a;
    }

    /* renamed from: a */
    public void mo27567a(Context context) {
        this.f4132b = context != null ? context.getApplicationContext() : null;
    }

    /* renamed from: b */
    public Context mo27568b() {
        return this.f4132b;
    }
}
