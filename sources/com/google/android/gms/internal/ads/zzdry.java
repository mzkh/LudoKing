package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
public final class zzdry<K, V> {
    static <K, V> void zza(zzdqf zzdqf, zzdrx<K, V> zzdrx, K k, V v) throws IOException {
        zzdqm.zza(zzdqf, zzdrx.zzhmt, 1, k);
        zzdqm.zza(zzdqf, zzdrx.zzhmv, 2, v);
    }

    static <K, V> int zza(zzdrx<K, V> zzdrx, K k, V v) {
        return zzdqm.zza(zzdrx.zzhmt, 1, k) + zzdqm.zza(zzdrx.zzhmv, 2, v);
    }
}
