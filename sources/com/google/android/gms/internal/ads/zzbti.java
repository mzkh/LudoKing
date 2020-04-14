package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbti implements zzdwb<zzbuy> {
    private final zzbth zzfje;

    private zzbti(zzbth zzbth) {
        this.zzfje = zzbth;
    }

    public static zzbti zzc(zzbth zzbth) {
        return new zzbti(zzbth);
    }

    public static zzbuy zzd(zzbth zzbth) {
        return (zzbuy) zzdwh.zza(zzbth.zzagy(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzd(this.zzfje);
    }
}
