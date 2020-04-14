package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.tapjoy.TapjoyConstants;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcpf implements zzdwb<zzcpd<zzcoz>> {
    private final zzdwo<Clock> zzfco;
    private final zzdwo<zzcpc> zzgfa;

    public zzcpf(zzdwo<zzcpc> zzdwo, zzdwo<Clock> zzdwo2) {
        this.zzgfa = zzdwo;
        this.zzfco = zzdwo2;
    }

    public final /* synthetic */ Object get() {
        return (zzcpd) zzdwh.zza(new zzcpd((zzcpc) this.zzgfa.get(), TapjoyConstants.TIMER_INCREMENT, (Clock) this.zzfco.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
