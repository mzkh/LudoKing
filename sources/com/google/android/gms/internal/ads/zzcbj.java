package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcbj implements zzdwb<zzbqs<zzcym>> {
    private final zzdwo<Executor> zzfck;
    private final zzdwo<zzcbn> zzfcs;

    private zzcbj(zzdwo<zzcbn> zzdwo, zzdwo<Executor> zzdwo2) {
        this.zzfcs = zzdwo;
        this.zzfck = zzdwo2;
    }

    public static zzcbj zzy(zzdwo<zzcbn> zzdwo, zzdwo<Executor> zzdwo2) {
        return new zzcbj(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return (zzbqs) zzdwh.zza(new zzbqs((zzcbn) this.zzfcs.get(), (Executor) this.zzfck.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
