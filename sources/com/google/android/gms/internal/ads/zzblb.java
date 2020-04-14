package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzblb implements zzdcz<zzbkk> {
    private final /* synthetic */ zzdcz zzffs;
    private final /* synthetic */ zzbkv zzfft;

    zzblb(zzbkv zzbkv, zzdcz zzdcz) {
        this.zzfft = zzbkv;
        this.zzffs = zzdcz;
    }

    public final void zzb(Throwable th) {
        this.zzfft.zzafn();
        this.zzffs.zzb(th);
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzbkk zzbkk = (zzbkk) obj;
        this.zzfft.zzafn();
        this.zzffs.onSuccess(zzbkk);
    }
}
