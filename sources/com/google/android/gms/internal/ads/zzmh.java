package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzmh {
    public final int length;
    private int zzafv;
    private final zzgo[] zzbby;

    public zzmh(zzgo... zzgoArr) {
        zznr.checkState(zzgoArr.length > 0);
        this.zzbby = zzgoArr;
        this.length = zzgoArr.length;
    }

    public final zzgo zzau(int i) {
        return this.zzbby[i];
    }

    public final int zzh(zzgo zzgo) {
        int i = 0;
        while (true) {
            zzgo[] zzgoArr = this.zzbby;
            if (i >= zzgoArr.length) {
                return -1;
            }
            if (zzgo == zzgoArr[i]) {
                return i;
            }
            i++;
        }
    }

    public final int hashCode() {
        if (this.zzafv == 0) {
            this.zzafv = Arrays.hashCode(this.zzbby) + 527;
        }
        return this.zzafv;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzmh zzmh = (zzmh) obj;
            return this.length == zzmh.length && Arrays.equals(this.zzbby, zzmh.zzbby);
        }
    }
}
