package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbld implements zzdwb<zzcvr> {
    private final zzbla zzffu;

    private zzbld(zzbla zzbla) {
        this.zzffu = zzbla;
    }

    public static zzbld zzc(zzbla zzbla) {
        return new zzbld(zzbla);
    }

    public static zzcvr zzd(zzbla zzbla) {
        return (zzcvr) zzdwh.zza(zzbla.zzafq(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzd(this.zzffu);
    }
}
