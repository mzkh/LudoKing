package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
class zzdfg implements zzdex<zzdec> {
    private static final Logger logger = Logger.getLogger(zzdfg.class.getName());

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    static class zza implements zzdec {
        private final zzdev<zzdec> zzgtf;

        private zza(zzdev<zzdec> zzdev) {
            this.zzgtf = zzdev;
        }

        public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            return zzdmn.zza(this.zzgtf.zzapv().zzapu(), ((zzdec) this.zzgtf.zzapv().zzapr()).zzc(bArr, bArr2));
        }
    }

    zzdfg() {
    }

    public final Class<zzdec> zzapo() {
        return zzdec.class;
    }

    public final /* synthetic */ Object zza(zzdev zzdev) throws GeneralSecurityException {
        return new zza(zzdev);
    }
}
