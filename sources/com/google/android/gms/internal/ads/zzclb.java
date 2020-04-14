package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzclb<AdT> implements zzcga<AdT> {
    private final zzcyg zzfgb;
    private final zzddl zzgag;
    @Nullable
    private final zzaah zzgam;
    /* access modifiers changed from: private */
    public final zzclc<AdT> zzgav;

    public zzclb(zzcyg zzcyg, zzddl zzddl, @Nullable zzaah zzaah, zzclc<AdT> zzclc) {
        this.zzfgb = zzcyg;
        this.zzgag = zzddl;
        this.zzgam = zzaah;
        this.zzgav = zzclc;
    }

    public final boolean zza(zzcvz zzcvz, zzcvr zzcvr) {
        return (this.zzgam == null || zzcvr.zzgje == null || zzcvr.zzgje.zzdib == null) ? false : true;
    }

    public final zzddi<AdT> zzb(zzcvz zzcvz, zzcvr zzcvr) {
        zzaxv zzaxv = new zzaxv();
        zzclj zzclj = new zzclj();
        zzcld zzcld = new zzcld(this, zzaxv, zzcvz, zzcvr, zzclj);
        zzclj.zza(zzcld);
        return this.zzfgb.zzu(zzcyd.CUSTOM_RENDER_SYN).zza((zzcxq) new zzcla(this, new zzaaa(zzclj, zzcvr.zzgje.zzdhz, zzcvr.zzgje.zzdib)), this.zzgag).zzw(zzcyd.CUSTOM_RENDER_ACK).zzb((zzddi<O2>) zzaxv).zzant();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzb(zzaaa zzaaa) throws Exception {
        this.zzgam.zza(zzaaa);
    }
}
