package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzq;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbdp {
    public static zzbbw zza(Context context, zzbdj zzbdj, String str, boolean z, boolean z2, @Nullable zzdf zzdf, zzaxl zzaxl, zzaab zzaab, zzi zzi, zza zza, zzsd zzsd, zzrf zzrf, boolean z3) throws zzbcf {
        try {
            zzbds zzbds = new zzbds(context, zzbdj, str, z, z2, zzdf, zzaxl, null, zzi, zza, zzsd, zzrf, z3);
            return (zzbbw) zzawq.zza(zzbds);
        } catch (Throwable th) {
            zzq.zzkn().zza(th, "AdWebViewFactory.newAdWebView2");
            throw new zzbcf("Webview initialization failed.", th);
        }
    }
}
