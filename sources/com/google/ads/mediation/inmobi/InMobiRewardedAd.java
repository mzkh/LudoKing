package com.google.ads.mediation.inmobi;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.ads.mediation.MediationAdConfiguration;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiInterstitial;
import com.inmobi.ads.listeners.InterstitialAdEventListener;
import com.inmobi.sdk.InMobiSdk;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class InMobiRewardedAd implements MediationRewardedAd {
    /* access modifiers changed from: private */
    public static HashMap<Long, WeakReference<InMobiRewardedAd>> mPlacementsInUse = new HashMap<>();
    private InMobiInterstitial mInMobiRewardedAd;
    /* access modifiers changed from: private */
    public MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mMediationAdLoadCallback;
    /* access modifiers changed from: private */
    public MediationRewardedAdCallback mRewardedAdCallback;
    /* access modifiers changed from: private */
    public SignalCallbacks mSignalCallbacks;

    public InMobiRewardedAd(Context context, final long j) {
        this.mInMobiRewardedAd = new InMobiInterstitial(context, j, new InterstitialAdEventListener() {
            public void onRewardsUnlocked(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map) {
                String str;
                int i;
                Log.d(InMobiMediationAdapter.TAG, "InMobi RewardedVideo onRewardsUnlocked.");
                String str2 = "";
                if (map != null) {
                    str = str2;
                    for (Object obj : map.keySet()) {
                        str2 = obj.toString();
                        str = map.get(str2).toString();
                        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                            break;
                        }
                    }
                } else {
                    str = str2;
                }
                if (!TextUtils.isEmpty(str)) {
                    try {
                        i = Integer.parseInt(str);
                    } catch (NumberFormatException unused) {
                        String str3 = InMobiMediationAdapter.TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected an integer reward value. Got ");
                        sb.append(str);
                        sb.append(" instead. Using reward value of 1.");
                        Log.w(str3, sb.toString());
                        i = 1;
                    }
                } else {
                    i = 0;
                }
                if (InMobiRewardedAd.this.mRewardedAdCallback != null) {
                    InMobiRewardedAd.this.mRewardedAdCallback.onVideoComplete();
                    InMobiRewardedAd.this.mRewardedAdCallback.onUserEarnedReward(new InMobiReward(str2, i));
                }
            }

            public void onAdDisplayFailed(InMobiInterstitial inMobiInterstitial) {
                Log.d(InMobiMediationAdapter.TAG, "onAdDisplayFailed");
                if (InMobiRewardedAd.this.mRewardedAdCallback != null) {
                    InMobiRewardedAd.this.mRewardedAdCallback.onAdFailedToShow("Internal Error.");
                }
                InMobiRewardedAd.mPlacementsInUse.remove(Long.valueOf(j));
            }

            public void onAdWillDisplay(InMobiInterstitial inMobiInterstitial) {
                Log.d(InMobiMediationAdapter.TAG, "onAdWillDisplay");
            }

            public void onAdDisplayed(InMobiInterstitial inMobiInterstitial) {
                Log.d(InMobiMediationAdapter.TAG, "onAdDisplayed");
                if (InMobiRewardedAd.this.mRewardedAdCallback != null) {
                    InMobiRewardedAd.this.mRewardedAdCallback.onAdOpened();
                    InMobiRewardedAd.this.mRewardedAdCallback.onVideoStart();
                    InMobiRewardedAd.this.mRewardedAdCallback.reportAdImpression();
                }
            }

            public void onAdDismissed(InMobiInterstitial inMobiInterstitial) {
                Log.d(InMobiMediationAdapter.TAG, "onAdDismissed");
                if (InMobiRewardedAd.this.mRewardedAdCallback != null) {
                    InMobiRewardedAd.this.mRewardedAdCallback.onAdClosed();
                }
                InMobiRewardedAd.mPlacementsInUse.remove(Long.valueOf(j));
            }

            public void onAdClicked(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map) {
                Log.d(InMobiMediationAdapter.TAG, "onAdClicked");
                if (InMobiRewardedAd.this.mRewardedAdCallback != null) {
                    InMobiRewardedAd.this.mRewardedAdCallback.reportAdClicked();
                }
            }

            public void onAdLoadSucceeded(InMobiInterstitial inMobiInterstitial) {
                Log.d(InMobiMediationAdapter.TAG, "onAdLoadSucceeded");
                InMobiRewardedAd inMobiRewardedAd = InMobiRewardedAd.this;
                inMobiRewardedAd.mRewardedAdCallback = (MediationRewardedAdCallback) inMobiRewardedAd.mMediationAdLoadCallback.onSuccess(InMobiRewardedAd.this);
            }

            public void onAdLoadFailed(InMobiInterstitial inMobiInterstitial, InMobiAdRequestStatus inMobiAdRequestStatus) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to load ad from InMobi: ");
                sb.append(inMobiAdRequestStatus.getMessage());
                String sb2 = sb.toString();
                Log.w(InMobiMediationAdapter.TAG, sb2);
                InMobiRewardedAd.this.mMediationAdLoadCallback.onFailure(sb2);
                InMobiRewardedAd.mPlacementsInUse.remove(Long.valueOf(j));
            }

            public void onAdReceived(InMobiInterstitial inMobiInterstitial) {
                Log.d(InMobiMediationAdapter.TAG, "InMobi Ad server responded with an Ad.");
            }

            public void onUserLeftApplication(InMobiInterstitial inMobiInterstitial) {
                Log.d(InMobiMediationAdapter.TAG, "onUserLeftApplication");
            }

            public void onRequestPayloadCreated(byte[] bArr) {
                String str = new String(bArr);
                String str2 = InMobiMediationAdapter.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("onRequestPayloadCreated: ");
                sb.append(str);
                Log.d(str2, sb.toString());
                if (InMobiRewardedAd.this.mSignalCallbacks != null) {
                    InMobiRewardedAd.this.mSignalCallbacks.onSuccess(str);
                }
            }

            public void onRequestPayloadCreationFailed(InMobiAdRequestStatus inMobiAdRequestStatus) {
                String message = inMobiAdRequestStatus.getMessage();
                String str = InMobiMediationAdapter.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("onRequestPayloadCreationFailed: ");
                sb.append(message);
                Log.d(str, sb.toString());
                if (InMobiRewardedAd.this.mSignalCallbacks != null) {
                    InMobiRewardedAd.this.mSignalCallbacks.onFailure(message);
                }
            }
        });
    }

    public void collectSignals(SignalCallbacks signalCallbacks) {
        this.mSignalCallbacks = signalCallbacks;
        this.mInMobiRewardedAd.getSignals();
    }

    public void load(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        Context context = mediationRewardedAdConfiguration.getContext();
        this.mMediationAdLoadCallback = mediationAdLoadCallback;
        if (!(context instanceof Activity)) {
            String str = "Failed to load ad from InMobi: InMobi SDK requires an Activity context to load ads.";
            Log.w(InMobiMediationAdapter.TAG, str);
            mediationAdLoadCallback.onFailure(str);
            return;
        }
        Bundle serverParameters = mediationRewardedAdConfiguration.getServerParameters();
        Bundle mediationExtras = mediationRewardedAdConfiguration.getMediationExtras();
        if (!InMobiMediationAdapter.isSdkInitialized.get()) {
            String string = serverParameters.getString("accountid");
            if (TextUtils.isEmpty(string)) {
                String str2 = "Failed to load ad from InMobi: Missing or Invalid Account ID.";
                Log.w(InMobiMediationAdapter.TAG, str2);
                this.mMediationAdLoadCallback.onFailure(str2);
                return;
            }
            InMobiSdk.init(context, string, InMobiConsent.getConsentObj());
            InMobiMediationAdapter.isSdkInitialized.set(true);
        }
        String string2 = serverParameters.getString("placementid");
        if (TextUtils.isEmpty(string2)) {
            String str3 = "Failed to load ad from InMobi: Missing or Invalid Placement ID.";
            Log.e(InMobiMediationAdapter.TAG, str3);
            this.mMediationAdLoadCallback.onFailure(str3);
            return;
        }
        try {
            long parseLong = Long.parseLong(string2.trim());
            if (!mPlacementsInUse.containsKey(Long.valueOf(parseLong)) || ((WeakReference) mPlacementsInUse.get(Long.valueOf(parseLong))).get() == null) {
                this.mInMobiRewardedAd.setExtras(InMobiAdapterUtils.createInMobiParameterMap((MediationAdConfiguration) mediationRewardedAdConfiguration));
                InMobiAdapterUtils.setGlobalTargeting(mediationRewardedAdConfiguration, mediationExtras);
                String bidResponse = mediationRewardedAdConfiguration.getBidResponse();
                if (TextUtils.isEmpty(bidResponse)) {
                    this.mInMobiRewardedAd.load();
                } else {
                    this.mInMobiRewardedAd.load(bidResponse.getBytes());
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to load ad from InMobi: An ad has already been requested for placement ID: ");
            sb.append(parseLong);
            String sb2 = sb.toString();
            Log.w(InMobiMediationAdapter.TAG, sb2);
            this.mMediationAdLoadCallback.onFailure(sb2);
        } catch (NumberFormatException e) {
            String str4 = "Failed to load ad from InMobi: Invalid Placement ID.";
            Log.w(InMobiMediationAdapter.TAG, str4, e);
            this.mMediationAdLoadCallback.onFailure(str4);
        }
    }

    public void showAd(Context context) {
        if (this.mInMobiRewardedAd.isReady()) {
            this.mInMobiRewardedAd.show();
        }
    }
}
