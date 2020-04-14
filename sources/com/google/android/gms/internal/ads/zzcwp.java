package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcwp implements zzdwb<Clock> {
    private final zzcwq zzgku;

    public zzcwp(zzcwq zzcwq) {
        this.zzgku = zzcwq;
    }

    public final /* synthetic */ Object get() {
        return (Clock) zzdwh.zza(DefaultClock.getInstance(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
