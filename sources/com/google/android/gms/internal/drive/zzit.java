package com.google.android.gms.internal.drive;

public final class zzit implements Cloneable {
    private static final zziu zzmy = new zziu();
    private int mSize;
    private boolean zzmz;
    private int[] zzna;
    private zziu[] zznb;

    zzit() {
        this(10);
    }

    private zzit(int i) {
        this.zzmz = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzna = new int[idealIntArraySize];
        this.zznb = new zziu[idealIntArraySize];
        this.mSize = 0;
    }

    private static int idealIntArraySize(int i) {
        int i2 = i << 2;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (i2 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        return i2 / 4;
    }

    private final int zzt(int i) {
        int i2 = this.mSize - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.zzna[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i2 = i4 - 1;
            }
        }
        return i3 ^ -1;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.mSize;
        zzit zzit = new zzit(i);
        System.arraycopy(this.zzna, 0, zzit.zzna, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            zziu[] zziuArr = this.zznb;
            if (zziuArr[i2] != null) {
                zzit.zznb[i2] = (zziu) zziuArr[i2].clone();
            }
        }
        zzit.mSize = i;
        return zzit;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzit)) {
            return false;
        }
        zzit zzit = (zzit) obj;
        int i = this.mSize;
        if (i != zzit.mSize) {
            return false;
        }
        int[] iArr = this.zzna;
        int[] iArr2 = zzit.zzna;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                z = true;
                break;
            } else if (iArr[i2] != iArr2[i2]) {
                z = false;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            zziu[] zziuArr = this.zznb;
            zziu[] zziuArr2 = zzit.zznb;
            int i3 = this.mSize;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                } else if (!zziuArr[i4].equals(zziuArr2[i4])) {
                    z2 = false;
                    break;
                } else {
                    i4++;
                }
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzna[i2]) * 31) + this.zznb[i2].hashCode();
        }
        return i;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    /* access modifiers changed from: 0000 */
    public final int size() {
        return this.mSize;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(int i, zziu zziu) {
        int zzt = zzt(i);
        if (zzt >= 0) {
            this.zznb[zzt] = zziu;
            return;
        }
        int i2 = zzt ^ -1;
        if (i2 < this.mSize) {
            zziu[] zziuArr = this.zznb;
            if (zziuArr[i2] == zzmy) {
                this.zzna[i2] = i;
                zziuArr[i2] = zziu;
                return;
            }
        }
        int i3 = this.mSize;
        if (i3 >= this.zzna.length) {
            int idealIntArraySize = idealIntArraySize(i3 + 1);
            int[] iArr = new int[idealIntArraySize];
            zziu[] zziuArr2 = new zziu[idealIntArraySize];
            int[] iArr2 = this.zzna;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            zziu[] zziuArr3 = this.zznb;
            System.arraycopy(zziuArr3, 0, zziuArr2, 0, zziuArr3.length);
            this.zzna = iArr;
            this.zznb = zziuArr2;
        }
        int i4 = this.mSize;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.zzna;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            zziu[] zziuArr4 = this.zznb;
            System.arraycopy(zziuArr4, i2, zziuArr4, i5, this.mSize - i2);
        }
        this.zzna[i2] = i;
        this.zznb[i2] = zziu;
        this.mSize++;
    }

    /* access modifiers changed from: 0000 */
    public final zziu zzr(int i) {
        int zzt = zzt(i);
        if (zzt >= 0) {
            zziu[] zziuArr = this.zznb;
            if (zziuArr[zzt] != zzmy) {
                return zziuArr[zzt];
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public final zziu zzs(int i) {
        return this.zznb[i];
    }
}
