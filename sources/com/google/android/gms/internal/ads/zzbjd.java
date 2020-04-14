package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbjd implements zzdwb<zzbqs<zzbog>> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzaxl> zzfan;
    private final zzdwo<zzcvr> zzfcp;
    private final zzbiv zzfec;
    private final zzdwo<zzcwe> zzfef;

    public zzbjd(zzbiv zzbiv, zzdwo<Context> zzdwo, zzdwo<zzaxl> zzdwo2, zzdwo<zzcvr> zzdwo3, zzdwo<zzcwe> zzdwo4) {
        this.zzfec = zzbiv;
        this.zzejy = zzdwo;
        this.zzfan = zzdwo2;
        this.zzfcp = zzdwo3;
        this.zzfef = zzdwo4;
    }

    public static zzbqs<zzbog> zza(zzbiv zzbiv, Context context, zzaxl zzaxl, zzcvr zzcvr, zzcwe zzcwe) {
        return (zzbqs) zzdwh.zza(new zzbqs(new zzbiu(context, zzaxl, zzcvr, zzcwe), zzaxn.zzdwn), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfec, (Context) this.zzejy.get(), (zzaxl) this.zzfan.get(), (zzcvr) this.zzfcp.get(), (zzcwe) this.zzfef.get());
    }
}
