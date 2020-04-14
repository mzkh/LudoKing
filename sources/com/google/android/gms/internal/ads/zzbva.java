package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbva {
    zzacn zzfly;
    zzaci zzflz;
    zzacz zzfma;
    zzacu zzfmb;
    zzagj zzfmc;
    final SimpleArrayMap<String, zzact> zzfmd = new SimpleArrayMap<>();
    final SimpleArrayMap<String, zzaco> zzfme = new SimpleArrayMap<>();

    public final zzbva zzb(zzacn zzacn) {
        this.zzfly = zzacn;
        return this;
    }

    public final zzbva zzb(zzaci zzaci) {
        this.zzflz = zzaci;
        return this;
    }

    public final zzbva zzb(zzacz zzacz) {
        this.zzfma = zzacz;
        return this;
    }

    public final zzbva zza(zzacu zzacu) {
        this.zzfmb = zzacu;
        return this;
    }

    public final zzbva zzb(zzagj zzagj) {
        this.zzfmc = zzagj;
        return this;
    }

    public final zzbva zzb(String str, zzact zzact, zzaco zzaco) {
        this.zzfmd.put(str, zzact);
        this.zzfme.put(str, zzaco);
        return this;
    }

    public final zzbuy zzail() {
        return new zzbuy(this);
    }
}
