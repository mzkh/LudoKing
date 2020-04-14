package com.unity3d.services.ads.placement;

import com.unity3d.ads.UnityAds.PlacementState;
import java.util.HashMap;

public class Placement {
    private static String _defaultBannerPlacement;
    private static String _defaultPlacement;
    private static HashMap<String, PlacementState> _placementReadyMap;

    public static void setPlacementState(String str, String str2) {
        if (_placementReadyMap == null) {
            _placementReadyMap = new HashMap<>();
        }
        _placementReadyMap.put(str, PlacementState.valueOf(str2));
    }

    public static boolean isReady(String str) {
        return getPlacementState(str) == PlacementState.READY;
    }

    public static boolean isReady() {
        return getPlacementState() == PlacementState.READY;
    }

    public static PlacementState getPlacementState(String str) {
        return currentState(str);
    }

    public static PlacementState getPlacementState() {
        String str = _defaultPlacement;
        if (str == null) {
            return PlacementState.NOT_AVAILABLE;
        }
        return getPlacementState(str);
    }

    public static void reset() {
        _placementReadyMap = null;
        _defaultPlacement = null;
    }

    public static void setDefaultPlacement(String str) {
        _defaultPlacement = str;
    }

    public static String getDefaultPlacement() {
        return _defaultPlacement;
    }

    public static void setDefaultBannerPlacement(String str) {
        _defaultBannerPlacement = str;
    }

    public static String getDefaultBannerPlacement() {
        return _defaultBannerPlacement;
    }

    private static PlacementState currentState(String str) {
        HashMap<String, PlacementState> hashMap = _placementReadyMap;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return PlacementState.NOT_AVAILABLE;
        }
        return (PlacementState) _placementReadyMap.get(str);
    }
}
