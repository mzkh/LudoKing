package com.iab.omid.library.inmobi.p032b;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.inmobi.adsession.C2077a;
import com.iab.omid.library.inmobi.p031a.C2073b;
import com.iab.omid.library.inmobi.p031a.C2074c;
import com.iab.omid.library.inmobi.p031a.C2075d;
import com.iab.omid.library.inmobi.p031a.C2076e;
import com.iab.omid.library.inmobi.p032b.C2080b.C2082a;
import com.iab.omid.library.inmobi.walking.TreeWalker;

/* renamed from: com.iab.omid.library.inmobi.b.e */
public class C2086e implements C2074c, C2082a {

    /* renamed from: a */
    private static C2086e f4137a;

    /* renamed from: b */
    private float f4138b = 0.0f;

    /* renamed from: c */
    private final C2076e f4139c;

    /* renamed from: d */
    private final C2073b f4140d;

    /* renamed from: e */
    private C2075d f4141e;

    /* renamed from: f */
    private C2079a f4142f;

    public C2086e(C2076e eVar, C2073b bVar) {
        this.f4139c = eVar;
        this.f4140d = bVar;
    }

    /* renamed from: a */
    public static C2086e m4001a() {
        if (f4137a == null) {
            f4137a = new C2086e(new C2076e(), new C2073b());
        }
        return f4137a;
    }

    /* renamed from: e */
    private C2079a m4002e() {
        if (this.f4142f == null) {
            this.f4142f = C2079a.m3964a();
        }
        return this.f4142f;
    }

    /* renamed from: a */
    public void mo27496a(float f) {
        this.f4138b = f;
        for (C2077a adSessionStatePublisher : m4002e().mo27557c()) {
            adSessionStatePublisher.getAdSessionStatePublisher().mo27595a(f);
        }
    }

    /* renamed from: a */
    public void mo27584a(Context context) {
        this.f4141e = this.f4139c.mo27500a(new Handler(), context, this.f4140d.mo27495a(), this);
    }

    /* renamed from: a */
    public void mo27566a(boolean z) {
        if (z) {
            TreeWalker.getInstance().mo27617a();
        } else {
            TreeWalker.getInstance().mo27620c();
        }
    }

    /* renamed from: b */
    public void mo27585b() {
        C2080b.m3971a().mo27561a((C2082a) this);
        C2080b.m3971a().mo27562b();
        if (C2080b.m3971a().mo27564d()) {
            TreeWalker.getInstance().mo27617a();
        }
        this.f4141e.mo27497a();
    }

    /* renamed from: c */
    public void mo27586c() {
        TreeWalker.getInstance().mo27619b();
        C2080b.m3971a().mo27563c();
        this.f4141e.mo27498b();
    }

    /* renamed from: d */
    public float mo27587d() {
        return this.f4138b;
    }
}
