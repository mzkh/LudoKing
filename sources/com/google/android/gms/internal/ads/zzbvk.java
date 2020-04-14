package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.ViewGroup;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbvk implements zzaaw {
    private final /* synthetic */ zzbvz zzfmz;
    private final /* synthetic */ ViewGroup zzfna;
    private final /* synthetic */ zzbvj zzfnb;

    zzbvk(zzbvj zzbvj, zzbvz zzbvz, ViewGroup viewGroup) {
        this.zzfnb = zzbvj;
        this.zzfmz = zzbvz;
        this.zzfna = viewGroup;
    }

    public final void zzqk() {
        if (zzbvj.zza(this.zzfmz, zzbvh.zzfmp)) {
            this.zzfmz.onClick(this.zzfna);
        }
    }

    public final void zzc(MotionEvent motionEvent) {
        this.zzfmz.onTouch(null, motionEvent);
    }
}
