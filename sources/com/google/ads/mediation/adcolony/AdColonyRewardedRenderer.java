package com.google.ads.mediation.adcolony;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAdOptions;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyReward;
import com.adcolony.sdk.AdColonyZone;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.jirbo.adcolony.AdColonyManager;

public class AdColonyRewardedRenderer implements MediationRewardedAd {
    private MediationRewardedAdConfiguration adConfiguration;
    private boolean isRtb = false;
    private AdColonyInterstitial mAdColonyInterstitial;
    private MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mAdLoadCallback;
    private MediationRewardedAdCallback mRewardedAdCallback;

    /* access modifiers changed from: 0000 */
    public void onIAPEvent(AdColonyInterstitial adColonyInterstitial, String str, int i) {
    }

    /* access modifiers changed from: 0000 */
    public void onLeftApplication(AdColonyInterstitial adColonyInterstitial) {
    }

    public AdColonyRewardedRenderer(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.adConfiguration = mediationRewardedAdConfiguration;
        this.mAdLoadCallback = mediationAdLoadCallback;
    }

    public void render() {
        boolean z;
        boolean z2;
        if (!this.adConfiguration.getBidResponse().equals("")) {
            this.isRtb = true;
        }
        Bundle serverParameters = this.adConfiguration.getServerParameters();
        Bundle mediationExtras = this.adConfiguration.getMediationExtras();
        if (mediationExtras != null) {
            z2 = mediationExtras.getBoolean("show_pre_popup", false);
            z = mediationExtras.getBoolean("show_post_popup", false);
        } else {
            z2 = false;
            z = false;
        }
        AdColonyAdOptions enableResultsDialog = new AdColonyAdOptions().enableConfirmationDialog(z2).enableResultsDialog(z);
        String zoneFromRequest = AdColonyManager.getInstance().getZoneFromRequest(AdColonyManager.getInstance().parseZoneList(serverParameters), mediationExtras);
        if (this.isRtb) {
            AdColonyRewardedEventForwarder.getInstance().addListener(zoneFromRequest, this);
            AdColony.requestInterstitial(zoneFromRequest, AdColonyRewardedEventForwarder.getInstance(), enableResultsDialog);
        } else if (AdColonyRewardedEventForwarder.getInstance().isListenerAvailable(zoneFromRequest)) {
            String str = "Failed to load ad from AdColony: Only a maximum of one ad can be loaded per Zone ID.";
            Log.e(AdColonyMediationAdapter.TAG, str);
            this.mAdLoadCallback.onFailure(str);
        } else {
            boolean configureAdColony = AdColonyManager.getInstance().configureAdColony(this.adConfiguration);
            if (!configureAdColony || TextUtils.isEmpty(zoneFromRequest)) {
                configureAdColony = false;
            } else {
                AdColonyRewardedEventForwarder.getInstance().addListener(zoneFromRequest, this);
                AdColony.requestInterstitial(zoneFromRequest, AdColonyRewardedEventForwarder.getInstance(), enableResultsDialog);
            }
            if (!configureAdColony) {
                String str2 = "Failed to request ad from AdColony: Internal Error";
                Log.w(AdColonyMediationAdapter.TAG, str2);
                this.mAdLoadCallback.onFailure(str2);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void onRequestFilled(AdColonyInterstitial adColonyInterstitial) {
        this.mAdColonyInterstitial = adColonyInterstitial;
        MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback = this.mAdLoadCallback;
        if (mediationAdLoadCallback != null) {
            this.mRewardedAdCallback = (MediationRewardedAdCallback) mediationAdLoadCallback.onSuccess(this);
        }
    }

    /* access modifiers changed from: 0000 */
    public void onRequestNotFilled(AdColonyZone adColonyZone) {
        MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback = this.mAdLoadCallback;
        if (mediationAdLoadCallback != null) {
            mediationAdLoadCallback.onFailure("Failed to load ad from AdColony.");
        }
    }

    /* access modifiers changed from: 0000 */
    public void onExpiring(AdColonyInterstitial adColonyInterstitial) {
        this.mAdColonyInterstitial = null;
        AdColony.requestInterstitial(adColonyInterstitial.getZoneID(), AdColonyRewardedEventForwarder.getInstance());
    }

    /* access modifiers changed from: 0000 */
    public void onClicked(AdColonyInterstitial adColonyInterstitial) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.reportAdClicked();
        }
    }

    /* access modifiers changed from: 0000 */
    public void onOpened(AdColonyInterstitial adColonyInterstitial) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onAdOpened();
            this.mRewardedAdCallback.onVideoStart();
            this.mRewardedAdCallback.reportAdImpression();
        }
    }

    /* access modifiers changed from: 0000 */
    public void onClosed(AdColonyInterstitial adColonyInterstitial) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onAdClosed();
        }
    }

    /* access modifiers changed from: 0000 */
    public void onReward(AdColonyReward adColonyReward) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onVideoComplete();
            if (adColonyReward.success()) {
                this.mRewardedAdCallback.onUserEarnedReward(new AdColonyReward(adColonyReward.getRewardName(), adColonyReward.getRewardAmount()));
            }
        }
    }

    public void showAd(Context context) {
        AdColonyInterstitial adColonyInterstitial = this.mAdColonyInterstitial;
        if (adColonyInterstitial != null) {
            adColonyInterstitial.show();
        } else {
            this.mRewardedAdCallback.onAdFailedToShow("No ad to show.");
        }
    }
}
