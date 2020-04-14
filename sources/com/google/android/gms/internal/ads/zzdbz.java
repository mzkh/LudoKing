package com.google.android.gms.internal.ads;

import java.lang.Throwable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdbz<V, X extends Throwable> extends zzdbw<V, X, zzdcj<? super X, ? extends V>, zzddi<? extends V>> {
    zzdbz(zzddi<? extends V> zzddi, Class<X> cls, zzdcj<? super X, ? extends V> zzdcj) {
        super(zzddi, cls, zzdcj);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void setResult(Object obj) {
        setFuture((zzddi) obj);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zza(Object obj, Throwable th) throws Exception {
        zzdcj zzdcj = (zzdcj) obj;
        zzddi zzf = zzdcj.zzf(th);
        zzdaq.zza(zzf, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzdcj);
        return zzf;
    }
}
