package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
public final class zzdro extends zzdpg<String> implements zzdrn, RandomAccess {
    private static final zzdro zzhmi;
    private static final zzdrn zzhmj = zzhmi;
    private final List<Object> zzhmk;

    public zzdro() {
        this(10);
    }

    public zzdro(int i) {
        this(new ArrayList<>(i));
    }

    private zzdro(ArrayList<Object> arrayList) {
        this.zzhmk = arrayList;
    }

    public final int size() {
        return this.zzhmk.size();
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzaxk();
        if (collection instanceof zzdrn) {
            collection = ((zzdrn) collection).zzban();
        }
        boolean addAll = this.zzhmk.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zzaxk();
        this.zzhmk.clear();
        this.modCount++;
    }

    public final void zzdb(zzdpm zzdpm) {
        zzaxk();
        this.zzhmk.add(zzdpm);
        this.modCount++;
    }

    public final Object zzgq(int i) {
        return this.zzhmk.get(i);
    }

    private static String zzam(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdpm) {
            return ((zzdpm) obj).zzaxn();
        }
        return zzdqx.zzad((byte[]) obj);
    }

    public final List<?> zzban() {
        return Collections.unmodifiableList(this.zzhmk);
    }

    public final zzdrn zzbao() {
        return zzaxi() ? new zzdts(this) : this;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        String str = (String) obj;
        zzaxk();
        return zzam(this.zzhmk.set(i, str));
    }

    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public final /* synthetic */ Object remove(int i) {
        zzaxk();
        Object remove = this.zzhmk.remove(i);
        this.modCount++;
        return zzam(remove);
    }

    public final /* bridge */ /* synthetic */ boolean zzaxi() {
        return super.zzaxi();
    }

    public final /* synthetic */ void add(int i, Object obj) {
        String str = (String) obj;
        zzaxk();
        this.zzhmk.add(i, str);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ zzdrd zzfl(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzhmk);
            return new zzdro(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzhmk.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdpm) {
            zzdpm zzdpm = (zzdpm) obj;
            String zzaxn = zzdpm.zzaxn();
            if (zzdpm.zzaxo()) {
                this.zzhmk.set(i, zzaxn);
            }
            return zzaxn;
        }
        byte[] bArr = (byte[]) obj;
        String zzad = zzdqx.zzad(bArr);
        if (zzdqx.zzac(bArr)) {
            this.zzhmk.set(i, zzad);
        }
        return zzad;
    }

    static {
        zzdro zzdro = new zzdro();
        zzhmi = zzdro;
        zzdro.zzaxj();
    }
}
