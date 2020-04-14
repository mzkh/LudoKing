package com.google.android.gms.ads.mediation.customevent;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public interface CustomEventListener {
    void onAdClicked();

    void onAdClosed();

    void onAdFailedToLoad(int i);

    void onAdLeftApplication();

    void onAdOpened();
}
