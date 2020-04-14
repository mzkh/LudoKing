package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzclg implements zzdwb<zzcle> {
    private final zzcle zzgbb;

    private zzclg(zzcle zzcle) {
        this.zzgbb = zzcle;
    }

    public static zzclg zzc(zzcle zzcle) {
        return new zzclg(zzcle);
    }

    public final /* synthetic */ Object get() {
        zzcle zzcle = this.zzgbb;
        if (zzcle != null) {
            return (zzcle) zzdwh.zza(zzcle, "Cannot return null from a non-@Nullable @Provides method");
        }
        throw null;
    }
}
