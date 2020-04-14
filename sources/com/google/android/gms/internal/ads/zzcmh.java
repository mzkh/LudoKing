package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcmh implements zzdcz<zzbio> {
    private final /* synthetic */ zzbjn zzgck;
    private final /* synthetic */ zzcme zzgcl;

    zzcmh(zzcme zzcme, zzbjn zzbjn) {
        this.zzgcl = zzcme;
        this.zzgck = zzbjn;
    }

    public final void zzb(Throwable th) {
        synchronized (this.zzgcl) {
            this.zzgcl.zzgbz = null;
            this.zzgck.zzacb().onAdFailedToLoad(zzccu.zzd(th));
            this.zzgcl.zzgcf.zzdd(60);
            zzcwj.zzc(th, "BannerAdManagerShim.onFailure");
        }
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzbio zzbio = (zzbio) obj;
        synchronized (this.zzgcl) {
            this.zzgcl.zzgbz = null;
            if (this.zzgcl.zzgbk != null) {
                this.zzgcl.zzgbk.destroy();
            }
            this.zzgcl.zzgbk = zzbio;
            this.zzgcl.zzfdl.removeAllViews();
            this.zzgcl.zzfdl.addView(zzbio.zzaeu());
            zzbio.zzafa();
            this.zzgcl.zzgcf.zzdd(zzbio.zzaez());
        }
    }
}
