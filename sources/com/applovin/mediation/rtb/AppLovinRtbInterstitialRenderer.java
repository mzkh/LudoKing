package com.applovin.mediation.rtb;

import android.content.Context;
import android.util.Log;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;

public final class AppLovinRtbInterstitialRenderer implements MediationInterstitialAd, AppLovinAdLoadListener, AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdVideoPlaybackListener {
    private static final String TAG = "AppLovinRtbInterstitialRenderer";

    /* renamed from: ad */
    private AppLovinAd f3270ad;
    private final MediationInterstitialAdConfiguration adConfiguration;
    private final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> callback;
    private AppLovinInterstitialAdDialog interstitialAd;
    private MediationInterstitialAdCallback mInterstitalAdCallback;
    private final AppLovinSdk sdk;

    public AppLovinRtbInterstitialRenderer(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        this.adConfiguration = mediationInterstitialAdConfiguration;
        this.callback = mediationAdLoadCallback;
        this.sdk = AppLovinUtils.retrieveSdk(mediationInterstitialAdConfiguration.getServerParameters(), mediationInterstitialAdConfiguration.getContext());
    }

    public void loadAd() {
        this.interstitialAd = AppLovinInterstitialAd.create(this.sdk, this.adConfiguration.getContext());
        this.interstitialAd.setAdDisplayListener(this);
        this.interstitialAd.setAdClickListener(this);
        this.interstitialAd.setAdVideoPlaybackListener(this);
        this.sdk.getAdService().loadNextAdForAdToken(this.adConfiguration.getBidResponse(), this);
    }

    public void showAd(Context context) {
        this.sdk.getSettings().setMuted(AppLovinUtils.shouldMuteAudio(this.adConfiguration.getMediationExtras()));
        this.interstitialAd.showAndRender(this.f3270ad);
    }

    public void adReceived(AppLovinAd appLovinAd) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Interstitial did load ad: ");
        sb.append(appLovinAd.getAdIdNumber());
        Log.d(str, sb.toString());
        this.f3270ad = appLovinAd;
        this.mInterstitalAdCallback = (MediationInterstitialAdCallback) this.callback.onSuccess(this);
    }

    public void failedToReceiveAd(int i) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to load interstitial ad with error: ");
        sb.append(i);
        Log.e(str, sb.toString());
        this.callback.onFailure(Integer.toString(AppLovinUtils.toAdMobErrorCode(i)));
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        Log.d(TAG, "Interstitial displayed");
        this.mInterstitalAdCallback.reportAdImpression();
        this.mInterstitalAdCallback.onAdOpened();
    }

    public void adHidden(AppLovinAd appLovinAd) {
        Log.d(TAG, "Interstitial hidden");
        this.mInterstitalAdCallback.onAdClosed();
    }

    public void adClicked(AppLovinAd appLovinAd) {
        Log.d(TAG, "Interstitial clicked");
        this.mInterstitalAdCallback.reportAdClicked();
        this.mInterstitalAdCallback.onAdLeftApplication();
    }

    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        Log.d(TAG, "Interstitial video playback began");
    }

    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Interstitial video playback ended at playback percent: ");
        sb.append(d);
        sb.append("%");
        Log.d(str, sb.toString());
    }
}
