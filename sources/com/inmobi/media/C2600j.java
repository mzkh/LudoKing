package com.inmobi.media;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.inmobi.ads.rendering.InMobiAdActivity;
import com.inmobi.media.C2325df.C2326a;
import com.inmobi.media.C2325df.C2328c;
import com.inmobi.media.C2344ds.C2345a;
import com.inmobi.media.C2426eq.C2431e;
import com.inmobi.media.C2426eq.C2432f;
import com.inmobi.media.C2426eq.C2433g;
import com.inmobi.media.C2452f.C2453a;
import com.inmobi.media.C2585ht.C25861;
import com.inmobi.media.C2585ht.C2590a;
import com.tapjoy.TJAdUnitConstants.String;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"SetJavaScriptEnabled", "ViewConstructor", "ClickableViewAccessibility"})
/* renamed from: com.inmobi.media.j */
/* compiled from: RenderView */
public final class C2600j extends WebView implements C2452f, C2496g, C2590a {

    /* renamed from: a */
    public static final C2618a f5757a = new C2618a() {
        /* renamed from: a */
        public final void mo28525a() {
        }

        /* renamed from: a */
        public final void mo28526a(C2600j jVar) {
        }

        /* renamed from: a */
        public final void mo28527a(C2600j jVar, @NonNull HashMap<Object, Object> hashMap) {
        }

        /* renamed from: a */
        public final void mo28528a(String str, Map<String, Object> map) {
        }

        /* renamed from: b */
        public final void mo28529b() {
        }

        /* renamed from: b */
        public final void mo28530b(C2600j jVar) {
        }

        /* renamed from: b */
        public final void mo28531b(C2600j jVar, @NonNull HashMap<Object, Object> hashMap) {
        }

        /* renamed from: c */
        public final void mo28533c(C2600j jVar) {
        }

        /* renamed from: d */
        public final void mo28534d(C2600j jVar) {
        }

        /* renamed from: e */
        public final void mo28535e(C2600j jVar) {
        }

        /* renamed from: f */
        public final void mo28536f(C2600j jVar) {
        }

        /* renamed from: g */
        public final void mo28537g(C2600j jVar) {
        }

        /* renamed from: h */
        public final void mo28538h(C2600j jVar) {
        }

        /* renamed from: i */
        public final void mo28539i(C2600j jVar) {
        }

        /* renamed from: j */
        public final void mo28540j(C2600j jVar) {
        }

        /* renamed from: c */
        public final C2591hu mo28532c() {
            return C2591hu.m5639b().mo28610a();
        }
    };

    /* renamed from: ak */
    private static final C2326a f5758ak = new C2326a() {
        /* renamed from: a */
        public final boolean mo28178a(@Nullable View view, @Nullable View view2, int i, @NonNull Object obj) {
            if (view2 == null || view2.getVisibility() != 0 || view == null || view.getParent() == null || !view2.isShown()) {
                return false;
            }
            C2600j jVar = null;
            if (view2 instanceof C2600j) {
                jVar = (C2600j) view2;
            }
            if (jVar == null) {
                return false;
            }
            return jVar.m5700a(i);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: x */
    public static final String f5759x = C2600j.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f5760A = false;

    /* renamed from: B */
    private WeakReference<ViewGroup> f5761B;

    /* renamed from: C */
    private C2618a f5762C;

    /* renamed from: D */
    private C2426eq f5763D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public List<String> f5764E = new ArrayList();

    /* renamed from: F */
    private boolean f5765F;

    /* renamed from: G */
    private C2256bx f5766G;

    /* renamed from: H */
    private C2275ce f5767H;

    /* renamed from: I */
    private C2274cd f5768I;

    /* renamed from: J */
    private JSONObject f5769J;

    /* renamed from: K */
    private JSONObject f5770K;

    /* renamed from: L */
    private boolean f5771L = true;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public boolean f5772M = false;

    /* renamed from: N */
    private final Object f5773N = new Object();

    /* renamed from: O */
    private final Object f5774O = new Object();

    /* renamed from: P */
    private boolean f5775P = true;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public View f5776Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public CustomViewCallback f5777R;

    /* renamed from: S */
    private int f5778S = -1;

    /* renamed from: T */
    private boolean f5779T = false;

    /* renamed from: U */
    private long f5780U = Long.MIN_VALUE;

    /* renamed from: V */
    private String f5781V;

    /* renamed from: W */
    private String f5782W;

    /* renamed from: aa */
    private C2452f f5783aa;

    /* renamed from: ab */
    private boolean f5784ab = false;

    /* renamed from: ac */
    private boolean f5785ac;
    @Nullable

    /* renamed from: ad */
    private C2325df f5786ad;
    @Nullable

    /* renamed from: ae */
    private Set<C2298cs> f5787ae;

    /* renamed from: af */
    private C2300cu f5788af;

    /* renamed from: ag */
    private boolean f5789ag;

    /* renamed from: ah */
    private boolean f5790ah = true;

    /* renamed from: ai */
    private int f5791ai;

    /* renamed from: aj */
    private int f5792aj;

    /* renamed from: al */
    private final C2453a f5793al = new C2453a() {
        /* renamed from: a */
        public final void mo28374a() {
            C2600j.f5759x;
            C2600j.this.getListener().mo28535e(C2600j.this);
        }

        /* renamed from: a */
        public final void mo28375a(Object obj) {
            C2600j.f5759x;
            if (C2600j.this.f5798d == 0) {
                String str = "Expanded";
                if (C2600j.this.f5818y != null) {
                    C2600j.this.f5818y.setAndUpdateViewState(str);
                } else {
                    C2600j.this.setAndUpdateViewState(str);
                }
                C2600j.this.f5812r = false;
            }
            C2600j.this.getListener().mo28536f(C2600j.this);
        }

        /* renamed from: b */
        public final void mo28376b(Object obj) {
            C2600j.f5759x;
            String str = "Default";
            if (C2600j.this.f5798d == 0) {
                C2600j.this.setAndUpdateViewState(str);
                if (C2600j.this.f5818y != null) {
                    C2600j.this.f5818y.setAndUpdateViewState(str);
                }
            } else if (str.equals(C2600j.this.f5797c)) {
                C2600j.this.setAndUpdateViewState("Hidden");
            }
            C2600j.this.getListener().mo28537g(C2600j.this);
        }
    };

    /* renamed from: am */
    private final WebViewClient f5794am = new WebViewClient() {
        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            C2600j.f5759x;
            if (VERSION.SDK_INT < 21) {
                return false;
            }
            String uri = webResourceRequest.getUrl().toString();
            if (C2600j.this.f5802h) {
                webView.loadUrl(uri);
                return true;
            } else if (C2600j.this.mo28663j() || C2600j.this.f5760A || "about:blank".equals(uri)) {
                C2600j.f5759x;
                C2600j.this.f5798d;
                if (1 != C2600j.this.f5798d) {
                    C2600j.f5759x;
                    if (C2513gg.m5335a(C2600j.this.getContainerContext(), uri, null) != null) {
                        C2600j.this.getListener().mo28539i(C2600j.this);
                    }
                    return true;
                } else if (!C2600j.this.f5760A || !C2513gg.m5338a(uri)) {
                    C2600j.f5759x;
                    if (C2513gg.m5335a(C2600j.this.getContainerContext(), uri, null) != null) {
                        C2600j.this.getListener().mo28539i(C2600j.this);
                    }
                    return true;
                } else {
                    C2600j.f5759x;
                    return false;
                }
            } else {
                C2600j.this.mo28632d("redirect");
                return true;
            }
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            C2600j.f5759x;
            if (C2600j.this.f5802h) {
                webView.loadUrl(str);
                return true;
            } else if (C2600j.this.mo28663j() || C2600j.this.f5760A || "about:blank".equals(str)) {
                C2600j.f5759x;
                C2600j.this.f5798d;
                if (1 != C2600j.this.f5798d) {
                    C2600j.f5759x;
                    if (C2513gg.m5335a(C2600j.this.getContainerContext(), str, null) != null) {
                        C2600j.this.getListener().mo28539i(C2600j.this);
                    }
                    return true;
                } else if (!C2600j.this.f5760A || !C2513gg.m5338a(str)) {
                    C2600j.f5759x;
                    if (C2513gg.m5335a(C2600j.this.getContainerContext(), str, null) != null) {
                        C2600j.this.getListener().mo28539i(C2600j.this);
                    }
                    return true;
                } else {
                    C2600j.f5759x;
                    return false;
                }
            } else {
                C2600j.this.mo28632d("redirect");
                return true;
            }
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            C2600j.f5759x;
            C2600j.this.f5772M = false;
            C2600j.this.setAndUpdateViewState("Loading");
        }

        public final void onPageFinished(WebView webView, String str) {
            C2600j.f5759x;
            if (C2600j.this.f5764E.contains(str) && !C2600j.this.f5772M) {
                C2600j.this.f5772M = true;
                C2600j.f5759x;
                C2600j jVar = C2600j.this;
                jVar.mo28633e(jVar.getMraidJsString());
            }
            if ("Loading".equals(C2600j.this.f5797c)) {
                C2600j.this.getListener().mo28533c(C2600j.this);
                C2600j.m5717j(C2600j.this);
                if (C2600j.this.f5818y != null) {
                    C2600j.this.setAndUpdateViewState("Expanded");
                    return;
                }
                C2600j.this.setAndUpdateViewState("Default");
            }
        }

        public final void onLoadResource(WebView webView, String str) {
            C2600j.f5759x;
            String url = C2600j.this.getUrl();
            if (str != null && url != null && str.contains("/mraid.js") && !"about:blank".equals(url) && !url.startsWith("file:")) {
                if (!C2600j.this.f5764E.contains(url)) {
                    C2600j.this.f5764E.add(url);
                }
                if (!C2600j.this.f5772M) {
                    C2600j.this.f5772M = true;
                    C2600j.f5759x;
                    C2600j jVar = C2600j.this;
                    jVar.mo28633e(jVar.getMraidJsString());
                }
            }
        }

        @TargetApi(22)
        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            C2600j.f5759x;
        }

        @TargetApi(23)
        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            C2600j.f5759x;
            StringBuilder sb = new StringBuilder("Loading error. Error code:");
            sb.append(webResourceError.getErrorCode());
            sb.append(" Error msg:");
            sb.append(webResourceError.getDescription());
            sb.append(" Failing url:");
            sb.append(webResourceRequest.getUrl());
        }
    };

    /* renamed from: an */
    private final WebChromeClient f5795an = new WebChromeClient() {
        public final boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
            C2600j.f5759x;
            if (C2600j.m5702a(C2600j.this, jsResult)) {
                Activity fullScreenActivity = C2600j.this.getFullScreenActivity();
                if (fullScreenActivity != null) {
                    new Builder(fullScreenActivity).setMessage(str2).setTitle(str).setPositiveButton(17039370, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            jsResult.confirm();
                        }
                    }).setCancelable(false).create().show();
                } else {
                    jsResult.cancel();
                }
            }
            return true;
        }

        public final boolean onJsConfirm(WebView webView, String str, String str2, final JsResult jsResult) {
            C2600j.f5759x;
            if (C2600j.m5702a(C2600j.this, jsResult)) {
                Activity fullScreenActivity = C2600j.this.getFullScreenActivity();
                if (fullScreenActivity != null) {
                    new Builder(fullScreenActivity).setMessage(str2).setPositiveButton(17039370, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            jsResult.confirm();
                        }
                    }).setNegativeButton(17039360, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            jsResult.cancel();
                        }
                    }).create().show();
                } else {
                    jsResult.cancel();
                }
            }
            return true;
        }

        public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            C2600j.f5759x;
            if (!C2600j.m5702a(C2600j.this, (JsResult) jsPromptResult)) {
                return true;
            }
            if (C2600j.this.getFullScreenActivity() != null) {
                return false;
            }
            jsPromptResult.cancel();
            return true;
        }

        public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
            if (C2600j.this.f5796b != null && C2600j.this.f5796b.get() != null) {
                C2600j.this.f5776Q = view;
                C2600j.this.f5777R = customViewCallback;
                C2600j.this.f5776Q.setOnTouchListener(new OnTouchListener() {
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return true;
                    }
                });
                FrameLayout frameLayout = (FrameLayout) ((Activity) C2600j.this.f5796b.get()).findViewById(16908290);
                C2600j.this.f5776Q.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                frameLayout.addView(C2600j.this.f5776Q, new LayoutParams(-1, -1, 0, 0));
                C2600j.this.f5776Q.requestFocus();
                View l = C2600j.this.f5776Q;
                l.setOnKeyListener(new OnKeyListener() {
                    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                        if (4 != keyEvent.getKeyCode() || keyEvent.getAction() != 0) {
                            return false;
                        }
                        C2600j.f5759x;
                        C26098.this.m5772a();
                        return true;
                    }
                });
                l.setFocusable(true);
                l.setFocusableInTouchMode(true);
                l.requestFocus();
            }
        }

        public final void onHideCustomView() {
            m5772a();
            super.onHideCustomView();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m5772a() {
            if (C2600j.this.f5776Q != null) {
                if (C2600j.this.f5777R != null) {
                    C2600j.this.f5777R.onCustomViewHidden();
                    C2600j.this.f5777R = null;
                }
                if (!(C2600j.this.f5776Q == null || C2600j.this.f5776Q.getParent() == null)) {
                    ((ViewGroup) C2600j.this.f5776Q.getParent()).removeView(C2600j.this.f5776Q);
                    C2600j.this.f5776Q = null;
                }
            }
        }

        public final void onGeolocationPermissionsShowPrompt(final String str, final Callback callback) {
            if (!(C2600j.this.f5796b == null || C2600j.this.f5796b.get() == null)) {
                new Builder((Context) C2600j.this.f5796b.get()).setTitle("Location Permission").setMessage("Allow location access").setPositiveButton(17039370, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        callback.invoke(str, true, false);
                    }
                }).setNegativeButton(17039360, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        callback.invoke(str, false, false);
                    }
                }).create().show();
            }
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }

        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            consoleMessage.message();
            consoleMessage.lineNumber();
            consoleMessage.sourceId();
            C2600j.f5759x;
            return true;
        }
    };

    /* renamed from: b */
    public WeakReference<Activity> f5796b;

    /* renamed from: c */
    public String f5797c = "Default";

    /* renamed from: d */
    public int f5798d;

    /* renamed from: e */
    public C2261bz f5799e;

    /* renamed from: f */
    public C2272cc f5800f;

    /* renamed from: g */
    public C2265cb f5801g;

    /* renamed from: h */
    public boolean f5802h;

    /* renamed from: i */
    public boolean f5803i = true;

    /* renamed from: j */
    public boolean f5804j = true;

    /* renamed from: k */
    public boolean f5805k = false;

    /* renamed from: l */
    public boolean f5806l = false;

    /* renamed from: m */
    public boolean f5807m = false;

    /* renamed from: n */
    public boolean f5808n = false;

    /* renamed from: o */
    public boolean f5809o = false;

    /* renamed from: p */
    public String f5810p = null;

    /* renamed from: q */
    public AtomicBoolean f5811q = new AtomicBoolean(false);

    /* renamed from: r */
    public boolean f5812r;

    /* renamed from: s */
    public String f5813s;

    /* renamed from: t */
    public C2649p f5814t;

    /* renamed from: u */
    public boolean f5815u;

    /* renamed from: v */
    public boolean f5816v;

    /* renamed from: w */
    public final C2182ap f5817w = new C2182ap() {
        /* renamed from: a */
        public final void mo27888a(C2156ae aeVar) {
            if (aeVar.f4358f != null && aeVar.f4353a.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", ((C2154ad) aeVar.f4353a.get(0)).f4336d);
                    jSONObject.put("reason", ((C2154ad) aeVar.f4353a.get(0)).f4344l);
                } catch (JSONException unused) {
                }
                String replace = jSONObject.toString().replace("\"", "\\\"");
                StringBuilder sb = new StringBuilder("sendSaveContentResult(\"saveContent_");
                sb.append(aeVar.f4359g);
                sb.append("\", 'failed', \"");
                sb.append(replace);
                sb.append("\");");
                String sb2 = sb.toString();
                C2600j.f5759x;
                C2600j.this.mo28624a(aeVar.f4358f, sb2);
            }
        }

        /* renamed from: b */
        public final void mo27889b(C2156ae aeVar) {
            if (aeVar.f4358f != null && aeVar.f4353a.size() > 0) {
                StringBuilder sb = new StringBuilder("sendSaveContentResult(\"saveContent_");
                sb.append(aeVar.f4359g);
                sb.append("\", 'success', \"");
                sb.append(((C2154ad) aeVar.f4353a.get(0)).f4343k);
                sb.append("\");");
                String sb2 = sb.toString();
                C2600j.f5759x;
                C2600j.this.mo28624a(aeVar.f4358f, sb2);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: y */
    public C2600j f5818y;
    @Nullable

    /* renamed from: z */
    private WeakReference<Activity> f5819z;

    /* renamed from: com.inmobi.media.j$a */
    /* compiled from: RenderView */
    public interface C2618a {
        /* renamed from: a */
        void mo28525a();

        /* renamed from: a */
        void mo28526a(C2600j jVar);

        /* renamed from: a */
        void mo28527a(C2600j jVar, @NonNull HashMap<Object, Object> hashMap);

        /* renamed from: a */
        void mo28528a(String str, Map<String, Object> map);

        /* renamed from: b */
        void mo28529b();

        /* renamed from: b */
        void mo28530b(C2600j jVar);

        /* renamed from: b */
        void mo28531b(C2600j jVar, @NonNull HashMap<Object, Object> hashMap);

        /* renamed from: c */
        C2591hu mo28532c();

        /* renamed from: c */
        void mo28533c(C2600j jVar);

        /* renamed from: d */
        void mo28534d(C2600j jVar);

        /* renamed from: e */
        void mo28535e(C2600j jVar);

        /* renamed from: f */
        void mo28536f(C2600j jVar);

        /* renamed from: g */
        void mo28537g(C2600j jVar);

        /* renamed from: h */
        void mo28538h(C2600j jVar);

        /* renamed from: i */
        void mo28539i(C2600j jVar);

        /* renamed from: j */
        void mo28540j(C2600j jVar);
    }

    public final Object getDataModel() {
        return null;
    }

    public final String getMarkupType() {
        return String.HTML;
    }

    @Nullable
    public final View getVideoContainerView() {
        return null;
    }

    public C2600j(Context context, int i, @Nullable Set<C2298cs> set, @Nullable String str) {
        super(context.getApplicationContext());
        if (context instanceof Activity) {
            this.f5819z = new WeakReference<>((Activity) context);
        }
        this.f5818y = null;
        this.f5798d = i;
        this.f5812r = false;
        this.f5787ae = set;
        this.f5813s = str;
        setReferenceContainer(this);
        this.f5783aa = this;
        this.f5785ac = false;
        this.f5816v = true;
    }

    public final void setAdSize(@NonNull String str) {
        this.f5781V = str;
        String str2 = "x";
        this.f5792aj = C2528gq.m5392a(Integer.parseInt(str.split(str2)[0]));
        this.f5791ai = C2528gq.m5392a(Integer.parseInt(str.split(str2)[1]));
    }

    public final int getHeightInPixel() {
        return this.f5791ai;
    }

    public final int getWidthInPixel() {
        return this.f5792aj;
    }

    public final void setIsPreload(boolean z) {
        this.f5815u = z;
    }

    public final void setPlacementId(long j) {
        this.f5780U = j;
    }

    public final void setImpressionId(String str) {
        this.f5813s = str;
    }

    public final void setCreativeId(String str) {
        this.f5782W = str;
    }

    public final void setAllowAutoRedirection(boolean z) {
        this.f5784ab = z;
    }

    public final void setBlobProvider(C2649p pVar) {
        this.f5814t = pVar;
    }

    public final String getImpressionId() {
        return this.f5813s;
    }

    public final String getCreativeId() {
        return this.f5782W;
    }

    public final long getPlacementId() {
        return this.f5780U;
    }

    public final boolean getAllowAutoRedirection() {
        return this.f5784ab;
    }

    public final void setOriginalRenderView(C2600j jVar) {
        this.f5818y = jVar;
    }

    public final C2600j getOriginalRenderView() {
        return this.f5818y;
    }

    public final C2453a getFullScreenEventsListener() {
        return this.f5793al;
    }

    public final int getPlacementType() {
        return this.f5798d;
    }

    public final String getState() {
        return this.f5797c;
    }

    public final Object getDefaultPositionMonitor() {
        return this.f5773N;
    }

    public final Object getCurrentPositionMonitor() {
        return this.f5774O;
    }

    public final void setShouldFireRenderBeacon(boolean z) {
        this.f5790ah = z;
    }

    @NonNull
    public final Context getContainerContext() {
        WeakReference<Activity> weakReference = this.f5796b;
        if (weakReference == null || weakReference.get() == null) {
            return getContext();
        }
        return (Context) this.f5796b.get();
    }

    /* renamed from: g */
    public final void mo28635g() {
        int[] iArr = new int[2];
        this.f5769J = new JSONObject();
        if (this.f5761B == null) {
            this.f5761B = new WeakReference<>((ViewGroup) getParent());
        }
        if (this.f5761B.get() != null) {
            ((ViewGroup) this.f5761B.get()).getLocationOnScreen(iArr);
            try {
                this.f5769J.put("x", C2528gq.m5396b(iArr[0]));
                this.f5769J.put("y", C2528gq.m5396b(iArr[1]));
                int b = C2528gq.m5396b(((ViewGroup) this.f5761B.get()).getWidth());
                int b2 = C2528gq.m5396b(((ViewGroup) this.f5761B.get()).getHeight());
                this.f5769J.put("width", b);
                this.f5769J.put("height", b2);
            } catch (JSONException unused) {
            }
        } else {
            this.f5769J.put("x", 0);
            this.f5769J.put("y", 0);
            this.f5769J.put("width", 0);
            this.f5769J.put("height", 0);
        }
        synchronized (this.f5773N) {
            this.f5803i = false;
            this.f5773N.notifyAll();
        }
    }

    public final String getDefaultPosition() {
        JSONObject jSONObject = this.f5769J;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    /* renamed from: h */
    public final void mo28661h() {
        this.f5770K = new JSONObject();
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        try {
            this.f5770K.put("x", C2528gq.m5396b(iArr[0]));
            this.f5770K.put("y", C2528gq.m5396b(iArr[1]));
            int b = C2528gq.m5396b(getWidth());
            int b2 = C2528gq.m5396b(getHeight());
            this.f5770K.put("width", b);
            this.f5770K.put("height", b2);
        } catch (JSONException unused) {
        }
        synchronized (this.f5774O) {
            this.f5804j = false;
            this.f5774O.notifyAll();
        }
    }

    public final String getCurrentPosition() {
        JSONObject jSONObject = this.f5770K;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public final void setFullScreenActivityContext(Activity activity) {
        this.f5796b = new WeakReference<>(activity);
        C2274cd cdVar = this.f5768I;
        if (cdVar != null) {
            setOrientationProperties(cdVar);
        }
    }

    @Nullable
    public final Activity getFullScreenActivity() {
        WeakReference<Activity> weakReference = this.f5796b;
        if (weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    public final Activity getPubActivity() {
        WeakReference<Activity> weakReference = this.f5819z;
        if (weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    public final C2433g getRenderingConfig() {
        return this.f5763D.f5180g;
    }

    public final C2431e getMraidConfig() {
        return this.f5763D.f5181h;
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != 0 && i2 != 0) {
            int b = C2528gq.m5396b(i);
            int b2 = C2528gq.m5396b(i2);
            StringBuilder sb = new StringBuilder("window.mraidview.broadcastEvent('sizeChange',");
            sb.append(b);
            sb.append(",");
            sb.append(b2);
            sb.append(");");
            mo28633e(sb.toString());
        }
    }

    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        boolean z = i == 0;
        if (z && this.f5786ad != null) {
            z = isShown() && m5700a(getAdConfig().f5182i.f5239i);
        }
        m5708d(z);
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.f5779T = !z;
        C2325df dfVar = this.f5786ad;
        if (dfVar != null) {
            if (z) {
                dfVar.mo28181a(this, this, null, getAdConfig().f5182i.f5239i);
                z = isShown() && m5700a(getAdConfig().f5182i.f5239i);
            } else {
                dfVar.mo28180a((View) this);
            }
        }
        m5707c(z);
    }

    public final void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        if (i == 0) {
            m5707c(false);
            return;
        }
        if (!this.f5779T) {
            m5707c(true);
        }
    }

    /* renamed from: c */
    private void m5707c(boolean z) {
        if (this.f5807m != z) {
            if (VERSION.SDK_INT <= 23 || getFullScreenActivity() == null || !getFullScreenActivity().isInMultiWindowMode()) {
                m5708d(z);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m5708d(boolean z) {
        if (this.f5807m != z && !this.f5812r) {
            this.f5807m = z;
            if (z) {
                getListener().mo28534d(this);
            }
            m5711e(this.f5807m);
        }
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f5765F = isHardwareAccelerated();
        C2325df dfVar = this.f5786ad;
        if (dfVar != null) {
            dfVar.mo28181a(this, this, null, getAdConfig().f5182i.f5239i);
            this.f5786ad.mo28159d();
        }
        if (this.f5761B == null) {
            this.f5761B = new WeakReference<>((ViewGroup) getParent());
        }
        if (this.f5790ah) {
            if (this.f5789ag) {
                C2585ht htVar = new C2585ht(this, this);
                long c = (long) getListener().mo28532c().mo28589c();
                C25861 r3 = new TimerTask() {
                    public final void run() {
                        C2590a aVar = (C2590a) C2585ht.this.f5701c.get();
                        if (!C2585ht.this.f5703e) {
                            C2585ht.this.f5702d = true;
                            if (aVar != null) {
                                aVar.mo28588l();
                            }
                        }
                    }
                };
                View view = (View) htVar.f5700a.get();
                if (view != null) {
                    view.post(new Runnable(r3, c) {

                        /* renamed from: a */
                        final /* synthetic */ TimerTask f5705a;

                        /* renamed from: b */
                        final /* synthetic */ long f5706b;

                        {
                            this.f5705a = r2;
                            this.f5706b = r3;
                        }

                        public final void run() {
                            final C2590a aVar = (C2590a) C2585ht.this.f5701c.get();
                            final Timer timer = new Timer();
                            timer.schedule(this.f5705a, this.f5706b);
                            new Thread(new Runnable() {
                                /* JADX WARNING: Code restructure failed: missing block: B:23:0x0083, code lost:
                                    if (r0 != null) goto L_0x0085;
                                 */
                                /* JADX WARNING: Code restructure failed: missing block: B:24:0x0085, code lost:
                                    r0.mo28588l();
                                 */
                                /* JADX WARNING: Code restructure failed: missing block: B:30:0x009f, code lost:
                                    r0 = r0;
                                 */
                                /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a1, code lost:
                                    if (r0 != null) goto L_0x00a3;
                                 */
                                /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a3, code lost:
                                    r0.mo28588l();
                                 */
                                /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a6, code lost:
                                    return;
                                 */
                                /* JADX WARNING: Failed to process nested try/catch */
                                /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0081 */
                                /* Code decompiled incorrectly, please refer to instructions dump. */
                                public final void run() {
                                    /*
                                        r9 = this;
                                    L_0x0000:
                                        com.inmobi.media.ht$2 r0 = com.inmobi.media.C2585ht.C25872.this     // Catch:{ IllegalStateException -> 0x0081 }
                                        com.inmobi.media.ht r0 = com.inmobi.media.C2585ht.this     // Catch:{ IllegalStateException -> 0x0081 }
                                        java.lang.ref.WeakReference r0 = r0.f5700a     // Catch:{ IllegalStateException -> 0x0081 }
                                        java.lang.Object r0 = r0.get()     // Catch:{ IllegalStateException -> 0x0081 }
                                        android.view.View r0 = (android.view.View) r0     // Catch:{ IllegalStateException -> 0x0081 }
                                        if (r0 == 0) goto L_0x006d
                                        android.graphics.Bitmap r1 = com.inmobi.media.C2585ht.m5630b(r0)     // Catch:{ IllegalStateException -> 0x0081 }
                                        if (r1 == 0) goto L_0x008a
                                        int r0 = r1.getWidth()     // Catch:{ IllegalStateException -> 0x0081 }
                                        int r2 = r1.getHeight()     // Catch:{ IllegalStateException -> 0x0081 }
                                        int r0 = r0 * r2
                                        int[] r0 = new int[r0]     // Catch:{ IllegalStateException -> 0x0081 }
                                        r3 = 0
                                        int r4 = r1.getWidth()     // Catch:{ IllegalStateException -> 0x0081 }
                                        r5 = 0
                                        r6 = 0
                                        int r7 = r1.getWidth()     // Catch:{ IllegalStateException -> 0x0081 }
                                        int r8 = r1.getHeight()     // Catch:{ IllegalStateException -> 0x0081 }
                                        r2 = r0
                                        r1.getPixels(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ IllegalStateException -> 0x0081 }
                                        int r1 = r0.length     // Catch:{ IllegalStateException -> 0x0081 }
                                        r2 = 0
                                    L_0x0037:
                                        if (r2 >= r1) goto L_0x005d
                                        r3 = r0[r2]     // Catch:{ IllegalStateException -> 0x0081 }
                                        r4 = -16777216(0xffffffffff000000, float:-1.7014118E38)
                                        if (r3 <= r4) goto L_0x005a
                                        if (r3 >= 0) goto L_0x005a
                                        com.inmobi.media.C2585ht.f5699b     // Catch:{ IllegalStateException -> 0x0081 }
                                        com.inmobi.media.ht$2 r0 = com.inmobi.media.C2585ht.C25872.this     // Catch:{ IllegalStateException -> 0x0081 }
                                        com.inmobi.media.ht r0 = com.inmobi.media.C2585ht.this     // Catch:{ IllegalStateException -> 0x0081 }
                                        r0.f5703e = true     // Catch:{ IllegalStateException -> 0x0081 }
                                        java.util.Timer r0 = r1     // Catch:{ IllegalStateException -> 0x0081 }
                                        r0.cancel()     // Catch:{ IllegalStateException -> 0x0081 }
                                        com.inmobi.media.ht$a r0 = r0     // Catch:{ IllegalStateException -> 0x0081 }
                                        if (r0 == 0) goto L_0x005d
                                        com.inmobi.media.ht$a r0 = r0     // Catch:{ IllegalStateException -> 0x0081 }
                                        r0.mo28587k()     // Catch:{ IllegalStateException -> 0x0081 }
                                        goto L_0x005d
                                    L_0x005a:
                                        int r2 = r2 + 1
                                        goto L_0x0037
                                    L_0x005d:
                                        com.inmobi.media.ht$2 r0 = com.inmobi.media.C2585ht.C25872.this     // Catch:{ IllegalStateException -> 0x0081 }
                                        com.inmobi.media.ht r0 = com.inmobi.media.C2585ht.this     // Catch:{ IllegalStateException -> 0x0081 }
                                        boolean r0 = r0.f5703e     // Catch:{ IllegalStateException -> 0x0081 }
                                        if (r0 != 0) goto L_0x008a
                                        r0 = 200(0xc8, double:9.9E-322)
                                        java.lang.Thread.sleep(r0)     // Catch:{ IllegalStateException -> 0x0081 }
                                        goto L_0x008a
                                    L_0x006d:
                                        com.inmobi.media.C2585ht.f5699b     // Catch:{ IllegalStateException -> 0x0081 }
                                        java.util.Timer r0 = r1     // Catch:{ IllegalStateException -> 0x0081 }
                                        r0.cancel()     // Catch:{ IllegalStateException -> 0x0081 }
                                        com.inmobi.media.ht$a r0 = r0     // Catch:{ IllegalStateException -> 0x0081 }
                                        if (r0 == 0) goto L_0x008a
                                        com.inmobi.media.ht$a r0 = r0     // Catch:{ IllegalStateException -> 0x0081 }
                                        r0.mo28588l()     // Catch:{ IllegalStateException -> 0x0081 }
                                        goto L_0x008a
                                    L_0x007f:
                                        goto L_0x009f
                                    L_0x0081:
                                        com.inmobi.media.ht$a r0 = r0     // Catch:{ InterruptedException -> 0x007f }
                                        if (r0 == 0) goto L_0x008a
                                        com.inmobi.media.ht$a r0 = r0     // Catch:{ InterruptedException -> 0x007f }
                                        r0.mo28588l()     // Catch:{ InterruptedException -> 0x007f }
                                    L_0x008a:
                                        com.inmobi.media.ht$2 r0 = com.inmobi.media.C2585ht.C25872.this     // Catch:{ InterruptedException -> 0x007f }
                                        com.inmobi.media.ht r0 = com.inmobi.media.C2585ht.this     // Catch:{ InterruptedException -> 0x007f }
                                        boolean r0 = r0.f5702d     // Catch:{ InterruptedException -> 0x007f }
                                        if (r0 != 0) goto L_0x009e
                                        com.inmobi.media.ht$2 r0 = com.inmobi.media.C2585ht.C25872.this     // Catch:{ InterruptedException -> 0x007f }
                                        com.inmobi.media.ht r0 = com.inmobi.media.C2585ht.this     // Catch:{ InterruptedException -> 0x007f }
                                        boolean r0 = r0.f5703e     // Catch:{ InterruptedException -> 0x007f }
                                        if (r0 == 0) goto L_0x0000
                                    L_0x009e:
                                        return
                                    L_0x009f:
                                        com.inmobi.media.ht$a r0 = r0
                                        if (r0 == 0) goto L_0x00a6
                                        r0.mo28588l()
                                    L_0x00a6:
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2585ht.C25872.C25881.run():void");
                                }
                            }).start();
                        }
                    });
                }
                return;
            }
            getListener().mo28525a();
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        motionEvent.getAction();
        this.f5785ac = true;
        if (mo28663j()) {
            mo28633e("window.mraidview.onUserInteraction();");
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void onDetachedFromWindow() {
        this.f5764E.clear();
        getMediaProcessor().mo28096b();
        getMediaProcessor().mo28097c();
        getMediaProcessor().mo28098e();
        C2325df dfVar = this.f5786ad;
        if (dfVar != null) {
            dfVar.mo28184f();
        }
        try {
            super.onDetachedFromWindow();
        } catch (IllegalArgumentException unused) {
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    @TargetApi(19)
    /* renamed from: a */
    public final void mo28623a(C2618a aVar, @NonNull C2426eq eqVar, boolean z, boolean z2) {
        this.f5763D = eqVar;
        if (this.f5798d == 0 && this.f5781V != null) {
            this.f5786ad = new C2305cy(f5758ak, eqVar.f5182i);
            this.f5786ad.f4913c = new C2328c() {
                /* renamed from: a */
                public final void mo28170a(@NonNull List<View> list, @NonNull List<View> list2) {
                    C2600j jVar = C2600j.this;
                    jVar.m5708d(list.contains(jVar));
                }
            };
        }
        this.f5762C = aVar;
        this.f5789ag = z;
        this.f5761B = new WeakReference<>((ViewGroup) getParent());
        this.f5790ah = z2;
        if (getRenderingConfig() != null) {
            setBackgroundColor(getRenderingConfig().f5217e);
        }
        if (getMraidConfig() != null) {
            C2263ca caVar = new C2263ca(getMraidConfig().f5205d, getMraidConfig().f5203b, getMraidConfig().f5204c, getMraidConfig().f5202a);
            if (caVar.f4739a != null) {
                caVar.f4740b = new C2486fr("GET", caVar.f4739a);
                caVar.f4740b.f5444p = false;
                caVar.f4740b.f5450v = false;
                HashMap hashMap = new HashMap();
                hashMap.put("Accept-Encoding", "gzip");
                caVar.f4740b.mo28407a((Map<String, String>) hashMap);
                new Thread(new Runnable() {
                    public final void run() {
                        if (C2263ca.m4586a(C2263ca.this)) {
                            int i = 0;
                            while (true) {
                                if (i > C2263ca.this.f4741d) {
                                    break;
                                }
                                C2263ca.f4738c;
                                long elapsedRealtime = SystemClock.elapsedRealtime();
                                C2487fs a = new C2488ft(C2263ca.this.f4740b).mo28422a();
                                try {
                                    C2566hi.m5571a().mo28564a(C2263ca.this.f4740b.mo28416i());
                                    C2566hi.m5571a().mo28565b(a.mo28421d());
                                    C2566hi.m5571a().mo28566c(SystemClock.elapsedRealtime() - elapsedRealtime);
                                } catch (Exception unused) {
                                    C2263ca.f4738c;
                                }
                                Context c = C2505gd.m5298c();
                                if (a.mo28417a()) {
                                    C2263ca.f4738c;
                                    i++;
                                    if (i > C2263ca.this.f4741d) {
                                        break;
                                    }
                                    try {
                                        Thread.sleep((long) (C2263ca.this.f4742e * 1000));
                                    } catch (InterruptedException unused2) {
                                        C2263ca.f4738c;
                                    }
                                } else if (c != null) {
                                    C2517gk gkVar = new C2517gk(c, "mraid_js_store");
                                    List list = (List) a.f5454c.get("Content-Encoding");
                                    String str = "mraid_js_string";
                                    if (list == null || !((String) list.get(0)).equals("gzip")) {
                                        gkVar.mo28469a(str, a.mo28418b());
                                        C2263ca.f4738c;
                                    } else {
                                        C2263ca.f4738c;
                                        byte[] a2 = C2515gi.m5355a(a.mo28420c());
                                        if (a2 != null) {
                                            try {
                                                gkVar.mo28469a(str, new String(a2, "UTF-8"));
                                                C2263ca.f4738c;
                                                return;
                                            } catch (UnsupportedEncodingException unused3) {
                                                C2263ca.f4738c;
                                                C2263ca.f4738c;
                                            }
                                        }
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }).start();
            }
        }
        if (VERSION.SDK_INT >= 16) {
            setImportantForAccessibility(2);
        }
        setScrollable(false);
        if (VERSION.SDK_INT >= 17) {
            getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        getSettings().setJavaScriptEnabled(true);
        getSettings().setGeolocationEnabled(true);
        setWebViewClient(this.f5794am);
        setWebChromeClient(this.f5795an);
        addJavascriptInterface(new C2243bw(this, this.f5798d), "sdkController");
        this.f5799e = new C2261bz(this);
        this.f5800f = new C2272cc(this);
        this.f5801g = new C2265cb(this);
        this.f5766G = new C2256bx();
        this.f5767H = new C2275ce();
        this.f5768I = new C2274cd();
    }

    /* access modifiers changed from: protected */
    public final void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        C2325df dfVar = this.f5786ad;
        boolean z = false;
        if (dfVar == null) {
            if (i == 0) {
                z = true;
            }
            m5708d(z);
        } else if (i == 0) {
            dfVar.mo28181a(view, this, null, getAdConfig().f5182i.f5239i);
        } else {
            dfVar.mo28180a((View) this);
            m5708d(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m5700a(int i) {
        if (this.f5791ai > 0 && this.f5792aj > 0) {
            Rect rect = new Rect();
            if (!getGlobalVisibleRect(rect)) {
                return false;
            }
            long j = (long) (this.f5791ai * this.f5792aj);
            long height = ((long) rect.height()) * ((long) rect.width());
            if (j > 0 && height * 100 >= ((long) i) * j) {
                return true;
            }
        }
        return false;
    }

    public final void setScrollable(boolean z) {
        setScrollContainer(z);
        setVerticalScrollBarEnabled(z);
        setHorizontalScrollBarEnabled(z);
    }

    public final void setIsInAppBrowser(boolean z) {
        this.f5760A = z;
    }

    /* renamed from: c */
    public final boolean mo28361c() {
        return this.f5811q.get();
    }

    /* renamed from: i */
    public final void mo28662i() {
        super.destroy();
    }

    @TargetApi(11)
    public final void destroy() {
        if (!this.f5811q.get()) {
            if (!this.f5771L) {
                this.f5771L = true;
                return;
            }
            this.f5811q.set(true);
            this.f5812r = true;
            this.f5778S = -1;
            removeJavascriptInterface("sdkController");
            WeakReference<Activity> weakReference = this.f5796b;
            if (weakReference != null) {
                Activity activity = (Activity) weakReference.get();
                if (activity != null) {
                    activity.finish();
                }
                this.f5796b.clear();
            }
            WeakReference<ViewGroup> weakReference2 = this.f5761B;
            if (weakReference2 != null) {
                weakReference2.clear();
            }
            C2300cu cuVar = this.f5788af;
            if (cuVar != null) {
                cuVar.mo28152d();
                this.f5788af.mo28153e();
            }
            this.f5762C = null;
            this.f5783aa = null;
            ViewParent parent = getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(this);
                removeAllViews();
            }
            C2432f fVar = this.f5763D.f5182i.f5242l;
            if (!this.f5816v || !fVar.f5211f || !C2345a.f4975a.mo28199a()) {
                super.destroy();
                return;
            }
            C2421em emVar = new C2421em(this, fVar.f5212g);
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    C2424ep epVar = C2424ep.this;
                    epVar.mo28335a(epVar.f5169a);
                    C2424ep.this.f5169a = null;
                }
            }, emVar.f5170b);
        }
    }

    /* renamed from: a */
    public final void mo28358a(int i, Map<String, String> map) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                }
                return;
            }
            mo28633e("inmobi.recordEvent(120,null);");
        }
    }

    /* renamed from: d */
    public final void mo28362d() {
        if (getFullScreenActivity() != null) {
            C2274cd cdVar = this.f5768I;
            if (cdVar != null) {
                setOrientationProperties(cdVar);
            }
        }
    }

    public final void setReferenceContainer(C2452f fVar) {
        this.f5783aa = fVar;
    }

    public final C2452f getReferenceContainer() {
        return this.f5783aa;
    }

    @NonNull
    public final C2426eq getAdConfig() {
        return this.f5763D;
    }

    @SuppressLint({"SwitchIntDef"})
    @NonNull
    public final C2300cu getViewableAd() {
        String str = "deferred";
        if (this.f5788af == null) {
            this.f5788af = new C2302cv(this);
            Set<C2298cs> set = this.f5787ae;
            if (set != null) {
                for (C2298cs csVar : set) {
                    try {
                        int i = csVar.f4851a;
                        boolean z = true;
                        if (i == 1) {
                            this.f5788af = new C2331dh(this, getContext(), this.f5788af, csVar.f4852b);
                        } else if (i == 3) {
                            C2336dl dlVar = (C2336dl) csVar.f4852b.get("omidAdSession");
                            if (!csVar.f4852b.containsKey(str) || !((Boolean) csVar.f4852b.get(str)).booleanValue()) {
                                z = false;
                            }
                            String str2 = (String) csVar.f4852b.get("customReferenceData");
                            if (z) {
                                dlVar.mo28194a(C2341dp.m4846a(this, str2));
                            }
                            if (dlVar != null) {
                                this.f5788af = new C2341dp(this, this.f5788af, dlVar);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return this.f5788af;
    }

    /* renamed from: b */
    public final void mo28627b(String str) {
        this.f5812r = false;
        if (!this.f5811q.get()) {
            loadDataWithBaseURL("", str, "text/html", "UTF-8", null);
        }
    }

    /* renamed from: c */
    public final void mo28630c(String str) {
        this.f5812r = false;
        if (!this.f5811q.get()) {
            loadUrl(str);
        }
    }

    public final void stopLoading() {
        if (!this.f5811q.get()) {
            super.stopLoading();
        }
    }

    /* renamed from: e */
    private void m5711e(boolean z) {
        StringBuilder sb = new StringBuilder("window.mraidview.broadcastEvent('viewableChange',");
        sb.append(z);
        sb.append(");");
        mo28633e(sb.toString());
    }

    /* renamed from: b */
    public final void mo28628b(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder("broadcastEvent('error',\"");
        sb.append(str2);
        sb.append("\", \"");
        sb.append(str3);
        sb.append("\")");
        mo28624a(str, sb.toString());
    }

    /* renamed from: a */
    public final void mo28624a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".");
        sb.append(str2);
        mo28633e(sb.toString());
    }

    /* renamed from: e */
    public final void mo28633e(final String str) {
        if (getContainerContext() != null) {
            new Handler(getContainerContext().getMainLooper()).post(new Runnable() {
                public final void run() {
                    try {
                        if (!C2600j.this.f5811q.get()) {
                            StringBuilder sb = new StringBuilder("javascript:try{");
                            sb.append(str);
                            sb.append("}catch(e){}");
                            String sb2 = sb.toString();
                            C2600j.f5759x;
                            if (VERSION.SDK_INT < 19) {
                                C2600j.this.loadUrl(sb2);
                                return;
                            }
                            C2600j.this.evaluateJavascript(sb2, null);
                        }
                    } catch (Exception unused) {
                        C2600j.f5759x;
                    }
                }
            });
        }
    }

    public final void setUseCustomClose(boolean z) {
        this.f5805k = z;
    }

    public final void setCloseRegionDisabled(boolean z) {
        this.f5808n = z;
    }

    public final void setDisableBackButton(boolean z) {
        this.f5809o = z;
    }

    /* renamed from: a */
    public final void mo28626a(boolean z) {
        setCloseRegionDisabled(z);
        View rootView = getRootView();
        if (rootView != null) {
            C2242bv bvVar = (C2242bv) rootView.findViewById(65531);
            if (bvVar != null) {
                bvVar.setVisibility(this.f5808n ? 8 : 0);
            }
        }
    }

    /* renamed from: b */
    public final void mo28629b(boolean z) {
        setUseCustomClose(z);
        if (getRootView() != null) {
            C2242bv bvVar = (C2242bv) getRootView().findViewById(65532);
            if (bvVar != null) {
                bvVar.setVisibility(this.f5805k ? 8 : 0);
            }
        }
    }

    /* renamed from: b */
    public final void mo28360b() {
        C2265cb cbVar = this.f5801g;
        if (cbVar.f4747b != null) {
            cbVar.f4747b.mo28071a();
            cbVar.f4747b = null;
        }
        String str = "Default";
        if ("Expanded".equals(this.f5797c)) {
            if (!str.equals(this.f5797c)) {
                this.f5812r = true;
                C2261bz bzVar = this.f5799e;
                if (bzVar.f4734a.getOriginalRenderView() == null) {
                    View findViewById = bzVar.f4736c.getRootView().findViewById(65535);
                    ((ViewGroup) bzVar.f4734a.getParent()).removeView(bzVar.f4734a);
                    ((ViewGroup) findViewById.getParent()).removeView(findViewById);
                    bzVar.f4736c.addView(bzVar.f4734a, bzVar.f4737d, new RelativeLayout.LayoutParams(bzVar.f4736c.getWidth(), bzVar.f4736c.getHeight()));
                    bzVar.f4734a.m5723o();
                }
                m5722n();
                this.f5812r = false;
            }
            this.f5771L = false;
        } else {
            if ("Resized".equals(this.f5797c)) {
                if (!str.equals(this.f5797c)) {
                    this.f5812r = true;
                    C2272cc ccVar = this.f5800f;
                    ViewGroup viewGroup = (ViewGroup) ccVar.f4763a.getParent();
                    View findViewById2 = viewGroup.getRootView().findViewById(65534);
                    View findViewById3 = ccVar.f4764b.getRootView().findViewById(65535);
                    ((ViewGroup) findViewById2.getParent()).removeView(findViewById2);
                    if (!(findViewById3 == null || findViewById3.getParent() == null)) {
                        ((ViewGroup) findViewById3.getParent()).removeView(findViewById3);
                    }
                    viewGroup.removeView(ccVar.f4763a);
                    ccVar.f4764b.addView(ccVar.f4763a, ccVar.f4765c, new RelativeLayout.LayoutParams(ccVar.f4764b.getWidth(), ccVar.f4764b.getHeight()));
                    ccVar.f4763a.m5723o();
                    setAndUpdateViewState(str);
                    getListener().mo28537g(this);
                    this.f5812r = false;
                }
            } else if (str.equals(this.f5797c)) {
                setAndUpdateViewState("Hidden");
                if (1 == this.f5798d) {
                    m5722n();
                } else {
                    ((ViewGroup) getParent()).removeAllViews();
                }
            }
        }
        this.f5764E.clear();
        this.f5806l = false;
    }

    /* renamed from: n */
    private void m5722n() {
        InMobiAdActivity.m4212a((Object) this);
        Activity fullScreenActivity = getFullScreenActivity();
        if (fullScreenActivity != null) {
            ((InMobiAdActivity) fullScreenActivity).f4258a = true;
            fullScreenActivity.finish();
            int i = this.f5778S;
            if (i != -1) {
                fullScreenActivity.overridePendingTransition(0, i);
            }
        } else {
            String str = "Default";
            if (this.f5798d == 0) {
                setAndUpdateViewState(str);
                C2600j jVar = this.f5818y;
                if (jVar != null) {
                    jVar.setAndUpdateViewState(str);
                }
            } else if (str.equals(this.f5797c)) {
                setAndUpdateViewState("Hidden");
            }
            getListener().mo28537g(this);
        }
    }

    public final void setExitAnimation(int i) {
        this.f5778S = i;
    }

    /* renamed from: g */
    private static String m5713g(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    /* renamed from: a */
    public final void mo28625a(String str, String str2, String str3, @Nullable String str4) {
        String str5 = ")";
        String str6 = "Cannot resolve URI (";
        while (true) {
            try {
                C2513gg.m5340b(getContainerContext(), str3);
                getListener().mo28539i(this);
                StringBuilder sb = new StringBuilder("broadcastEvent('");
                sb.append(str);
                sb.append("Successful','");
                sb.append(str3);
                sb.append("');");
                mo28624a(str2, sb.toString());
                return;
            } catch (URISyntaxException unused) {
                StringBuilder sb2 = new StringBuilder(str6);
                sb2.append(m5713g(str3));
                sb2.append(str5);
                mo28628b(str2, sb2.toString(), str);
                if (str4 == null) {
                    return;
                }
            } catch (ActivityNotFoundException unused2) {
                StringBuilder sb3 = new StringBuilder(str6);
                sb3.append(m5713g(str3));
                sb3.append(str5);
                mo28628b(str2, sb3.toString(), str);
                if (str4 == null) {
                    return;
                }
            } catch (Exception unused3) {
                mo28628b(str2, "Unexpected error", "openExternal");
                C2514gh.m5342a(1, f5759x, "Could not open URL; SDK encountered an unexpected error");
                return;
            }
            str3 = str4;
            str4 = null;
        }
    }

    /* renamed from: a */
    public final void mo28359a(String str) {
        if (C2513gg.m5338a(str)) {
            InMobiAdActivity.m4211a(this);
            Intent intent = new Intent(getContainerContext(), InMobiAdActivity.class);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 100);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.IN_APP_BROWSER_URL", str);
            C2505gd.m5287a(getContainerContext(), intent);
        }
    }

    /* renamed from: e */
    public final void mo28364e() {
        getListener().mo28536f(this);
    }

    /* renamed from: f */
    public final void mo28365f() {
        getListener().mo28537g(this);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:13|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        com.inmobi.media.C2513gg.m5340b(getContainerContext(), r5);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0035 */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo28631c(java.lang.String r3, java.lang.String r4, java.lang.String r5) {
        /*
            r2 = this;
            if (r5 == 0) goto L_0x005b
            java.lang.String r0 = "http"
            boolean r0 = r5.startsWith(r0)
            if (r0 == 0) goto L_0x0011
            boolean r0 = android.webkit.URLUtil.isValidUrl(r5)
            if (r0 != 0) goto L_0x0011
            goto L_0x005b
        L_0x0011:
            android.content.Context r0 = r2.getContainerContext()
            java.lang.String r0 = com.inmobi.media.C2361e.m4920a(r0)
            com.inmobi.media.eq r1 = r2.getAdConfig()     // Catch:{ Exception -> 0x0035 }
            boolean r1 = r1.f5178e     // Catch:{ Exception -> 0x0035 }
            if (r0 == 0) goto L_0x0031
            if (r1 != 0) goto L_0x0024
            goto L_0x0031
        L_0x0024:
            com.inmobi.media.bu r0 = new com.inmobi.media.bu     // Catch:{ Exception -> 0x0035 }
            android.content.Context r1 = r2.getContainerContext()     // Catch:{ Exception -> 0x0035 }
            r0.<init>(r5, r1, r2)     // Catch:{ Exception -> 0x0035 }
            r0.mo27988b()     // Catch:{ Exception -> 0x0035 }
            goto L_0x003c
        L_0x0031:
            r2.mo28359a(r5)     // Catch:{ Exception -> 0x0035 }
            goto L_0x003c
        L_0x0035:
            android.content.Context r0 = r2.getContainerContext()     // Catch:{ URISyntaxException -> 0x003c }
            com.inmobi.media.C2513gg.m5340b(r0, r5)     // Catch:{ URISyntaxException -> 0x003c }
        L_0x003c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "broadcastEvent('"
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r3 = "Successful','"
            r0.append(r3)
            r0.append(r5)
            java.lang.String r3 = "');"
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r2.mo28624a(r4, r3)
            return
        L_0x005b:
            java.lang.String r5 = "Invalid URL"
            r2.mo28628b(r4, r5, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2600j.mo28631c(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public final void setRenderViewEventListener(C2618a aVar) {
        this.f5762C = aVar;
    }

    public final C2618a getListener() {
        C2618a aVar = this.f5762C;
        if (aVar != null) {
            return aVar;
        }
        C2618a aVar2 = f5757a;
        this.f5762C = aVar2;
        return aVar2;
    }

    public final String getViewState() {
        return this.f5797c;
    }

    public final C2265cb getMediaProcessor() {
        return this.f5801g;
    }

    public final C2256bx getExpandProperties() {
        return this.f5766G;
    }

    public final C2275ce getResizeProperties() {
        return this.f5767H;
    }

    public final void setResizeProperties(C2275ce ceVar) {
        this.f5767H = ceVar;
    }

    public final void setAndUpdateViewState(String str) {
        this.f5797c = str;
        String lowerCase = this.f5797c.toLowerCase(Locale.ENGLISH);
        StringBuilder sb = new StringBuilder("window.mraidview.broadcastEvent('stateChange','");
        sb.append(lowerCase);
        sb.append("');");
        mo28633e(sb.toString());
    }

    /* renamed from: o */
    private void m5723o() {
        setVisibility(0);
        requestLayout();
    }

    public final void setAdActiveFlag(boolean z) {
        this.f5806l = z;
    }

    public final C2274cd getOrientationProperties() {
        return this.f5768I;
    }

    public final void setOrientationProperties(C2274cd cdVar) {
        this.f5768I = cdVar;
        WeakReference<Activity> weakReference = this.f5796b;
        if (!(weakReference == null || weakReference.get() == null || cdVar.f4768a)) {
            String str = cdVar.f4769b;
            char c = 65535;
            int hashCode = str.hashCode();
            boolean z = true;
            if (hashCode != 729267099) {
                if (hashCode == 1430647483 && str.equals(String.LANDSCAPE)) {
                    c = 0;
                }
            } else if (str.equals(String.PORTRAIT)) {
                c = 1;
            }
            if (c == 0) {
                if (!(C2528gq.m5395b() == 3 || C2528gq.m5395b() == 4)) {
                    z = false;
                }
                if (z) {
                    if (3 == C2528gq.m5395b()) {
                        ((Activity) this.f5796b.get()).setRequestedOrientation(0);
                    } else {
                        ((Activity) this.f5796b.get()).setRequestedOrientation(8);
                    }
                } else if (cdVar.f4770c.equals("left")) {
                    ((Activity) this.f5796b.get()).setRequestedOrientation(8);
                } else if (cdVar.f4770c.equals(String.RIGHT)) {
                    ((Activity) this.f5796b.get()).setRequestedOrientation(0);
                }
            } else if (c != 1) {
                if (C2528gq.m5395b() == 2) {
                    ((Activity) this.f5796b.get()).setRequestedOrientation(9);
                } else if (C2528gq.m5395b() == 4) {
                    ((Activity) this.f5796b.get()).setRequestedOrientation(8);
                } else if (C2528gq.m5395b() == 3) {
                    ((Activity) this.f5796b.get()).setRequestedOrientation(0);
                } else {
                    ((Activity) this.f5796b.get()).setRequestedOrientation(1);
                }
            } else if (C2528gq.m5395b() == 2) {
                ((Activity) this.f5796b.get()).setRequestedOrientation(9);
            } else {
                ((Activity) this.f5796b.get()).setRequestedOrientation(1);
            }
        }
    }

    public final String getMraidJsString() {
        String a = new C2517gk(getContext(), "mraid_js_store").mo28467a("mraid_js_string");
        return a == null ? "var imIsObjValid=function(a){return\"undefined\"!=typeof a&&null!=a?!0:!1},EventListeners=function(a){this.event=a;this.count=0;var b=[];this.add=function(a){b.push(a);++this.count};this.remove=function(a){var e=!1,d=this;b=b.filter(function(b){if(b=b===a)--d.count,e=!0;return!b});return e};this.removeAll=function(){b=[];this.count=0};this.broadcast=function(a){b.forEach(function(e){try{e.apply({},a)}catch(d){}})};this.toString=function(){var c=[a,\":\"];b.forEach(function(a){c.push(\"|\",String(a),\"|\")});\nreturn c.join(\"\")}},InmobiObj=function(){this.listeners=[];this.addEventListener=function(a,b){try{if(imIsObjValid(b)&&imIsObjValid(a)){var c=this.listeners;c[a]||(c[a]=new EventListeners);c[a].add(b);\"micIntensityChange\"==a&&window.imraidview.startListeningMicIntensity();\"deviceMuted\"==a&&window.imraidview.startListeningDeviceMuteEvents();\"deviceVolumeChange\"==a&&window.imraidview.startListeningDeviceVolumeChange();\"volumeChange\"==a&&window.imraidview.startListeningVolumeChange();\"headphones\"==a&&\nwindow.imraidview.startListeningHeadphonePluggedEvents();\"backButtonPressed\"==a&&window.imraidview.startListeningForBackButtonPressedEvent();\"downloadStatusChanged\"==a&&window.imraidview.registerDownloaderCallbacks()}}catch(e){this.log(e)}};this.removeEventListener=function(a,b){if(imIsObjValid(a)){var c=this.listeners;imIsObjValid(c[a])&&(imIsObjValid(b)?c[a].remove(b):c[a].removeAll());\"micIntensityChange\"==a&&0==c[a].count&&window.imraidview.stopListeningMicIntensity();\"deviceMuted\"==a&&0==c[a].count&&\nwindow.imraidview.stopListeningDeviceMuteEvents();\"deviceVolumeChange\"==a&&0==c[a].count&&window.imraidview.stopListeningDeviceVolumeChange();\"volumeChange\"==a&&0==c[a].count&&window.imraidview.stopListeningVolumeChange();\"headphones\"==a&&0==c[a].count&&window.imraidview.stopListeningHeadphonePluggedEvents();\"backButtonPressed\"==a&&0==c[a].count&&window.imraidview.stopListeningForBackButtonPressedEvent();\"downloadStatusChanged\"==a&&0==c[a].count&&window.imraidview.unregisterDownloaderCallbacks()}};\nthis.broadcastEvent=function(a){if(imIsObjValid(a)){for(var b=Array(arguments.length),c=0;c<arguments.length;c++)b[c]=arguments[c];c=b.shift();try{this.listeners[c]&&this.listeners[c].broadcast(b)}catch(e){}}};this.sendSaveContentResult=function(a){if(imIsObjValid(a)){for(var b=Array(arguments.length),c=0;c<arguments.length;c++)if(2==c){var e=arguments[c],e=JSON.parse(e);b[c]=e}else b[c]=arguments[c];e=b[1];\"success\"!=e&&(c=b[0].substring(b[0].indexOf(\"_\")+1),imraid.saveContentIDMap[c]&&delete imraid.saveContentIDMap[c]);\nwindow.imraid.broadcastEvent(b[0],b[1],b[2])}}},__im__iosNativeMessageHandler=void 0;window.webkit&&(window.webkit.messageHandlers&&window.webkit.messageHandlers.nativeMessageHandler)&&(__im__iosNativeMessageHandler=window.webkit.messageHandlers.nativeMessageHandler);\nvar __im__iosNativeCall={nativeCallInFlight:!1,nativeCallQueue:[],executeNativeCall:function(a){this.nativeCallInFlight?this.nativeCallQueue.push(a):(this.nativeCallInFlight=!0,imIsObjValid(__im__iosNativeMessageHandler)?__im__iosNativeMessageHandler.postMessage(a):window.location=a)},nativeCallComplete:function(a){0==this.nativeCallQueue.length?this.nativeCallInFlight=!1:(a=this.nativeCallQueue.shift(),imIsObjValid(__im__iosNativeMessageHandler)?__im__iosNativeMessageHandler.postMessage(a):window.location=\na)}},IOSNativeCall=function(){this.urlScheme=\"\";this.executeNativeCall=function(a){if(imIsObjValid(__im__iosNativeMessageHandler)){e={};e.command=a;e.scheme=this.urlScheme;for(var b={},c=1;c<arguments.length;c+=2)d=arguments[c+1],null!=d&&(b[arguments[c]]=\"\"+d);e.params=b}else for(var e=this.urlScheme+\"://\"+a,d,b=!0,c=1;c<arguments.length;c+=2)d=arguments[c+1],null!=d&&(b?(e+=\"?\",b=!1):e+=\"&\",e+=arguments[c]+\"=\"+escape(d));__im__iosNativeCall.executeNativeCall(e);return\"OK\"};this.nativeCallComplete=\nfunction(a){__im__iosNativeCall.nativeCallComplete(a);return\"OK\"};this.updateKV=function(a,b){this[a]=b;var c=this.broadcastMap[a];c&&this.broadcastEvent(c,b)}};\n(function(){var a=window.mraidview={};a.orientationProperties={allowOrientationChange:!0,forceOrientation:\"none\",direction:\"right\"};var b=[],c=!1;a.detectAndBlockFraud=function(e){a.isPossibleFraud()&&a.fireRedirectFraudBeacon(e);return!1};a.popupBlocked=function(e){a.firePopupBlockedBeacon(e)};a.zeroPad=function(a){var d=\"\";10>a&&(d+=\"0\");return d+a};a.supports=function(a){console.log(\"bridge: supports (MRAID)\");if(\"string\"!=typeof a)window.mraid.broadcastEvent(\"error\",\"Supports method expects string parameter\",\n\"supports\");else return\"false\"!=sdkController.supports(\"window.mraidview\",a)};a.useCustomClose=function(a){try{sdkController.useCustomClose(\"window.mraidview\",a)}catch(d){imraidview.showAlert(\"use CustomClose: \"+d)}};a.close=function(){try{sdkController.close(\"window.mraidview\")}catch(a){imraidview.showAlert(\"close: \"+a)}};a.stackCommands=function(a,d){c?b.push(a):(eval(a),d&&(c=!0))};a.expand=function(a){try{\"undefined\"==typeof a&&(a=null),sdkController.expand(\"window.mraidview\",a)}catch(d){imraidview.showAlert(\"executeNativeExpand: \"+\nd+\", URL = \"+a)}};a.setExpandProperties=function(b){try{b?this.props=b:b=null;if(\"undefined\"!=typeof b.lockOrientation&&null!=b.lockOrientation&&\"undefined\"!=typeof b.orientation&&null!=b.orientation){var d={};d.allowOrientationChange=!b.lockOrientation;d.forceOrientation=b.orientation;a.setOrientationProperties(d)}sdkController.setExpandProperties(\"window.mraidview\",a.stringify(b))}catch(c){imraidview.showAlert(\"executeNativesetExpandProperties: \"+c+\", props = \"+b)}};a.getExpandProperties=function(){try{return eval(\"(\"+\nsdkController.getExpandProperties(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getExpandProperties: \"+a)}};a.setOrientationProperties=function(b){try{b?(\"undefined\"!=typeof b.allowOrientationChange&&(a.orientationProperties.allowOrientationChange=b.allowOrientationChange),\"undefined\"!=typeof b.forceOrientation&&(a.orientationProperties.forceOrientation=b.forceOrientation)):b=null,sdkController.setOrientationProperties(\"window.mraidview\",a.stringify(a.orientationProperties))}catch(d){imraidview.showAlert(\"setOrientationProperties: \"+\nd+\", props = \"+b)}};a.getOrientationProperties=function(){return{forceOrientation:a.orientationProperties.forceOrientation,allowOrientationChange:a.orientationProperties.allowOrientationChange}};a.resizeProps=null;a.setResizeProperties=function(b){var d,c;try{d=parseInt(b.width);c=parseInt(b.height);if(isNaN(d)||isNaN(c)||1>d||1>c)throw\"Invalid\";b.width=d;b.height=c;a.resizeProps=b;sdkController.setResizeProperties(\"window.mraidview\",a.stringify(b))}catch(g){window.mraid.broadcastEvent(\"error\",\"Invalid properties.\",\n\"setResizeProperties\")}};a.getResizeProperties=function(){try{return eval(\"(\"+sdkController.getResizeProperties(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getResizeProperties: \"+a)}};a.open=function(a){\"undefined\"==typeof a&&(a=null);try{sdkController.open(\"window.mraidview\",a)}catch(d){imraidview.showAlert(\"open: \"+d)}};a.getScreenSize=function(){try{return eval(\"(\"+sdkController.getScreenSize(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getScreenSize: \"+a)}};a.getMaxSize=\nfunction(){try{return eval(\"(\"+sdkController.getMaxSize(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getMaxSize: \"+a)}};a.getCurrentPosition=function(){try{return eval(\"(\"+sdkController.getCurrentPosition(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getCurrentPosition: \"+a)}};a.getDefaultPosition=function(){try{return eval(\"(\"+sdkController.getDefaultPosition(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getDefaultPosition: \"+a)}};a.getState=function(){try{return String(sdkController.getState(\"window.mraidview\"))}catch(a){imraidview.showAlert(\"getState: \"+\na)}};a.isViewable=function(){try{return sdkController.isViewable(\"window.mraidview\")}catch(a){imraidview.showAlert(\"isViewable: \"+a)}};a.getPlacementType=function(){return sdkController.getPlacementType(\"window.mraidview\")};a.close=function(){try{sdkController.close(\"window.mraidview\")}catch(a){imraidview.showAlert(\"close: \"+a)}};\"function\"!=typeof String.prototype.startsWith&&(String.prototype.startsWith=function(a){return 0==this.indexOf(a)});a.playVideo=function(a){var d=\"\";null!=a&&(d=a);try{sdkController.playVideo(\"window.mraidview\",\nd)}catch(b){imraidview.showAlert(\"playVideo: \"+b)}};a.stringify=function(b){if(\"undefined\"===typeof JSON){var d=\"\",c;if(\"undefined\"==typeof b.length)return a.stringifyArg(b);for(c=0;c<b.length;c++)0<c&&(d+=\",\"),d+=a.stringifyArg(b[c]);return d+\"]\"}return JSON.stringify(b)};a.stringifyArg=function(a){var b,c,g;c=typeof a;b=\"\";if(\"number\"===c||\"boolean\"===c)b+=args;else if(a instanceof Array)b=b+\"[\"+a+\"]\";else if(a instanceof Object){c=!0;b+=\"{\";for(g in a)null!==a[g]&&(c||(b+=\",\"),b=b+'\"'+g+'\":',c=\ntypeof a[g],b=\"number\"===c||\"boolean\"===c?b+a[g]:\"function\"===typeof a[g]?b+'\"\"':a[g]instanceof Object?b+this.stringify(args[i][g]):b+'\"'+a[g]+'\"',c=!1);b+=\"}\"}else a=a.replace(/\\\\/g,\"\\\\\\\\\"),a=a.replace(/\"/g,'\\\\\"'),b=b+'\"'+a+'\"';imraidview.showAlert(\"json:\"+b);return b};getPID=function(a){var b=\"\";null!=a&&(\"undefined\"!=typeof a.id&&null!=a.id)&&(b=a.id);return b};a.resize=function(){if(null==a.resizeProps)window.mraid.broadcastEvent(\"error\",\"Valid resize dimensions must be provided before calling resize\",\n\"resize\");else try{sdkController.resize(\"window.mraidview\")}catch(b){imraidview.showAlert(\"resize called in bridge\")}};a.storePicture=function(b){console.log(\"bridge: storePicture\");if(\"string\"!=typeof b)window.mraid.broadcastEvent(\"error\",\"storePicture method expects url as string parameter\",\"storePicture\");else{if(a.supports(\"storePicture\"))return!window.confirm(\"Do you want to download the file?\")?(window.mraid.broadcastEvent(\"error\",\"Store picture on \"+b+\" was cancelled by user.\",\"storePicture\"),\n!1):sdkController.storePicture(\"window.mraidview\",b);window.mraid.broadcastEvent(\"error\",\"Store picture on \"+b+\" was cancelled because it is unsupported in this device/app.\",\"storePicture\")}};a.fireMediaTrackingEvent=function(a,b){};a.fireMediaErrorEvent=function(a,b){};a.fireMediaTimeUpdateEvent=function(a,b,c){};a.fireMediaCloseEvent=function(a,b,c){};a.fireMediaVolumeChangeEvent=function(a,b,c){};a.broadcastEvent=function(){window.mraid.broadcastEvent.apply(window.mraid,arguments)}})();\n(function(){var a=window.mraid=new InmobiObj,b=window.mraidview,c=!1;b.isAdShownToUser=!1;b.onUserInteraction=function(){c=!0};b.isPossibleFraud=function(){return a.supports(\"redirectFraudDetection\")&&(!b.isAdShownToUser||!c)};b.fireRedirectFraudBeacon=function(a){if(\"undefined\"!=typeof inmobi&&inmobi.recordEvent){var d={};d.trigger=a;d.isAdShown=b.isAdShownToUser.toString();inmobi.recordEvent(135,d)}};b.firePopupBlockedBeacon=function(a){if(\"undefined\"!=typeof inmobi&&inmobi.recordEvent){var b={};\nb.trigger=a;inmobi.recordEvent(136,b)}};window.onbeforeunload=function(){b.detectAndBlockFraud(\"redirect\")};a.addEventListener(\"viewableChange\",function(a){a&&!b.isAdShownToUser&&(b.isAdShownToUser=!0)});a.useCustomClose=b.useCustomClose;a.close=b.close;a.getExpandProperties=b.getExpandProperties;a.setExpandProperties=function(c){\"undefined\"!=typeof c&&(\"useCustomClose\"in c&&\"undefined\"!=typeof a.getState()&&\"expanded\"!=a.getState())&&a.useCustomClose(c.useCustomClose);b.setExpandProperties(c)};a.getResizeProperties=\nb.getResizeProperties;a.setResizeProperties=b.setResizeProperties;a.getOrientationProperties=b.getOrientationProperties;a.setOrientationProperties=b.setOrientationProperties;a.expand=b.expand;a.getMaxSize=b.getMaxSize;a.getState=b.getState;a.isViewable=b.isViewable;a.createCalendarEvent=function(a){window.mraid.broadcastEvent(\"error\",\"Method not supported\",\"createCalendarEvent\")};a.open=function(c){b.detectAndBlockFraud(\"mraid.open\")||(\"string\"!=typeof c?a.broadcastEvent(\"error\",\"URL is required.\",\n\"open\"):b.open(c))};a.resize=b.resize;a.getVersion=function(){return\"2.0\"};a.getPlacementType=b.getPlacementType;a.playVideo=function(a){b.playVideo(a)};a.getScreenSize=b.getScreenSize;a.getCurrentPosition=b.getCurrentPosition;a.getDefaultPosition=b.getDefaultPosition;a.supports=function(a){return b.supports(a)};a.storePicture=function(c){\"string\"!=typeof c?a.broadcastEvent(\"error\",\"Request must specify a valid URL\",\"storePicture\"):b.storePicture(c)}})();\n(function(){var a=window.imraidview={},b,c=!0;a.setOrientationProperties=function(b){try{b?(\"undefined\"!=typeof b.allowOrientationChange&&(mraidview.orientationProperties.allowOrientationChange=b.allowOrientationChange),\"undefined\"!=typeof b.forceOrientation&&(mraidview.orientationProperties.forceOrientation=b.forceOrientation),\"undefined\"!=typeof b.direction&&(mraidview.orientationProperties.direction=b.direction)):b=null,sdkController.setOrientationProperties(\"window.imraidview\",mraidview.stringify(mraidview.orientationProperties))}catch(c){a.showAlert(\"setOrientationProperties: \"+\nc+\", props = \"+b)}};a.getOrientationProperties=function(){return mraidview.orientationProperties};a.getWindowOrientation=function(){var a=window.orientation;0>a&&(a+=360);window.innerWidth!==this.previousWidth&&0==a&&window.innerWidth>window.innerHeight&&(a=90);return a};var e=function(){window.setTimeout(function(){if(c||a.getWindowOrientation()!==b)c=!1,b=a.getWindowOrientation(),sdkController.onOrientationChange(\"window.imraidview\"),imraid.broadcastEvent(\"orientationChange\",b)},200)};a.registerOrientationListener=\nfunction(){b=a.getWindowOrientation();window.addEventListener(\"resize\",e,!1);window.addEventListener(\"orientationchange\",e,!1)};a.unRegisterOrientationListener=function(){window.removeEventListener(\"resize\",e,!1);window.removeEventListener(\"orientationchange\",e,!1)};window.imraidview.registerOrientationListener();a.firePostStatusEvent=function(a){window.imraid.broadcastEvent(\"postStatus\",a)};a.fireMediaTrackingEvent=function(a,b){var c={};c.name=a;var f=\"inmobi_media_\"+a;\"undefined\"!=typeof b&&(null!=\nb&&\"\"!=b)&&(f=f+\"_\"+b);window.imraid.broadcastEvent(f,c)};a.fireMediaErrorEvent=function(a,b){var c={name:\"error\"};c.code=b;var f=\"inmobi_media_\"+c.name;\"undefined\"!=typeof a&&(null!=a&&\"\"!=a)&&(f=f+\"_\"+a);window.imraid.broadcastEvent(f,c)};a.fireMediaTimeUpdateEvent=function(a,b,c){var f={name:\"timeupdate\",target:{}};f.target.currentTime=b;f.target.duration=c;b=\"inmobi_media_\"+f.name;\"undefined\"!=typeof a&&(null!=a&&\"\"!=a)&&(b=b+\"_\"+a);window.imraid.broadcastEvent(b,f)};a.saveContent=function(a,\nb,c){window.imraid.addEventListener(\"saveContent_\"+a,c);sdkController.saveContent(\"window.imraidview\",a,b)};a.cancelSaveContent=function(a){sdkController.cancelSaveContent(\"window.imraidview\",a)};a.disableCloseRegion=function(a){sdkController.disableCloseRegion(\"window.imraidview\",a)};a.fireGalleryImageSelectedEvent=function(a,b,c){var f=new Image;f.src=\"data:image/jpeg;base64,\"+a;f.width=b;f.height=c;window.imraid.broadcastEvent(\"galleryImageSelected\",f)};a.fireCameraPictureCatpturedEvent=function(a,\nb,c){var f=new Image;f.src=\"data:image/jpeg;base64,\"+a;f.width=b;f.height=c;window.imraid.broadcastEvent(\"cameraPictureCaptured\",f)};a.fireMediaCloseEvent=function(a,b,c){var f={name:\"close\"};f.viaUserInteraction=b;f.target={};f.target.currentTime=c;b=\"inmobi_media_\"+f.name;\"undefined\"!=typeof a&&(null!=a&&\"\"!=a)&&(b=b+\"_\"+a);window.imraid.broadcastEvent(b,f)};a.fireMediaVolumeChangeEvent=function(a,b,c){var f={name:\"volumechange\",target:{}};f.target.volume=b;f.target.muted=c;b=\"inmobi_media_\"+f.name;\n\"undefined\"!=typeof a&&(null!=a&&\"\"!=a)&&(b=b+\"_\"+a);window.imraid.broadcastEvent(b,f)};a.fireDeviceMuteChangeEvent=function(a){window.imraid.broadcastEvent(\"deviceMuted\",a)};a.fireDeviceVolumeChangeEvent=function(a){window.imraid.broadcastEvent(\"deviceVolumeChange\",a)};a.fireHeadphonePluggedEvent=function(a){window.imraid.broadcastEvent(\"headphones\",a)};a.showAlert=function(a){sdkController.showAlert(\"window.imraidview\",a)};a.openExternal=function(b,c){try{600<=getSdkVersionInt()?sdkController.openExternal(\"window.imraidview\",\nb,c):sdkController.openExternal(\"window.imraidview\",b)}catch(e){a.showAlert(\"openExternal: \"+e)}};a.log=function(b){try{sdkController.log(\"window.imraidview\",b)}catch(c){a.showAlert(\"log: \"+c)}};a.getPlatform=function(){return\"android\"};a.asyncPing=function(b){try{sdkController.asyncPing(\"window.imraidview\",b)}catch(c){a.showAlert(\"asyncPing: \"+c)}};a.startListeningDeviceMuteEvents=function(){sdkController.registerDeviceMuteEventListener(\"window.imraidview\")};a.stopListeningDeviceMuteEvents=function(){sdkController.unregisterDeviceMuteEventListener(\"window.imraidview\")};\na.startListeningDeviceVolumeChange=function(){sdkController.registerDeviceVolumeChangeEventListener(\"window.imraidview\")};a.stopListeningDeviceVolumeChange=function(){sdkController.unregisterDeviceVolumeChangeEventListener(\"window.imraidview\")};a.startListeningHeadphonePluggedEvents=function(){sdkController.registerHeadphonePluggedEventListener(\"window.imraidview\")};a.stopListeningHeadphonePluggedEvents=function(){sdkController.unregisterHeadphonePluggedEventListener(\"window.imraidview\")};getSdkVersionInt=\nfunction(){for(var b=a.getSdkVersion().split(\".\"),c=b.length,e=\"\",f=0;f<c;f++)e+=b[f];return parseInt(e)};a.getSdkVersion=function(){return window._im_imaiview.getSdkVersion()};a.supports=function(a){console.log(\"bridge: supports (IMRAID)\");if(\"string\"!=typeof a)window.imraid.broadcastEvent(\"error\",\"Supports method expects string parameter\",\"supports\");else return\"false\"!=sdkController.supports(\"window.imraidview\",a)};a.postToSocial=function(b,c,e,f){window.imraid.broadcastEvent(\"error\",\"Method not supported\",\n\"postToSocial\");a.log(\"Method postToSocial not supported\")};a.incentCompleted=function(a){if(\"object\"!=typeof a||null==a)sdkController.incentCompleted(\"window.imraidview\",null);else try{sdkController.incentCompleted(\"window.imraidview\",JSON.stringify(a))}catch(b){sdkController.incentCompleted(\"window.imraidview\",null)}};a.getOrientation=function(){try{return String(sdkController.getOrientation(\"window.imraidview\"))}catch(b){a.showAlert(\"getOrientation: \"+b)}};a.acceptAction=function(b){try{sdkController.acceptAction(\"window.imraidview\",\nmraidview.stringify(b))}catch(c){a.showAlert(\"acceptAction: \"+c+\", params = \"+b)}};a.rejectAction=function(b){try{sdkController.rejectAction(\"window.imraidview\",mraidview.stringify(b))}catch(c){a.showAlert(\"rejectAction: \"+c+\", params = \"+b)}};a.updateToPassbook=function(b){window.imraid.broadcastEvent(\"error\",\"Method not supported\",\"updateToPassbook\");a.log(\"Method not supported\")};a.isDeviceMuted=function(){return\"false\"!=sdkController.isDeviceMuted(\"window.imraidview\")};a.getDeviceVolume=function(){return 603>=\ngetSdkVersionInt()?-1:sdkController.getDeviceVolume(\"window.imraidview\")};a.isHeadPhonesPlugged=function(){return\"false\"!=sdkController.isHeadphonePlugged(\"window.imraidview\")};a.sendSaveContentResult=function(){window.imraid.sendSaveContentResult.apply(window.imraid,arguments)};a.broadcastEvent=function(){window.imraid.broadcastEvent.apply(window.imraid,arguments)};a.disableBackButton=function(a){void 0==a||\"boolean\"!=typeof a?console.log(\"disableBackButton called with invalid params\"):sdkController.disableBackButton(\"window.imraidview\",\na)};a.isBackButtonDisabled=function(){return sdkController.isBackButtonDisabled(\"window.imraidview\")};a.startListeningForBackButtonPressedEvent=function(){sdkController.registerBackButtonPressedEventListener(\"window.imraidview\")};a.stopListeningForBackButtonPressedEvent=function(){sdkController.unregisterBackButtonPressedEventListener(\"window.imraidview\")};a.hideStatusBar=function(){};a.setOpaqueBackground=function(){};a.startDownloader=function(a,b,c){682<=getSdkVersionInt()&&sdkController.startDownloader(\"window.imraidview\",\na,b,c)};a.registerDownloaderCallbacks=function(){682<=getSdkVersionInt()&&sdkController.registerDownloaderCallbacks(\"window.imraidview\")};a.unregisterDownloaderCallbacks=function(){682<=getSdkVersionInt()&&sdkController.unregisterDownloaderCallbacks(\"window.imraidview\")};a.getDownloadProgress=function(){return 682<=getSdkVersionInt()?sdkController.getDownloadProgress(\"window.imraidview\"):-1};a.getDownloadStatus=function(){return 682<=getSdkVersionInt()?sdkController.getDownloadStatus(\"window.imraidview\"):\n-1};a.fireEvent=function(a){700<=getSdkVersionInt()&&(\"fireSkip\"===a?sdkController.fireSkip(\"window.imraidview\"):\"fireComplete\"===a?sdkController.fireComplete(\"window.imraidview\"):\"showEndCard\"===a&&sdkController.showEndCard(\"window.imraidview\"))};a.saveBlob=function(a){700<=getSdkVersionInt()&&sdkController.saveBlob(\"window.imraidview\",a)};a.getBlob=function(a,b){700<=getSdkVersionInt()&&sdkController.getBlob(a,b)};a.setCloseEndCardTracker=function(a){700<=getSdkVersionInt()&&sdkController.setCloseEndCardTracker(\"window.imraidview\",\na)}})();\n(function(){var a=window.imraid=new InmobiObj,b=window.imraidview;a.getOrientation=b.getOrientation;a.setOrientationProperties=b.setOrientationProperties;a.getOrientationProperties=b.getOrientationProperties;a.saveContentIDMap={};a.saveContent=function(c,e,d){var k=arguments.length,g,f=null;if(3>k){if(\"function\"===typeof arguments[k-1])g=arguments[k-1];else return;f={reason:1}}else a.saveContentIDMap[c]&&(g=arguments[2],f={reason:11,url:arguments[1]});\"function\"!==!g&&(f?(window.imraid.addEventListener(\"saveContent_failed_\"+c,\ng),window.imraid.sendSaveContentResult(\"saveContent_failed_\"+c,\"failed\",JSON.stringify(f))):(a.removeEventListener(\"saveContent_\"+c),a.saveContentIDMap[c]=!0,b.saveContent(c,e,d)))};a.cancelSaveContent=function(a){b.cancelSaveContent(a)};a.asyncPing=function(c){\"string\"!=typeof c?a.broadcastEvent(\"error\",\"URL is required.\",\"asyncPing\"):b.asyncPing(c)};a.disableCloseRegion=b.disableCloseRegion;a.getSdkVersion=b.getSdkVersion;a.log=function(c){\"undefined\"==typeof c?a.broadcastEvent(\"error\",\"message is required.\",\n\"log\"):\"string\"==typeof c?b.log(c):b.log(JSON.stringify(c))};a.getInMobiAIVersion=function(){return\"2.0\"};a.getVendorName=function(){return\"inmobi\"};a.openExternal=function(a,e){mraidview.detectAndBlockFraud(\"imraid.openExternal\")||b.openExternal(a,e)};a.updateToPassbook=function(c){mraidview.detectAndBlockFraud(\"imraid.updateToPassbook\")||(\"string\"!=typeof c?a.broadcastEvent(\"error\",\"Request must specify a valid URL\",\"updateToPassbook\"):b.updateToPassbook(c))};a.postToSocial=function(a,e,d,k){mraidview.detectAndBlockFraud(\"imraid.postToSocial\")||\nb.postToSocial(a,e,d,k)};a.getPlatform=b.getPlatform;a.incentCompleted=b.incentCompleted;a.loadSKStore=b.loadSKStore;a.showSKStore=function(a){mraidview.detectAndBlockFraud(\"imraid.showSKStore\")||b.showSKStore(a)};a.supports=function(a){return b.supports(a)};a.isDeviceMuted=function(){return!imIsObjValid(a.listeners.deviceMuted)?-1:b.isDeviceMuted()};a.isHeadPhonesPlugged=function(){return!imIsObjValid(a.listeners.headphones)?!1:b.isHeadPhonesPlugged()};a.getDeviceVolume=function(){return b.getDeviceVolume()};\na.setDeviceVolume=function(a){b.setDeviceVolume(a)};a.hideStatusBar=function(){b.hideStatusBar()};a.setOpaqueBackground=function(){b.setOpaqueBackground()};a.disableBackButton=b.disableBackButton;a.isBackButtonDisabled=b.isBackButtonDisabled;a.startDownloader=b.startDownloader;a.getDownloadProgress=b.getDownloadProgress;a.getDownloadStatus=b.getDownloadStatus;a.fireEvent=b.fireEvent;a.saveBlob=b.saveBlob;a.getBlob=b.getBlob;a.setCloseEndCardTracker=b.setCloseEndCardTracker})();\n(function(){var a=window._im_imaiview={ios:{}};window.imaiview=a;a.broadcastEvent=function(){for(var a=Array(arguments.length),c=0;c<arguments.length;c++)a[c]=arguments[c];c=a.shift();try{window.mraid.broadcastEvent(c,a)}catch(e){}};a.getPlatform=function(){return\"android\"};a.getPlatformVersion=function(){return sdkController.getPlatformVersion(\"window.imaiview\")};a.log=function(a){sdkController.log(\"window.imaiview\",a)};a.openEmbedded=function(a){sdkController.openEmbedded(\"window.imaiview\",a)};\na.openExternal=function(a,c){600<=getSdkVersionInt()?sdkController.openExternal(\"window.imaiview\",a,c):sdkController.openExternal(\"window.imaiview\",a)};a.ping=function(a,c){sdkController.ping(\"window.imaiview\",a,c)};a.pingInWebView=function(a,c){sdkController.pingInWebView(\"window.imaiview\",a,c)};a.getSdkVersion=function(){try{var a=sdkController.getSdkVersion(\"window.imaiview\");if(\"string\"==typeof a&&null!=a)return a}catch(c){return\"3.7.0\"}};a.onUserInteraction=function(a){if(\"object\"!=typeof a||\nnull==a)sdkController.onUserInteraction(\"window.imaiview\",null);else try{sdkController.onUserInteraction(\"window.imaiview\",JSON.stringify(a))}catch(c){sdkController.onUserInteraction(\"window.imaiview\",null)}};a.fireAdReady=function(){sdkController.fireAdReady(\"window.imaiview\")};a.fireAdFailed=function(){sdkController.fireAdFailed(\"window.imaiview\")};a.broadcastEvent=function(){window.imai.broadcastEvent.apply(window.imai,arguments)}})();\n(function(){var a=window._im_imaiview;window._im_imai=new InmobiObj;window._im_imai.ios=new InmobiObj;var b=window._im_imai;window.imai=window._im_imai;b.matchString=function(a,b){if(\"string\"!=typeof a||null==a||null==b)return-1;var d=-1;try{d=a.indexOf(b)}catch(k){}return d};b.isHttpUrl=function(a){return\"string\"!=typeof a||null==a?!1:0==b.matchString(a,\"http://\")?!0:0==b.matchString(a,\"https://\")?!0:!1};b.appendTapParams=function(a,e,d){if(!imIsObjValid(e)||!imIsObjValid(d))return a;b.isHttpUrl(a)&&\n(a=-1==b.matchString(a,\"?\")?a+(\"?u-tap-o=\"+e+\",\"+d):a+(\"&u-tap-o=\"+e+\",\"+d));return a};b.performAdClick=function(a,e){e=e||event;if(imIsObjValid(a)){var d=a.clickConfig,k=a.landingConfig;if(!imIsObjValid(d)&&!imIsObjValid(k))b.log(\"click/landing config are invalid, Nothing to process .\"),this.broadcastEvent(\"error\",\"click/landing config are invalid, Nothing to process .\");else{var g=null,f=null,h=null,m=null,n=null,l=null,q=null,p=null;if(imIsObjValid(e))try{m=e.changedTouches[0].pageX,n=e.changedTouches[0].pageY}catch(r){n=\nm=0}imIsObjValid(k)?imIsObjValid(d)?(l=k.url,q=k.fallbackUrl,p=k.urlType,g=d.url,f=d.pingWV,h=d.fr):(l=k.url,p=k.urlType):(l=d.url,p=d.urlType);d=b.getPlatform();try{if(\"boolean\"!=typeof h&&\"number\"!=typeof h||null==h)h=!0;if(0>h||1<h)h=!0;if(\"boolean\"!=typeof f&&\"number\"!=typeof f||null==f)f=!0;if(0>f||1<f)f=!0;if(\"number\"!=typeof p||null==p)p=0;g=b.appendTapParams(g,m,n);imIsObjValid(g)?!0==f?b.pingInWebView(g,h):b.ping(g,h):b.log(\"clickurl provided is null.\");if(imIsObjValid(l))switch(imIsObjValid(g)||\n(l=b.appendTapParams(l,m,n)),p){case 1:b.openEmbedded(l);break;case 2:\"ios\"==d?b.ios.openItunesProductView(l):this.broadcastEvent(\"error\",\"Cannot process openItunesProductView for os\"+d);break;default:b.openExternal(l,q)}else b.log(\"Landing url provided is null.\")}catch(s){}}}else b.log(\" invalid config, nothing to process .\"),this.broadcastEvent(\"error\",\"invalid config, nothing to process .\")};b.performActionClick=function(a,e){e=e||event;if(imIsObjValid(a)){var d=a.clickConfig,k=a.landingConfig;\nif(!imIsObjValid(d)&&!imIsObjValid(k))b.log(\"click/landing config are invalid, Nothing to process .\"),this.broadcastEvent(\"error\",\"click/landing config are invalid, Nothing to process .\");else{var g=null,f=null,h=null,m=null,n=null;if(imIsObjValid(e))try{m=e.changedTouches[0].pageX,n=e.changedTouches[0].pageY}catch(l){n=m=0}imIsObjValid(d)&&(g=d.url,f=d.pingWV,h=d.fr);try{if(\"boolean\"!=typeof h&&\"number\"!=typeof h||null==h)h=!0;if(0>h||1<h)h=!0;if(\"boolean\"!=typeof f&&\"number\"!=typeof f||null==f)f=\n!0;if(0>f||1<f)f=!0;g=b.appendTapParams(g,m,n);imIsObjValid(g)?!0==f?b.pingInWebView(g,h):b.ping(g,h):b.log(\"clickurl provided is null.\");b.onUserInteraction(k)}catch(q){}}}else b.log(\" invalid config, nothing to process .\"),this.broadcastEvent(\"error\",\"invalid config, nothing to process .\")};b.getVersion=function(){return\"1.0\"};b.getPlatform=a.getPlatform;b.getPlatformVersion=a.getPlatformVersion;b.log=a.log;b.openEmbedded=function(b){mraidview.detectAndBlockFraud(\"imai.openEmbedded\")||a.openEmbedded(b)};\nb.openExternal=function(b,e){mraidview.detectAndBlockFraud(\"imai.openExternal\")||a.openExternal(b,e)};b.ping=a.ping;b.pingInWebView=a.pingInWebView;b.onUserInteraction=a.onUserInteraction;b.getSdkVersion=a.getSdkVersion;b.loadSKStore=a.loadSKStore;b.showSKStore=function(b){mraidview.detectAndBlockFraud(\"imai.showSKStore\")||a.showSKStore(b)};b.ios.openItunesProductView=function(b){mraidview.detectAndBlockFraud(\"imai.ios.openItunesProductView\")||a.ios.openItunesProductView(b)};b.fireAdReady=a.fireAdReady;\nb.fireAdFailed=a.fireAdFailed})();" : a;
    }

    /* renamed from: a */
    public final void mo28357a() {
        this.f5775P = false;
        try {
            getClass().getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(this, new Object[]{Integer.valueOf(1), null});
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
        }
    }

    @android.annotation.TargetApi(16)
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo28634f(java.lang.String r7) {
        /*
            r6 = this;
            int r0 = r7.hashCode()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 0
            r5 = 1
            switch(r0) {
                case -1886160473: goto L_0x0035;
                case -1647691422: goto L_0x002b;
                case 1509574865: goto L_0x0021;
                case 1642189884: goto L_0x0017;
                case 1772979069: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x003f
        L_0x000d:
            java.lang.String r0 = "redirectFraudDetection"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x003f
            r7 = 0
            goto L_0x0040
        L_0x0017:
            java.lang.String r0 = "saveContent"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x003f
            r7 = 2
            goto L_0x0040
        L_0x0021:
            java.lang.String r0 = "html5video"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x003f
            r7 = 4
            goto L_0x0040
        L_0x002b:
            java.lang.String r0 = "inlineVideo"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x003f
            r7 = 3
            goto L_0x0040
        L_0x0035:
            java.lang.String r0 = "playVideo"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x003f
            r7 = 1
            goto L_0x0040
        L_0x003f:
            r7 = -1
        L_0x0040:
            if (r7 == 0) goto L_0x0056
            if (r7 == r5) goto L_0x0055
            if (r7 == r3) goto L_0x0055
            if (r7 == r2) goto L_0x004b
            if (r7 == r1) goto L_0x004b
            return r4
        L_0x004b:
            boolean r7 = r6.f5765F
            if (r7 == 0) goto L_0x0054
            boolean r7 = r6.f5775P
            if (r7 == 0) goto L_0x0054
            return r5
        L_0x0054:
            return r4
        L_0x0055:
            return r5
        L_0x0056:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2600j.mo28634f(java.lang.String):boolean");
    }

    /* renamed from: j */
    public final boolean mo28663j() {
        C2433g renderingConfig = getRenderingConfig();
        return renderingConfig != null && (!renderingConfig.f5218f || this.f5784ab || this.f5785ac);
    }

    /* renamed from: a */
    public final void mo28445a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("(");
        sb.append(str3);
        sb.append(");");
        mo28624a(str, sb.toString());
    }

    public final void setCloseEndCardTracker(String str) {
        C2452f referenceContainer = getReferenceContainer();
        if (referenceContainer instanceof C2596i) {
            C2403ek ekVar = (C2403ek) ((C2596i) referenceContainer).getVideoContainerView();
            if (ekVar != null) {
                C2235bp bpVar = (C2235bp) ekVar.getVideoView().getTag();
                if (bpVar != null && bpVar.mo27982b() != null && bpVar.mo27982b().mo28142f() != null) {
                    bpVar.mo27982b().mo28142f().mo28123a(new C2234bo(str, 0, "closeEndCard", null));
                }
            }
        }
    }

    /* renamed from: k */
    public final void mo28587k() {
        if (!this.f5811q.get()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    C2600j.this.getListener().mo28525a();
                }
            });
        }
    }

    /* renamed from: l */
    public final void mo28588l() {
        if (!this.f5811q.get()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    C2600j.this.getListener().mo28529b();
                }
            });
        }
    }

    /* renamed from: d */
    public final void mo28632d(String str) {
        StringBuilder sb = new StringBuilder("window.mraidview.fireRedirectFraudBeacon('");
        sb.append(str);
        sb.append("')");
        mo28633e(sb.toString());
        String str2 = this.f5781V != null ? "banner" : "int";
        HashMap hashMap = new HashMap();
        hashMap.put("creativeId", this.f5782W);
        hashMap.put("trigger", str);
        hashMap.put("impressionId", getImpressionId());
        hashMap.put("adType", str2);
        getListener().mo28528a("BlockAutoRedirection", (Map<String, Object>) hashMap);
    }

    public final void setExpandProperties(C2256bx bxVar) {
        if (bxVar.f4715b) {
            setUseCustomClose(bxVar.f4714a);
        }
        this.f5766G = bxVar;
    }

    /* renamed from: j */
    static /* synthetic */ void m5717j(C2600j jVar) {
        jVar.mo28633e("window.imaiview.broadcastEvent('ready');");
        jVar.mo28633e("window.mraidview.broadcastEvent('ready');");
    }

    /* renamed from: a */
    static /* synthetic */ boolean m5702a(C2600j jVar, JsResult jsResult) {
        C2433g renderingConfig = jVar.getRenderingConfig();
        if (renderingConfig != null && renderingConfig.f5224l) {
            return true;
        }
        jsResult.cancel();
        jVar.mo28633e("window.mraidview.popupBlocked('popupBlocked')");
        return false;
    }
}
