package com.appsflyer.internal;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.appsflyer.internal.ar */
public final class C1359ar extends FilterInputStream {

    /* renamed from: ˊ */
    private static final int[] f3501 = C1355al.f3465;

    /* renamed from: ˋ */
    private static final int[] f3502 = C1355al.f3462;

    /* renamed from: ˎ */
    private static final int[] f3503 = C1355al.f3461;

    /* renamed from: ˏ */
    private static final int[] f3504 = C1355al.f3464;

    /* renamed from: ॱ */
    private static final byte[] f3505 = C1355al.f3463;

    /* renamed from: ʻ */
    private final byte[][] f3506;

    /* renamed from: ʼ */
    private final byte[] f3507 = new byte[16];

    /* renamed from: ʽ */
    private final int[] f3508 = new int[4];

    /* renamed from: ˊॱ */
    private int f3509 = 16;

    /* renamed from: ˋॱ */
    private int f3510 = Integer.MAX_VALUE;

    /* renamed from: ˏॱ */
    private final byte[] f3511 = new byte[16];

    /* renamed from: ͺ */
    private int f3512 = 16;

    /* renamed from: ॱॱ */
    private final int[] f3513;

    /* renamed from: ᐝ */
    private final int f3514;

    public final boolean markSupported() {
        return false;
    }

    public C1359ar(InputStream inputStream, int i, byte[] bArr, byte[][] bArr2) {
        super(inputStream);
        this.f3514 = i;
        this.f3513 = C1355al.m3296(bArr, i);
        this.f3506 = m3311(bArr2);
    }

    public final int read() throws IOException {
        m3312();
        int i = this.f3512;
        if (i >= this.f3509) {
            return -1;
        }
        byte[] bArr = this.f3511;
        this.f3512 = i + 1;
        return bArr[i] & 255;
    }

    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i + i2;
        int i4 = i;
        while (i4 < i3) {
            m3312();
            int i5 = this.f3512;
            if (i5 < this.f3509) {
                int i6 = i4 + 1;
                byte[] bArr2 = this.f3511;
                this.f3512 = i5 + 1;
                bArr[i4] = bArr2[i5];
                i4 = i6;
            } else if (i4 == i) {
                return -1;
            } else {
                return i2 - (i3 - i4);
            }
        }
        return i2;
    }

    public final long skip(long j) throws IOException {
        long j2 = 0;
        while (j2 < j && read() != -1) {
            j2++;
        }
        return j2;
    }

    public final int available() throws IOException {
        return this.f3509 - this.f3512;
    }

    public final void close() throws IOException {
        super.close();
    }

    public final synchronized void mark(int i) {
    }

    public final synchronized void reset() throws IOException {
    }

    /* renamed from: ˋ */
    private static byte[][] m3311(byte[][] bArr) {
        byte[][] bArr2 = new byte[bArr.length][];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = new byte[bArr[i].length];
            for (int i2 = 0; i2 < bArr[i].length; i2++) {
                bArr2[i][bArr[i][i2]] = (byte) i2;
            }
        }
        return bArr2;
    }

    /* renamed from: ˎ */
    private int m3312() throws IOException {
        if (this.f3510 == Integer.MAX_VALUE) {
            this.f3510 = this.in.read();
        }
        int i = 16;
        if (this.f3512 == 16) {
            this.f3507[0] = (byte) this.f3510;
            int i2 = 1;
            do {
                i2 += this.in.read(this.f3507, i2, 16 - i2);
            } while (i2 < 16);
            m3313(this.f3507, this.f3511);
            this.f3510 = this.in.read();
            this.f3512 = 0;
            if (this.f3510 < 0) {
                i = 16 - (this.f3511[15] & 255);
            }
            this.f3509 = i;
        }
        return this.f3509;
    }

    /* renamed from: ˏ */
    private void m3313(byte[] bArr, byte[] bArr2) {
        int[] iArr = this.f3508;
        char c = 1;
        byte b = (bArr[0] << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        int[] iArr2 = this.f3513;
        iArr[0] = b ^ iArr2[0];
        iArr[1] = ((((bArr[4] << 24) | ((bArr[5] & 255) << 16)) | ((bArr[6] & 255) << 8)) | (bArr[7] & 255)) ^ iArr2[1];
        iArr[2] = ((((bArr[8] << 24) | ((bArr[9] & 255) << 16)) | ((bArr[10] & 255) << 8)) | (bArr[11] & 255)) ^ iArr2[2];
        iArr[3] = iArr2[3] ^ ((((bArr[12] << 24) | ((bArr[13] & 255) << 16)) | ((bArr[14] & 255) << 8)) | (bArr[15] & 255));
        int i = 1;
        int i2 = 4;
        while (i < this.f3514) {
            int[] iArr3 = f3501;
            int[] iArr4 = this.f3508;
            byte[][] bArr3 = this.f3506;
            int i3 = iArr3[iArr4[bArr3[0][0]] >>> 24];
            int[] iArr5 = f3504;
            int i4 = i3 ^ iArr5[(iArr4[bArr3[c][0]] >>> 16) & 255];
            int[] iArr6 = f3502;
            int i5 = iArr6[(iArr4[bArr3[2][0]] >>> 8) & 255] ^ i4;
            int[] iArr7 = f3503;
            int i6 = iArr7[iArr4[bArr3[3][0]] & 255] ^ i5;
            int[] iArr8 = this.f3513;
            int i7 = i6 ^ iArr8[i2];
            int i8 = ((iArr6[(iArr4[bArr3[2][c]] >>> 8) & 255] ^ (iArr3[iArr4[bArr3[0][c]] >>> 24] ^ iArr5[(iArr4[bArr3[c][c]] >>> 16) & 255])) ^ iArr7[iArr4[bArr3[3][c]] & 255]) ^ iArr8[i2 + 1];
            int i9 = (((iArr5[(iArr4[bArr3[c][2]] >>> 16) & 255] ^ iArr3[iArr4[bArr3[0][2]] >>> 24]) ^ iArr6[(iArr4[bArr3[2][2]] >>> 8) & 255]) ^ iArr7[iArr4[bArr3[3][2]] & 255]) ^ iArr8[i2 + 2];
            int i10 = (((iArr3[iArr4[bArr3[0][3]] >>> 24] ^ iArr5[(iArr4[bArr3[1][3]] >>> 16) & 255]) ^ iArr6[(iArr4[bArr3[2][3]] >>> 8) & 255]) ^ iArr7[iArr4[bArr3[3][3]] & 255]) ^ iArr8[i2 + 3];
            iArr4[0] = i7;
            iArr4[1] = i8;
            iArr4[2] = i9;
            iArr4[3] = i10;
            i++;
            i2 += 4;
            c = 1;
        }
        int[] iArr9 = this.f3513;
        int i11 = iArr9[i2];
        byte[] bArr4 = f3505;
        int[] iArr10 = this.f3508;
        byte[][] bArr5 = this.f3506;
        bArr2[0] = (byte) (bArr4[iArr10[bArr5[0][0]] >>> 24] ^ (i11 >>> 24));
        bArr2[1] = (byte) (bArr4[(iArr10[bArr5[1][0]] >>> 16) & 255] ^ (i11 >>> 16));
        bArr2[2] = (byte) (bArr4[(iArr10[bArr5[2][0]] >>> 8) & 255] ^ (i11 >>> 8));
        bArr2[3] = (byte) (i11 ^ bArr4[iArr10[bArr5[3][0]] & 255]);
        int i12 = iArr9[i2 + 1];
        bArr2[4] = (byte) (bArr4[iArr10[bArr5[0][1]] >>> 24] ^ (i12 >>> 24));
        bArr2[5] = (byte) (bArr4[(iArr10[bArr5[1][1]] >>> 16) & 255] ^ (i12 >>> 16));
        bArr2[6] = (byte) (bArr4[(iArr10[bArr5[2][1]] >>> 8) & 255] ^ (i12 >>> 8));
        bArr2[7] = (byte) (i12 ^ bArr4[iArr10[bArr5[3][1]] & 255]);
        int i13 = iArr9[i2 + 2];
        bArr2[8] = (byte) (bArr4[iArr10[bArr5[0][2]] >>> 24] ^ (i13 >>> 24));
        bArr2[9] = (byte) (bArr4[(iArr10[bArr5[1][2]] >>> 16) & 255] ^ (i13 >>> 16));
        bArr2[10] = (byte) (bArr4[(iArr10[bArr5[2][2]] >>> 8) & 255] ^ (i13 >>> 8));
        bArr2[11] = (byte) (i13 ^ bArr4[iArr10[bArr5[3][2]] & 255]);
        int i14 = iArr9[i2 + 3];
        bArr2[12] = (byte) (bArr4[iArr10[bArr5[0][3]] >>> 24] ^ (i14 >>> 24));
        bArr2[13] = (byte) (bArr4[(iArr10[bArr5[1][3]] >>> 16) & 255] ^ (i14 >>> 16));
        bArr2[14] = (byte) (bArr4[(iArr10[bArr5[2][3]] >>> 8) & 255] ^ (i14 >>> 8));
        bArr2[15] = (byte) (i14 ^ bArr4[iArr10[bArr5[3][3]] & 255]);
    }
}
