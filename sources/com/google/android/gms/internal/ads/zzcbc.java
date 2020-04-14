package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcbc implements zzbnb, zzbog, zzbpc {
    private final zzcbl zzfru;
    private final zzcbo zzfrv;

    public zzcbc(zzcbl zzcbl, zzcbo zzcbo) {
        this.zzfru = zzcbl;
        this.zzfrv = zzcbo;
    }

    public final void onAdLoaded() {
        this.zzfrv.zzm(this.zzfru.zzqd());
    }

    public final void onAdFailedToLoad(int i) {
        this.zzfrv.zzm(this.zzfru.zzqd());
    }

    public final void zzb(zzape zzape) {
        this.zzfru.zzi(zzape.zzdma);
    }

    public final void zza(zzcvz zzcvz) {
        this.zzfru.zzb(zzcvz);
    }
}
