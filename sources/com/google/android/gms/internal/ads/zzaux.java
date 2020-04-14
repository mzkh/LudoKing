package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import com.google.android.gms.ads.internal.zzq;
import java.io.InputStream;
import java.util.Map;

@TargetApi(21)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzaux extends zzauy {
    public final int zzvt() {
        return 16974374;
    }

    public final CookieManager zzbd(Context context) {
        if (zzvs()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzaug.zzc("Failed to obtain CookieManager.", th);
            zzq.zzkn().zza(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public final zzbbv zza(zzbbw zzbbw, zzsd zzsd, boolean z) {
        return new zzbcx(zzbbw, zzsd, z);
    }

    public final WebResourceResponse zza(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        WebResourceResponse webResourceResponse = new WebResourceResponse(str, str2, i, str3, map, inputStream);
        return webResourceResponse;
    }
}
