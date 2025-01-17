package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
abstract class zzdpg<E> extends AbstractList<E> implements zzdrd<E> {
    private boolean zzhfr = true;

    zzdpg() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < size(); i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public boolean add(E e) {
        zzaxk();
        return super.add(e);
    }

    public void add(int i, E e) {
        zzaxk();
        super.add(i, e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        zzaxk();
        return super.addAll(collection);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        zzaxk();
        return super.addAll(i, collection);
    }

    public void clear() {
        zzaxk();
        super.clear();
    }

    public boolean zzaxi() {
        return this.zzhfr;
    }

    public final void zzaxj() {
        this.zzhfr = false;
    }

    public E remove(int i) {
        zzaxk();
        return super.remove(i);
    }

    public boolean remove(Object obj) {
        zzaxk();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        zzaxk();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        zzaxk();
        return super.retainAll(collection);
    }

    public E set(int i, E e) {
        zzaxk();
        return super.set(i, e);
    }

    /* access modifiers changed from: protected */
    public final void zzaxk() {
        if (!this.zzhfr) {
            throw new UnsupportedOperationException();
        }
    }
}
