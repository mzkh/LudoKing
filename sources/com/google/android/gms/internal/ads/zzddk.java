package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzddk {
    public static Executor zzapk() {
        return zzdcq.INSTANCE;
    }

    public static zzddl zza(ExecutorService executorService) {
        if (executorService instanceof zzddl) {
            return (zzddl) executorService;
        }
        if (executorService instanceof ScheduledExecutorService) {
            return new zzddo((ScheduledExecutorService) executorService);
        }
        return new zzddp(executorService);
    }

    static Executor zza(Executor executor, zzdby<?> zzdby) {
        zzdaq.checkNotNull(executor);
        zzdaq.checkNotNull(zzdby);
        if (executor == zzdcq.INSTANCE) {
            return executor;
        }
        return new zzddn(executor, zzdby);
    }
}
