package com.google.ads.mediation.adcolony;

import android.content.Context;
import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.adcolony.sdk.AdColonyZone;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;

public class AdColonyInterstitialRenderer extends AdColonyInterstitialListener implements MediationInterstitialAd {
    private AdColonyInterstitial adColonyInterstitial;
    private MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mAdLoadCallback;
    private MediationInterstitialAdCallback mInterstitialAdCallback;
    private String zoneID;

    AdColonyInterstitialRenderer(String str) {
        this.zoneID = str;
    }

    public void requestInterstitial(MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        this.mAdLoadCallback = mediationAdLoadCallback;
        AdColony.requestInterstitial(this.zoneID, this);
    }

    public void showAd(Context context) {
        this.adColonyInterstitial.show();
    }

    public void onRequestFilled(AdColonyInterstitial adColonyInterstitial2) {
        this.adColonyInterstitial = adColonyInterstitial2;
        this.mInterstitialAdCallback = (MediationInterstitialAdCallback) this.mAdLoadCallback.onSuccess(this);
    }

    public void onRequestNotFilled(AdColonyZone adColonyZone) {
        this.mAdLoadCallback.onFailure("Failed to load ad.");
    }

    public void onLeftApplication(AdColonyInterstitial adColonyInterstitial2) {
        super.onLeftApplication(adColonyInterstitial2);
        this.mInterstitialAdCallback.reportAdClicked();
        this.mInterstitialAdCallback.onAdLeftApplication();
    }

    public void onOpened(AdColonyInterstitial adColonyInterstitial2) {
        super.onOpened(adColonyInterstitial2);
        this.mInterstitialAdCallback.onAdOpened();
        this.mInterstitialAdCallback.reportAdImpression();
    }

    public void onClosed(AdColonyInterstitial adColonyInterstitial2) {
        super.onClosed(adColonyInterstitial2);
        this.mInterstitialAdCallback.onAdClosed();
    }

    public void onExpiring(AdColonyInterstitial adColonyInterstitial2) {
        super.onExpiring(adColonyInterstitial2);
        AdColony.requestInterstitial(adColonyInterstitial2.getZoneID(), this);
    }
}
