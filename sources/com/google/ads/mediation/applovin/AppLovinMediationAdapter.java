package com.google.ads.mediation.applovin;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.mediation.AppLovinIncentivizedAdListener;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.mediation.ApplovinAdapter;
import com.applovin.mediation.BuildConfig;
import com.applovin.mediation.rtb.AppLovinRtbBannerRenderer;
import com.applovin.mediation.rtb.AppLovinRtbInterstitialRenderer;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

public class AppLovinMediationAdapter extends RtbAdapter implements MediationRewardedAd, AppLovinAdLoadListener {
    private static final String DEFAULT_ZONE = "";
    public static final HashMap<String, AppLovinIncentivizedInterstitial> INCENTIVIZED_ADS = new HashMap<>();
    private static final Object INCENTIVIZED_ADS_LOCK = new Object();
    private static final String TAG = "AppLovinMediationAdapter";
    private static WeakReference<Context> applicationContextRef = null;
    private static boolean isRtbAd = true;

    /* renamed from: ad */
    private AppLovinAd f3675ad;
    private MediationRewardedAdConfiguration adConfiguration;
    private AppLovinIncentivizedInterstitial mIncentivizedInterstitial;
    /* access modifiers changed from: private */
    public MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mMediationAdLoadCallback;
    private Bundle mNetworkExtras;
    private String mPlacement;
    /* access modifiers changed from: private */
    public MediationRewardedAdCallback mRewardedAdCallback;
    private AppLovinSdk mSdk;
    private String mZoneId;

    public void initialize(Context context, InitializationCompleteCallback initializationCompleteCallback, List<MediationConfiguration> list) {
        ApplovinAdapter.log(3, "Attempting to initialize SDK");
        Context applicationContext = context.getApplicationContext();
        applicationContextRef = new WeakReference<>(applicationContext);
        if (AppLovinUtils.androidManifestHasValidSdkKey(applicationContext)) {
            AppLovinSdk.getInstance(applicationContext).initializeSdk();
        }
        for (MediationConfiguration serverParameters : list) {
            AppLovinUtils.retrieveSdk(serverParameters.getServerParameters(), (Context) applicationContextRef.get()).initializeSdk();
        }
        initializationCompleteCallback.onInitializationSucceeded();
    }

    public VersionInfo getVersionInfo() {
        String[] split = BuildConfig.VERSION_NAME.split("\\.");
        return new VersionInfo(Integer.parseInt(split[0]), Integer.parseInt(split[1]), (Integer.parseInt(split[2]) * 100) + Integer.parseInt(split[3]));
    }

    public VersionInfo getSDKVersionInfo() {
        String[] split = AppLovinSdk.VERSION.split("\\.");
        return new VersionInfo(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
    }

    public void loadRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.adConfiguration = mediationRewardedAdConfiguration;
        if (mediationRewardedAdConfiguration.getBidResponse().equals("")) {
            isRtbAd = false;
        }
        if (!isRtbAd) {
            synchronized (INCENTIVIZED_ADS_LOCK) {
                Bundle serverParameters = this.adConfiguration.getServerParameters();
                this.mPlacement = AppLovinUtils.retrievePlacement(serverParameters);
                this.mZoneId = AppLovinUtils.retrieveZoneId(serverParameters);
                this.mSdk = AppLovinUtils.retrieveSdk(serverParameters, this.adConfiguration.getContext());
                this.mNetworkExtras = this.adConfiguration.getMediationExtras();
                this.mMediationAdLoadCallback = mediationAdLoadCallback;
                ApplovinAdapter.log(3, String.format("Requesting rewarded video for zone '%s' and placement '%s'.", new Object[]{this.mZoneId, this.mPlacement}));
                if (INCENTIVIZED_ADS.containsKey(this.mZoneId)) {
                    this.mIncentivizedInterstitial = (AppLovinIncentivizedInterstitial) INCENTIVIZED_ADS.get(this.mZoneId);
                    this.mMediationAdLoadCallback.onFailure(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED);
                    ApplovinAdapter.log(6, "Cannot load multiple ads with the same Zone ID. Display one ad before attempting to load another.");
                } else {
                    if ("".equals(this.mZoneId)) {
                        this.mIncentivizedInterstitial = AppLovinIncentivizedInterstitial.create(this.mSdk);
                    } else {
                        this.mIncentivizedInterstitial = AppLovinIncentivizedInterstitial.create(this.mZoneId, this.mSdk);
                    }
                    INCENTIVIZED_ADS.put(this.mZoneId, this.mIncentivizedInterstitial);
                }
            }
            this.mIncentivizedInterstitial.preload(this);
            return;
        }
        this.mMediationAdLoadCallback = mediationAdLoadCallback;
        this.mNetworkExtras = this.adConfiguration.getMediationExtras();
        this.mSdk = AppLovinUtils.retrieveSdk(this.adConfiguration.getServerParameters(), this.adConfiguration.getContext());
        this.mIncentivizedInterstitial = AppLovinIncentivizedInterstitial.create(this.mSdk);
        this.mSdk.getAdService().loadNextAdForAdToken(this.adConfiguration.getBidResponse(), this);
    }

    public void showAd(Context context) {
        this.mSdk.getSettings().setMuted(AppLovinUtils.shouldMuteAudio(this.mNetworkExtras));
        ApplovinAdapter.log(3, String.format("Showing rewarded video for zone '%s', placement '%s'", new Object[]{this.mZoneId, this.mPlacement}));
        AppLovinIncentivizedAdListener appLovinIncentivizedAdListener = new AppLovinIncentivizedAdListener(this.adConfiguration, this.mRewardedAdCallback);
        if (isRtbAd) {
            this.mIncentivizedInterstitial.show(this.f3675ad, context, (AppLovinAdRewardListener) appLovinIncentivizedAdListener, (AppLovinAdVideoPlaybackListener) appLovinIncentivizedAdListener, (AppLovinAdDisplayListener) appLovinIncentivizedAdListener, (AppLovinAdClickListener) appLovinIncentivizedAdListener);
        } else if (!this.mIncentivizedInterstitial.isAdReadyToDisplay()) {
            this.mRewardedAdCallback.onAdFailedToShow("Ad Failed to show");
        } else {
            this.mIncentivizedInterstitial.show(context, appLovinIncentivizedAdListener, appLovinIncentivizedAdListener, appLovinIncentivizedAdListener, appLovinIncentivizedAdListener);
        }
    }

    public void collectSignals(RtbSignalData rtbSignalData, SignalCallbacks signalCallbacks) {
        MediationConfiguration configuration = rtbSignalData.getConfiguration();
        if (configuration.getFormat() == AdFormat.NATIVE) {
            handleCollectSignalsFailure("Requested to collect signal for unsupported native ad format. Ignoring...", signalCallbacks);
            return;
        }
        if (rtbSignalData.getNetworkExtras() != null) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Extras for signal collection: ");
            sb.append(rtbSignalData.getNetworkExtras());
            Log.i(str, sb.toString());
        }
        String bidToken = AppLovinUtils.retrieveSdk(configuration.getServerParameters(), rtbSignalData.getContext()).getAdService().getBidToken();
        if (!TextUtils.isEmpty(bidToken)) {
            String str2 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Generated bid token: ");
            sb2.append(bidToken);
            Log.i(str2, sb2.toString());
            signalCallbacks.onSuccess(bidToken);
        } else {
            handleCollectSignalsFailure("Failed to generate bid token", signalCallbacks);
        }
    }

    private void handleCollectSignalsFailure(String str, SignalCallbacks signalCallbacks) {
        Log.e(TAG, str);
        signalCallbacks.onFailure(str);
    }

    public void loadBannerAd(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        new AppLovinRtbBannerRenderer(mediationBannerAdConfiguration, mediationAdLoadCallback).loadAd();
    }

    public void loadInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        new AppLovinRtbInterstitialRenderer(mediationInterstitialAdConfiguration, mediationAdLoadCallback).loadAd();
    }

    public void adReceived(AppLovinAd appLovinAd) {
        this.f3675ad = appLovinAd;
        StringBuilder sb = new StringBuilder();
        sb.append("Rewarded video did load ad: ");
        sb.append(this.f3675ad.getAdIdNumber());
        Log.d("INFO", sb.toString());
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                appLovinMediationAdapter.mRewardedAdCallback = (MediationRewardedAdCallback) appLovinMediationAdapter.mMediationAdLoadCallback.onSuccess(AppLovinMediationAdapter.this);
            }
        });
    }

    public void failedToReceiveAd(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("Rewarded video failed to load with error: ");
        sb.append(i);
        ApplovinAdapter.log(6, sb.toString());
        if (!isRtbAd) {
            INCENTIVIZED_ADS.remove(this.mZoneId);
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                AppLovinMediationAdapter.this.mMediationAdLoadCallback.onFailure("Error");
            }
        });
    }
}
