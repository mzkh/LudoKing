package com.jirbo.adcolony;

import androidx.annotation.NonNull;
import com.adcolony.sdk.AdColonyAdView;
import com.adcolony.sdk.AdColonyAdViewListener;
import com.adcolony.sdk.AdColonyZone;
import com.google.android.gms.ads.mediation.MediationBannerListener;

class AdColonyBannerAdListener extends AdColonyAdViewListener {
    private AdColonyAdapter adapter;
    private MediationBannerListener mediationBannerListener;

    AdColonyBannerAdListener(@NonNull AdColonyAdapter adColonyAdapter, @NonNull MediationBannerListener mediationBannerListener2) {
        this.mediationBannerListener = mediationBannerListener2;
        this.adapter = adColonyAdapter;
    }

    public void onClicked(AdColonyAdView adColonyAdView) {
        this.mediationBannerListener.onAdClicked(this.adapter);
    }

    public void onOpened(AdColonyAdView adColonyAdView) {
        this.mediationBannerListener.onAdOpened(this.adapter);
    }

    public void onClosed(AdColonyAdView adColonyAdView) {
        this.mediationBannerListener.onAdClosed(this.adapter);
    }

    public void onLeftApplication(AdColonyAdView adColonyAdView) {
        this.mediationBannerListener.onAdLeftApplication(this.adapter);
    }

    public void onRequestFilled(AdColonyAdView adColonyAdView) {
        this.adapter.setAdView(adColonyAdView);
        this.mediationBannerListener.onAdLoaded(this.adapter);
    }

    public void onRequestNotFilled(AdColonyZone adColonyZone) {
        this.mediationBannerListener.onAdFailedToLoad(this.adapter, 3);
    }
}
