package com.google.android.gms.internal.ads;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzddr<V> extends zzdcw<V> implements zzddi<V>, ScheduledFuture<V> {
    private final ScheduledFuture<?> zzgsb;

    public zzddr(zzddi<V> zzddi, ScheduledFuture<?> scheduledFuture) {
        super(zzddi);
        this.zzgsb = scheduledFuture;
    }

    public final boolean cancel(boolean z) {
        boolean cancel = super.cancel(z);
        if (cancel) {
            this.zzgsb.cancel(z);
        }
        return cancel;
    }

    public final long getDelay(TimeUnit timeUnit) {
        return this.zzgsb.getDelay(timeUnit);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return this.zzgsb.compareTo((Delayed) obj);
    }
}
