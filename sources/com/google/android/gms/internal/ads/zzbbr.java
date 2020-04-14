package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsPromptResult;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbbr implements OnClickListener {
    private final /* synthetic */ JsPromptResult zzeeh;

    zzbbr(JsPromptResult jsPromptResult) {
        this.zzeeh = jsPromptResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzeeh.cancel();
    }
}
