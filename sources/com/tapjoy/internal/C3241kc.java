package com.tapjoy.internal;

import com.tapjoy.internal.C3245kf.C3246a;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.tapjoy.internal.kc */
public abstract class C3241kc implements C3245kf {

    /* renamed from: a */
    private final ReentrantLock f7751a = new ReentrantLock();

    /* renamed from: b */
    private final C3242a f7752b = new C3242a(this, 0);

    /* renamed from: c */
    private final C3242a f7753c = new C3242a(this, 0);

    /* renamed from: d */
    private C3246a f7754d = C3246a.NEW;

    /* renamed from: e */
    private boolean f7755e = false;

    /* renamed from: com.tapjoy.internal.kc$a */
    class C3242a extends C1855kb {
        private C3242a() {
        }

        /* synthetic */ C3242a(C3241kc kcVar, byte b) {
            this();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public C3246a get(long j, TimeUnit timeUnit) {
            try {
                return (C3246a) super.get(j, timeUnit);
            } catch (TimeoutException unused) {
                throw new TimeoutException(C3241kc.this.toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo30353a();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo30354b();

    /* renamed from: e */
    public final C1857ke mo30350e() {
        this.f7751a.lock();
        try {
            if (this.f7754d == C3246a.NEW) {
                this.f7754d = C3246a.STARTING;
                mo30353a();
            }
        } catch (Throwable th) {
            this.f7751a.unlock();
            throw th;
        }
        this.f7751a.unlock();
        return this.f7752b;
    }

    /* renamed from: g */
    private C1857ke m7523g() {
        this.f7751a.lock();
        try {
            if (this.f7754d == C3246a.NEW) {
                this.f7754d = C3246a.TERMINATED;
                this.f7752b.mo18195a((Object) C3246a.TERMINATED);
                this.f7753c.mo18195a((Object) C3246a.TERMINATED);
            } else if (this.f7754d == C3246a.STARTING) {
                this.f7755e = true;
                this.f7752b.mo18195a((Object) C3246a.STOPPING);
            } else if (this.f7754d == C3246a.RUNNING) {
                this.f7754d = C3246a.STOPPING;
                mo30354b();
            }
        } catch (Throwable th) {
            this.f7751a.unlock();
            throw th;
        }
        this.f7751a.unlock();
        return this.f7753c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final void mo30358c() {
        this.f7751a.lock();
        try {
            if (this.f7754d == C3246a.STARTING) {
                this.f7754d = C3246a.RUNNING;
                if (this.f7755e) {
                    m7523g();
                } else {
                    this.f7752b.mo18195a((Object) C3246a.RUNNING);
                }
                return;
            }
            StringBuilder sb = new StringBuilder("Cannot notifyStarted() when the service is ");
            sb.append(this.f7754d);
            IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
            mo30357a(illegalStateException);
            throw illegalStateException;
        } finally {
            this.f7751a.unlock();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final void mo30359d() {
        this.f7751a.lock();
        try {
            if (this.f7754d != C3246a.STOPPING) {
                if (this.f7754d != C3246a.RUNNING) {
                    StringBuilder sb = new StringBuilder("Cannot notifyStopped() when the service is ");
                    sb.append(this.f7754d);
                    IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
                    mo30357a(illegalStateException);
                    throw illegalStateException;
                }
            }
            this.f7754d = C3246a.TERMINATED;
            this.f7753c.mo18195a((Object) C3246a.TERMINATED);
        } finally {
            this.f7751a.unlock();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30357a(Throwable th) {
        C3226jp.m7500a(th);
        this.f7751a.lock();
        try {
            if (this.f7754d == C3246a.STARTING) {
                this.f7752b.mo18196a(th);
                this.f7753c.mo18196a((Throwable) new Exception("Service failed to start.", th));
            } else if (this.f7754d == C3246a.STOPPING) {
                this.f7753c.mo18196a(th);
            } else if (this.f7754d == C3246a.RUNNING) {
                this.f7753c.mo18196a((Throwable) new Exception("Service failed while running", th));
            } else if (this.f7754d == C3246a.NEW || this.f7754d == C3246a.TERMINATED) {
                StringBuilder sb = new StringBuilder("Failed while in state:");
                sb.append(this.f7754d);
                throw new IllegalStateException(sb.toString(), th);
            }
            this.f7754d = C3246a.FAILED;
        } finally {
            this.f7751a.unlock();
        }
    }

    /* renamed from: f */
    public final C3246a mo30351f() {
        C3246a aVar;
        this.f7751a.lock();
        try {
            if (!this.f7755e || this.f7754d != C3246a.STARTING) {
                aVar = this.f7754d;
            } else {
                aVar = C3246a.STOPPING;
            }
            return aVar;
        } finally {
            this.f7751a.unlock();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(mo30351f());
        sb.append("]");
        return sb.toString();
    }
}
