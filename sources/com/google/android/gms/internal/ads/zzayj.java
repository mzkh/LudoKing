package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzayj implements Runnable {
    private final /* synthetic */ zzayh zzdxr;

    zzayj(zzayh zzayh) {
        this.zzdxr = zzayh;
    }

    public final void run() {
        if (this.zzdxr.zzdxp != null) {
            this.zzdxr.zzdxp.zzel();
        }
    }
}
