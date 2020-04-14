package com.unity3d.services.monetization.core.placementcontent;

import com.unity3d.services.monetization.UnityMonetization.PlacementContentState;
import com.unity3d.services.monetization.placementcontent.core.CustomEvent;
import com.unity3d.services.monetization.placementcontent.core.PlacementContent;
import java.util.HashMap;
import java.util.Map;

public class PlacementContents {
    private static final PlacementContent NOT_AVAILABLE = getNotAvailablePlacementContent();
    private static Map<String, PlacementContent> placementContentsMap = new HashMap();

    private static final class NotAvailablePlacementContent extends PlacementContent {
        /* access modifiers changed from: protected */
        public String getDefaultEventCategory() {
            return "NOT_AVAILABLE";
        }

        public boolean isReady() {
            return false;
        }

        public void sendCustomEvent(CustomEvent customEvent) {
        }

        public NotAvailablePlacementContent(String str, Map<String, Object> map) {
            super(str, map);
        }

        public PlacementContentState getState() {
            return PlacementContentState.NOT_AVAILABLE;
        }
    }

    public static PlacementContent getPlacementContent(String str) {
        PlacementContent placementContent = (PlacementContent) placementContentsMap.get(str);
        return placementContent == null ? NOT_AVAILABLE : placementContent;
    }

    public static <T extends PlacementContent> T getPlacementContent(String str, Class<T> cls) {
        PlacementContent placementContent = getPlacementContent(str);
        if (cls.isInstance(placementContent)) {
            return (PlacementContent) cls.cast(placementContent);
        }
        return null;
    }

    public static PlacementContent putPlacementContent(String str, PlacementContent placementContent) {
        return (PlacementContent) placementContentsMap.put(str, placementContent);
    }

    public static boolean isReady(String str) {
        PlacementContent placementContent = getPlacementContent(str);
        return placementContent != null && placementContent.isReady();
    }

    public static void removePlacementContent(String str) {
        placementContentsMap.remove(str);
    }

    public static void setPlacementContentState(String str, PlacementContentState placementContentState) {
        PlacementContent placementContent = getPlacementContent(str);
        if (placementContent != null) {
            placementContent.setState(placementContentState);
        }
    }

    private static PlacementContent getNotAvailablePlacementContent() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "NOT_AVAILABLE");
        return new NotAvailablePlacementContent("", hashMap);
    }
}
