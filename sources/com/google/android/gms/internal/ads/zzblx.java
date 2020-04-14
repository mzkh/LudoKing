package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzblx implements zzdwb<zzbqs<zzbog>> {
    private final zzdwo<Executor> zzfck;
    private final zzdwo<zzbhd> zzfdd;

    private zzblx(zzdwo<zzbhd> zzdwo, zzdwo<Executor> zzdwo2) {
        this.zzfdd = zzdwo;
        this.zzfck = zzdwo2;
    }

    public static zzblx zzg(zzdwo<zzbhd> zzdwo, zzdwo<Executor> zzdwo2) {
        return new zzblx(zzdwo, zzdwo2);
    }

    public static zzbqs<zzbog> zza(zzbhd zzbhd, Executor executor) {
        return (zzbqs) zzdwh.zza(new zzbqs(zzbhd, executor), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza((zzbhd) this.zzfdd.get(), (Executor) this.zzfck.get());
    }
}
