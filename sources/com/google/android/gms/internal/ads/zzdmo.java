package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdmo extends zzdml {
    private static final int[] zzhbl = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private static final int[] zzhbm = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private int state;
    private int value;
    private final int[] zzhbn;

    public zzdmo(int i, byte[] bArr) {
        this.zzhbj = bArr;
        this.zzhbn = (i & 8) == 0 ? zzhbl : zzhbm;
        this.state = 0;
        this.value = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007d, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f5, code lost:
        if (r9 == 0) goto L_0x011e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f7, code lost:
        if (r9 == 1) goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00f9, code lost:
        if (r9 == 2) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00fb, code lost:
        if (r9 == 3) goto L_0x0103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00fd, code lost:
        if (r9 == 4) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0100, code lost:
        r0.state = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0103, code lost:
        r1 = r11 + 1;
        r5[r11] = (byte) (r10 >> 10);
        r11 = r1 + 1;
        r5[r1] = (byte) (r10 >> 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0112, code lost:
        r1 = r11 + 1;
        r5[r11] = (byte) (r10 >> 4);
        r11 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x011b, code lost:
        r0.state = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x011e, code lost:
        r0.state = r9;
        r0.zzhbk = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0122, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(byte[] r18, int r19, int r20, boolean r21) {
        /*
            r17 = this;
            r0 = r17
            r1 = r20
            int r2 = r0.state
            r3 = 0
            r4 = 6
            if (r2 != r4) goto L_0x000b
            return r3
        L_0x000b:
            byte[] r5 = r0.zzhbj
            int[] r6 = r0.zzhbn
            r7 = 5
            r8 = 4
            r9 = r2
            r2 = 0
            r10 = 0
            r11 = 0
        L_0x0015:
            r12 = 3
            r13 = 2
            r14 = 1
            if (r2 >= r1) goto L_0x00f5
            if (r9 != 0) goto L_0x0060
        L_0x001c:
            int r15 = r2 + 4
            if (r15 > r1) goto L_0x005e
            byte r10 = r18[r2]
            r10 = r10 & 255(0xff, float:3.57E-43)
            r10 = r6[r10]
            int r10 = r10 << 18
            int r16 = r2 + 1
            byte r3 = r18[r16]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r3 = r6[r3]
            int r3 = r3 << 12
            r3 = r3 | r10
            int r10 = r2 + 2
            byte r10 = r18[r10]
            r10 = r10 & 255(0xff, float:3.57E-43)
            r10 = r6[r10]
            int r10 = r10 << r4
            r3 = r3 | r10
            int r10 = r2 + 3
            byte r10 = r18[r10]
            r10 = r10 & 255(0xff, float:3.57E-43)
            r10 = r6[r10]
            r10 = r10 | r3
            if (r10 < 0) goto L_0x005e
            int r2 = r11 + 2
            byte r3 = (byte) r10
            r5[r2] = r3
            int r2 = r11 + 1
            int r3 = r10 >> 8
            byte r3 = (byte) r3
            r5[r2] = r3
            int r2 = r10 >> 16
            byte r2 = (byte) r2
            r5[r11] = r2
            int r11 = r11 + 3
            r2 = r15
            r3 = 0
            goto L_0x001c
        L_0x005e:
            if (r2 >= r1) goto L_0x00f5
        L_0x0060:
            int r3 = r2 + 1
            byte r2 = r18[r2]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r2 = r6[r2]
            r15 = -1
            if (r9 == 0) goto L_0x00e5
            if (r9 == r14) goto L_0x00d7
            r14 = -2
            if (r9 == r13) goto L_0x00c0
            if (r9 == r12) goto L_0x0087
            if (r9 == r8) goto L_0x007e
            if (r9 == r7) goto L_0x0078
            goto L_0x00f1
        L_0x0078:
            if (r2 == r15) goto L_0x00f1
            r0.state = r4
        L_0x007c:
            r12 = 0
            return r12
        L_0x007e:
            r12 = 0
            if (r2 != r14) goto L_0x0082
            goto L_0x00dd
        L_0x0082:
            if (r2 == r15) goto L_0x00f1
            r0.state = r4
            return r12
        L_0x0087:
            if (r2 < 0) goto L_0x00a5
            int r9 = r10 << 6
            r10 = r9 | r2
            int r2 = r11 + 2
            byte r9 = (byte) r10
            r5[r2] = r9
            int r2 = r11 + 1
            int r9 = r10 >> 8
            byte r9 = (byte) r9
            r5[r2] = r9
            int r2 = r10 >> 16
            byte r2 = (byte) r2
            r5[r11] = r2
            int r11 = r11 + 3
            r2 = r3
            r3 = 0
            r9 = 0
            goto L_0x0015
        L_0x00a5:
            if (r2 != r14) goto L_0x00ba
            int r2 = r11 + 1
            int r9 = r10 >> 2
            byte r9 = (byte) r9
            r5[r2] = r9
            int r2 = r10 >> 10
            byte r2 = (byte) r2
            r5[r11] = r2
            int r11 = r11 + 2
            r2 = r3
            r3 = 0
            r9 = 5
            goto L_0x0015
        L_0x00ba:
            if (r2 == r15) goto L_0x00f1
            r0.state = r4
        L_0x00be:
            r1 = 0
            return r1
        L_0x00c0:
            if (r2 < 0) goto L_0x00c3
            goto L_0x00da
        L_0x00c3:
            if (r2 != r14) goto L_0x00d2
            int r2 = r11 + 1
            int r9 = r10 >> 4
            byte r9 = (byte) r9
            r5[r11] = r9
            r11 = r2
            r2 = r3
            r3 = 0
            r9 = 4
            goto L_0x0015
        L_0x00d2:
            if (r2 == r15) goto L_0x00f1
            r0.state = r4
            goto L_0x007c
        L_0x00d7:
            r12 = 0
            if (r2 < 0) goto L_0x00e0
        L_0x00da:
            int r10 = r10 << 6
            r10 = r10 | r2
        L_0x00dd:
            int r9 = r9 + 1
            goto L_0x00f1
        L_0x00e0:
            if (r2 == r15) goto L_0x00f1
            r0.state = r4
            return r12
        L_0x00e5:
            r12 = 0
            if (r2 < 0) goto L_0x00ec
            int r9 = r9 + 1
            r10 = r2
            goto L_0x00f1
        L_0x00ec:
            if (r2 == r15) goto L_0x00f1
            r0.state = r4
            return r12
        L_0x00f1:
            r2 = r3
            r3 = 0
            goto L_0x0015
        L_0x00f5:
            if (r9 == 0) goto L_0x011e
            if (r9 == r14) goto L_0x011b
            if (r9 == r13) goto L_0x0112
            if (r9 == r12) goto L_0x0103
            if (r9 == r8) goto L_0x0100
            goto L_0x011e
        L_0x0100:
            r0.state = r4
            goto L_0x00be
        L_0x0103:
            int r1 = r11 + 1
            int r2 = r10 >> 10
            byte r2 = (byte) r2
            r5[r11] = r2
            int r11 = r1 + 1
            int r2 = r10 >> 2
            byte r2 = (byte) r2
            r5[r1] = r2
            goto L_0x011e
        L_0x0112:
            int r1 = r11 + 1
            int r2 = r10 >> 4
            byte r2 = (byte) r2
            r5[r11] = r2
            r11 = r1
            goto L_0x011e
        L_0x011b:
            r0.state = r4
            goto L_0x00be
        L_0x011e:
            r0.state = r9
            r0.zzhbk = r11
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdmo.zzb(byte[], int, int, boolean):boolean");
    }
}
