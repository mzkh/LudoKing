package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzlf implements zzmg {
    private final zzmg[] zzazr;

    public zzlf(zzmg[] zzmgArr) {
        this.zzazr = zzmgArr;
    }

    public final long zzgz() {
        long j = Long.MAX_VALUE;
        for (zzmg zzgz : this.zzazr) {
            long zzgz2 = zzgz.zzgz();
            if (zzgz2 != Long.MIN_VALUE) {
                j = Math.min(j, zzgz2);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final boolean zzdy(long j) {
        zzmg[] zzmgArr;
        boolean z;
        boolean z2 = false;
        do {
            long zzgz = zzgz();
            if (zzgz == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (zzmg zzmg : this.zzazr) {
                if (zzmg.zzgz() == zzgz) {
                    z |= zzmg.zzdy(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}
