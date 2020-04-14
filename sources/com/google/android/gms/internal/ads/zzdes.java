package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdjn.zzb;
import com.google.android.gms.internal.ads.zzdjx.zza;
import java.io.IOException;
import java.security.GeneralSecurityException;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdes {
    @Deprecated
    public static final zzdep zzj(byte[] bArr) throws GeneralSecurityException {
        try {
            zzdjx zzm = zzdjx.zzm(bArr);
            zzb(zzm);
            return zzdep.zza(zzm);
        } catch (zzdrg unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }

    public static final zzdep zza(zzdeo zzdeo) throws GeneralSecurityException, IOException {
        zzdjx zzapn = zzdeo.zzapn();
        zzb(zzapn);
        return zzdep.zza(zzapn);
    }

    private static void zzb(zzdjx zzdjx) throws GeneralSecurityException {
        for (zza zza : zzdjx.zzauj()) {
            if (zza.zzauo().zzatw() == zzb.UNKNOWN_KEYMATERIAL || zza.zzauo().zzatw() == zzb.SYMMETRIC) {
                throw new GeneralSecurityException("keyset contains secret key material");
            } else if (zza.zzauo().zzatw() == zzb.ASYMMETRIC_PRIVATE) {
                throw new GeneralSecurityException("keyset contains secret key material");
            }
        }
    }
}
