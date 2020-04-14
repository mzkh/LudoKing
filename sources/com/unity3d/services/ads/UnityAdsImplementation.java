package com.unity3d.services.ads;

import android.app.Activity;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds.FinishState;
import com.unity3d.ads.UnityAds.PlacementState;
import com.unity3d.ads.UnityAds.UnityAdsError;
import com.unity3d.ads.properties.AdsProperties;
import com.unity3d.services.IUnityServicesListener;
import com.unity3d.services.UnityServices;
import com.unity3d.services.UnityServices.UnityServicesError;
import com.unity3d.services.ads.adunit.AdUnitOpen;
import com.unity3d.services.ads.load.LoadModule;
import com.unity3d.services.ads.placement.Placement;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.ClientProperties;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class UnityAdsImplementation {
    public static void initialize(Activity activity, String str, IUnityAdsListener iUnityAdsListener) {
        initialize(activity, str, iUnityAdsListener, false);
    }

    public static void initialize(Activity activity, String str, IUnityAdsListener iUnityAdsListener, boolean z) {
        initialize(activity, str, iUnityAdsListener, z, false);
    }

    public static void initialize(Activity activity, String str, final IUnityAdsListener iUnityAdsListener, boolean z, boolean z2) {
        DeviceLog.entered();
        addListener(iUnityAdsListener);
        UnityServices.initialize(activity, str, new IUnityServicesListener() {
            public void onUnityServicesError(UnityServicesError unityServicesError, String str) {
                if (unityServicesError == UnityServicesError.INIT_SANITY_CHECK_FAIL) {
                    iUnityAdsListener.onUnityAdsError(UnityAdsError.INIT_SANITY_CHECK_FAIL, str);
                } else if (unityServicesError == UnityServicesError.INVALID_ARGUMENT) {
                    iUnityAdsListener.onUnityAdsError(UnityAdsError.INVALID_ARGUMENT, str);
                }
            }
        }, z, z2);
    }

    public static boolean isInitialized() {
        return UnityServices.isInitialized();
    }

    @Deprecated
    public static void setListener(IUnityAdsListener iUnityAdsListener) {
        AdsProperties.addListener(iUnityAdsListener);
    }

    public static void addListener(IUnityAdsListener iUnityAdsListener) {
        AdsProperties.addListener(iUnityAdsListener);
    }

    public static void removeListener(IUnityAdsListener iUnityAdsListener) {
        AdsProperties.removeListener(iUnityAdsListener);
    }

    @Deprecated
    public static IUnityAdsListener getListener() {
        Iterator it = AdsProperties.getListeners().iterator();
        if (it.hasNext()) {
            return (IUnityAdsListener) it.next();
        }
        return null;
    }

    public static boolean isSupported() {
        return UnityServices.isSupported();
    }

    public static String getVersion() {
        return UnityServices.getVersion();
    }

    public static boolean isReady() {
        return isSupported() && isInitialized() && Placement.isReady();
    }

    public static boolean isReady(String str) {
        return isSupported() && isInitialized() && str != null && Placement.isReady(str);
    }

    public static PlacementState getPlacementState() {
        if (!isSupported() || !isInitialized()) {
            return PlacementState.NOT_AVAILABLE;
        }
        return Placement.getPlacementState();
    }

    public static PlacementState getPlacementState(String str) {
        if (!isSupported() || !isInitialized() || str == null) {
            return PlacementState.NOT_AVAILABLE;
        }
        return Placement.getPlacementState(str);
    }

    public static void show(Activity activity) {
        if (Placement.getDefaultPlacement() != null) {
            show(activity, Placement.getDefaultPlacement());
            return;
        }
        handleShowError("", UnityAdsError.NOT_INITIALIZED, "Unity Ads default placement is not initialized");
    }

    public static void show(final Activity activity, final String str) {
        if (activity == null) {
            handleShowError(str, UnityAdsError.INVALID_ARGUMENT, "Activity must not be null");
            return;
        }
        if (isReady(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unity Ads opening new ad unit for placement ");
            sb.append(str);
            DeviceLog.info(sb.toString());
            ClientProperties.setActivity(activity);
            new Thread(new Runnable() {
                public void run() {
                    Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("requestedOrientation", activity.getRequestedOrientation());
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("rotation", defaultDisplay.getRotation());
                        String str = "height";
                        String str2 = "width";
                        if (VERSION.SDK_INT >= 13) {
                            Point point = new Point();
                            defaultDisplay.getSize(point);
                            jSONObject2.put(str2, point.x);
                            jSONObject2.put(str, point.y);
                        } else {
                            jSONObject2.put(str2, defaultDisplay.getWidth());
                            jSONObject2.put(str, defaultDisplay.getHeight());
                        }
                        jSONObject.put("display", jSONObject2);
                    } catch (JSONException e) {
                        DeviceLog.exception("JSON error while constructing show options", e);
                    }
                    try {
                        if (!AdUnitOpen.open(str, jSONObject)) {
                            UnityAdsImplementation.handleShowError(str, UnityAdsError.INTERNAL_ERROR, "Webapp timeout, shutting down Unity Ads");
                        }
                    } catch (NoSuchMethodException e2) {
                        DeviceLog.exception("Could not get callback method", e2);
                        UnityAdsImplementation.handleShowError(str, UnityAdsError.SHOW_ERROR, "Could not get com.unity3d.ads.properties.showCallback method");
                    }
                }
            }).start();
        } else if (!isSupported()) {
            handleShowError(str, UnityAdsError.NOT_INITIALIZED, "Unity Ads is not supported for this device");
        } else if (!isInitialized()) {
            handleShowError(str, UnityAdsError.NOT_INITIALIZED, "Unity Ads is not initialized");
        } else {
            UnityAdsError unityAdsError = UnityAdsError.SHOW_ERROR;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Placement \"");
            sb2.append(str);
            sb2.append("\" is not ready");
            handleShowError(str, unityAdsError, sb2.toString());
        }
    }

    /* access modifiers changed from: private */
    public static void handleShowError(final String str, final UnityAdsError unityAdsError, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("Unity Ads show failed: ");
        sb.append(str2);
        final String sb2 = sb.toString();
        DeviceLog.error(sb2);
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                for (IUnityAdsListener iUnityAdsListener : AdsProperties.getListeners()) {
                    iUnityAdsListener.onUnityAdsError(unityAdsError, sb2);
                    String str = str;
                    if (str != null) {
                        iUnityAdsListener.onUnityAdsFinish(str, FinishState.ERROR);
                    } else {
                        iUnityAdsListener.onUnityAdsFinish("", FinishState.ERROR);
                    }
                }
            }
        });
    }

    public static void setDebugMode(boolean z) {
        UnityServices.setDebugMode(z);
    }

    public static boolean getDebugMode() {
        return UnityServices.getDebugMode();
    }

    public static String getDefaultPlacement() {
        return Placement.getDefaultPlacement();
    }

    public static void load(String str) {
        LoadModule.getInstance().load(str);
    }
}
