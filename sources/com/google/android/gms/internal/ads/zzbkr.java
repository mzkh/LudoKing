package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbkr<AdT> implements zzdwb<zzbko<AdT>> {
    private final zzdwo<Map<String, zzcga<AdT>>> zzffl;

    private zzbkr(zzdwo<Map<String, zzcga<AdT>>> zzdwo) {
        this.zzffl = zzdwo;
    }

    public static <AdT> zzbkr<AdT> zzd(zzdwo<Map<String, zzcga<AdT>>> zzdwo) {
        return new zzbkr<>(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return new zzbko((Map) this.zzffl.get());
    }
}
