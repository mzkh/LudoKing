package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbsb implements zzdwb<zzbqs<zzbog>> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzaxl> zzfan;
    private final zzdwo<zzcvr> zzfcp;
    private final zzdwo<zzcwe> zzfef;
    private final zzbrx zzfin;

    private zzbsb(zzbrx zzbrx, zzdwo<Context> zzdwo, zzdwo<zzaxl> zzdwo2, zzdwo<zzcvr> zzdwo3, zzdwo<zzcwe> zzdwo4) {
        this.zzfin = zzbrx;
        this.zzejy = zzdwo;
        this.zzfan = zzdwo2;
        this.zzfcp = zzdwo3;
        this.zzfef = zzdwo4;
    }

    public static zzbsb zza(zzbrx zzbrx, zzdwo<Context> zzdwo, zzdwo<zzaxl> zzdwo2, zzdwo<zzcvr> zzdwo3, zzdwo<zzcwe> zzdwo4) {
        zzbsb zzbsb = new zzbsb(zzbrx, zzdwo, zzdwo2, zzdwo3, zzdwo4);
        return zzbsb;
    }

    public final /* synthetic */ Object get() {
        return (zzbqs) zzdwh.zza(new zzbqs(new zzbrw((Context) this.zzejy.get(), (zzaxl) this.zzfan.get(), (zzcvr) this.zzfcp.get(), (zzcwe) this.zzfef.get()), zzaxn.zzdwn), "Cannot return null from a non-@Nullable @Provides method");
    }
}
