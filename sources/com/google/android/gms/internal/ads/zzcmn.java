package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcmn implements zzdcz<zzbrs> {
    private final /* synthetic */ zzbso zzgcv;
    private final /* synthetic */ zzcmk zzgcw;

    zzcmn(zzcmk zzcmk, zzbso zzbso) {
        this.zzgcw = zzcmk;
        this.zzgcv = zzbso;
    }

    public final void zzb(Throwable th) {
        synchronized (this.zzgcw) {
            this.zzgcw.zzgbz = null;
            this.zzgcv.zzacb().onAdFailedToLoad(zzccu.zzd(th));
            zzcwj.zzc(th, "InterstitialAdManagerShim.onFailure");
        }
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzbrs zzbrs = (zzbrs) obj;
        synchronized (this.zzgcw) {
            this.zzgcw.zzgbz = null;
            this.zzgcw.zzgcp = zzbrs;
            zzbrs.zzafa();
        }
    }
}
