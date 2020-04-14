package com.jirbo.adcolony;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAdSize;
import com.adcolony.sdk.AdColonyAdView;
import com.adcolony.sdk.AdColonyInterstitial;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import com.google.ads.mediation.adcolony.AdColonyMediationAdapter;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

public class AdColonyAdapter extends AdColonyMediationAdapter implements MediationInterstitialAdapter, MediationBannerAdapter {
    private AdColonyAdView adColonyAdView;
    private AdColonyBannerAdListener adColonyBannerAdListener;
    private AdColonyInterstitial adColonyInterstitial;
    private AdColonyAdListener adColonyInterstitialListener;

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
        AdColonyInterstitial adColonyInterstitial2 = this.adColonyInterstitial;
        if (adColonyInterstitial2 != null) {
            adColonyInterstitial2.cancel();
            this.adColonyInterstitial.destroy();
        }
        AdColonyAdListener adColonyAdListener = this.adColonyInterstitialListener;
        if (adColonyAdListener != null) {
            adColonyAdListener.destroy();
        }
        AdColonyAdView adColonyAdView2 = this.adColonyAdView;
        if (adColonyAdView2 != null) {
            adColonyAdView2.destroy();
        }
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        String zoneFromRequest = AdColonyManager.getInstance().getZoneFromRequest(AdColonyManager.getInstance().parseZoneList(bundle), bundle2);
        if (TextUtils.isEmpty(zoneFromRequest)) {
            Log.e(TAG, "Failed to request ad: zone ID is null or empty");
            mediationInterstitialListener.onAdFailedToLoad(this, 1);
            return;
        }
        this.adColonyInterstitialListener = new AdColonyAdListener(this, mediationInterstitialListener);
        if (!AdColonyManager.getInstance().configureAdColony(context, bundle, mediationAdRequest, bundle2)) {
            Log.w(TAG, "Failed to configure AdColony SDK");
            mediationInterstitialListener.onAdFailedToLoad(this, 1);
            return;
        }
        AdColony.requestInterstitial(zoneFromRequest, this.adColonyInterstitialListener);
    }

    public void showInterstitial() {
        showAdColonyInterstitial();
    }

    private void showAdColonyInterstitial() {
        AdColonyInterstitial adColonyInterstitial2 = this.adColonyInterstitial;
        if (adColonyInterstitial2 != null) {
            adColonyInterstitial2.show();
        }
    }

    /* access modifiers changed from: 0000 */
    public void setAd(AdColonyInterstitial adColonyInterstitial2) {
        this.adColonyInterstitial = adColonyInterstitial2;
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        if (adSize == null) {
            Log.e(TAG, "Fail to request banner ad: adSize is null");
            mediationBannerListener.onAdFailedToLoad(this, 1);
            return;
        }
        AdColonyAdSize adColonyAdSizeFromAdMobAdSize = AdColonyAdapterUtils.adColonyAdSizeFromAdMobAdSize(context, adSize);
        if (adColonyAdSizeFromAdMobAdSize == null) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to request banner with unsupported size: ");
            sb.append(adSize.toString());
            Log.e(str, sb.toString());
            mediationBannerListener.onAdFailedToLoad(this, 1);
            return;
        }
        String zoneFromRequest = AdColonyManager.getInstance().getZoneFromRequest(AdColonyManager.getInstance().parseZoneList(bundle), bundle2);
        if (TextUtils.isEmpty(zoneFromRequest)) {
            Log.e(TAG, "Failed to request ad: zone ID is null or empty");
            mediationBannerListener.onAdFailedToLoad(this, 1);
            return;
        }
        this.adColonyBannerAdListener = new AdColonyBannerAdListener(this, mediationBannerListener);
        if (!AdColonyManager.getInstance().configureAdColony(context, bundle, mediationAdRequest, bundle2)) {
            Log.w(TAG, "Failed to configure AdColony SDK");
            mediationBannerListener.onAdFailedToLoad(this, 1);
            return;
        }
        AdColony.requestAdView(zoneFromRequest, this.adColonyBannerAdListener, adColonyAdSizeFromAdMobAdSize);
    }

    public View getBannerView() {
        return this.adColonyAdView;
    }

    /* access modifiers changed from: 0000 */
    public void setAdView(AdColonyAdView adColonyAdView2) {
        this.adColonyAdView = adColonyAdView2;
    }
}
