package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzadv extends zzacy {
    private final OnUnifiedNativeAdLoadedListener zzcxb;

    public zzadv(OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        this.zzcxb = onUnifiedNativeAdLoadedListener;
    }

    public final void zza(zzadg zzadg) {
        this.zzcxb.onUnifiedNativeAdLoaded(new zzadl(zzadg));
    }
}
