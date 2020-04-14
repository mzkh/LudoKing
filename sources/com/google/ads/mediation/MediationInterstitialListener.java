package com.google.ads.mediation;

import com.google.ads.AdRequest.ErrorCode;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public interface MediationInterstitialListener {
    void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter);

    void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, ErrorCode errorCode);

    void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter);

    void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter);

    void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter);
}
