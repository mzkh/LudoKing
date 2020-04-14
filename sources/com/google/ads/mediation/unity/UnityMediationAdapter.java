package com.google.ads.mediation.unity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAds.FinishState;
import com.unity3d.ads.UnityAds.PlacementState;
import com.unity3d.ads.UnityAds.UnityAdsError;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class UnityMediationAdapter extends Adapter implements MediationRewardedAd {
    static final String KEY_GAME_ID = "gameId";
    static final String KEY_PLACEMENT_ID = "zoneId";
    static final String TAG = "UnityMediationAdapter";
    /* access modifiers changed from: private */
    public MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mMediationAdLoadCallback;
    /* access modifiers changed from: private */
    public MediationRewardedAdCallback mMediationRewardedAdCallback;
    /* access modifiers changed from: private */
    public String mPlacementId;
    private UnityAdapterDelegate mUnityAdapterRewardedAdDelegate = new UnityAdapterDelegate() {
        public void onUnityAdsPlacementStateChanged(String str, PlacementState placementState, PlacementState placementState2) {
        }

        public String getPlacementId() {
            return UnityMediationAdapter.this.mPlacementId;
        }

        public void onUnityAdsReady(String str) {
            if (str.equals(getPlacementId()) && UnityMediationAdapter.this.mMediationAdLoadCallback != null) {
                UnityMediationAdapter unityMediationAdapter = UnityMediationAdapter.this;
                unityMediationAdapter.mMediationRewardedAdCallback = (MediationRewardedAdCallback) unityMediationAdapter.mMediationAdLoadCallback.onSuccess(UnityMediationAdapter.this);
            }
        }

        public void onUnityAdsStart(String str) {
            if (UnityMediationAdapter.this.mMediationRewardedAdCallback != null) {
                UnityMediationAdapter.this.mMediationRewardedAdCallback.onVideoStart();
            }
        }

        public void onUnityAdsClick(String str) {
            if (UnityMediationAdapter.this.mMediationRewardedAdCallback != null) {
                UnityMediationAdapter.this.mMediationRewardedAdCallback.reportAdClicked();
            }
        }

        public void onUnityAdsFinish(String str, FinishState finishState) {
            if (UnityMediationAdapter.this.mMediationRewardedAdCallback != null) {
                if (finishState == FinishState.COMPLETED) {
                    UnityMediationAdapter.this.mMediationRewardedAdCallback.onVideoComplete();
                    UnityMediationAdapter.this.mMediationRewardedAdCallback.onUserEarnedReward(new UnityReward());
                }
                UnityMediationAdapter.this.mMediationRewardedAdCallback.onAdClosed();
            }
        }

        public void onUnityAdsError(UnityAdsError unityAdsError, String str) {
            if (str.equals(getPlacementId()) && UnityMediationAdapter.this.mMediationAdLoadCallback != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to load Rewarded ad from Unity Ads: ");
                sb.append(unityAdsError.toString());
                String sb2 = sb.toString();
                Log.w(UnityMediationAdapter.TAG, sb2);
                UnityMediationAdapter.this.mMediationAdLoadCallback.onFailure(sb2);
            }
        }
    };

    public VersionInfo getVersionInfo() {
        String[] split = BuildConfig.VERSION_NAME.split("\\.");
        return new VersionInfo(Integer.parseInt(split[0]), Integer.parseInt(split[1]), (Integer.parseInt(split[2]) * 100) + Integer.parseInt(split[3]));
    }

    public VersionInfo getSDKVersionInfo() {
        String[] split = UnityAds.getVersion().split("\\.");
        return new VersionInfo(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
    }

    public void initialize(Context context, InitializationCompleteCallback initializationCompleteCallback, List<MediationConfiguration> list) {
        String str;
        String str2;
        if (!(context instanceof Activity)) {
            initializationCompleteCallback.onInitializationFailed("UnityAds SDK requires an Activity context to initialize");
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            str = KEY_GAME_ID;
            if (!hasNext) {
                break;
            }
            String string = ((MediationConfiguration) it.next()).getServerParameters().getString(str);
            if (!TextUtils.isEmpty(string)) {
                hashSet.add(string);
            }
        }
        int size = hashSet.size();
        if (size > 0) {
            str2 = (String) hashSet.iterator().next();
            if (size > 1) {
                Log.w(TAG, String.format("Multiple '%s' entries found: %s. Using '%s' to initialize the UnityAds SDK", new Object[]{str, hashSet.toString(), str2}));
            }
        } else {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            initializationCompleteCallback.onInitializationFailed("Initialization failed: Missing or invalid Game ID.");
            return;
        }
        UnitySingleton.getInstance().initializeUnityAds((Activity) context, str2);
        initializationCompleteCallback.onInitializationSucceeded();
    }

    public void loadRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        Context context = mediationRewardedAdConfiguration.getContext();
        if (!(context instanceof Activity)) {
            mediationAdLoadCallback.onFailure("Context is not an Activity. Unity Ads requires an Activity context to show ads.");
            return;
        }
        Bundle serverParameters = mediationRewardedAdConfiguration.getServerParameters();
        String string = serverParameters.getString(KEY_GAME_ID);
        this.mPlacementId = serverParameters.getString(KEY_PLACEMENT_ID);
        if (!isValidIds(string, this.mPlacementId)) {
            mediationAdLoadCallback.onFailure("Failed to load ad from UnityAds: Missing or invalid game ID and placement ID.");
            return;
        }
        this.mMediationAdLoadCallback = mediationAdLoadCallback;
        UnitySingleton.getInstance().initializeUnityAds((Activity) context, string);
        UnitySingleton.getInstance().loadAd(this.mUnityAdapterRewardedAdDelegate);
    }

    public void showAd(Context context) {
        if (!(context instanceof Activity)) {
            String str = "An activity context is required to show Unity Ads.";
            Log.w(TAG, str);
            MediationRewardedAdCallback mediationRewardedAdCallback = this.mMediationRewardedAdCallback;
            if (mediationRewardedAdCallback != null) {
                mediationRewardedAdCallback.onAdFailedToShow(str);
            }
            return;
        }
        Activity activity = (Activity) context;
        if (UnityAds.isReady(this.mPlacementId)) {
            UnitySingleton.getInstance().showAd(this.mUnityAdapterRewardedAdDelegate, activity);
            MediationRewardedAdCallback mediationRewardedAdCallback2 = this.mMediationRewardedAdCallback;
            if (mediationRewardedAdCallback2 != null) {
                mediationRewardedAdCallback2.onAdOpened();
                this.mMediationRewardedAdCallback.reportAdImpression();
            }
        } else {
            MediationRewardedAdCallback mediationRewardedAdCallback3 = this.mMediationRewardedAdCallback;
            if (mediationRewardedAdCallback3 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("UnityAds placement '");
                sb.append(this.mPlacementId);
                sb.append("' is not ready.");
                mediationRewardedAdCallback3.onAdFailedToShow(sb.toString());
            }
        }
    }

    private static boolean isValidIds(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return true;
        }
        String str3 = TextUtils.isEmpty(str) ? TextUtils.isEmpty(str2) ? "Game ID and Placement ID" : "Game ID" : "Placement ID";
        String str4 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        sb.append(" cannot be empty.");
        Log.w(str4, sb.toString());
        return false;
    }
}
