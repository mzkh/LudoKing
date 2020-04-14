package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzauk implements Runnable {
    private final Context zzcfb;
    private final String zzdbt;
    private final zzauh zzdsr;

    zzauk(zzauh zzauh, Context context, String str) {
        this.zzdsr = zzauh;
        this.zzcfb = context;
        this.zzdbt = str;
    }

    public final void run() {
        this.zzdsr.zzp(this.zzcfb, this.zzdbt);
    }
}
