package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcad implements zzdwb<zzcaa> {
    private final zzdwo<zzbbw> zzfdu;

    private zzcad(zzdwo<zzbbw> zzdwo) {
        this.zzfdu = zzdwo;
    }

    public static zzcad zzy(zzdwo<zzbbw> zzdwo) {
        return new zzcad(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return new zzcaa((zzbbw) this.zzfdu.get());
    }
}
