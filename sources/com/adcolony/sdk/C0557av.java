package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.iab.omid.library.adcolony.ScriptInjector;
import com.tapjoy.TJAdUnitConstants.String;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import org.json.JSONArray;
import org.json.JSONObject;

@SuppressLint({"SetJavaScriptEnabled"})
/* renamed from: com.adcolony.sdk.av */
class C0557av extends WebView implements C0485ae {

    /* renamed from: a */
    static boolean f465a = false;

    /* renamed from: A */
    private boolean f466A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public boolean f467B;

    /* renamed from: C */
    private boolean f468C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public boolean f469D;

    /* renamed from: E */
    private boolean f470E;

    /* renamed from: F */
    private boolean f471F;

    /* renamed from: G */
    private boolean f472G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public JSONArray f473H = C0746u.m909b();
    /* access modifiers changed from: private */

    /* renamed from: I */
    public JSONObject f474I = C0746u.m892a();

    /* renamed from: J */
    private JSONObject f475J = C0746u.m892a();
    /* access modifiers changed from: private */

    /* renamed from: K */
    public C0580c f476K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public C0480ab f477L;

    /* renamed from: M */
    private ImageView f478M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public final Object f479N = new Object();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f480b;

    /* renamed from: c */
    private String f481c;

    /* renamed from: d */
    private String f482d;

    /* renamed from: e */
    private String f483e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f484f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f485g;

    /* renamed from: h */
    private String f486h;

    /* renamed from: i */
    private String f487i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public String f488j;

    /* renamed from: k */
    private String f489k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f490l;

    /* renamed from: m */
    private int f491m;

    /* renamed from: n */
    private int f492n;

    /* renamed from: o */
    private int f493o;

    /* renamed from: p */
    private int f494p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f495q;

    /* renamed from: r */
    private int f496r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f497s;

    /* renamed from: t */
    private int f498t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f499u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f500v;

    /* renamed from: w */
    private int f501w;

    /* renamed from: x */
    private int f502x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f503y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public boolean f504z;

    /* renamed from: com.adcolony.sdk.av$a */
    private class C0573a extends WebViewClient {
        private C0573a() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!C0557av.this.f467B) {
                return false;
            }
            C0543at.m306a(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            C0511aq n = C0476a.m77a().mo8580n();
            n.mo8328b(C0557av.this.f484f);
            n.mo8326a(C0557av.this.f484f);
            JSONObject a = C0746u.m892a();
            C0746u.m902a(a, "url", str);
            C0746u.m902a(a, "ad_session_id", C0557av.this.f484f);
            new C0480ab("WebView.redirect_detected", C0557av.this.f476K.mo8467c(), a).mo8217b();
            return true;
        }

        public void onLoadResource(WebView webView, String str) {
            if (str.equals(C0557av.this.f480b)) {
                C0557av.this.mo8403a("if (typeof(CN) != 'undefined' && CN.div) {\n  if (typeof(cn_dispatch_on_touch_begin) != 'undefined') CN.div.removeEventListener('mousedown',  cn_dispatch_on_touch_begin, true);\n  if (typeof(cn_dispatch_on_touch_end) != 'undefined')   CN.div.removeEventListener('mouseup',  cn_dispatch_on_touch_end, true);\n  if (typeof(cn_dispatch_on_touch_move) != 'undefined')  CN.div.removeEventListener('mousemove',  cn_dispatch_on_touch_move, true);\n}\n");
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            C0557av.this.f467B = false;
            new C0749a().mo8726a("onPageStarted with URL = ").mo8726a(str).mo8728a(C0748w.f1168d);
        }

        public void onPageFinished(WebView webView, String str) {
            JSONObject a = C0746u.m892a();
            String str2 = "id";
            C0746u.m912b(a, str2, C0557av.this.f490l);
            C0746u.m902a(a, "url", str);
            new C0749a().mo8726a("onPageFinished called with URL = ").mo8726a(str).mo8728a(C0748w.f1166b);
            String str3 = "WebView.on_load";
            String str4 = "ad_session_id";
            if (C0557av.this.f476K == null) {
                new C0480ab(str3, C0557av.this.f499u, a).mo8217b();
            } else {
                C0746u.m902a(a, str4, C0557av.this.f484f);
                C0746u.m912b(a, "container_id", C0557av.this.f476K.mo8470d());
                new C0480ab(str3, C0557av.this.f476K.mo8467c(), a).mo8217b();
            }
            if ((C0557av.this.f503y || C0557av.this.f504z) && !C0557av.this.f467B) {
                int m = C0557av.this.f500v > 0 ? C0557av.this.f500v : C0557av.this.f499u;
                if (C0557av.this.f500v > 0) {
                    float p = C0476a.m77a().mo8579m().mo8640p();
                    C0746u.m912b(C0557av.this.f474I, "app_orientation", C0543at.m335j(C0543at.m332h()));
                    C0746u.m912b(C0557av.this.f474I, "x", C0543at.m297a((View) C0557av.this));
                    C0746u.m912b(C0557av.this.f474I, "y", C0543at.m315b((View) C0557av.this));
                    C0746u.m912b(C0557av.this.f474I, "width", (int) (((float) C0557av.this.f495q) / p));
                    C0746u.m912b(C0557av.this.f474I, "height", (int) (((float) C0557av.this.f497s) / p));
                    C0746u.m902a(C0557av.this.f474I, str4, C0557av.this.f484f);
                }
                C0557av avVar = C0557av.this;
                StringBuilder sb = new StringBuilder();
                sb.append("ADC3_init(");
                sb.append(m);
                sb.append(",");
                sb.append(C0557av.this.f474I.toString());
                sb.append(");");
                avVar.mo8403a(sb.toString());
                C0557av.this.f467B = true;
            }
            if (!C0557av.this.f504z) {
                return;
            }
            if (C0557av.this.f499u != 1 || C0557av.this.f500v > 0) {
                JSONObject a2 = C0746u.m892a();
                C0746u.m913b(a2, "success", true);
                C0746u.m912b(a2, str2, C0557av.this.f499u);
                C0557av.this.f477L.mo8216a(a2).mo8217b();
            }
        }

        @TargetApi(11)
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            String str2 = "UTF-8";
            if (VERSION.SDK_INT < 21 && str.endsWith("mraid.js")) {
                try {
                    return new WebResourceResponse("text/javascript", str2, new ByteArrayInputStream(C0557av.this.f485g.getBytes(str2)));
                } catch (UnsupportedEncodingException unused) {
                    new C0749a().mo8726a("UTF-8 not supported.").mo8728a(C0748w.f1172h);
                }
            }
            return null;
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            if (VERSION.SDK_INT < 23) {
                C0557av.this.m405a(i, str, str2);
            }
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (VERSION.SDK_INT < 26) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            if (renderProcessGoneDetail.didCrash()) {
                C0557av.this.m409a(C0746u.m892a(), "An error occurred while rendering the ad. Ad closing.");
            }
            return true;
        }
    }

    /* renamed from: c */
    public void mo8239c() {
    }

    private C0557av(Context context) {
        super(context);
        String str = "";
        this.f482d = str;
        this.f483e = str;
        this.f485g = str;
        this.f486h = str;
        this.f487i = str;
        this.f488j = str;
        this.f489k = str;
    }

    C0557av(Context context, C0480ab abVar, int i, int i2, C0580c cVar) {
        super(context);
        String str = "";
        this.f482d = str;
        this.f483e = str;
        this.f485g = str;
        this.f486h = str;
        this.f487i = str;
        this.f488j = str;
        this.f489k = str;
        this.f477L = abVar;
        mo8401a(abVar, i, i2, cVar);
        mo8409e();
    }

    C0557av(Context context, int i, boolean z) {
        super(context);
        String str = "";
        this.f482d = str;
        this.f483e = str;
        this.f485g = str;
        this.f486h = str;
        this.f487i = str;
        this.f488j = str;
        this.f489k = str;
        this.f499u = i;
        this.f466A = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8403a(String str) {
        if (this.f468C) {
            new C0749a().mo8726a("Ignoring call to execute_js as WebView has been destroyed.").mo8728a(C0748w.f1166b);
            return;
        }
        if (VERSION.SDK_INT >= 19) {
            evaluateJavascript(str, null);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("javascript:");
            sb.append(str);
            loadUrl(sb.toString());
        }
    }

    /* renamed from: a */
    public int mo8236a() {
        return this.f499u;
    }

    /* renamed from: b */
    public int mo8238b() {
        return this.f500v;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo8406a(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        return C0746u.m914c(c, "id") == this.f490l && C0746u.m914c(c, "container_id") == this.f476K.mo8470d() && C0746u.m908b(c, "ad_session_id").equals(this.f476K.mo8463b());
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AdColonyAdView adColonyAdView;
        if (motionEvent.getAction() == 1) {
            if (this.f484f == null) {
                adColonyAdView = null;
            } else {
                adColonyAdView = (AdColonyAdView) C0476a.m77a().mo8578l().mo8512e().get(this.f484f);
            }
            if (adColonyAdView != null && !adColonyAdView.getUserInteraction()) {
                JSONObject a = C0746u.m892a();
                C0746u.m902a(a, "ad_session_id", this.f484f);
                new C0480ab("WebView.on_first_click", 1, a).mo8217b();
                adColonyAdView.setUserInteraction(true);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo8409e() {
        mo8405a(false, (C0480ab) null);
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"AddJavascriptInterface"})
    /* renamed from: a */
    public void mo8405a(boolean z, C0480ab abVar) {
        String str;
        String str2;
        if (this.f477L == null) {
            this.f477L = abVar;
        }
        final JSONObject c = this.f477L.mo8220c();
        this.f504z = z;
        this.f466A = C0746u.m918d(c, "is_display_module");
        String str3 = String.VIDEO_INFO;
        String str4 = "";
        if (z) {
            String b = C0746u.m908b(c, "filepath");
            this.f489k = C0746u.m908b(c, "interstitial_html");
            this.f486h = C0746u.m908b(c, "mraid_filepath");
            this.f483e = C0746u.m908b(c, "base_url");
            this.f481c = b;
            this.f475J = C0746u.m921f(c, "iab");
            if (f465a && this.f499u == 1) {
                this.f481c = "android_asset/ADCController.js";
            }
            if (this.f489k.equals(str4)) {
                StringBuilder sb = new StringBuilder();
                sb.append("file:///");
                sb.append(this.f481c);
                str2 = sb.toString();
            } else {
                str2 = str4;
            }
            this.f480b = str2;
            this.f474I = C0746u.m921f(c, str3);
            this.f484f = C0746u.m908b(c, "ad_session_id");
            this.f503y = true;
        }
        setFocusable(true);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        if (VERSION.SDK_INT >= 19) {
            setWebContentsDebuggingEnabled(true);
        }
        setWebChromeClient(new WebChromeClient() {
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                new C0749a().mo8726a("JS Alert: ").mo8726a(str2).mo8728a(C0748w.f1168d);
                jsResult.confirm();
                return true;
            }

            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                String str;
                MessageLevel messageLevel = consoleMessage.messageLevel();
                String message = consoleMessage.message();
                boolean z = false;
                boolean z2 = messageLevel == MessageLevel.ERROR;
                if (consoleMessage.message().contains("Viewport argument key \"shrink-to-fit\" not recognized and ignored") || consoleMessage.message().contains("Viewport target-densitydpi is not supported.")) {
                    z = true;
                }
                if (message.contains("ADC3_update is not defined") || message.contains("NativeLayer.dispatch_messages is not a function")) {
                    C0557av.this.m409a(c, "Unable to communicate with AdColony. Please ensure that you have added an exception for our Javascript interface in your ProGuard configuration and that you do not have a faulty proxy enabled on your device.");
                }
                if (!z && (messageLevel == MessageLevel.WARNING || z2)) {
                    AdColonyInterstitial adColonyInterstitial = null;
                    if (C0557av.this.f484f != null) {
                        adColonyInterstitial = (AdColonyInterstitial) C0476a.m77a().mo8578l().mo8509c().get(C0557av.this.f484f);
                    }
                    if (adColonyInterstitial == null) {
                        str = "unknown";
                    } else {
                        str = adColonyInterstitial.mo8133b();
                    }
                    new C0749a().mo8726a("onConsoleMessage: ").mo8726a(consoleMessage.message()).mo8726a(" with ad id: ").mo8726a(str).mo8728a(z2 ? C0748w.f1172h : C0748w.f1170f);
                }
                return true;
            }
        });
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setGeolocationEnabled(true);
        settings.setUseWideViewPort(true);
        if (VERSION.SDK_INT >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        if (VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(true);
            settings.setAllowUniversalAccessFromFileURLs(true);
            settings.setAllowFileAccess(true);
        }
        WebViewClient webViewClient = VERSION.SDK_INT >= 23 ? new C0573a() {
            @RequiresApi(api = 24)
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                if (!C0557av.this.f467B || !webResourceRequest.isForMainFrame()) {
                    return false;
                }
                Uri url = webResourceRequest.getUrl();
                C0543at.m306a(new Intent("android.intent.action.VIEW", url));
                JSONObject a = C0746u.m892a();
                C0746u.m902a(a, "url", url.toString());
                C0746u.m902a(a, "ad_session_id", C0557av.this.f484f);
                new C0480ab("WebView.redirect_detected", C0557av.this.f476K.mo8467c(), a).mo8217b();
                C0511aq n = C0476a.m77a().mo8580n();
                n.mo8328b(C0557av.this.f484f);
                n.mo8326a(C0557av.this.f484f);
                return true;
            }

            @RequiresApi(api = 23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                C0557av.this.m405a(webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
            }

            @RequiresApi(api = 23)
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                String str = "UTF-8";
                if (webResourceRequest.getUrl().toString().endsWith("mraid.js")) {
                    try {
                        return new WebResourceResponse("text/javascript", str, new ByteArrayInputStream(C0557av.this.f485g.getBytes(str)));
                    } catch (UnsupportedEncodingException unused) {
                        new C0749a().mo8726a("UTF-8 not supported.").mo8728a(C0748w.f1172h);
                    }
                }
                return null;
            }
        } : VERSION.SDK_INT >= 21 ? new C0573a() {
            @RequiresApi(api = 21)
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                String str = "UTF-8";
                if (webResourceRequest.getUrl().toString().endsWith("mraid.js")) {
                    try {
                        return new WebResourceResponse("text/javascript", str, new ByteArrayInputStream(C0557av.this.f485g.getBytes(str)));
                    } catch (UnsupportedEncodingException unused) {
                        new C0749a().mo8726a("UTF-8 not supported.").mo8728a(C0748w.f1172h);
                    }
                }
                return null;
            }
        } : new C0573a();
        addJavascriptInterface(new Object() {
            @JavascriptInterface
            public void push_messages(String str) {
                C0557av.this.m414b(str);
            }

            @JavascriptInterface
            public void dispatch_messages(String str) {
                C0557av.this.m414b(str);
            }

            @JavascriptInterface
            public String pull_messages() {
                String str;
                synchronized (C0557av.this.f479N) {
                    str = "[]";
                    if (C0557av.this.f473H.length() > 0) {
                        if (C0557av.this.f503y) {
                            str = C0557av.this.f473H.toString();
                        }
                        C0557av.this.f473H = C0746u.m909b();
                    }
                }
                return str;
            }

            @JavascriptInterface
            public void enable_reverse_messaging() {
                C0557av.this.f469D = true;
            }
        }, "NativeLayer");
        setWebViewClient(webViewClient);
        String str5 = ".html";
        if (this.f466A) {
            try {
                if (this.f489k.equals(str4)) {
                    FileInputStream fileInputStream = new FileInputStream(this.f481c);
                    StringBuilder sb2 = new StringBuilder(fileInputStream.available());
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read < 0) {
                            break;
                        }
                        sb2.append(new String(bArr, 0, read));
                    }
                    if (this.f481c.contains(str5)) {
                        str = sb2.toString();
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("<html><script>");
                        sb3.append(sb2.toString());
                        sb3.append("</script></html>");
                        str = sb3.toString();
                    }
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("script src=\"file://");
                    sb4.append(this.f486h);
                    sb4.append("\"");
                    str = this.f489k.replaceFirst("script\\s*src\\s*=\\s*\"mraid.js\"", sb4.toString());
                }
                String b2 = C0746u.m908b(C0746u.m921f(c, str3), "metadata");
                StringBuilder sb5 = new StringBuilder();
                sb5.append("var ADC_DEVICE_INFO = ");
                sb5.append(b2);
                sb5.append(";");
                loadDataWithBaseURL(this.f480b.equals(str4) ? this.f483e : this.f480b, m403a(str, C0746u.m908b(C0746u.m893a(b2), "iab_filepath")).replaceFirst("var\\s*ADC_DEVICE_INFO\\s*=\\s*null\\s*;", Matcher.quoteReplacement(sb5.toString())), "text/html", null, null);
            } catch (IOException e) {
                m411a((Exception) e);
                return;
            } catch (IllegalArgumentException e2) {
                m411a((Exception) e2);
                return;
            } catch (IndexOutOfBoundsException e3) {
                m411a((Exception) e3);
                return;
            }
        } else {
            String str6 = "file";
            if (!this.f480b.startsWith("http") && !this.f480b.startsWith(str6)) {
                loadDataWithBaseURL(this.f483e, this.f480b, "text/html", null, null);
            } else if (this.f480b.contains(str5) || !this.f480b.startsWith(str6)) {
                loadUrl(this.f480b);
            } else {
                String str7 = this.f480b;
                StringBuilder sb6 = new StringBuilder();
                sb6.append("<html><script src=\"");
                sb6.append(this.f480b);
                sb6.append("\"></script></html>");
                loadDataWithBaseURL(str7, sb6.toString(), "text/html", null, null);
            }
        }
        if (!z) {
            mo8410f();
            mo8411g();
        }
        if (z || this.f503y) {
            C0476a.m77a().mo8583q().mo8223a((C0485ae) this);
        }
        if (!this.f482d.equals(str4)) {
            mo8403a(this.f482d);
        }
    }

    /* renamed from: a */
    private String m403a(String str, String str2) {
        C0487ag agVar;
        C0595d l = C0476a.m77a().mo8578l();
        AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) l.mo8509c().get(this.f484f);
        AdColonyAdViewListener adColonyAdViewListener = (AdColonyAdViewListener) l.mo8511d().get(this.f484f);
        if (adColonyInterstitial != null && this.f475J.length() > 0 && !C0746u.m908b(this.f475J, AppEventsConstants.EVENT_PARAM_AD_TYPE).equals("video")) {
            adColonyInterstitial.mo8129a(this.f475J);
        } else if (adColonyAdViewListener != null && this.f475J.length() > 0) {
            adColonyAdViewListener.mo8071a(new C0487ag(this.f475J, this.f484f));
        }
        if (adColonyInterstitial == null) {
            agVar = null;
        } else {
            agVar = adColonyInterstitial.mo8146h();
        }
        if (agVar == null && adColonyAdViewListener != null) {
            agVar = adColonyAdViewListener.mo8074c();
        }
        if (agVar != null && agVar.mo8250c() == 2) {
            this.f470E = true;
            if (!str2.equals("")) {
                try {
                    return ScriptInjector.injectScriptContentIntoHtml(C0476a.m77a().mo8576j().mo8691a(str2, false).toString(), str);
                } catch (IOException e) {
                    m411a((Exception) e);
                }
            }
        }
        return str;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m414b(String str) {
        JSONArray b = C0746u.m910b(str);
        for (int i = 0; i < b.length(); i++) {
            C0476a.m77a().mo8583q().mo8227a(C0746u.m917d(b, i));
        }
    }

    /* renamed from: a */
    private boolean m411a(Exception exc) {
        new C0749a().mo8726a(exc.getClass().toString()).mo8726a(" during metadata injection w/ metadata = ").mo8726a(C0746u.m908b(this.f474I, "metadata")).mo8728a(C0748w.f1172h);
        AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) C0476a.m77a().mo8578l().mo8509c().remove(C0746u.m908b(this.f474I, "ad_session_id"));
        if (adColonyInterstitial == null) {
            return false;
        }
        AdColonyInterstitialListener listener = adColonyInterstitial.getListener();
        if (listener == null) {
            return false;
        }
        listener.onExpiring(adColonyInterstitial);
        adColonyInterstitial.mo8130a(true);
        return true;
    }

    /* renamed from: b */
    private void m413b(Exception exc) {
        new C0749a().mo8726a(exc.getClass().toString()).mo8726a(" during metadata injection w/ metadata = ").mo8726a(C0746u.m908b(this.f474I, "metadata")).mo8728a(C0748w.f1172h);
        JSONObject a = C0746u.m892a();
        C0746u.m902a(a, "id", this.f484f);
        new C0480ab("AdSession.on_error", this.f476K.mo8467c(), a).mo8217b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo8410f() {
        String str = "WebView.set_visible";
        this.f476K.mo8488m().add(C0476a.m76a(str, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(final C0480ab abVar) {
                if (C0557av.this.mo8406a(abVar)) {
                    C0543at.m309a((Runnable) new Runnable() {
                        public void run() {
                            C0557av.this.mo8408c(abVar);
                        }
                    });
                }
            }
        }, true));
        String str2 = "WebView.set_bounds";
        this.f476K.mo8488m().add(C0476a.m76a(str2, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(final C0480ab abVar) {
                if (C0557av.this.mo8406a(abVar)) {
                    C0543at.m309a((Runnable) new Runnable() {
                        public void run() {
                            C0557av.this.mo8407b(abVar);
                        }
                    });
                }
            }
        }, true));
        String str3 = "WebView.execute_js";
        this.f476K.mo8488m().add(C0476a.m76a(str3, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(final C0480ab abVar) {
                if (C0557av.this.mo8406a(abVar)) {
                    C0543at.m309a((Runnable) new Runnable() {
                        public void run() {
                            C0557av.this.mo8403a(C0746u.m908b(abVar.mo8220c(), "custom_js"));
                        }
                    });
                }
            }
        }, true));
        String str4 = "WebView.set_transparent";
        this.f476K.mo8488m().add(C0476a.m76a(str4, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(final C0480ab abVar) {
                if (C0557av.this.mo8406a(abVar)) {
                    C0543at.m309a((Runnable) new Runnable() {
                        public void run() {
                            C0557av.this.m415b(C0746u.m918d(abVar.mo8220c(), String.TRANSPARENT));
                        }
                    });
                }
            }
        }, true));
        this.f476K.mo8489n().add(str);
        this.f476K.mo8489n().add(str2);
        this.f476K.mo8489n().add(str3);
        this.f476K.mo8489n().add(str4);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m415b(boolean z) {
        setBackgroundColor(z ? 0 : -1);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo8411g() {
        setVisibility(4);
        LayoutParams layoutParams = new LayoutParams(this.f495q, this.f497s);
        layoutParams.setMargins(this.f491m, this.f493o, 0, 0);
        layoutParams.gravity = 0;
        this.f476K.addView(this, layoutParams);
        String str = "";
        if (!this.f487i.equals(str) && !this.f488j.equals(str)) {
            m433w();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8402a(C0480ab abVar, int i, C0580c cVar) {
        mo8401a(abVar, i, -1, cVar);
        mo8411g();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8401a(C0480ab abVar, int i, int i2, C0580c cVar) {
        JSONObject c = abVar.mo8220c();
        this.f480b = C0746u.m908b(c, "url");
        String str = "";
        if (this.f480b.equals(str)) {
            this.f480b = C0746u.m908b(c, "data");
        }
        this.f483e = C0746u.m908b(c, "base_url");
        this.f482d = C0746u.m908b(c, "custom_js");
        this.f484f = C0746u.m908b(c, "ad_session_id");
        this.f474I = C0746u.m921f(c, String.VIDEO_INFO);
        this.f486h = C0746u.m908b(c, "mraid_filepath");
        this.f500v = C0746u.m918d(c, "use_mraid_module") ? C0476a.m77a().mo8583q().mo8231d() : this.f500v;
        this.f487i = C0746u.m908b(c, "ad_choices_filepath");
        this.f488j = C0746u.m908b(c, "ad_choices_url");
        this.f471F = C0746u.m918d(c, "disable_ad_choices");
        this.f472G = C0746u.m918d(c, "ad_choices_snap_to_webview");
        this.f501w = C0746u.m914c(c, "ad_choices_width");
        this.f502x = C0746u.m914c(c, "ad_choices_height");
        if (this.f475J.length() == 0) {
            this.f475J = C0746u.m921f(c, "iab");
        }
        boolean z = false;
        if (!this.f466A && !this.f486h.equals(str)) {
            if (this.f500v > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("script src=\"file://");
                sb.append(this.f486h);
                sb.append("\"");
                this.f480b = m403a(this.f480b.replaceFirst("script\\s*src\\s*=\\s*\"mraid.js\"", sb.toString()), C0746u.m908b(C0746u.m921f(this.f474I, DeviceRequestsHelper.DEVICE_INFO_PARAM), "iab_filepath"));
            } else {
                try {
                    this.f485g = C0476a.m77a().mo8576j().mo8691a(this.f486h, false).toString();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("bridge.os_name = \"\";\nvar ADC_DEVICE_INFO = ");
                    sb2.append(this.f474I.toString());
                    sb2.append(";\n");
                    this.f485g = this.f485g.replaceFirst("bridge.os_name\\s*=\\s*\"\"\\s*;", sb2.toString());
                } catch (IOException e) {
                    m413b((Exception) e);
                } catch (IllegalArgumentException e2) {
                    m413b((Exception) e2);
                } catch (IndexOutOfBoundsException e3) {
                    m413b((Exception) e3);
                }
            }
        }
        this.f490l = i;
        this.f476K = cVar;
        if (i2 >= 0) {
            this.f499u = i2;
        } else {
            mo8410f();
        }
        this.f495q = C0746u.m914c(c, "width");
        this.f497s = C0746u.m914c(c, "height");
        this.f491m = C0746u.m914c(c, "x");
        this.f493o = C0746u.m914c(c, "y");
        this.f496r = this.f495q;
        this.f498t = this.f497s;
        this.f494p = this.f493o;
        this.f492n = this.f491m;
        if (C0746u.m918d(c, "enable_messages") || this.f504z) {
            z = true;
        }
        this.f503y = z;
        mo8415k();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8407b(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        this.f491m = C0746u.m914c(c, "x");
        this.f493o = C0746u.m914c(c, "y");
        this.f495q = C0746u.m914c(c, "width");
        this.f497s = C0746u.m914c(c, "height");
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        layoutParams.setMargins(this.f491m, this.f493o, 0, 0);
        layoutParams.width = this.f495q;
        layoutParams.height = this.f497s;
        setLayoutParams(layoutParams);
        if (this.f504z) {
            JSONObject a = C0746u.m892a();
            C0746u.m913b(a, "success", true);
            C0746u.m912b(a, "id", this.f499u);
            abVar.mo8216a(a).mo8217b();
        }
        mo8412h();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo8412h() {
        if (this.f478M != null) {
            int q = C0476a.m77a().mo8579m().mo8641q();
            int r = C0476a.m77a().mo8579m().mo8642r();
            if (this.f472G) {
                q = this.f491m + this.f495q;
            }
            if (this.f472G) {
                r = this.f493o + this.f497s;
            }
            float p = C0476a.m77a().mo8579m().mo8640p();
            int i = (int) (((float) this.f501w) * p);
            int i2 = (int) (((float) this.f502x) * p);
            this.f478M.setLayoutParams(new AbsoluteLayout.LayoutParams(i, i2, q - i, r - i2));
        }
    }

    /* renamed from: w */
    private void m433w() {
        Context c = C0476a.m85c();
        if (c != null && this.f476K != null && !this.f471F) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            gradientDrawable.setShape(1);
            this.f478M = new ImageView(c);
            this.f478M.setImageURI(Uri.fromFile(new File(this.f487i)));
            this.f478M.setBackground(gradientDrawable);
            this.f478M.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C0543at.m306a(new Intent("android.intent.action.VIEW", Uri.parse(C0557av.this.f488j)));
                    C0476a.m77a().mo8580n().mo8326a(C0557av.this.f484f);
                }
            });
            mo8412h();
            addView(this.f478M);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public void mo8413i() {
        ImageView imageView = this.f478M;
        if (imageView != null) {
            this.f476K.mo8458a((View) imageView);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo8408c(C0480ab abVar) {
        if (C0746u.m918d(abVar.mo8220c(), String.VISIBLE)) {
            setVisibility(0);
        } else {
            setVisibility(4);
        }
        if (this.f504z) {
            JSONObject a = C0746u.m892a();
            C0746u.m913b(a, "success", true);
            C0746u.m912b(a, "id", this.f499u);
            abVar.mo8216a(a).mo8217b();
        }
    }

    /* renamed from: a */
    public void mo8237a(JSONObject jSONObject) {
        synchronized (this.f479N) {
            this.f473H.put(jSONObject);
        }
    }

    /* renamed from: d */
    public void mo8240d() {
        if (C0476a.m86d() && this.f467B && !this.f469D) {
            mo8414j();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo8414j() {
        C0543at.m309a((Runnable) new Runnable() {
            public void run() {
                String str;
                synchronized (C0557av.this.f479N) {
                    str = "";
                    if (C0557av.this.f473H.length() > 0) {
                        if (C0557av.this.f503y) {
                            str = C0557av.this.f473H.toString();
                        }
                        C0557av.this.f473H = C0746u.m909b();
                    }
                }
                if (C0557av.this.f503y) {
                    C0557av avVar = C0557av.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("NativeLayer.dispatch_messages(ADC3_update(");
                    sb.append(str);
                    sb.append("));");
                    avVar.mo8403a(sb.toString());
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m409a(JSONObject jSONObject, String str) {
        Context c = C0476a.m85c();
        if (c != null && (c instanceof C0578b)) {
            C0480ab abVar = new C0480ab("AdSession.finish_fullscreen_ad", 0);
            C0746u.m912b(jSONObject, "status", 1);
            new C0749a().mo8726a(str).mo8728a(C0748w.f1171g);
            ((C0578b) c).mo8152a(abVar);
        } else if (this.f499u == 1) {
            new C0749a().mo8726a("Unable to communicate with controller, disabling AdColony.").mo8728a(C0748w.f1171g);
            AdColony.disable();
        } else if (this.f500v > 0) {
            this.f503y = false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public void mo8415k() {
        C0543at.m309a((Runnable) new Runnable() {
            public void run() {
                C0487ag agVar;
                int i;
                try {
                    C0595d l = C0476a.m77a().mo8578l();
                    AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) l.mo8509c().get(C0557av.this.f484f);
                    AdColonyAdView adColonyAdView = (AdColonyAdView) l.mo8512e().get(C0557av.this.f484f);
                    if (adColonyInterstitial == null) {
                        agVar = null;
                    } else {
                        agVar = adColonyInterstitial.mo8146h();
                    }
                    if (agVar == null && adColonyAdView != null) {
                        agVar = adColonyAdView.getOmidManager();
                    }
                    if (agVar == null) {
                        i = -1;
                    } else {
                        i = agVar.mo8250c();
                    }
                    if (agVar != null && i == 2) {
                        agVar.mo8245a((WebView) C0557av.this);
                        agVar.mo8246a(C0557av.this.f476K);
                    }
                } catch (IllegalArgumentException unused) {
                    new C0749a().mo8726a("IllegalArgumentException when creating omid session").mo8728a(C0748w.f1172h);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m405a(int i, String str, String str2) {
        if (this.f476K != null) {
            JSONObject a = C0746u.m892a();
            C0746u.m912b(a, "id", this.f490l);
            C0746u.m902a(a, "ad_session_id", this.f484f);
            C0746u.m912b(a, "container_id", this.f476K.mo8470d());
            C0746u.m912b(a, "code", i);
            C0746u.m902a(a, "error", str);
            C0746u.m902a(a, "url", str2);
            new C0480ab("WebView.on_error", this.f476K.mo8467c(), a).mo8217b();
        }
        new C0749a().mo8726a("onReceivedError: ").mo8726a(str).mo8728a(C0748w.f1172h);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public boolean mo8416l() {
        return this.f470E;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public boolean mo8417m() {
        return this.f466A;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public boolean mo8418n() {
        return this.f468C;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8404a(boolean z) {
        this.f468C = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public int mo8419o() {
        return this.f492n;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: p */
    public int mo8421p() {
        return this.f494p;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public int mo8422q() {
        return this.f496r;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public int mo8423r() {
        return this.f498t;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: s */
    public int mo8424s() {
        return this.f495q;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: t */
    public int mo8425t() {
        return this.f497s;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: u */
    public int mo8426u() {
        return this.f491m;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: v */
    public int mo8427v() {
        return this.f493o;
    }
}
