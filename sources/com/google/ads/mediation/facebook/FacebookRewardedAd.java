package com.google.ads.mediation.facebook;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.ads.C1431Ad;
import com.facebook.ads.ExtraHints.Builder;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdExtendedListener;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import java.util.concurrent.atomic.AtomicBoolean;

public class FacebookRewardedAd implements MediationRewardedAd, RewardedVideoAdExtendedListener {
    private MediationRewardedAdConfiguration adConfiguration;
    private AtomicBoolean didRewardedAdClose = new AtomicBoolean();
    private boolean isRtbAd = false;
    /* access modifiers changed from: private */
    public MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mMediationAdLoadCallback;
    private MediationRewardedAdCallback mRewardedAdCallback;
    private RewardedVideoAd rewardedAd;

    public FacebookRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.adConfiguration = mediationRewardedAdConfiguration;
        this.mMediationAdLoadCallback = mediationAdLoadCallback;
    }

    public void render() {
        final Context context = this.adConfiguration.getContext();
        final String placementID = FacebookMediationAdapter.getPlacementID(this.adConfiguration.getServerParameters());
        if (TextUtils.isEmpty(placementID)) {
            String str = "Failed to request ad, placementID is null or empty.";
            Log.e(FacebookMediationAdapter.TAG, str);
            this.mMediationAdLoadCallback.onFailure(str);
            return;
        }
        String bidResponse = this.adConfiguration.getBidResponse();
        if (!TextUtils.isEmpty(bidResponse)) {
            this.isRtbAd = true;
        }
        if (this.isRtbAd) {
            this.rewardedAd = new RewardedVideoAd(context, placementID);
            if (!TextUtils.isEmpty(this.adConfiguration.getWatermark())) {
                this.rewardedAd.setExtraHints(new Builder().mediationData(this.adConfiguration.getWatermark()).build());
            }
            RewardedVideoAd rewardedVideoAd = this.rewardedAd;
            rewardedVideoAd.loadAd(rewardedVideoAd.buildLoadAdConfig().withAdListener(this).withBid(bidResponse).build());
        } else {
            FacebookInitializer.getInstance().initialize(context, placementID, (Listener) new Listener() {
                public void onInitializeSuccess() {
                    FacebookRewardedAd.this.createAndLoadRewardedVideo(context, placementID);
                }

                public void onInitializeError(String str) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to load ad from Facebook: ");
                    sb.append(str);
                    String sb2 = sb.toString();
                    Log.w(FacebookMediationAdapter.TAG, sb2);
                    if (FacebookRewardedAd.this.mMediationAdLoadCallback != null) {
                        FacebookRewardedAd.this.mMediationAdLoadCallback.onFailure(sb2);
                    }
                }
            });
        }
    }

    public void showAd(Context context) {
        if (this.rewardedAd.isAdLoaded()) {
            this.rewardedAd.show();
            MediationRewardedAdCallback mediationRewardedAdCallback = this.mRewardedAdCallback;
            if (mediationRewardedAdCallback != null) {
                mediationRewardedAdCallback.onVideoStart();
                this.mRewardedAdCallback.onAdOpened();
                return;
            }
            return;
        }
        MediationRewardedAdCallback mediationRewardedAdCallback2 = this.mRewardedAdCallback;
        if (mediationRewardedAdCallback2 != null) {
            mediationRewardedAdCallback2.onAdFailedToShow("No ads to show");
        }
    }

    /* access modifiers changed from: private */
    public void createAndLoadRewardedVideo(Context context, String str) {
        this.rewardedAd = new RewardedVideoAd(context, str);
        RewardedVideoAd rewardedVideoAd = this.rewardedAd;
        rewardedVideoAd.loadAd(rewardedVideoAd.buildLoadAdConfig().withAdListener(this).build());
    }

    public void onRewardedVideoCompleted() {
        this.mRewardedAdCallback.onVideoComplete();
        this.mRewardedAdCallback.onUserEarnedReward(new FacebookReward());
    }

    public void onError(C1431Ad ad, AdError adError) {
        String errorMessage = adError.getErrorMessage();
        if (!TextUtils.isEmpty(errorMessage)) {
            String str = FacebookMediationAdapter.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to load ad from Facebook: ");
            sb.append(errorMessage);
            Log.w(str, sb.toString());
        }
        MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback = this.mMediationAdLoadCallback;
        if (mediationAdLoadCallback != null) {
            mediationAdLoadCallback.onFailure(errorMessage);
        }
        this.rewardedAd.destroy();
    }

    public void onAdLoaded(C1431Ad ad) {
        MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback = this.mMediationAdLoadCallback;
        if (mediationAdLoadCallback != null) {
            this.mRewardedAdCallback = (MediationRewardedAdCallback) mediationAdLoadCallback.onSuccess(this);
        }
    }

    public void onAdClicked(C1431Ad ad) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mRewardedAdCallback;
        if (mediationRewardedAdCallback != null && !this.isRtbAd) {
            mediationRewardedAdCallback.reportAdClicked();
        }
    }

    public void onLoggingImpression(C1431Ad ad) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mRewardedAdCallback;
        if (mediationRewardedAdCallback != null && !this.isRtbAd) {
            mediationRewardedAdCallback.reportAdImpression();
        }
    }

    public void onRewardedVideoClosed() {
        if (!this.didRewardedAdClose.getAndSet(true)) {
            MediationRewardedAdCallback mediationRewardedAdCallback = this.mRewardedAdCallback;
            if (mediationRewardedAdCallback != null) {
                mediationRewardedAdCallback.onAdClosed();
            }
        }
        RewardedVideoAd rewardedVideoAd = this.rewardedAd;
        if (rewardedVideoAd != null) {
            rewardedVideoAd.destroy();
        }
    }

    public void onRewardedVideoActivityDestroyed() {
        if (!this.didRewardedAdClose.getAndSet(true)) {
            MediationRewardedAdCallback mediationRewardedAdCallback = this.mRewardedAdCallback;
            if (mediationRewardedAdCallback != null) {
                mediationRewardedAdCallback.onAdClosed();
            }
        }
        RewardedVideoAd rewardedVideoAd = this.rewardedAd;
        if (rewardedVideoAd != null) {
            rewardedVideoAd.destroy();
        }
    }
}
