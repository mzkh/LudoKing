package com.google.ads.mediation.unity;

import com.google.android.gms.ads.rewarded.RewardItem;

public class UnityReward implements RewardItem {
    public int getAmount() {
        return 1;
    }

    public String getType() {
        return "";
    }
}
