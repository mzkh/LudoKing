package com.unity3d.ads.properties;

import com.unity3d.ads.IUnityAdsListener;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class AdsProperties {
    private static Set<IUnityAdsListener> _listeners = Collections.synchronizedSet(new LinkedHashSet());
    private static int _showTimeout = 5000;

    public static void setShowTimeout(int i) {
        _showTimeout = i;
    }

    public static int getShowTimeout() {
        return _showTimeout;
    }

    public static void addListener(IUnityAdsListener iUnityAdsListener) {
        if (iUnityAdsListener != null && !_listeners.contains(iUnityAdsListener)) {
            _listeners.add(iUnityAdsListener);
        }
    }

    public static Set<IUnityAdsListener> getListeners() {
        return new LinkedHashSet(_listeners);
    }

    public static void removeListener(IUnityAdsListener iUnityAdsListener) {
        _listeners.remove(iUnityAdsListener);
    }
}
