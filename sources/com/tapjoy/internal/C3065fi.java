package com.tapjoy.internal;

import android.os.SystemClock;

/* renamed from: com.tapjoy.internal.fi */
public final class C3065fi {

    /* renamed from: a */
    public static final C3065fi f7230a = new C3065fi(-1);

    /* renamed from: b */
    public final long f7231b;

    /* renamed from: c */
    public long f7232c;

    public C3065fi(long j) {
        this.f7231b = j;
        this.f7232c = SystemClock.elapsedRealtime();
    }

    public C3065fi() {
        this.f7231b = 3600000;
        try {
            this.f7232c = SystemClock.elapsedRealtime() - 3600000;
        } catch (NullPointerException unused) {
            this.f7232c = -1;
        }
    }

    /* renamed from: a */
    public final boolean mo30120a() {
        boolean z = true;
        try {
            if (SystemClock.elapsedRealtime() - this.f7232c > this.f7231b) {
                return true;
            }
            z = false;
            return z;
        } catch (NullPointerException unused) {
        }
    }

    /* renamed from: a */
    public final boolean mo30121a(long j) {
        try {
            return (SystemClock.elapsedRealtime() - this.f7232c) + j > this.f7231b;
        } catch (NullPointerException unused) {
            return true;
        }
    }
}
