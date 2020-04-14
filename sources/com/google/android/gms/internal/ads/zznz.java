package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zznz {
    private byte[] data;
    private int zzbgg;
    private int zzbgh;
    private int zzbgi;

    public zznz() {
    }

    public zznz(byte[] bArr) {
        this(bArr, bArr.length);
    }

    private zznz(byte[] bArr, int i) {
        this.data = bArr;
        this.zzbgi = i;
    }

    public final int zzbc(int i) {
        byte b;
        byte b2;
        boolean z = false;
        if (i == 0) {
            return 0;
        }
        int i2 = i / 8;
        int i3 = i;
        byte b3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = this.zzbgh;
            if (i5 != 0) {
                byte[] bArr = this.data;
                int i6 = this.zzbgg;
                b2 = ((bArr[i6 + 1] & 255) >>> (8 - i5)) | ((bArr[i6] & 255) << i5);
            } else {
                b2 = this.data[this.zzbgg];
            }
            i3 -= 8;
            b3 |= (255 & b2) << i3;
            this.zzbgg++;
        }
        if (i3 > 0) {
            int i7 = this.zzbgh + i3;
            byte b4 = (byte) (255 >> (8 - i3));
            if (i7 > 8) {
                byte[] bArr2 = this.data;
                int i8 = this.zzbgg;
                b = (b4 & (((bArr2[i8 + 1] & 255) >> (16 - i7)) | ((bArr2[i8] & 255) << (i7 - 8)))) | b3;
                this.zzbgg = i8 + 1;
            } else {
                byte[] bArr3 = this.data;
                int i9 = this.zzbgg;
                b = (b4 & ((bArr3[i9] & 255) >> (8 - i7))) | b3;
                if (i7 == 8) {
                    this.zzbgg = i9 + 1;
                }
            }
            b3 = b;
            this.zzbgh = i7 % 8;
        }
        int i10 = this.zzbgg;
        if (i10 >= 0) {
            int i11 = this.zzbgh;
            if (i11 >= 0 && i11 < 8) {
                int i12 = this.zzbgi;
                if (i10 < i12 || (i10 == i12 && i11 == 0)) {
                    z = true;
                }
            }
        }
        zznr.checkState(z);
        return b3;
    }
}
