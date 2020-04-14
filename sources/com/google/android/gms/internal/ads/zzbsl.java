package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbsl implements zzdwb<zzbqs<zzbpg>> {
    private final zzdwo<Executor> zzfck;
    private final zzbrx zzfin;

    private zzbsl(zzbrx zzbrx, zzdwo<Executor> zzdwo) {
        this.zzfin = zzbrx;
        this.zzfck = zzdwo;
    }

    public static zzbsl zzd(zzbrx zzbrx, zzdwo<Executor> zzdwo) {
        return new zzbsl(zzbrx, zzdwo);
    }

    public final /* synthetic */ Object get() {
        return (zzbqs) zzdwh.zza(this.zzfin.zzb((Executor) this.zzfck.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
