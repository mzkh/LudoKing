package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbmc implements zzdwb<zzbmd> {
    private final zzdwo<zzccj> zzeks;
    private final zzdwo<zzaui> zzemh;
    private final zzdwo<zzaxl> zzfcq;
    private final zzdwo<zzcwe> zzfef;
    private final zzdwo<Context> zzfgo;

    private zzbmc(zzdwo<Context> zzdwo, zzdwo<zzcwe> zzdwo2, zzdwo<zzaxl> zzdwo3, zzdwo<zzaui> zzdwo4, zzdwo<zzccj> zzdwo5) {
        this.zzfgo = zzdwo;
        this.zzfef = zzdwo2;
        this.zzfcq = zzdwo3;
        this.zzemh = zzdwo4;
        this.zzeks = zzdwo5;
    }

    public static zzbmc zzc(zzdwo<Context> zzdwo, zzdwo<zzcwe> zzdwo2, zzdwo<zzaxl> zzdwo3, zzdwo<zzaui> zzdwo4, zzdwo<zzccj> zzdwo5) {
        zzbmc zzbmc = new zzbmc(zzdwo, zzdwo2, zzdwo3, zzdwo4, zzdwo5);
        return zzbmc;
    }

    public final /* synthetic */ Object get() {
        zzbmd zzbmd = new zzbmd((Context) this.zzfgo.get(), (zzcwe) this.zzfef.get(), (zzaxl) this.zzfcq.get(), (zzaui) this.zzemh.get(), (zzccj) this.zzeks.get());
        return zzbmd;
    }
}
