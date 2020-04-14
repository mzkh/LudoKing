package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbib implements zzqa {
    private final Clock zzbmp;
    @GuardedBy("this")
    private Runnable zzdry = null;
    private final ScheduledExecutorService zzfcx;
    @GuardedBy("this")
    @Nullable
    private ScheduledFuture<?> zzfcy;
    @GuardedBy("this")
    private long zzfcz = -1;
    @GuardedBy("this")
    private long zzfda = -1;
    @GuardedBy("this")
    private boolean zzfdb = false;

    public zzbib(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        this.zzfcx = scheduledExecutorService;
        this.zzbmp = clock;
        zzq.zzkm().zza(this);
    }

    public final void zzo(boolean z) {
        if (z) {
            zzaen();
        } else {
            zzaem();
        }
    }

    public final synchronized void zza(int i, Runnable runnable) {
        this.zzdry = runnable;
        long j = (long) i;
        this.zzfcz = this.zzbmp.elapsedRealtime() + j;
        this.zzfcy = this.zzfcx.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    @VisibleForTesting
    private final synchronized void zzaem() {
        if (!this.zzfdb) {
            if (this.zzfcy == null || this.zzfcy.isDone()) {
                this.zzfda = -1;
            } else {
                this.zzfcy.cancel(true);
                this.zzfda = this.zzfcz - this.zzbmp.elapsedRealtime();
            }
            this.zzfdb = true;
        }
    }

    @VisibleForTesting
    private final synchronized void zzaen() {
        if (this.zzfdb) {
            if (this.zzfda > 0 && this.zzfcy != null && this.zzfcy.isCancelled()) {
                this.zzfcy = this.zzfcx.schedule(this.zzdry, this.zzfda, TimeUnit.MILLISECONDS);
            }
            this.zzfdb = false;
        }
    }
}
