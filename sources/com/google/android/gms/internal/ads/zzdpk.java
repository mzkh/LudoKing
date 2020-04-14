package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdpk extends zzdpg<Boolean> implements zzdrd<Boolean>, zzdss, RandomAccess {
    private static final zzdpk zzhfv;
    private int size;
    private boolean[] zzhfw;

    zzdpk() {
        this(new boolean[10], 0);
    }

    private zzdpk(boolean[] zArr, int i) {
        this.zzhfw = zArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzaxk();
        if (i2 >= i) {
            boolean[] zArr = this.zzhfw;
            System.arraycopy(zArr, i2, zArr, i, this.size - i2);
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
        if (!(obj instanceof zzdpk)) {
            return super.equals(obj);
        }
        zzdpk zzdpk = (zzdpk) obj;
        if (this.size != zzdpk.size) {
            return false;
        }
        boolean[] zArr = zzdpk.zzhfw;
        for (int i = 0; i < this.size; i++) {
            if (this.zzhfw[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzdqx.zzbj(this.zzhfw[i2]);
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void addBoolean(boolean z) {
        zzaxk();
        int i = this.size;
        boolean[] zArr = this.zzhfw;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[(((i * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.zzhfw = zArr2;
        }
        boolean[] zArr3 = this.zzhfw;
        int i2 = this.size;
        this.size = i2 + 1;
        zArr3[i2] = z;
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzaxk();
        zzdqx.checkNotNull(collection);
        if (!(collection instanceof zzdpk)) {
            return super.addAll(collection);
        }
        zzdpk zzdpk = (zzdpk) collection;
        int i = zzdpk.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.zzhfw;
            if (i3 > zArr.length) {
                this.zzhfw = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(zzdpk.zzhfw, 0, this.zzhfw, this.size, zzdpk.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzaxk();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Boolean.valueOf(this.zzhfw[i]))) {
                boolean[] zArr = this.zzhfw;
                System.arraycopy(zArr, i + 1, zArr, i, (this.size - i) - 1);
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
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzaxk();
        zzfj(i);
        boolean[] zArr = this.zzhfw;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ Object remove(int i) {
        zzaxk();
        zzfj(i);
        boolean[] zArr = this.zzhfw;
        boolean z = zArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzaxk();
        if (i >= 0) {
            int i2 = this.size;
            if (i <= i2) {
                boolean[] zArr = this.zzhfw;
                if (i2 < zArr.length) {
                    System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
                } else {
                    boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(zArr, 0, zArr2, 0, i);
                    System.arraycopy(this.zzhfw, i, zArr2, i + 1, this.size - i);
                    this.zzhfw = zArr2;
                }
                this.zzhfw[i] = booleanValue;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzfk(i));
    }

    public final /* synthetic */ boolean add(Object obj) {
        addBoolean(((Boolean) obj).booleanValue());
        return true;
    }

    public final /* synthetic */ zzdrd zzfl(int i) {
        if (i >= this.size) {
            return new zzdpk(Arrays.copyOf(this.zzhfw, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzfj(i);
        return Boolean.valueOf(this.zzhfw[i]);
    }

    static {
        zzdpk zzdpk = new zzdpk(new boolean[0], 0);
        zzhfv = zzdpk;
        zzdpk.zzaxj();
    }
}
