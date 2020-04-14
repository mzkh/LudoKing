package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzchz implements zzbsu {
    private final zzcgf zzfxr;

    zzchz(zzcgf zzcgf) {
        this.zzfxr = zzcgf;
    }

    public final void zza(boolean z, Context context) {
        zzcgf zzcgf = this.zzfxr;
        try {
            ((zzcwm) zzcgf.zzddv).setImmersiveMode(z);
            ((zzcwm) zzcgf.zzddv).showInterstitial();
        } catch (zzcwh unused) {
            zzaug.zzet("Cannot show interstitial.");
        }
    }
}
