package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdqi extends zzdpg<Double> implements zzdrd<Double>, zzdss, RandomAccess {
    private static final zzdqi zzhhg;
    private int size;
    private double[] zzhhh;

    zzdqi() {
        this(new double[10], 0);
    }

    private zzdqi(double[] dArr, int i) {
        this.zzhhh = dArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzaxk();
        if (i2 >= i) {
            double[] dArr = this.zzhhh;
            System.arraycopy(dArr, i2, dArr, i, this.size - i2);
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
        if (!(obj instanceof zzdqi)) {
            return super.equals(obj);
        }
        zzdqi zzdqi = (zzdqi) obj;
        if (this.size != zzdqi.size) {
            return false;
        }
        double[] dArr = zzdqi.zzhhh;
        for (int i = 0; i < this.size; i++) {
            if (Double.doubleToLongBits(this.zzhhh[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzdqx.zzfk(Double.doubleToLongBits(this.zzhhh[i2]));
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void zzd(double d) {
        zzaxk();
        int i = this.size;
        double[] dArr = this.zzhhh;
        if (i == dArr.length) {
            double[] dArr2 = new double[(((i * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.zzhhh = dArr2;
        }
        double[] dArr3 = this.zzhhh;
        int i2 = this.size;
        this.size = i2 + 1;
        dArr3[i2] = d;
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        zzaxk();
        zzdqx.checkNotNull(collection);
        if (!(collection instanceof zzdqi)) {
            return super.addAll(collection);
        }
        zzdqi zzdqi = (zzdqi) collection;
        int i = zzdqi.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.zzhhh;
            if (i3 > dArr.length) {
                this.zzhhh = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(zzdqi.zzhhh, 0, this.zzhhh, this.size, zzdqi.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzaxk();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Double.valueOf(this.zzhhh[i]))) {
                double[] dArr = this.zzhhh;
                System.arraycopy(dArr, i + 1, dArr, i, (this.size - i) - 1);
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
        double doubleValue = ((Double) obj).doubleValue();
        zzaxk();
        zzfj(i);
        double[] dArr = this.zzhhh;
        double d = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d);
    }

    public final /* synthetic */ Object remove(int i) {
        zzaxk();
        zzfj(i);
        double[] dArr = this.zzhhh;
        double d = dArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzaxk();
        if (i >= 0) {
            int i2 = this.size;
            if (i <= i2) {
                double[] dArr = this.zzhhh;
                if (i2 < dArr.length) {
                    System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
                } else {
                    double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(dArr, 0, dArr2, 0, i);
                    System.arraycopy(this.zzhhh, i, dArr2, i + 1, this.size - i);
                    this.zzhhh = dArr2;
                }
                this.zzhhh[i] = doubleValue;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzfk(i));
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzd(((Double) obj).doubleValue());
        return true;
    }

    public final /* synthetic */ zzdrd zzfl(int i) {
        if (i >= this.size) {
            return new zzdqi(Arrays.copyOf(this.zzhhh, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzfj(i);
        return Double.valueOf(this.zzhhh[i]);
    }

    static {
        zzdqi zzdqi = new zzdqi(new double[0], 0);
        zzhhg = zzdqi;
        zzdqi.zzaxj();
    }
}
