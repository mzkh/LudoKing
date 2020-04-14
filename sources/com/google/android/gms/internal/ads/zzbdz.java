package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebView;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbdz {
    @GuardedBy("InvokeJavascriptWorkaround.class")
    @VisibleForTesting
    private static Boolean zzeih;

    private zzbdz() {
    }

    @TargetApi(19)
    private static boolean zzb(WebView webView) {
        boolean booleanValue;
        synchronized (zzbdz.class) {
            if (zzeih == null) {
                try {
                    webView.evaluateJavascript("(function(){})()", null);
                    zzeih = Boolean.valueOf(true);
                } catch (IllegalStateException unused) {
                    zzeih = Boolean.valueOf(false);
                }
            }
            booleanValue = zzeih.booleanValue();
        }
        return booleanValue;
    }

    @TargetApi(19)
    static void zza(WebView webView, String str) {
        if (!PlatformVersion.isAtLeastKitKat() || !zzb(webView)) {
            String str2 = "javascript:";
            String valueOf = String.valueOf(str);
            webView.loadUrl(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return;
        }
        webView.evaluateJavascript(str, null);
    }
}
