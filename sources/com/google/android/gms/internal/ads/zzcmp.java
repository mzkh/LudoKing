package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcmp implements zzcms<zzbkk> {
    private final /* synthetic */ zzcmm zzgda;

    zzcmp(zzcmm zzcmm) {
        this.zzgda = zzcmm;
    }

    public final void zzalq() {
        synchronized (this.zzgda) {
            this.zzgda.zzadc = false;
        }
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzbkk zzbkk = (zzbkk) obj;
        synchronized (this.zzgda) {
            this.zzgda.zzadc = false;
            this.zzgda.zzgct = zzbkk.getMediationAdapterClassName();
            this.zzgda.zzgcu = zzbkk.zzju();
            zzbkk.zzafa();
        }
    }
}
