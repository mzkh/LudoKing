package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdwd<K, V> extends zzdvy<K, V, V> {
    private static final zzdwo<Map<Object, Object>> zzhxq = zzdwe.zzbb(Collections.emptyMap());

    public static <K, V> zzdwf<K, V> zzho(int i) {
        return new zzdwf<>(i);
    }

    private zzdwd(Map<K, zzdwo<V>> map) {
        super(map);
    }

    public final /* synthetic */ Object get() {
        LinkedHashMap zzhm = zzdwa.zzhm(zzbde().size());
        for (Entry entry : zzbde().entrySet()) {
            zzhm.put(entry.getKey(), ((zzdwo) entry.getValue()).get());
        }
        return Collections.unmodifiableMap(zzhm);
    }
}
