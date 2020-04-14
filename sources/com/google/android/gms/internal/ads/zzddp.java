package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
class zzddp extends zzdcb {
    private final ExecutorService zzgrz;

    zzddp(ExecutorService executorService) {
        this.zzgrz = (ExecutorService) zzdaq.checkNotNull(executorService);
    }

    public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.zzgrz.awaitTermination(j, timeUnit);
    }

    public final boolean isShutdown() {
        return this.zzgrz.isShutdown();
    }

    public final boolean isTerminated() {
        return this.zzgrz.isTerminated();
    }

    public final void shutdown() {
        this.zzgrz.shutdown();
    }

    public final List<Runnable> shutdownNow() {
        return this.zzgrz.shutdownNow();
    }

    public final void execute(Runnable runnable) {
        this.zzgrz.execute(runnable);
    }
}
