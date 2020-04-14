package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdsu<E> extends zzdpg<E> {
    private static final zzdsu<Object> zzhnw;
    private int size;
    private E[] zzgpq;

    public static <E> zzdsu<E> zzbbi() {
        return zzhnw;
    }

    zzdsu() {
        this(new Object[10], 0);
    }

    private zzdsu(E[] eArr, int i) {
        this.zzgpq = eArr;
        this.size = i;
    }

    public final boolean add(E e) {
        zzaxk();
        int i = this.size;
        E[] eArr = this.zzgpq;
        if (i == eArr.length) {
            this.zzgpq = Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzgpq;
        int i2 = this.size;
        this.size = i2 + 1;
        eArr2[i2] = e;
        this.modCount++;
        return true;
    }

    public final void add(int i, E e) {
        zzaxk();
        if (i >= 0) {
            int i2 = this.size;
            if (i <= i2) {
                E[] eArr = this.zzgpq;
                if (i2 < eArr.length) {
                    System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
                } else {
                    E[] eArr2 = new Object[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(eArr, 0, eArr2, 0, i);
                    System.arraycopy(this.zzgpq, i, eArr2, i + 1, this.size - i);
                    this.zzgpq = eArr2;
                }
                this.zzgpq[i] = e;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzfk(i));
    }

    public final E get(int i) {
        zzfj(i);
        return this.zzgpq[i];
    }

    public final E remove(int i) {
        zzaxk();
        zzfj(i);
        E[] eArr = this.zzgpq;
        E e = eArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return e;
    }

    public final E set(int i, E e) {
        zzaxk();
        zzfj(i);
        E[] eArr = this.zzgpq;
        E e2 = eArr[i];
        eArr[i] = e;
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.size;
    }

    private final void zzfj(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzfk(i));
        }
    }

    private final String zzfk(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ zzdrd zzfl(int i) {
        if (i >= this.size) {
            return new zzdsu(Arrays.copyOf(this.zzgpq, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    static {
        zzdsu<Object> zzdsu = new zzdsu<>(new Object[0], 0);
        zzhnw = zzdsu;
        zzdsu.zzaxj();
    }
}
