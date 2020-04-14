package com.google.ads.mediation.facebook.rtb;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.ads.C1431Ad;
import com.facebook.ads.ExtraHints.Builder;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import java.util.concurrent.atomic.AtomicBoolean;

public class FacebookRtbInterstitialAd implements MediationInterstitialAd, InterstitialAdExtendedListener {
    private MediationInterstitialAdConfiguration adConfiguration;
    private MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> callback;
    private AtomicBoolean didInterstitialAdClose = new AtomicBoolean();
    private InterstitialAd interstitialAd;
    private MediationInterstitialAdCallback mInterstitalAdCallback;

    public void onRewardedAdCompleted() {
    }

    public void onRewardedAdServerFailed() {
    }

    public void onRewardedAdServerSucceeded() {
    }

    public FacebookRtbInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        this.adConfiguration = mediationInterstitialAdConfiguration;
        this.callback = mediationAdLoadCallback;
    }

    public void render() {
        String placementID = FacebookMediationAdapter.getPlacementID(this.adConfiguration.getServerParameters());
        if (TextUtils.isEmpty(placementID)) {
            String str = "Failed to request ad, placementID is null or empty.";
            Log.e(FacebookMediationAdapter.TAG, str);
            this.callback.onFailure(str);
            return;
        }
        this.interstitialAd = new InterstitialAd(this.adConfiguration.getContext(), placementID);
        if (!TextUtils.isEmpty(this.adConfiguration.getWatermark())) {
            this.interstitialAd.setExtraHints(new Builder().mediationData(this.adConfiguration.getWatermark()).build());
        }
        InterstitialAd interstitialAd2 = this.interstitialAd;
        interstitialAd2.loadAd(interstitialAd2.buildLoadAdConfig().withBid(this.adConfiguration.getBidResponse()).withAdListener(this).build());
    }

    public void showAd(Context context) {
        if (this.interstitialAd.isAdLoaded()) {
            this.interstitialAd.show();
        }
    }

    public void onInterstitialDisplayed(C1431Ad ad) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.mInterstitalAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdOpened();
        }
    }

    public void onInterstitialDismissed(C1431Ad ad) {
        if (!this.didInterstitialAdClose.getAndSet(true)) {
            MediationInterstitialAdCallback mediationInterstitialAdCallback = this.mInterstitalAdCallback;
            if (mediationInterstitialAdCallback != null) {
                mediationInterstitialAdCallback.onAdClosed();
            }
        }
    }

    public void onError(C1431Ad ad, AdError adError) {
        this.callback.onFailure(adError.getErrorMessage());
    }

    public void onAdLoaded(C1431Ad ad) {
        this.mInterstitalAdCallback = (MediationInterstitialAdCallback) this.callback.onSuccess(this);
    }

    public void onAdClicked(C1431Ad ad) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.mInterstitalAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdLeftApplication();
        }
    }

    public void onLoggingImpression(C1431Ad ad) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.mInterstitalAdCallback;
    }

    public void onInterstitialActivityDestroyed() {
        if (!this.didInterstitialAdClose.getAndSet(true)) {
            MediationInterstitialAdCallback mediationInterstitialAdCallback = this.mInterstitalAdCallback;
            if (mediationInterstitialAdCallback != null) {
                mediationInterstitialAdCallback.onAdClosed();
            }
        }
    }
}
