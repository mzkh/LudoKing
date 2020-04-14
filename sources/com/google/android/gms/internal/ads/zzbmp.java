package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbmp implements zzdwb<String> {
    private final zzdwo<zzblr> zzelz;
    private final zzbmk zzfgv;

    private zzbmp(zzbmk zzbmk, zzdwo<zzblr> zzdwo) {
        this.zzfgv = zzbmk;
        this.zzelz = zzdwo;
    }

    public static zzbmp zzb(zzbmk zzbmk, zzdwo<zzblr> zzdwo) {
        return new zzbmp(zzbmk, zzdwo);
    }

    public final /* synthetic */ Object get() {
        return (String) zzdwh.zza(((zzblr) this.zzelz.get()).zzua(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
