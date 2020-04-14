package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbta implements zzdwb<zzbtb> {
    private final zzdwo<zzbnl> zzfit;

    private zzbta(zzdwo<zzbnl> zzdwo) {
        this.zzfit = zzdwo;
    }

    public static zzbta zzv(zzdwo<zzbnl> zzdwo) {
        return new zzbta(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return new zzbtb((zzbnl) this.zzfit.get());
    }
}
