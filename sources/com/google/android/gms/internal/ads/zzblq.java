package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzblq implements zzdwb<zzblr> {
    private final zzdwo<Clock> zzfco;
    private final zzdwo<zzatq> zzfgi;

    private zzblq(zzdwo<Clock> zzdwo, zzdwo<zzatq> zzdwo2) {
        this.zzfco = zzdwo;
        this.zzfgi = zzdwo2;
    }

    public static zzblq zzb(zzdwo<Clock> zzdwo, zzdwo<zzatq> zzdwo2) {
        return new zzblq(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return new zzblr((Clock) this.zzfco.get(), (zzatq) this.zzfgi.get());
    }
}
