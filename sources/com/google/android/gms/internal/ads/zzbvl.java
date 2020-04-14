package com.google.android.gms.internal.ads;

import android.view.ViewGroup;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbvl implements Runnable {
    private final zzbvj zzfmw;
    private final ViewGroup zzfnc;

    zzbvl(zzbvj zzbvj, ViewGroup viewGroup) {
        this.zzfmw = zzbvj;
        this.zzfnc = viewGroup;
    }

    public final void run() {
        this.zzfmw.zzb(this.zzfnc);
    }
}
