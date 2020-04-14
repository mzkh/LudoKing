package com.moat.analytics.mobile.inm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.inm.g */
class C2707g {

    /* renamed from: a */
    WebView f6040a;

    /* renamed from: b */
    C2719j f6041b;

    /* renamed from: c */
    final String f6042c = String.format(Locale.ROOT, "_moatTracker%d", new Object[]{Integer.valueOf((int) (Math.random() * 1.0E8d))});

    /* renamed from: d */
    private final C2712a f6043d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f6044e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Handler f6045f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Runnable f6046g;

    /* renamed from: com.moat.analytics.mobile.inm.g$a */
    enum C2712a {
        DISPLAY,
        VIDEO
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    C2707g(Context context, C2712a aVar) {
        this.f6043d = aVar;
        this.f6040a = new WebView(context);
        WebSettings settings = this.f6040a.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccess(false);
        settings.setDatabaseEnabled(false);
        settings.setDomStorageEnabled(false);
        settings.setGeolocationEnabled(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setSaveFormData(false);
        if (VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(1);
        }
        C2723a aVar2 = C2723a.NATIVE_DISPLAY;
        if (aVar == C2712a.VIDEO) {
            aVar2 = C2723a.NATIVE_VIDEO;
        }
        try {
            this.f6041b = new C2719j(this.f6040a, aVar2);
        } catch (C2726m e) {
            C2726m.m6274a(e);
        }
    }

    /* renamed from: a */
    private static String m6193a(String str, String str2, Integer num, Integer num2, JSONObject jSONObject, Integer num3) {
        String str3 = "mianahwvc";
        return String.format(Locale.ROOT, "<html><head></head><body><div id=\"%s\" style=\"width: %dpx; height: %dpx;\"></div><script>(function initMoatTracking(apiname, pcode, ids, duration) {var events = [];window[pcode + '_moatElToTrack'] = document.getElementById('%s');var moatapi = {'dropTime':%d,'adData': {'ids': ids, 'duration': duration, 'url': 'n/a'},'dispatchEvent': function(ev) {if (this.sendEvent) {if (events) { events.push(ev); ev = events; events = false; }this.sendEvent(ev);} else {events.push(ev);}},'dispatchMany': function(evs){for (var i=0, l=evs.length; i<l; i++) {this.dispatchEvent(evs[i]);}}};Object.defineProperty(window, apiname, {'value': moatapi});var s = document.createElement('script');s.src = 'https://z.moatads.com/' + pcode + '/moatvideo.js?' + apiname + '#' + apiname;document.body.appendChild(s);})('%s', '%s', %s, %s);</script></body></html>", new Object[]{str3, num, num2, str3, Long.valueOf(System.currentTimeMillis()), str, str2, jSONObject.toString(), num3});
    }

    /* renamed from: b */
    private static String m6197b(String str) {
        StringBuilder sb = new StringBuilder("<!DOCTYPE html>\n<html>\n<head lang=\"en\">\n   <meta charset=\"UTF-8\">\n   <title></title>\n</head>\n<body style=\"margin:0;padding:0;\">\n    <script src=\"https://z.moatads.com/");
        sb.append(str);
        sb.append("/moatad.js\" type=\"text/javascript\"></script>\n</body>\n</html>");
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo29029a() {
        C2735p.m6310a(3, "GlobalWebView", (Object) this, "Cleaning up");
        this.f6041b.mo29054b();
        this.f6041b = null;
        this.f6040a.destroy();
        this.f6040a = null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo29030a(String str) {
        if (this.f6043d == C2712a.DISPLAY) {
            this.f6040a.setWebViewClient(new WebViewClient() {
                public void onPageFinished(WebView webView, String str) {
                    if (!C2707g.this.f6044e) {
                        try {
                            C2707g.this.f6044e = true;
                            C2707g.this.f6041b.mo29050a();
                        } catch (Exception e) {
                            C2726m.m6274a(e);
                        }
                    }
                }
            });
            this.f6040a.loadData(m6197b(str), "text/html", "utf-8");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo29031a(String str, Map<String, String> map, Integer num, Integer num2, Integer num3) {
        if (this.f6043d == C2712a.VIDEO) {
            String str2 = "GlobalWebView";
            if (VERSION.SDK_INT >= 19) {
                C2735p.m6310a(3, str2, (Object) this, "Starting off polling interval to check for Video API instance presence");
                this.f6045f = new Handler();
                this.f6046g = new Runnable() {
                    public void run() {
                        try {
                            if (C2707g.this.f6040a != null && VERSION.SDK_INT >= 19) {
                                WebView webView = C2707g.this.f6040a;
                                StringBuilder sb = new StringBuilder("typeof ");
                                sb.append(C2707g.this.f6042c);
                                sb.append(" !== 'undefined'");
                                webView.evaluateJavascript(sb.toString(), new ValueCallback<String>() {
                                    /* renamed from: a */
                                    public void onReceiveValue(String str) {
                                        if ("true".equals(str)) {
                                            C2735p.m6310a(3, "GlobalWebView", (Object) this, String.format("Video API instance %s detected. Flushing event queue", new Object[]{C2707g.this.f6042c}));
                                            try {
                                                C2707g.this.f6044e = true;
                                                C2707g.this.f6041b.mo29050a();
                                                C2707g.this.f6041b.mo29058c(C2707g.this.f6042c);
                                            } catch (Exception e) {
                                                C2726m.m6274a(e);
                                            }
                                        } else {
                                            C2707g.this.f6045f.postDelayed(C2707g.this.f6046g, 200);
                                        }
                                    }
                                });
                            }
                        } catch (Exception e) {
                            C2726m.m6274a(e);
                        }
                    }
                };
                this.f6045f.post(this.f6046g);
            } else {
                StringBuilder sb = new StringBuilder("Android API version is less than KitKat: ");
                sb.append(VERSION.SDK_INT);
                C2735p.m6310a(3, str2, (Object) this, sb.toString());
                this.f6040a.setWebViewClient(new WebViewClient() {
                    public void onPageFinished(WebView webView, String str) {
                        if (!C2707g.this.f6044e) {
                            C2735p.m6310a(3, "GlobalWebView", (Object) this, "onPageFinished is called for the first time. Flushing event queue");
                            try {
                                C2707g.this.f6044e = true;
                                C2707g.this.f6041b.mo29050a();
                                C2707g.this.f6041b.mo29058c(C2707g.this.f6042c);
                            } catch (Exception e) {
                                C2726m.m6274a(e);
                            }
                        }
                    }
                });
            }
            this.f6040a.loadData(m6193a(this.f6042c, str, num, num2, new JSONObject(map), num3), "text/html", null);
        }
    }
}
