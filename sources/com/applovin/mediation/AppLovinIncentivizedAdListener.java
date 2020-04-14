package com.applovin.mediation;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.google.ads.mediation.applovin.AppLovinMediationAdapter;
import com.google.ads.mediation.applovin.AppLovinRewardItem;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import java.util.Map;

public class AppLovinIncentivizedAdListener implements AppLovinAdRewardListener, AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdVideoPlaybackListener {
    private boolean mFullyWatched;
    private AppLovinRewardItem mRewardItem;
    private MediationRewardedAdCallback mRewardedAdCallback;
    private String mZoneId;

    public AppLovinIncentivizedAdListener(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationRewardedAdCallback mediationRewardedAdCallback) {
        this.mZoneId = AppLovinUtils.retrieveZoneId(mediationRewardedAdConfiguration.getServerParameters());
        this.mRewardedAdCallback = mediationRewardedAdCallback;
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Rewarded video displayed");
        this.mRewardedAdCallback.onAdOpened();
        this.mRewardedAdCallback.reportAdImpression();
    }

    public void adHidden(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Rewarded video dismissed");
        AppLovinMediationAdapter.INCENTIVIZED_ADS.remove(this.mZoneId);
        if (this.mFullyWatched) {
            this.mRewardedAdCallback.onUserEarnedReward(this.mRewardItem);
        }
        this.mRewardedAdCallback.onAdClosed();
    }

    public void adClicked(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Rewarded video clicked");
        this.mRewardedAdCallback.reportAdClicked();
    }

    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Rewarded video playback began");
        this.mRewardedAdCallback.onVideoStart();
    }

    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("Rewarded video playback ended at playback percent: ");
        sb.append(d);
        sb.append("%");
        ApplovinAdapter.log(3, sb.toString());
        this.mFullyWatched = z;
        if (z) {
            this.mRewardedAdCallback.onVideoComplete();
        }
    }

    public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("Rewarded video validation request for ad did exceed quota with response: ");
        sb.append(map);
        ApplovinAdapter.log(6, sb.toString());
    }

    public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("Rewarded video validation request for ad failed with error code: ");
        sb.append(i);
        ApplovinAdapter.log(6, sb.toString());
    }

    public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("Rewarded video validation request was rejected with response: ");
        sb.append(map);
        ApplovinAdapter.log(6, sb.toString());
    }

    public void userDeclinedToViewAd(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "User declined to view rewarded video");
    }

    public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
        String str = (String) map.get("currency");
        int parseDouble = (int) Double.parseDouble((String) map.get("amount"));
        StringBuilder sb = new StringBuilder();
        sb.append("Rewarded ");
        sb.append(parseDouble);
        sb.append(" ");
        sb.append(str);
        ApplovinAdapter.log(3, sb.toString());
        this.mRewardItem = new AppLovinRewardItem(parseDouble, str);
    }
}
