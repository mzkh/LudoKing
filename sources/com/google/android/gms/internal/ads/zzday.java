package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzday<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zzgoy = new Object[0];

    zzday() {
    }

    public abstract boolean contains(@NullableDecl Object obj);

    /* renamed from: zzaoj */
    public abstract zzdbu<E> iterator();

    /* access modifiers changed from: 0000 */
    public Object[] zzaok() {
        return null;
    }

    /* access modifiers changed from: 0000 */
    public abstract boolean zzaoo();

    public final Object[] toArray() {
        return toArray(zzgoy);
    }

    public final <T> T[] toArray(T[] tArr) {
        zzdaq.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] zzaok = zzaok();
            if (zzaok != null) {
                return Arrays.copyOfRange(zzaok, zzaol(), zzaom(), tArr.getClass());
            }
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zza(tArr, 0);
        return tArr;
    }

    /* access modifiers changed from: 0000 */
    public int zzaol() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: 0000 */
    public int zzaom() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public zzdbd<E> zzaon() {
        return isEmpty() ? zzdbd.zzaop() : zzdbd.zzc(toArray());
    }

    /* access modifiers changed from: 0000 */
    public int zza(Object[] objArr, int i) {
        zzdbu zzdbu = (zzdbu) iterator();
        while (zzdbu.hasNext()) {
            int i2 = i + 1;
            objArr[i] = zzdbu.next();
            i = i2;
        }
        return i;
    }
}
