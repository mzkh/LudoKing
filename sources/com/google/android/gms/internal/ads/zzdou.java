package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdou {
    private static final Pattern zzhfe;
    private static final Pattern zzhff;

    public static void zzfg(int i) throws InvalidAlgorithmParameterException {
        if (i != 16 && i != 32) {
            throw new InvalidAlgorithmParameterException(String.format("invalid key size %d; only 128-bit and 256-bit AES keys are supported", new Object[]{Integer.valueOf(i << 3)}));
        }
    }

    public static void zzx(int i, int i2) throws GeneralSecurityException {
        if (i < 0 || i > 0) {
            throw new GeneralSecurityException(String.format("key has version %d; only keys with version in range [0..%d] are supported", new Object[]{Integer.valueOf(i), Integer.valueOf(0)}));
        }
    }

    public static void zzc(zzdob zzdob) throws GeneralSecurityException {
        int i = zzdot.zzhez[zzdob.ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            String str = "Unsupported hash: ";
            String valueOf = String.valueOf(zzdob.name());
            throw new GeneralSecurityException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    public static void zzfh(int i) throws GeneralSecurityException {
        if (i < 2048) {
            throw new GeneralSecurityException(String.format("Modulus size is %d; only modulus size >= 2048-bit is supported", new Object[]{Integer.valueOf(i)}));
        }
    }

    static {
        String str = "([0-9a-zA-Z\\-\\.\\_~])+";
        zzhfe = Pattern.compile(String.format("^projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s$", new Object[]{str, str, str, str}), 2);
        zzhff = Pattern.compile(String.format("^projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s/cryptoKeyVersions/%s$", new Object[]{str, str, str, str, str}), 2);
    }
}
