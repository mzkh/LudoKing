package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbdl implements Runnable {
    private final zzbdm zzehz;

    zzbdl(zzbdm zzbdm) {
        this.zzehz = zzbdm;
    }

    public final void run() {
        zzbdm zzbdm = this.zzehz;
        zzbdm.zzeem.zzzy();
        zzc zzzl = zzbdm.zzeem.zzzl();
        if (zzzl != null) {
            zzzl.zzsq();
        }
    }
}
