package com.appsflyer.internal;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* renamed from: com.appsflyer.internal.aj */
public final class C1353aj extends FilterInputStream {

    /* renamed from: ʽ */
    private int f3453;

    /* renamed from: ˊ */
    private short f3454;

    /* renamed from: ˋ */
    private long[] f3455 = new long[4];

    /* renamed from: ˎ */
    private int[] f3456;

    /* renamed from: ˏ */
    private long[] f3457 = new long[4];

    /* renamed from: ॱ */
    private final int f3458;

    /* renamed from: ᐝ */
    private int f3459;

    public final boolean markSupported() {
        return false;
    }

    public C1353aj(InputStream inputStream, int i, int i2, short s, int i3, int i4) throws IOException {
        super(inputStream);
        this.f3458 = Math.min(Math.max(s, 4), 8);
        int i5 = this.f3458;
        this.f3456 = new int[i5];
        this.f3453 = i5;
        this.f3457 = C1354ak.m3294(i ^ i4, i5 ^ i4);
        this.f3455 = C1354ak.m3294(i2 ^ i4, i3 ^ i4);
        this.f3459 = this.in.read();
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        int read = read();
        if (read == -1) {
            return -1;
        }
        bArr[i] = (byte) read;
        int i3 = 1;
        while (i3 < i2) {
            int read2 = read();
            if (read2 == -1) {
                return i3;
            }
            bArr[i + i3] = (byte) read2;
            i3++;
        }
        return i3;
    }

    public final long skip(long j) throws IOException {
        long j2 = 0;
        while (j2 < j && read() != -1) {
            j2++;
        }
        return j2;
    }

    public final int available() throws IOException {
        return this.f3458 - this.f3453;
    }

    public final int read() throws IOException {
        if (this.f3453 == this.f3458) {
            int i = this.f3459;
            if (i == -1) {
                Arrays.fill(this.f3456, -1);
            } else {
                this.f3456[0] = i;
                for (int i2 = 1; i2 < this.f3458; i2++) {
                    this.f3456[i2] = this.in.read();
                }
                long[] jArr = this.f3457;
                long[] jArr2 = this.f3455;
                short s = this.f3454;
                int i3 = (s + 2) % 4;
                long j = ((jArr[s % 4] * 2147483085) + jArr2[i3]) % 2147483647L;
                int i4 = (s + 3) % 4;
                jArr2[i4] = ((jArr[i4] * 2147483085) + jArr2[i3]) / 2147483647L;
                jArr[i4] = j;
                for (int i5 = 0; i5 < this.f3458; i5++) {
                    int[] iArr = this.f3456;
                    iArr[i5] = (int) (((long) iArr[i5]) ^ ((this.f3457[this.f3454] >> (i5 << 3)) & 255));
                }
                this.f3454 = (short) ((this.f3454 + 1) % 4);
                this.f3459 = this.in.read();
                if (this.f3459 == -1) {
                    int i6 = this.f3458;
                    int[] iArr2 = this.f3456;
                    Arrays.fill(iArr2, i6 - iArr2[i6 - 1], i6, -1);
                }
            }
            this.f3453 = 0;
        }
        int[] iArr3 = this.f3456;
        int i7 = this.f3453;
        this.f3453 = i7 + 1;
        return iArr3[i7];
    }
}
