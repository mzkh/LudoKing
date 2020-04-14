package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdme implements zzdet {
    private final int zzhao = 16;
    private final SecretKey zzhau;
    private byte[] zzhav;
    private byte[] zzhaw;

    private static Cipher zzawu() throws GeneralSecurityException {
        return (Cipher) zzdnu.zzhdz.zzhf("AES/ECB/NoPadding");
    }

    public zzdme(byte[] bArr, int i) throws GeneralSecurityException {
        zzdou.zzfg(bArr.length);
        this.zzhau = new SecretKeySpec(bArr, "AES");
        Cipher zzawu = zzawu();
        zzawu.init(1, this.zzhau);
        this.zzhav = zzdmj.zzp(zzawu.doFinal(new byte[16]));
        this.zzhaw = zzdmj.zzp(this.zzhav);
    }

    public final byte[] zzk(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2;
        Cipher zzawu = zzawu();
        zzawu.init(1, this.zzhau);
        double length = (double) bArr.length;
        Double.isNaN(length);
        int max = Math.max(1, (int) Math.ceil(length / 16.0d));
        if ((max << 4) == bArr.length) {
            bArr2 = zzdmn.zza(bArr, (max - 1) << 4, this.zzhav, 0, 16);
        } else {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, (max - 1) << 4, bArr.length);
            if (copyOfRange.length < 16) {
                byte[] copyOf = Arrays.copyOf(copyOfRange, 16);
                copyOf[copyOfRange.length] = Byte.MIN_VALUE;
                bArr2 = zzdmn.zzd(copyOf, this.zzhaw);
            } else {
                throw new IllegalArgumentException("x must be smaller than a block.");
            }
        }
        byte[] bArr3 = new byte[16];
        for (int i = 0; i < max - 1; i++) {
            bArr3 = zzawu.doFinal(zzdmn.zza(bArr3, 0, bArr, i << 4, 16));
        }
        byte[] bArr4 = new byte[this.zzhao];
        System.arraycopy(zzawu.doFinal(zzdmn.zzd(bArr2, bArr3)), 0, bArr4, 0, this.zzhao);
        return bArr4;
    }
}
