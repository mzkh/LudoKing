package com.jirbo.adcolony;

import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.adcolony.sdk.AdColonyZone;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

class AdColonyAdListener extends AdColonyInterstitialListener {
    private AdColonyAdapter _adapter;
    private MediationInterstitialListener _mediationInterstitialListener;

    AdColonyAdListener(AdColonyAdapter adColonyAdapter, MediationInterstitialListener mediationInterstitialListener) {
        this._mediationInterstitialListener = mediationInterstitialListener;
        this._adapter = adColonyAdapter;
    }

    public void onRequestFilled(AdColonyInterstitial adColonyInterstitial) {
        AdColonyAdapter adColonyAdapter = this._adapter;
        if (adColonyAdapter != null) {
            adColonyAdapter.setAd(adColonyInterstitial);
            notifyAdLoaded();
        }
    }

    public void onClicked(AdColonyInterstitial adColonyInterstitial) {
        AdColonyAdapter adColonyAdapter = this._adapter;
        if (adColonyAdapter != null) {
            adColonyAdapter.setAd(adColonyInterstitial);
            this._mediationInterstitialListener.onAdClicked(this._adapter);
        }
    }

    public void onClosed(AdColonyInterstitial adColonyInterstitial) {
        AdColonyAdapter adColonyAdapter = this._adapter;
        if (adColonyAdapter != null) {
            adColonyAdapter.setAd(adColonyInterstitial);
            this._mediationInterstitialListener.onAdClosed(this._adapter);
        }
    }

    public void onExpiring(AdColonyInterstitial adColonyInterstitial) {
        AdColonyAdapter adColonyAdapter = this._adapter;
        if (adColonyAdapter != null) {
            adColonyAdapter.setAd(adColonyInterstitial);
            AdColony.requestInterstitial(adColonyInterstitial.getZoneID(), this);
        }
    }

    public void onIAPEvent(AdColonyInterstitial adColonyInterstitial, String str, int i) {
        AdColonyAdapter adColonyAdapter = this._adapter;
        if (adColonyAdapter != null) {
            adColonyAdapter.setAd(adColonyInterstitial);
        }
    }

    public void onLeftApplication(AdColonyInterstitial adColonyInterstitial) {
        AdColonyAdapter adColonyAdapter = this._adapter;
        if (adColonyAdapter != null) {
            adColonyAdapter.setAd(adColonyInterstitial);
            this._mediationInterstitialListener.onAdLeftApplication(this._adapter);
        }
    }

    public void onOpened(AdColonyInterstitial adColonyInterstitial) {
        AdColonyAdapter adColonyAdapter = this._adapter;
        if (adColonyAdapter != null) {
            adColonyAdapter.setAd(adColonyInterstitial);
            this._mediationInterstitialListener.onAdOpened(this._adapter);
        }
    }

    public void onRequestNotFilled(AdColonyZone adColonyZone) {
        AdColonyAdapter adColonyAdapter = this._adapter;
        if (adColonyAdapter != null) {
            adColonyAdapter.setAd(null);
            this._mediationInterstitialListener.onAdFailedToLoad(this._adapter, 3);
        }
    }

    /* access modifiers changed from: 0000 */
    public void destroy() {
        this._adapter = null;
        this._mediationInterstitialListener = null;
    }

    /* access modifiers changed from: 0000 */
    public void notifyAdLoaded() {
        this._mediationInterstitialListener.onAdLoaded(this._adapter);
    }
}
