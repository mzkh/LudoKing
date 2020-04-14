package com.adcolony.sdk;

import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import org.json.JSONObject;

public class AdColonyReward {

    /* renamed from: a */
    private int f122a;

    /* renamed from: b */
    private String f123b;

    /* renamed from: c */
    private String f124c;

    /* renamed from: d */
    private boolean f125d;

    AdColonyReward(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        this.f122a = C0746u.m914c(c, "reward_amount");
        this.f123b = C0746u.m908b(c, "reward_name");
        this.f125d = C0746u.m918d(c, "success");
        this.f124c = C0746u.m908b(c, AdColonyAdapterUtils.KEY_ZONE_ID);
    }

    public int getRewardAmount() {
        return this.f122a;
    }

    public String getRewardName() {
        return this.f123b;
    }

    public String getZoneID() {
        return this.f124c;
    }

    public boolean success() {
        return this.f125d;
    }
}
