package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzcrr;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcpg<S extends zzcrr<?>> {
    private final Clock zzbmp;
    public final zzddi<S> zzgfb;
    private final long zzgfc;

    public zzcpg(zzddi<S> zzddi, long j, Clock clock) {
        this.zzgfb = zzddi;
        this.zzbmp = clock;
        this.zzgfc = clock.elapsedRealtime() + j;
    }

    public final boolean hasExpired() {
        return this.zzgfc < this.zzbmp.elapsedRealtime();
    }
}
