package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzmq {
    public final int viewportHeight;
    public final int viewportWidth;
    public final String zzbdk;
    public final String zzbdl;
    public final boolean zzbdm;
    public final boolean zzbdn;
    public final int zzbdo;
    public final int zzbdp;
    public final int zzbdq;
    public final boolean zzbdr;
    public final boolean zzbds;
    public final boolean zzbdt;

    public zzmq() {
        this(null, null, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
    }

    private zzmq(String str, String str2, boolean z, boolean z2, int i, int i2, int i3, boolean z3, boolean z4, int i4, int i5, boolean z5) {
        this.zzbdk = null;
        this.zzbdl = null;
        this.zzbdm = false;
        this.zzbdn = true;
        this.zzbdo = Integer.MAX_VALUE;
        this.zzbdp = Integer.MAX_VALUE;
        this.zzbdq = Integer.MAX_VALUE;
        this.zzbdr = true;
        this.zzbds = true;
        this.viewportWidth = Integer.MAX_VALUE;
        this.viewportHeight = Integer.MAX_VALUE;
        this.zzbdt = true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzmq zzmq = (zzmq) obj;
            return this.zzbdn == zzmq.zzbdn && this.zzbdo == zzmq.zzbdo && this.zzbdp == zzmq.zzbdp && this.zzbdr == zzmq.zzbdr && this.zzbds == zzmq.zzbds && this.zzbdt == zzmq.zzbdt && this.viewportWidth == zzmq.viewportWidth && this.viewportHeight == zzmq.viewportHeight && this.zzbdq == zzmq.zzbdq && TextUtils.equals(null, null) && TextUtils.equals(null, null);
        }
    }

    public final int hashCode() {
        String str = null;
        return (((((((((((((((((((str.hashCode() * 31) + str.hashCode()) * 31 * 31) + (this.zzbdn ? 1 : 0)) * 31) + this.zzbdo) * 31) + this.zzbdp) * 31) + this.zzbdq) * 31) + (this.zzbdr ? 1 : 0)) * 31) + (this.zzbds ? 1 : 0)) * 31) + (this.zzbdt ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight;
    }
}
