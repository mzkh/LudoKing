package com.google.android.gms.internal.ads;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzgk {
    public final int index;
    private final zzgx[] zzacp;
    private final zzmy zzacq;
    public final zzls zzadm;
    public final Object zzadn;
    public final zzmd[] zzado;
    private final boolean[] zzadp;
    public final long zzadq;
    public int zzadr;
    public long zzads;
    public boolean zzadt;
    public boolean zzadu;
    public boolean zzadv;
    public zzgk zzadw;
    public zzna zzadx;
    private final zzgw[] zzady;
    private final zzgs zzadz;
    private final zzlu zzaea;
    private zzna zzaeb;

    public zzgk(zzgx[] zzgxArr, zzgw[] zzgwArr, long j, zzmy zzmy, zzgs zzgs, zzlu zzlu, Object obj, int i, int i2, boolean z, long j2) {
        this.zzacp = zzgxArr;
        this.zzady = zzgwArr;
        this.zzadq = j;
        this.zzacq = zzmy;
        this.zzadz = zzgs;
        this.zzaea = zzlu;
        this.zzadn = zznr.checkNotNull(obj);
        this.index = i;
        this.zzadr = i2;
        this.zzadt = z;
        this.zzads = j2;
        this.zzado = new zzmd[zzgxArr.length];
        this.zzadp = new boolean[zzgxArr.length];
        this.zzadm = zzlu.zza(i2, zzgs.zzen());
    }

    public final long zzdz() {
        return this.zzadq - this.zzads;
    }

    public final void zzc(int i, boolean z) {
        this.zzadr = i;
        this.zzadt = z;
    }

    public final boolean zzea() {
        return this.zzadu && (!this.zzadv || this.zzadm.zzhd() == Long.MIN_VALUE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzeb() throws com.google.android.gms.internal.ads.zzgd {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzmy r0 = r6.zzacq
            com.google.android.gms.internal.ads.zzgw[] r1 = r6.zzady
            com.google.android.gms.internal.ads.zzls r2 = r6.zzadm
            com.google.android.gms.internal.ads.zzmk r2 = r2.zzhb()
            com.google.android.gms.internal.ads.zzna r0 = r0.zza(r1, r2)
            com.google.android.gms.internal.ads.zzna r1 = r6.zzaeb
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0016
        L_0x0014:
            r1 = 0
            goto L_0x0028
        L_0x0016:
            r4 = 0
        L_0x0017:
            com.google.android.gms.internal.ads.zzmv r5 = r0.zzbef
            int r5 = r5.length
            if (r4 >= r5) goto L_0x0027
            boolean r5 = r0.zza(r1, r4)
            if (r5 != 0) goto L_0x0024
            goto L_0x0014
        L_0x0024:
            int r4 = r4 + 1
            goto L_0x0017
        L_0x0027:
            r1 = 1
        L_0x0028:
            if (r1 == 0) goto L_0x002b
            return r3
        L_0x002b:
            r6.zzadx = r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgk.zzeb():boolean");
    }

    public final long zzb(long j, boolean z) {
        return zza(j, false, new boolean[this.zzacp.length]);
    }

    public final long zza(long j, boolean z, boolean[] zArr) {
        zzmv zzmv = this.zzadx.zzbef;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzmv.length) {
                break;
            }
            boolean[] zArr2 = this.zzadp;
            if (z || !this.zzadx.zza(this.zzaeb, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        long zza = this.zzadm.zza(zzmv.zzhy(), this.zzadp, this.zzado, zArr, j);
        this.zzaeb = this.zzadx;
        this.zzadv = false;
        int i2 = 0;
        while (true) {
            zzmd[] zzmdArr = this.zzado;
            if (i2 < zzmdArr.length) {
                if (zzmdArr[i2] != null) {
                    zznr.checkState(zzmv.zzax(i2) != null);
                    this.zzadv = true;
                } else {
                    zznr.checkState(zzmv.zzax(i2) == null);
                }
                i2++;
            } else {
                this.zzadz.zza(this.zzacp, this.zzadx.zzbee, zzmv);
                return zza;
            }
        }
    }

    public final void release() {
        try {
            this.zzaea.zzb(this.zzadm);
        } catch (RuntimeException e) {
            Log.e("ExoPlayerImplInternal", "Period release failed.", e);
        }
    }
}
