package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzpc implements Runnable {
    private final /* synthetic */ zzov zzbjg;
    private final /* synthetic */ int zzbjk;
    private final /* synthetic */ int zzbjl;
    private final /* synthetic */ int zzbjm;
    private final /* synthetic */ float zzbjn;

    zzpc(zzov zzov, int i, int i2, int i3, float f) {
        this.zzbjg = zzov;
        this.zzbjk = i;
        this.zzbjl = i2;
        this.zzbjm = i3;
        this.zzbjn = f;
    }

    public final void run() {
        this.zzbjg.zzbjf.zzb(this.zzbjk, this.zzbjl, this.zzbjm, this.zzbjn);
    }
}
