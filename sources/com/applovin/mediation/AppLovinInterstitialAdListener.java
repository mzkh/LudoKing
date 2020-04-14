package com.applovin.mediation;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

class AppLovinInterstitialAdListener implements AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdVideoPlaybackListener {
    private final ApplovinAdapter mAdapter;
    private final MediationInterstitialListener mMediationInterstitialListener;

    AppLovinInterstitialAdListener(ApplovinAdapter applovinAdapter, MediationInterstitialListener mediationInterstitialListener) {
        this.mAdapter = applovinAdapter;
        this.mMediationInterstitialListener = mediationInterstitialListener;
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Interstitial displayed");
        this.mMediationInterstitialListener.onAdOpened(this.mAdapter);
    }

    public void adHidden(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Interstitial dismissed");
        this.mMediationInterstitialListener.onAdClosed(this.mAdapter);
    }

    public void adClicked(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Interstitial clicked");
        this.mMediationInterstitialListener.onAdClicked(this.mAdapter);
        this.mMediationInterstitialListener.onAdLeftApplication(this.mAdapter);
    }

    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Interstitial video playback began");
    }

    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("Interstitial video playback ended at playback percent: ");
        sb.append(d);
        sb.append("%");
        ApplovinAdapter.log(3, sb.toString());
    }
}
