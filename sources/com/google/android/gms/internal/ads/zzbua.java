package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbua implements zzdwb<zzbyh> {
    private final zzbtx zzfkj;

    public zzbua(zzbtx zzbtx) {
        this.zzfkj = zzbtx;
    }

    public static zzbyh zza(zzbtx zzbtx) {
        return (zzbyh) zzdwh.zza(zzbtx.zzahi(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfkj);
    }
}
