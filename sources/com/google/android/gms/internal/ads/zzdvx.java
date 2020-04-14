package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzdvx<K, V, V2> {
    final LinkedHashMap<K, zzdwo<V>> zzhxl;

    zzdvx(int i) {
        this.zzhxl = zzdwa.zzhm(i);
    }

    /* access modifiers changed from: 0000 */
    public zzdvx<K, V, V2> zza(K k, zzdwo<V> zzdwo) {
        this.zzhxl.put(zzdwh.zza(k, "key"), zzdwh.zza(zzdwo, "provider"));
        return this;
    }
}
