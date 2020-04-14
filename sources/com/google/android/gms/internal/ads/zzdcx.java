package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzdcx<V> extends zzdcu<V> implements zzddi<V> {
    protected zzdcx() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzapj */
    public abstract zzddi<? extends V> zzapi();

    public void addListener(Runnable runnable, Executor executor) {
        zzapi().addListener(runnable, executor);
    }
}
