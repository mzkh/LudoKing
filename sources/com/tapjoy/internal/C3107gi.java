package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.gi */
public final class C3107gi {

    /* renamed from: a */
    public static final C3107gi f7337a;

    /* renamed from: b */
    public final long f7338b;

    /* renamed from: c */
    public final long f7339c;

    /* renamed from: d */
    public final double f7340d;

    /* renamed from: e */
    public long f7341e;

    /* renamed from: f */
    private final long f7342f;

    static {
        C3107gi giVar = new C3107gi(0, 0, 0, 0.0d);
        f7337a = giVar;
    }

    public C3107gi(long j, long j2, long j3, double d) {
        this.f7342f = j;
        this.f7338b = j2;
        this.f7339c = j3;
        this.f7340d = d;
        this.f7341e = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C3107gi giVar = (C3107gi) obj;
            return this.f7342f == giVar.f7342f && this.f7338b == giVar.f7338b && this.f7339c == giVar.f7339c && this.f7340d == giVar.f7340d && this.f7341e == giVar.f7341e;
        }
    }
}
