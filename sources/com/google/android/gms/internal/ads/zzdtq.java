package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzd;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
public final class zzdtq {
    private static final zzdtq zzhop = new zzdtq(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzhfr;
    private int zzhks;
    private Object[] zzhnb;
    private int[] zzhoq;

    public static zzdtq zzbbx() {
        return zzhop;
    }

    static zzdtq zzbby() {
        return new zzdtq();
    }

    static zzdtq zza(zzdtq zzdtq, zzdtq zzdtq2) {
        int i = zzdtq.count + zzdtq2.count;
        int[] copyOf = Arrays.copyOf(zzdtq.zzhoq, i);
        System.arraycopy(zzdtq2.zzhoq, 0, copyOf, zzdtq.count, zzdtq2.count);
        Object[] copyOf2 = Arrays.copyOf(zzdtq.zzhnb, i);
        System.arraycopy(zzdtq2.zzhnb, 0, copyOf2, zzdtq.count, zzdtq2.count);
        return new zzdtq(i, copyOf, copyOf2, true);
    }

    private zzdtq() {
        this(0, new int[8], new Object[8], true);
    }

    private zzdtq(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzhks = -1;
        this.count = i;
        this.zzhoq = iArr;
        this.zzhnb = objArr;
        this.zzhfr = z;
    }

    public final void zzaxj() {
        this.zzhfr = false;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzduk zzduk) throws IOException {
        if (zzduk.zzayy() == zzd.zzhlh) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzduk.zzb(this.zzhoq[i] >>> 3, this.zzhnb[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzduk.zzb(this.zzhoq[i2] >>> 3, this.zzhnb[i2]);
        }
    }

    public final void zzb(zzduk zzduk) throws IOException {
        if (this.count != 0) {
            if (zzduk.zzayy() == zzd.zzhlg) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zzhoq[i], this.zzhnb[i], zzduk);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zzhoq[i2], this.zzhnb[i2], zzduk);
            }
        }
    }

    private static void zzb(int i, Object obj, zzduk zzduk) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzduk.zzo(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzduk.zzi(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzduk.zza(i2, (zzdpm) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzduk.zzad(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzdrg.zzbah());
        } else if (zzduk.zzayy() == zzd.zzhlg) {
            zzduk.zzgm(i2);
            ((zzdtq) obj).zzb(zzduk);
            zzduk.zzgn(i2);
        } else {
            zzduk.zzgn(i2);
            ((zzdtq) obj).zzb(zzduk);
            zzduk.zzgm(i2);
        }
    }

    public final int zzbbz() {
        int i = this.zzhks;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzdqf.zzd(this.zzhoq[i3] >>> 3, (zzdpm) this.zzhnb[i3]);
        }
        this.zzhks = i2;
        return i2;
    }

    public final int zzazu() {
        int i;
        int i2 = this.zzhks;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zzhoq[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzdqf.zzk(i6, ((Long) this.zzhnb[i4]).longValue());
            } else if (i7 == 1) {
                i = zzdqf.zzm(i6, ((Long) this.zzhnb[i4]).longValue());
            } else if (i7 == 2) {
                i = zzdqf.zzc(i6, (zzdpm) this.zzhnb[i4]);
            } else if (i7 == 3) {
                i = (zzdqf.zzgd(i6) << 1) + ((zzdtq) this.zzhnb[i4]).zzazu();
            } else if (i7 == 5) {
                i = zzdqf.zzah(i6, ((Integer) this.zzhnb[i4]).intValue());
            } else {
                throw new IllegalStateException(zzdrg.zzbah());
            }
            i3 += i;
        }
        this.zzhks = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzdtq)) {
            return false;
        }
        zzdtq zzdtq = (zzdtq) obj;
        int i = this.count;
        if (i == zzdtq.count) {
            int[] iArr = this.zzhoq;
            int[] iArr2 = zzdtq.zzhoq;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.zzhnb;
                Object[] objArr2 = zzdtq.zzhnb;
                int i3 = this.count;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                return z2;
            }
        }
    }

    public final int hashCode() {
        int i = this.count;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzhoq;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzhnb;
        for (int i7 = 0; i7 < this.count; i7++) {
            i3 = (i3 * 31) + objArr[i7].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzdsh.zza(sb, i, String.valueOf(this.zzhoq[i2] >>> 3), this.zzhnb[i2]);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzc(int i, Object obj) {
        if (this.zzhfr) {
            int i2 = this.count;
            if (i2 == this.zzhoq.length) {
                int i3 = this.count + (i2 < 4 ? 8 : i2 >> 1);
                this.zzhoq = Arrays.copyOf(this.zzhoq, i3);
                this.zzhnb = Arrays.copyOf(this.zzhnb, i3);
            }
            int[] iArr = this.zzhoq;
            int i4 = this.count;
            iArr[i4] = i;
            this.zzhnb[i4] = obj;
            this.count = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
