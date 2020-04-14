package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbha implements zzbnb {
    private final zzcvt zzfbc;
    private final zzcvz zzfbd;
    private final zzcyp zzfbe;

    public zzbha(zzcvz zzcvz, zzcyp zzcyp) {
        this.zzfbd = zzcvz;
        this.zzfbe = zzcyp;
        this.zzfbc = zzcvz.zzgkb.zzgjy;
    }

    public final void onAdFailedToLoad(int i) {
        this.zzfbe.zza(this.zzfbd, null, this.zzfbc.zzdcb);
    }
}
