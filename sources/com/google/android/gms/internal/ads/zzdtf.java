package com.google.android.gms.internal.ads;

import java.util.Map.Entry;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdtf implements Comparable<zzdtf>, Entry<K, V> {
    private V value;
    private final /* synthetic */ zzdta zzhoh;
    private final K zzhol;

    zzdtf(zzdta zzdta, Entry<K, V> entry) {
        this(zzdta, (Comparable) entry.getKey(), entry.getValue());
    }

    zzdtf(zzdta zzdta, K k, V v) {
        this.zzhoh = zzdta;
        this.zzhol = k;
        this.value = v;
    }

    public final V getValue() {
        return this.value;
    }

    public final V setValue(V v) {
        this.zzhoh.zzbbr();
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return equals(this.zzhol, entry.getKey()) && equals(this.value, entry.getValue());
    }

    public final int hashCode() {
        K k = this.zzhol;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.value;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzhol);
        String valueOf2 = String.valueOf(this.value);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    private static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public final /* synthetic */ Object getKey() {
        return this.zzhol;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzdtf) obj).getKey());
    }
}
