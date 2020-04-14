package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzmk {
    public static final zzmk zzbdc = new zzmk(new zzmh[0]);
    public final int length;
    private int zzafv;
    private final zzmh[] zzbdd;

    public zzmk(zzmh... zzmhArr) {
        this.zzbdd = zzmhArr;
        this.length = zzmhArr.length;
    }

    public final zzmh zzav(int i) {
        return this.zzbdd[i];
    }

    public final int zza(zzmh zzmh) {
        for (int i = 0; i < this.length; i++) {
            if (this.zzbdd[i] == zzmh) {
                return i;
            }
        }
        return -1;
    }

    public final int hashCode() {
        if (this.zzafv == 0) {
            this.zzafv = Arrays.hashCode(this.zzbdd);
        }
        return this.zzafv;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzmk zzmk = (zzmk) obj;
            return this.length == zzmk.length && Arrays.equals(this.zzbdd, zzmk.zzbdd);
        }
    }
}
