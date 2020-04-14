package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzmm implements zzmt {
    private final int length;
    private int zzafv;
    private final zzgo[] zzbby;
    private final zzmh zzbde;
    private final int[] zzbdf;
    private final long[] zzbdg;

    public zzmm(zzmh zzmh, int... iArr) {
        int i = 0;
        zznr.checkState(iArr.length > 0);
        this.zzbde = (zzmh) zznr.checkNotNull(zzmh);
        this.length = iArr.length;
        this.zzbby = new zzgo[this.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.zzbby[i2] = zzmh.zzau(iArr[i2]);
        }
        Arrays.sort(this.zzbby, new zzmo());
        this.zzbdf = new int[this.length];
        while (true) {
            int i3 = this.length;
            if (i < i3) {
                this.zzbdf[i] = zzmh.zzh(this.zzbby[i]);
                i++;
            } else {
                this.zzbdg = new long[i3];
                return;
            }
        }
    }

    public final zzmh zzhx() {
        return this.zzbde;
    }

    public final int length() {
        return this.zzbdf.length;
    }

    public final zzgo zzau(int i) {
        return this.zzbby[i];
    }

    public final int zzaw(int i) {
        return this.zzbdf[0];
    }

    public int hashCode() {
        if (this.zzafv == 0) {
            this.zzafv = (System.identityHashCode(this.zzbde) * 31) + Arrays.hashCode(this.zzbdf);
        }
        return this.zzafv;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzmm zzmm = (zzmm) obj;
            return this.zzbde == zzmm.zzbde && Arrays.equals(this.zzbdf, zzmm.zzbdf);
        }
    }
}
