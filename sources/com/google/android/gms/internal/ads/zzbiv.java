package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzbiv {
    private final View view;
    private final zzbbw zzczi;
    private final zzcvu zzfde;
    private final zzbkl zzfdn;

    public zzbiv(View view2, @Nullable zzbbw zzbbw, zzbkl zzbkl, zzcvu zzcvu) {
        this.view = view2;
        this.zzczi = zzbbw;
        this.zzfdn = zzbkl;
        this.zzfde = zzcvu;
    }

    @Nullable
    public final zzbbw zzaeo() {
        return this.zzczi;
    }

    public final View zzaeu() {
        return this.view;
    }

    public final zzbkl zzafc() {
        return this.zzfdn;
    }

    public final zzcvu zzafd() {
        return this.zzfde;
    }

    public zzbob zza(Set<zzbqs<zzbog>> set) {
        return new zzbob(set);
    }
}
