package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

@TargetApi(11)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbcv extends zzbcy {
    public zzbcv(zzbbw zzbbw, zzsd zzsd, boolean z) {
        super(zzbbw, zzsd, z);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zza(webView, str, null);
    }
}
