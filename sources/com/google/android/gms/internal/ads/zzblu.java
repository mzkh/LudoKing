package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzblu implements zzdwb<zzbqs<zzbnj>> {
    private final zzdwo<Executor> zzfck;
    private final zzdwo<zzbhd> zzfdd;

    private zzblu(zzdwo<zzbhd> zzdwo, zzdwo<Executor> zzdwo2) {
        this.zzfdd = zzdwo;
        this.zzfck = zzdwo2;
    }

    public static zzblu zze(zzdwo<zzbhd> zzdwo, zzdwo<Executor> zzdwo2) {
        return new zzblu(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return (zzbqs) zzdwh.zza(new zzbqs((zzbhd) this.zzfdd.get(), (Executor) this.zzfck.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
