package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
abstract class zzdco<T> extends zzddh<T> {
    private final Executor zzgre;
    boolean zzgrf = true;
    private final /* synthetic */ zzdcm zzgrg;

    public zzdco(zzdcm zzdcm, Executor executor) {
        this.zzgrg = zzdcm;
        this.zzgre = (Executor) zzdaq.checkNotNull(executor);
    }

    /* access modifiers changed from: 0000 */
    public abstract void setValue(T t);

    /* access modifiers changed from: 0000 */
    public final boolean isDone() {
        return this.zzgrg.isDone();
    }

    /* access modifiers changed from: 0000 */
    public final void execute() {
        try {
            this.zzgre.execute(this);
        } catch (RejectedExecutionException e) {
            if (this.zzgrf) {
                this.zzgrg.setException(e);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(T t, Throwable th) {
        if (th == null) {
            setValue(t);
        } else if (th instanceof ExecutionException) {
            this.zzgrg.setException(th.getCause());
        } else if (th instanceof CancellationException) {
            this.zzgrg.cancel(false);
        } else {
            this.zzgrg.setException(th);
        }
    }
}
