package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzavd;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzj extends RelativeLayout {
    @VisibleForTesting
    private zzavd zzdhs;
    @VisibleForTesting
    boolean zzdht;

    public zzj(Context context, String str, String str2) {
        super(context);
        this.zzdhs = new zzavd(context, str);
        this.zzdhs.zzr(str2);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.zzdht) {
            this.zzdhs.zzd(motionEvent);
        }
        return false;
    }
}
