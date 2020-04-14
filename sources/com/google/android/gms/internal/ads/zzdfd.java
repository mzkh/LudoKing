package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdkl.zza;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdfd {
    @Deprecated
    public static final zzdkl zzgtc;
    @Deprecated
    private static final zzdkl zzgtd = ((zzdkl) ((zzdqw) ((zza) zzdkl.zzavk().zza(zzgtc)).zzhe("TINK_AEAD_1_1_0").zzazr()));
    public static final zzdkl zzgte;

    public static void zzapz() throws GeneralSecurityException {
        zzdgl.zzapz();
        zzdey.zza("TinkAead", (zzdef<?>) new zzdfe<Object>());
        zzdee.zza(zzgte);
    }

    static {
        String str = "AesCtrHmacAeadKey";
        String str2 = "Aead";
        String str3 = "TinkAead";
        String str4 = "AesEaxKey";
        String str5 = "AesGcmKey";
        String str6 = "ChaCha20Poly1305Key";
        String str7 = "KmsAeadKey";
        String str8 = "KmsEnvelopeAeadKey";
        zzgtc = (zzdkl) ((zzdqw) ((zza) zzdkl.zzavk().zza(zzdgl.zzgtc)).zzb(zzdee.zza(str3, str2, str, 0, true)).zzb(zzdee.zza(str3, str2, str4, 0, true)).zzb(zzdee.zza(str3, str2, str5, 0, true)).zzb(zzdee.zza(str3, str2, str6, 0, true)).zzb(zzdee.zza(str3, str2, str7, 0, true)).zzb(zzdee.zza(str3, str2, str8, 0, true)).zzhe("TINK_AEAD_1_0_0").zzazr());
        zzgte = (zzdkl) ((zzdqw) ((zza) zzdkl.zzavk().zza(zzdgl.zzgte)).zzb(zzdee.zza(str3, str2, str, 0, true)).zzb(zzdee.zza(str3, str2, str4, 0, true)).zzb(zzdee.zza(str3, str2, str5, 0, true)).zzb(zzdee.zza(str3, str2, str6, 0, true)).zzb(zzdee.zza(str3, str2, str7, 0, true)).zzb(zzdee.zza(str3, str2, str8, 0, true)).zzb(zzdee.zza(str3, str2, "XChaCha20Poly1305Key", 0, true)).zzhe("TINK_AEAD").zzazr());
        try {
            zzapz();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
