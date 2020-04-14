package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
abstract class zzdde<V> implements zzddi<V> {
    private static final Logger zzgqc = Logger.getLogger(zzdde.class.getName());

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    static class zza<V> extends zzdde<V> {
        static final zza<Object> zzgrp = new zza<>(null);
        @NullableDecl
        private final V value;

        zza(@NullableDecl V v) {
            this.value = v;
        }

        public final V get() {
            return this.value;
        }

        public final String toString() {
            String obj = super.toString();
            String valueOf = String.valueOf(this.value);
            StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 27 + String.valueOf(valueOf).length());
            sb.append(obj);
            sb.append("[status=SUCCESS, result=[");
            sb.append(valueOf);
            sb.append("]]");
            return sb.toString();
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    static final class zzb<V> extends zzj<V> {
        zzb(Throwable th) {
            setException(th);
        }
    }

    zzdde() {
    }

    public boolean cancel(boolean z) {
        return false;
    }

    public abstract V get() throws ExecutionException;

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    public void addListener(Runnable runnable, Executor executor) {
        zzdaq.checkNotNull(runnable, "Runnable was null.");
        zzdaq.checkNotNull(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = zzgqc;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57 + String.valueOf(valueOf2).length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(valueOf);
            sb.append(" with executor ");
            sb.append(valueOf2);
            logger.logp(level, "com.google.common.util.concurrent.ImmediateFuture", "addListener", sb.toString(), e);
        }
    }

    public V get(long j, TimeUnit timeUnit) throws ExecutionException {
        zzdaq.checkNotNull(timeUnit);
        return get();
    }
}
