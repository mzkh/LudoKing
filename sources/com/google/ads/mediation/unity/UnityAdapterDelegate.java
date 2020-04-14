package com.google.ads.mediation.unity;

import com.unity3d.ads.mediation.IUnityAdsExtendedListener;

public interface UnityAdapterDelegate extends IUnityAdsExtendedListener {
    String getPlacementId();
}
