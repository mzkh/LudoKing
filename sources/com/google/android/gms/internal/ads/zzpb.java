package com.google.android.gms.internal.ads;

import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzpb implements Runnable {
    private final /* synthetic */ zzov zzbjg;
    private final /* synthetic */ Surface zzbjj;

    zzpb(zzov zzov, Surface surface) {
        this.zzbjg = zzov;
        this.zzbjj = surface;
    }

    public final void run() {
        this.zzbjg.zzbjf.zzb(this.zzbjj);
    }
}
