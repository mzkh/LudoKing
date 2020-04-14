package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzdba<E> {
    zzdba() {
    }

    public abstract zzdba<E> zzab(E e);

    public zzdba<E> zze(Iterable<? extends E> iterable) {
        for (Object zzab : iterable) {
            zzab(zzab);
        }
        return this;
    }

    public zzdba<E> zza(Iterator<? extends E> it) {
        while (it.hasNext()) {
            zzab(it.next());
        }
        return this;
    }
}
