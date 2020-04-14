package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.webkit.JsPromptResult;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbbs implements OnCancelListener {
    private final /* synthetic */ JsPromptResult zzeeh;

    zzbbs(JsPromptResult jsPromptResult) {
        this.zzeeh = jsPromptResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zzeeh.cancel();
    }
}
