package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzblv implements zzdwb<zzbqs<zzbna>> {
    private final zzdwo<Executor> zzfck;
    private final zzdwo<zzbhd> zzfdd;

    private zzblv(zzdwo<zzbhd> zzdwo, zzdwo<Executor> zzdwo2) {
        this.zzfdd = zzdwo;
        this.zzfck = zzdwo2;
    }

    public static zzblv zzf(zzdwo<zzbhd> zzdwo, zzdwo<Executor> zzdwo2) {
        return new zzblv(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return (zzbqs) zzdwh.zza(new zzbqs((zzbhd) this.zzfdd.get(), (Executor) this.zzfck.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
