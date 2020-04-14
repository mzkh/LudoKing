package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.tapjoy.internal.hi */
public final class C3143hi {

    /* renamed from: a */
    final C3250o f7421a = new C3250o(this.f7423c, "noMoreToday.date");

    /* renamed from: b */
    public final C3250o f7422b = new C3250o(this.f7423c, "noMoreToday.actionIds");

    /* renamed from: c */
    private final SharedPreferences f7423c;

    public C3143hi(Context context) {
        this.f7423c = context.getApplicationContext().getSharedPreferences("fiverocks", 0);
        mo30216b();
    }

    /* renamed from: a */
    static String m7267a() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    }

    /* renamed from: b */
    public final void mo30216b() {
        String a = this.f7421a.mo30368a();
        if (a != null && !m7267a().equals(a)) {
            this.f7421a.mo30369a(null);
            this.f7422b.mo30369a(null);
        }
    }
}
