package com.google.android.gms.internal.ads;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
class zzdta<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzhhq;
    private final int zzhob;
    /* access modifiers changed from: private */
    public List<zzdtf> zzhoc;
    /* access modifiers changed from: private */
    public Map<K, V> zzhod;
    private volatile zzdth zzhoe;
    /* access modifiers changed from: private */
    public Map<K, V> zzhof;
    private volatile zzdtb zzhog;

    static <FieldDescriptorType extends zzdqo<FieldDescriptorType>> zzdta<FieldDescriptorType, Object> zzgy(int i) {
        return new zzdsz(i);
    }

    private zzdta(int i) {
        this.zzhob = i;
        this.zzhoc = Collections.emptyList();
        this.zzhod = Collections.emptyMap();
        this.zzhof = Collections.emptyMap();
    }

    public void zzaxj() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.zzhhq) {
            if (this.zzhod.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzhod);
            }
            this.zzhod = map;
            if (this.zzhof.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzhof);
            }
            this.zzhof = map2;
            this.zzhhq = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzhhq;
    }

    public final int zzbbo() {
        return this.zzhoc.size();
    }

    public final Entry<K, V> zzgz(int i) {
        return (Entry) this.zzhoc.get(i);
    }

    public final Iterable<Entry<K, V>> zzbbp() {
        if (this.zzhod.isEmpty()) {
            return zzdte.zzbbu();
        }
        return this.zzhod.entrySet();
    }

    public int size() {
        return this.zzhoc.size() + this.zzhod.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza((K) comparable) >= 0 || this.zzhod.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza((K) comparable);
        if (zza >= 0) {
            return ((zzdtf) this.zzhoc.get(zza)).getValue();
        }
        return this.zzhod.get(comparable);
    }

    /* renamed from: zza */
    public final V put(K k, V v) {
        zzbbr();
        int zza = zza(k);
        if (zza >= 0) {
            return ((zzdtf) this.zzhoc.get(zza)).setValue(v);
        }
        zzbbr();
        if (this.zzhoc.isEmpty() && !(this.zzhoc instanceof ArrayList)) {
            this.zzhoc = new ArrayList(this.zzhob);
        }
        int i = -(zza + 1);
        if (i >= this.zzhob) {
            return zzbbs().put(k, v);
        }
        int size = this.zzhoc.size();
        int i2 = this.zzhob;
        if (size == i2) {
            zzdtf zzdtf = (zzdtf) this.zzhoc.remove(i2 - 1);
            zzbbs().put((Comparable) zzdtf.getKey(), zzdtf.getValue());
        }
        this.zzhoc.add(i, new zzdtf(this, k, v));
        return null;
    }

    public void clear() {
        zzbbr();
        if (!this.zzhoc.isEmpty()) {
            this.zzhoc.clear();
        }
        if (!this.zzhod.isEmpty()) {
            this.zzhod.clear();
        }
    }

    public V remove(Object obj) {
        zzbbr();
        Comparable comparable = (Comparable) obj;
        int zza = zza((K) comparable);
        if (zza >= 0) {
            return zzha(zza);
        }
        if (this.zzhod.isEmpty()) {
            return null;
        }
        return this.zzhod.remove(comparable);
    }

    /* access modifiers changed from: private */
    public final V zzha(int i) {
        zzbbr();
        V value = ((zzdtf) this.zzhoc.remove(i)).getValue();
        if (!this.zzhod.isEmpty()) {
            Iterator it = zzbbs().entrySet().iterator();
            this.zzhoc.add(new zzdtf(this, (Entry) it.next()));
            it.remove();
        }
        return value;
    }

    private final int zza(K k) {
        int size = this.zzhoc.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) ((zzdtf) this.zzhoc.get(size)).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) ((zzdtf) this.zzhoc.get(i2)).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    public Set<Entry<K, V>> entrySet() {
        if (this.zzhoe == null) {
            this.zzhoe = new zzdth(this, null);
        }
        return this.zzhoe;
    }

    /* access modifiers changed from: 0000 */
    public final Set<Entry<K, V>> zzbbq() {
        if (this.zzhog == null) {
            this.zzhog = new zzdtb(this, null);
        }
        return this.zzhog;
    }

    /* access modifiers changed from: private */
    public final void zzbbr() {
        if (this.zzhhq) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzbbs() {
        zzbbr();
        if (this.zzhod.isEmpty() && !(this.zzhod instanceof TreeMap)) {
            this.zzhod = new TreeMap();
            this.zzhof = ((TreeMap) this.zzhod).descendingMap();
        }
        return (SortedMap) this.zzhod;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdta)) {
            return super.equals(obj);
        }
        zzdta zzdta = (zzdta) obj;
        int size = size();
        if (size != zzdta.size()) {
            return false;
        }
        int zzbbo = zzbbo();
        if (zzbbo != zzdta.zzbbo()) {
            return entrySet().equals(zzdta.entrySet());
        }
        for (int i = 0; i < zzbbo; i++) {
            if (!zzgz(i).equals(zzdta.zzgz(i))) {
                return false;
            }
        }
        if (zzbbo != size) {
            return this.zzhod.equals(zzdta.zzhod);
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < zzbbo(); i2++) {
            i += ((zzdtf) this.zzhoc.get(i2)).hashCode();
        }
        return this.zzhod.size() > 0 ? i + this.zzhod.hashCode() : i;
    }

    /* synthetic */ zzdta(int i, zzdsz zzdsz) {
        this(i);
    }
}
