package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzdbd<E> extends zzday<E> implements List<E>, RandomAccess {
    private static final zzdbx<Object> zzgpb = new zzdbf(zzdbn.zzgpp, 0);

    public static <E> zzdbd<E> zzaop() {
        return zzdbn.zzgpp;
    }

    public final zzdbd<E> zzaon() {
        return this;
    }

    public static <E> zzdbd<E> zzad(E e) {
        Object[] objArr = {e};
        for (int i = 0; i <= 0; i++) {
            zzdbk.zzd(objArr[0], 0);
        }
        return zzb(objArr, 1);
    }

    public static <E> zzdbd<E> zzf(Iterable<? extends E> iterable) {
        zzdaq.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection instanceof zzday) {
                zzdbd<E> zzaon = ((zzday) collection).zzaon();
                if (zzaon.zzaoo()) {
                    Object[] array = zzaon.toArray();
                    zzaon = zzb(array, array.length);
                }
                return zzaon;
            }
            Object[] array2 = collection.toArray();
            int length = array2.length;
            for (int i = 0; i < length; i++) {
                zzdbk.zzd(array2[i], i);
            }
            return zzb(array2, array2.length);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return zzdbn.zzgpp;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return zzad(next);
        }
        zzdbc zzdbc = (zzdbc) ((zzdbc) new zzdbc().zzab(next)).zza(it);
        zzdbc.zzgpa = true;
        return zzb(zzdbc.zzgoz, zzdbc.size);
    }

    public static <E> zzdbd<E> zzb(E[] eArr) {
        if (eArr.length == 0) {
            return zzdbn.zzgpp;
        }
        Object[] objArr = (Object[]) eArr.clone();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            zzdbk.zzd(objArr[i], i);
        }
        return zzb(objArr, objArr.length);
    }

    static <E> zzdbd<E> zzc(Object[] objArr) {
        return zzb(objArr, objArr.length);
    }

    static <E> zzdbd<E> zzb(Object[] objArr, int i) {
        if (i == 0) {
            return zzdbn.zzgpp;
        }
        return new zzdbn(objArr, i);
    }

    zzdbd() {
    }

    public final zzdbu<E> zzaoj() {
        return (zzdbx) listIterator();
    }

    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        if (this instanceof RandomAccess) {
            int size = size();
            int i = 0;
            if (obj == null) {
                while (i < size) {
                    if (get(i) == null) {
                        return i;
                    }
                    i++;
                }
            } else {
                while (i < size) {
                    if (obj.equals(get(i))) {
                        return i;
                    }
                    i++;
                }
            }
            return -1;
        }
        ListIterator listIterator = listIterator();
        while (listIterator.hasNext()) {
            if (zzdao.equal(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        if (this instanceof RandomAccess) {
            if (obj == null) {
                for (int size = size() - 1; size >= 0; size--) {
                    if (get(size) == null) {
                        return size;
                    }
                }
            } else {
                for (int size2 = size() - 1; size2 >= 0; size2--) {
                    if (obj.equals(get(size2))) {
                        return size2;
                    }
                }
            }
            return -1;
        }
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (zzdao.equal(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    /* renamed from: zzt */
    public zzdbd<E> subList(int i, int i2) {
        zzdaq.zzf(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return zzdbn.zzgpp;
        }
        return new zzdbe(this, i, i3);
    }

    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: 0000 */
    public int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == zzdaq.checkNotNull(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (!(this instanceof RandomAccess) || !(list instanceof RandomAccess)) {
                    zzdbd zzdbd = this;
                    int size2 = zzdbd.size();
                    Iterator it = list.iterator();
                    int i = 0;
                    while (true) {
                        if (i < size2) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Object obj2 = zzdbd.get(i);
                            i++;
                            if (!zzdao.equal(obj2, it.next())) {
                                break;
                            }
                        } else if (!it.hasNext()) {
                            return true;
                        }
                    }
                } else {
                    int i2 = 0;
                    while (i2 < size) {
                        if (zzdao.equal(get(i2), list.get(i2))) {
                            i2++;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < size(); i2++) {
            i = (((i * 31) + get(i2).hashCode()) ^ -1) ^ -1;
        }
        return i;
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public /* synthetic */ ListIterator listIterator(int i) {
        zzdaq.zzs(i, size());
        if (isEmpty()) {
            return zzgpb;
        }
        return new zzdbf(this, i);
    }

    public /* synthetic */ ListIterator listIterator() {
        return (zzdbx) listIterator(0);
    }
}
