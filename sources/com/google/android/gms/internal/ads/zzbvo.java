package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbvo implements zzdwb<zzbvm> {
    private final zzdwo<zzbyh> zzeuf;
    private final zzdwo<Clock> zzfco;

    public zzbvo(zzdwo<zzbyh> zzdwo, zzdwo<Clock> zzdwo2) {
        this.zzeuf = zzdwo;
        this.zzfco = zzdwo2;
    }

    public final /* synthetic */ Object get() {
        return new zzbvm((zzbyh) this.zzeuf.get(), (Clock) this.zzfco.get());
    }
}
