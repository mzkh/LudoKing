package com.google.ads.mediation;

import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzb implements RewardedVideoAdListener {
    private final /* synthetic */ AbstractAdViewAdapter zzmu;

    zzb(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.zzmu = abstractAdViewAdapter;
    }

    public final void onRewardedVideoAdLoaded() {
        this.zzmu.zzms.onAdLoaded(this.zzmu);
    }

    public final void onRewardedVideoAdOpened() {
        this.zzmu.zzms.onAdOpened(this.zzmu);
    }

    public final void onRewardedVideoStarted() {
        this.zzmu.zzms.onVideoStarted(this.zzmu);
    }

    public final void onRewardedVideoAdClosed() {
        this.zzmu.zzms.onAdClosed(this.zzmu);
        this.zzmu.zzmr = null;
    }

    public final void onRewarded(RewardItem rewardItem) {
        this.zzmu.zzms.onRewarded(this.zzmu, rewardItem);
    }

    public final void onRewardedVideoAdLeftApplication() {
        this.zzmu.zzms.onAdLeftApplication(this.zzmu);
    }

    public final void onRewardedVideoAdFailedToLoad(int i) {
        this.zzmu.zzms.onAdFailedToLoad(this.zzmu, i);
    }

    public final void onRewardedVideoCompleted() {
        this.zzmu.zzms.onVideoCompleted(this.zzmu);
    }
}
