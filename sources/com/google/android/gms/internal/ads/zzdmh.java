package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdmh implements zzdec {
    private final SecretKey zzhau;

    public zzdmh(byte[] bArr) throws GeneralSecurityException {
        zzdou.zzfg(bArr.length);
        this.zzhau = new SecretKeySpec(bArr, "AES");
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length <= 2147483619) {
            byte[] bArr3 = new byte[(bArr.length + 12 + 16)];
            byte[] zzff = zzdoj.zzff(12);
            System.arraycopy(zzff, 0, bArr3, 0, 12);
            Cipher cipher = (Cipher) zzdnu.zzhdz.zzhf("AES/GCM/NoPadding");
            cipher.init(1, this.zzhau, zzf(zzff, 0, zzff.length));
            if (!(bArr2 == null || bArr2.length == 0)) {
                cipher.updateAAD(bArr2);
            }
            int doFinal = cipher.doFinal(bArr, 0, bArr.length, bArr3, 12);
            if (doFinal == bArr.length + 16) {
                return bArr3;
            }
            throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", new Object[]{Integer.valueOf(16), Integer.valueOf(doFinal - bArr.length)}));
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    private static AlgorithmParameterSpec zzf(byte[] bArr, int i, int i2) throws GeneralSecurityException {
        try {
            Class.forName("javax.crypto.spec.GCMParameterSpec");
            return new GCMParameterSpec(128, bArr, 0, i2);
        } catch (ClassNotFoundException unused) {
            if (zzdos.zzaxd()) {
                return new IvParameterSpec(bArr, 0, i2);
            }
            throw new GeneralSecurityException("cannot use AES-GCM: javax.crypto.spec.GCMParameterSpec not found");
        }
    }
}
