package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzcrr;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcpd<S extends zzcrr<?>> implements zzcru<S> {
    private final Clock zzbmp;
    private final AtomicReference<zzcpg<S>> zzgex = new AtomicReference<>();
    private final zzcru<S> zzgey;
    private final long zzgez;

    public zzcpd(zzcru<S> zzcru, long j, Clock clock) {
        this.zzbmp = clock;
        this.zzgey = zzcru;
        this.zzgez = j;
    }

    public final zzddi<S> zzalv() {
        zzcpg zzcpg = (zzcpg) this.zzgex.get();
        if (zzcpg == null || zzcpg.hasExpired()) {
            zzcpg = new zzcpg(this.zzgey.zzalv(), this.zzgez, this.zzbmp);
            this.zzgex.set(zzcpg);
        }
        return zzcpg.zzgfb;
    }
}
