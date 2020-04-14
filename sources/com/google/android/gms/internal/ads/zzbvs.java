package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbvs implements zzaer {
    private final zzbvr zzfnl;

    zzbvs(zzbvr zzbvr) {
        this.zzfnl = zzbvr;
    }

    public final void zza(Object obj, Map map) {
        zzbbw zzbbw = (zzbbw) obj;
        zzbbw.zzzp().zza((zzbdf) new zzbvx(this.zzfnl, map));
        String str = (String) map.get("overlayHtml");
        String str2 = (String) map.get("baseUrl");
        if (TextUtils.isEmpty(str2)) {
            zzbbw.loadData(str, "text/html", "UTF-8");
        } else {
            zzbbw.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
        }
    }
}
