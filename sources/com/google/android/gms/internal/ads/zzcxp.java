package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcxp<E, V> implements zzddi<V> {
    private final E zzgll;
    private final String zzglm;
    private final zzddi<V> zzgln;

    @VisibleForTesting(otherwise = 3)
    public zzcxp(E e, String str, zzddi<V> zzddi) {
        this.zzgll = e;
        this.zzglm = str;
        this.zzgln = zzddi;
    }

    public final void addListener(Runnable runnable, Executor executor) {
        this.zzgln.addListener(runnable, executor);
    }

    public final boolean cancel(boolean z) {
        return this.zzgln.cancel(z);
    }

    public final V get() throws InterruptedException, ExecutionException {
        return this.zzgln.get();
    }

    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.zzgln.get(j, timeUnit);
    }

    public final boolean isCancelled() {
        return this.zzgln.isCancelled();
    }

    public final boolean isDone() {
        return this.zzgln.isDone();
    }

    public final E zzanq() {
        return this.zzgll;
    }

    public final String zzanr() {
        return this.zzglm;
    }

    public final String toString() {
        String str = this.zzglm;
        int identityHashCode = System.identityHashCode(this);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(str);
        sb.append("@");
        sb.append(identityHashCode);
        return sb.toString();
    }
}
