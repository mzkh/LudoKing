package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcsj implements zzdwb<zzcsi> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzatn> zzeqj;
    private final zzdwo<Executor> zzfck;
    private final zzdwo<ScheduledExecutorService> zzfoz;

    public zzcsj(zzdwo<zzatn> zzdwo, zzdwo<Context> zzdwo2, zzdwo<ScheduledExecutorService> zzdwo3, zzdwo<Executor> zzdwo4) {
        this.zzeqj = zzdwo;
        this.zzejy = zzdwo2;
        this.zzfoz = zzdwo3;
        this.zzfck = zzdwo4;
    }

    public final /* synthetic */ Object get() {
        return new zzcsi((zzatn) this.zzeqj.get(), (Context) this.zzejy.get(), (ScheduledExecutorService) this.zzfoz.get(), (Executor) this.zzfck.get());
    }
}
