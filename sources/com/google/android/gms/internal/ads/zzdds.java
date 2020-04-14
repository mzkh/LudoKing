package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdds<V> extends zzdcv<V> {
    /* access modifiers changed from: private */
    @NullableDecl
    public zzddi<V> zzgsc;
    /* access modifiers changed from: private */
    @NullableDecl
    public ScheduledFuture<?> zzgsd;

    static <V> zzddi<V> zzb(zzddi<V> zzddi, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzdds zzdds = new zzdds(zzddi);
        zzddu zzddu = new zzddu(zzdds);
        zzdds.zzgsd = scheduledExecutorService.schedule(zzddu, j, timeUnit);
        zzddi.addListener(zzddu, zzdcq.INSTANCE);
        return zzdds;
    }

    private zzdds(zzddi<V> zzddi) {
        this.zzgsc = (zzddi) zzdaq.checkNotNull(zzddi);
    }

    /* access modifiers changed from: protected */
    public final String pendingToString() {
        zzddi<V> zzddi = this.zzgsc;
        ScheduledFuture<?> scheduledFuture = this.zzgsd;
        if (zzddi == null) {
            return null;
        }
        String valueOf = String.valueOf(zzddi);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14);
        sb.append("inputFuture=[");
        sb.append(valueOf);
        sb.append("]");
        String sb2 = sb.toString();
        if (scheduledFuture != null) {
            long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
            if (delay > 0) {
                String valueOf2 = String.valueOf(sb2);
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 43);
                sb3.append(valueOf2);
                sb3.append(", remaining delay=[");
                sb3.append(delay);
                sb3.append(" ms]");
                sb2 = sb3.toString();
            }
        }
        return sb2;
    }

    /* access modifiers changed from: protected */
    public final void afterDone() {
        maybePropagateCancellationTo(this.zzgsc);
        ScheduledFuture<?> scheduledFuture = this.zzgsd;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zzgsc = null;
        this.zzgsd = null;
    }
}
