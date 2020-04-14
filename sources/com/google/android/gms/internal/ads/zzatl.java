package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzatl implements zzatn {
    public final zzddi<String> zza(String str, PackageInfo packageInfo) {
        return zzdcy.zzah(str);
    }

    public final zzddi<Info> zzak(Context context) {
        zzaxv zzaxv = new zzaxv();
        zzuv.zzoj();
        if (zzawy.zzbk(context)) {
            zzaxn.zzdwi.execute(new zzato(this, context, zzaxv));
        }
        return zzaxv;
    }
}
