package com.google.ads.mediation.inmobi.rtb;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiBanner;
import com.inmobi.ads.listeners.BannerAdEventListener;
import java.util.HashMap;
import java.util.Map;

public class InMobiBannerAd implements MediationBannerAd {
    /* access modifiers changed from: private */
    public final String TAG = InMobiBannerAd.class.getName();
    /* access modifiers changed from: private */
    public MediationBannerAdCallback mBannerAdCallback;
    private final InMobiBanner mInMobiBanner;
    /* access modifiers changed from: private */
    public MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mMediationAdLoadCallback;
    /* access modifiers changed from: private */
    public SignalCallbacks mSignalsCallback;

    public InMobiBannerAd(Context context, long j, AdSize adSize) {
        this.mInMobiBanner = new InMobiBanner(context, j);
        this.mInMobiBanner.setBannerSize(adSize.getWidth(), adSize.getHeight());
        this.mInMobiBanner.setListener(new BannerAdEventListener() {
            public void onAdLoadSucceeded(InMobiBanner inMobiBanner) {
                Log.d(InMobiBannerAd.this.TAG, "onAdLoadSucceeded");
                if (InMobiBannerAd.this.mMediationAdLoadCallback != null) {
                    InMobiBannerAd inMobiBannerAd = InMobiBannerAd.this;
                    inMobiBannerAd.mBannerAdCallback = (MediationBannerAdCallback) inMobiBannerAd.mMediationAdLoadCallback.onSuccess(InMobiBannerAd.this);
                    InMobiBannerAd.this.mBannerAdCallback.reportAdImpression();
                }
            }

            public void onAdLoadFailed(InMobiBanner inMobiBanner, InMobiAdRequestStatus inMobiAdRequestStatus) {
                StringBuilder sb = new StringBuilder();
                sb.append("onAdLoadFailed: ");
                sb.append(inMobiAdRequestStatus.getMessage());
                String sb2 = sb.toString();
                Log.d(InMobiBannerAd.this.TAG, sb2);
                if (InMobiBannerAd.this.mMediationAdLoadCallback != null) {
                    InMobiBannerAd.this.mMediationAdLoadCallback.onFailure(sb2);
                }
            }

            public void onAdClicked(InMobiBanner inMobiBanner, Map<Object, Object> map) {
                Log.d(InMobiBannerAd.this.TAG, "onAdClicked");
                if (InMobiBannerAd.this.mBannerAdCallback != null) {
                    InMobiBannerAd.this.mBannerAdCallback.reportAdClicked();
                }
            }

            public void onAdDisplayed(InMobiBanner inMobiBanner) {
                Log.d(InMobiBannerAd.this.TAG, "onAdDisplayed");
                if (InMobiBannerAd.this.mBannerAdCallback != null) {
                    InMobiBannerAd.this.mBannerAdCallback.onAdOpened();
                }
            }

            public void onAdDismissed(InMobiBanner inMobiBanner) {
                Log.d(InMobiBannerAd.this.TAG, "onAdDismissed");
                if (InMobiBannerAd.this.mBannerAdCallback != null) {
                    InMobiBannerAd.this.mBannerAdCallback.onAdClosed();
                }
            }

            public void onUserLeftApplication(InMobiBanner inMobiBanner) {
                Log.d(InMobiBannerAd.this.TAG, "onUserLeftApplication");
                if (InMobiBannerAd.this.mBannerAdCallback != null) {
                    InMobiBannerAd.this.mBannerAdCallback.onAdLeftApplication();
                }
            }

            public void onRequestPayloadCreated(byte[] bArr) {
                String str = new String(bArr);
                String access$000 = InMobiBannerAd.this.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("onRequestPayloadCreated: ");
                sb.append(str);
                Log.d(access$000, sb.toString());
                if (InMobiBannerAd.this.mSignalsCallback != null) {
                    InMobiBannerAd.this.mSignalsCallback.onSuccess(str);
                }
            }

            public void onRequestPayloadCreationFailed(InMobiAdRequestStatus inMobiAdRequestStatus) {
                String message = inMobiAdRequestStatus.getMessage();
                String access$000 = InMobiBannerAd.this.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("onRequestPayloadCreationFailed: ");
                sb.append(message);
                Log.d(access$000, sb.toString());
                if (InMobiBannerAd.this.mSignalsCallback != null) {
                    InMobiBannerAd.this.mSignalsCallback.onFailure(message);
                }
            }
        });
        HashMap hashMap = new HashMap();
        hashMap.put("tp", "c_admob");
        this.mInMobiBanner.setExtras(hashMap);
    }

    public void collectSignals(SignalCallbacks signalCallbacks) {
        this.mSignalsCallback = signalCallbacks;
        this.mInMobiBanner.getSignals();
    }

    public void load(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        this.mMediationAdLoadCallback = mediationAdLoadCallback;
        this.mInMobiBanner.load(mediationBannerAdConfiguration.getBidResponse().getBytes());
    }

    @NonNull
    public View getView() {
        return this.mInMobiBanner;
    }
}
