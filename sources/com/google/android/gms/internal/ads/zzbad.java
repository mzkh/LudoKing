package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import com.tapjoy.TapjoyConstants;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbad implements zzgs {
    private int zzbfh;
    private final zzni zzecc;
    private long zzecd;
    private long zzece;
    private long zzecf;
    private long zzecg;
    private boolean zzech;

    zzbad() {
        this(15000, TapjoyConstants.TJC_PLACEMENT_RESPONSE_TIMEOUT, 2500, 5000);
    }

    private zzbad(int i, int i2, long j, long j2) {
        this.zzecc = new zzni(true, 65536);
        this.zzecd = 15000000;
        this.zzece = 30000000;
        this.zzecf = 2500000;
        this.zzecg = 5000000;
    }

    public final void zzel() {
        zzj(false);
    }

    public final void zza(zzgx[] zzgxArr, zzmk zzmk, zzmv zzmv) {
        this.zzbfh = 0;
        for (int i = 0; i < zzgxArr.length; i++) {
            if (zzmv.zzax(i) != null) {
                this.zzbfh += zzof.zzbk(zzgxArr[i].getTrackType());
            }
        }
        this.zzecc.zzba(this.zzbfh);
    }

    public final void onStopped() {
        zzj(true);
    }

    public final void zzem() {
        zzj(true);
    }

    public final zznc zzen() {
        return this.zzecc;
    }

    public final synchronized boolean zzc(long j, boolean z) {
        boolean z2;
        long j2 = z ? this.zzecg : this.zzecf;
        if (j2 <= 0 || j >= j2) {
            z2 = true;
        } else {
            z2 = false;
        }
        return z2;
    }

    public final synchronized boolean zzdn(long j) {
        boolean z = false;
        char c = j > this.zzece ? 0 : j < this.zzecd ? (char) 2 : 1;
        boolean z2 = this.zzecc.zzid() >= this.zzbfh;
        if (c == 2 || (c == 1 && this.zzech && !z2)) {
            z = true;
        }
        this.zzech = z;
        return this.zzech;
    }

    public final synchronized void zzcz(int i) {
        this.zzecd = ((long) i) * 1000;
    }

    public final synchronized void zzda(int i) {
        this.zzece = ((long) i) * 1000;
    }

    public final synchronized void zzcu(int i) {
        this.zzecf = ((long) i) * 1000;
    }

    public final synchronized void zzcv(int i) {
        this.zzecg = ((long) i) * 1000;
    }

    @VisibleForTesting
    private final void zzj(boolean z) {
        this.zzbfh = 0;
        this.zzech = false;
        if (z) {
            this.zzecc.reset();
        }
    }
}
