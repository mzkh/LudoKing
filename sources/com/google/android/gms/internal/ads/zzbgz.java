package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzq;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbgz implements zzbgs {
    private final Context zzlk;

    public zzbgz(Context context) {
        this.zzlk = context;
    }

    public final void zzk(Map<String, String> map) {
        String str = (String) map.get("cookie");
        if (!TextUtils.isEmpty(str)) {
            CookieManager zzbd = zzq.zzkl().zzbd(this.zzlk);
            if (zzbd != null) {
                zzbd.setCookie("googleads.g.doubleclick.net", str);
            }
        }
    }
}
