package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbtj implements zzdwb<zzbth> {
    private final zzbth zzfje;

    private zzbtj(zzbth zzbth) {
        this.zzfje = zzbth;
    }

    public static zzbtj zze(zzbth zzbth) {
        return new zzbtj(zzbth);
    }

    public final /* synthetic */ Object get() {
        zzbth zzbth = this.zzfje;
        if (zzbth != null) {
            return (zzbth) zzdwh.zza(zzbth, "Cannot return null from a non-@Nullable @Provides method");
        }
        throw null;
    }
}
