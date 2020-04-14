package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAdCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzarn extends zzare {
    private final RewardedAdCallback zzdod;

    public zzarn(RewardedAdCallback rewardedAdCallback) {
        this.zzdod = rewardedAdCallback;
    }

    public final void onRewardedAdOpened() {
        RewardedAdCallback rewardedAdCallback = this.zzdod;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdOpened();
        }
    }

    public final void onRewardedAdClosed() {
        RewardedAdCallback rewardedAdCallback = this.zzdod;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdClosed();
        }
    }

    public final void zza(zzaqv zzaqv) {
        RewardedAdCallback rewardedAdCallback = this.zzdod;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onUserEarnedReward(new zzaro(zzaqv));
        }
    }

    public final void onRewardedAdFailedToShow(int i) {
        RewardedAdCallback rewardedAdCallback = this.zzdod;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdFailedToShow(i);
        }
    }
}
