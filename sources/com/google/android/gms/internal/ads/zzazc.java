package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzazc {
    private final Context zzcfz;
    private final zzazj zzdya;
    private final ViewGroup zzdyv;
    private zzayw zzdyw;

    public zzazc(Context context, ViewGroup viewGroup, zzbbw zzbbw) {
        this(context, viewGroup, zzbbw, null);
    }

    @VisibleForTesting
    private zzazc(Context context, ViewGroup viewGroup, zzazj zzazj, zzayw zzayw) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.zzcfz = context;
        this.zzdyv = viewGroup;
        this.zzdya = zzazj;
        this.zzdyw = null;
    }

    public final void zze(int i, int i2, int i3, int i4) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzayw zzayw = this.zzdyw;
        if (zzayw != null) {
            zzayw.zzd(i, i2, i3, i4);
        }
    }

    public final void zza(int i, int i2, int i3, int i4, int i5, boolean z, zzazk zzazk) {
        if (this.zzdyw == null) {
            zzzs.zza(this.zzdya.zzxq().zzpy(), this.zzdya.zzxm(), "vpr2");
            Context context = this.zzcfz;
            zzazj zzazj = this.zzdya;
            zzayw zzayw = new zzayw(context, zzazj, i5, z, zzazj.zzxq().zzpy(), zzazk);
            this.zzdyw = zzayw;
            this.zzdyv.addView(this.zzdyw, 0, new LayoutParams(-1, -1));
            int i6 = i;
            int i7 = i2;
            this.zzdyw.zzd(i, i2, i3, i4);
            this.zzdya.zzao(false);
        }
    }

    public final zzayw zzxg() {
        Preconditions.checkMainThread("getAdVideoUnderlay must be called from the UI thread.");
        return this.zzdyw;
    }

    public final void onPause() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzayw zzayw = this.zzdyw;
        if (zzayw != null) {
            zzayw.pause();
        }
    }

    public final void onDestroy() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzayw zzayw = this.zzdyw;
        if (zzayw != null) {
            zzayw.destroy();
            this.zzdyv.removeView(this.zzdyw);
            this.zzdyw = null;
        }
    }
}
