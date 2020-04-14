package com.applovin.impl.adview;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;

/* renamed from: com.applovin.impl.adview.b */
class C0800b extends WebChromeClient {

    /* renamed from: a */
    private final C1227o f1371a;

    public C0800b(C1192i iVar) {
        this.f1371a = iVar.mo10249v();
    }

    public void onConsoleMessage(String str, int i, String str2) {
        C1227o oVar = this.f1371a;
        StringBuilder sb = new StringBuilder();
        sb.append("console.log[");
        sb.append(i);
        sb.append("] :");
        sb.append(str);
        oVar.mo10381d("AdWebView", sb.toString());
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        StringBuilder sb = new StringBuilder();
        sb.append(consoleMessage.sourceId());
        String str = ": ";
        sb.append(str);
        sb.append(consoleMessage.lineNumber());
        sb.append(str);
        sb.append(consoleMessage.message());
        this.f1371a.mo10378b("AdWebView", sb.toString());
        return true;
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        C1227o oVar = this.f1371a;
        StringBuilder sb = new StringBuilder();
        sb.append("Alert attempted: ");
        sb.append(str2);
        oVar.mo10381d("AdWebView", sb.toString());
        return true;
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        C1227o oVar = this.f1371a;
        StringBuilder sb = new StringBuilder();
        sb.append("JS onBeforeUnload attempted: ");
        sb.append(str2);
        oVar.mo10381d("AdWebView", sb.toString());
        return true;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        C1227o oVar = this.f1371a;
        StringBuilder sb = new StringBuilder();
        sb.append("JS confirm attempted: ");
        sb.append(str2);
        oVar.mo10381d("AdWebView", sb.toString());
        return true;
    }
}
