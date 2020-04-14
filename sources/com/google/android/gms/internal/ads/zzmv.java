package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzmv {
    public final int length;
    private int zzafv;
    private final zzmt[] zzbec;

    public zzmv(zzmt... zzmtArr) {
        this.zzbec = zzmtArr;
        this.length = zzmtArr.length;
    }

    public final zzmt zzax(int i) {
        return this.zzbec[i];
    }

    public final zzmt[] zzhy() {
        return (zzmt[]) this.zzbec.clone();
    }

    public final int hashCode() {
        if (this.zzafv == 0) {
            this.zzafv = Arrays.hashCode(this.zzbec) + 527;
        }
        return this.zzafv;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzbec, ((zzmv) obj).zzbec);
    }
}
