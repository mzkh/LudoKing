package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdru extends zzdpg<Long> implements zzdrd<Long>, zzdss, RandomAccess {
    private static final zzdru zzhmq;
    private int size;
    private long[] zzhmr;

    zzdru() {
        this(new long[10], 0);
    }

    private zzdru(long[] jArr, int i) {
        this.zzhmr = jArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzaxk();
        if (i2 >= i) {
            long[] jArr = this.zzhmr;
            System.arraycopy(jArr, i2, jArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdru)) {
            return super.equals(obj);
        }
        zzdru zzdru = (zzdru) obj;
        if (this.size != zzdru.size) {
            return false;
        }
        long[] jArr = zzdru.zzhmr;
        for (int i = 0; i < this.size; i++) {
            if (this.zzhmr[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzdqx.zzfk(this.zzhmr[i2]);
        }
        return i;
    }

    public final long getLong(int i) {
        zzfj(i);
        return this.zzhmr[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzfl(long j) {
        zzaxk();
        int i = this.size;
        long[] jArr = this.zzhmr;
        if (i == jArr.length) {
            long[] jArr2 = new long[(((i * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.zzhmr = jArr2;
        }
        long[] jArr3 = this.zzhmr;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr3[i2] = j;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        zzaxk();
        zzdqx.checkNotNull(collection);
        if (!(collection instanceof zzdru)) {
            return super.addAll(collection);
        }
        zzdru zzdru = (zzdru) collection;
        int i = zzdru.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.zzhmr;
            if (i3 > jArr.length) {
                this.zzhmr = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(zzdru.zzhmr, 0, this.zzhmr, this.size, zzdru.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzaxk();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zzhmr[i]))) {
                long[] jArr = this.zzhmr;
                System.arraycopy(jArr, i + 1, jArr, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
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

    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzaxk();
        zzfj(i);
        long[] jArr = this.zzhmr;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final /* synthetic */ Object remove(int i) {
        zzaxk();
        zzfj(i);
        long[] jArr = this.zzhmr;
        long j = jArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzaxk();
        if (i >= 0) {
            int i2 = this.size;
            if (i <= i2) {
                long[] jArr = this.zzhmr;
                if (i2 < jArr.length) {
                    System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
                } else {
                    long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(jArr, 0, jArr2, 0, i);
                    System.arraycopy(this.zzhmr, i, jArr2, i + 1, this.size - i);
                    this.zzhmr = jArr2;
                }
                this.zzhmr[i] = longValue;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzfk(i));
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzfl(((Long) obj).longValue());
        return true;
    }

    public final /* synthetic */ zzdrd zzfl(int i) {
        if (i >= this.size) {
            return new zzdru(Arrays.copyOf(this.zzhmr, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    static {
        zzdru zzdru = new zzdru(new long[0], 0);
        zzhmq = zzdru;
        zzdru.zzaxj();
    }
}
