package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdqy extends zzdpg<Integer> implements zzdrb, zzdss, RandomAccess {
    private static final zzdqy zzhlm;
    private int size;
    private int[] zzhln;

    public static zzdqy zzbab() {
        return zzhlm;
    }

    zzdqy() {
        this(new int[10], 0);
    }

    private zzdqy(int[] iArr, int i) {
        this.zzhln = iArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzaxk();
        if (i2 >= i) {
            int[] iArr = this.zzhln;
            System.arraycopy(iArr, i2, iArr, i, this.size - i2);
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
        if (!(obj instanceof zzdqy)) {
            return super.equals(obj);
        }
        zzdqy zzdqy = (zzdqy) obj;
        if (this.size != zzdqy.size) {
            return false;
        }
        int[] iArr = zzdqy.zzhln;
        for (int i = 0; i < this.size; i++) {
            if (this.zzhln[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzhln[i2];
        }
        return i;
    }

    /* renamed from: zzgo */
    public final zzdrb zzfl(int i) {
        if (i >= this.size) {
            return new zzdqy(Arrays.copyOf(this.zzhln, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final int getInt(int i) {
        zzfj(i);
        return this.zzhln[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzgp(int i) {
        zzaxk();
        int i2 = this.size;
        int[] iArr = this.zzhln;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.zzhln = iArr2;
        }
        int[] iArr3 = this.zzhln;
        int i3 = this.size;
        this.size = i3 + 1;
        iArr3[i3] = i;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzaxk();
        zzdqx.checkNotNull(collection);
        if (!(collection instanceof zzdqy)) {
            return super.addAll(collection);
        }
        zzdqy zzdqy = (zzdqy) collection;
        int i = zzdqy.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.zzhln;
            if (i3 > iArr.length) {
                this.zzhln = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(zzdqy.zzhln, 0, this.zzhln, this.size, zzdqy.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzaxk();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzhln[i]))) {
                int[] iArr = this.zzhln;
                System.arraycopy(iArr, i + 1, iArr, i, (this.size - i) - 1);
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
        int intValue = ((Integer) obj).intValue();
        zzaxk();
        zzfj(i);
        int[] iArr = this.zzhln;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ Object remove(int i) {
        zzaxk();
        zzfj(i);
        int[] iArr = this.zzhln;
        int i2 = iArr[i];
        int i3 = this.size;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzaxk();
        if (i >= 0) {
            int i2 = this.size;
            if (i <= i2) {
                int[] iArr = this.zzhln;
                if (i2 < iArr.length) {
                    System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
                } else {
                    int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(iArr, 0, iArr2, 0, i);
                    System.arraycopy(this.zzhln, i, iArr2, i + 1, this.size - i);
                    this.zzhln = iArr2;
                }
                this.zzhln[i] = intValue;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzfk(i));
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzgp(((Integer) obj).intValue());
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    static {
        zzdqy zzdqy = new zzdqy(new int[0], 0);
        zzhlm = zzdqy;
        zzdqy.zzaxj();
    }
}
