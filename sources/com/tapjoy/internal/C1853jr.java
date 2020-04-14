package com.tapjoy.internal;

import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.jr */
public final class C1853jr {
    /* renamed from: a */
    private static void m3671a(@Nullable Throwable th, Class cls) {
        if (th != null && cls.isInstance(th)) {
            throw ((Throwable) cls.cast(th));
        }
    }

    /* renamed from: a */
    public static RuntimeException m3670a(Throwable th) {
        Throwable th2 = (Throwable) C3226jp.m7500a(th);
        m3671a(th2, Error.class);
        m3671a(th2, RuntimeException.class);
        throw new RuntimeException(th);
    }
}
