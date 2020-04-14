package com.google.android.gms.internal.ads;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdbo extends zzdbd<Entry<K, V>> {
    private final /* synthetic */ zzdbp zzgpr;

    zzdbo(zzdbp zzdbp) {
        this.zzgpr = zzdbp;
    }

    public final boolean zzaoo() {
        return true;
    }

    public final int size() {
        return this.zzgpr.size;
    }

    public final /* synthetic */ Object get(int i) {
        zzdaq.zzr(i, this.zzgpr.size);
        Object[] zzb = this.zzgpr.zzgpo;
        int i2 = i * 2;
        zzdbp zzdbp = this.zzgpr;
        Object obj = zzb[i2];
        Object[] zzb2 = zzdbp.zzgpo;
        zzdbp zzdbp2 = this.zzgpr;
        return new SimpleImmutableEntry(obj, zzb2[i2 + 1]);
    }
}
