package com.appsflyer.internal;

/* renamed from: com.appsflyer.internal.al */
public final class C1355al {

    /* renamed from: ʽ */
    private static int[] f3460 = new int[10];

    /* renamed from: ˊ */
    static final int[] f3461 = new int[256];

    /* renamed from: ˋ */
    static final int[] f3462 = new int[256];

    /* renamed from: ˎ */
    static final byte[] f3463 = new byte[256];

    /* renamed from: ˏ */
    static final int[] f3464 = new int[256];

    /* renamed from: ॱ */
    static final int[] f3465 = new int[256];

    /* renamed from: ॱॱ */
    private static byte[] f3466 = new byte[256];

    static {
        byte[] bArr;
        byte b;
        byte b2 = 1;
        byte b3 = 1;
        do {
            b2 = (byte) (((b2 & 128) != 0 ? (byte) 27 : 0) ^ ((b2 << 1) ^ b2));
            byte b4 = (byte) (b3 ^ (b3 << 1));
            byte b5 = (byte) (b4 ^ (b4 << 2));
            byte b6 = (byte) (b5 ^ (b5 << 4));
            b3 = (byte) (b6 ^ ((b6 & 128) != 0 ? (byte) 9 : 0));
            bArr = f3466;
            b = b2 & 255;
            byte b7 = b3 & 255;
            bArr[b] = (byte) (((((b3 ^ 99) ^ ((b7 << 1) | (b7 >> 7))) ^ ((b7 << 2) | (b7 >> 6))) ^ ((b7 << 3) | (b7 >> 5))) ^ ((b7 >> 4) | (b7 << 4)));
        } while (b != 1);
        bArr[0] = 99;
        for (int i = 0; i < 256; i++) {
            byte b8 = f3466[i] & 255;
            f3463[b8] = (byte) i;
            int i2 = i << 1;
            if (i2 >= 256) {
                i2 ^= 283;
            }
            int i3 = i2 << 1;
            if (i3 >= 256) {
                i3 ^= 283;
            }
            int i4 = i3 << 1;
            if (i4 >= 256) {
                i4 ^= 283;
            }
            int i5 = i4 ^ i;
            int i6 = ((i2 ^ (i3 ^ i4)) << 24) | (i5 << 16) | ((i5 ^ i3) << 8) | (i5 ^ i2);
            f3465[b8] = i6;
            f3464[b8] = (i6 >>> 8) | (i6 << 24);
            f3462[b8] = (i6 >>> 16) | (i6 << 16);
            f3461[b8] = (i6 << 8) | (i6 >>> 24);
        }
        f3460[0] = 16777216;
        int i7 = 1;
        for (int i8 = 1; i8 < 10; i8++) {
            i7 <<= 1;
            if (i7 >= 256) {
                i7 ^= 283;
            }
            f3460[i8] = i7 << 24;
        }
    }

    /* renamed from: ˎ */
    private static int[] m3297(byte[] bArr, int[] iArr, int i) throws IllegalArgumentException {
        if (bArr.length == 16) {
            int i2 = 4;
            int[] iArr2 = new int[((i + 1) * 4)];
            int i3 = i * 4;
            int i4 = i3 + 1;
            iArr2[0] = iArr[i3];
            int i5 = i4 + 1;
            int i6 = iArr[i4];
            int i7 = 1;
            iArr2[1] = i6;
            int i8 = i5 + 1;
            iArr2[2] = iArr[i5];
            iArr2[3] = iArr[i8];
            int i9 = i8 - 7;
            while (i7 < i) {
                int i10 = i9 + 1;
                int i11 = iArr[i9];
                int i12 = i2 + 1;
                int[] iArr3 = f3465;
                byte[] bArr2 = f3466;
                int i13 = iArr3[bArr2[i11 >>> 24] & 255];
                int[] iArr4 = f3464;
                int i14 = i13 ^ iArr4[bArr2[(i11 >>> 16) & 255] & 255];
                int[] iArr5 = f3462;
                int i15 = i14 ^ iArr5[bArr2[(i11 >>> 8) & 255] & 255];
                int[] iArr6 = f3461;
                iArr2[i2] = iArr6[bArr2[i11 & 255] & 255] ^ i15;
                int i16 = i10 + 1;
                int i17 = iArr[i10];
                int i18 = i12 + 1;
                iArr2[i12] = iArr6[bArr2[i17 & 255] & 255] ^ ((iArr3[bArr2[i17 >>> 24] & 255] ^ iArr4[bArr2[(i17 >>> 16) & 255] & 255]) ^ iArr5[bArr2[(i17 >>> 8) & 255] & 255]);
                int i19 = i16 + 1;
                int i20 = iArr[i16];
                int i21 = i18 + 1;
                iArr2[i18] = iArr6[bArr2[i20 & 255] & 255] ^ ((iArr3[bArr2[i20 >>> 24] & 255] ^ iArr4[bArr2[(i20 >>> 16) & 255] & 255]) ^ iArr5[bArr2[(i20 >>> 8) & 255] & 255]);
                int i22 = iArr[i19];
                int i23 = i21 + 1;
                iArr2[i21] = iArr6[bArr2[i22 & 255] & 255] ^ ((iArr3[bArr2[i22 >>> 24] & 255] ^ iArr4[bArr2[(i22 >>> 16) & 255] & 255]) ^ iArr5[bArr2[(i22 >>> 8) & 255] & 255]);
                i9 = i19 - 7;
                i7++;
                i2 = i23;
            }
            int i24 = i2 + 1;
            int i25 = i9 + 1;
            iArr2[i2] = iArr[i9];
            int i26 = i24 + 1;
            int i27 = i25 + 1;
            iArr2[i24] = iArr[i25];
            int i28 = i26 + 1;
            int i29 = i27 + 1;
            iArr2[i26] = iArr[i27];
            iArr2[i28] = iArr[i29];
            return iArr2;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: ˊ */
    public static byte[][] m3295(int i) {
        byte[][] bArr = new byte[4][];
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i >>> (i2 << 3);
            bArr[i2] = new byte[]{(byte) (i3 & 3), (byte) ((i3 >> 2) & 3), (byte) ((i3 >> 4) & 3), (byte) ((i3 >> 6) & 3)};
        }
        return bArr;
    }

    /* renamed from: ˋ */
    static int[] m3296(byte[] bArr, int i) throws IllegalArgumentException {
        if (bArr.length == 16) {
            int i2 = (i + 1) * 4;
            int[] iArr = new int[i2];
            int i3 = 0;
            int i4 = 0;
            while (i3 < 4) {
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                byte b = (bArr[i4] << 24) | ((bArr[i5] & 255) << 16);
                int i7 = i6 + 1;
                byte b2 = b | ((bArr[i6] & 255) << 8);
                int i8 = i7 + 1;
                iArr[i3] = b2 | (bArr[i7] & 255);
                i3++;
                i4 = i8;
            }
            int i9 = 4;
            int i10 = 0;
            int i11 = 0;
            while (i9 < i2) {
                int i12 = iArr[i9 - 1];
                if (i10 == 0) {
                    byte[] bArr2 = f3466;
                    byte b3 = (bArr2[i12 >>> 24] & 255) | (bArr2[(i12 >>> 16) & 255] << 24) | ((bArr2[(i12 >>> 8) & 255] & 255) << 16) | ((bArr2[i12 & 255] & 255) << 8);
                    i12 = b3 ^ f3460[i11];
                    i11++;
                    i10 = 4;
                }
                iArr[i9] = i12 ^ iArr[i9 - 4];
                i9++;
                i10--;
            }
            return m3297(bArr, iArr, i);
        }
        throw new IllegalArgumentException();
    }
}
