package com.unity3d.services.core.api;

import com.unity3d.services.core.configuration.InitializationNotificationCenter;
import com.unity3d.services.core.configuration.InitializeThread;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;

public class Sdk {
    @WebViewExposed
    public static void loadComplete(WebViewCallback webViewCallback) {
        DeviceLog.debug("Web Application loaded");
        WebViewApp.getCurrentApp().setWebAppLoaded(true);
        webViewCallback.invoke(ClientProperties.getGameId(), Boolean.valueOf(SdkProperties.isTestMode()), ClientProperties.getAppName(), ClientProperties.getAppVersion(), Integer.valueOf(SdkProperties.getVersionCode()), SdkProperties.getVersionName(), Boolean.valueOf(ClientProperties.isAppDebuggable()), WebViewApp.getCurrentApp().getConfiguration().getConfigUrl(), WebViewApp.getCurrentApp().getConfiguration().getWebViewUrl(), WebViewApp.getCurrentApp().getConfiguration().getWebViewHash(), WebViewApp.getCurrentApp().getConfiguration().getWebViewVersion(), Long.valueOf(SdkProperties.getInitializationTime()), Boolean.valueOf(SdkProperties.isReinitialized()), Boolean.valueOf(SdkProperties.isPerPlacementLoadEnabled()));
    }

    @WebViewExposed
    public static void initComplete(WebViewCallback webViewCallback) {
        DeviceLog.debug("Web Application initialized");
        SdkProperties.setInitialized(true);
        WebViewApp.getCurrentApp().setWebAppInitialized(true);
        InitializationNotificationCenter.getInstance().triggerOnSdkInitialized();
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void initError(String str, int i, WebViewCallback webViewCallback) {
        InitializationNotificationCenter.getInstance().triggerOnSdkInitializationFailed(str, i);
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void setDebugMode(Boolean bool, WebViewCallback webViewCallback) {
        SdkProperties.setDebugMode(bool.booleanValue());
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void getDebugMode(WebViewCallback webViewCallback) {
        webViewCallback.invoke(Boolean.valueOf(SdkProperties.getDebugMode()));
    }

    @WebViewExposed
    public static void logError(String str, WebViewCallback webViewCallback) {
        DeviceLog.error(str);
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void logWarning(String str, WebViewCallback webViewCallback) {
        DeviceLog.warning(str);
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void logInfo(String str, WebViewCallback webViewCallback) {
        DeviceLog.info(str);
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void logDebug(String str, WebViewCallback webViewCallback) {
        DeviceLog.debug(str);
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void reinitialize(WebViewCallback webViewCallback) {
        SdkProperties.setReinitialized(true);
        InitializeThread.initialize(WebViewApp.getCurrentApp().getConfiguration());
    }
}
