package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzclz implements zzdwb<zzclw> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzcwe> zzfef;
    private final zzdwo<zzuy> zzgbs;
    private final zzdwo<zzbio> zzgbt;

    public zzclz(zzdwo<Context> zzdwo, zzdwo<zzuy> zzdwo2, zzdwo<zzcwe> zzdwo3, zzdwo<zzbio> zzdwo4) {
        this.zzejy = zzdwo;
        this.zzgbs = zzdwo2;
        this.zzfef = zzdwo3;
        this.zzgbt = zzdwo4;
    }

    public final /* synthetic */ Object get() {
        return new zzclw((Context) this.zzejy.get(), (zzuy) this.zzgbs.get(), (zzcwe) this.zzfef.get(), (zzbio) this.zzgbt.get());
    }
}
