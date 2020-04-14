package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdcp extends zzdco<V> {
    private final /* synthetic */ zzdcm zzgrg;
    private final Callable<V> zzgrh;

    public zzdcp(zzdcm zzdcm, Callable<V> callable, Executor executor) {
        this.zzgrg = zzdcm;
        super(zzdcm, executor);
        this.zzgrh = (Callable) zzdaq.checkNotNull(callable);
    }

    /* access modifiers changed from: 0000 */
    public final V zzapg() throws Exception {
        this.zzgrf = false;
        return this.zzgrh.call();
    }

    /* access modifiers changed from: 0000 */
    public final void setValue(V v) {
        this.zzgrg.set(v);
    }

    /* access modifiers changed from: 0000 */
    public final String zzaph() {
        return this.zzgrh.toString();
    }
}
