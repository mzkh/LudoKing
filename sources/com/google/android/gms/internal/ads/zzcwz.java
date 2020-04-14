package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcwz implements zzdwb<zzaui> {
    private final zzcxa zzgla;
    private final zzdwo<zzcwy> zzglb;

    private zzcwz(zzcxa zzcxa, zzdwo<zzcwy> zzdwo) {
        this.zzgla = zzcxa;
        this.zzglb = zzdwo;
    }

    public static zzcwz zza(zzcxa zzcxa, zzdwo<zzcwy> zzdwo) {
        return new zzcwz(zzcxa, zzdwo);
    }

    public static zzaui zza(zzcxa zzcxa, zzcwy zzcwy) {
        return (zzaui) zzdwh.zza(zzcwy.zzdrp, "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzgla, (zzcwy) this.zzglb.get());
    }
}
