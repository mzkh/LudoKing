package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzlw implements zzlr, zzls {
    private zzmk zzadf;
    private zzlr zzbaf;
    public final zzls[] zzbbm;
    private final IdentityHashMap<zzmd, Integer> zzbbn = new IdentityHashMap<>();
    private int zzbbo;
    private zzls[] zzbbp;
    private zzmg zzbbq;

    public zzlw(zzls... zzlsArr) {
        this.zzbbm = zzlsArr;
    }

    public final void zza(zzlr zzlr, long j) {
        this.zzbaf = zzlr;
        zzls[] zzlsArr = this.zzbbm;
        this.zzbbo = zzlsArr.length;
        for (zzls zza : zzlsArr) {
            zza.zza(this, j);
        }
    }

    public final void zzha() throws IOException {
        for (zzls zzha : this.zzbbm) {
            zzha.zzha();
        }
    }

    public final zzmk zzhb() {
        return this.zzadf;
    }

    public final long zza(zzmt[] zzmtArr, boolean[] zArr, zzmd[] zzmdArr, boolean[] zArr2, long j) {
        int i;
        zzmt[] zzmtArr2 = zzmtArr;
        zzmd[] zzmdArr2 = zzmdArr;
        int[] iArr = new int[zzmtArr2.length];
        int[] iArr2 = new int[zzmtArr2.length];
        for (int i2 = 0; i2 < zzmtArr2.length; i2++) {
            if (zzmdArr2[i2] == null) {
                i = -1;
            } else {
                i = ((Integer) this.zzbbn.get(zzmdArr2[i2])).intValue();
            }
            iArr[i2] = i;
            iArr2[i2] = -1;
            if (zzmtArr2[i2] != null) {
                zzmh zzhx = zzmtArr2[i2].zzhx();
                int i3 = 0;
                while (true) {
                    zzls[] zzlsArr = this.zzbbm;
                    if (i3 >= zzlsArr.length) {
                        break;
                    } else if (zzlsArr[i3].zzhb().zza(zzhx) != -1) {
                        iArr2[i2] = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        this.zzbbn.clear();
        zzmd[] zzmdArr3 = new zzmd[zzmtArr2.length];
        zzmd[] zzmdArr4 = new zzmd[zzmtArr2.length];
        zzmt[] zzmtArr3 = new zzmt[zzmtArr2.length];
        ArrayList arrayList = new ArrayList(this.zzbbm.length);
        long j2 = j;
        int i4 = 0;
        while (i4 < this.zzbbm.length) {
            int i5 = 0;
            while (i5 < zzmtArr2.length) {
                zzmt zzmt = null;
                zzmdArr4[i5] = iArr[i5] == i4 ? zzmdArr2[i5] : null;
                if (iArr2[i5] == i4) {
                    zzmt = zzmtArr2[i5];
                }
                zzmtArr3[i5] = zzmt;
                i5++;
            }
            ArrayList arrayList2 = arrayList;
            zzmt[] zzmtArr4 = zzmtArr3;
            int i6 = i4;
            long zza = this.zzbbm[i4].zza(zzmtArr3, zArr, zzmdArr4, zArr2, j2);
            if (i6 == 0) {
                j2 = zza;
            } else if (zza != j2) {
                throw new IllegalStateException("Children enabled at different positions");
            }
            boolean z = false;
            for (int i7 = 0; i7 < zzmtArr2.length; i7++) {
                boolean z2 = true;
                if (iArr2[i7] == i6) {
                    zznr.checkState(zzmdArr4[i7] != null);
                    zzmdArr3[i7] = zzmdArr4[i7];
                    this.zzbbn.put(zzmdArr4[i7], Integer.valueOf(i6));
                    z = true;
                } else if (iArr[i7] == i6) {
                    if (zzmdArr4[i7] != null) {
                        z2 = false;
                    }
                    zznr.checkState(z2);
                }
            }
            if (z) {
                arrayList2.add(this.zzbbm[i6]);
            }
            i4 = i6 + 1;
            arrayList = arrayList2;
            zzmtArr3 = zzmtArr4;
        }
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zzmdArr3, 0, zzmdArr2, 0, zzmdArr3.length);
        this.zzbbp = new zzls[arrayList3.size()];
        arrayList3.toArray(this.zzbbp);
        this.zzbbq = new zzlf(this.zzbbp);
        return j2;
    }

    public final void zzdz(long j) {
        for (zzls zzdz : this.zzbbp) {
            zzdz.zzdz(j);
        }
    }

    public final boolean zzdy(long j) {
        return this.zzbbq.zzdy(j);
    }

    public final long zzgz() {
        return this.zzbbq.zzgz();
    }

    public final long zzhc() {
        long zzhc = this.zzbbm[0].zzhc();
        int i = 1;
        while (true) {
            zzls[] zzlsArr = this.zzbbm;
            if (i >= zzlsArr.length) {
                if (zzhc != -9223372036854775807L) {
                    zzls[] zzlsArr2 = this.zzbbp;
                    int length = zzlsArr2.length;
                    int i2 = 0;
                    while (i2 < length) {
                        zzls zzls = zzlsArr2[i2];
                        if (zzls == this.zzbbm[0] || zzls.zzea(zzhc) == zzhc) {
                            i2++;
                        } else {
                            throw new IllegalStateException("Children seeked to different positions");
                        }
                    }
                }
                return zzhc;
            } else if (zzlsArr[i].zzhc() == -9223372036854775807L) {
                i++;
            } else {
                throw new IllegalStateException("Child reported discontinuity");
            }
        }
    }

    public final long zzhd() {
        long j = Long.MAX_VALUE;
        for (zzls zzhd : this.zzbbp) {
            long zzhd2 = zzhd.zzhd();
            if (zzhd2 != Long.MIN_VALUE) {
                j = Math.min(j, zzhd2);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final long zzea(long j) {
        long zzea = this.zzbbp[0].zzea(j);
        int i = 1;
        while (true) {
            zzls[] zzlsArr = this.zzbbp;
            if (i >= zzlsArr.length) {
                return zzea;
            }
            if (zzlsArr[i].zzea(zzea) == zzea) {
                i++;
            } else {
                throw new IllegalStateException("Children seeked to different positions");
            }
        }
    }

    public final void zza(zzls zzls) {
        int i = this.zzbbo - 1;
        this.zzbbo = i;
        if (i <= 0) {
            int i2 = 0;
            for (zzls zzhb : this.zzbbm) {
                i2 += zzhb.zzhb().length;
            }
            zzmh[] zzmhArr = new zzmh[i2];
            zzls[] zzlsArr = this.zzbbm;
            int length = zzlsArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                zzmk zzhb2 = zzlsArr[i3].zzhb();
                int i5 = zzhb2.length;
                int i6 = i4;
                int i7 = 0;
                while (i7 < i5) {
                    int i8 = i6 + 1;
                    zzmhArr[i6] = zzhb2.zzav(i7);
                    i7++;
                    i6 = i8;
                }
                i3++;
                i4 = i6;
            }
            this.zzadf = new zzmk(zzmhArr);
            this.zzbaf.zza(this);
        }
    }

    public final /* synthetic */ void zza(zzmg zzmg) {
        if (this.zzadf != null) {
            this.zzbaf.zza(this);
        }
    }
}
