package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcyb implements zzdcz<O> {
    private final /* synthetic */ zzcxp zzglw;
    private final /* synthetic */ zzcxy zzglx;

    zzcyb(zzcxy zzcxy, zzcxp zzcxp) {
        this.zzglx = zzcxy;
        this.zzglw = zzcxp;
    }

    public final void onSuccess(O o) {
        this.zzglx.zzglr.zzglp.zzc(this.zzglw);
    }

    public final void zzb(Throwable th) {
        this.zzglx.zzglr.zzglp.zza(this.zzglw, th);
    }
}
