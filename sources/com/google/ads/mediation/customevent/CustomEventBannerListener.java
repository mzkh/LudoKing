package com.google.ads.mediation.customevent;

import android.view.View;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public interface CustomEventBannerListener extends CustomEventListener {
    void onClick();

    void onReceivedAd(View view);
}
