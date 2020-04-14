package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzni implements zznc {
    private final boolean zzbfd;
    private final int zzbfe;
    private final byte[] zzbff;
    private final zzmz[] zzbfg;
    private int zzbfh;
    private int zzbfi;
    private int zzbfj;
    private zzmz[] zzbfk;

    public zzni(boolean z, int i) {
        this(true, 65536, 0);
    }

    private zzni(boolean z, int i, int i2) {
        zznr.checkArgument(true);
        zznr.checkArgument(true);
        this.zzbfd = true;
        this.zzbfe = 65536;
        this.zzbfj = 0;
        this.zzbfk = new zzmz[100];
        this.zzbff = null;
        this.zzbfg = new zzmz[1];
    }

    public final synchronized void reset() {
        if (this.zzbfd) {
            zzba(0);
        }
    }

    public final synchronized void zzba(int i) {
        boolean z = i < this.zzbfh;
        this.zzbfh = i;
        if (z) {
            zzm();
        }
    }

    public final synchronized zzmz zzhz() {
        zzmz zzmz;
        this.zzbfi++;
        if (this.zzbfj > 0) {
            zzmz[] zzmzArr = this.zzbfk;
            int i = this.zzbfj - 1;
            this.zzbfj = i;
            zzmz = zzmzArr[i];
            this.zzbfk[this.zzbfj] = null;
        } else {
            zzmz = new zzmz(new byte[this.zzbfe], 0);
        }
        return zzmz;
    }

    public final synchronized void zza(zzmz zzmz) {
        this.zzbfg[0] = zzmz;
        zza(this.zzbfg);
    }

    public final synchronized void zza(zzmz[] zzmzArr) {
        boolean z;
        if (this.zzbfj + zzmzArr.length >= this.zzbfk.length) {
            this.zzbfk = (zzmz[]) Arrays.copyOf(this.zzbfk, Math.max(this.zzbfk.length << 1, this.zzbfj + zzmzArr.length));
        }
        for (zzmz zzmz : zzmzArr) {
            if (zzmz.data != null) {
                if (zzmz.data.length != this.zzbfe) {
                    z = false;
                    zznr.checkArgument(z);
                    zzmz[] zzmzArr2 = this.zzbfk;
                    int i = this.zzbfj;
                    this.zzbfj = i + 1;
                    zzmzArr2[i] = zzmz;
                }
            }
            z = true;
            zznr.checkArgument(z);
            zzmz[] zzmzArr22 = this.zzbfk;
            int i2 = this.zzbfj;
            this.zzbfj = i2 + 1;
            zzmzArr22[i2] = zzmz;
        }
        this.zzbfi -= zzmzArr.length;
        notifyAll();
    }

    public final synchronized void zzm() {
        int max = Math.max(0, zzof.zze(this.zzbfh, this.zzbfe) - this.zzbfi);
        if (max < this.zzbfj) {
            Arrays.fill(this.zzbfk, max, this.zzbfj, null);
            this.zzbfj = max;
        }
    }

    public final synchronized int zzid() {
        return this.zzbfi * this.zzbfe;
    }

    public final int zzia() {
        return this.zzbfe;
    }
}
