package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zznw {
    private int size;
    private long[] zzbgc;

    public zznw() {
        this(32);
    }

    private zznw(int i) {
        this.zzbgc = new long[32];
    }

    public final void add(long j) {
        int i = this.size;
        long[] jArr = this.zzbgc;
        if (i == jArr.length) {
            this.zzbgc = Arrays.copyOf(jArr, i << 1);
        }
        long[] jArr2 = this.zzbgc;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr2[i2] = j;
    }

    public final long get(int i) {
        if (i >= 0 && i < this.size) {
            return this.zzbgc[i];
        }
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Invalid index ");
        sb.append(i);
        sb.append(", size is ");
        sb.append(i2);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final int size() {
        return this.size;
    }
}
