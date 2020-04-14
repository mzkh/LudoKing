package com.unity3d.ads;

import android.app.Activity;
import com.unity3d.services.UnityServices;
import com.unity3d.services.ads.UnityAdsImplementation;

public final class UnityAds {

    public enum FinishState {
        ERROR,
        SKIPPED,
        COMPLETED
    }

    public enum PlacementState {
        READY,
        NOT_AVAILABLE,
        DISABLED,
        WAITING,
        NO_FILL
    }

    public enum UnityAdsError {
        NOT_INITIALIZED,
        INITIALIZE_FAILED,
        INVALID_ARGUMENT,
        VIDEO_PLAYER_ERROR,
        INIT_SANITY_CHECK_FAIL,
        AD_BLOCKER_DETECTED,
        FILE_IO_ERROR,
        DEVICE_ID_ERROR,
        SHOW_ERROR,
        INTERNAL_ERROR
    }

    public static void initialize(Activity activity, String str, IUnityAdsListener iUnityAdsListener) {
        initialize(activity, str, iUnityAdsListener, false, false);
    }

    public static void initialize(Activity activity, String str, IUnityAdsListener iUnityAdsListener, boolean z) {
        UnityAdsImplementation.initialize(activity, str, iUnityAdsListener, z, false);
    }

    public static void initialize(Activity activity, String str, IUnityAdsListener iUnityAdsListener, boolean z, boolean z2) {
        UnityAdsImplementation.initialize(activity, str, iUnityAdsListener, z, z2);
    }

    public static boolean isInitialized() {
        return UnityServices.isInitialized();
    }

    public static void setListener(IUnityAdsListener iUnityAdsListener) {
        UnityAdsImplementation.setListener(iUnityAdsListener);
    }

    public static void addListener(IUnityAdsListener iUnityAdsListener) {
        UnityAdsImplementation.addListener(iUnityAdsListener);
    }

    public static void removeListener(IUnityAdsListener iUnityAdsListener) {
        UnityAdsImplementation.removeListener(iUnityAdsListener);
    }

    public static IUnityAdsListener getListener() {
        return UnityAdsImplementation.getListener();
    }

    public static boolean isSupported() {
        return UnityAdsImplementation.isSupported();
    }

    public static String getVersion() {
        return UnityAdsImplementation.getVersion();
    }

    public static boolean isReady() {
        return UnityAdsImplementation.isReady();
    }

    public static boolean isReady(String str) {
        return UnityAdsImplementation.isReady(str);
    }

    public static PlacementState getPlacementState() {
        return UnityAdsImplementation.getPlacementState();
    }

    public static PlacementState getPlacementState(String str) {
        return UnityAdsImplementation.getPlacementState(str);
    }

    public static void show(Activity activity) {
        UnityAdsImplementation.show(activity);
    }

    public static void show(Activity activity, String str) {
        UnityAdsImplementation.show(activity, str);
    }

    public static void setDebugMode(boolean z) {
        UnityAdsImplementation.setDebugMode(z);
    }

    public static boolean getDebugMode() {
        return UnityAdsImplementation.getDebugMode();
    }

    public static void load(String str) {
        UnityAdsImplementation.load(str);
    }
}
