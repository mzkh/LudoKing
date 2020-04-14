package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdju.zza;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdee {
    public static zzdju zza(String str, String str2, String str3, int i, boolean z) {
        zza zzgz = zzdju.zzaug().zzgz(str2);
        String valueOf = String.valueOf(str3);
        String str4 = "type.googleapis.com/google.crypto.tink.";
        return (zzdju) ((zzdqw) zzgz.zzha(valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4)).zzeq(0).zzbg(true).zzhb(str).zzazr());
    }

    public static void zza(zzdkl zzdkl) throws GeneralSecurityException {
        for (zzdju zzdju : zzdkl.zzavj()) {
            if (zzdju.zzatu().isEmpty()) {
                throw new GeneralSecurityException("Missing type_url.");
            } else if (zzdju.zzauc().isEmpty()) {
                throw new GeneralSecurityException("Missing primitive_name.");
            } else if (!zzdju.zzauf().isEmpty()) {
                zzdef zzgt = zzdey.zzgt(zzdju.zzauf());
                zzdey.zza(zzgt.zzapm());
                zzdey.zza(zzgt.zzb(zzdju.zzatu(), zzdju.zzauc(), zzdju.zzaud()), zzdju.zzaue());
            } else {
                throw new GeneralSecurityException("Missing catalogue_name.");
            }
        }
    }
}
