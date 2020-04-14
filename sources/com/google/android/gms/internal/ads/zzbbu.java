package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsPromptResult;
import android.widget.EditText;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbbu implements OnClickListener {
    private final /* synthetic */ JsPromptResult zzeeh;
    private final /* synthetic */ EditText zzeej;

    zzbbu(JsPromptResult jsPromptResult, EditText editText) {
        this.zzeeh = jsPromptResult;
        this.zzeej = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzeeh.confirm(this.zzeej.getText().toString());
    }
}
