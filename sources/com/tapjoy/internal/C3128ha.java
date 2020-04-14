package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;

/* renamed from: com.tapjoy.internal.ha */
public class C3128ha implements C3111go {

    /* renamed from: a */
    private static final C3128ha f7378a = new C3128ha() {
        /* renamed from: a */
        public final void mo29403a(String str) {
        }

        /* renamed from: a */
        public final void mo29404a(String str, C1829gl glVar) {
        }

        /* renamed from: a */
        public final void mo29405a(String str, String str2, C1829gl glVar) {
        }

        /* renamed from: b */
        public final void mo29406b(String str) {
        }

        /* renamed from: c */
        public final void mo29407c(String str) {
        }

        /* renamed from: d */
        public final void mo29408d(String str) {
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C3111go f7379b;

    /* renamed from: c */
    private final C2889ba f7380c;

    /* synthetic */ C3128ha(byte b) {
        this();
    }

    /* renamed from: a */
    public static C3128ha m7230a(C3111go goVar) {
        if (!(!(goVar instanceof C3128ha))) {
            throw new IllegalArgumentException();
        } else if (goVar != null) {
            return new C3128ha(goVar);
        } else {
            return f7378a;
        }
    }

    private C3128ha() {
        this.f7379b = null;
        this.f7380c = null;
    }

    private C3128ha(C3111go goVar) {
        Handler handler;
        this.f7379b = goVar;
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            C3226jp.m7500a(myLooper);
            handler = myLooper == Looper.getMainLooper() ? C3254u.m7563a() : new Handler(myLooper);
        } else {
            handler = null;
        }
        if (handler != null) {
            this.f7380c = C3254u.m7564a(handler);
            new Object[1][0] = handler.getLooper();
        } else if (Thread.currentThread() == C3114gr.m7197b()) {
            this.f7380c = C3114gr.f7346a;
        } else {
            this.f7380c = C3254u.m7564a(C3254u.m7563a());
        }
    }

    /* renamed from: a */
    public void mo29403a(final String str) {
        this.f7380c.mo29867a(new Runnable() {
            public final void run() {
                C3128ha.this.f7379b.mo29403a(str);
            }
        });
    }

    /* renamed from: b */
    public void mo29406b(final String str) {
        this.f7380c.mo29867a(new Runnable() {
            public final void run() {
                C3128ha.this.f7379b.mo29406b(str);
            }
        });
    }

    /* renamed from: c */
    public void mo29407c(final String str) {
        this.f7380c.mo29867a(new Runnable() {
            public final void run() {
                C3128ha.this.f7379b.mo29407c(str);
            }
        });
    }

    /* renamed from: d */
    public void mo29408d(final String str) {
        this.f7380c.mo29867a(new Runnable() {
            public final void run() {
                C3128ha.this.f7379b.mo29408d(str);
            }
        });
    }

    /* renamed from: a */
    public void mo29404a(final String str, final C1829gl glVar) {
        this.f7380c.mo29867a(new Runnable() {
            public final void run() {
                C3128ha.this.f7379b.mo29404a(str, glVar);
            }
        });
    }

    /* renamed from: a */
    public void mo29405a(final String str, final String str2, final C1829gl glVar) {
        this.f7380c.mo29867a(new Runnable() {
            public final void run() {
                C3128ha.this.f7379b.mo29405a(str, str2, glVar);
            }
        });
    }
}
