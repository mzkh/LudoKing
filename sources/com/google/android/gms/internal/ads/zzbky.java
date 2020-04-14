package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbky implements zzdcz<zzbkq> {
    private final /* synthetic */ zzdcz zzffs;
    private final /* synthetic */ zzbkv zzfft;

    zzbky(zzbkv zzbkv, zzdcz zzdcz) {
        this.zzfft = zzbkv;
        this.zzffs = zzdcz;
    }

    public final void zzb(Throwable th) {
        this.zzffs.zzb(th);
        this.zzfft.zzafn();
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.zzfft.zza(((zzbkq) obj).zzffk, this.zzffs);
    }
}
