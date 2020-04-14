package com.inmobi.media;

/* renamed from: com.inmobi.media.hi */
/* compiled from: SessionManager */
public class C2566hi {

    /* renamed from: g */
    private static final String f5651g = "hi";

    /* renamed from: a */
    long f5652a;

    /* renamed from: b */
    long f5653b;

    /* renamed from: c */
    long f5654c;

    /* renamed from: d */
    long f5655d;

    /* renamed from: e */
    long f5656e;

    /* renamed from: f */
    long f5657f;

    /* renamed from: com.inmobi.media.hi$a */
    /* compiled from: SessionManager */
    static class C2567a {

        /* renamed from: a */
        static final C2566hi f5658a = new C2566hi(0);
    }

    /* synthetic */ C2566hi(byte b) {
        this();
    }

    /* renamed from: a */
    public static C2566hi m5571a() {
        return C2567a.f5658a;
    }

    private C2566hi() {
        this.f5652a = 0;
        this.f5653b = 0;
        this.f5654c = 0;
        this.f5655d = 0;
        this.f5656e = 0;
        this.f5657f = 0;
    }

    /* renamed from: b */
    static void m5572b() {
        C2568hj.m5581a();
        if (C2568hj.m5583e().f5328d) {
            C2535gv.m5426a().f5564c = System.currentTimeMillis();
        }
    }

    /* renamed from: a */
    public final void mo28564a(long j) {
        int a = C2527gp.m5386a();
        if (a != 0) {
            if (a == 1) {
                m5573d(j);
            }
            return;
        }
        m5575f(j);
    }

    /* renamed from: b */
    public final void mo28565b(long j) {
        int a = C2527gp.m5386a();
        if (a != 0) {
            if (a == 1) {
                m5574e(j);
            }
            return;
        }
        m5576g(j);
    }

    /* renamed from: d */
    private void m5573d(long j) {
        this.f5652a += j;
    }

    /* renamed from: e */
    private void m5574e(long j) {
        this.f5653b += j;
    }

    /* renamed from: f */
    private void m5575f(long j) {
        this.f5654c += j;
    }

    /* renamed from: g */
    private void m5576g(long j) {
        this.f5655d += j;
    }

    /* renamed from: c */
    public final void mo28566c(long j) {
        this.f5656e += j;
    }
}
