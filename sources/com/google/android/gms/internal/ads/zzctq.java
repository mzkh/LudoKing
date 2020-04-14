package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzctq implements zzdwb<zzcto> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzanu> zzeqj;
    private final zzdwo<ScheduledExecutorService> zzfoz;

    public zzctq(zzdwo<zzanu> zzdwo, zzdwo<ScheduledExecutorService> zzdwo2, zzdwo<Context> zzdwo3) {
        this.zzeqj = zzdwo;
        this.zzfoz = zzdwo2;
        this.zzejy = zzdwo3;
    }

    public final /* synthetic */ Object get() {
        return new zzcto((zzanu) this.zzeqj.get(), (ScheduledExecutorService) this.zzfoz.get(), (Context) this.zzejy.get());
    }
}
