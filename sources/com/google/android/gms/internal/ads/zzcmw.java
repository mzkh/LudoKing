package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcmw implements zzdcz<zzbkk> {
    private final /* synthetic */ zzcms zzgdg;
    private final /* synthetic */ zzbtl zzgdh;
    private final /* synthetic */ zzcmu zzgdi;

    zzcmw(zzcmu zzcmu, zzcms zzcms, zzbtl zzbtl) {
        this.zzgdi = zzcmu;
        this.zzgdg = zzcms;
        this.zzgdh = zzbtl;
    }

    public final void zzb(Throwable th) {
        this.zzgdh.zzacb().onAdFailedToLoad(zzccu.zzd(th));
        zzcwj.zzc(th, "NativeAdLoader.onFailure");
        this.zzgdg.zzalq();
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzbkk zzbkk = (zzbkk) obj;
        synchronized (this.zzgdi) {
            this.zzgdg.onSuccess(zzbkk);
        }
    }
}
