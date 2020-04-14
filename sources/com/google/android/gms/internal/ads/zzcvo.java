package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcvo implements zzcms<zzbyz> {
    private final /* synthetic */ zzcvl zzgiw;

    zzcvo(zzcvl zzcvl) {
        this.zzgiw = zzcvl;
    }

    public final void zzalq() {
        synchronized (this.zzgiw) {
            this.zzgiw.zzgil = null;
        }
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzbyz zzbyz = (zzbyz) obj;
        synchronized (this.zzgiw) {
            this.zzgiw.zzgil = zzbyz;
            this.zzgiw.zzgil.zzafa();
        }
    }
}
