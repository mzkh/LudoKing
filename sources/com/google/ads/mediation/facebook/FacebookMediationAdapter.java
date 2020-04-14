package com.google.ads.mediation.facebook;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.ads.BidderTokenProvider;
import com.facebook.ads.BuildConfig;
import com.google.ads.mediation.facebook.rtb.FacebookRtbBannerAd;
import com.google.ads.mediation.facebook.rtb.FacebookRtbInterstitialAd;
import com.google.ads.mediation.facebook.rtb.FacebookRtbNativeAd;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;
import java.util.ArrayList;
import java.util.List;

public class FacebookMediationAdapter extends RtbAdapter {
    public static final String PLACEMENT_PARAMETER = "pubid";
    public static final String RTB_PLACEMENT_PARAMETER = "placement_id";
    public static final String TAG = FacebookAdapter.class.getSimpleName();
    private FacebookRtbBannerAd banner;
    private FacebookRtbInterstitialAd interstitial;
    private FacebookRtbNativeAd nativeAd;
    private FacebookRewardedAd rewardedAd;

    public VersionInfo getVersionInfo() {
        String[] split = BuildConfig.VERSION_NAME.split("\\.");
        return new VersionInfo(Integer.parseInt(split[0]), Integer.parseInt(split[1]), (Integer.parseInt(split[2]) * 100) + Integer.parseInt(split[3]));
    }

    public VersionInfo getSDKVersionInfo() {
        String[] split = BuildConfig.VERSION_NAME.split("\\.");
        return new VersionInfo(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
    }

    public void initialize(Context context, final InitializationCompleteCallback initializationCompleteCallback, List<MediationConfiguration> list) {
        if (context == null) {
            initializationCompleteCallback.onInitializationFailed("Initialization Failed: Context is null.");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (MediationConfiguration serverParameters : list) {
            String placementID = getPlacementID(serverParameters.getServerParameters());
            if (!TextUtils.isEmpty(placementID)) {
                arrayList.add(placementID);
            }
        }
        if (arrayList.isEmpty()) {
            initializationCompleteCallback.onInitializationFailed("Initialization failed: No placement IDs found");
        } else {
            FacebookInitializer.getInstance().initialize(context, arrayList, (Listener) new Listener() {
                public void onInitializeSuccess() {
                    initializationCompleteCallback.onInitializationSucceeded();
                }

                public void onInitializeError(String str) {
                    InitializationCompleteCallback initializationCompleteCallback = initializationCompleteCallback;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Initialization failed: ");
                    sb.append(str);
                    initializationCompleteCallback.onInitializationFailed(sb.toString());
                }
            });
        }
    }

    public void collectSignals(RtbSignalData rtbSignalData, SignalCallbacks signalCallbacks) {
        signalCallbacks.onSuccess(BidderTokenProvider.getBidderToken(rtbSignalData.getContext()));
    }

    public void loadRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.rewardedAd = new FacebookRewardedAd(mediationRewardedAdConfiguration, mediationAdLoadCallback);
        this.rewardedAd.render();
    }

    public void loadBannerAd(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        this.banner = new FacebookRtbBannerAd(mediationBannerAdConfiguration, mediationAdLoadCallback);
        this.banner.render();
    }

    public void loadInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        this.interstitial = new FacebookRtbInterstitialAd(mediationInterstitialAdConfiguration, mediationAdLoadCallback);
        this.interstitial.render();
    }

    public void loadNativeAd(MediationNativeAdConfiguration mediationNativeAdConfiguration, MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback) {
        this.nativeAd = new FacebookRtbNativeAd(mediationNativeAdConfiguration, mediationAdLoadCallback);
        this.nativeAd.render();
    }

    @Nullable
    public static String getPlacementID(@NonNull Bundle bundle) {
        String string = bundle.getString(RTB_PLACEMENT_PARAMETER);
        return string == null ? bundle.getString("pubid") : string;
    }
}
