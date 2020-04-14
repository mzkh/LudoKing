package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdfe implements zzdef<zzdec> {
    public final zzden<zzdec> zzb(String str, String str2, int i) throws GeneralSecurityException {
        zzden<zzdec> zzden;
        String lowerCase = str2.toLowerCase();
        char c = 65535;
        if (((lowerCase.hashCode() == 2989895 && lowerCase.equals("aead")) ? (char) 0 : 65535) == 0) {
            switch (str.hashCode()) {
                case 245054116:
                    if (str.equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
                        c = 6;
                        break;
                    }
                    break;
                case 360753376:
                    if (str.equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1215885937:
                    if (str.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1469984853:
                    if (str.equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1797113348:
                    if (str.equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1855890991:
                    if (str.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
                        c = 2;
                        break;
                    }
                    break;
                case 2079211877:
                    if (str.equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    zzden = new zzdfh<>();
                    break;
                case 1:
                    zzden = new zzdfi<>();
                    break;
                case 2:
                    zzden = new zzdfl<>();
                    break;
                case 3:
                    zzden = new zzdfk<>();
                    break;
                case 4:
                    zzden = new zzdfn<>();
                    break;
                case 5:
                    zzden = new zzdfp<>();
                    break;
                case 6:
                    zzden = new zzdfo<>();
                    break;
                default:
                    throw new GeneralSecurityException(String.format("No support for primitive 'Aead' with key type '%s'.", new Object[]{str}));
            }
            if (zzden.getVersion() >= i) {
                return zzden;
            }
            throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", new Object[]{str, Integer.valueOf(i)}));
        }
        throw new GeneralSecurityException(String.format("No support for primitive '%s'.", new Object[]{str2}));
    }

    public final zzdex<zzdec> zzapm() {
        return new zzdfg();
    }
}
