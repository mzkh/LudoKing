package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzddw<V> extends zzdcv<V> implements RunnableFuture<V> {
    private volatile zzddh<?> zzgsf;

    static <V> zzddw<V> zze(Callable<V> callable) {
        return new zzddw<>(callable);
    }

    static <V> zzddw<V> zza(Runnable runnable, @NullableDecl V v) {
        return new zzddw<>(Executors.callable(runnable, v));
    }

    private zzddw(Callable<V> callable) {
        this.zzgsf = new zzddz(this, callable);
    }

    public final void run() {
        zzddh<?> zzddh = this.zzgsf;
        if (zzddh != null) {
            zzddh.run();
        }
        this.zzgsf = null;
    }

    /* access modifiers changed from: protected */
    public final void afterDone() {
        super.afterDone();
        if (wasInterrupted()) {
            zzddh<?> zzddh = this.zzgsf;
            if (zzddh != null) {
                zzddh.interruptTask();
            }
        }
        this.zzgsf = null;
    }

    /* access modifiers changed from: protected */
    public final String pendingToString() {
        zzddh<?> zzddh = this.zzgsf;
        if (zzddh == null) {
            return super.pendingToString();
        }
        String valueOf = String.valueOf(zzddh);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 7);
        sb.append("task=[");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }
}
