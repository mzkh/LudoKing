package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzddo extends zzddp implements zzddl, ScheduledExecutorService {
    private final ScheduledExecutorService zzgry;

    zzddo(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.zzgry = (ScheduledExecutorService) zzdaq.checkNotNull(scheduledExecutorService);
    }

    public final /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzddq zzddq = new zzddq(runnable);
        return new zzddr(zzddq, this.zzgry.scheduleWithFixedDelay(zzddq, j, j2, timeUnit));
    }

    public final /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzddq zzddq = new zzddq(runnable);
        return new zzddr(zzddq, this.zzgry.scheduleAtFixedRate(zzddq, j, j2, timeUnit));
    }

    public final /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        zzddw zze = zzddw.zze(callable);
        return new zzddr(zze, this.zzgry.schedule(zze, j, timeUnit));
    }

    public final /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        zzddw zza = zzddw.zza(runnable, null);
        return new zzddr(zza, this.zzgry.schedule(zza, j, timeUnit));
    }
}
