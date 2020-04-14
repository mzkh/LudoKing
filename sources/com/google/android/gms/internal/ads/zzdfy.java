package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdkl.zza;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdfy {
    @Deprecated
    public static final zzdkl zzgtc;
    @Deprecated
    public static final zzdkl zzgtd = ((zzdkl) ((zzdqw) ((zza) zzdkl.zzavk().zza(zzgtc)).zzhe("TINK_HYBRID_1_1_0").zzazr()));
    public static final zzdkl zzgte;

    public static void zzapz() throws GeneralSecurityException {
        zzdfd.zzapz();
        zzdey.zza("TinkHybridEncrypt", (zzdef<?>) new zzdgb<Object>());
        zzdey.zza("TinkHybridDecrypt", (zzdef<?>) new zzdfx<Object>());
        zzdee.zza(zzgte);
    }

    static {
        String str = "EciesAeadHkdfPrivateKey";
        String str2 = "HybridDecrypt";
        String str3 = "TinkHybridDecrypt";
        String str4 = "EciesAeadHkdfPublicKey";
        String str5 = "HybridEncrypt";
        String str6 = "TinkHybridEncrypt";
        zzgtc = (zzdkl) ((zzdqw) ((zza) zzdkl.zzavk().zza(zzdfd.zzgtc)).zzb(zzdee.zza(str3, str2, str, 0, true)).zzb(zzdee.zza(str6, str5, str4, 0, true)).zzhe("TINK_HYBRID_1_0_0").zzazr());
        zzgte = (zzdkl) ((zzdqw) ((zza) zzdkl.zzavk().zza(zzdfd.zzgte)).zzb(zzdee.zza(str3, str2, str, 0, true)).zzb(zzdee.zza(str6, str5, str4, 0, true)).zzhe("TINK_HYBRID").zzazr());
        try {
            zzapz();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
