package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzqb implements Runnable {
    private ValueCallback<String> zzbpu = new zzqe(this);
    final /* synthetic */ zzpt zzbpv;
    final /* synthetic */ WebView zzbpw;
    final /* synthetic */ boolean zzbpx;
    final /* synthetic */ zzpz zzbpy;

    zzqb(zzpz zzpz, zzpt zzpt, WebView webView, boolean z) {
        this.zzbpy = zzpz;
        this.zzbpv = zzpt;
        this.zzbpw = webView;
        this.zzbpx = z;
    }

    public final void run() {
        if (this.zzbpw.getSettings().getJavaScriptEnabled()) {
            try {
                this.zzbpw.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzbpu);
            } catch (Throwable unused) {
                this.zzbpu.onReceiveValue("");
            }
        }
    }
}
