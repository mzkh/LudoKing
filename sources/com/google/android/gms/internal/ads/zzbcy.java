package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import java.io.File;
import java.util.Collections;
import java.util.Map;

@TargetApi(11)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzbcy extends zzbbv {
    public zzbcy(zzbbw zzbbw, zzsd zzsd, boolean z) {
        super(zzbbw, zzsd, z);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final WebResourceResponse zza(WebView webView, String str, @Nullable Map<String, String> map) {
        String str2;
        if (!(webView instanceof zzbbw)) {
            zzaug.zzeu("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzbbw zzbbw = (zzbbw) webView;
        if (this.zzeew != null) {
            this.zzeew.zza(str, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.zzd(str, map);
        }
        if (zzbbw.zzzp() != null) {
            zzbbw.zzzp().zzsq();
        }
        if (zzbbw.zzzn().zzaau()) {
            str2 = (String) zzuv.zzon().zzd(zzza.zzcig);
        } else if (zzbbw.zzzu()) {
            str2 = (String) zzuv.zzon().zzd(zzza.zzcif);
        } else {
            str2 = (String) zzuv.zzon().zzd(zzza.zzcie);
        }
        zzq.zzkj();
        return zzaul.zzd(zzbbw.getContext(), zzbbw.zzxr().zzblz, str2);
    }
}
