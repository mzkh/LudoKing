package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ads.zzaug;
import com.google.android.gms.internal.ads.zzuv;
import com.google.android.gms.internal.ads.zzza;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzk extends WebViewClient {
    private final /* synthetic */ zzl zzblj;

    zzk(zzl zzl) {
        this.zzblj = zzl;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith(this.zzblj.zzjy())) {
            return false;
        }
        String str2 = "#007 Could not call remote method.";
        if (str.startsWith((String) zzuv.zzon().zzd(zzza.zzcpa))) {
            if (this.zzblj.zzblp != null) {
                try {
                    this.zzblj.zzblp.onAdFailedToLoad(3);
                } catch (RemoteException e) {
                    zzaug.zze(str2, e);
                }
            }
            this.zzblj.zzbl(0);
            return true;
        }
        if (str.startsWith((String) zzuv.zzon().zzd(zzza.zzcpb))) {
            if (this.zzblj.zzblp != null) {
                try {
                    this.zzblj.zzblp.onAdFailedToLoad(0);
                } catch (RemoteException e2) {
                    zzaug.zze(str2, e2);
                }
            }
            this.zzblj.zzbl(0);
            return true;
        }
        if (str.startsWith((String) zzuv.zzon().zzd(zzza.zzcpc))) {
            if (this.zzblj.zzblp != null) {
                try {
                    this.zzblj.zzblp.onAdLoaded();
                } catch (RemoteException e3) {
                    zzaug.zze(str2, e3);
                }
            }
            this.zzblj.zzbl(this.zzblj.zzbn(str));
            return true;
        } else if (str.startsWith("gmsg://")) {
            return true;
        } else {
            if (this.zzblj.zzblp != null) {
                try {
                    this.zzblj.zzblp.onAdLeftApplication();
                } catch (RemoteException e4) {
                    zzaug.zze(str2, e4);
                }
            }
            this.zzblj.zzbp(this.zzblj.zzbo(str));
            return true;
        }
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (this.zzblj.zzblp != null) {
            try {
                this.zzblj.zzblp.onAdFailedToLoad(0);
            } catch (RemoteException e) {
                zzaug.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
