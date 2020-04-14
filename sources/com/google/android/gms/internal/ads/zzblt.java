package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzblt implements zzdwb<zzbqs<zzbrb>> {
    private final zzdwo<Executor> zzfck;
    private final zzdwo<zzbra> zzfdd;

    private zzblt(zzdwo<zzbra> zzdwo, zzdwo<Executor> zzdwo2) {
        this.zzfdd = zzdwo;
        this.zzfck = zzdwo2;
    }

    public static zzblt zzd(zzdwo<zzbra> zzdwo, zzdwo<Executor> zzdwo2) {
        return new zzblt(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return (zzbqs) zzdwh.zza(new zzbqs((zzbra) this.zzfdd.get(), (Executor) this.zzfck.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
