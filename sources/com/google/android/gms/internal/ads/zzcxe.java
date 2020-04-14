package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcxe implements zzdwb<zzdf> {
    private final zzcxa zzgla;
    private final zzdwo<zzcwy> zzglb;

    private zzcxe(zzcxa zzcxa, zzdwo<zzcwy> zzdwo) {
        this.zzgla = zzcxa;
        this.zzglb = zzdwo;
    }

    public static zzcxe zzd(zzcxa zzcxa, zzdwo<zzcwy> zzdwo) {
        return new zzcxe(zzcxa, zzdwo);
    }

    public final /* synthetic */ Object get() {
        return (zzdf) zzdwh.zza(((zzcwy) this.zzglb.get()).zzgkz, "Cannot return null from a non-@Nullable @Provides method");
    }
}
