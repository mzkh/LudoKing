package com.google.android.gms.ads.doubleclick;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public interface CustomRenderedAd {
    String getBaseUrl();

    String getContent();

    void onAdRendered(View view);

    void recordClick();

    void recordImpression();
}
