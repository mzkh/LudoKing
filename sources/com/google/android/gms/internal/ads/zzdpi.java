package com.google.android.gms.internal.ads;

import com.google.android.gms.games.Notifications;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdpi {
    static int zza(byte[] bArr, int i, zzdpl zzdpl) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza((int) b, bArr, i2, zzdpl);
        }
        zzdpl.zzhfx = b;
        return i2;
    }

    static int zza(int i, byte[] bArr, int i2, zzdpl zzdpl) {
        int i3 = i & Notifications.NOTIFICATION_TYPES_ALL;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzdpl.zzhfx = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzdpl.zzhfx = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzdpl.zzhfx = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzdpl.zzhfx = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzdpl.zzhfx = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzb(byte[] bArr, int i, zzdpl zzdpl) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzdpl.zzhfy = j;
            return i2;
        }
        long j2 = j & 127;
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j3 = j2 | (((long) (b & Byte.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j3 |= ((long) (b2 & Byte.MAX_VALUE)) << i4;
            int i6 = i5;
            b = b2;
            i3 = i6;
        }
        zzdpl.zzhfy = j3;
        return i3;
    }

    static int zzf(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    static long zzg(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    static double zzh(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzg(bArr, i));
    }

    static float zzi(byte[] bArr, int i) {
        return Float.intBitsToFloat(zzf(bArr, i));
    }

    static int zzc(byte[] bArr, int i, zzdpl zzdpl) throws zzdrg {
        int zza = zza(bArr, i, zzdpl);
        int i2 = zzdpl.zzhfx;
        if (i2 < 0) {
            throw zzdrg.zzbad();
        } else if (i2 == 0) {
            zzdpl.zzhfz = "";
            return zza;
        } else {
            zzdpl.zzhfz = new String(bArr, zza, i2, zzdqx.UTF_8);
            return zza + i2;
        }
    }

    static int zzd(byte[] bArr, int i, zzdpl zzdpl) throws zzdrg {
        int zza = zza(bArr, i, zzdpl);
        int i2 = zzdpl.zzhfx;
        if (i2 < 0) {
            throw zzdrg.zzbad();
        } else if (i2 == 0) {
            zzdpl.zzhfz = "";
            return zza;
        } else {
            zzdpl.zzhfz = zzdtw.zzn(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zze(byte[] bArr, int i, zzdpl zzdpl) throws zzdrg {
        int zza = zza(bArr, i, zzdpl);
        int i2 = zzdpl.zzhfx;
        if (i2 < 0) {
            throw zzdrg.zzbad();
        } else if (i2 > bArr.length - zza) {
            throw zzdrg.zzbac();
        } else if (i2 == 0) {
            zzdpl.zzhfz = zzdpm.zzhgb;
            return zza;
        } else {
            zzdpl.zzhfz = zzdpm.zzh(bArr, zza, i2);
            return zza + i2;
        }
    }

    /* JADX WARNING: type inference failed for: r8v2, types: [int] */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zza(com.google.android.gms.internal.ads.zzdsv r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.ads.zzdpl r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = zza(r8, r7, r0, r10)
            int r8 = r10.zzhfx
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.newInstance()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.zza(r1, r2, r3, r4, r5)
            r6.zzak(r9)
            r10.zzhfz = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.ads.zzdrg r6 = com.google.android.gms.internal.ads.zzdrg.zzbac()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdpi.zza(com.google.android.gms.internal.ads.zzdsv, byte[], int, int, com.google.android.gms.internal.ads.zzdpl):int");
    }

    static int zza(zzdsv zzdsv, byte[] bArr, int i, int i2, int i3, zzdpl zzdpl) throws IOException {
        zzdsk zzdsk = (zzdsk) zzdsv;
        Object newInstance = zzdsk.newInstance();
        int zza = zzdsk.zza(newInstance, bArr, i, i2, i3, zzdpl);
        zzdsk.zzak(newInstance);
        zzdpl.zzhfz = newInstance;
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzdrd<?> zzdrd, zzdpl zzdpl) {
        zzdqy zzdqy = (zzdqy) zzdrd;
        int zza = zza(bArr, i2, zzdpl);
        zzdqy.zzgp(zzdpl.zzhfx);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzdpl);
            if (i != zzdpl.zzhfx) {
                break;
            }
            zza = zza(bArr, zza2, zzdpl);
            zzdqy.zzgp(zzdpl.zzhfx);
        }
        return zza;
    }

    static int zza(byte[] bArr, int i, zzdrd<?> zzdrd, zzdpl zzdpl) throws IOException {
        zzdqy zzdqy = (zzdqy) zzdrd;
        int zza = zza(bArr, i, zzdpl);
        int i2 = zzdpl.zzhfx + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzdpl);
            zzdqy.zzgp(zzdpl.zzhfx);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzdrg.zzbac();
    }

    static int zza(zzdsv<?> zzdsv, int i, byte[] bArr, int i2, int i3, zzdrd<?> zzdrd, zzdpl zzdpl) throws IOException {
        int zza = zza((zzdsv) zzdsv, bArr, i2, i3, zzdpl);
        zzdrd.add(zzdpl.zzhfz);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzdpl);
            if (i != zzdpl.zzhfx) {
                break;
            }
            zza = zza((zzdsv) zzdsv, bArr, zza2, i3, zzdpl);
            zzdrd.add(zzdpl.zzhfz);
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzdtq zzdtq, zzdpl zzdpl) throws zzdrg {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzb = zzb(bArr, i2, zzdpl);
                zzdtq.zzc(i, Long.valueOf(zzdpl.zzhfy));
                return zzb;
            } else if (i4 == 1) {
                zzdtq.zzc(i, Long.valueOf(zzg(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza = zza(bArr, i2, zzdpl);
                int i5 = zzdpl.zzhfx;
                if (i5 < 0) {
                    throw zzdrg.zzbad();
                } else if (i5 <= bArr.length - zza) {
                    if (i5 == 0) {
                        zzdtq.zzc(i, zzdpm.zzhgb);
                    } else {
                        zzdtq.zzc(i, zzdpm.zzh(bArr, zza, i5));
                    }
                    return zza + i5;
                } else {
                    throw zzdrg.zzbac();
                }
            } else if (i4 == 3) {
                zzdtq zzbby = zzdtq.zzbby();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, zzdpl);
                    int i8 = zzdpl.zzhfx;
                    if (i8 == i6) {
                        i7 = i8;
                        i2 = zza2;
                        break;
                    }
                    i7 = i8;
                    i2 = zza(i8, bArr, zza2, i3, zzbby, zzdpl);
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzdrg.zzbai();
                }
                zzdtq.zzc(i, zzbby);
                return i2;
            } else if (i4 == 5) {
                zzdtq.zzc(i, Integer.valueOf(zzf(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzdrg.zzbaf();
            }
        } else {
            throw zzdrg.zzbaf();
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzdpl zzdpl) throws zzdrg {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzb(bArr, i2, zzdpl);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zza(bArr, i2, zzdpl) + zzdpl.zzhfx;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zza(bArr, i2, zzdpl);
                    i6 = zzdpl.zzhfx;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zza(i6, bArr, i2, i3, zzdpl);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzdrg.zzbai();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzdrg.zzbaf();
            }
        } else {
            throw zzdrg.zzbaf();
        }
    }
}
