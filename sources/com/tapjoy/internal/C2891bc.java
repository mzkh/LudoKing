package com.tapjoy.internal;

import java.io.FilterInputStream;
import java.io.InputStream;

/* renamed from: com.tapjoy.internal.bc */
public final class C2891bc extends FilterInputStream {
    public C2891bc(InputStream inputStream) {
        super(inputStream);
    }

    public final int read(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int read = super.read(bArr, i + i3, i2 - i3);
            if (read != -1) {
                i3 += read;
            } else if (i3 != 0) {
                return i3;
            } else {
                return -1;
            }
        }
        return i3;
    }

    public final int read(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int read = super.read(bArr, i, bArr.length - i);
            if (read != -1) {
                i += read;
            } else if (i != 0) {
                return i;
            } else {
                return -1;
            }
        }
        return i;
    }

    public final long skip(long j) {
        long j2 = 0;
        while (j2 < j) {
            long skip = super.skip(j - j2);
            if (skip == 0) {
                if (super.read() < 0) {
                    break;
                }
                skip++;
            }
            j2 += skip;
        }
        return j2;
    }
}
