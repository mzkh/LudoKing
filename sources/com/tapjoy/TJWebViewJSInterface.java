package com.tapjoy;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.TapjoyErrorMessage.ErrorType;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

public class TJWebViewJSInterface {

    /* renamed from: a */
    WebView f6440a;

    /* renamed from: b */
    TJWebViewJSInterfaceListener f6441b;

    /* renamed from: c */
    private final ConcurrentLinkedQueue f6442c = new ConcurrentLinkedQueue();

    /* renamed from: d */
    private boolean f6443d;

    @TargetApi(19)
    /* renamed from: com.tapjoy.TJWebViewJSInterface$a */
    class C2836a extends AsyncTask {

        /* renamed from: a */
        WebView f6444a;

        /* access modifiers changed from: protected */
        public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
            return ((String[]) objArr)[0];
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            String str = (String) obj;
            if (this.f6444a != null) {
                String str2 = "javascript:";
                String str3 = "TJWebViewJSInterface";
                if (!str.startsWith(str2) || VERSION.SDK_INT < 19) {
                    try {
                        this.f6444a.loadUrl(str);
                    } catch (Exception e) {
                        ErrorType errorType = ErrorType.INTERNAL_ERROR;
                        StringBuilder sb = new StringBuilder("Exception in loadUrl. Device not supported. ");
                        sb.append(e.toString());
                        TapjoyLog.m6551e(str3, new TapjoyErrorMessage(errorType, sb.toString()));
                    }
                } else {
                    try {
                        this.f6444a.evaluateJavascript(str.replaceFirst(str2, ""), null);
                    } catch (Exception e2) {
                        ErrorType errorType2 = ErrorType.INTERNAL_ERROR;
                        StringBuilder sb2 = new StringBuilder("Exception in evaluateJavascript. Device not supported. ");
                        sb2.append(e2.toString());
                        TapjoyLog.m6551e(str3, new TapjoyErrorMessage(errorType2, sb2.toString()));
                    }
                }
            }
        }

        public C2836a(WebView webView) {
            this.f6444a = webView;
        }
    }

    public TJWebViewJSInterface(WebView webView, TJWebViewJSInterfaceListener tJWebViewJSInterfaceListener) {
        this.f6440a = webView;
        this.f6441b = tJWebViewJSInterfaceListener;
    }

    @JavascriptInterface
    public void dispatchMethod(String str) {
        StringBuilder sb = new StringBuilder("dispatchMethod params: ");
        sb.append(str);
        String str2 = "TJWebViewJSInterface";
        TapjoyLog.m6550d(str2, sb.toString());
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getJSONObject("data").getString("method");
            StringBuilder sb2 = new StringBuilder("method: ");
            sb2.append(string);
            TapjoyLog.m6550d(str2, sb2.toString());
            if (this.f6441b != null) {
                this.f6441b.onDispatchMethod(string, jSONObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void callback(ArrayList arrayList, String str, String str2) {
        try {
            callbackToJavaScript(new JSONArray(arrayList), str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void callback(Map map, String str, String str2) {
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject(map));
            callbackToJavaScript(jSONArray, str, str2);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("Exception in callback to JS: ");
            sb.append(e.toString());
            TapjoyLog.m6552e("TJWebViewJSInterface", sb.toString());
            e.printStackTrace();
        }
    }

    public void callbackToJavaScript(Object obj, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(String.ARGUMENTS, obj);
            if (str != null && str.length() > 0) {
                jSONObject.put("method", str);
            }
            JSONObject jSONObject2 = new JSONObject();
            if (str2 != null && str2.length() > 0) {
                jSONObject2.put(String.CALLBACK_ID, str2);
            }
            jSONObject2.put("data", jSONObject);
            StringBuilder sb = new StringBuilder("javascript:if(window.AndroidWebViewJavascriptBridge) AndroidWebViewJavascriptBridge._handleMessageFromAndroid('");
            sb.append(jSONObject2);
            sb.append("');");
            String sb2 = sb.toString();
            if (!this.f6443d) {
                this.f6442c.add(sb2);
                return;
            }
            new C2836a(this.f6440a).execute(new String[]{sb2});
        } catch (Exception e) {
            StringBuilder sb3 = new StringBuilder("Exception in callback to JS: ");
            sb3.append(e.toString());
            TapjoyLog.m6552e("TJWebViewJSInterface", sb3.toString());
            e.printStackTrace();
        }
    }

    public void flushMessageQueue() {
        if (!this.f6443d) {
            while (true) {
                String str = (String) this.f6442c.poll();
                if (str != null) {
                    new C2836a(this.f6440a).execute(new String[]{str});
                } else {
                    this.f6443d = true;
                    return;
                }
            }
        }
    }
}
