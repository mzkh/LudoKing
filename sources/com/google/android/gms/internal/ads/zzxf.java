package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final /* synthetic */ class zzxf implements Runnable {
    private final zzxc zzcez;
    private final Context zzcfb;

    zzxf(zzxc zzxc, Context context) {
        this.zzcez = zzxc;
        this.zzcfb = context;
    }

    public final void run() {
        this.zzcez.getRewardedVideoAdInstance(this.zzcfb);
    }
}
