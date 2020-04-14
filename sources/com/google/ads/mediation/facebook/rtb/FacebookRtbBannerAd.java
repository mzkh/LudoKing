package com.google.ads.mediation.facebook.rtb;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdView;
import com.facebook.ads.C1431Ad;
import com.facebook.ads.ExtraHints.Builder;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;

public class FacebookRtbBannerAd implements MediationBannerAd, AdListener {
    private MediationBannerAdConfiguration adConfiguration;
    private AdView adView;
    private MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> callback;
    private MediationBannerAdCallback mBannerAdCallback;

    public FacebookRtbBannerAd(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        this.adConfiguration = mediationBannerAdConfiguration;
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
        try {
            this.adView = new AdView(this.adConfiguration.getContext(), placementID, this.adConfiguration.getBidResponse());
            if (!TextUtils.isEmpty(this.adConfiguration.getWatermark())) {
                this.adView.setExtraHints(new Builder().mediationData(this.adConfiguration.getWatermark()).build());
            }
            this.adView.loadAd(this.adView.buildLoadAdConfig().withAdListener(this).withBid(this.adConfiguration.getBidResponse()).build());
        } catch (Exception e) {
            MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback = this.callback;
            StringBuilder sb = new StringBuilder();
            sb.append("FacebookRtbBannerAd Failed to load: ");
            sb.append(e.getMessage());
            mediationAdLoadCallback.onFailure(sb.toString());
        }
    }

    @NonNull
    public View getView() {
        return this.adView;
    }

    public void onError(C1431Ad ad, AdError adError) {
        this.callback.onFailure(adError.getErrorMessage());
    }

    public void onAdLoaded(C1431Ad ad) {
        this.mBannerAdCallback = (MediationBannerAdCallback) this.callback.onSuccess(this);
    }

    public void onAdClicked(C1431Ad ad) {
        MediationBannerAdCallback mediationBannerAdCallback = this.mBannerAdCallback;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.onAdOpened();
            this.mBannerAdCallback.onAdLeftApplication();
        }
    }

    public void onLoggingImpression(C1431Ad ad) {
        MediationBannerAdCallback mediationBannerAdCallback = this.mBannerAdCallback;
    }
}
