package com.google.ads.mediation.applovin;

import com.google.android.gms.ads.rewarded.RewardItem;

public final class AppLovinRewardItem implements RewardItem {
    private final int mAmount;
    private final String mType;

    public AppLovinRewardItem(int i, String str) {
        this.mAmount = i;
        this.mType = str;
    }

    public String getType() {
        return this.mType;
    }

    public int getAmount() {
        return this.mAmount;
    }
}
