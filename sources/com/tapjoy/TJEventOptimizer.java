package com.tapjoy;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tapjoy.TapjoyErrorMessage.ErrorType;
import java.util.concurrent.CountDownLatch;

@SuppressLint({"SetJavaScriptEnabled"})
public class TJEventOptimizer extends WebView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static String f6362a = "TJEventOptimizer";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static TJEventOptimizer f6363b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static CountDownLatch f6364c;

    /* renamed from: d */
    private Context f6365d;

    /* renamed from: e */
    private TJAdUnitJSBridge f6366e;

    /* renamed from: com.tapjoy.TJEventOptimizer$a */
    class C2823a extends WebChromeClient {
        private C2823a() {
        }

        /* synthetic */ C2823a(TJEventOptimizer tJEventOptimizer, byte b) {
            this();
        }

        @TargetApi(8)
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            String a = TJEventOptimizer.f6362a;
            StringBuilder sb = new StringBuilder("JS CONSOLE: ");
            sb.append(consoleMessage.message());
            sb.append(" -- From line ");
            sb.append(consoleMessage.lineNumber());
            sb.append(" of ");
            sb.append(consoleMessage.sourceId());
            TapjoyLog.m6550d(a, sb.toString());
            return true;
        }
    }

    /* renamed from: com.tapjoy.TJEventOptimizer$b */
    class C2824b extends WebViewClient {
        private C2824b() {
        }

        /* synthetic */ C2824b(TJEventOptimizer tJEventOptimizer, byte b) {
            this();
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            TapjoyLog.m6551e(TJEventOptimizer.f6362a, new TapjoyErrorMessage(ErrorType.SDK_ERROR, "Error encountered when instantiating a WebViewClient"));
        }

        public final void onPageFinished(WebView webView, String str) {
            TapjoyLog.m6550d(TJEventOptimizer.f6362a, "boostrap html loaded successfully");
        }
    }

    /* synthetic */ TJEventOptimizer(Context context, byte b) {
        this(context);
    }

    private TJEventOptimizer(Context context) {
        super(context);
        this.f6365d = context;
        this.f6366e = new TJAdUnitJSBridge(this.f6365d, (WebView) this);
        getSettings().setJavaScriptEnabled(true);
        setWebViewClient(new C2824b(this, 0));
        setWebChromeClient(new C2823a(this, 0));
        StringBuilder sb = new StringBuilder();
        sb.append(TapjoyConnectCore.getHostURL());
        sb.append(TJAdUnitConstants.EVENTS_PROXY_PATH);
        sb.append(TapjoyUtil.convertURLParams(TapjoyConnectCore.getGenericURLParams(), true));
        loadUrl(sb.toString());
    }

    public static void init(final Context context) {
        TapjoyLog.m6550d(f6362a, "Initializing event optimizer");
        f6364c = new CountDownLatch(1);
        TapjoyUtil.runOnMainThread(new Runnable() {
            public final void run() {
                try {
                    TJEventOptimizer.f6363b = new TJEventOptimizer(context, 0);
                } catch (Exception e) {
                    TapjoyLog.m6555w(TJEventOptimizer.f6362a, e.getMessage());
                }
                TJEventOptimizer.f6364c.countDown();
            }
        });
        f6364c.await();
        if (f6363b == null) {
            throw new RuntimeException("Failed to init TJEventOptimizer");
        }
    }

    public static TJEventOptimizer getInstance() {
        return f6363b;
    }
}
