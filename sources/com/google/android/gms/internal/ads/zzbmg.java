package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbmg implements zzdwb<zzdal<zzcvr, zzavd>> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzaxl> zzfan;
    private final zzdwo<zzcwe> zzfef;

    public zzbmg(zzdwo<Context> zzdwo, zzdwo<zzaxl> zzdwo2, zzdwo<zzcwe> zzdwo3) {
        this.zzejy = zzdwo;
        this.zzfan = zzdwo2;
        this.zzfef = zzdwo3;
    }

    public final /* synthetic */ Object get() {
        return (zzdal) zzdwh.zza(new zzbmh((Context) this.zzejy.get(), (zzaxl) this.zzfan.get(), (zzcwe) this.zzfef.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
