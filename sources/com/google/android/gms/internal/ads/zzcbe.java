package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcbe implements zzdwb<zzbqs<zzbpc>> {
    private final zzdwo<Executor> zzfck;
    private final zzdwo<zzcbc> zzfcs;

    private zzcbe(zzdwo<zzcbc> zzdwo, zzdwo<Executor> zzdwo2) {
        this.zzfcs = zzdwo;
        this.zzfck = zzdwo2;
    }

    public static zzcbe zzu(zzdwo<zzcbc> zzdwo, zzdwo<Executor> zzdwo2) {
        return new zzcbe(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return (zzbqs) zzdwh.zza(new zzbqs((zzcbc) this.zzfcs.get(), (Executor) this.zzfck.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
