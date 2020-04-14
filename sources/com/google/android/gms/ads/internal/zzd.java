package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzaip;
import com.google.android.gms.internal.ads.zzais;
import com.google.android.gms.internal.ads.zzats;
import com.google.android.gms.internal.ads.zzaug;
import com.google.android.gms.internal.ads.zzaxl;
import com.google.android.gms.internal.ads.zzaxn;
import com.google.android.gms.internal.ads.zzaxr;
import com.google.android.gms.internal.ads.zzdcy;
import com.google.android.gms.internal.ads.zzddi;
import com.google.android.gms.internal.ads.zzuv;
import com.google.android.gms.internal.ads.zzza;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzd {
    private long zzbku = 0;
    private Context zzlk;

    public final void zza(Context context, zzaxl zzaxl, String str, @Nullable Runnable runnable) {
        zza(context, zzaxl, true, null, str, null, runnable);
    }

    public final void zza(Context context, zzaxl zzaxl, String str, zzats zzats) {
        zza(context, zzaxl, false, zzats, zzats != null ? zzats.zzuo() : null, str, null);
    }

    @VisibleForTesting
    private final void zza(Context context, zzaxl zzaxl, boolean z, @Nullable zzats zzats, String str, @Nullable String str2, @Nullable Runnable runnable) {
        if (zzq.zzkq().elapsedRealtime() - this.zzbku < 5000) {
            zzaug.zzeu("Not retrying to fetch app settings");
            return;
        }
        this.zzbku = zzq.zzkq().elapsedRealtime();
        boolean z2 = true;
        if (zzats != null) {
            if (!(zzq.zzkq().currentTimeMillis() - zzats.zzul() > ((Long) zzuv.zzon().zzd(zzza.zzcoy)).longValue()) && zzats.zzum()) {
                z2 = false;
            }
        }
        if (z2) {
            if (context == null) {
                zzaug.zzeu("Context not provided to fetch application settings");
            } else if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                this.zzlk = applicationContext;
                zzaip zza = zzq.zzkw().zzb(this.zzlk, zzaxl).zza("google.afma.config.fetchAppSettings", zzais.zzday, zzais.zzday);
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("app_id", str);
                    } else if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("ad_unit_id", str2);
                    }
                    jSONObject.put("is_init", z);
                    jSONObject.put("pn", context.getPackageName());
                    zzddi zzi = zza.zzi(jSONObject);
                    zzddi zzb = zzdcy.zzb(zzi, zzf.zzbkv, (Executor) zzaxn.zzdwn);
                    if (runnable != null) {
                        zzi.addListener(runnable, zzaxn.zzdwn);
                    }
                    zzaxr.zza(zzb, "ConfigLoader.maybeFetchNewAppSettings");
                } catch (Exception e) {
                    zzaug.zzc("Error requesting application settings", e);
                }
            } else {
                zzaug.zzeu("App settings could not be fetched. Required parameters missing");
            }
        }
    }
}
