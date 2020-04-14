package com.applovin.mediation;

import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.ads.mediation.MediationBannerListener;

class AppLovinBannerAdListener implements AppLovinAdLoadListener, AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdViewEventListener {
    private final AppLovinAdView mAdView;
    /* access modifiers changed from: private */
    public final ApplovinAdapter mAdapter;
    /* access modifiers changed from: private */
    public final MediationBannerListener mMediationBannerListener;
    private final String mZoneId;

    AppLovinBannerAdListener(String str, AppLovinAdView appLovinAdView, ApplovinAdapter applovinAdapter, MediationBannerListener mediationBannerListener) {
        this.mAdapter = applovinAdapter;
        this.mMediationBannerListener = mediationBannerListener;
        this.mAdView = appLovinAdView;
        this.mZoneId = str;
    }

    public void adReceived(AppLovinAd appLovinAd) {
        StringBuilder sb = new StringBuilder();
        sb.append("Banner did load ad: ");
        sb.append(appLovinAd.getAdIdNumber());
        sb.append(" for zone: ");
        sb.append(this.mZoneId);
        ApplovinAdapter.log(3, sb.toString());
        this.mAdView.renderAd(appLovinAd);
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                AppLovinBannerAdListener.this.mMediationBannerListener.onAdLoaded(AppLovinBannerAdListener.this.mAdapter);
            }
        });
    }

    public void failedToReceiveAd(final int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to load banner ad with error: ");
        sb.append(i);
        ApplovinAdapter.log(6, sb.toString());
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                AppLovinBannerAdListener.this.mMediationBannerListener.onAdFailedToLoad(AppLovinBannerAdListener.this.mAdapter, AppLovinUtils.toAdMobErrorCode(i));
            }
        });
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Banner displayed");
    }

    public void adHidden(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Banner dismissed");
    }

    public void adClicked(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Banner clicked");
        this.mMediationBannerListener.onAdClicked(this.mAdapter);
    }

    public void adOpenedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        ApplovinAdapter.log(3, "Banner opened fullscreen");
        this.mMediationBannerListener.onAdOpened(this.mAdapter);
    }

    public void adClosedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        ApplovinAdapter.log(3, "Banner closed fullscreen");
        this.mMediationBannerListener.onAdClosed(this.mAdapter);
    }

    public void adLeftApplication(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        ApplovinAdapter.log(3, "Banner left application");
        this.mMediationBannerListener.onAdLeftApplication(this.mAdapter);
    }

    public void adFailedToDisplay(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
        StringBuilder sb = new StringBuilder();
        sb.append("Banner failed to display: ");
        sb.append(appLovinAdViewDisplayErrorCode);
        ApplovinAdapter.log(6, sb.toString());
    }
}
