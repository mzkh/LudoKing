package com.unity3d.services.monetization.placementcontent.core;

import java.util.Map;

public class RewardablePlacementContent extends PlacementContent {
    private boolean isRewarded;
    private String rewardId;

    public RewardablePlacementContent(String str, Map<String, Object> map) {
        super(str, map);
        String str2 = "rewarded";
        if (map.containsKey(str2)) {
            this.isRewarded = ((Boolean) map.get(str2)).booleanValue();
        }
        String str3 = "rewardId";
        if (map.containsKey(str3)) {
            this.rewardId = (String) map.get(str3);
        }
    }

    public boolean isRewarded() {
        return this.isRewarded;
    }

    public String getRewardId() {
        return this.rewardId;
    }
}
