package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.formats.UnifiedNativeAd.MediaContent;
import com.google.android.gms.internal.ads.zzaax;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final /* synthetic */ class zzd implements zzaax {
    private final UnifiedNativeAdView zzbkl;

    zzd(UnifiedNativeAdView unifiedNativeAdView) {
        this.zzbkl = unifiedNativeAdView;
    }

    public final void setMediaContent(MediaContent mediaContent) {
        this.zzbkl.zza(mediaContent);
    }
}
