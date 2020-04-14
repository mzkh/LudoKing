package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzasx implements Callable {
    private final Context zzcfb;
    private final zzasl zzdpv;

    zzasx(zzasl zzasl, Context context) {
        this.zzdpv = zzasl;
        this.zzcfb = context;
    }

    public final Object call() {
        return this.zzdpv.zzaj(this.zzcfb);
    }
}
