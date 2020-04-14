package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcdd implements Callable {
    private final Context zzdpy;

    zzcdd(Context context) {
        this.zzdpy = context;
    }

    public final Object call() {
        CookieManager zzbd = zzq.zzkl().zzbd(this.zzdpy);
        return zzbd != null ? zzbd.getCookie("googleads.g.doubleclick.net") : "";
    }
}
