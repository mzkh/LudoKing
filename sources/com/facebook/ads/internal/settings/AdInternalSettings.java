package com.facebook.ads.internal.settings;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.ads.AdSettings.MultiprocessSupportMode;
import com.facebook.ads.internal.dynamicloading.DynamicLoader;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import java.util.ArrayList;
import java.util.Collection;

@Keep
public class AdInternalSettings {
    private static final String BOOL_AUTOPLAY_ON_MOBILE_KEY = "BOOL_AUTOPLAY_ON_MOBILE_KEY";
    public static final String BOOL_CHILD_DIRECTED_KEY = "BOOL_CHILD_DIRECTED_KEY";
    private static final String BOOL_DEBUGGER_STATE_KEY = "BOOL_DEBUGGER_STATE_KEY";
    private static final String BOOL_DEBUG_BUILD_KEY = "BOOL_DEBUG_BUILD_KEY";
    private static final String BOOL_EXPLICIT_TEST_MODE_KEY = "BOOL_EXPLICIT_TEST_MODE_KEY";
    public static final String BOOL_MIXED_AUDIENCE_KEY = "BOOL_MIXED_AUDIENCE_KEY";
    private static final String BOOL_VIDEO_AUTOPLAY_KEY = "BOOL_VIDEO_AUTOPLAY_KEY";
    private static final String BOOL_VISIBLE_ANIMATION_KEY = "BOOL_VISIBLE_ANIMATION_KEY";
    private static final String LIST_TEST_DEVICES_KEY = "LIST_TEST_DEVICES_KEY";
    public static final String SRL_INTEGRATION_ERROR_MODE_KEY = "SRL_INTEGRATION_ERROR_MODE_KEY";
    private static final String STR_MEDIATION_SERVICE_KEY = "STR_MEDIATION_SERVICE_KEY";
    private static final String STR_URL_PREFIX_KEY = "STR_URL_PREFIX_KEY";
    public static final String TEST_AD_TYPE_KEY = "TEST_AD_TYPE_KEY";
    public static boolean sForceIpc = false;
    public static MultiprocessSupportMode sMultiprocessSupportMode = MultiprocessSupportMode.MULTIPROCESS_SUPPORT_MODE_AUTO;
    public static MultithreadedBundleWrapper sSettingsBundle = new MultithreadedBundleWrapper();

    public static void setTestMode(boolean z) {
        sSettingsBundle.putBoolean(BOOL_EXPLICIT_TEST_MODE_KEY, z);
    }

    public static void setVisibleAnimation(boolean z) {
        sSettingsBundle.putBoolean(BOOL_VISIBLE_ANIMATION_KEY, z);
    }

    public static void setUrlPrefix(@Nullable String str) {
        sSettingsBundle.putString(STR_URL_PREFIX_KEY, str);
    }

    public static void setMediationService(String str) {
        sSettingsBundle.putString(STR_MEDIATION_SERVICE_KEY, str);
    }

    public static boolean isExplicitTestMode() {
        return sSettingsBundle.getBoolean(BOOL_EXPLICIT_TEST_MODE_KEY, false);
    }

    public static boolean isTestMode(Context context) {
        return DynamicLoaderFactory.makeLoader(context).createAdSettingsApi().isTestMode(context);
    }

    public static boolean isVisibleAnimation() {
        return sSettingsBundle.getBoolean(BOOL_VISIBLE_ANIMATION_KEY, false);
    }

    @Nullable
    public static String getUrlPrefix() {
        return sSettingsBundle.getString(STR_URL_PREFIX_KEY, null);
    }

    @Nullable
    public static String getMediationService() {
        return sSettingsBundle.getString(STR_MEDIATION_SERVICE_KEY, null);
    }

    public static void addTestDevices(Collection<String> collection) {
        getTestDevicesList().addAll(collection);
    }

    public static void addTestDevice(String str) {
        getTestDevicesList().add(str);
    }

    public static void clearTestDevices() {
        getTestDevicesList().clear();
    }

    public static void turnOnSDKDebugger(Context context) {
        DynamicLoader dynamicLoader = DynamicLoaderFactory.getDynamicLoader();
        if (dynamicLoader != null) {
            dynamicLoader.createAdSettingsApi().turnOnDebugger();
        } else {
            sSettingsBundle.putBoolean(BOOL_DEBUGGER_STATE_KEY, true);
        }
    }

    public static void setDebugBuild(boolean z) {
        DynamicLoader dynamicLoader = DynamicLoaderFactory.getDynamicLoader();
        if (dynamicLoader != null && z) {
            dynamicLoader.createAdSettingsApi().turnOnDebugger();
        }
        sSettingsBundle.putBoolean(BOOL_DEBUG_BUILD_KEY, z);
    }

    public static boolean isVideoAutoplay() {
        return sSettingsBundle.getBoolean(BOOL_VIDEO_AUTOPLAY_KEY);
    }

    public static void setVideoAutoplay(boolean z) {
        sSettingsBundle.putBoolean(BOOL_VIDEO_AUTOPLAY_KEY, z);
    }

    public static void setVideoAutoplayOnMobile(boolean z) {
        sSettingsBundle.putBoolean(BOOL_AUTOPLAY_ON_MOBILE_KEY, z);
    }

    public static boolean isVideoAutoplayOnMobile() {
        return sSettingsBundle.getBoolean(BOOL_AUTOPLAY_ON_MOBILE_KEY, false);
    }

    public static boolean isDebugBuild() {
        return sSettingsBundle.getBoolean(BOOL_DEBUG_BUILD_KEY, false);
    }

    public static boolean isDebuggerOn() {
        return sSettingsBundle.getBoolean(BOOL_DEBUGGER_STATE_KEY, false);
    }

    public static ArrayList<String> getTestDevicesList() {
        MultithreadedBundleWrapper multithreadedBundleWrapper = sSettingsBundle;
        String str = LIST_TEST_DEVICES_KEY;
        ArrayList<String> stringArrayList = multithreadedBundleWrapper.getStringArrayList(str);
        if (stringArrayList != null) {
            return stringArrayList;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        sSettingsBundle.putStringArrayList(str, arrayList);
        return arrayList;
    }

    public static void setMultiprocessSupportMode(MultiprocessSupportMode multiprocessSupportMode) {
        sMultiprocessSupportMode = multiprocessSupportMode;
    }

    public static void setForceIpc(boolean z) {
        sForceIpc = z;
    }
}
