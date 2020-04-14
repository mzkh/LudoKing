package com.unity3d.services.ads.configuration;

import android.os.ConditionVariable;
import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds.UnityAdsError;
import com.unity3d.services.ads.adunit.VideoPlayerHandler;
import com.unity3d.services.ads.adunit.WebPlayerHandler;
import com.unity3d.services.ads.adunit.WebViewHandler;
import com.unity3d.services.ads.api.AdUnit;
import com.unity3d.services.ads.api.AdsProperties;
import com.unity3d.services.ads.api.Listener;
import com.unity3d.services.ads.api.Placement;
import com.unity3d.services.ads.api.Purchasing;
import com.unity3d.services.ads.api.VideoPlayer;
import com.unity3d.services.ads.api.WebPlayer;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AdsModuleConfiguration implements IAdsModuleConfiguration {
    /* access modifiers changed from: private */
    public InetAddress _address;

    public boolean initCompleteState(Configuration configuration) {
        return true;
    }

    public Class[] getWebAppApiClassList() {
        return new Class[]{AdUnit.class, Listener.class, VideoPlayer.class, Placement.class, WebPlayer.class, Purchasing.class, AdsProperties.class};
    }

    public boolean resetState(Configuration configuration) {
        com.unity3d.services.ads.placement.Placement.reset();
        return true;
    }

    public boolean initModuleState(Configuration configuration) {
        DeviceLog.debug("Unity Ads init: checking for ad blockers");
        try {
            final String host = new URL(configuration.getConfigUrl()).getHost();
            final ConditionVariable conditionVariable = new ConditionVariable();
            new Thread() {
                public void run() {
                    try {
                        AdsModuleConfiguration.this._address = InetAddress.getByName(host);
                        conditionVariable.open();
                    } catch (Exception e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Couldn't get address. Host: ");
                        sb.append(host);
                        DeviceLog.exception(sb.toString(), e);
                        conditionVariable.open();
                    }
                }
            }.start();
            if (conditionVariable.block(2000)) {
                InetAddress inetAddress = this._address;
                if (inetAddress != null && inetAddress.isLoopbackAddress()) {
                    DeviceLog.error("Unity Ads init: halting init because Unity Ads config resolves to loopback address (due to ad blocker?)");
                    Utilities.runOnUiThread(new Runnable() {
                        public void run() {
                            for (IUnityAdsListener onUnityAdsError : com.unity3d.ads.properties.AdsProperties.getListeners()) {
                                onUnityAdsError.onUnityAdsError(UnityAdsError.AD_BLOCKER_DETECTED, "Unity Ads config server resolves to loopback address (due to ad blocker?)");
                            }
                        }
                    });
                    return false;
                }
            }
        } catch (MalformedURLException unused) {
        }
        return true;
    }

    public boolean initErrorState(Configuration configuration, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("Init failed in ");
        sb.append(str);
        final String sb2 = sb.toString();
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                for (IUnityAdsListener onUnityAdsError : com.unity3d.ads.properties.AdsProperties.getListeners()) {
                    onUnityAdsError.onUnityAdsError(UnityAdsError.INITIALIZE_FAILED, sb2);
                }
            }
        });
        return true;
    }

    public Map<String, Class> getAdUnitViewHandlers() {
        HashMap hashMap = new HashMap();
        hashMap.put("videoplayer", VideoPlayerHandler.class);
        hashMap.put("webplayer", WebPlayerHandler.class);
        hashMap.put("webview", WebViewHandler.class);
        return hashMap;
    }
}
