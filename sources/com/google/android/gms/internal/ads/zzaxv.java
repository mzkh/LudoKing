package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzaxv<T> implements zzddi<T> {
    private final zzddt<T> zzdws = zzddt.zzapl();

    public final boolean set(@Nullable T t) {
        return zzal(this.zzdws.set(t));
    }

    public final boolean setException(Throwable th) {
        return zzal(this.zzdws.setException(th));
    }

    private static boolean zzal(boolean z) {
        if (!z) {
            zzq.zzkn().zzb(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture");
        }
        return z;
    }

    public void addListener(Runnable runnable, Executor executor) {
        this.zzdws.addListener(runnable, executor);
    }

    public boolean cancel(boolean z) {
        return this.zzdws.cancel(z);
    }

    public boolean isCancelled() {
        return this.zzdws.isCancelled();
    }

    public boolean isDone() {
        return this.zzdws.isDone();
    }

    public T get() throws ExecutionException, InterruptedException {
        return this.zzdws.get();
    }

    public T get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.zzdws.get(j, timeUnit);
    }
}
