package com.google.ads.mediation.inmobi;

import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: InMobiRewardedAd */
class InMobiReward implements RewardItem {
    private int amount;
    private String type;

    InMobiReward(String str, int i) {
        this.type = str;
        this.amount = i;
    }

    public String getType() {
        return this.type;
    }

    public int getAmount() {
        return this.amount;
    }
}
