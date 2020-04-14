package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdqs extends zzdpg<Float> implements zzdrd<Float>, zzdss, RandomAccess {
    private static final zzdqs zzhke;
    private int size;
    private float[] zzhkf;

    zzdqs() {
        this(new float[10], 0);
    }

    private zzdqs(float[] fArr, int i) {
        this.zzhkf = fArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzaxk();
        if (i2 >= i) {
            float[] fArr = this.zzhkf;
            System.arraycopy(fArr, i2, fArr, i, this.size - i2);
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
        if (!(obj instanceof zzdqs)) {
            return super.equals(obj);
        }
        zzdqs zzdqs = (zzdqs) obj;
        if (this.size != zzdqs.size) {
            return false;
        }
        float[] fArr = zzdqs.zzhkf;
        for (int i = 0; i < this.size; i++) {
            if (Float.floatToIntBits(this.zzhkf[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zzhkf[i2]);
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void zzh(float f) {
        zzaxk();
        int i = this.size;
        float[] fArr = this.zzhkf;
        if (i == fArr.length) {
            float[] fArr2 = new float[(((i * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.zzhkf = fArr2;
        }
        float[] fArr3 = this.zzhkf;
        int i2 = this.size;
        this.size = i2 + 1;
        fArr3[i2] = f;
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        zzaxk();
        zzdqx.checkNotNull(collection);
        if (!(collection instanceof zzdqs)) {
            return super.addAll(collection);
        }
        zzdqs zzdqs = (zzdqs) collection;
        int i = zzdqs.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.zzhkf;
            if (i3 > fArr.length) {
                this.zzhkf = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(zzdqs.zzhkf, 0, this.zzhkf, this.size, zzdqs.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzaxk();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Float.valueOf(this.zzhkf[i]))) {
                float[] fArr = this.zzhkf;
                System.arraycopy(fArr, i + 1, fArr, i, (this.size - i) - 1);
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
        float floatValue = ((Float) obj).floatValue();
        zzaxk();
        zzfj(i);
        float[] fArr = this.zzhkf;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    public final /* synthetic */ Object remove(int i) {
        zzaxk();
        zzfj(i);
        float[] fArr = this.zzhkf;
        float f = fArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzaxk();
        if (i >= 0) {
            int i2 = this.size;
            if (i <= i2) {
                float[] fArr = this.zzhkf;
                if (i2 < fArr.length) {
                    System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
                } else {
                    float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(fArr, 0, fArr2, 0, i);
                    System.arraycopy(this.zzhkf, i, fArr2, i + 1, this.size - i);
                    this.zzhkf = fArr2;
                }
                this.zzhkf[i] = floatValue;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzfk(i));
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzh(((Float) obj).floatValue());
        return true;
    }

    public final /* synthetic */ zzdrd zzfl(int i) {
        if (i >= this.size) {
            return new zzdqs(Arrays.copyOf(this.zzhkf, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzfj(i);
        return Float.valueOf(this.zzhkf[i]);
    }

    static {
        zzdqs zzdqs = new zzdqs(new float[0], 0);
        zzhke = zzdqs;
        zzdqs.zzaxj();
    }
}
