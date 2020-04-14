package com.google.android.gms.internal.ads;

import android.webkit.JavascriptInterface;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzagt {
    private final zzagw zzczb;

    private zzagt(zzagw zzagw) {
        this.zzczb = zzagw;
    }

    @JavascriptInterface
    public final void notify(@Nullable String str) {
        this.zzczb.zzcx(str);
    }
}
