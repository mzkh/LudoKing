package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbbw;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzi {
    public final int index;
    public final ViewGroup parent;
    public final LayoutParams zzdhr;
    public final Context zzlk;

    public zzi(zzbbw zzbbw) throws zzg {
        this.zzdhr = zzbbw.getLayoutParams();
        ViewParent parent2 = zzbbw.getParent();
        this.zzlk = zzbbw.zzzk();
        if (parent2 == null || !(parent2 instanceof ViewGroup)) {
            throw new zzg("Could not get the parent of the WebView for an overlay.");
        }
        this.parent = (ViewGroup) parent2;
        this.index = this.parent.indexOfChild(zzbbw.getView());
        this.parent.removeView(zzbbw.getView());
        zzbbw.zzas(true);
    }
}
