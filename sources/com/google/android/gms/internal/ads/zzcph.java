package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcph implements zzdwb<zzcvp> {
    private final zzdwo<Clock> zzfco;

    public zzcph(zzdwo<Clock> zzdwo) {
        this.zzfco = zzdwo;
    }

    public final /* synthetic */ Object get() {
        return (zzcvp) zzdwh.zza(new zzcvp((Clock) this.zzfco.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
