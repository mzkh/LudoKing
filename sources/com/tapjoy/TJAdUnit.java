package com.tapjoy;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.VideoView;
import com.google.android.gms.drive.DriveFile;
import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.TJAdUnitJSBridge.AdUnitAsyncTaskListner;
import com.tapjoy.TapjoyErrorMessage.ErrorType;
import com.tapjoy.internal.C1823gf;
import com.tapjoy.internal.C1852jq;
import com.tapjoy.internal.C3071fm;
import com.tapjoy.internal.C3147hn;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.json.JSONObject;

public class TJAdUnit implements OnCompletionListener, OnErrorListener, OnInfoListener, OnPreparedListener {

    /* renamed from: a */
    public static TJVideoListener f3707a;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f3708A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public boolean f3709B;

    /* renamed from: C */
    private int f3710C = -1;

    /* renamed from: D */
    private int f3711D;

    /* renamed from: E */
    private int f3712E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public boolean f3713F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public boolean f3714G;

    /* renamed from: H */
    private C3071fm f3715H;

    /* renamed from: I */
    private final Runnable f3716I = new Runnable() {
        public final void run() {
            int streamVolume = TJAdUnit.this.f3736s.getStreamVolume(3);
            if (TJAdUnit.this.f3737t != streamVolume) {
                TJAdUnit.this.f3737t = streamVolume;
                TJAdUnit.this.f3719b.onVolumeChanged();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: J */
    public final Runnable f3717J = new Runnable() {
        public final void run() {
            if (TJAdUnit.this.f3722e.getCurrentPosition() != 0) {
                if (!TJAdUnit.this.f3733p) {
                    TJAdUnit.this.f3733p = true;
                }
                TJAdUnit.this.f3719b.onVideoStarted(TJAdUnit.this.f3731n);
                TJAdUnit.this.f3718K.run();
            } else if (!TJAdUnit.this.f3713F) {
                TJAdUnit.this.f3726i.postDelayed(TJAdUnit.this.f3717J, 200);
            } else {
                TJAdUnit.this.f3714G = true;
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: K */
    public final Runnable f3718K = new Runnable() {
        public final void run() {
            TJAdUnit.this.f3719b.onVideoProgress(TJAdUnit.this.f3722e.getCurrentPosition());
            TJAdUnit.this.f3726i.postDelayed(TJAdUnit.this.f3718K, 500);
        }
    };
    /* access modifiers changed from: 0000 */

    /* renamed from: b */
    public TJAdUnitJSBridge f3719b;
    /* access modifiers changed from: 0000 */

    /* renamed from: c */
    public TJWebView f3720c;
    /* access modifiers changed from: 0000 */

    /* renamed from: d */
    public TJWebView f3721d;

    /* renamed from: e */
    VideoView f3722e;

    /* renamed from: f */
    volatile boolean f3723f;

    /* renamed from: g */
    WebViewClient f3724g = new WebViewClient() {
        public final void onLoadResource(WebView webView, String str) {
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return m3443a(str);
        }

        @TargetApi(24)
        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return m3443a(webResourceRequest.getUrl().toString());
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            StringBuilder sb = new StringBuilder("onPageStarted: ");
            sb.append(str);
            TapjoyLog.m6550d("TJAdUnit", sb.toString());
            if (TJAdUnit.this.f3719b != null) {
                TJAdUnit.this.f3719b.allowRedirect = true;
                TJAdUnit.this.f3719b.customClose = false;
                TJAdUnit.this.f3719b.closeRequested = false;
                TJAdUnit.this.m3408a();
            }
        }

        public final void onPageFinished(WebView webView, String str) {
            StringBuilder sb = new StringBuilder("onPageFinished: ");
            sb.append(str);
            TapjoyLog.m6550d("TJAdUnit", sb.toString());
            if (TJAdUnit.this.f3729l != null) {
                TJAdUnit.this.f3729l.setProgressSpinnerVisibility(false);
            }
            TJAdUnit.this.f3709B = true;
            if (TJAdUnit.this.f3742y) {
                TJAdUnit.this.f3719b.display();
            }
            TJAdUnit.this.f3719b.flushMessageQueue();
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            StringBuilder sb = new StringBuilder("error:");
            sb.append(str);
            TapjoyLog.m6550d("TJAdUnit", sb.toString());
            if (TJAdUnit.this.f3729l != null) {
                TJAdUnit.this.f3729l.showErrorDialog();
            }
            super.onReceivedError(webView, i, str, str2);
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (TapjoyCache.getInstance() != null) {
                TapjoyCachedAssetData cachedDataForURL = TapjoyCache.getInstance().getCachedDataForURL(str);
                if (cachedDataForURL != null) {
                    WebResourceResponse a = m3442a(cachedDataForURL);
                    if (a != null) {
                        StringBuilder sb = new StringBuilder("Reading request for ");
                        sb.append(str);
                        sb.append(" from cache -- localPath: ");
                        sb.append(cachedDataForURL.getLocalFilePath());
                        TapjoyLog.m6550d("TJAdUnit", sb.toString());
                        return a;
                    }
                }
            }
            return super.shouldInterceptRequest(webView, str);
        }

        /* renamed from: a */
        private boolean m3443a(String str) {
            if (!TJAdUnit.this.m3422e() || !URLUtil.isValidUrl(str)) {
                if (TJAdUnit.this.f3729l != null) {
                    TJAdUnit.this.f3729l.showErrorDialog();
                }
                return true;
            } else if (TJAdUnit.m3416b(str)) {
                return false;
            } else {
                String str2 = "TJAdUnit";
                if (TJAdUnit.this.f3719b.allowRedirect) {
                    Uri parse = Uri.parse(str);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(parse);
                    intent.addFlags(DriveFile.MODE_READ_ONLY);
                    if (TJAdUnit.this.f3721d.getContext() != null) {
                        try {
                            TJAdUnit.this.f3721d.getContext().startActivity(intent);
                            return true;
                        } catch (Exception e) {
                            StringBuilder sb = new StringBuilder("Exception in loading URL. ");
                            sb.append(e.getMessage());
                            TapjoyLog.m6552e(str2, sb.toString());
                        }
                    }
                } else {
                    String str3 = "javascript:";
                    if (str.startsWith(str3) && VERSION.SDK_INT >= 19) {
                        try {
                            TJAdUnit.this.f3721d.evaluateJavascript(str.replaceFirst(str3, ""), null);
                            return true;
                        } catch (Exception e2) {
                            StringBuilder sb2 = new StringBuilder("Exception in evaluateJavascript. Device not supported. ");
                            sb2.append(e2.toString());
                            TapjoyLog.m6552e(str2, sb2.toString());
                        }
                    }
                }
                return false;
            }
        }

        /* renamed from: a */
        private static WebResourceResponse m3442a(TapjoyCachedAssetData tapjoyCachedAssetData) {
            if (tapjoyCachedAssetData == null) {
                return null;
            }
            try {
                return new WebResourceResponse(tapjoyCachedAssetData.getMimeType(), "UTF-8", new FileInputStream(tapjoyCachedAssetData.getLocalFilePath()));
            } catch (Exception unused) {
                return null;
            }
        }
    };

    /* renamed from: h */
    WebChromeClient f3725h = new WebChromeClient() {
        public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            TapjoyLog.m6550d("TJAdUnit", str2);
            return false;
        }

        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (TJAdUnit.this.f3719b.closeRequested) {
                int i = 0;
                String[] strArr = {"Uncaught", "uncaught", "Error", "error", "not defined"};
                if (TJAdUnit.this.f3729l != null) {
                    while (true) {
                        if (i >= 5) {
                            break;
                        }
                        if (consoleMessage.message().contains(strArr[i])) {
                            TJAdUnit.this.f3729l.handleClose();
                            break;
                        }
                        i++;
                    }
                }
            }
            return true;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final Handler f3726i = new Handler(Looper.getMainLooper());

    /* renamed from: j */
    private TJAdUnitWebViewListener f3727j;

    /* renamed from: k */
    private TJAdUnitVideoListener f3728k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public TJAdUnitActivity f3729l;

    /* renamed from: m */
    private MediaPlayer f3730m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f3731n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f3732o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f3733p;

    /* renamed from: q */
    private boolean f3734q;
    @Nullable

    /* renamed from: r */
    private ScheduledFuture f3735r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public AudioManager f3736s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f3737t = 0;

    /* renamed from: u */
    private int f3738u;

    /* renamed from: v */
    private boolean f3739v;

    /* renamed from: w */
    private boolean f3740w;

    /* renamed from: x */
    private boolean f3741x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f3742y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public boolean f3743z;

    public interface TJAdUnitVideoListener {
        void onVideoCompleted();

        void onVideoError(String str);

        void onVideoStart();
    }

    public interface TJAdUnitWebViewListener {
        void onClick();

        void onClosed();

        void onContentReady();
    }

    /* renamed from: a */
    private static boolean m3409a(int i) {
        return i == 0 || i == 8 || i == 6 || i == 11;
    }

    /* renamed from: b */
    private static boolean m3414b(int i) {
        return i == 1 || i == 9 || i == 7 || i == 12;
    }

    public boolean preload(TJPlacementData tJPlacementData, Context context) {
        if (this.f3743z || !tJPlacementData.isPrerenderingRequested() || !TJPlacementManager.canPreRenderPlacement() || TapjoyConnectCore.isViewOpen()) {
            fireContentReady();
            return false;
        }
        StringBuilder sb = new StringBuilder("Pre-rendering ad unit for placement: ");
        sb.append(tJPlacementData.getPlacementName());
        TapjoyLog.m6553i("TJAdUnit", sb.toString());
        TJPlacementManager.incrementPlacementPreRenderCount();
        load(tJPlacementData, true, context);
        return true;
    }

    public void load(final TJPlacementData tJPlacementData, final boolean z, final Context context) {
        this.f3743z = false;
        TapjoyUtil.runOnMainThread(new Runnable() {
            public final void run() {
                TJAdUnit tJAdUnit = TJAdUnit.this;
                Context context = context;
                String str = "TJAdUnit";
                if (Looper.myLooper() == Looper.getMainLooper() && !tJAdUnit.f3723f && context != null) {
                    TapjoyLog.m6550d(str, "Constructing ad unit");
                    tJAdUnit.f3723f = true;
                    tJAdUnit.f3720c = new TJWebView(context);
                    tJAdUnit.f3720c.loadDataWithBaseURL(null, "<!DOCTYPE html><html><head><title>Tapjoy Background Webview</title></head></html>", "text/html", "utf-8", null);
                    tJAdUnit.f3721d = new TJWebView(context);
                    tJAdUnit.f3721d.setWebViewClient(tJAdUnit.f3724g);
                    tJAdUnit.f3721d.setWebChromeClient(tJAdUnit.f3725h);
                    tJAdUnit.f3722e = new VideoView(context);
                    tJAdUnit.f3722e.setOnCompletionListener(tJAdUnit);
                    tJAdUnit.f3722e.setOnErrorListener(tJAdUnit);
                    tJAdUnit.f3722e.setOnPreparedListener(tJAdUnit);
                    tJAdUnit.f3722e.setVisibility(4);
                    tJAdUnit.f3719b = new TJAdUnitJSBridge(context, tJAdUnit);
                    if (context instanceof TJAdUnitActivity) {
                        tJAdUnit.setAdUnitActivity((TJAdUnitActivity) context);
                    }
                }
                if (tJAdUnit.f3723f) {
                    TapjoyLog.m6553i(str, "Loading ad unit content");
                    TJAdUnit.this.f3743z = true;
                    boolean z = false;
                    if (!C1852jq.m3669c(tJPlacementData.getRedirectURL())) {
                        if (tJPlacementData.isPreloadDisabled()) {
                            TJAdUnit.this.f3721d.postUrl(tJPlacementData.getRedirectURL(), null);
                        } else {
                            TJAdUnit.this.f3721d.loadUrl(tJPlacementData.getRedirectURL());
                        }
                    } else if (tJPlacementData.getBaseURL() == null || tJPlacementData.getHttpResponse() == null) {
                        TapjoyLog.m6551e(str, new TapjoyErrorMessage(ErrorType.SDK_ERROR, "Error loading ad unit content"));
                        TJAdUnit.this.f3743z = false;
                    } else {
                        TJAdUnit.this.f3721d.loadDataWithBaseURL(tJPlacementData.getBaseURL(), tJPlacementData.getHttpResponse(), "text/html", "utf-8", null);
                    }
                    TJAdUnit tJAdUnit2 = TJAdUnit.this;
                    if (tJAdUnit2.f3743z && z) {
                        z = true;
                    }
                    tJAdUnit2.f3708A = z;
                }
            }
        });
    }

    public void resume(TJAdUnitSaveStateData tJAdUnitSaveStateData) {
        if (this.f3719b.didLaunchOtherActivity) {
            StringBuilder sb = new StringBuilder("onResume bridge.didLaunchOtherActivity callbackID: ");
            sb.append(this.f3719b.otherActivityCallbackID);
            TapjoyLog.m6550d("TJAdUnit", sb.toString());
            TJAdUnitJSBridge tJAdUnitJSBridge = this.f3719b;
            tJAdUnitJSBridge.invokeJSCallback(tJAdUnitJSBridge.otherActivityCallbackID, Boolean.TRUE);
            this.f3719b.didLaunchOtherActivity = false;
        }
        this.f3713F = false;
        this.f3719b.setEnabled(true);
        if (tJAdUnitSaveStateData != null) {
            this.f3731n = tJAdUnitSaveStateData.seekTime;
            this.f3722e.seekTo(this.f3731n);
            if (this.f3730m != null) {
                this.f3739v = tJAdUnitSaveStateData.isVideoMuted;
            }
        }
        if (this.f3714G) {
            this.f3714G = false;
            this.f3726i.postDelayed(this.f3717J, 200);
        }
    }

    public void pause() {
        this.f3713F = true;
        this.f3719b.setEnabled(false);
        pauseVideo();
    }

    public void invokeBridgeCallback(String str, Object... objArr) {
        TJAdUnitJSBridge tJAdUnitJSBridge = this.f3719b;
        if (tJAdUnitJSBridge != null && str != null) {
            tJAdUnitJSBridge.invokeJSCallback(str, objArr);
        }
    }

    public void destroy() {
        this.f3719b.destroy();
        m3417c();
        TJWebView tJWebView = this.f3720c;
        if (tJWebView != null) {
            tJWebView.removeAllViews();
            this.f3720c = null;
        }
        TJWebView tJWebView2 = this.f3721d;
        if (tJWebView2 != null) {
            tJWebView2.removeAllViews();
            this.f3721d = null;
        }
        this.f3723f = false;
        this.f3742y = false;
        setAdUnitActivity(null);
        m3408a();
        this.f3730m = null;
        TJAdUnitWebViewListener tJAdUnitWebViewListener = this.f3727j;
        if (tJAdUnitWebViewListener != null) {
            tJAdUnitWebViewListener.onClosed();
        }
        resetContentLoadState();
    }

    public void resetContentLoadState() {
        this.f3743z = false;
        this.f3709B = false;
        this.f3708A = false;
        this.f3710C = -1;
        this.f3741x = false;
        this.f3739v = false;
    }

    public void setVisible(boolean z) {
        this.f3719b.notifyOrientationChanged(getScreenOrientationString(), this.f3711D, this.f3712E);
        this.f3742y = z;
        if (this.f3742y && this.f3709B) {
            this.f3719b.display();
        }
    }

    public void fireContentReady() {
        TJAdUnitWebViewListener tJAdUnitWebViewListener = this.f3727j;
        if (tJAdUnitWebViewListener != null) {
            tJAdUnitWebViewListener.onContentReady();
        }
    }

    public void fireOnClick() {
        TJAdUnitWebViewListener tJAdUnitWebViewListener = this.f3727j;
        if (tJAdUnitWebViewListener != null) {
            tJAdUnitWebViewListener.onClick();
        }
    }

    public void closeRequested(boolean z) {
        this.f3719b.closeRequested(Boolean.valueOf(z));
    }

    public void setOrientation(int i) {
        TJAdUnitActivity tJAdUnitActivity = this.f3729l;
        if (tJAdUnitActivity != null) {
            int b = m3412b();
            int i2 = this.f3710C;
            if (i2 != -1) {
                b = i2;
            }
            if ((m3409a(b) && m3409a(i)) || (m3414b(b) && m3414b(i))) {
                i = b;
            }
            tJAdUnitActivity.setRequestedOrientation(i);
            this.f3710C = i;
            this.f3741x = true;
        }
    }

    public void unsetOrientation() {
        TJAdUnitActivity tJAdUnitActivity = this.f3729l;
        if (tJAdUnitActivity != null) {
            tJAdUnitActivity.setRequestedOrientation(-1);
        }
        this.f3710C = -1;
        this.f3741x = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3408a() {
        TapjoyLog.m6550d("TJAdUnit", "detachVolumeListener");
        ScheduledFuture scheduledFuture = this.f3735r;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.f3735r = null;
        }
        this.f3736s = null;
    }

    /* renamed from: b */
    private int m3412b() {
        TJAdUnitActivity tJAdUnitActivity = this.f3729l;
        if (tJAdUnitActivity == null) {
            return -1;
        }
        int rotation = tJAdUnitActivity.getWindowManager().getDefaultDisplay().getRotation();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        tJAdUnitActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f3711D = displayMetrics.widthPixels;
        this.f3712E = displayMetrics.heightPixels;
        if (((rotation != 0 && rotation != 2) || this.f3712E <= this.f3711D) && ((rotation != 1 && rotation != 3) || this.f3711D <= this.f3712E)) {
            if (rotation != 0) {
                if (rotation != 1) {
                    if (rotation == 2) {
                        return 8;
                    }
                    if (rotation != 3) {
                        TapjoyLog.m6555w("TJAdUnit", "Unknown screen orientation. Defaulting to landscape.");
                    }
                    return 9;
                }
            }
            return 0;
        } else if (rotation != 0) {
            if (rotation != 1) {
                if (rotation != 2) {
                    if (rotation == 3) {
                        return 8;
                    }
                }
                return 9;
            }
            return 0;
        }
        return 1;
    }

    public void setAdUnitActivity(TJAdUnitActivity tJAdUnitActivity) {
        this.f3729l = tJAdUnitActivity;
        TJAdUnitJSBridge tJAdUnitJSBridge = this.f3719b;
        if (tJAdUnitJSBridge != null) {
            tJAdUnitJSBridge.setAdUnitActivity(this.f3729l);
        }
    }

    public void setAdContentTracker(C3071fm fmVar) {
        this.f3715H = fmVar;
    }

    public void setBackgroundColor(final String str, final AdUnitAsyncTaskListner adUnitAsyncTaskListner) {
        TapjoyUtil.runOnMainThread(new Runnable() {
            public final void run() {
                String str = "TJAdUnit";
                try {
                    StringBuilder sb = new StringBuilder("setBackgroundColor: ");
                    sb.append(str);
                    TapjoyLog.m6550d(str, sb.toString());
                    TJAdUnit.this.f3720c.setBackgroundColor(Color.parseColor(str));
                    adUnitAsyncTaskListner.onComplete(true);
                } catch (Exception unused) {
                    StringBuilder sb2 = new StringBuilder("Error setting background color. backgroundWebView: ");
                    sb2.append(TJAdUnit.this.f3720c);
                    sb2.append(", hexColor: ");
                    sb2.append(str);
                    TapjoyLog.m6550d(str, sb2.toString());
                    adUnitAsyncTaskListner.onComplete(false);
                }
            }
        });
    }

    public void setBackgroundContent(final String str, final AdUnitAsyncTaskListner adUnitAsyncTaskListner) {
        TapjoyUtil.runOnMainThread(new Runnable() {
            public final void run() {
                String str = "TJAdUnit";
                try {
                    StringBuilder sb = new StringBuilder("setBackgroundContent: ");
                    sb.append(str);
                    TapjoyLog.m6550d(str, sb.toString());
                    TJAdUnit.this.f3720c.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
                    adUnitAsyncTaskListner.onComplete(true);
                } catch (Exception unused) {
                    StringBuilder sb2 = new StringBuilder("Error setting background content. backgroundWebView: ");
                    sb2.append(TJAdUnit.this.f3720c);
                    sb2.append(", content: ");
                    sb2.append(str);
                    TapjoyLog.m6550d(str, sb2.toString());
                    adUnitAsyncTaskListner.onComplete(false);
                }
            }
        });
    }

    public void setWebViewListener(TJAdUnitWebViewListener tJAdUnitWebViewListener) {
        this.f3727j = tJAdUnitWebViewListener;
    }

    public void setVideoListener(TJAdUnitVideoListener tJAdUnitVideoListener) {
        this.f3728k = tJAdUnitVideoListener;
    }

    public int getLockedOrientation() {
        return this.f3710C;
    }

    public int getScreenWidth() {
        return this.f3711D;
    }

    public int getScreenHeight() {
        return this.f3712E;
    }

    public String getScreenOrientationString() {
        return m3409a(m3412b()) ? String.LANDSCAPE : String.PORTRAIT;
    }

    public boolean hasCalledLoad() {
        return this.f3743z;
    }

    public boolean isPrerendered() {
        return this.f3708A;
    }

    public boolean isLockedOrientation() {
        return this.f3741x;
    }

    public TJWebView getBackgroundWebView() {
        return this.f3720c;
    }

    public TJWebView getWebView() {
        return this.f3721d;
    }

    public boolean getCloseRequested() {
        return this.f3719b.closeRequested;
    }

    public void loadVideoUrl(final String str, final AdUnitAsyncTaskListner adUnitAsyncTaskListner) {
        TapjoyUtil.runOnMainThread(new Runnable() {
            public final void run() {
                if (TJAdUnit.this.f3722e != null) {
                    StringBuilder sb = new StringBuilder("loadVideoUrl: ");
                    sb.append(str);
                    TapjoyLog.m6553i("TJAdUnit", sb.toString());
                    TJAdUnit.this.f3722e.setBackgroundColor(TJAdUnit.this.f3720c.getBackgroundColor());
                    TJAdUnit.this.f3722e.setVideoPath(str);
                    TJAdUnit.this.f3722e.setVisibility(0);
                    TJAdUnit.this.f3722e.seekTo(0);
                    adUnitAsyncTaskListner.onComplete(true);
                    return;
                }
                adUnitAsyncTaskListner.onComplete(false);
            }
        });
    }

    public boolean playVideo() {
        TapjoyLog.m6553i("TJAdUnit", "playVideo");
        VideoView videoView = this.f3722e;
        if (videoView == null) {
            return false;
        }
        videoView.start();
        this.f3722e.setBackgroundColor(0);
        this.f3734q = false;
        this.f3726i.postDelayed(this.f3717J, 200);
        return true;
    }

    public boolean pauseVideo() {
        m3417c();
        VideoView videoView = this.f3722e;
        if (videoView == null || !videoView.isPlaying()) {
            return false;
        }
        this.f3722e.pause();
        this.f3731n = this.f3722e.getCurrentPosition();
        StringBuilder sb = new StringBuilder("Video paused at: ");
        sb.append(this.f3731n);
        TapjoyLog.m6553i("TJAdUnit", sb.toString());
        this.f3719b.onVideoPaused(this.f3731n);
        return true;
    }

    public void clearVideo(final AdUnitAsyncTaskListner adUnitAsyncTaskListner, final boolean z) {
        if (this.f3722e != null) {
            m3417c();
            TapjoyUtil.runOnMainThread(new Runnable() {
                public final void run() {
                    TJAdUnit.this.f3722e.setVisibility(z ? 0 : 4);
                    TJAdUnit.this.f3722e.stopPlayback();
                    TJAdUnit.this.f3733p = false;
                    TJAdUnit.this.f3732o = false;
                    TJAdUnit.this.f3731n = 0;
                    adUnitAsyncTaskListner.onComplete(true);
                }
            });
            return;
        }
        adUnitAsyncTaskListner.onComplete(false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo17971a(boolean z) {
        MediaPlayer mediaPlayer = this.f3730m;
        if (mediaPlayer != null) {
            if (z) {
                mediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                mediaPlayer.setVolume(1.0f, 1.0f);
            }
            if (this.f3740w != z) {
                this.f3740w = z;
                this.f3719b.onVolumeChanged();
            }
        } else {
            this.f3739v = z;
        }
    }

    public void attachVolumeListener(boolean z, int i) {
        StringBuilder sb = new StringBuilder("attachVolumeListener: isAttached=");
        sb.append(z);
        sb.append("; interval=");
        sb.append(i);
        TapjoyLog.m6550d("TJAdUnit", sb.toString());
        m3408a();
        if (z) {
            TJAdUnitActivity tJAdUnitActivity = this.f3729l;
            if (tJAdUnitActivity != null) {
                this.f3736s = (AudioManager) tJAdUnitActivity.getSystemService("audio");
                this.f3737t = this.f3736s.getStreamVolume(3);
                this.f3738u = this.f3736s.getStreamMaxVolume(3);
                long j = (long) i;
                this.f3735r = C3147hn.f7460a.scheduleWithFixedDelay(this.f3716I, j, j, TimeUnit.MILLISECONDS);
            }
        }
    }

    public VideoView getVideoView() {
        return this.f3722e;
    }

    public int getVideoSeekTime() {
        return this.f3731n;
    }

    public boolean isVideoComplete() {
        return this.f3734q;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        TapjoyLog.m6553i("TJAdUnit", "video -- onPrepared");
        final int duration = this.f3722e.getDuration();
        final int measuredWidth = this.f3722e.getMeasuredWidth();
        final int measuredHeight = this.f3722e.getMeasuredHeight();
        this.f3730m = mediaPlayer;
        boolean z = this.f3739v;
        if (z) {
            mo17971a(z);
        }
        if (this.f3731n <= 0 || this.f3722e.getCurrentPosition() == this.f3731n) {
            this.f3719b.onVideoReady(duration, measuredWidth, measuredHeight);
        } else {
            this.f3730m.setOnSeekCompleteListener(new OnSeekCompleteListener() {
                public final void onSeekComplete(MediaPlayer mediaPlayer) {
                    TJAdUnit.this.f3719b.onVideoReady(duration, measuredWidth, measuredHeight);
                }
            });
        }
        this.f3730m.setOnInfoListener(this);
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str;
        ErrorType errorType = ErrorType.SDK_ERROR;
        StringBuilder sb = new StringBuilder("Error encountered when instantiating the VideoView: ");
        sb.append(i);
        sb.append(" - ");
        sb.append(i2);
        TapjoyLog.m6551e("TJAdUnit", new TapjoyErrorMessage(errorType, sb.toString()));
        this.f3732o = true;
        m3417c();
        String str2 = i != 100 ? "MEDIA_ERROR_UNKNOWN" : "MEDIA_ERROR_SERVER_DIED";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(" -- ");
        String sb3 = sb2.toString();
        if (i2 == -1010) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(sb3);
            sb4.append("MEDIA_ERROR_UNSUPPORTED");
            str = sb4.toString();
        } else if (i2 == -1007) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb3);
            sb5.append("MEDIA_ERROR_MALFORMED");
            str = sb5.toString();
        } else if (i2 == -1004) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(sb3);
            sb6.append("MEDIA_ERROR_IO");
            str = sb6.toString();
        } else if (i2 != -110) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(sb3);
            sb7.append("MEDIA_ERROR_EXTRA_UNKNOWN");
            str = sb7.toString();
        } else {
            StringBuilder sb8 = new StringBuilder();
            sb8.append(sb3);
            sb8.append("MEDIA_ERROR_TIMED_OUT");
            str = sb8.toString();
        }
        this.f3719b.onVideoError(str);
        if (i == 1 || i2 == -1004) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    private void m3417c() {
        this.f3726i.removeCallbacks(this.f3717J);
        this.f3726i.removeCallbacks(this.f3718K);
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        TapjoyLog.m6553i("TJAdUnit", "video -- onCompletion");
        m3417c();
        this.f3734q = true;
        if (!this.f3732o) {
            this.f3719b.onVideoCompletion();
        }
        this.f3732o = false;
    }

    public void fireOnVideoStart() {
        TapjoyLog.m6554v("TJAdUnit", "Firing onVideoStart");
        if (getPublisherVideoListener() != null) {
            getPublisherVideoListener().onVideoStart();
        }
        TJAdUnitVideoListener tJAdUnitVideoListener = this.f3728k;
        if (tJAdUnitVideoListener != null) {
            tJAdUnitVideoListener.onVideoStart();
        }
    }

    public void fireOnVideoError(String str) {
        StringBuilder sb = new StringBuilder("Firing onVideoError with error: ");
        sb.append(str);
        TapjoyLog.m6552e("TJAdUnit", sb.toString());
        if (getPublisherVideoListener() != null) {
            getPublisherVideoListener().onVideoError(3);
        }
        TJAdUnitVideoListener tJAdUnitVideoListener = this.f3728k;
        if (tJAdUnitVideoListener != null) {
            tJAdUnitVideoListener.onVideoError(str);
        }
    }

    public void fireOnVideoComplete() {
        TapjoyLog.m6554v("TJAdUnit", "Firing onVideoComplete");
        if (getPublisherVideoListener() != null) {
            getPublisherVideoListener().onVideoComplete();
        }
        TJAdUnitVideoListener tJAdUnitVideoListener = this.f3728k;
        if (tJAdUnitVideoListener != null) {
            tJAdUnitVideoListener.onVideoCompleted();
        }
    }

    public float getVolume() {
        return ((float) this.f3737t) / ((float) this.f3738u);
    }

    public boolean isMuted() {
        return this.f3740w;
    }

    public void startAdContentTracking(String str, JSONObject jSONObject) {
        C3071fm fmVar = this.f3715H;
        if (fmVar != null) {
            fmVar.mo30130a(str, jSONObject);
        }
    }

    public void endAdContentTracking(String str, JSONObject jSONObject) {
        if (this.f3715H != null) {
            m3421d();
            this.f3715H.mo30131b(str, jSONObject);
        }
    }

    public void sendAdContentTracking(String str, JSONObject jSONObject) {
        if (this.f3715H != null) {
            m3421d();
            C3071fm fmVar = this.f3715H;
            Map a = C3071fm.m7095a(jSONObject);
            C1823gf.m3524e(str).mo18100a(fmVar.f7261a).mo18100a(a).mo18103b(C3071fm.m7096b(jSONObject)).mo18104c();
        }
    }

    /* renamed from: d */
    private void m3421d() {
        C3071fm fmVar = this.f3715H;
        if (fmVar != null) {
            fmVar.mo30143a("prerendered", Boolean.valueOf(this.f3708A));
        }
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str;
        if (i == 3) {
            str = "MEDIA_INFO_VIDEO_RENDERING_START";
        } else if (i != 801) {
            switch (i) {
                case 700:
                    str = "MEDIA_INFO_VIDEO_TRACK_LAGGING";
                    break;
                case 701:
                    str = "MEDIA_INFO_BUFFERING_START";
                    break;
                case 702:
                    str = "MEDIA_INFO_BUFFERING_END";
                    break;
                default:
                    str = "";
                    break;
            }
        } else {
            str = "MEDIA_INFO_NOT_SEEKABLE";
        }
        this.f3719b.onVideoInfo(str);
        return false;
    }

    public TJVideoListener getPublisherVideoListener() {
        return f3707a;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m3416b(String str) {
        try {
            String host = new URL(TapjoyConfig.TJC_SERVICE_URL).getHost();
            if ((host == null || !str.contains(host)) && !str.contains(TapjoyConnectCore.getRedirectDomain()) && !str.contains(TapjoyUtil.getRedirectDomain(TapjoyConnectCore.getPlacementURL()))) {
                return false;
            }
            return true;
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m3422e() {
        boolean z = false;
        try {
            if (this.f3721d.getContext() != null) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f3721d.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                    z = true;
                }
                return z;
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("Exception getting NetworkInfo: ");
            sb.append(e.getLocalizedMessage());
            TapjoyLog.m6550d("TJAdUnit", sb.toString());
        }
        return false;
    }

    public void notifyOrientationChanged() {
        this.f3719b.notifyOrientationChanged(getScreenOrientationString(), this.f3711D, this.f3712E);
    }
}
