package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcbu implements zzdwb<zzcbv> {
    private final zzdwo<Clock> zzfco;

    public zzcbu(zzdwo<Clock> zzdwo) {
        this.zzfco = zzdwo;
    }

    public final /* synthetic */ Object get() {
        return new zzcbv((Clock) this.zzfco.get());
    }
}
