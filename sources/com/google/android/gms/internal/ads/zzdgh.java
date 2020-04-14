package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdhq.zza;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdgh implements zzdmv {
    private final String zzgtn;
    private final int zzgto;
    private zzdhq zzgtp;
    private zzdgo zzgtq;
    private int zzgtr;

    zzdgh(zzdjt zzdjt) throws GeneralSecurityException {
        this.zzgtn = zzdjt.zzatu();
        if (this.zzgtn.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzdhr zzak = zzdhr.zzak(zzdjt.zzatv());
                this.zzgtp = (zzdhq) zzdey.zzb(zzdjt);
                this.zzgto = zzak.getKeySize();
            } catch (zzdrg e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        } else if (this.zzgtn.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzdgp zzv = zzdgp.zzv(zzdjt.zzatv());
                this.zzgtq = (zzdgo) zzdey.zzb(zzdjt);
                this.zzgtr = zzv.zzaqf().getKeySize();
                this.zzgto = this.zzgtr + zzv.zzaqg().getKeySize();
            } catch (zzdrg e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
            }
        } else {
            String str = "unsupported AEAD DEM key type: ";
            String valueOf = String.valueOf(this.zzgtn);
            throw new GeneralSecurityException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    public final int zzaqa() {
        return this.zzgto;
    }

    public final zzdec zzl(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != this.zzgto) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        } else if (this.zzgtn.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            return (zzdec) zzdey.zza(this.zzgtn, (zzdsg) (zzdhq) ((zzdqw) ((zza) zzdhq.zzaro().zza(this.zzgtp)).zzal(zzdpm.zzh(bArr, 0, this.zzgto)).zzazr()), zzdec.class);
        } else if (this.zzgtn.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zzgtr);
            zzdji zzdji = (zzdji) ((zzdqw) ((zzdji.zza) zzdji.zzatl().zza(this.zzgtq.zzaqc())).zzbm(zzdpm.zzy(Arrays.copyOfRange(bArr, this.zzgtr, this.zzgto))).zzazr());
            return (zzdec) zzdey.zza(this.zzgtn, (zzdsg) (zzdgo) ((zzdqw) zzdgo.zzaqd().zzdu(this.zzgtq.getVersion()).zzb((zzdgx) ((zzdqw) ((zzdgx.zza) zzdgx.zzaqu().zza(this.zzgtq.zzaqb())).zzab(zzdpm.zzy(copyOfRange)).zzazr())).zzb(zzdji).zzazr()), zzdec.class);
        } else {
            throw new GeneralSecurityException("unknown DEM key type");
        }
    }
}
