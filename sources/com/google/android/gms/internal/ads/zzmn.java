package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzmn extends zzms {
    private static final int[] zzbdh = new int[0];
    private final zzmw zzbdi;
    private final AtomicReference<zzmq> zzbdj;

    public zzmn() {
        this(null);
    }

    private static int zzd(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    private static boolean zze(int i, boolean z) {
        int i2 = i & 3;
        return i2 == 3 || (z && i2 == 2);
    }

    private zzmn(zzmw zzmw) {
        this.zzbdi = null;
        this.zzbdj = new AtomicReference<>(new zzmq());
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0186, code lost:
        if (r9.zzaey <= r11) goto L_0x018b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x01ec A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzmt[] zza(com.google.android.gms.internal.ads.zzgw[] r37, com.google.android.gms.internal.ads.zzmk[] r38, int[][][] r39) throws com.google.android.gms.internal.ads.zzgd {
        /*
            r36 = this;
            r0 = r37
            int r1 = r0.length
            com.google.android.gms.internal.ads.zzmt[] r2 = new com.google.android.gms.internal.ads.zzmt[r1]
            r3 = r36
            java.util.concurrent.atomic.AtomicReference<com.google.android.gms.internal.ads.zzmq> r4 = r3.zzbdj
            java.lang.Object r4 = r4.get()
            com.google.android.gms.internal.ads.zzmq r4 = (com.google.android.gms.internal.ads.zzmq) r4
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x0012:
            r9 = 2
            if (r6 >= r1) goto L_0x0269
            r13 = r0[r6]
            int r13 = r13.getTrackType()
            if (r9 != r13) goto L_0x0251
            if (r7 != 0) goto L_0x0238
            r7 = r38[r6]
            r13 = r39[r6]
            int r14 = r4.zzbdo
            int r15 = r4.zzbdp
            int r11 = r4.zzbdq
            int r9 = r4.viewportWidth
            int r5 = r4.viewportHeight
            boolean r10 = r4.zzbdt
            boolean r12 = r4.zzbdr
            boolean r3 = r4.zzbds
            r21 = r1
            r20 = r4
            r25 = r8
            r0 = 0
            r1 = 0
            r4 = 0
            r22 = 0
            r23 = -1
            r24 = -1
        L_0x0042:
            int r8 = r7.length
            if (r4 >= r8) goto L_0x0216
            com.google.android.gms.internal.ads.zzmh r8 = r7.zzav(r4)
            r26 = r7
            java.util.ArrayList r7 = new java.util.ArrayList
            r27 = r2
            int r2 = r8.length
            r7.<init>(r2)
            r28 = r6
            r2 = 0
        L_0x0058:
            int r6 = r8.length
            if (r2 >= r6) goto L_0x0066
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            r7.add(r6)
            int r2 = r2 + 1
            goto L_0x0058
        L_0x0066:
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r9 == r2) goto L_0x013c
            if (r5 != r2) goto L_0x006f
            goto L_0x013c
        L_0x006f:
            r29 = r1
            r6 = 0
        L_0x0072:
            int r1 = r8.length
            if (r6 >= r1) goto L_0x0106
            com.google.android.gms.internal.ads.zzgo r1 = r8.zzau(r6)
            r30 = r0
            int r0 = r1.width
            if (r0 <= 0) goto L_0x00ec
            int r0 = r1.height
            if (r0 <= 0) goto L_0x00ec
            int r0 = r1.width
            r31 = r12
            int r12 = r1.height
            if (r10 == 0) goto L_0x00a6
            if (r0 <= r12) goto L_0x0092
            r32 = r10
            r10 = 1
            goto L_0x0095
        L_0x0092:
            r32 = r10
            r10 = 0
        L_0x0095:
            if (r9 <= r5) goto L_0x009b
            r33 = r5
            r5 = 1
            goto L_0x009e
        L_0x009b:
            r33 = r5
            r5 = 0
        L_0x009e:
            if (r10 == r5) goto L_0x00aa
            r5 = r9
            r34 = r5
            r10 = r33
            goto L_0x00af
        L_0x00a6:
            r33 = r5
            r32 = r10
        L_0x00aa:
            r10 = r9
            r34 = r10
            r5 = r33
        L_0x00af:
            int r9 = r0 * r5
            r35 = r11
            int r11 = r12 * r10
            if (r9 < r11) goto L_0x00c2
            android.graphics.Point r5 = new android.graphics.Point
            int r0 = com.google.android.gms.internal.ads.zzof.zze(r11, r0)
            r5.<init>(r10, r0)
            r0 = r5
            goto L_0x00cb
        L_0x00c2:
            android.graphics.Point r0 = new android.graphics.Point
            int r9 = com.google.android.gms.internal.ads.zzof.zze(r9, r12)
            r0.<init>(r9, r5)
        L_0x00cb:
            int r5 = r1.width
            int r9 = r1.height
            int r5 = r5 * r9
            int r9 = r1.width
            int r10 = r0.x
            float r10 = (float) r10
            r11 = 1065017672(0x3f7ae148, float:0.98)
            float r10 = r10 * r11
            int r10 = (int) r10
            if (r9 < r10) goto L_0x00f6
            int r1 = r1.height
            int r0 = r0.y
            float r0 = (float) r0
            float r0 = r0 * r11
            int r0 = (int) r0
            if (r1 < r0) goto L_0x00f6
            if (r5 >= r2) goto L_0x00f6
            r2 = r5
            goto L_0x00f6
        L_0x00ec:
            r33 = r5
            r34 = r9
            r32 = r10
            r35 = r11
            r31 = r12
        L_0x00f6:
            int r6 = r6 + 1
            r0 = r30
            r12 = r31
            r10 = r32
            r5 = r33
            r9 = r34
            r11 = r35
            goto L_0x0072
        L_0x0106:
            r30 = r0
            r33 = r5
            r34 = r9
            r32 = r10
            r35 = r11
            r31 = r12
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r2 == r0) goto L_0x014a
            int r0 = r7.size()
            r1 = 1
            int r0 = r0 - r1
        L_0x011d:
            if (r0 < 0) goto L_0x014a
            java.lang.Object r1 = r7.get(r0)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            com.google.android.gms.internal.ads.zzgo r1 = r8.zzau(r1)
            int r1 = r1.zzej()
            r5 = -1
            if (r1 == r5) goto L_0x0136
            if (r1 <= r2) goto L_0x0139
        L_0x0136:
            r7.remove(r0)
        L_0x0139:
            int r0 = r0 + -1
            goto L_0x011d
        L_0x013c:
            r30 = r0
            r29 = r1
            r33 = r5
            r34 = r9
            r32 = r10
            r35 = r11
            r31 = r12
        L_0x014a:
            r0 = r13[r4]
            r2 = r22
            r5 = r23
            r6 = r24
            r1 = 0
        L_0x0153:
            int r9 = r8.length
            if (r1 >= r9) goto L_0x01f6
            r9 = r0[r1]
            boolean r9 = zze(r9, r3)
            if (r9 == 0) goto L_0x01e6
            com.google.android.gms.internal.ads.zzgo r9 = r8.zzau(r1)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r1)
            boolean r10 = r7.contains(r10)
            if (r10 == 0) goto L_0x018d
            int r10 = r9.width
            r11 = -1
            if (r10 == r11) goto L_0x0176
            int r10 = r9.width
            if (r10 > r14) goto L_0x018d
        L_0x0176:
            int r10 = r9.height
            if (r10 == r11) goto L_0x017e
            int r10 = r9.height
            if (r10 > r15) goto L_0x018d
        L_0x017e:
            int r10 = r9.zzaey
            if (r10 == r11) goto L_0x0189
            int r10 = r9.zzaey
            r11 = r35
            if (r10 > r11) goto L_0x018f
            goto L_0x018b
        L_0x0189:
            r11 = r35
        L_0x018b:
            r10 = 1
            goto L_0x0190
        L_0x018d:
            r11 = r35
        L_0x018f:
            r10 = 0
        L_0x0190:
            if (r10 != 0) goto L_0x019a
            if (r31 == 0) goto L_0x0195
            goto L_0x019a
        L_0x0195:
            r23 = r0
            r22 = r3
            goto L_0x01ec
        L_0x019a:
            if (r10 == 0) goto L_0x01a0
            r22 = r3
            r12 = 2
            goto L_0x01a3
        L_0x01a0:
            r22 = r3
            r12 = 1
        L_0x01a3:
            r3 = r0[r1]
            r23 = r0
            r0 = 0
            boolean r3 = zze(r3, r0)
            if (r3 == 0) goto L_0x01b0
            int r12 = r12 + 1000
        L_0x01b0:
            if (r12 <= r2) goto L_0x01b4
            r0 = 1
            goto L_0x01b5
        L_0x01b4:
            r0 = 0
        L_0x01b5:
            if (r12 != r2) goto L_0x01d8
            int r0 = r9.zzej()
            if (r0 == r5) goto L_0x01c6
            int r0 = r9.zzej()
            int r0 = zzd(r0, r5)
            goto L_0x01cc
        L_0x01c6:
            int r0 = r9.zzaey
            int r0 = zzd(r0, r6)
        L_0x01cc:
            if (r3 == 0) goto L_0x01d3
            if (r10 == 0) goto L_0x01d3
            if (r0 <= 0) goto L_0x01d7
            goto L_0x01d5
        L_0x01d3:
            if (r0 >= 0) goto L_0x01d7
        L_0x01d5:
            r0 = 1
            goto L_0x01d8
        L_0x01d7:
            r0 = 0
        L_0x01d8:
            if (r0 == 0) goto L_0x01ec
            int r6 = r9.zzaey
            int r5 = r9.zzej()
            r29 = r1
            r30 = r8
            r2 = r12
            goto L_0x01ec
        L_0x01e6:
            r23 = r0
            r22 = r3
            r11 = r35
        L_0x01ec:
            int r1 = r1 + 1
            r35 = r11
            r3 = r22
            r0 = r23
            goto L_0x0153
        L_0x01f6:
            r22 = r3
            r11 = r35
            int r4 = r4 + 1
            r23 = r5
            r24 = r6
            r7 = r26
            r6 = r28
            r1 = r29
            r0 = r30
            r12 = r31
            r10 = r32
            r5 = r33
            r9 = r34
            r22 = r2
            r2 = r27
            goto L_0x0042
        L_0x0216:
            r30 = r0
            r29 = r1
            r27 = r2
            r28 = r6
            if (r30 != 0) goto L_0x0223
            r16 = 0
            goto L_0x022e
        L_0x0223:
            com.google.android.gms.internal.ads.zzmp r11 = new com.google.android.gms.internal.ads.zzmp
            r1 = r29
            r0 = r30
            r11.<init>(r0, r1)
            r16 = r11
        L_0x022e:
            r27[r28] = r16
            r0 = r27[r28]
            if (r0 == 0) goto L_0x0236
            r7 = 1
            goto L_0x0242
        L_0x0236:
            r7 = 0
            goto L_0x0242
        L_0x0238:
            r21 = r1
            r27 = r2
            r20 = r4
            r28 = r6
            r25 = r8
        L_0x0242:
            r0 = r38[r28]
            int r0 = r0.length
            if (r0 <= 0) goto L_0x024b
            r19 = 1
            goto L_0x024d
        L_0x024b:
            r19 = 0
        L_0x024d:
            r0 = r25 | r19
            r8 = r0
            goto L_0x025b
        L_0x0251:
            r21 = r1
            r27 = r2
            r20 = r4
            r28 = r6
            r25 = r8
        L_0x025b:
            int r6 = r28 + 1
            r3 = r36
            r0 = r37
            r4 = r20
            r1 = r21
            r2 = r27
            goto L_0x0012
        L_0x0269:
            r27 = r2
            r20 = r4
            r25 = r8
            r0 = r1
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x0273:
            if (r1 >= r0) goto L_0x0464
            r4 = r37[r1]
            int r4 = r4.getTrackType()
            r5 = 3
            r6 = 1
            if (r4 == r6) goto L_0x03ba
            r6 = 2
            if (r4 == r6) goto L_0x03b2
            if (r4 == r5) goto L_0x0305
            r4 = r37[r1]
            r4.getTrackType()
            r4 = r38[r1]
            r5 = r39[r1]
            r6 = r20
            boolean r7 = r6.zzbds
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x0295:
            int r12 = r4.length
            if (r8 >= r12) goto L_0x02ef
            com.google.android.gms.internal.ads.zzmh r12 = r4.zzav(r8)
            r13 = r5[r8]
            r14 = r11
            r11 = r10
            r10 = r9
            r9 = 0
        L_0x02a3:
            int r15 = r12.length
            if (r9 >= r15) goto L_0x02e5
            r15 = r13[r9]
            boolean r15 = zze(r15, r7)
            if (r15 == 0) goto L_0x02da
            com.google.android.gms.internal.ads.zzgo r15 = r12.zzau(r9)
            int r15 = r15.zzafs
            r19 = 1
            r15 = r15 & 1
            if (r15 == 0) goto L_0x02bd
            r15 = 1
            goto L_0x02be
        L_0x02bd:
            r15 = 0
        L_0x02be:
            if (r15 == 0) goto L_0x02c4
            r21 = r0
            r15 = 2
            goto L_0x02c7
        L_0x02c4:
            r21 = r0
            r15 = 1
        L_0x02c7:
            r0 = r13[r9]
            r20 = r4
            r4 = 0
            boolean r0 = zze(r0, r4)
            if (r0 == 0) goto L_0x02d4
            int r15 = r15 + 1000
        L_0x02d4:
            if (r15 <= r14) goto L_0x02de
            r11 = r9
            r10 = r12
            r14 = r15
            goto L_0x02de
        L_0x02da:
            r21 = r0
            r20 = r4
        L_0x02de:
            int r9 = r9 + 1
            r4 = r20
            r0 = r21
            goto L_0x02a3
        L_0x02e5:
            r21 = r0
            r20 = r4
            int r8 = r8 + 1
            r9 = r10
            r10 = r11
            r11 = r14
            goto L_0x0295
        L_0x02ef:
            r21 = r0
            if (r9 != 0) goto L_0x02f5
            r11 = 0
            goto L_0x02fa
        L_0x02f5:
            com.google.android.gms.internal.ads.zzmp r11 = new com.google.android.gms.internal.ads.zzmp
            r11.<init>(r9, r10)
        L_0x02fa:
            r27[r1] = r11
            r18 = r2
            r2 = 0
            r5 = -1
            r15 = 0
            r17 = 2
            goto L_0x0457
        L_0x0305:
            r21 = r0
            r6 = r20
            if (r3 != 0) goto L_0x03b6
            r0 = r38[r1]
            r3 = r39[r1]
            boolean r4 = r6.zzbds
            r7 = 0
            r8 = 0
            r10 = 0
            r11 = 0
        L_0x0315:
            int r12 = r0.length
            if (r7 >= r12) goto L_0x0395
            com.google.android.gms.internal.ads.zzmh r12 = r0.zzav(r7)
            r13 = r3[r7]
            r14 = r11
            r11 = r10
            r10 = r8
            r8 = 0
        L_0x0323:
            int r15 = r12.length
            if (r8 >= r15) goto L_0x038a
            r15 = r13[r8]
            boolean r15 = zze(r15, r4)
            if (r15 == 0) goto L_0x0380
            com.google.android.gms.internal.ads.zzgo r15 = r12.zzau(r8)
            int r5 = r15.zzafs
            r19 = 1
            r5 = r5 & 1
            if (r5 == 0) goto L_0x033d
            r5 = 1
            goto L_0x033e
        L_0x033d:
            r5 = 0
        L_0x033e:
            int r9 = r15.zzafs
            r17 = 2
            r9 = r9 & 2
            if (r9 == 0) goto L_0x034b
            r23 = r0
            r0 = 0
            r9 = 1
            goto L_0x034f
        L_0x034b:
            r23 = r0
            r0 = 0
            r9 = 0
        L_0x034f:
            boolean r24 = zza(r15, r0)
            if (r24 == 0) goto L_0x035f
            if (r5 == 0) goto L_0x0359
            r9 = 6
            goto L_0x036f
        L_0x0359:
            if (r9 != 0) goto L_0x035d
            r9 = 5
            goto L_0x036f
        L_0x035d:
            r9 = 4
            goto L_0x036f
        L_0x035f:
            if (r5 == 0) goto L_0x0363
            r9 = 3
            goto L_0x036f
        L_0x0363:
            if (r9 == 0) goto L_0x0384
            r0 = 0
            boolean r5 = zza(r15, r0)
            if (r5 == 0) goto L_0x036e
            r9 = 2
            goto L_0x036f
        L_0x036e:
            r9 = 1
        L_0x036f:
            r0 = r13[r8]
            r5 = 0
            boolean r0 = zze(r0, r5)
            if (r0 == 0) goto L_0x037a
            int r9 = r9 + 1000
        L_0x037a:
            if (r9 <= r14) goto L_0x0384
            r11 = r8
            r14 = r9
            r10 = r12
            goto L_0x0384
        L_0x0380:
            r23 = r0
            r17 = 2
        L_0x0384:
            int r8 = r8 + 1
            r0 = r23
            r5 = 3
            goto L_0x0323
        L_0x038a:
            r23 = r0
            r17 = 2
            int r7 = r7 + 1
            r8 = r10
            r10 = r11
            r11 = r14
            r5 = 3
            goto L_0x0315
        L_0x0395:
            r17 = 2
            if (r8 != 0) goto L_0x039b
            r11 = 0
            goto L_0x03a0
        L_0x039b:
            com.google.android.gms.internal.ads.zzmp r11 = new com.google.android.gms.internal.ads.zzmp
            r11.<init>(r8, r10)
        L_0x03a0:
            r27[r1] = r11
            r0 = r27[r1]
            if (r0 == 0) goto L_0x03a8
            r0 = 1
            goto L_0x03a9
        L_0x03a8:
            r0 = 0
        L_0x03a9:
            r3 = r0
            r0 = r2
            r2 = 0
            r5 = -1
            r15 = 0
            r19 = 1
            goto L_0x045b
        L_0x03b2:
            r21 = r0
            r6 = r20
        L_0x03b6:
            r17 = 2
            goto L_0x0452
        L_0x03ba:
            r21 = r0
            r6 = r20
            r17 = 2
            if (r2 != 0) goto L_0x0452
            r0 = r38[r1]
            r2 = r39[r1]
            boolean r4 = r6.zzbds
            r5 = 0
            r7 = -1
            r8 = -1
            r9 = 0
        L_0x03cc:
            int r10 = r0.length
            if (r5 >= r10) goto L_0x0436
            com.google.android.gms.internal.ads.zzmh r10 = r0.zzav(r5)
            r11 = r2[r5]
            r12 = r9
            r9 = r8
            r8 = r7
            r7 = 0
        L_0x03da:
            int r13 = r10.length
            if (r7 >= r13) goto L_0x0428
            r13 = r11[r7]
            boolean r13 = zze(r13, r4)
            if (r13 == 0) goto L_0x041d
            com.google.android.gms.internal.ads.zzgo r13 = r10.zzau(r7)
            r14 = r11[r7]
            int r15 = r13.zzafs
            r19 = 1
            r15 = r15 & 1
            if (r15 == 0) goto L_0x03f9
            r16 = r2
            r2 = 0
            r15 = 1
            goto L_0x03fd
        L_0x03f9:
            r16 = r2
            r2 = 0
            r15 = 0
        L_0x03fd:
            boolean r13 = zza(r13, r2)
            if (r13 == 0) goto L_0x0409
            if (r15 == 0) goto L_0x0407
            r13 = 4
            goto L_0x040e
        L_0x0407:
            r13 = 3
            goto L_0x040e
        L_0x0409:
            if (r15 == 0) goto L_0x040d
            r13 = 2
            goto L_0x040e
        L_0x040d:
            r13 = 1
        L_0x040e:
            r15 = 0
            boolean r14 = zze(r14, r15)
            if (r14 == 0) goto L_0x0417
            int r13 = r13 + 1000
        L_0x0417:
            if (r13 <= r12) goto L_0x0423
            r8 = r5
            r9 = r7
            r12 = r13
            goto L_0x0423
        L_0x041d:
            r16 = r2
            r2 = 0
            r15 = 0
            r19 = 1
        L_0x0423:
            int r7 = r7 + 1
            r2 = r16
            goto L_0x03da
        L_0x0428:
            r16 = r2
            r2 = 0
            r15 = 0
            r19 = 1
            int r5 = r5 + 1
            r7 = r8
            r8 = r9
            r9 = r12
            r2 = r16
            goto L_0x03cc
        L_0x0436:
            r2 = 0
            r5 = -1
            r15 = 0
            r19 = 1
            if (r7 != r5) goto L_0x043f
            r11 = r2
            goto L_0x0448
        L_0x043f:
            com.google.android.gms.internal.ads.zzmh r0 = r0.zzav(r7)
            com.google.android.gms.internal.ads.zzmp r11 = new com.google.android.gms.internal.ads.zzmp
            r11.<init>(r0, r8)
        L_0x0448:
            r27[r1] = r11
            r0 = r27[r1]
            if (r0 == 0) goto L_0x0450
            r0 = 1
            goto L_0x045b
        L_0x0450:
            r0 = 0
            goto L_0x045b
        L_0x0452:
            r18 = r2
            r2 = 0
            r5 = -1
            r15 = 0
        L_0x0457:
            r19 = 1
            r0 = r18
        L_0x045b:
            int r1 = r1 + 1
            r2 = r0
            r20 = r6
            r0 = r21
            goto L_0x0273
        L_0x0464:
            return r27
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmn.zza(com.google.android.gms.internal.ads.zzgw[], com.google.android.gms.internal.ads.zzmk[], int[][][]):com.google.android.gms.internal.ads.zzmt[]");
    }

    private static boolean zza(zzgo zzgo, String str) {
        return str != null && TextUtils.equals(str, zzof.zzbg(zzgo.zzaft));
    }
}
