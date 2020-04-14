package com.google.android.gms.measurement.internal;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzdu<V> {
    private static final Object zzjo = new Object();
    private final String zzjj;
    private final zzdv<V> zzjk;
    private final V zzjl;
    private final V zzjm;
    private final Object zzjn;
    @GuardedBy("overrideLock")
    private volatile V zzjp;
    @GuardedBy("cachingLock")
    private volatile V zzjq;

    private zzdu(@NonNull String str, @NonNull V v, @NonNull V v2, @Nullable zzdv<V> zzdv) {
        this.zzjn = new Object();
        this.zzjp = null;
        this.zzjq = null;
        this.zzjj = str;
        this.zzjl = v;
        this.zzjm = v2;
        this.zzjk = zzdv;
    }

    public final String getKey() {
        return this.zzjj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0025, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(@androidx.annotation.Nullable V r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.zzjn
            monitor-enter(r0)
            V r1 = r4.zzjp     // Catch:{ all -> 0x008d }
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            if (r5 == 0) goto L_0x0009
            return r5
        L_0x0009:
            com.google.android.gms.measurement.internal.zzr r5 = com.google.android.gms.measurement.internal.zzak.zzfv
            if (r5 != 0) goto L_0x0010
            V r5 = r4.zzjl
            return r5
        L_0x0010:
            com.google.android.gms.measurement.internal.zzr r5 = com.google.android.gms.measurement.internal.zzak.zzfv
            java.lang.Object r5 = zzjo
            monitor-enter(r5)
            boolean r0 = com.google.android.gms.measurement.internal.zzr.isMainThread()     // Catch:{ all -> 0x008a }
            if (r0 == 0) goto L_0x0026
            V r0 = r4.zzjq     // Catch:{ all -> 0x008a }
            if (r0 != 0) goto L_0x0022
            V r0 = r4.zzjl     // Catch:{ all -> 0x008a }
            goto L_0x0024
        L_0x0022:
            V r0 = r4.zzjq     // Catch:{ all -> 0x008a }
        L_0x0024:
            monitor-exit(r5)     // Catch:{ all -> 0x008a }
            return r0
        L_0x0026:
            boolean r0 = com.google.android.gms.measurement.internal.zzr.isMainThread()     // Catch:{ all -> 0x008a }
            if (r0 != 0) goto L_0x0082
            com.google.android.gms.measurement.internal.zzr r0 = com.google.android.gms.measurement.internal.zzak.zzfv     // Catch:{ all -> 0x008a }
            java.util.List r0 = com.google.android.gms.measurement.internal.zzak.zzfw     // Catch:{ SecurityException -> 0x0066 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ SecurityException -> 0x0066 }
        L_0x0036:
            boolean r1 = r0.hasNext()     // Catch:{ SecurityException -> 0x0066 }
            if (r1 == 0) goto L_0x006a
            java.lang.Object r1 = r0.next()     // Catch:{ SecurityException -> 0x0066 }
            com.google.android.gms.measurement.internal.zzdu r1 = (com.google.android.gms.measurement.internal.zzdu) r1     // Catch:{ SecurityException -> 0x0066 }
            java.lang.Object r2 = zzjo     // Catch:{ SecurityException -> 0x0066 }
            monitor-enter(r2)     // Catch:{ SecurityException -> 0x0066 }
            boolean r3 = com.google.android.gms.measurement.internal.zzr.isMainThread()     // Catch:{ all -> 0x0063 }
            if (r3 != 0) goto L_0x005b
            com.google.android.gms.measurement.internal.zzdv<V> r3 = r1.zzjk     // Catch:{ all -> 0x0063 }
            if (r3 == 0) goto L_0x0056
            com.google.android.gms.measurement.internal.zzdv<V> r3 = r1.zzjk     // Catch:{ all -> 0x0063 }
            java.lang.Object r3 = r3.get()     // Catch:{ all -> 0x0063 }
            goto L_0x0057
        L_0x0056:
            r3 = 0
        L_0x0057:
            r1.zzjq = r3     // Catch:{ all -> 0x0063 }
            monitor-exit(r2)     // Catch:{ all -> 0x0063 }
            goto L_0x0036
        L_0x005b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = "Refreshing flag cache must be done on a worker thread."
            r0.<init>(r1)     // Catch:{ all -> 0x0063 }
            throw r0     // Catch:{ all -> 0x0063 }
        L_0x0063:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0063 }
            throw r0     // Catch:{ SecurityException -> 0x0066 }
        L_0x0066:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzak.zza(r0)     // Catch:{ all -> 0x008a }
        L_0x006a:
            monitor-exit(r5)     // Catch:{ all -> 0x008a }
            com.google.android.gms.measurement.internal.zzdv<V> r5 = r4.zzjk
            if (r5 != 0) goto L_0x0074
            com.google.android.gms.measurement.internal.zzr r5 = com.google.android.gms.measurement.internal.zzak.zzfv
            V r5 = r4.zzjl
            return r5
        L_0x0074:
            java.lang.Object r5 = r5.get()     // Catch:{ SecurityException -> 0x0079 }
            return r5
        L_0x0079:
            r5 = move-exception
            com.google.android.gms.measurement.internal.zzak.zza(r5)
            com.google.android.gms.measurement.internal.zzr r5 = com.google.android.gms.measurement.internal.zzak.zzfv
            V r5 = r4.zzjl
            return r5
        L_0x0082:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x008a }
            java.lang.String r1 = "Tried to refresh flag cache on main thread or on package side."
            r0.<init>(r1)     // Catch:{ all -> 0x008a }
            throw r0     // Catch:{ all -> 0x008a }
        L_0x008a:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x008a }
            throw r0
        L_0x008d:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            throw r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzdu.get(java.lang.Object):java.lang.Object");
    }
}
