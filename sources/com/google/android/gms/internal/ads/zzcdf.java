package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcdf implements Callable {
    private final Context zzcfb;
    private final zzdf zzfub;

    zzcdf(zzdf zzdf, Context context) {
        this.zzfub = zzdf;
        this.zzcfb = context;
    }

    public final Object call() {
        zzdf zzdf = this.zzfub;
        return zzdf.zzcd().zza(this.zzcfb);
    }
}
