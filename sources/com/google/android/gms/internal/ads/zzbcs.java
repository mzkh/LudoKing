package com.google.android.gms.internal.ads;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbcs implements zzbcu {
    private final zzbbw zzehv;

    zzbcs(zzbbw zzbbw) {
        this.zzehv = zzbbw;
    }

    public final void zzh(Uri uri) {
        zzbdg zzzp = this.zzehv.zzzp();
        if (zzzp == null) {
            zzaug.zzes("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
        } else {
            zzzp.zzh(uri);
        }
    }
}
