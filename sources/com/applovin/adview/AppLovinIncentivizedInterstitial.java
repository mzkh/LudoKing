package com.applovin.adview;

import android.content.Context;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p017a.C1062a;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;

public class AppLovinIncentivizedInterstitial {

    /* renamed from: a */
    private final C1062a f1209a;

    public AppLovinIncentivizedInterstitial(Context context) {
        this(AppLovinSdk.getInstance(context));
    }

    public AppLovinIncentivizedInterstitial(AppLovinSdk appLovinSdk) {
        this(null, appLovinSdk);
    }

    public AppLovinIncentivizedInterstitial(String str, AppLovinSdk appLovinSdk) {
        if (appLovinSdk != null) {
            this.f1209a = createIncentivizedAdController(str, appLovinSdk);
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    public static AppLovinIncentivizedInterstitial create(Context context) {
        return create(AppLovinSdk.getInstance(context));
    }

    public static AppLovinIncentivizedInterstitial create(AppLovinSdk appLovinSdk) {
        return create(null, appLovinSdk);
    }

    public static AppLovinIncentivizedInterstitial create(String str, AppLovinSdk appLovinSdk) {
        return new AppLovinIncentivizedInterstitial(str, appLovinSdk);
    }

    /* access modifiers changed from: protected */
    public C1062a createIncentivizedAdController(String str, AppLovinSdk appLovinSdk) {
        return new C1062a(str, appLovinSdk);
    }

    public void dismiss() {
        this.f1209a.mo9749c();
    }

    public String getUserIdentifier() {
        C1227o.m2841i("AppLovinIncentivizedInterstitial", "Please use AppLovinSdk.getUserIdentifier() instead to properly identify your users in our system. This property is now deprecated and will be removed in a future SDK version.");
        return ((AppLovinSdk) AppLovinSdk.m3157a().get(0)).getUserIdentifier();
    }

    public String getZoneId() {
        return this.f1209a.mo9748b();
    }

    public boolean isAdReadyToDisplay() {
        return this.f1209a.mo9747a();
    }

    public void preload(AppLovinAdLoadListener appLovinAdLoadListener) {
        if (appLovinAdLoadListener == null) {
            C1227o.m2839g("AppLovinIncentivizedInterstitial", "AppLovinAdLoadListener was null when preloading incentivized interstitials; using a listener is highly recommended.");
        }
        this.f1209a.mo9746a(appLovinAdLoadListener);
    }

    public void setUserIdentifier(String str) {
        for (AppLovinSdk userIdentifier : AppLovinSdk.m3157a()) {
            userIdentifier.setUserIdentifier(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Please use AppLovinSdk.setUserIdentifier(\"");
        sb.append(str);
        sb.append("\") instead to properly identify your users in our system. This property is now deprecated and will be removed in a future SDK version.");
        C1227o.m2841i("AppLovinIncentivizedInterstitial", sb.toString());
    }

    public void show(Context context) {
        show(context, null, null);
    }

    public void show(Context context, AppLovinAdRewardListener appLovinAdRewardListener) {
        show(context, appLovinAdRewardListener, null);
    }

    public void show(Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        show(context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, null);
    }

    public void show(Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener) {
        show(context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, null);
    }

    public void show(Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        show(context, (String) null, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    @Deprecated
    public void show(Context context, String str, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        this.f1209a.mo9745a(null, context, "", appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    public void show(AppLovinAd appLovinAd, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        this.f1209a.mo9745a(appLovinAd, context, null, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppLovinIncentivizedInterstitial{zoneId='");
        sb.append(getZoneId());
        sb.append("', isAdReadyToDisplay=");
        sb.append(isAdReadyToDisplay());
        sb.append('}');
        return sb.toString();
    }
}
