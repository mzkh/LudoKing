package com.tapjoy.internal;

import com.tapjoy.internal.C3245kf.C3246a;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* renamed from: com.tapjoy.internal.ka */
public abstract class C3237ka implements C3245kf {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Logger f7746a = Logger.getLogger(C3237ka.class.getName());

    /* renamed from: b */
    private final C3245kf f7747b = new C3241kc() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo30353a() {
            new Executor() {
                public final void execute(Runnable runnable) {
                    new Thread(runnable, C3237ka.this.getClass().getSimpleName()).start();
                }
            }.execute(new Runnable() {
                public final void run() {
                    try {
                        C3237ka.this.mo30175b();
                        C32381.this.mo30358c();
                        if (C32381.this.mo30351f() == C3246a.RUNNING) {
                            C3237ka.this.mo30177d();
                        }
                        C3237ka.this.mo30176c();
                        C32381.this.mo30359d();
                    } catch (Throwable th) {
                        C32381.this.mo30357a(th);
                        throw C1853jr.m3670a(th);
                    }
                }
            });
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public final void mo30354b() {
            C3237ka.this.mo30174a();
        }
    };

    /* renamed from: a */
    public void mo30174a() {
    }

    /* renamed from: b */
    public void mo30175b() {
    }

    /* renamed from: c */
    public void mo30176c() {
    }

    /* renamed from: d */
    public abstract void mo30177d();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(mo30351f());
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: e */
    public final C1857ke mo30350e() {
        return this.f7747b.mo30350e();
    }

    /* renamed from: f */
    public final C3246a mo30351f() {
        return this.f7747b.mo30351f();
    }
}
