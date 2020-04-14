package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbko<AdT> implements zzbkp<AdT> {
    private final Map<String, zzcga<AdT>> zzffj;

    zzbko(Map<String, zzcga<AdT>> map) {
        this.zzffj = map;
    }

    @Nullable
    public final zzcga<AdT> zze(int i, String str) {
        return (zzcga) this.zzffj.get(str);
    }
}
