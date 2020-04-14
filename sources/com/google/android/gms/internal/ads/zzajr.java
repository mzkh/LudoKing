package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final /* synthetic */ class zzajr implements Runnable {
    private final Context zzcfb;
    private final zzajp zzdbs;

    zzajr(zzajp zzajp, Context context) {
        this.zzdbs = zzajp;
        this.zzcfb = context;
    }

    public final void run() {
        zzajp.zzo(this.zzcfb);
    }
}
