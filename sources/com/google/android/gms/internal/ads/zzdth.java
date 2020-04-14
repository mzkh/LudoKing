package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
class zzdth extends AbstractSet<Entry<K, V>> {
    private final /* synthetic */ zzdta zzhoh;

    private zzdth(zzdta zzdta) {
        this.zzhoh = zzdta;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new zzdti(this.zzhoh, null);
    }

    public int size() {
        return this.zzhoh.size();
    }

    public boolean contains(Object obj) {
        Entry entry = (Entry) obj;
        Object obj2 = this.zzhoh.get(entry.getKey());
        Object value = entry.getValue();
        return obj2 == value || (obj2 != null && obj2.equals(value));
    }

    public boolean remove(Object obj) {
        Entry entry = (Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzhoh.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.zzhoh.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Entry entry = (Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzhoh.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ zzdth(zzdta zzdta, zzdsz zzdsz) {
        this(zzdta);
    }
}
