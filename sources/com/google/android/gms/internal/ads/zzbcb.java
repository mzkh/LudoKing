package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzi;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbcb {
    public static zzddi<zzbbw> zza(Context context, zzaxl zzaxl, String str, zzdf zzdf, zza zza) {
        zzddi zzah = zzdcy.zzah(null);
        zzbce zzbce = new zzbce(context, zzdf, zzaxl, zza, str);
        return zzdcy.zzb(zzah, (zzdcj<? super I, ? extends O>) zzbce, (Executor) zzaxn.zzdwm);
    }

    public static zzbbw zza(Context context, zzbdj zzbdj, String str, boolean z, boolean z2, @Nullable zzdf zzdf, zzaxl zzaxl, zzaab zzaab, zzi zzi, zza zza, zzsd zzsd, zzrf zzrf, boolean z3) throws zzbcf {
        zzza.initialize(context);
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcjx)).booleanValue()) {
            return zzbdp.zza(context, zzbdj, str, z, z2, zzdf, zzaxl, null, zzi, zza, zzsd, zzrf, z3);
        }
        try {
            zzbcd zzbcd = new zzbcd(context, zzbdj, str, z, z2, zzdf, zzaxl, null, zzi, zza, zzsd, zzrf, z3);
            return (zzbbw) zzawq.zza(zzbcd);
        } catch (Throwable th) {
            throw new zzbcf("Webview initialization failed.", th);
        }
    }
}
