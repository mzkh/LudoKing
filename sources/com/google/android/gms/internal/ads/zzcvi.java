package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcvi implements zzcms<zzbyz> {
    private final /* synthetic */ zzcvf zzgir;

    zzcvi(zzcvf zzcvf) {
        this.zzgir = zzcvf;
    }

    public final void zzalq() {
        synchronized (this.zzgir) {
            this.zzgir.zzgil = null;
        }
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzbyz zzbyz = (zzbyz) obj;
        synchronized (this.zzgir) {
            this.zzgir.zzgil = zzbyz;
            this.zzgir.zzgil.zzafa();
        }
    }
}
