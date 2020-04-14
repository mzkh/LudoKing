package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Arrays;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzms extends zzmy {
    private int zzagf = 0;
    private final SparseArray<Map<zzmk, zzmu>> zzbdz = new SparseArray<>();
    private final SparseBooleanArray zzbea = new SparseBooleanArray();
    private zzmr zzbeb;

    /* access modifiers changed from: protected */
    public abstract zzmt[] zza(zzgw[] zzgwArr, zzmk[] zzmkArr, int[][][] iArr) throws zzgd;

    public final void zzf(int i, boolean z) {
        if (this.zzbea.get(i) != z) {
            this.zzbea.put(i, z);
            invalidate();
        }
    }

    public final zzna zza(zzgw[] zzgwArr, zzmk zzmk) throws zzgd {
        int[] iArr;
        zzgw[] zzgwArr2 = zzgwArr;
        zzmk zzmk2 = zzmk;
        int[] iArr2 = new int[(zzgwArr2.length + 1)];
        zzmh[][] zzmhArr = new zzmh[(zzgwArr2.length + 1)][];
        int[][][] iArr3 = new int[(zzgwArr2.length + 1)][][];
        for (int i = 0; i < zzmhArr.length; i++) {
            zzmhArr[i] = new zzmh[zzmk2.length];
            iArr3[i] = new int[zzmk2.length][];
        }
        int[] iArr4 = new int[zzgwArr2.length];
        for (int i2 = 0; i2 < iArr4.length; i2++) {
            iArr4[i2] = zzgwArr2[i2].zzdq();
        }
        for (int i3 = 0; i3 < zzmk2.length; i3++) {
            zzmh zzav = zzmk2.zzav(i3);
            int length = zzgwArr2.length;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (i4 >= zzgwArr2.length) {
                    i4 = length;
                    break;
                }
                zzgw zzgw = zzgwArr2[i4];
                int i6 = length;
                int i7 = i5;
                for (int i8 = 0; i8 < zzav.length; i8++) {
                    int zza = zzgw.zza(zzav.zzau(i8)) & 3;
                    if (zza > i7) {
                        if (zza == 3) {
                            break;
                        }
                        i6 = i4;
                        i7 = zza;
                    }
                }
                i4++;
                i5 = i7;
                length = i6;
            }
            if (i4 == zzgwArr2.length) {
                iArr = new int[zzav.length];
            } else {
                zzgw zzgw2 = zzgwArr2[i4];
                int[] iArr5 = new int[zzav.length];
                for (int i9 = 0; i9 < zzav.length; i9++) {
                    iArr5[i9] = zzgw2.zza(zzav.zzau(i9));
                }
                iArr = iArr5;
            }
            int i10 = iArr2[i4];
            zzmhArr[i4][i10] = zzav;
            iArr3[i4][i10] = iArr;
            iArr2[i4] = iArr2[i4] + 1;
        }
        zzmk[] zzmkArr = new zzmk[zzgwArr2.length];
        int[] iArr6 = new int[zzgwArr2.length];
        for (int i11 = 0; i11 < zzgwArr2.length; i11++) {
            int i12 = iArr2[i11];
            zzmkArr[i11] = new zzmk((zzmh[]) Arrays.copyOf(zzmhArr[i11], i12));
            iArr3[i11] = (int[][]) Arrays.copyOf(iArr3[i11], i12);
            iArr6[i11] = zzgwArr2[i11].getTrackType();
        }
        zzmk zzmk3 = new zzmk((zzmh[]) Arrays.copyOf(zzmhArr[zzgwArr2.length], iArr2[zzgwArr2.length]));
        zzmt[] zza2 = zza(zzgwArr2, zzmkArr, iArr3);
        int i13 = 0;
        while (true) {
            zzmu zzmu = null;
            if (i13 < zzgwArr2.length) {
                if (this.zzbea.get(i13)) {
                    zza2[i13] = null;
                } else {
                    zzmk zzmk4 = zzmkArr[i13];
                    Map map = (Map) this.zzbdz.get(i13);
                    if (map != null) {
                        zzmu = (zzmu) map.get(zzmk4);
                    }
                    if (zzmu != null) {
                        throw new NoSuchMethodError();
                    }
                }
                i13++;
            } else {
                zzmr zzmr = new zzmr(iArr6, zzmkArr, iArr4, iArr3, zzmk3);
                zzgz[] zzgzArr = new zzgz[zzgwArr2.length];
                for (int i14 = 0; i14 < zzgwArr2.length; i14++) {
                    zzgzArr[i14] = zza2[i14] != null ? zzgz.zzage : null;
                }
                return new zzna(zzmk2, new zzmv(zza2), zzmr, zzgzArr);
            }
        }
    }

    public final void zzd(Object obj) {
        this.zzbeb = (zzmr) obj;
    }
}
