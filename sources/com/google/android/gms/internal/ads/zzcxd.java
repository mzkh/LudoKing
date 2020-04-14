package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcxd implements zzdwb<zzatz> {
    private final zzcxa zzgla;
    private final zzdwo<zzcwy> zzglb;

    private zzcxd(zzcxa zzcxa, zzdwo<zzcwy> zzdwo) {
        this.zzgla = zzcxa;
        this.zzglb = zzdwo;
    }

    public static zzcxd zzc(zzcxa zzcxa, zzdwo<zzcwy> zzdwo) {
        return new zzcxd(zzcxa, zzdwo);
    }

    public final /* synthetic */ Object get() {
        return (zzatz) zzdwh.zza(((zzcwy) this.zzglb.get()).zzdqe, "Cannot return null from a non-@Nullable @Provides method");
    }
}
