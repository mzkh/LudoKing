package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcly extends zzvh {
    private zzuy zzblp;
    private final zzbei zzfza;
    private final Context zzgbp;
    @VisibleForTesting
    private final zzcwg zzgbq = new zzcwg();
    @VisibleForTesting
    private final zzbva zzgbr = new zzbva();

    public zzcly(zzbei zzbei, Context context, String str) {
        this.zzfza = zzbei;
        this.zzgbq.zzgf(str);
        this.zzgbp = context;
    }

    public final zzvd zzor() {
        zzbuy zzail = this.zzgbr.zzail();
        this.zzgbq.zzb(zzail.zzaij());
        this.zzgbq.zzc(zzail.zzaik());
        zzcwg zzcwg = this.zzgbq;
        if (zzcwg.zzjt() == null) {
            zzcwg.zzd(zzua.zzg(this.zzgbp));
        }
        zzcmb zzcmb = new zzcmb(this.zzgbp, this.zzfza, this.zzgbq, zzail, this.zzblp);
        return zzcmb;
    }

    public final void zzb(zzuy zzuy) {
        this.zzblp = zzuy;
    }

    public final void zza(zzaci zzaci) {
        this.zzgbr.zzb(zzaci);
    }

    public final void zza(zzacz zzacz) {
        this.zzgbr.zzb(zzacz);
    }

    public final void zza(zzacn zzacn) {
        this.zzgbr.zzb(zzacn);
    }

    public final void zza(String str, zzact zzact, zzaco zzaco) {
        this.zzgbr.zzb(str, zzact, zzaco);
    }

    public final void zza(zzaay zzaay) {
        this.zzgbq.zzb(zzaay);
    }

    public final void zza(zzagd zzagd) {
        this.zzgbq.zzb(zzagd);
    }

    public final void zza(zzagj zzagj) {
        this.zzgbr.zzb(zzagj);
    }

    public final void zzb(zzvz zzvz) {
        this.zzgbq.zzc(zzvz);
    }

    public final void zza(zzacu zzacu, zzua zzua) {
        this.zzgbr.zza(zzacu);
        this.zzgbq.zzd(zzua);
    }

    public final void zza(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzgbq.zzb(publisherAdViewOptions);
    }
}
