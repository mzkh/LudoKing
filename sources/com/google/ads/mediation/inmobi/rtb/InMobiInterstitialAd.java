package com.google.ads.mediation.inmobi.rtb;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiInterstitial;
import com.inmobi.ads.listeners.InterstitialAdEventListener;
import java.util.HashMap;
import java.util.Map;

public class InMobiInterstitialAd implements MediationInterstitialAd {
    /* access modifiers changed from: private */
    public final String TAG = InMobiInterstitialAd.class.getName();
    private final InMobiInterstitial mInMobiInterstitial;
    /* access modifiers changed from: private */
    public MediationInterstitialAdCallback mInterstitialAdCallback;
    /* access modifiers changed from: private */
    public MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mMediationAdLoadCallback;
    /* access modifiers changed from: private */
    public SignalCallbacks mSignalCallbacks;

    public InMobiInterstitialAd(Context context, long j) {
        this.mInMobiInterstitial = new InMobiInterstitial(context, j, new InterstitialAdEventListener() {
            public void onAdLoadSucceeded(InMobiInterstitial inMobiInterstitial) {
                Log.d(InMobiInterstitialAd.this.TAG, "onAdLoadSucceeded");
                if (InMobiInterstitialAd.this.mMediationAdLoadCallback != null) {
                    InMobiInterstitialAd inMobiInterstitialAd = InMobiInterstitialAd.this;
                    inMobiInterstitialAd.mInterstitialAdCallback = (MediationInterstitialAdCallback) inMobiInterstitialAd.mMediationAdLoadCallback.onSuccess(InMobiInterstitialAd.this);
                }
            }

            public void onAdLoadFailed(InMobiInterstitial inMobiInterstitial, InMobiAdRequestStatus inMobiAdRequestStatus) {
                StringBuilder sb = new StringBuilder();
                sb.append("onAdLoadFailed: ");
                sb.append(inMobiAdRequestStatus.getMessage());
                String sb2 = sb.toString();
                Log.d(InMobiInterstitialAd.this.TAG, sb2);
                if (InMobiInterstitialAd.this.mMediationAdLoadCallback != null) {
                    InMobiInterstitialAd.this.mMediationAdLoadCallback.onFailure(sb2);
                }
            }

            public void onAdClicked(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map) {
                Log.d(InMobiInterstitialAd.this.TAG, "onAdClicked");
                if (InMobiInterstitialAd.this.mInterstitialAdCallback != null) {
                    InMobiInterstitialAd.this.mInterstitialAdCallback.reportAdClicked();
                }
            }

            public void onAdWillDisplay(InMobiInterstitial inMobiInterstitial) {
                Log.d(InMobiInterstitialAd.this.TAG, "onAdWillDisplay");
            }

            public void onAdDisplayed(InMobiInterstitial inMobiInterstitial) {
                Log.d(InMobiInterstitialAd.this.TAG, "onAdDisplayed");
                if (InMobiInterstitialAd.this.mInterstitialAdCallback != null) {
                    InMobiInterstitialAd.this.mInterstitialAdCallback.onAdOpened();
                    InMobiInterstitialAd.this.mInterstitialAdCallback.reportAdImpression();
                }
            }

            public void onAdDismissed(InMobiInterstitial inMobiInterstitial) {
                Log.d(InMobiInterstitialAd.this.TAG, "onAdDismissed");
                if (InMobiInterstitialAd.this.mInterstitialAdCallback != null) {
                    InMobiInterstitialAd.this.mInterstitialAdCallback.onAdClosed();
                }
            }

            public void onUserLeftApplication(InMobiInterstitial inMobiInterstitial) {
                Log.d(InMobiInterstitialAd.this.TAG, "onUserLeftApplication");
                if (InMobiInterstitialAd.this.mInterstitialAdCallback != null) {
                    InMobiInterstitialAd.this.mInterstitialAdCallback.onAdLeftApplication();
                }
            }

            public void onRequestPayloadCreated(byte[] bArr) {
                String str = new String(bArr);
                String access$000 = InMobiInterstitialAd.this.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("onRequestPayloadCreated: ");
                sb.append(str);
                Log.d(access$000, sb.toString());
                if (InMobiInterstitialAd.this.mSignalCallbacks != null) {
                    InMobiInterstitialAd.this.mSignalCallbacks.onSuccess(str);
                }
            }

            public void onRequestPayloadCreationFailed(InMobiAdRequestStatus inMobiAdRequestStatus) {
                String message = inMobiAdRequestStatus.getMessage();
                String access$000 = InMobiInterstitialAd.this.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("onRequestPayloadCreationFailed: ");
                sb.append(message);
                Log.d(access$000, sb.toString());
                if (InMobiInterstitialAd.this.mSignalCallbacks != null) {
                    InMobiInterstitialAd.this.mSignalCallbacks.onFailure(message);
                }
            }
        });
        HashMap hashMap = new HashMap();
        hashMap.put("tp", "c_admob");
        this.mInMobiInterstitial.setExtras(hashMap);
    }

    public void collectSignals(SignalCallbacks signalCallbacks) {
        this.mSignalCallbacks = signalCallbacks;
        this.mInMobiInterstitial.getSignals();
    }

    public void load(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        this.mMediationAdLoadCallback = mediationAdLoadCallback;
        this.mInMobiInterstitial.load(mediationInterstitialAdConfiguration.getBidResponse().getBytes());
    }

    public void showAd(Context context) {
        if (this.mInMobiInterstitial.isReady()) {
            this.mInMobiInterstitial.show();
        }
    }
}
