package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
class zzdfz implements zzdex<zzdei> {
    private static final Logger logger = Logger.getLogger(zzdfz.class.getName());

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    static class zza implements zzdei {
        private final zzdev<zzdei> zzgtj;

        public zza(zzdev<zzdei> zzdev) {
            this.zzgtj = zzdev;
        }
    }

    zzdfz() {
    }

    public final Class<zzdei> zzapo() {
        return zzdei.class;
    }

    public final /* synthetic */ Object zza(zzdev zzdev) throws GeneralSecurityException {
        return new zza(zzdev);
    }
}
