package com.google.android.gms.ads.mediation.rtb;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public interface SignalCallbacks {
    void onFailure(String str);

    void onSuccess(String str);
}
