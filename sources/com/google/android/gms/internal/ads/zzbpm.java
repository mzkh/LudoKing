package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzbpm<ListenerT> {
    @GuardedBy("this")
    private final Map<ListenerT, Executor> zzfhj = new HashMap();

    protected zzbpm(Set<zzbqs<ListenerT>> set) {
        zzb(set);
    }

    public final synchronized void zza(zzbqs<ListenerT> zzbqs) {
        zza(zzbqs.zzfhz, zzbqs.executor);
    }

    public final synchronized void zza(ListenerT listenert, Executor executor) {
        this.zzfhj.put(listenert, executor);
    }

    private final synchronized void zzb(Set<zzbqs<ListenerT>> set) {
        for (zzbqs zza : set) {
            zza(zza);
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zza(zzbpo<ListenerT> zzbpo) {
        for (Entry entry : this.zzfhj.entrySet()) {
            ((Executor) entry.getValue()).execute(new zzbpl(zzbpo, entry.getKey()));
        }
    }
}
