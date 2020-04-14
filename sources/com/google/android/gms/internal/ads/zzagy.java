package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzagy implements Runnable {
    private final zzagz zzczc;
    private final zzaer zzczd;
    private final Map zzcze;

    zzagy(zzagz zzagz, zzaer zzaer, Map map) {
        this.zzczc = zzagz;
        this.zzczd = zzaer;
        this.zzcze = map;
    }

    public final void run() {
        this.zzczc.zza(this.zzczd, this.zzcze);
    }
}
