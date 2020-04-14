package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzk implements Runnable {
    private final zzl zzdhu;
    private final Drawable zzdhv;

    zzk(zzl zzl, Drawable drawable) {
        this.zzdhu = zzl;
        this.zzdhv = drawable;
    }

    public final void run() {
        zzl zzl = this.zzdhu;
        zzl.zzdhw.zzzr.getWindow().setBackgroundDrawable(this.zzdhv);
    }
}
