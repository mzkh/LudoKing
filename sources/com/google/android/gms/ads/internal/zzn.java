package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzn implements OnTouchListener {
    private final /* synthetic */ zzl zzblj;

    zzn(zzl zzl) {
        this.zzblj = zzl;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zzblj.zzblq != null) {
            this.zzblj.zzblq.zzb(motionEvent);
        }
        return false;
    }
}
