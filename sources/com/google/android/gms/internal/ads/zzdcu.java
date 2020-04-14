package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzdcu<V> extends zzdaw implements Future<V> {
    protected zzdcu() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzapi */
    public abstract Future<? extends V> zzaoi();

    public boolean cancel(boolean z) {
        return zzaoi().cancel(z);
    }

    public boolean isCancelled() {
        return zzaoi().isCancelled();
    }

    public boolean isDone() {
        return zzaoi().isDone();
    }

    public V get() throws InterruptedException, ExecutionException {
        return zzaoi().get();
    }

    public V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return zzaoi().get(j, timeUnit);
    }
}
