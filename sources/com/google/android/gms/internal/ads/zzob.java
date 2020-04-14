package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzob {
    private byte[] data;
    private int zzbgg;
    private int zzbgh = 0;
    private int zzbgi;

    public zzob(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.zzbgg = i;
        this.zzbgi = i2;
        zzil();
    }

    public final void zzbd(int i) {
        int i2 = this.zzbgg;
        this.zzbgg = (i / 8) + i2;
        this.zzbgh += i % 8;
        int i3 = this.zzbgh;
        if (i3 > 7) {
            this.zzbgg++;
            this.zzbgh = i3 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.zzbgg) {
                zzil();
                return;
            } else if (zzbe(i2)) {
                this.zzbgg++;
                i2 += 2;
            }
        }
    }

    public final boolean zzih() {
        return zzbc(1) == 1;
    }

    public final int zzbc(int i) {
        byte b;
        byte b2;
        if (i == 0) {
            return 0;
        }
        int i2 = i / 8;
        byte b3 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = zzbe(this.zzbgg + 1) ? this.zzbgg + 2 : this.zzbgg + 1;
            int i5 = this.zzbgh;
            if (i5 != 0) {
                byte[] bArr = this.data;
                b2 = ((bArr[i4] & 255) >>> (8 - i5)) | ((bArr[this.zzbgg] & 255) << i5);
            } else {
                b2 = this.data[this.zzbgg];
            }
            i -= 8;
            b3 |= (255 & b2) << i;
            this.zzbgg = i4;
        }
        if (i > 0) {
            int i6 = this.zzbgh + i;
            byte b4 = (byte) (255 >> (8 - i));
            int i7 = zzbe(this.zzbgg + 1) ? this.zzbgg + 2 : this.zzbgg + 1;
            if (i6 > 8) {
                byte[] bArr2 = this.data;
                b = (b4 & (((255 & bArr2[i7]) >> (16 - i6)) | ((bArr2[this.zzbgg] & 255) << (i6 - 8)))) | b3;
                this.zzbgg = i7;
            } else {
                b = (b4 & ((255 & this.data[this.zzbgg]) >> (8 - i6))) | b3;
                if (i6 == 8) {
                    this.zzbgg = i7;
                }
            }
            b3 = b;
            this.zzbgh = i6 % 8;
        }
        zzil();
        return b3;
    }

    public final int zzii() {
        return zzik();
    }

    public final int zzij() {
        int zzik = zzik();
        return (zzik % 2 == 0 ? -1 : 1) * ((zzik + 1) / 2);
    }

    private final int zzik() {
        int i = 0;
        int i2 = 0;
        while (!zzih()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = zzbc(i2);
        }
        return i3 + i;
    }

    private final boolean zzbe(int i) {
        if (2 <= i && i < this.zzbgi) {
            byte[] bArr = this.data;
            if (bArr[i] == 3 && bArr[i - 2] == 0 && bArr[i - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    private final void zzil() {
        boolean z;
        int i = this.zzbgg;
        if (i >= 0) {
            int i2 = this.zzbgh;
            if (i2 >= 0 && i2 < 8) {
                int i3 = this.zzbgi;
                if (i < i3 || (i == i3 && i2 == 0)) {
                    z = true;
                    zznr.checkState(z);
                }
            }
        }
        z = false;
        zznr.checkState(z);
    }
}
