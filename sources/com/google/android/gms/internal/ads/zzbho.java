package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbho implements zzdwb<zzbhf> {
    private final zzdwo<zzpe> zzfci;
    private final zzdwo<zzajc> zzfcj;
    private final zzdwo<Executor> zzfck;

    private zzbho(zzdwo<zzpe> zzdwo, zzdwo<zzajc> zzdwo2, zzdwo<Executor> zzdwo3) {
        this.zzfci = zzdwo;
        this.zzfcj = zzdwo2;
        this.zzfck = zzdwo3;
    }

    public static zzbho zzb(zzdwo<zzpe> zzdwo, zzdwo<zzajc> zzdwo2, zzdwo<Executor> zzdwo3) {
        return new zzbho(zzdwo, zzdwo2, zzdwo3);
    }

    public final /* synthetic */ Object get() {
        return (zzbhf) zzdwh.zza(new zzbhf(((zzpe) this.zzfci.get()).zzkf(), (zzajc) this.zzfcj.get(), (Executor) this.zzfck.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
