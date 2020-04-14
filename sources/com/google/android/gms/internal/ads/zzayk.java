package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzayk implements Runnable {
    private final int zzdtk;
    private final zzayh zzdxs;

    zzayk(zzayh zzayh, int i) {
        this.zzdxs = zzayh;
        this.zzdtk = i;
    }

    public final void run() {
        this.zzdxs.zzcr(this.zzdtk);
    }
}
