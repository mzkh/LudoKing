package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdos {
    public static String zza(zzdob zzdob) throws GeneralSecurityException {
        zzdou.zzc(zzdob);
        String valueOf = String.valueOf(zzdob);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 9);
        sb.append(valueOf);
        sb.append("withECDSA");
        return sb.toString();
    }

    public static String zzb(zzdob zzdob) throws GeneralSecurityException {
        int i = zzdor.zzhez[zzdob.ordinal()];
        if (i == 1) {
            return "SHA-1";
        }
        if (i == 2) {
            return "SHA-256";
        }
        if (i == 3) {
            return "SHA-384";
        }
        if (i == 4) {
            return "SHA-512";
        }
        String valueOf = String.valueOf(zzdob);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 17);
        sb.append("Unsupported hash ");
        sb.append(valueOf);
        throw new GeneralSecurityException(sb.toString());
    }

    public static boolean zzaxd() {
        try {
            Class.forName("android.app.Application", false, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static BigInteger zzw(byte[] bArr) {
        return new BigInteger(1, bArr);
    }

    public static byte[] zza(BigInteger bigInteger, int i) throws GeneralSecurityException {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == i) {
            return byteArray;
        }
        int i2 = i + 1;
        String str = "integer too large";
        if (byteArray.length > i2) {
            throw new GeneralSecurityException(str);
        } else if (byteArray.length != i2) {
            byte[] bArr = new byte[i];
            System.arraycopy(byteArray, 0, bArr, i - byteArray.length, byteArray.length);
            return bArr;
        } else if (byteArray[0] == 0) {
            return Arrays.copyOfRange(byteArray, 1, byteArray.length);
        } else {
            throw new GeneralSecurityException(str);
        }
    }

    public static byte[] zza(byte[] bArr, int i, zzdob zzdob) throws GeneralSecurityException {
        MessageDigest messageDigest = (MessageDigest) zzdnu.zzhec.zzhf(zzb(zzdob));
        int digestLength = messageDigest.getDigestLength();
        byte[] bArr2 = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 <= (i - 1) / digestLength; i3++) {
            messageDigest.reset();
            messageDigest.update(bArr);
            messageDigest.update(zza(BigInteger.valueOf((long) i3), 4));
            byte[] digest = messageDigest.digest();
            System.arraycopy(digest, 0, bArr2, i2, Math.min(digest.length, bArr2.length - i2));
            i2 += digest.length;
        }
        return bArr2;
    }
}
