package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdok {
    private static long zze(byte[] bArr, int i) {
        return ((long) (((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16))) & 4294967295L;
    }

    private static long zzg(byte[] bArr, int i, int i2) {
        return (zze(bArr, i) >> i2) & 67108863;
    }

    private static void zza(byte[] bArr, long j, int i) {
        int i2 = 0;
        while (i2 < 4) {
            bArr[i + i2] = (byte) ((int) (255 & j));
            i2++;
            j >>= 8;
        }
    }

    static byte[] zzf(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        if (bArr3.length == 32) {
            long zzg = zzg(bArr3, 0, 0) & 67108863;
            int i = 2;
            int i2 = 3;
            long zzg2 = zzg(bArr3, 3, 2) & 67108611;
            long zzg3 = zzg(bArr3, 6, 4) & 67092735;
            long zzg4 = zzg(bArr3, 9, 6) & 66076671;
            long zzg5 = zzg(bArr3, 12, 8) & 1048575;
            long j = zzg2 * 5;
            long j2 = zzg3 * 5;
            long j3 = zzg4 * 5;
            long j4 = zzg5 * 5;
            byte[] bArr5 = new byte[17];
            long j5 = 0;
            long j6 = 0;
            long j7 = 0;
            long j8 = 0;
            long j9 = 0;
            int i3 = 0;
            while (i3 < bArr4.length) {
                int min = Math.min(16, bArr4.length - i3);
                System.arraycopy(bArr4, i3, bArr5, 0, min);
                bArr5[min] = 1;
                if (min != 16) {
                    Arrays.fill(bArr5, min + 1, 17, 0);
                }
                long zzg6 = j9 + zzg(bArr5, 0, 0);
                long zzg7 = j5 + zzg(bArr5, i2, i);
                long zzg8 = j6 + zzg(bArr5, 6, 4);
                long zzg9 = j7 + zzg(bArr5, 9, 6);
                long zzg10 = j8 + (zzg(bArr5, 12, 8) | ((long) (bArr5[16] << 24)));
                long j10 = (zzg6 * zzg) + (zzg7 * j4) + (zzg8 * j3) + (zzg9 * j2) + (zzg10 * j);
                long j11 = (zzg6 * zzg3) + (zzg7 * zzg2) + (zzg8 * zzg) + (zzg9 * j4) + (zzg10 * j3);
                long j12 = (zzg6 * zzg2) + (zzg7 * zzg) + (zzg8 * j4) + (zzg9 * j3) + (zzg10 * j2) + (j10 >> 26);
                long j13 = j11 + (j12 >> 26);
                long j14 = (zzg6 * zzg4) + (zzg7 * zzg3) + (zzg8 * zzg2) + (zzg9 * zzg) + (zzg10 * j4) + (j13 >> 26);
                long j15 = (zzg6 * zzg5) + (zzg7 * zzg4) + (zzg8 * zzg3) + (zzg9 * zzg2) + (zzg10 * zzg) + (j14 >> 26);
                long j16 = (j10 & 67108863) + ((j15 >> 26) * 5);
                j5 = (j12 & 67108863) + (j16 >> 26);
                i3 += 16;
                j6 = j13 & 67108863;
                j7 = j14 & 67108863;
                j8 = j15 & 67108863;
                j9 = j16 & 67108863;
                i = 2;
                i2 = 3;
            }
            long j17 = j6 + (j5 >> 26);
            long j18 = j17 & 67108863;
            long j19 = j7 + (j17 >> 26);
            long j20 = j19 & 67108863;
            long j21 = j8 + (j19 >> 26);
            long j22 = j21 & 67108863;
            long j23 = j9 + ((j21 >> 26) * 5);
            long j24 = j23 & 67108863;
            long j25 = (j5 & 67108863) + (j23 >> 26);
            long j26 = j24 + 5;
            long j27 = j26 & 67108863;
            long j28 = (j26 >> 26) + j25;
            long j29 = j18 + (j28 >> 26);
            long j30 = j20 + (j29 >> 26);
            long j31 = j30 & 67108863;
            long j32 = (j22 + (j30 >> 26)) - 67108864;
            long j33 = j32 >> 63;
            long j34 = j24 & j33;
            long j35 = j25 & j33;
            long j36 = j18 & j33;
            long j37 = j20 & j33;
            long j38 = j22 & j33;
            long j39 = j33 ^ -1;
            long j40 = (j28 & 67108863 & j39) | j35;
            long j41 = (j29 & 67108863 & j39) | j36;
            long j42 = (j31 & j39) | j37;
            long j43 = (j32 & j39) | j38;
            long j44 = j40 << 26;
            long j45 = ((j40 >> 6) | (j41 << 20)) & 4294967295L;
            long j46 = ((j41 >> 12) | (j42 << 14)) & 4294967295L;
            long j47 = ((j42 >> 18) | (j43 << 8)) & 4294967295L;
            long zze = ((j44 | j34 | (j27 & j39)) & 4294967295L) + zze(bArr3, 16);
            long j48 = zze & 4294967295L;
            long zze2 = j45 + zze(bArr3, 20) + (zze >> 32);
            long j49 = zze2 & 4294967295L;
            long zze3 = j46 + zze(bArr3, 24) + (zze2 >> 32);
            long j50 = zze3 & 4294967295L;
            long zze4 = (j47 + zze(bArr3, 28) + (zze3 >> 32)) & 4294967295L;
            byte[] bArr6 = new byte[16];
            zza(bArr6, j48, 0);
            zza(bArr6, j49, 4);
            zza(bArr6, j50, 8);
            zza(bArr6, zze4, 12);
            return bArr6;
        }
        throw new IllegalArgumentException("The key length in bytes must be 32.");
    }
}
