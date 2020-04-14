package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzblc implements zzdwb<String> {
    private final zzbla zzffu;

    private zzblc(zzbla zzbla) {
        this.zzffu = zzbla;
    }

    public static zzblc zza(zzbla zzbla) {
        return new zzblc(zzbla);
    }

    public static String zzb(zzbla zzbla) {
        return (String) zzdwh.zza(zzbla.zzafr(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzb(this.zzffu);
    }
}
