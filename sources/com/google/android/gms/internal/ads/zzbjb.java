package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbjb implements zzdwb<zzbkl> {
    private final zzbiv zzfec;

    public zzbjb(zzbiv zzbiv) {
        this.zzfec = zzbiv;
    }

    public static zzbkl zzc(zzbiv zzbiv) {
        return (zzbkl) zzdwh.zza(zzbiv.zzafc(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzc(this.zzfec);
    }
}
