package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbyd implements zzdwb<zzbyb> {
    private final zzdwo<zzbvj> zzeti;
    private final zzdwo<Context> zzfgo;
    private final zzdwo<zzbur> zzfkg;
    private final zzdwo<zzbuj> zzfpj;

    private zzbyd(zzdwo<Context> zzdwo, zzdwo<zzbur> zzdwo2, zzdwo<zzbvj> zzdwo3, zzdwo<zzbuj> zzdwo4) {
        this.zzfgo = zzdwo;
        this.zzfkg = zzdwo2;
        this.zzeti = zzdwo3;
        this.zzfpj = zzdwo4;
    }

    public static zzbyd zzb(zzdwo<Context> zzdwo, zzdwo<zzbur> zzdwo2, zzdwo<zzbvj> zzdwo3, zzdwo<zzbuj> zzdwo4) {
        return new zzbyd(zzdwo, zzdwo2, zzdwo3, zzdwo4);
    }

    public final /* synthetic */ Object get() {
        return new zzbyb((Context) this.zzfgo.get(), (zzbur) this.zzfkg.get(), (zzbvj) this.zzeti.get(), (zzbuj) this.zzfpj.get());
    }
}
