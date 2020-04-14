package com.unity3d.services.monetization;

import android.app.Activity;
import com.unity3d.services.UnityServices;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.monetization.core.placementcontent.PlacementContents;
import com.unity3d.services.monetization.core.properties.ClientProperties;
import com.unity3d.services.monetization.placementcontent.core.PlacementContent;

public class UnityMonetization {

    public enum PlacementContentState {
        READY,
        NOT_AVAILABLE,
        DISABLED,
        WAITING,
        NO_FILL
    }

    public static void setListener(IUnityMonetizationListener iUnityMonetizationListener) {
        ClientProperties.setListener(iUnityMonetizationListener);
    }

    public static IUnityMonetizationListener getListener() {
        return ClientProperties.getListener();
    }

    public static boolean isReady(String str) {
        return PlacementContents.isReady(str);
    }

    public static PlacementContent getPlacementContent(String str) {
        return PlacementContents.getPlacementContent(str);
    }

    public static <T extends PlacementContent> T getPlacementContent(String str, Class<T> cls) {
        return PlacementContents.getPlacementContent(str, cls);
    }

    public static void initialize(Activity activity, String str, IUnityMonetizationListener iUnityMonetizationListener) {
        initialize(activity, str, iUnityMonetizationListener, false);
    }

    public static void initialize(Activity activity, String str, IUnityMonetizationListener iUnityMonetizationListener, boolean z) {
        DeviceLog.entered();
        if (iUnityMonetizationListener != null) {
            setListener(iUnityMonetizationListener);
        }
        ClientProperties.setMonetizationEnabled(true);
        UnityServices.initialize(activity, str, iUnityMonetizationListener, z, false);
    }
}
