package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
class zzdgk implements zzdex<zzdet> {
    private static final Logger logger = Logger.getLogger(zzdgk.class.getName());

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    static class zza implements zzdet {
        private final zzdev<zzdet> zzgtj;
        private final byte[] zzgts;

        private zza(zzdev<zzdet> zzdev) {
            this.zzgts = new byte[]{0};
            this.zzgtj = zzdev;
        }

        public final byte[] zzk(byte[] bArr) throws GeneralSecurityException {
            if (this.zzgtj.zzapv().zzapt().equals(zzdkj.LEGACY)) {
                return zzdmn.zza(this.zzgtj.zzapv().zzapu(), ((zzdet) this.zzgtj.zzapv().zzapr()).zzk(zzdmn.zza(bArr, this.zzgts)));
            }
            return zzdmn.zza(this.zzgtj.zzapv().zzapu(), ((zzdet) this.zzgtj.zzapv().zzapr()).zzk(bArr));
        }
    }

    zzdgk() {
    }

    public final Class<zzdet> zzapo() {
        return zzdet.class;
    }

    public final /* synthetic */ Object zza(zzdev zzdev) throws GeneralSecurityException {
        return new zza(zzdev);
    }
}
