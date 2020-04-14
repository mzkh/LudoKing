package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final /* synthetic */ class zzajo implements Runnable {
    private final Context zzcfb;
    private final zzajp zzdbs;
    private final String zzdbt;

    zzajo(zzajp zzajp, Context context, String str) {
        this.zzdbs = zzajp;
        this.zzcfb = context;
        this.zzdbt = str;
    }

    public final void run() {
        zzajp.zzd(this.zzcfb, this.zzdbt);
    }
}
