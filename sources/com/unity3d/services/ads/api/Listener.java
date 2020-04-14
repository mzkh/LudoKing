package com.unity3d.services.ads.api;

import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds.FinishState;
import com.unity3d.ads.UnityAds.PlacementState;
import com.unity3d.ads.UnityAds.UnityAdsError;
import com.unity3d.ads.mediation.IUnityAdsExtendedListener;
import com.unity3d.ads.properties.AdsProperties;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;

public class Listener {
    @WebViewExposed
    public static void sendReadyEvent(final String str, WebViewCallback webViewCallback) {
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                for (IUnityAdsListener onUnityAdsReady : AdsProperties.getListeners()) {
                    onUnityAdsReady.onUnityAdsReady(str);
                }
            }
        });
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void sendStartEvent(final String str, WebViewCallback webViewCallback) {
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                for (IUnityAdsListener onUnityAdsStart : AdsProperties.getListeners()) {
                    onUnityAdsStart.onUnityAdsStart(str);
                }
            }
        });
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void sendFinishEvent(final String str, final String str2, WebViewCallback webViewCallback) {
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                for (IUnityAdsListener onUnityAdsFinish : AdsProperties.getListeners()) {
                    onUnityAdsFinish.onUnityAdsFinish(str, FinishState.valueOf(str2));
                }
            }
        });
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void sendClickEvent(final String str, WebViewCallback webViewCallback) {
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                for (IUnityAdsListener iUnityAdsListener : AdsProperties.getListeners()) {
                    if (iUnityAdsListener instanceof IUnityAdsExtendedListener) {
                        ((IUnityAdsExtendedListener) iUnityAdsListener).onUnityAdsClick(str);
                    }
                }
            }
        });
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void sendPlacementStateChangedEvent(final String str, final String str2, final String str3, WebViewCallback webViewCallback) {
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                for (IUnityAdsListener iUnityAdsListener : AdsProperties.getListeners()) {
                    if (iUnityAdsListener instanceof IUnityAdsExtendedListener) {
                        ((IUnityAdsExtendedListener) iUnityAdsListener).onUnityAdsPlacementStateChanged(str, PlacementState.valueOf(str2), PlacementState.valueOf(str3));
                    }
                }
            }
        });
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void sendErrorEvent(final String str, final String str2, WebViewCallback webViewCallback) {
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                for (IUnityAdsListener iUnityAdsListener : AdsProperties.getListeners()) {
                    if (iUnityAdsListener instanceof IUnityAdsExtendedListener) {
                        iUnityAdsListener.onUnityAdsError(UnityAdsError.valueOf(str), str2);
                    }
                }
            }
        });
        webViewCallback.invoke(new Object[0]);
    }
}
