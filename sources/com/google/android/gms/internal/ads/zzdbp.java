package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdbp<K, V> extends zzdbg<Entry<K, V>> {
    /* access modifiers changed from: private */
    public final transient int size;
    /* access modifiers changed from: private */
    public final transient Object[] zzgpo;
    private final transient zzdbh<K, V> zzgps;
    private final transient int zzgpt = 0;

    zzdbp(zzdbh<K, V> zzdbh, Object[] objArr, int i, int i2) {
        this.zzgps = zzdbh;
        this.zzgpo = objArr;
        this.size = i2;
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzaoo() {
        return true;
    }

    public final zzdbu<Entry<K, V>> zzaoj() {
        return (zzdbu) zzaon().iterator();
    }

    /* access modifiers changed from: 0000 */
    public final int zza(Object[] objArr, int i) {
        return zzaon().zza(objArr, i);
    }

    /* access modifiers changed from: 0000 */
    public final zzdbd<Entry<K, V>> zzaor() {
        return new zzdbo(this);
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Entry) {
            Entry entry = (Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zzgps.get(key))) {
                return true;
            }
        }
        return false;
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
