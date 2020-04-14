package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzddn implements Executor {
    boolean zzgrv = true;
    private final /* synthetic */ Executor zzgrw;
    private final /* synthetic */ zzdby zzgrx;

    zzddn(Executor executor, zzdby zzdby) {
        this.zzgrw = executor;
        this.zzgrx = zzdby;
    }

    public final void execute(Runnable runnable) {
        try {
            this.zzgrw.execute(new zzddm(this, runnable));
        } catch (RejectedExecutionException e) {
            if (this.zzgrv) {
                this.zzgrx.setException(e);
            }
        }
    }
}
