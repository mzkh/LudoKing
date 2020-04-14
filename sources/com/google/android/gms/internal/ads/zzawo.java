package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzawo {
    private final Object lock = new Object();
    private long zzdva;
    @GuardedBy("lock")
    private long zzdvb = Long.MIN_VALUE;

    public zzawo(long j) {
        this.zzdva = j;
    }

    public final boolean tryAcquire() {
        synchronized (this.lock) {
            long elapsedRealtime = zzq.zzkq().elapsedRealtime();
            if (this.zzdvb + this.zzdva > elapsedRealtime) {
                return false;
            }
            this.zzdvb = elapsedRealtime;
            return true;
        }
    }

    public final void zzev(long j) {
        synchronized (this.lock) {
            this.zzdva = j;
        }
    }
}
