package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcvp {
    private final Object lock = new Object();
    private final Clock zzbmp;
    private volatile long zzdri = 0;
    @GuardedBy("lock")
    private volatile int zzgix = zzcvs.zzgjq;

    public zzcvp(Clock clock) {
        this.zzbmp = clock;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzq(int r5, int r6) {
        /*
            r4 = this;
            r4.zzamw()
            com.google.android.gms.common.util.Clock r0 = r4.zzbmp
            long r0 = r0.currentTimeMillis()
            java.lang.Object r2 = r4.lock
            monitor-enter(r2)
            int r3 = r4.zzgix     // Catch:{ all -> 0x001e }
            if (r3 == r5) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            return
        L_0x0012:
            r4.zzgix = r6     // Catch:{ all -> 0x001e }
            int r5 = r4.zzgix     // Catch:{ all -> 0x001e }
            int r6 = com.google.android.gms.internal.ads.zzcvs.zzgjs     // Catch:{ all -> 0x001e }
            if (r5 != r6) goto L_0x001c
            r4.zzdri = r0     // Catch:{ all -> 0x001e }
        L_0x001c:
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            return
        L_0x001e:
            r5 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcvp.zzq(int, int):void");
    }

    private final void zzamw() {
        long currentTimeMillis = this.zzbmp.currentTimeMillis();
        synchronized (this.lock) {
            if (this.zzgix == zzcvs.zzgjs) {
                if (this.zzdri + ((Long) zzuv.zzon().zzd(zzza.zzcsl)).longValue() <= currentTimeMillis) {
                    this.zzgix = zzcvs.zzgjq;
                }
            }
        }
    }

    public final void zzbd(boolean z) {
        if (z) {
            zzq(zzcvs.zzgjq, zzcvs.zzgjr);
        } else {
            zzq(zzcvs.zzgjr, zzcvs.zzgjq);
        }
    }

    public final boolean zzamx() {
        boolean z;
        synchronized (this.lock) {
            zzamw();
            z = this.zzgix == zzcvs.zzgjr;
        }
        return z;
    }

    public final boolean zzamy() {
        boolean z;
        synchronized (this.lock) {
            zzamw();
            z = this.zzgix == zzcvs.zzgjs;
        }
        return z;
    }

    public final void zzud() {
        zzq(zzcvs.zzgjr, zzcvs.zzgjs);
    }
}
