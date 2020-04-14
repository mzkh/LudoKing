package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdda<V> implements Runnable {
    private final Future<V> zzgrm;
    private final zzdcz<? super V> zzgrn;

    zzdda(Future<V> future, zzdcz<? super V> zzdcz) {
        this.zzgrm = future;
        this.zzgrn = zzdcz;
    }

    public final void run() {
        try {
            this.zzgrn.onSuccess(zzdcy.zzb(this.zzgrm));
        } catch (ExecutionException e) {
            this.zzgrn.zzb(e.getCause());
        } catch (Error | RuntimeException e2) {
            this.zzgrn.zzb(e2);
        }
    }

    public final String toString() {
        return zzdak.zzx(this).zzy(this.zzgrn).toString();
    }
}
