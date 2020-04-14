package com.unity3d.services.core.webview;

import android.os.Build.VERSION;
import android.os.ConditionVariable;
import android.os.Looper;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.unity3d.services.ads.api.AdUnit;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.InitializeThread;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.misc.ViewUtilities;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.webview.bridge.CallbackStatus;
import com.unity3d.services.core.webview.bridge.Invocation;
import com.unity3d.services.core.webview.bridge.NativeCallback;
import com.unity3d.services.core.webview.bridge.WebViewBridge;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;

public class WebViewApp {
    private static final int INVOKE_JS_CHARS_LENGTH = 22;
    /* access modifiers changed from: private */
    public static ConditionVariable _conditionVariable;
    private static WebViewApp _currentApp;
    private Configuration _configuration;
    private boolean _initialized;
    private HashMap<String, NativeCallback> _nativeCallbacks;
    private boolean _webAppLoaded;
    private WebView _webView;

    private class WebAppChromeClient extends WebChromeClient {
        private WebAppChromeClient() {
        }

        public void onConsoleMessage(String str, int i, String str2) {
            File file;
            try {
                file = new File(str2);
            } catch (Exception e) {
                DeviceLog.exception("Could not handle sourceId", e);
                file = null;
            }
            if (file != null) {
                str2 = file.getName();
            }
            if (VERSION.SDK_INT < 19) {
                StringBuilder sb = new StringBuilder();
                sb.append("JavaScript (sourceId=");
                sb.append(str2);
                sb.append(", line=");
                sb.append(i);
                sb.append("): ");
                sb.append(str);
                DeviceLog.debug(sb.toString());
            }
        }
    }

    private class WebAppClient extends WebViewClient {
        private WebAppClient() {
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    if (AdUnit.getAdUnitActivity() != null) {
                        AdUnit.getAdUnitActivity().finish();
                    }
                    if (!(WebViewApp.getCurrentApp() == null || WebViewApp.getCurrentApp().getWebView() == null)) {
                        ViewUtilities.removeViewFromParent(WebViewApp.getCurrentApp().getWebView());
                    }
                    InitializeThread.reset();
                }
            });
            StringBuilder sb = new StringBuilder();
            sb.append("UnityAds Sdk WebView onRenderProcessGone : ");
            sb.append(renderProcessGoneDetail.toString());
            DeviceLog.error(sb.toString());
            return true;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            StringBuilder sb = new StringBuilder();
            sb.append("onPageFinished url: ");
            sb.append(str);
            DeviceLog.debug(sb.toString());
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("Trying to load url: ");
            sb.append(str);
            DeviceLog.debug(sb.toString());
            return false;
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            String str = "WEBVIEW_ERROR: ";
            if (webView != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(webView.toString());
                DeviceLog.error(sb.toString());
            }
            if (webResourceRequest != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(webResourceRequest.toString());
                DeviceLog.error(sb2.toString());
            }
            if (webResourceError != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(webResourceError.toString());
                DeviceLog.error(sb3.toString());
            }
        }
    }

    private WebViewApp(Configuration configuration) {
        this._webAppLoaded = false;
        this._initialized = false;
        setConfiguration(configuration);
        WebViewBridge.setClassTable(getConfiguration().getWebAppApiClassList());
        this._webView = new WebView(ClientProperties.getApplicationContext());
        this._webView.setWebViewClient(new WebAppClient());
        this._webView.setWebChromeClient(new WebAppChromeClient());
    }

    public WebViewApp() {
        this._webAppLoaded = false;
        this._initialized = false;
    }

    public void setWebAppLoaded(boolean z) {
        this._webAppLoaded = z;
    }

    public boolean isWebAppLoaded() {
        return this._webAppLoaded;
    }

    public void setWebAppInitialized(boolean z) {
        this._initialized = z;
        _conditionVariable.open();
    }

    public boolean isWebAppInitialized() {
        return this._initialized;
    }

    public WebView getWebView() {
        return this._webView;
    }

    public void setWebView(WebView webView) {
        this._webView = webView;
    }

    public Configuration getConfiguration() {
        return this._configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this._configuration = configuration;
    }

    private void invokeJavascriptMethod(String str, String str2, JSONArray jSONArray) throws JSONException {
        String jSONArray2 = jSONArray.toString();
        StringBuilder sb = new StringBuilder(str.length() + 22 + str2.length() + jSONArray2.length());
        sb.append("javascript:window.");
        sb.append(str);
        sb.append(".");
        sb.append(str2);
        sb.append("(");
        sb.append(jSONArray2);
        sb.append(");");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Invoking javascript: ");
        sb3.append(sb2);
        DeviceLog.debug(sb3.toString());
        getWebView().invokeJavascript(sb2);
    }

    public boolean sendEvent(Enum enumR, Enum enumR2, Object... objArr) {
        if (!isWebAppLoaded()) {
            DeviceLog.debug("sendEvent ignored because web app is not loaded");
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(enumR.name());
        jSONArray.put(enumR2.name());
        for (Object put : objArr) {
            jSONArray.put(put);
        }
        try {
            invokeJavascriptMethod("nativebridge", "handleEvent", jSONArray);
            return true;
        } catch (Exception e) {
            DeviceLog.exception("Error while sending event to WebView", e);
            return false;
        }
    }

    public boolean invokeMethod(String str, String str2, Method method, Object... objArr) {
        if (!isWebAppLoaded()) {
            DeviceLog.debug("invokeMethod ignored because web app is not loaded");
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(str);
        jSONArray.put(str2);
        if (method != null) {
            NativeCallback nativeCallback = new NativeCallback(method);
            addCallback(nativeCallback);
            jSONArray.put(nativeCallback.getId());
        } else {
            jSONArray.put(null);
        }
        if (objArr != null) {
            for (Object put : objArr) {
                jSONArray.put(put);
            }
        }
        try {
            invokeJavascriptMethod("nativebridge", "handleInvocation", jSONArray);
            return true;
        } catch (Exception e) {
            DeviceLog.exception("Error invoking javascript method", e);
            return false;
        }
    }

    public boolean invokeCallback(Invocation invocation) {
        if (!isWebAppLoaded()) {
            DeviceLog.debug("invokeBatchCallback ignored because web app is not loaded");
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        ArrayList responses = invocation.getResponses();
        if (responses != null && !responses.isEmpty()) {
            Iterator it = responses.iterator();
            while (it.hasNext()) {
                ArrayList arrayList = (ArrayList) it.next();
                CallbackStatus callbackStatus = (CallbackStatus) arrayList.get(0);
                Enum enumR = (Enum) arrayList.get(1);
                Object[] objArr = (Object[]) arrayList.get(2);
                String str = (String) objArr[0];
                Object[] copyOfRange = Arrays.copyOfRange(objArr, 1, objArr.length);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str);
                arrayList2.add(callbackStatus.toString());
                JSONArray jSONArray2 = new JSONArray();
                if (enumR != null) {
                    jSONArray2.put(enumR.name());
                }
                for (Object put : copyOfRange) {
                    jSONArray2.put(put);
                }
                arrayList2.add(jSONArray2);
                JSONArray jSONArray3 = new JSONArray();
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    jSONArray3.put(it2.next());
                }
                jSONArray.put(jSONArray3);
            }
        }
        try {
            invokeJavascriptMethod("nativebridge", "handleCallback", jSONArray);
        } catch (Exception e) {
            DeviceLog.exception("Error while invoking batch response for WebView", e);
        }
        return true;
    }

    public void addCallback(NativeCallback nativeCallback) {
        if (this._nativeCallbacks == null) {
            this._nativeCallbacks = new HashMap<>();
        }
        synchronized (this._nativeCallbacks) {
            this._nativeCallbacks.put(nativeCallback.getId(), nativeCallback);
        }
    }

    public void removeCallback(NativeCallback nativeCallback) {
        HashMap<String, NativeCallback> hashMap = this._nativeCallbacks;
        if (hashMap != null) {
            synchronized (hashMap) {
                this._nativeCallbacks.remove(nativeCallback.getId());
            }
        }
    }

    public NativeCallback getCallback(String str) {
        NativeCallback nativeCallback;
        synchronized (this._nativeCallbacks) {
            nativeCallback = (NativeCallback) this._nativeCallbacks.get(str);
        }
        return nativeCallback;
    }

    public static WebViewApp getCurrentApp() {
        return _currentApp;
    }

    public static void setCurrentApp(WebViewApp webViewApp) {
        _currentApp = webViewApp;
    }

    public static boolean create(final Configuration configuration) throws IllegalThreadStateException {
        DeviceLog.entered();
        if (!Thread.currentThread().equals(Looper.getMainLooper().getThread())) {
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    String str = "UTF-8";
                    try {
                        WebViewApp webViewApp = new WebViewApp(configuration);
                        String str2 = "?platform=android";
                        try {
                            if (configuration.getWebViewUrl() != null) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(str2);
                                sb.append("&origin=");
                                sb.append(URLEncoder.encode(configuration.getWebViewUrl(), str));
                                str2 = sb.toString();
                            }
                        } catch (UnsupportedEncodingException e) {
                            DeviceLog.exception("Unsupported charset when encoding origin url", e);
                        }
                        try {
                            if (configuration.getWebViewVersion() != null) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(str2);
                                sb2.append("&version=");
                                sb2.append(URLEncoder.encode(configuration.getWebViewVersion(), str));
                                str2 = sb2.toString();
                            }
                        } catch (UnsupportedEncodingException e2) {
                            DeviceLog.exception("Unsupported charset when encoding webview version", e2);
                        }
                        WebView webView = webViewApp.getWebView();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("file://");
                        sb3.append(SdkProperties.getLocalWebViewFile());
                        sb3.append(str2);
                        webView.loadDataWithBaseURL(sb3.toString(), configuration.getWebViewData(), "text/html", "UTF-8", null);
                        WebViewApp.setCurrentApp(webViewApp);
                    } catch (Exception unused) {
                        DeviceLog.error("Couldn't construct WebViewApp");
                        WebViewApp._conditionVariable.open();
                    }
                }
            });
            _conditionVariable = new ConditionVariable();
            return _conditionVariable.block(60000) && getCurrentApp() != null;
        }
        throw new IllegalThreadStateException("Cannot call create() from main thread!");
    }
}
