package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzod implements zznv {
    private boolean started;
    private zzgu zzadh = zzgu.zzafz;
    private long zzbgr;
    private long zzbgs;

    public final void start() {
        if (!this.started) {
            this.zzbgs = SystemClock.elapsedRealtime();
            this.started = true;
        }
    }

    public final void stop() {
        if (this.started) {
            zzef(zzfj());
            this.started = false;
        }
    }

    public final void zzef(long j) {
        this.zzbgr = j;
        if (this.started) {
            this.zzbgs = SystemClock.elapsedRealtime();
        }
    }

    public final void zza(zznv zznv) {
        zzef(zznv.zzfj());
        this.zzadh = zznv.zzfc();
    }

    public final long zzfj() {
        long j;
        long j2 = this.zzbgr;
        if (!this.started) {
            return j2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzbgs;
        if (this.zzadh.zzaga == 1.0f) {
            j = zzga.zzdh(elapsedRealtime);
        } else {
            j = this.zzadh.zzdo(elapsedRealtime);
        }
        return j2 + j;
    }

    public final zzgu zzb(zzgu zzgu) {
        if (this.started) {
            zzef(zzfj());
        }
        this.zzadh = zzgu;
        return zzgu;
    }

    public final zzgu zzfc() {
        return this.zzadh;
    }
}
