package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcfm implements zzdwb<zzcfn> {
    private final zzdwo<zzcft> zzfwa;

    private zzcfm(zzdwo<zzcft> zzdwo) {
        this.zzfwa = zzdwo;
    }

    public static zzcfm zzad(zzdwo<zzcft> zzdwo) {
        return new zzcfm(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return new zzcfn((zzcft) this.zzfwa.get());
    }
}
