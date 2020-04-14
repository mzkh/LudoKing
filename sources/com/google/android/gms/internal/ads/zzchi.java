package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzchi implements zzdcz<zzbio> {
    private final /* synthetic */ zzchh zzfyd;

    zzchi(zzchh zzchh) {
        this.zzfyd = zzchh;
    }

    public final void zzb(Throwable th) {
        this.zzfyd.zzfht.onAdFailedToLoad(zzccu.zzd(th));
        zzcwj.zzc(th, "DelayedBannerAd.onFailure");
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        ((zzbio) obj).zzafa();
    }
}
