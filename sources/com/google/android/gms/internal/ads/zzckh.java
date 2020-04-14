package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzckh implements zzbsu {
    private final zzcgf zzfxr;

    zzckh(zzcgf zzcgf) {
        this.zzfxr = zzcgf;
    }

    public final void zza(boolean z, Context context) {
        zzcgf zzcgf = this.zzfxr;
        try {
            ((zzcwm) zzcgf.zzddv).setImmersiveMode(z);
            ((zzcwm) zzcgf.zzddv).showVideo();
        } catch (zzcwh e) {
            zzaug.zzd("Cannot show rewarded video.", e);
        }
    }
}
