package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdcd<I, O> extends zzdca<I, O, zzdcj<? super I, ? extends O>, zzddi<? extends O>> {
    zzdcd(zzddi<? extends I> zzddi, zzdcj<? super I, ? extends O> zzdcj) {
        super(zzddi, zzdcj);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void setResult(Object obj) {
        setFuture((zzddi) obj);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zzc(Object obj, @NullableDecl Object obj2) throws Exception {
        zzdcj zzdcj = (zzdcj) obj;
        zzddi zzf = zzdcj.zzf(obj2);
        zzdaq.zza(zzf, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzdcj);
        return zzf;
    }
}
