package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdmg implements zzdof {
    private final SecretKeySpec zzhaz;
    private final int zzhbb;
    private final int zzhbc = ((Cipher) zzdnu.zzhdz.zzhf("AES/CTR/NoPadding")).getBlockSize();

    public zzdmg(byte[] bArr, int i) throws GeneralSecurityException {
        zzdou.zzfg(bArr.length);
        this.zzhaz = new SecretKeySpec(bArr, "AES");
        if (i < 12 || i > this.zzhbc) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.zzhbb = i;
    }

    public final byte[] zzo(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzhbb;
        if (length <= Integer.MAX_VALUE - i) {
            byte[] bArr2 = new byte[(bArr.length + i)];
            byte[] zzff = zzdoj.zzff(i);
            System.arraycopy(zzff, 0, bArr2, 0, this.zzhbb);
            int length2 = bArr.length;
            int i2 = this.zzhbb;
            Cipher cipher = (Cipher) zzdnu.zzhdz.zzhf("AES/CTR/NoPadding");
            byte[] bArr3 = new byte[this.zzhbc];
            System.arraycopy(zzff, 0, bArr3, 0, this.zzhbb);
            cipher.init(1, this.zzhaz, new IvParameterSpec(bArr3));
            if (cipher.doFinal(bArr, 0, length2, bArr2, i2) == length2) {
                return bArr2;
            }
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
        int i3 = Integer.MAX_VALUE - i;
        StringBuilder sb = new StringBuilder(43);
        sb.append("plaintext length can not exceed ");
        sb.append(i3);
        throw new GeneralSecurityException(sb.toString());
    }
}
