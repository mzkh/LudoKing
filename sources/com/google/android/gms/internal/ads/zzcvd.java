package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcvd implements zzdcz<zzbyz> {
    private final /* synthetic */ zzcms zzgdg;
    private final /* synthetic */ zzcvb zzgih;

    zzcvd(zzcvb zzcvb, zzcms zzcms) {
        this.zzgih = zzcvb;
        this.zzgdg = zzcms;
    }

    public final void zzb(Throwable th) {
        synchronized (this.zzgih) {
            ((zzbzc) this.zzgih.zzgie.zzamt()).zzacb().onAdFailedToLoad(zzccu.zzd(th));
            zzcwj.zzc(th, "RewardedAdLoader.onFailure");
            this.zzgdg.zzalq();
        }
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzbyz zzbyz = (zzbyz) obj;
        synchronized (this.zzgih) {
            this.zzgdg.onSuccess(zzbyz);
            this.zzgih.zzgid.onAdMetadataChanged();
        }
    }
}
