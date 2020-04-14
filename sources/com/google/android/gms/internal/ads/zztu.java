package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zztu extends zzvr {
    private final AdMetadataListener zzcbw;

    public zztu(AdMetadataListener adMetadataListener) {
        this.zzcbw = adMetadataListener;
    }

    public final void onAdMetadataChanged() {
        AdMetadataListener adMetadataListener = this.zzcbw;
        if (adMetadataListener != null) {
            adMetadataListener.onAdMetadataChanged();
        }
    }
}
