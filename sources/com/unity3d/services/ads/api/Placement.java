package com.unity3d.services.ads.api;

import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;

public class Placement {
    @WebViewExposed
    public static void setDefaultPlacement(String str, WebViewCallback webViewCallback) {
        com.unity3d.services.ads.placement.Placement.setDefaultPlacement(str);
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void setPlacementState(String str, String str2, WebViewCallback webViewCallback) {
        com.unity3d.services.ads.placement.Placement.setPlacementState(str, str2);
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void setDefaultBannerPlacement(String str, WebViewCallback webViewCallback) {
        com.unity3d.services.ads.placement.Placement.setDefaultBannerPlacement(str);
        webViewCallback.invoke(new Object[0]);
    }
}
