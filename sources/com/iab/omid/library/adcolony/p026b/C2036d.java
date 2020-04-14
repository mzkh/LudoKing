package com.iab.omid.library.adcolony.p026b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.adcolony.adsession.ErrorType;
import com.iab.omid.library.adcolony.p028d.C2047c;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.adcolony.b.d */
public class C2036d {

    /* renamed from: a */
    private static C2036d f4034a = new C2036d();

    private C2036d() {
    }

    /* renamed from: a */
    public static C2036d m3782a() {
        return f4034a;
    }

    /* renamed from: a */
    public void mo27406a(WebView webView) {
        mo27411a(webView, "finishSession", new Object[0]);
    }

    /* renamed from: a */
    public void mo27407a(WebView webView, float f) {
        mo27411a(webView, "setDeviceVolume", Float.valueOf(f));
    }

    /* renamed from: a */
    public void mo27408a(WebView webView, ErrorType errorType, String str) {
        mo27411a(webView, "error", errorType.toString(), str);
    }

    /* renamed from: a */
    public void mo27409a(WebView webView, String str, JSONObject jSONObject) {
        String str2 = "publishVideoEvent";
        if (jSONObject != null) {
            mo27411a(webView, str2, str, jSONObject);
            return;
        }
        mo27411a(webView, str2, str);
    }

    /* renamed from: a */
    public void mo27410a(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        mo27411a(webView, "startSession", str, jSONObject, jSONObject2);
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo27411a(WebView webView, String str, Object... objArr) {
        if (webView != null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
            sb.append(str);
            sb.append("(");
            mo27414a(sb, objArr);
            sb.append(")}");
            mo27412a(webView, sb);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("The WebView is null for ");
        sb2.append(str);
        C2047c.m3835a(sb2.toString());
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo27412a(final WebView webView, StringBuilder sb) {
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
    public void mo27413a(WebView webView, JSONObject jSONObject) {
        mo27411a(webView, "init", jSONObject);
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo27414a(StringBuilder sb, Object[] objArr) {
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
    public boolean mo27415a(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("javascript: ");
        sb.append(str);
        webView.loadUrl(sb.toString());
        return true;
    }

    /* renamed from: b */
    public void mo27416b(WebView webView) {
        mo27411a(webView, "publishImpressionEvent", new Object[0]);
    }

    /* renamed from: b */
    public void mo27417b(WebView webView, String str) {
        if (str != null) {
            mo27415a(webView, "var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);".replace("%SCRIPT_SRC%", str));
        }
    }

    /* renamed from: c */
    public void mo27418c(WebView webView, String str) {
        mo27411a(webView, "setNativeViewHierarchy", str);
    }

    /* renamed from: d */
    public void mo27419d(WebView webView, String str) {
        mo27411a(webView, "setState", str);
    }
}
