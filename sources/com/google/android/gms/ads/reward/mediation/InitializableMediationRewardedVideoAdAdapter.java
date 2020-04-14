package com.google.android.gms.ads.reward.mediation;

import android.content.Context;
import android.os.Bundle;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public interface InitializableMediationRewardedVideoAdAdapter extends MediationRewardedVideoAdAdapter {
    void initialize(Context context, MediationRewardedVideoAdListener mediationRewardedVideoAdListener, List<Bundle> list);
}
