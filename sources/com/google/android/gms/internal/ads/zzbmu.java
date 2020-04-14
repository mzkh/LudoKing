package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbmk.zza;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbmu implements zzdwb<zza> {
    private final zzbmk zzfgv;

    private zzbmu(zzbmk zzbmk) {
        this.zzfgv = zzbmk;
    }

    public static zzbmu zzl(zzbmk zzbmk) {
        return new zzbmu(zzbmk);
    }

    public final /* synthetic */ Object get() {
        return (zza) zzdwh.zza(this.zzfgv.zzaft(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
