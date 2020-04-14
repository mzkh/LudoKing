package com.unity3d.services.monetization.core.api;

import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;
import com.unity3d.services.monetization.IUnityMonetizationListener;
import com.unity3d.services.monetization.UnityMonetization.PlacementContentState;
import com.unity3d.services.monetization.core.placementcontent.PlacementContentListenerError;
import com.unity3d.services.monetization.core.placementcontent.PlacementContents;
import com.unity3d.services.monetization.core.properties.ClientProperties;

public class MonetizationListener {
    @WebViewExposed
    public static void isMonetizationEnabled(WebViewCallback webViewCallback) {
        webViewCallback.invoke(Boolean.valueOf(ClientProperties.isMonetizationEnabled()));
    }

    @WebViewExposed
    public static void sendPlacementContentReady(String str, WebViewCallback webViewCallback) {
        IUnityMonetizationListener listener = ClientProperties.getListener();
        if (listener != null) {
            try {
                listener.onPlacementContentReady(str, PlacementContents.getPlacementContent(str));
                webViewCallback.invoke(new Object[0]);
            } catch (Exception e) {
                webViewCallback.error(PlacementContentListenerError.PLACEMENTCONTENT_LISTENER_ERROR, e);
            }
        } else {
            webViewCallback.error(PlacementContentListenerError.PLACEMENTCONTENT_LISTENER_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void sendPlacementContentStateChanged(String str, String str2, String str3, WebViewCallback webViewCallback) {
        IUnityMonetizationListener listener = ClientProperties.getListener();
        if (listener != null) {
            try {
                listener.onPlacementContentStateChange(str, PlacementContents.getPlacementContent(str), PlacementContentState.valueOf(str2), PlacementContentState.valueOf(str3));
                webViewCallback.invoke(new Object[0]);
            } catch (Exception e) {
                webViewCallback.error(PlacementContentListenerError.PLACEMENTCONTENT_LISTENER_ERROR, e);
            }
        } else {
            webViewCallback.error(PlacementContentListenerError.PLACEMENTCONTENT_LISTENER_NULL, new Object[0]);
        }
    }
}
