package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbqs<T> {
    public Executor executor;
    public T zzfhz;

    public static <T> zzbqs<T> zzb(T t, Executor executor2) {
        return new zzbqs<>(t, executor2);
    }

    public zzbqs(T t, Executor executor2) {
        this.zzfhz = t;
        this.executor = executor2;
    }
}
