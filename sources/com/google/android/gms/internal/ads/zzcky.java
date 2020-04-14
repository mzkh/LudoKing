package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcky implements zzdwb<zzcks> {
    private final zzdwo<zzddl> zzfdx;
    private final zzdwo<zzcyg> zzfek;
    private final zzdwo<zzbjn> zzfxj;
    private final zzdwo<Context> zzgas;
    private final zzdwo<zzaah> zzgat;

    public zzcky(zzdwo<Context> zzdwo, zzdwo<zzbjn> zzdwo2, zzdwo<zzcyg> zzdwo3, zzdwo<zzddl> zzdwo4, zzdwo<zzaah> zzdwo5) {
        this.zzgas = zzdwo;
        this.zzfxj = zzdwo2;
        this.zzfek = zzdwo3;
        this.zzfdx = zzdwo4;
        this.zzgat = zzdwo5;
    }

    public final /* synthetic */ Object get() {
        zzcks zzcks = new zzcks((Context) this.zzgas.get(), (zzbjn) this.zzfxj.get(), (zzcyg) this.zzfek.get(), (zzddl) this.zzfdx.get(), (zzaah) this.zzgat.get());
        return zzcks;
    }
}
