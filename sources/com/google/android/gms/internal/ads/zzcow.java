package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcow implements zzdwb<zzcos> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<Executor> zzfck;
    private final zzdwo<ScheduledExecutorService> zzfoz;

    private zzcow(zzdwo<Context> zzdwo, zzdwo<ScheduledExecutorService> zzdwo2, zzdwo<Executor> zzdwo3) {
        this.zzejy = zzdwo;
        this.zzfoz = zzdwo2;
        this.zzfck = zzdwo3;
    }

    public static zzcow zzo(zzdwo<Context> zzdwo, zzdwo<ScheduledExecutorService> zzdwo2, zzdwo<Executor> zzdwo3) {
        return new zzcow(zzdwo, zzdwo2, zzdwo3);
    }

    public final /* synthetic */ Object get() {
        return new zzcos((Context) this.zzejy.get(), (ScheduledExecutorService) this.zzfoz.get(), (Executor) this.zzfck.get());
    }
}
