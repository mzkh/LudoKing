package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdcm<V> extends zzdce<Object, V> {
    zzdcm(zzday<? extends zzddi<?>> zzday, boolean z, Executor executor, Callable<V> callable) {
        zzd(new zzdcr(this, zzday, z, new zzdcp(this, callable, executor)));
    }
}
