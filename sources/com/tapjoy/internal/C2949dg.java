package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.VisibleForTesting;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.dg */
public final class C2949dg {

    /* renamed from: a */
    private static C2949dg f6811a = new C2949dg();

    private C2949dg() {
    }

    /* renamed from: a */
    public static C2949dg m6726a() {
        return f6811a;
    }

    @VisibleForTesting
    /* renamed from: a */
    private static void m6727a(StringBuilder sb, Object[] objArr) {
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
    public static boolean m6728a(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        StringBuilder sb = new StringBuilder("javascript: ");
        sb.append(str);
        webView.loadUrl(sb.toString());
        return true;
    }

    /* renamed from: a */
    public final void mo29947a(WebView webView, String str, JSONObject jSONObject) {
        String str2 = "publishVideoEvent";
        if (jSONObject != null) {
            mo29948a(webView, str2, str, jSONObject);
            return;
        }
        mo29948a(webView, str2, str);
    }

    /* renamed from: b */
    public final void mo29949b(WebView webView, String str) {
        mo29948a(webView, "setNativeViewHierarchy", str);
    }

    @VisibleForTesting
    /* renamed from: a */
    public final void mo29948a(final WebView webView, String str, Object... objArr) {
        if (webView != null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
            sb.append(str);
            sb.append("(");
            m6727a(sb, objArr);
            sb.append(")}");
            final String sb2 = sb.toString();
            Handler handler = webView.getHandler();
            if (handler == null || Looper.myLooper() == handler.getLooper()) {
                webView.loadUrl(sb2);
            } else {
                handler.post(new Runnable() {
                    public final void run() {
                        webView.loadUrl(sb2);
                    }
                });
            }
        }
    }
}
