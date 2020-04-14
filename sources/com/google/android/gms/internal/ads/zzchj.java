package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzchj implements Runnable {
    private final zzcvr zzfea;
    private final zzcvz zzfom;
    private final zzchh zzfya;

    zzchj(zzchh zzchh, zzcvz zzcvz, zzcvr zzcvr) {
        this.zzfya = zzchh;
        this.zzfom = zzcvz;
        this.zzfea = zzcvr;
    }

    public final void run() {
        this.zzfya.zzd(this.zzfom, this.zzfea);
    }
}
