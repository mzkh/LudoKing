package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcxl implements zzdwb<ScheduledExecutorService> {
    private final zzdwo<ThreadFactory> zzgli;

    public zzcxl(zzdwo<ThreadFactory> zzdwo) {
        this.zzgli = zzdwo;
    }

    public final /* synthetic */ Object get() {
        return (ScheduledExecutorService) zzdwh.zza(new ScheduledThreadPoolExecutor(1, (ThreadFactory) this.zzgli.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
