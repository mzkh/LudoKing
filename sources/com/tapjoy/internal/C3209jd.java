package com.tapjoy.internal;

import java.io.InterruptedIOException;

/* renamed from: com.tapjoy.internal.jd */
public class C3209jd {

    /* renamed from: a */
    public static final C3209jd f7654a = new C3209jd() {
        /* renamed from: a */
        public final void mo30322a() {
        }
    };

    /* renamed from: b */
    private boolean f7655b;

    /* renamed from: c */
    private long f7656c;

    /* renamed from: a */
    public void mo30322a() {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.f7655b && this.f7656c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
