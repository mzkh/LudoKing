package com.iab.omid.library.adcolony.p026b;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.adcolony.adsession.C2029a;
import com.iab.omid.library.adcolony.p025a.C2025b;
import com.iab.omid.library.adcolony.p025a.C2026c;
import com.iab.omid.library.adcolony.p025a.C2027d;
import com.iab.omid.library.adcolony.p025a.C2028e;
import com.iab.omid.library.adcolony.p026b.C2032b.C2034a;
import com.iab.omid.library.adcolony.walking.TreeWalker;

/* renamed from: com.iab.omid.library.adcolony.b.e */
public class C2038e implements C2026c, C2034a {

    /* renamed from: a */
    private static C2038e f4038a;

    /* renamed from: b */
    private float f4039b = 0.0f;

    /* renamed from: c */
    private final C2028e f4040c;

    /* renamed from: d */
    private final C2025b f4041d;

    /* renamed from: e */
    private C2027d f4042e;

    /* renamed from: f */
    private C2031a f4043f;

    public C2038e(C2028e eVar, C2025b bVar) {
        this.f4040c = eVar;
        this.f4041d = bVar;
    }

    /* renamed from: a */
    public static C2038e m3797a() {
        if (f4038a == null) {
            f4038a = new C2038e(new C2028e(), new C2025b());
        }
        return f4038a;
    }

    /* renamed from: e */
    private C2031a m3798e() {
        if (this.f4043f == null) {
            this.f4043f = C2031a.m3760a();
        }
        return this.f4043f;
    }

    /* renamed from: a */
    public void mo27333a(float f) {
        this.f4039b = f;
        for (C2029a adSessionStatePublisher : m3798e().mo27394c()) {
            adSessionStatePublisher.getAdSessionStatePublisher().mo27431a(f);
        }
    }

    /* renamed from: a */
    public void mo27421a(Context context) {
        this.f4042e = this.f4040c.mo27337a(new Handler(), context, this.f4041d.mo27332a(), this);
    }

    /* renamed from: a */
    public void mo27403a(boolean z) {
        if (z) {
            TreeWalker.getInstance().mo27453a();
        } else {
            TreeWalker.getInstance().mo27456c();
        }
    }

    /* renamed from: b */
    public void mo27422b() {
        C2032b.m3767a().mo27398a((C2034a) this);
        C2032b.m3767a().mo27399b();
        if (C2032b.m3767a().mo27401d()) {
            TreeWalker.getInstance().mo27453a();
        }
        this.f4042e.mo27334a();
    }

    /* renamed from: c */
    public void mo27423c() {
        TreeWalker.getInstance().mo27455b();
        C2032b.m3767a().mo27400c();
        this.f4042e.mo27335b();
    }

    /* renamed from: d */
    public float mo27424d() {
        return this.f4039b;
    }
}
