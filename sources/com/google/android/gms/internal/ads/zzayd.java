package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzayd {
    public static void zza(View view, OnGlobalLayoutListener onGlobalLayoutListener) {
        new zzayg(view, onGlobalLayoutListener).attach();
    }

    public static void zza(View view, OnScrollChangedListener onScrollChangedListener) {
        new zzayf(view, onScrollChangedListener).attach();
    }
}
