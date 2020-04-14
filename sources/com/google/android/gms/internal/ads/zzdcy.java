package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdcy extends zzddf {
    public static <V> zzddi<V> zzah(@NullableDecl V v) {
        if (v == null) {
            return zza.zzgrp;
        }
        return new zza(v);
    }

    public static <V> zzddi<V> zzi(Throwable th) {
        zzdaq.checkNotNull(th);
        return new zzb(th);
    }

    public static <V, X extends Throwable> zzddi<V> zzb(zzddi<? extends V> zzddi, Class<X> cls, zzdcj<? super X, ? extends V> zzdcj, Executor executor) {
        return zzdbw.zza(zzddi, cls, zzdcj, executor);
    }

    public static <V> zzddi<V> zza(zzddi<V> zzddi, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (zzddi.isDone()) {
            return zzddi;
        }
        return zzdds.zzb(zzddi, j, timeUnit, scheduledExecutorService);
    }

    public static <I, O> zzddi<O> zzb(zzddi<I> zzddi, zzdcj<? super I, ? extends O> zzdcj, Executor executor) {
        return zzdca.zza(zzddi, zzdcj, executor);
    }

    public static <I, O> zzddi<O> zzb(zzddi<I> zzddi, zzdal<? super I, ? extends O> zzdal, Executor executor) {
        return zzdca.zza(zzddi, zzdal, executor);
    }

    public static <V> zzddi<List<V>> zzg(Iterable<? extends zzddi<? extends V>> iterable) {
        return new zzdck(zzdbd.zzf(iterable), true);
    }

    @SafeVarargs
    public static <V> zzddd<V> zza(zzddi<? extends V>... zzddiArr) {
        return new zzddd<>(false, zzdbd.zzb(zzddiArr), null);
    }

    public static <V> zzddd<V> zzh(Iterable<? extends zzddi<? extends V>> iterable) {
        return new zzddd<>(false, zzdbd.zzf(iterable), null);
    }

    public static <V> void zza(zzddi<V> zzddi, zzdcz<? super V> zzdcz, Executor executor) {
        zzdaq.checkNotNull(zzdcz);
        zzddi.addListener(new zzdda(zzddi, zzdcz), executor);
    }

    public static <V> V zzb(Future<V> future) throws ExecutionException {
        if (future.isDone()) {
            return zzdeb.zza(future);
        }
        throw new IllegalStateException(zzdas.zzb("Future was expected to be done: %s", future));
    }

    public static <V> V zzc(Future<V> future) {
        zzdaq.checkNotNull(future);
        try {
            return zzdeb.zza(future);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof Error) {
                throw new zzdct((Error) cause);
            }
            throw new zzddy(cause);
        }
    }
}
