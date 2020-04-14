package com.unity3d.services.ads.webplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.webkit.ClientCertRequest;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.misc.ViewUtilities;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebPlayerView extends WebView {
    private Map<String, String> _erroredSettings;
    /* access modifiers changed from: private */
    public Method _evaluateJavascript = null;
    private JSONObject _eventSettings;
    private Runnable _unsubscribeLayoutChange = null;
    /* access modifiers changed from: private */
    public String viewId;

    private class JavaScriptInvocation implements Runnable {
        private String _jsString = null;
        private WebView _webView = null;

        public JavaScriptInvocation(String str, WebView webView) {
            this._jsString = str;
            this._webView = webView;
        }

        public void run() {
            if (this._jsString != null) {
                try {
                    if (VERSION.SDK_INT >= 19) {
                        WebPlayerView.this._evaluateJavascript.invoke(this._webView, new Object[]{this._jsString, null});
                        return;
                    }
                    WebPlayerView.this.loadUrl(this._jsString);
                } catch (Exception e) {
                    DeviceLog.exception("Error while processing JavaScriptString", e);
                }
            } else {
                DeviceLog.error("Could not process JavaScript, the string is NULL");
            }
        }
    }

    @TargetApi(21)
    private class WebPlayerChromeClient extends WebChromeClient {
        private WebPlayerChromeClient() {
        }

        public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
            String str2 = "onGeolocationPermissionsShowPrompt";
            if (WebPlayerView.this.shouldCallSuper(str2)) {
                super.onGeolocationPermissionsShowPrompt(str, callback);
            }
            if (WebPlayerView.this.shouldSendEvent(str2)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.GEOLOCATION_PERMISSIONS_SHOW, str, WebPlayerView.this.viewId);
            }
        }

        public void onPermissionRequest(PermissionRequest permissionRequest) {
            String str = "onPermissionRequest";
            if (WebPlayerView.this.shouldCallSuper(str)) {
                super.onPermissionRequest(permissionRequest);
            }
            if (WebPlayerView.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.PERMISSION_REQUEST, (permissionRequest == null || permissionRequest.getOrigin() == null) ? "" : permissionRequest.getOrigin().toString(), WebPlayerView.this.viewId);
            }
        }

        public void onProgressChanged(WebView webView, int i) {
            String str = "onProgressChanged";
            if (WebPlayerView.this.shouldCallSuper(str)) {
                super.onProgressChanged(webView, i);
            }
            if (WebPlayerView.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.PROGRESS_CHANGED, Integer.valueOf(i), WebPlayerView.this.viewId);
            }
        }

        public void onReceivedTitle(WebView webView, String str) {
            String str2 = "onReceivedTitle";
            if (WebPlayerView.this.shouldCallSuper(str2)) {
                super.onReceivedTitle(webView, str);
            }
            if (WebPlayerView.this.shouldSendEvent(str2)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.RECEIVED_TITLE, str, WebPlayerView.this.viewId);
            }
        }

        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            String str = "onReceivedIcon";
            if (WebPlayerView.this.shouldCallSuper(str)) {
                super.onReceivedIcon(webView, bitmap);
            }
            if (WebPlayerView.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.RECEIVED_ICON, WebPlayerView.this.viewId);
            }
        }

        public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
            String str2 = "onReceivedTouchIconUrl";
            if (WebPlayerView.this.shouldCallSuper(str2)) {
                super.onReceivedTouchIconUrl(webView, str, z);
            }
            if (WebPlayerView.this.shouldSendEvent(str2)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.RECEIVED_TOUCH_ICON_URL, str, Boolean.valueOf(z), WebPlayerView.this.viewId);
            }
        }

        public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
            String str = "onShowCustomView";
            if (WebPlayerView.this.shouldCallSuper(str)) {
                super.onShowCustomView(view, customViewCallback);
            }
            if (WebPlayerView.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SHOW_CUSTOM_VIEW, WebPlayerView.this.viewId);
            }
        }

        public void onHideCustomView() {
            String str = "onHideCustomView";
            if (WebPlayerView.this.shouldCallSuper(str)) {
                super.onHideCustomView();
            }
            if (WebPlayerView.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.HIDE_CUSTOM_VIEW, WebPlayerView.this.viewId);
            }
        }

        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            Boolean valueOf = Boolean.valueOf(false);
            String str = "onCreateWindow";
            Boolean valueOf2 = WebPlayerView.this.shouldCallSuper(str) ? Boolean.valueOf(super.onCreateWindow(webView, z, z2, message)) : valueOf;
            if (WebPlayerView.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.CREATE_WINDOW, Boolean.valueOf(z), Boolean.valueOf(z2), message, WebPlayerView.this.viewId);
            }
            if (WebPlayerView.this.hasReturnValue(str)) {
                valueOf2 = (Boolean) WebPlayerView.this.getReturnValue(str, Boolean.class, valueOf);
            }
            return valueOf2.booleanValue();
        }

        public void onRequestFocus(WebView webView) {
            String str = "onRequestFocus";
            if (WebPlayerView.this.shouldCallSuper(str)) {
                super.onRequestFocus(webView);
            }
            if (WebPlayerView.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.REQUEST_FOCUS, WebPlayerView.this.viewId);
            }
        }

        public void onCloseWindow(WebView webView) {
            String str = "onCloseWindow";
            if (WebPlayerView.this.shouldCallSuper(str)) {
                super.onCloseWindow(webView);
            }
            if (WebPlayerView.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.CLOSE_WINDOW, WebPlayerView.this.viewId);
            }
        }

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            Boolean valueOf = Boolean.valueOf(false);
            String str3 = "onJsAlert";
            if (WebPlayerView.this.shouldCallSuper(str3)) {
                valueOf = Boolean.valueOf(super.onJsAlert(webView, str, str2, jsResult));
            }
            if (WebPlayerView.this.shouldSendEvent(str3)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.JS_ALERT, str, str2, jsResult, WebPlayerView.this.viewId);
            }
            if (WebPlayerView.this.hasReturnValue(str3)) {
                valueOf = (Boolean) WebPlayerView.this.getReturnValue(str3, Boolean.class, Boolean.valueOf(true));
            }
            return valueOf.booleanValue();
        }

        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            Boolean valueOf = Boolean.valueOf(false);
            String str3 = "onJsConfirm";
            if (WebPlayerView.this.shouldCallSuper(str3)) {
                valueOf = Boolean.valueOf(super.onJsConfirm(webView, str, str2, jsResult));
            }
            if (WebPlayerView.this.shouldSendEvent(str3)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.JS_CONFIRM, str, str2, WebPlayerView.this.viewId);
            }
            if (WebPlayerView.this.hasReturnValue(str3)) {
                valueOf = (Boolean) WebPlayerView.this.getReturnValue(str3, Boolean.class, Boolean.valueOf(true));
            }
            return valueOf.booleanValue();
        }

        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            Boolean valueOf = Boolean.valueOf(false);
            String str4 = "onJsPrompt";
            if (WebPlayerView.this.shouldCallSuper(str4)) {
                valueOf = Boolean.valueOf(super.onJsPrompt(webView, str, str2, str3, jsPromptResult));
            }
            if (WebPlayerView.this.shouldSendEvent(str4)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.JS_PROMPT, str, str2, str3, WebPlayerView.this.viewId);
            }
            if (WebPlayerView.this.hasReturnValue(str4)) {
                valueOf = (Boolean) WebPlayerView.this.getReturnValue(str4, Boolean.class, Boolean.valueOf(true));
            }
            return valueOf.booleanValue();
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            Boolean valueOf = Boolean.valueOf(false);
            String str = "onConsoleMessage";
            if (WebPlayerView.this.shouldCallSuper(str)) {
                valueOf = Boolean.valueOf(super.onConsoleMessage(consoleMessage));
            }
            if (WebPlayerView.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.CONSOLE_MESSAGE, consoleMessage != null ? consoleMessage.message() : "", WebPlayerView.this.viewId);
            }
            if (WebPlayerView.this.hasReturnValue(str)) {
                valueOf = (Boolean) WebPlayerView.this.getReturnValue(str, Boolean.class, Boolean.valueOf(true));
            }
            return valueOf.booleanValue();
        }

        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
            Boolean valueOf = Boolean.valueOf(false);
            String str = "onShowFileChooser";
            if (WebPlayerView.this.shouldCallSuper(str)) {
                valueOf = Boolean.valueOf(super.onShowFileChooser(webView, valueCallback, fileChooserParams));
            }
            if (WebPlayerView.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SHOW_FILE_CHOOSER, WebPlayerView.this.viewId);
            }
            if (WebPlayerView.this.hasReturnValue(str)) {
                valueOf = (Boolean) WebPlayerView.this.getReturnValue(str, Boolean.class, Boolean.valueOf(true));
                if (valueOf.booleanValue()) {
                    valueCallback.onReceiveValue(null);
                }
            }
            return valueOf.booleanValue();
        }
    }

    private class WebPlayerClient extends WebViewClient {
        private WebPlayerClient() {
        }

        public boolean onRenderProcessGone(final WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    ViewUtilities.removeViewFromParent(webView);
                    webView.destroy();
                }
            });
            String access$400 = WebPlayerView.this.viewId;
            String url = WebPlayerView.this.getUrl();
            StringBuilder sb = new StringBuilder();
            String str = "UnityAds Sdk WebPlayer onRenderProcessGone : ";
            sb.append(str);
            sb.append(renderProcessGoneDetail.toString());
            WebPlayerEventBridge.error(access$400, url, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(renderProcessGoneDetail.toString());
            DeviceLog.error(sb2.toString());
            return true;
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            String str2 = "onPageStarted";
            if (WebPlayerView.this.shouldCallSuper(str2)) {
                super.onPageStarted(webView, str, bitmap);
            }
            if (WebPlayerView.this.shouldSendEvent(str2)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.PAGE_STARTED, str, WebPlayerView.this.viewId);
            }
        }

        public void onPageFinished(WebView webView, String str) {
            String str2 = "onPageFinished";
            if (WebPlayerView.this.shouldCallSuper(str2)) {
                super.onPageFinished(webView, str);
            }
            if (WebPlayerView.this.shouldSendEvent(str2)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.PAGE_FINISHED, str, WebPlayerView.this.viewId);
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            String str3 = "onReceivedError";
            if (WebPlayerView.this.shouldCallSuper(str3)) {
                super.onReceivedError(webView, i, str, str2);
            }
            if (WebPlayerView.this.shouldSendEvent(str3)) {
                WebPlayerEventBridge.error(WebPlayerView.this.viewId, str2, str);
            }
        }

        @TargetApi(25)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            String str = "onReceivedError";
            if (WebPlayerView.this.shouldCallSuper(str)) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
            if (WebPlayerView.this.shouldSendEvent(str)) {
                String str2 = "";
                String charSequence = (webResourceError == null || webResourceError.getDescription() == null) ? str2 : webResourceError.getDescription().toString();
                if (!(webResourceRequest == null || webResourceRequest.getUrl() == null)) {
                    str2 = webResourceRequest.getUrl().toString();
                }
                WebPlayerEventBridge.error(WebPlayerView.this.viewId, str2, charSequence);
            }
        }

        public void onLoadResource(WebView webView, String str) {
            String str2 = "onLoadResource";
            if (WebPlayerView.this.shouldCallSuper(str2)) {
                super.onLoadResource(webView, str);
            }
            if (WebPlayerView.this.shouldSendEvent(str2)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.LOAD_RESOUCE, str, WebPlayerView.this.viewId);
            }
        }

        @TargetApi(14)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String str = "onReceivedSslError";
            if (WebPlayerView.this.shouldCallSuper(str)) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
            if (WebPlayerView.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SSL_ERROR, sslError != null ? sslError.getUrl() : "", WebPlayerView.this.viewId);
            }
        }

        @TargetApi(21)
        public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            int i;
            String str;
            String str2 = "onReceivedClientCertRequest";
            if (WebPlayerView.this.shouldCallSuper(str2)) {
                super.onReceivedClientCertRequest(webView, clientCertRequest);
            }
            if (WebPlayerView.this.shouldSendEvent(str2)) {
                if (clientCertRequest != null) {
                    str = clientCertRequest.getHost();
                    i = clientCertRequest.getPort();
                } else {
                    str = "";
                    i = -1;
                }
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.CLIENT_CERT_REQUEST, str, Integer.valueOf(i), WebPlayerView.this.viewId);
            }
        }

        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            String str3 = "onReceivedHttpAuthRequest";
            if (WebPlayerView.this.shouldCallSuper(str3)) {
                super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
            if (WebPlayerView.this.shouldSendEvent(str3)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.HTTP_AUTH_REQUEST, str, str2, WebPlayerView.this.viewId);
            }
        }

        public void onScaleChanged(WebView webView, float f, float f2) {
            String str = "onScaleChanged";
            if (WebPlayerView.this.shouldCallSuper(str)) {
                super.onScaleChanged(webView, f, f2);
            }
            if (WebPlayerView.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SCALE_CHANGED, Float.valueOf(f), Float.valueOf(f2), WebPlayerView.this.viewId);
            }
        }

        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            String str4 = "onReceivedLoginRequest";
            if (WebPlayerView.this.shouldCallSuper(str4)) {
                super.onReceivedLoginRequest(webView, str, str2, str3);
            }
            if (WebPlayerView.this.shouldSendEvent(str4)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.LOGIN_REQUEST, str, str2, str3, WebPlayerView.this.viewId);
            }
        }

        @TargetApi(21)
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            String str = "onReceivedHttpError";
            if (WebPlayerView.this.shouldCallSuper(str)) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
            if (WebPlayerView.this.shouldSendEvent(str)) {
                String str2 = "";
                String uri = (webResourceRequest == null || webResourceRequest.getUrl() == null) ? str2 : webResourceRequest.getUrl().toString();
                int i = -1;
                if (webResourceResponse != null) {
                    i = webResourceResponse.getStatusCode();
                    str2 = webResourceResponse.getReasonPhrase();
                }
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.HTTP_ERROR, uri, str2, Integer.valueOf(i), WebPlayerView.this.viewId);
            }
        }

        @TargetApi(21)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            Boolean valueOf = Boolean.valueOf(false);
            String str = "shouldOverrideUrlLoading";
            if (WebPlayerView.this.shouldCallSuper(str)) {
                valueOf = Boolean.valueOf(super.shouldOverrideUrlLoading(webView, webResourceRequest));
            }
            if (WebPlayerView.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SHOULD_OVERRIDE_URL_LOADING, webResourceRequest.getUrl().toString(), webResourceRequest.getMethod(), WebPlayerView.this.viewId);
            }
            if (WebPlayerView.this.hasReturnValue(str)) {
                valueOf = (Boolean) WebPlayerView.this.getReturnValue(str, Boolean.class, Boolean.valueOf(true));
            }
            return valueOf.booleanValue();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Boolean valueOf = Boolean.valueOf(false);
            String str2 = "shouldOverrideUrlLoading";
            if (WebPlayerView.this.shouldCallSuper(str2)) {
                valueOf = Boolean.valueOf(super.shouldOverrideUrlLoading(webView, str));
            }
            if (WebPlayerView.this.shouldSendEvent(str2)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SHOULD_OVERRIDE_URL_LOADING, str, WebPlayerView.this.viewId);
            }
            if (WebPlayerView.this.hasReturnValue(str2)) {
                valueOf = (Boolean) WebPlayerView.this.getReturnValue(str2, Boolean.class, Boolean.valueOf(true));
            }
            return valueOf.booleanValue();
        }

        public void onPageCommitVisible(WebView webView, String str) {
            String str2 = "onPageCommitVisible";
            if (WebPlayerView.this.shouldCallSuper(str2)) {
                super.onPageCommitVisible(webView, str);
            }
            if (WebPlayerView.this.shouldSendEvent(str2)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.PAGE_COMMIT_VISIBLE, str, WebPlayerView.this.viewId);
            }
        }

        @TargetApi(21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            String str = "shouldInterceptRequest";
            WebResourceResponse shouldInterceptRequest = WebPlayerView.this.shouldCallSuper(str) ? super.shouldInterceptRequest(webView, webResourceRequest) : null;
            if (WebPlayerView.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SHOULD_INTERCEPT_REQUEST, webResourceRequest.getUrl().toString(), WebPlayerView.this.viewId);
            }
            return shouldInterceptRequest;
        }

        public void onFormResubmission(WebView webView, Message message, Message message2) {
            String str = "onFormResubmission";
            if (WebPlayerView.this.shouldCallSuper(str)) {
                super.onFormResubmission(webView, message, message2);
            }
            if (WebPlayerView.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.FORM_RESUBMISSION, WebPlayerView.this.viewId);
            }
        }

        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            Boolean valueOf = Boolean.valueOf(false);
            String str = "shouldOverrideKeyEvent";
            if (WebPlayerView.this.shouldCallSuper(str)) {
                valueOf = Boolean.valueOf(super.shouldOverrideKeyEvent(webView, keyEvent));
            }
            if (WebPlayerView.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SHOULD_OVERRIDE_KEY_EVENT, Integer.valueOf(keyEvent.getKeyCode()), Integer.valueOf(keyEvent.getAction()), WebPlayerView.this.viewId);
            }
            if (WebPlayerView.this.hasReturnValue(str)) {
                valueOf = (Boolean) WebPlayerView.this.getReturnValue(str, Boolean.class, Boolean.valueOf(true));
            }
            return valueOf.booleanValue();
        }

        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            String str = "onUnhandledKeyEvent";
            if (WebPlayerView.this.shouldCallSuper(str)) {
                super.onUnhandledKeyEvent(webView, keyEvent);
            }
            if (WebPlayerView.this.shouldSendEvent(str)) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.UNHANDLED_KEY_EVENT, Integer.valueOf(keyEvent.getKeyCode()), Integer.valueOf(keyEvent.getAction()), WebPlayerView.this.viewId);
            }
        }
    }

    private class WebPlayerDownloadListener implements DownloadListener {
        private WebPlayerDownloadListener() {
        }

        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (WebPlayerView.this.shouldSendEvent("onDownloadStart")) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.DOWNLOAD_START, str, str2, str3, str4, Long.valueOf(j), WebPlayerView.this.viewId);
            }
        }
    }

    public WebPlayerView(Context context, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        super(context);
        this.viewId = str;
        WebSettings settings = getSettings();
        if (VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        if (VERSION.SDK_INT >= 19) {
            try {
                this._evaluateJavascript = WebView.class.getMethod("evaluateJavascript", new Class[]{String.class, ValueCallback.class});
            } catch (NoSuchMethodException e) {
                DeviceLog.exception("Method evaluateJavascript not found", e);
                this._evaluateJavascript = null;
            }
        }
        settings.setAppCacheEnabled(false);
        settings.setCacheMode(2);
        settings.setDatabaseEnabled(false);
        settings.setDomStorageEnabled(false);
        settings.setGeolocationEnabled(false);
        settings.setJavaScriptEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setPluginState(PluginState.OFF);
        settings.setRenderPriority(RenderPriority.NORMAL);
        settings.setSaveFormData(false);
        settings.setSavePassword(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setInitialScale(0);
        setBackgroundColor(0);
        ViewUtilities.setBackground(this, new ColorDrawable(0));
        setBackgroundResource(0);
        setSettings(jSONObject, jSONObject2);
        setWebViewClient(new WebPlayerClient());
        setWebChromeClient(new WebPlayerChromeClient());
        setDownloadListener(new WebPlayerDownloadListener());
        addJavascriptInterface(new WebPlayerBridgeInterface(str), "webplayerbridge");
        WebPlayerViewCache.getInstance().addWebPlayer(str, this);
        subscribeOnLayoutChange();
    }

    private void subscribeOnLayoutChange() {
        Runnable runnable = this._unsubscribeLayoutChange;
        if (runnable != null) {
            runnable.run();
        }
        if (VERSION.SDK_INT >= 11) {
            final C34101 r0 = new OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    WebPlayerView.this.onLayoutChange();
                }
            };
            addOnLayoutChangeListener(r0);
            this._unsubscribeLayoutChange = new Runnable() {
                public void run() {
                    WebPlayerView.this.removeOnLayoutChangeListener(r0);
                }
            };
        }
    }

    public void destroy() {
        super.destroy();
        WebPlayerViewCache.getInstance().removeWebPlayer(this.viewId);
        Runnable runnable = this._unsubscribeLayoutChange;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void setEventSettings(JSONObject jSONObject) {
        this._eventSettings = jSONObject;
    }

    public void setSettings(JSONObject jSONObject, JSONObject jSONObject2) {
        Map<String, String> map = this._erroredSettings;
        if (map != null) {
            map.clear();
        }
        setTargetSettings(getSettings(), jSONObject);
        setTargetSettings(this, jSONObject2);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        onLayoutChange();
    }

    public void onLayoutChange() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        WebPlayerEventBridge.sendFrameUpdate(this.viewId, iArr[0], iArr[1], getWidth(), getHeight(), VERSION.SDK_INT >= 11 ? getAlpha() : 1.0f);
    }

    public Map<String, String> getErroredSettings() {
        return this._erroredSettings;
    }

    private Object setTargetSettings(Object obj, JSONObject jSONObject) {
        if (jSONObject != null) {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    obj.getClass().getMethod(str, getTypes(jSONArray)).invoke(obj, getValues(jSONArray));
                } catch (Exception e) {
                    addErroredSetting(str, e.getMessage());
                    DeviceLog.exception("Setting errored", e);
                }
            }
        }
        return obj;
    }

    public void invokeJavascript(String str) {
        Utilities.runOnUiThread(new JavaScriptInvocation(str, this));
    }

    public void sendEvent(JSONArray jSONArray) {
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:window.nativebridge.receiveEvent(");
        sb.append(jSONArray.toString());
        sb.append(")");
        invokeJavascript(sb.toString());
    }

    private Class<?>[] getTypes(JSONArray jSONArray) throws JSONException, ClassNotFoundException {
        if (jSONArray == null) {
            return null;
        }
        Class<?>[] clsArr = new Class[jSONArray.length()];
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                if (jSONArray.get(i) instanceof JSONObject) {
                    Class<?> cls = Class.forName(((JSONObject) jSONArray.get(i)).getString("className"));
                    if (cls != null) {
                        clsArr[i] = cls;
                    }
                } else {
                    clsArr[i] = getPrimitiveClass(jSONArray.get(i).getClass());
                }
            }
        }
        return clsArr;
    }

    public Class<?> getPrimitiveClass(Class<?> cls) {
        String name = cls.getName();
        if (name.equals("java.lang.Byte")) {
            return Byte.TYPE;
        }
        if (name.equals("java.lang.Short")) {
            return Short.TYPE;
        }
        if (name.equals("java.lang.Integer")) {
            return Integer.TYPE;
        }
        if (name.equals("java.lang.Long")) {
            return Long.TYPE;
        }
        if (name.equals("java.lang.Character")) {
            return Character.TYPE;
        }
        if (name.equals("java.lang.Float")) {
            return Float.TYPE;
        }
        if (name.equals("java.lang.Double")) {
            return Double.TYPE;
        }
        if (name.equals("java.lang.Boolean")) {
            return Boolean.TYPE;
        }
        if (name.equals("java.lang.Void")) {
            cls = Void.TYPE;
        }
        return cls;
    }

    private Object[] getValues(JSONArray jSONArray) throws JSONException, ClassNotFoundException, NoSuchMethodException {
        if (jSONArray == null) {
            return null;
        }
        Object[] objArr = new Object[jSONArray.length()];
        Object[] objArr2 = new Object[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            if (jSONArray.get(i) instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                Object obj = jSONObject.get("value");
                String string = jSONObject.getString("type");
                String str = "className";
                String string2 = jSONObject.has(str) ? jSONObject.getString(str) : null;
                if (string2 != null && string.equals("Enum")) {
                    Class cls = Class.forName(string2);
                    if (cls != null) {
                        objArr2[i] = Enum.valueOf(cls, (String) obj);
                    }
                }
            } else {
                objArr2[i] = jSONArray.get(i);
            }
        }
        if (jSONArray != null) {
            System.arraycopy(objArr2, 0, objArr, 0, jSONArray.length());
        }
        return objArr;
    }

    private void addErroredSetting(String str, String str2) {
        if (this._erroredSettings == null) {
            this._erroredSettings = new HashMap();
        }
        this._erroredSettings.put(str, str2);
    }

    /* access modifiers changed from: private */
    public boolean shouldCallSuper(String str) {
        String str2 = "callSuper";
        try {
            if (this._eventSettings != null && this._eventSettings.has(str) && this._eventSettings.getJSONObject(str).has(str2)) {
                return this._eventSettings.getJSONObject(str).getBoolean(str2);
            }
        } catch (Exception e) {
            DeviceLog.exception("Error getting super call status", e);
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean shouldSendEvent(String str) {
        String str2 = "sendEvent";
        try {
            if (this._eventSettings != null && this._eventSettings.has(str) && this._eventSettings.getJSONObject(str).has(str2)) {
                return this._eventSettings.getJSONObject(str).getBoolean(str2);
            }
        } catch (Exception e) {
            DeviceLog.exception("Error getting send event status", e);
        }
        return false;
    }

    /* access modifiers changed from: private */
    public <T> T getReturnValue(String str, Class<T> cls, T t) {
        String str2 = "returnValue";
        try {
            if (this._eventSettings != null && this._eventSettings.has(str) && this._eventSettings.getJSONObject(str).has(str2)) {
                return cls.cast(this._eventSettings.getJSONObject(str).get(str2));
            }
        } catch (Exception e) {
            DeviceLog.exception("Error getting default return value", e);
        }
        return t;
    }

    /* access modifiers changed from: private */
    public boolean hasReturnValue(String str) {
        try {
            if (this._eventSettings != null && this._eventSettings.has(str) && this._eventSettings.getJSONObject(str).has("returnValue")) {
                return true;
            }
        } catch (Exception e) {
            DeviceLog.exception("Error getting default return value", e);
        }
        return false;
    }
}
