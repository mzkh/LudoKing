package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbby implements Runnable {
    private final zzbbv zzefb;

    zzbby(zzbbv zzbbv) {
        this.zzefb = zzbbv;
    }

    public final void run() {
        zzbbv zzbbv = this.zzefb;
        zzbbv.zzeem.zzzy();
        zzc zzzl = zzbbv.zzeem.zzzl();
        if (zzzl != null) {
            zzzl.zzsq();
        }
    }
}
