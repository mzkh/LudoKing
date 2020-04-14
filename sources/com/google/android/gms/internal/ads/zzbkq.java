package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbkq {
    public final List<? extends zzddi<? extends zzbkk>> zzffk;

    public zzbkq(List<? extends zzddi<? extends zzbkk>> list) {
        this.zzffk = list;
    }

    public zzbkq(zzbkk zzbkk) {
        this.zzffk = Collections.singletonList(zzdcy.zzah(zzbkk));
    }

    public static zzcga<zzbkq> zza(@NonNull zzcih<? extends zzbkk> zzcih) {
        return new zzcgd(zzcih, zzbkt.zzdos);
    }

    public static zzcga<zzbkq> zza(@NonNull zzcga<? extends zzbkk> zzcga) {
        return new zzcgd(zzcga, zzbks.zzdos);
    }
}
