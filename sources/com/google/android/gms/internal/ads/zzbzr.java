package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbzr implements OnTouchListener {
    private final zzbzn zzfqo;

    zzbzr(zzbzn zzbzn) {
        this.zzfqo = zzbzn;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.zzfqo.zza(view, motionEvent);
    }
}
