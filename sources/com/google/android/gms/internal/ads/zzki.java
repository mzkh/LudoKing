package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzki {
    private static final int[] zzaxh = {zzof.zzbi("isom"), zzof.zzbi("iso2"), zzof.zzbi("iso3"), zzof.zzbi("iso4"), zzof.zzbi("iso5"), zzof.zzbi("iso6"), zzof.zzbi("avc1"), zzof.zzbi("hvc1"), zzof.zzbi("hev1"), zzof.zzbi("mp41"), zzof.zzbi("mp42"), zzof.zzbi("3g2a"), zzof.zzbi("3g2b"), zzof.zzbi("3gr6"), zzof.zzbi("3gs6"), zzof.zzbi("3ge6"), zzof.zzbi("3gg6"), zzof.zzbi("M4V "), zzof.zzbi("M4A "), zzof.zzbi("f4v "), zzof.zzbi("kddi"), zzof.zzbi("M4VP"), zzof.zzbi("qt  "), zzof.zzbi("MSNV")};

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b7, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b8, code lost:
        if (r5 == false) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ba, code lost:
        if (r0 != false) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00bd, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zzd(com.google.android.gms.internal.ads.zziv r16) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r0 = r16
            long r1 = r16.getLength()
            r3 = 4096(0x1000, double:2.0237E-320)
            r5 = -1
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0012
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0013
        L_0x0012:
            r1 = r3
        L_0x0013:
            int r2 = (int) r1
            com.google.android.gms.internal.ads.zzoc r1 = new com.google.android.gms.internal.ads.zzoc
            r3 = 64
            r1.<init>(r3)
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x001e:
            if (r4 >= r2) goto L_0x00b7
            r7 = 8
            r1.reset(r7)
            byte[] r8 = r1.data
            r0.zza(r8, r3, r7)
            long r8 = r1.zzio()
            int r10 = r1.readInt()
            r11 = 1
            r13 = 16
            int r14 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r14 != 0) goto L_0x0047
            byte[] r8 = r1.data
            r0.zza(r8, r7, r7)
            r1.zzbf(r13)
            long r8 = r1.zzis()
            goto L_0x0049
        L_0x0047:
            r13 = 8
        L_0x0049:
            long r11 = (long) r13
            int r14 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r14 < 0) goto L_0x00be
            int r4 = r4 + r13
            int r13 = com.google.android.gms.internal.ads.zzjs.zzary
            if (r10 == r13) goto L_0x001e
            int r13 = com.google.android.gms.internal.ads.zzjs.zzash
            if (r10 == r13) goto L_0x00b5
            int r13 = com.google.android.gms.internal.ads.zzjs.zzasj
            if (r10 != r13) goto L_0x005c
            goto L_0x00b5
        L_0x005c:
            long r13 = (long) r4
            long r13 = r13 + r8
            long r13 = r13 - r11
            long r6 = (long) r2
            int r15 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r15 >= 0) goto L_0x00b7
            long r8 = r8 - r11
            int r6 = (int) r8
            int r4 = r4 + r6
            int r7 = com.google.android.gms.internal.ads.zzjs.zzaqx
            if (r10 != r7) goto L_0x00ae
            r7 = 8
            if (r6 < r7) goto L_0x00be
            r1.reset(r6)
            byte[] r7 = r1.data
            r0.zza(r7, r3, r6)
            int r6 = r6 / 4
            r7 = 0
        L_0x007a:
            if (r7 >= r6) goto L_0x00aa
            r8 = 1
            if (r7 != r8) goto L_0x0084
            r8 = 4
            r1.zzbh(r8)
            goto L_0x00a7
        L_0x0084:
            int r8 = r1.readInt()
            int r9 = r8 >>> 8
            java.lang.String r10 = "3gp"
            int r10 = com.google.android.gms.internal.ads.zzof.zzbi(r10)
            if (r9 != r10) goto L_0x0094
        L_0x0092:
            r8 = 1
            goto L_0x00a3
        L_0x0094:
            int[] r9 = zzaxh
            int r10 = r9.length
            r11 = 0
        L_0x0098:
            if (r11 >= r10) goto L_0x00a2
            r12 = r9[r11]
            if (r12 != r8) goto L_0x009f
            goto L_0x0092
        L_0x009f:
            int r11 = r11 + 1
            goto L_0x0098
        L_0x00a2:
            r8 = 0
        L_0x00a3:
            if (r8 == 0) goto L_0x00a7
            r5 = 1
            goto L_0x00aa
        L_0x00a7:
            int r7 = r7 + 1
            goto L_0x007a
        L_0x00aa:
            if (r5 == 0) goto L_0x00be
            goto L_0x001e
        L_0x00ae:
            if (r6 == 0) goto L_0x001e
            r0.zzac(r6)
            goto L_0x001e
        L_0x00b5:
            r0 = 1
            goto L_0x00b8
        L_0x00b7:
            r0 = 0
        L_0x00b8:
            if (r5 == 0) goto L_0x00be
            if (r0 != 0) goto L_0x00be
            r0 = 1
            return r0
        L_0x00be:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzki.zzd(com.google.android.gms.internal.ads.zziv):boolean");
    }
}
