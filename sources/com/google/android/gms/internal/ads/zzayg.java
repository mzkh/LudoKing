package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.ads.internal.zzq;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzayg extends zzayi implements OnGlobalLayoutListener {
    private final WeakReference<OnGlobalLayoutListener> zzdwz;

    public zzayg(View view, OnGlobalLayoutListener onGlobalLayoutListener) {
        super(view);
        this.zzdwz = new WeakReference<>(onGlobalLayoutListener);
    }

    public final void onGlobalLayout() {
        OnGlobalLayoutListener onGlobalLayoutListener = (OnGlobalLayoutListener) this.zzdwz.get();
        if (onGlobalLayoutListener != null) {
            onGlobalLayoutListener.onGlobalLayout();
        } else {
            detach();
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    /* access modifiers changed from: protected */
    public final void zzb(ViewTreeObserver viewTreeObserver) {
        zzq.zzkl();
        viewTreeObserver.removeOnGlobalLayoutListener(this);
    }
}
