package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzavb implements OnApplyWindowInsetsListener {
    private final zzavc zzdtd;
    private final Activity zzdte;

    zzavb(zzavc zzavc, Activity activity) {
        this.zzdtd = zzavc;
        this.zzdte = activity;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return zzavc.zza(this.zzdte, view, windowInsets);
    }
}
