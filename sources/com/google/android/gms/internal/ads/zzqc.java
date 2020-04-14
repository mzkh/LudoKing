package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzqc implements Runnable {
    private final /* synthetic */ zzpz zzbpy;
    private final /* synthetic */ View zzbpz;

    zzqc(zzpz zzpz, View view) {
        this.zzbpy = zzpz;
        this.zzbpz = view;
    }

    public final void run() {
        this.zzbpy.zzi(this.zzbpz);
    }
}
