package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcfc implements zzdwb<zzbqs<zzbnb>> {
    private final zzdwo<Executor> zzfck;
    private final zzdwo<zzcfn> zzfcs;

    private zzcfc(zzdwo<zzcfn> zzdwo, zzdwo<Executor> zzdwo2) {
        this.zzfcs = zzdwo;
        this.zzfck = zzdwo2;
    }

    public static zzcfc zzaf(zzdwo<zzcfn> zzdwo, zzdwo<Executor> zzdwo2) {
        return new zzcfc(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return (zzbqs) zzdwh.zza(new zzbqs((zzcfn) this.zzfcs.get(), (Executor) this.zzfck.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
