package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbou extends zzbpm<zzboy> {
    private final Clock zzbmp;
    @GuardedBy("this")
    private boolean zzfcd = false;
    private final ScheduledExecutorService zzfcx;
    @GuardedBy("this")
    private long zzfcz = -1;
    @GuardedBy("this")
    private long zzfda = -1;
    @GuardedBy("this")
    @Nullable
    private ScheduledFuture<?> zzfhe;

    public zzbou(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        super(Collections.emptySet());
        this.zzfcx = scheduledExecutorService;
        this.zzbmp = clock;
    }

    public final synchronized void onPause() {
        if (!this.zzfcd) {
            if (this.zzfhe == null || this.zzfhe.isCancelled()) {
                this.zzfda = -1;
            } else {
                this.zzfhe.cancel(true);
                this.zzfda = this.zzfcz - this.zzbmp.elapsedRealtime();
            }
            this.zzfcd = true;
        }
    }

    public final synchronized void onResume() {
        if (this.zzfcd) {
            if (this.zzfda > 0 && this.zzfhe.isCancelled()) {
                zzex(this.zzfda);
            }
            this.zzfcd = false;
        }
    }

    public final synchronized void zzaga() {
        this.zzfcd = false;
        zzex(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzdd(int r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            if (r7 > 0) goto L_0x0005
            monitor-exit(r6)
            return
        L_0x0005:
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x0043 }
            long r1 = (long) r7     // Catch:{ all -> 0x0043 }
            long r0 = r0.toMillis(r1)     // Catch:{ all -> 0x0043 }
            boolean r7 = r6.zzfcd     // Catch:{ all -> 0x0043 }
            if (r7 == 0) goto L_0x0025
            long r2 = r6.zzfda     // Catch:{ all -> 0x0043 }
            r4 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 <= 0) goto L_0x001f
            long r2 = r6.zzfda     // Catch:{ all -> 0x0043 }
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            long r0 = r6.zzfda     // Catch:{ all -> 0x0043 }
        L_0x0021:
            r6.zzfda = r0     // Catch:{ all -> 0x0043 }
            monitor-exit(r6)
            return
        L_0x0025:
            com.google.android.gms.common.util.Clock r7 = r6.zzbmp     // Catch:{ all -> 0x0043 }
            long r2 = r7.elapsedRealtime()     // Catch:{ all -> 0x0043 }
            long r4 = r6.zzfcz     // Catch:{ all -> 0x0043 }
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 > 0) goto L_0x003e
            long r2 = r6.zzfcz     // Catch:{ all -> 0x0043 }
            com.google.android.gms.common.util.Clock r7 = r6.zzbmp     // Catch:{ all -> 0x0043 }
            long r4 = r7.elapsedRealtime()     // Catch:{ all -> 0x0043 }
            long r2 = r2 - r4
            int r7 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r7 <= 0) goto L_0x0041
        L_0x003e:
            r6.zzex(r0)     // Catch:{ all -> 0x0043 }
        L_0x0041:
            monitor-exit(r6)
            return
        L_0x0043:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbou.zzdd(int):void");
    }

    private final synchronized void zzex(long j) {
        if (this.zzfhe != null && !this.zzfhe.isDone()) {
            this.zzfhe.cancel(true);
        }
        this.zzfcz = this.zzbmp.elapsedRealtime() + j;
        this.zzfhe = this.zzfcx.schedule(new zzbov(this), j, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: private */
    public final void zzagb() {
        zza(zzbot.zzfgz);
    }
}
