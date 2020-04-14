package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zztt extends zzvb {
    private final AdListener zzcbv;

    public zztt(AdListener adListener) {
        this.zzcbv = adListener;
    }

    public final void onAdClosed() {
        this.zzcbv.onAdClosed();
    }

    public final void onAdFailedToLoad(int i) {
        this.zzcbv.onAdFailedToLoad(i);
    }

    public final void onAdLeftApplication() {
        this.zzcbv.onAdLeftApplication();
    }

    public final void onAdLoaded() {
        this.zzcbv.onAdLoaded();
    }

    public final void onAdOpened() {
        this.zzcbv.onAdOpened();
    }

    public final void onAdClicked() {
        this.zzcbv.onAdClicked();
    }

    public final void onAdImpression() {
        this.zzcbv.onAdImpression();
    }

    public final AdListener getAdListener() {
        return this.zzcbv;
    }
}
