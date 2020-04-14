package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzblh implements zzdwb<zzble> {
    private final zzdwo<zzbnr> zzesa;

    private zzblh(zzdwo<zzbnr> zzdwo) {
        this.zzesa = zzdwo;
    }

    public static zzblh zze(zzdwo<zzbnr> zzdwo) {
        return new zzblh(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return new zzble((zzbnr) this.zzesa.get());
    }
}
