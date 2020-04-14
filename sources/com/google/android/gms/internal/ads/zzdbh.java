package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzdbh<K, V> implements Serializable, Map<K, V> {
    private static final Entry<?, ?>[] zzgpf = new Entry[0];
    private transient zzdbg<Entry<K, V>> zzgpg;
    private transient zzdbg<K> zzgph;
    private transient zzday<V> zzgpi;

    public static <K, V> zzdbh<K, V> zza(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        zzdax.zzb(k, v);
        zzdax.zzb(k2, v2);
        zzdax.zzb(k3, v3);
        zzdax.zzb(k4, v4);
        zzdax.zzb(k5, v5);
        return zzdbm.zzc(5, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5});
    }

    public abstract V get(@NullableDecl Object obj);

    /* access modifiers changed from: 0000 */
    public abstract zzdbg<Entry<K, V>> zzaos();

    /* access modifiers changed from: 0000 */
    public abstract zzdbg<K> zzaot();

    /* access modifiers changed from: 0000 */
    public abstract zzday<V> zzaou();

    zzdbh() {
    }

    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(@NullableDecl Object obj) {
        return ((zzday) values()).contains(obj);
    }

    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return entrySet().equals(((Map) obj).entrySet());
    }

    public int hashCode() {
        return zzdbs.zzf((zzdbg) entrySet());
    }

    public String toString() {
        int size = size();
        zzdax.zzf(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) << 3, 1073741824));
        sb.append('{');
        boolean z = true;
        for (Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            z = false;
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
        }
        sb.append('}');
        return sb.toString();
    }

    public /* synthetic */ Set entrySet() {
        zzdbg<Entry<K, V>> zzdbg = this.zzgpg;
        if (zzdbg != null) {
            return zzdbg;
        }
        zzdbg<Entry<K, V>> zzaos = zzaos();
        this.zzgpg = zzaos;
        return zzaos;
    }

    public /* synthetic */ Collection values() {
        zzday<V> zzday = this.zzgpi;
        if (zzday != null) {
            return zzday;
        }
        zzday<V> zzaou = zzaou();
        this.zzgpi = zzaou;
        return zzaou;
    }

    public /* synthetic */ Set keySet() {
        zzdbg<K> zzdbg = this.zzgph;
        if (zzdbg != null) {
            return zzdbg;
        }
        zzdbg<K> zzaot = zzaot();
        this.zzgph = zzaot;
        return zzaot;
    }
}
