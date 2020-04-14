package com.applovin.impl.mediation.p016d;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.utils.C1248i;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;

/* renamed from: com.applovin.impl.mediation.d.a */
public class C0988a implements MaxAdListener, MaxAdViewAdListener, MaxRewardedAdListener {

    /* renamed from: a */
    private final C1192i f1906a;

    /* renamed from: b */
    private final MaxAdListener f1907b;

    public C0988a(MaxAdListener maxAdListener, C1192i iVar) {
        this.f1906a = iVar;
        this.f1907b = maxAdListener;
    }

    public void onAdClicked(MaxAd maxAd) {
        C1248i.m3015d(this.f1907b, maxAd);
    }

    public void onAdCollapsed(MaxAd maxAd) {
        C1248i.m3019h(this.f1907b, maxAd);
    }

    public void onAdDisplayFailed(MaxAd maxAd, int i) {
        C1248i.m2995a(this.f1907b, maxAd, i);
    }

    public void onAdDisplayed(MaxAd maxAd) {
        C1248i.m3009b(this.f1907b, maxAd);
    }

    public void onAdExpanded(MaxAd maxAd) {
        C1248i.m3018g(this.f1907b, maxAd);
    }

    public void onAdHidden(MaxAd maxAd) {
        C1248i.m3013c(this.f1907b, maxAd);
    }

    public void onAdLoadFailed(String str, int i) {
        C1248i.m2997a(this.f1907b, str, i);
    }

    public void onAdLoaded(MaxAd maxAd) {
        C1248i.m2994a(this.f1907b, maxAd);
    }

    public void onRewardedVideoCompleted(MaxAd maxAd) {
        C1248i.m3017f(this.f1907b, maxAd);
    }

    public void onRewardedVideoStarted(MaxAd maxAd) {
        C1248i.m3016e(this.f1907b, maxAd);
    }

    public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
        C1248i.m2996a(this.f1907b, maxAd, maxReward);
    }
}
