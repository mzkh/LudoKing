package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdoi implements zzdet {
    private final Mac zzhes;
    private final int zzhet;
    private final String zzheu;
    private final Key zzhev;

    public zzdoi(String str, Key key, int i) throws GeneralSecurityException {
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        } else if (key.getEncoded().length >= 16) {
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1823053428) {
                if (hashCode != 392315118) {
                    if (hashCode == 392317873 && str.equals("HMACSHA512")) {
                        c = 2;
                    }
                } else if (str.equals("HMACSHA256")) {
                    c = 1;
                }
            } else if (str.equals("HMACSHA1")) {
                c = 0;
            }
            String str2 = "tag size too big";
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        String str3 = "unknown Hmac algorithm: ";
                        String valueOf = String.valueOf(str);
                        throw new NoSuchAlgorithmException(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                    } else if (i > 64) {
                        throw new InvalidAlgorithmParameterException(str2);
                    }
                } else if (i > 32) {
                    throw new InvalidAlgorithmParameterException(str2);
                }
            } else if (i > 20) {
                throw new InvalidAlgorithmParameterException(str2);
            }
            this.zzheu = str;
            this.zzhet = i;
            this.zzhev = key;
            this.zzhes = (Mac) zzdnu.zzhea.zzhf(str);
            this.zzhes.init(key);
        } else {
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
    }

    public final byte[] zzk(byte[] bArr) throws GeneralSecurityException {
        Mac mac;
        try {
            mac = (Mac) this.zzhes.clone();
        } catch (CloneNotSupportedException unused) {
            mac = (Mac) zzdnu.zzhea.zzhf(this.zzheu);
            mac.init(this.zzhev);
        }
        mac.update(bArr);
        byte[] bArr2 = new byte[this.zzhet];
        System.arraycopy(mac.doFinal(), 0, bArr2, 0, this.zzhet);
        return bArr2;
    }
}
