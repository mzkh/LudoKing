package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbdn implements OnAttachStateChangeListener {
    private final /* synthetic */ zzasi zzefc;
    private final /* synthetic */ zzbdm zzeib;

    zzbdn(zzbdm zzbdm, zzasi zzasi) {
        this.zzeib = zzbdm;
        this.zzefc = zzasi;
    }

    public final void onViewDetachedFromWindow(View view) {
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzeib.zza(view, this.zzefc, 10);
    }
}
