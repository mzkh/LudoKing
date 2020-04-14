package com.google.android.gms.internal.ads;

import java.util.Map.Entry;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdrj<K> implements Entry<K, Object> {
    private Entry<K, zzdrh> zzhmd;

    private zzdrj(Entry<K, zzdrh> entry) {
        this.zzhmd = entry;
    }

    public final K getKey() {
        return this.zzhmd.getKey();
    }

    public final Object getValue() {
        if (((zzdrh) this.zzhmd.getValue()) == null) {
            return null;
        }
        return zzdrh.zzbak();
    }

    public final zzdrh zzbam() {
        return (zzdrh) this.zzhmd.getValue();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzdsg) {
            return ((zzdrh) this.zzhmd.getValue()).zzq((zzdsg) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
