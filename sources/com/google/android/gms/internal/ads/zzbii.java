package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbii extends zzbkk {
    private final View view;
    @Nullable
    private final zzbbw zzczi;
    private final zzcvu zzfde;
    private final int zzfdf;
    @Nullable
    private zzrc zzfdh;

    zzbii(zzbkn zzbkn, View view2, @Nullable zzbbw zzbbw, zzcvu zzcvu, int i) {
        super(zzbkn);
        this.view = view2;
        this.zzczi = zzbbw;
        this.zzfde = zzcvu;
        this.zzfdf = i;
    }

    public final zzcvu zzaet() {
        return zzcwi.zza(this.zzfet.zzgjd, this.zzfde);
    }

    public final View zzaeu() {
        return this.view;
    }

    public final int zzaer() {
        return this.zzfdf;
    }

    public final boolean zzyw() {
        zzbbw zzbbw = this.zzczi;
        return zzbbw != null && zzbbw.zzzp().zzyw();
    }

    public final boolean zzaev() {
        zzbbw zzbbw = this.zzczi;
        return zzbbw != null && zzbbw.zzzr();
    }

    public final void zza(zzqr zzqr) {
        zzbbw zzbbw = this.zzczi;
        if (zzbbw != null) {
            zzbbw.zza(zzqr);
        }
    }

    public final void zza(zzrc zzrc) {
        this.zzfdh = zzrc;
    }

    @Nullable
    public final zzrc zzaew() {
        return this.zzfdh;
    }
}
