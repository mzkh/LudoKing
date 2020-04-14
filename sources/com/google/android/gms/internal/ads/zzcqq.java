package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcrr;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcqq<S extends zzcrr<?>> implements zzcru<S> {
    private final ScheduledExecutorService zzfcx;
    private final zzcru<S> zzgey;
    private final long zzgfn;

    public zzcqq(zzcru<S> zzcru, long j, ScheduledExecutorService scheduledExecutorService) {
        this.zzgey = zzcru;
        this.zzgfn = j;
        this.zzfcx = scheduledExecutorService;
    }

    public final zzddi<S> zzalv() {
        zzddi zzalv = this.zzgey.zzalv();
        long j = this.zzgfn;
        if (j > 0) {
            zzalv = zzdcy.zza(zzalv, j, TimeUnit.MILLISECONDS, this.zzfcx);
        }
        return zzdcy.zzb(zzalv, Throwable.class, zzcqp.zzbkv, zzaxn.zzdwn);
    }
}
