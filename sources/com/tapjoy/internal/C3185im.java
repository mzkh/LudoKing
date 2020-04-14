package com.tapjoy.internal;

import android.os.SystemClock;

/* renamed from: com.tapjoy.internal.im */
public abstract class C3185im implements Runnable {

    /* renamed from: a */
    private final long f7587a = 300;

    /* renamed from: a */
    public abstract boolean mo30202a();

    public void run() {
        long elapsedRealtime = SystemClock.elapsedRealtime() + this.f7587a;
        while (!mo30202a() && elapsedRealtime - SystemClock.elapsedRealtime() > 0) {
            try {
                Thread.sleep(0);
            } catch (InterruptedException unused) {
                return;
            }
        }
    }
}
