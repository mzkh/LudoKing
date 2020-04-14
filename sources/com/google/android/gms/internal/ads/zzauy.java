package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

@TargetApi(19)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzauy extends zzauv {
    public final boolean isAttachedToWindow(View view) {
        return view.isAttachedToWindow();
    }

    public final LayoutParams zzvr() {
        return new LayoutParams(-1, -1);
    }
}
