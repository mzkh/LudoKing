package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcfe implements zzdwb<zzbqs<zzcym>> {
    private final zzdwo<Executor> zzfck;
    private final zzdwo<zzcfr> zzfcs;

    private zzcfe(zzdwo<zzcfr> zzdwo, zzdwo<Executor> zzdwo2) {
        this.zzfcs = zzdwo;
        this.zzfck = zzdwo2;
    }

    public static zzcfe zzag(zzdwo<zzcfr> zzdwo, zzdwo<Executor> zzdwo2) {
        return new zzcfe(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return (zzbqs) zzdwh.zza(new zzbqs((zzcfr) this.zzfcs.get(), (Executor) this.zzfck.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
