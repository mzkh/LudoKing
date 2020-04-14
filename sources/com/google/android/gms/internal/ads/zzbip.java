package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbip implements zzdwb<zzbou> {
    private final zzdwo<Clock> zzfco;
    private final zzdwo<ScheduledExecutorService> zzfdm;

    public zzbip(zzdwo<ScheduledExecutorService> zzdwo, zzdwo<Clock> zzdwo2) {
        this.zzfdm = zzdwo;
        this.zzfco = zzdwo2;
    }

    public static zzbou zza(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        return (zzbou) zzdwh.zza(new zzbou(scheduledExecutorService, clock), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza((ScheduledExecutorService) this.zzfdm.get(), (Clock) this.zzfco.get());
    }
}
