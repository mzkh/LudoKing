package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdep {
    private zzdjx zzgsp;

    private zzdep(zzdjx zzdjx) {
        this.zzgsp = zzdjx;
    }

    static final zzdep zza(zzdjx zzdjx) throws GeneralSecurityException {
        if (zzdjx != null && zzdjx.zzauk() > 0) {
            return new zzdep(zzdjx);
        }
        throw new GeneralSecurityException("empty keyset");
    }

    /* access modifiers changed from: 0000 */
    public final zzdjx zzapq() {
        return this.zzgsp;
    }

    public final String toString() {
        return zzdfb.zzc(this.zzgsp).toString();
    }
}
