package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzddz extends zzddh<V> {
    private final Callable<V> zzgrh;
    private final /* synthetic */ zzddw zzgsg;

    zzddz(zzddw zzddw, Callable<V> callable) {
        this.zzgsg = zzddw;
        this.zzgrh = (Callable) zzdaq.checkNotNull(callable);
    }

    /* access modifiers changed from: 0000 */
    public final boolean isDone() {
        return this.zzgsg.isDone();
    }

    /* access modifiers changed from: 0000 */
    public final V zzapg() throws Exception {
        return this.zzgrh.call();
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(V v, Throwable th) {
        if (th == null) {
            this.zzgsg.set(v);
        } else {
            this.zzgsg.setException(th);
        }
    }

    /* access modifiers changed from: 0000 */
    public final String zzaph() {
        return this.zzgrh.toString();
    }
}
