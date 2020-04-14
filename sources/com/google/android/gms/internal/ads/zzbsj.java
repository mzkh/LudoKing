package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbsj implements zzdwb<zzbqs<zzbna>> {
    private final zzdwo<Executor> zzfck;
    private final zzdwo<zzbtd> zzfdd;
    private final zzbrx zzfin;

    private zzbsj(zzbrx zzbrx, zzdwo<zzbtd> zzdwo, zzdwo<Executor> zzdwo2) {
        this.zzfin = zzbrx;
        this.zzfdd = zzdwo;
        this.zzfck = zzdwo2;
    }

    public static zzbsj zzb(zzbrx zzbrx, zzdwo<zzbtd> zzdwo, zzdwo<Executor> zzdwo2) {
        return new zzbsj(zzbrx, zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return (zzbqs) zzdwh.zza(new zzbqs((zzbtd) this.zzfdd.get(), (Executor) this.zzfck.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
