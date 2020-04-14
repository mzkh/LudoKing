package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
abstract class zzdvy<K, V, V2> implements zzdwb<Map<K, V2>> {
    private final Map<K, zzdwo<V>> zzhxm;

    zzdvy(Map<K, zzdwo<V>> map) {
        this.zzhxm = Collections.unmodifiableMap(map);
    }

    /* access modifiers changed from: 0000 */
    public final Map<K, zzdwo<V>> zzbde() {
        return this.zzhxm;
    }
}
