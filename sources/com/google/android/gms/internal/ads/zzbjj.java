package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbjj implements zzdwb<zzbqs<zzpj>> {
    private final zzdwo<Executor> zzfck;
    private final zzdwo<zzbkj> zzfdd;
    private final zzbiv zzfec;

    public zzbjj(zzbiv zzbiv, zzdwo<zzbkj> zzdwo, zzdwo<Executor> zzdwo2) {
        this.zzfec = zzbiv;
        this.zzfdd = zzdwo;
        this.zzfck = zzdwo2;
    }

    public final /* synthetic */ Object get() {
        return (zzbqs) zzdwh.zza(new zzbqs((zzbkj) this.zzfdd.get(), (Executor) this.zzfck.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
