package com.iab.omid.library.inmobi.p032b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.inmobi.adsession.ErrorType;
import com.iab.omid.library.inmobi.p034d.C2095c;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.inmobi.b.d */
public class C2084d {

    /* renamed from: a */
    private static C2084d f4133a = new C2084d();

    private C2084d() {
    }

    /* renamed from: a */
    public static C2084d m3986a() {
        return f4133a;
    }

    /* renamed from: a */
    public void mo27569a(WebView webView) {
        mo27574a(webView, "finishSession", new Object[0]);
    }

    /* renamed from: a */
    public void mo27570a(WebView webView, float f) {
        mo27574a(webView, "setDeviceVolume", Float.valueOf(f));
    }

    /* renamed from: a */
    public void mo27571a(WebView webView, ErrorType errorType, String str) {
        mo27574a(webView, "error", errorType.toString(), str);
    }

    /* renamed from: a */
    public void mo27572a(WebView webView, String str, JSONObject jSONObject) {
        String str2 = "publishVideoEvent";
        if (jSONObject != null) {
            mo27574a(webView, str2, str, jSONObject);
            return;
        }
        mo27574a(webView, str2, str);
    }

    /* renamed from: a */
    public void mo27573a(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        mo27574a(webView, "startSession", str, jSONObject, jSONObject2);
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo27574a(WebView webView, String str, Object... objArr) {
        if (webView != null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
            sb.append(str);
            sb.append("(");
            mo27577a(sb, objArr);
            sb.append(")}");
            mo27575a(webView, sb);
            return;
        }
        C2095c.m4041a("The WebView is null for ".concat(String.valueOf(str)));
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo27575a(final WebView webView, StringBuilder sb) {
        final String sb2 = sb.toString();
        Handler handler = webView.getHandler();
        if (handler == null || Looper.myLooper() == handler.getLooper()) {
            webView.loadUrl(sb2);
        } else {
            handler.post(new Runnable() {
                public void run() {
                    webView.loadUrl(sb2);
                }
            });
        }
    }

    /* renamed from: a */
    public void mo27576a(WebView webView, JSONObject jSONObject) {
        mo27574a(webView, "init", jSONObject);
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo27577a(StringBuilder sb, Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                if (obj == null) {
                    sb.append('\"');
                } else {
                    if (obj instanceof String) {
                        String obj2 = obj.toString();
                        if (obj2.startsWith("{")) {
                            sb.append(obj2);
                        } else {
                            sb.append('\"');
                            sb.append(obj2);
                        }
                    } else {
                        sb.append(obj);
                    }
                    sb.append(",");
                }
                sb.append('\"');
                sb.append(",");
            }
            sb.setLength(sb.length() - 1);
        }
    }

    /* renamed from: a */
    public boolean mo27578a(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        webView.loadUrl("javascript: ".concat(String.valueOf(str)));
        return true;
    }

    /* renamed from: b */
    public void mo27579b(WebView webView) {
        mo27574a(webView, "publishImpressionEvent", new Object[0]);
    }

    /* renamed from: b */
    public void mo27580b(WebView webView, String str) {
        if (str != null) {
            mo27578a(webView, "var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);".replace("%SCRIPT_SRC%", str));
        }
    }

    /* renamed from: c */
    public void mo27581c(WebView webView, String str) {
        mo27574a(webView, "setNativeViewHierarchy", str);
    }

    /* renamed from: d */
    public void mo27582d(WebView webView, String str) {
        mo27574a(webView, "setState", str);
    }
}
