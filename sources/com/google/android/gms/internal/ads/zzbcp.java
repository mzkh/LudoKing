package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.android.gms.internal.ads.zzbct;
import com.google.android.gms.internal.ads.zzbdb;
import com.google.android.gms.internal.ads.zzbdd;

@TargetApi(17)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbcp<WebViewT extends zzbct & zzbdb & zzbdd> {
    private final zzbcu zzehs;
    private final WebViewT zzeht;

    public static zzbcp<zzbbw> zzc(zzbbw zzbbw) {
        return new zzbcp<>(zzbbw, new zzbcs(zzbbw));
    }

    private zzbcp(WebViewT webviewt, zzbcu zzbcu) {
        this.zzehs = zzbcu;
        this.zzeht = webviewt;
    }

    @JavascriptInterface
    public final void notify(String str) {
        if (TextUtils.isEmpty(str)) {
            zzaug.zzeu("URL is empty, ignoring message");
        } else {
            zzaul.zzdsu.post(new zzbcr(this, str));
        }
    }

    @JavascriptInterface
    public final String getClickSignals(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            zzaug.zzdy("Click string is empty, not proceeding.");
            return str2;
        }
        zzdf zzzs = ((zzbdb) this.zzeht).zzzs();
        if (zzzs == null) {
            zzaug.zzdy("Signal utils is empty, ignoring.");
            return str2;
        }
        zzdc zzcd = zzzs.zzcd();
        if (zzcd == null) {
            zzaug.zzdy("Signals object is empty, ignoring.");
            return str2;
        } else if (this.zzeht.getContext() != null) {
            return zzcd.zza(this.zzeht.getContext(), str, ((zzbdd) this.zzeht).getView(), this.zzeht.zzxn());
        } else {
            zzaug.zzdy("Context is null, ignoring.");
            return str2;
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzfl(String str) {
        this.zzehs.zzh(Uri.parse(str));
    }
}
