package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public interface zzrf {
    View getView();

    WebView getWebView();

    void onPageStarted(WebView webView, String str, Bitmap bitmap);

    void zza(Activity activity, WebView webView);

    void zze(String str, String str2);
}
