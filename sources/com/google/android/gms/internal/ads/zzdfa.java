package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdfa implements zza {
    private final /* synthetic */ zzden zzgtb;

    zzdfa(zzden zzden) {
        this.zzgtb = zzden;
    }

    public final <Q> zzden<Q> zzb(Class<Q> cls) throws GeneralSecurityException {
        if (this.zzgtb.zzapo().equals(cls)) {
            return this.zzgtb;
        }
        throw new InternalError("This should never be called, as we always first check supportedPrimitives.");
    }

    public final zzden<?> zzapw() {
        return this.zzgtb;
    }

    public final Class<?> zzapx() {
        return this.zzgtb.getClass();
    }

    public final Set<Class<?>> zzapy() {
        return Collections.singleton(this.zzgtb.zzapo());
    }
}
