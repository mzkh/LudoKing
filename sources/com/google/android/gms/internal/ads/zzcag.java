package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcag implements zzdwb<zzbqs<zztp>> {
    private final zzdwo<Executor> zzfck;
    private final zzdwo<zzcaq> zzfcs;

    private zzcag(zzdwo<zzcaq> zzdwo, zzdwo<Executor> zzdwo2) {
        this.zzfcs = zzdwo;
        this.zzfck = zzdwo2;
    }

    public static zzcag zzl(zzdwo<zzcaq> zzdwo, zzdwo<Executor> zzdwo2) {
        return new zzcag(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return (zzbqs) zzdwh.zza(new zzbqs((zzcaq) this.zzfcs.get(), (Executor) this.zzfck.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
