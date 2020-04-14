package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdun implements Cloneable {
    private static final zzduq zzhqz = new zzduq();
    private int mSize;
    private boolean zzhra;
    private int[] zzhrb;
    private zzduq[] zzhrc;

    zzdun() {
        this(10);
    }

    private zzdun(int i) {
        this.zzhra = false;
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
        int i5 = i2 / 4;
        this.zzhrb = new int[i5];
        this.zzhrc = new zzduq[i5];
        this.mSize = 0;
    }

    /* access modifiers changed from: 0000 */
    public final int size() {
        return this.mSize;
    }

    /* access modifiers changed from: 0000 */
    public final zzduq zzhf(int i) {
        return this.zzhrc[i];
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdun)) {
            return false;
        }
        zzdun zzdun = (zzdun) obj;
        int i = this.mSize;
        if (i != zzdun.mSize) {
            return false;
        }
        int[] iArr = this.zzhrb;
        int[] iArr2 = zzdun.zzhrb;
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
            zzduq[] zzduqArr = this.zzhrc;
            zzduq[] zzduqArr2 = zzdun.zzhrc;
            int i3 = this.mSize;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                } else if (!zzduqArr[i4].equals(zzduqArr2[i4])) {
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
            i = (((i * 31) + this.zzhrb[i2]) * 31) + this.zzhrc[i2].hashCode();
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.mSize;
        zzdun zzdun = new zzdun(i);
        System.arraycopy(this.zzhrb, 0, zzdun.zzhrb, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            zzduq[] zzduqArr = this.zzhrc;
            if (zzduqArr[i2] != null) {
                zzdun.zzhrc[i2] = (zzduq) zzduqArr[i2].clone();
            }
        }
        zzdun.mSize = i;
        return zzdun;
    }
}
