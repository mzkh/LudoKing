package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.webkit.JsResult;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbbn implements OnCancelListener {
    private final /* synthetic */ JsResult zzeeg;

    zzbbn(JsResult jsResult) {
        this.zzeeg = jsResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zzeeg.cancel();
    }
}
