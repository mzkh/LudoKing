package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbid {
    private final View view;
    private final zzbbw zzczi;
    private final zzcvu zzfde;
    private final int zzfdf;

    public zzbid(View view2, @Nullable zzbbw zzbbw, zzcvu zzcvu, int i) {
        this.view = view2;
        this.zzczi = zzbbw;
        this.zzfde = zzcvu;
        this.zzfdf = i;
    }

    @Nullable
    public final zzbbw zzaeo() {
        return this.zzczi;
    }

    public final View zzaep() {
        return this.view;
    }

    public final zzcvu zzaeq() {
        return this.zzfde;
    }

    public final int zzaer() {
        return this.zzfdf;
    }
}
