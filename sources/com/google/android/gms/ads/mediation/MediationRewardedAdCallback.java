package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public interface MediationRewardedAdCallback extends MediationAdCallback {
    void onAdFailedToShow(String str);

    void onUserEarnedReward(RewardItem rewardItem);

    void onVideoComplete();

    void onVideoStart();
}
