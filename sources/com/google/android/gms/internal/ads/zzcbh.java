package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcbh implements zzdwb<zzbqs<zzbnb>> {
    private final zzdwo<Executor> zzfck;
    private final zzdwo<zzcbc> zzfcs;

    private zzcbh(zzdwo<zzcbc> zzdwo, zzdwo<Executor> zzdwo2) {
        this.zzfcs = zzdwo;
        this.zzfck = zzdwo2;
    }

    public static zzcbh zzx(zzdwo<zzcbc> zzdwo, zzdwo<Executor> zzdwo2) {
        return new zzcbh(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return (zzbqs) zzdwh.zza(new zzbqs((zzcbc) this.zzfcs.get(), (Executor) this.zzfck.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
