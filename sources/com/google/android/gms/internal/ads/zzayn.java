package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzayn implements Runnable {
    private final /* synthetic */ zzayh zzdxr;
    private final /* synthetic */ int zzdxv;
    private final /* synthetic */ int zzdxw;

    zzayn(zzayh zzayh, int i, int i2) {
        this.zzdxr = zzayh;
        this.zzdxv = i;
        this.zzdxw = i2;
    }

    public final void run() {
        if (this.zzdxr.zzdxp != null) {
            this.zzdxr.zzdxp.zzj(this.zzdxv, this.zzdxw);
        }
    }
}
