package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsResult;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbbq implements OnClickListener {
    private final /* synthetic */ JsResult zzeeg;

    zzbbq(JsResult jsResult) {
        this.zzeeg = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzeeg.cancel();
    }
}
