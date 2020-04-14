package com.google.android.gms.internal.ads;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzdcb extends AbstractExecutorService implements zzddl {
    /* access modifiers changed from: protected */
    public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return zzddw.zza(runnable, t);
    }

    /* access modifiers changed from: protected */
    public final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return zzddw.zze(callable);
    }

    /* renamed from: zzf */
    public final zzddi<?> submit(Runnable runnable) {
        return (zzddi) super.submit(runnable);
    }

    /* renamed from: zzd */
    public final <T> zzddi<T> submit(Callable<T> callable) {
        return (zzddi) super.submit(callable);
    }

    public /* synthetic */ Future submit(Runnable runnable, @NullableDecl Object obj) {
        return (zzddi) super.submit(runnable, obj);
    }
}
