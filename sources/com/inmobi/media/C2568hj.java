package com.inmobi.media;

import android.os.SystemClock;
import com.inmobi.media.C2457fb.C2458a;
import com.inmobi.media.C2457fb.C2459b;
import java.util.UUID;

/* renamed from: com.inmobi.media.hj */
/* compiled from: SignalsComponent */
public class C2568hj {

    /* renamed from: c */
    private static final String f5659c = "hj";

    /* renamed from: a */
    public C2558hf f5660a;

    /* renamed from: b */
    public boolean f5661b;

    /* renamed from: d */
    private C2560hg f5662d;

    /* renamed from: com.inmobi.media.hj$a */
    /* compiled from: SignalsComponent */
    static class C2569a {

        /* renamed from: a */
        static final C2568hj f5663a = new C2568hj(0);
    }

    /* synthetic */ C2568hj(byte b) {
        this();
    }

    /* renamed from: a */
    public static C2568hj m5581a() {
        return C2569a.f5663a;
    }

    private C2568hj() {
    }

    /* renamed from: b */
    public final synchronized void mo28567b() {
        C2438es.m5087a("signals", C2505gd.m5306f(), null);
        C2535gv a = C2535gv.m5426a();
        a.f5565d = m5583e().f5328d;
        if (!a.f5565d) {
            a.f5562a = null;
            a.f5563b = 0;
            a.f5564c = 0;
        }
        C2566hi a2 = C2566hi.m5571a();
        C2568hj hjVar = C2569a.f5663a;
        if (m5583e().f5328d) {
            C2535gv.m5426a().f5562a = UUID.randomUUID().toString();
            C2535gv.m5426a().f5563b = System.currentTimeMillis();
            C2535gv.m5426a().f5564c = 0;
            a2.f5657f = SystemClock.elapsedRealtime();
            a2.f5652a = 0;
            a2.f5653b = 0;
            a2.f5654c = 0;
            a2.f5655d = 0;
            a2.f5656e = 0;
            a2.f5657f = 0;
        }
        if (m5586h()) {
            m5587i();
        }
        if (m5585g()) {
            C2562hh.m5557a().mo28557b();
        }
    }

    /* renamed from: c */
    public final synchronized void mo28568c() {
        C2566hi.m5571a();
        C2566hi.m5572b();
        if (this.f5661b) {
            this.f5661b = false;
            if (this.f5662d != null) {
                C2560hg hgVar = this.f5662d;
                hgVar.f5641a.f5642a = true;
                C2561a aVar = hgVar.f5641a;
                C2568hj hjVar = C2569a.f5663a;
                aVar.sendEmptyMessageDelayed(2, (long) (m5583e().f5326b * 1000));
            }
        }
        C2562hh a = C2562hh.m5557a();
        if (C2562hh.m5561c()) {
            if (a.f5645a != null) {
                a.f5645a.removeUpdates(a);
            }
            if (a.f5646b != null) {
                a.f5646b.disconnect();
            }
        }
        a.f5646b = null;
    }

    /* renamed from: d */
    static C2540gy m5582d() {
        return new C2540gy(((C2457fb) C2438es.m5087a("signals", C2505gd.m5306f(), null)).f5243m.f5245a);
    }

    /* renamed from: a */
    public static C2459b m5580a(String str) {
        return ((C2457fb) C2438es.m5087a("signals", str, null)).f5314a;
    }

    /* renamed from: e */
    public static C2459b m5583e() {
        return ((C2457fb) C2438es.m5087a("signals", C2505gd.m5306f(), null)).f5314a;
    }

    /* renamed from: f */
    public static C2458a m5584f() {
        return ((C2457fb) C2438es.m5087a("signals", C2505gd.m5306f(), null)).f5315b;
    }

    /* renamed from: i */
    private synchronized void m5587i() {
        if (!this.f5661b) {
            this.f5661b = true;
            if (this.f5662d == null) {
                this.f5662d = new C2560hg();
            }
            this.f5662d.mo28555a();
        }
    }

    /* renamed from: g */
    static boolean m5585g() {
        String l = C2505gd.m5314l();
        C2578hq b = C2579hs.m5621b();
        String e = b != null ? b.mo28576e() : null;
        return (l == null || m5580a(l).f5327c) && (e == null || b.mo28572a()) && (!(b != null && b.mo28575d()) || m5580a(e).f5327c);
    }

    /* renamed from: h */
    public static boolean m5586h() {
        String l = C2505gd.m5314l();
        C2578hq b = C2579hs.m5621b();
        String e = b != null ? b.mo28576e() : null;
        return (l == null || m5580a(l).f5330f) && (e == null || b.mo28573b()) && (!(b != null && b.mo28575d()) || m5580a(e).f5330f);
    }
}
