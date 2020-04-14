package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzblf implements zzdwb<zzcvz> {
    private final zzbla zzffu;

    private zzblf(zzbla zzbla) {
        this.zzffu = zzbla;
    }

    public static zzblf zze(zzbla zzbla) {
        return new zzblf(zzbla);
    }

    public static zzcvz zzf(zzbla zzbla) {
        return (zzcvz) zzdwh.zza(zzbla.zzafp(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzf(this.zzffu);
    }
}
