package com.moat.analytics.mobile.inm;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Build.VERSION;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import com.facebook.appevents.AppEventsConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.inm.j */
class C2719j {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f6077a = 0;

    /* renamed from: b */
    private boolean f6078b = false;

    /* renamed from: c */
    private boolean f6079c = false;

    /* renamed from: d */
    private final AtomicBoolean f6080d = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f6081e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f6082f = false;

    /* renamed from: g */
    private boolean f6083g = false;
    @NonNull

    /* renamed from: h */
    private final WeakReference<WebView> f6084h;

    /* renamed from: i */
    private final Map<C2701b, String> f6085i;

    /* renamed from: j */
    private final LinkedList<String> f6086j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final long f6087k;

    /* renamed from: l */
    private final String f6088l;

    /* renamed from: m */
    private final List<String> f6089m;

    /* renamed from: n */
    private final C2723a f6090n;

    /* renamed from: o */
    private final BroadcastReceiver f6091o = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            try {
                C2719j.this.m6231d();
            } catch (Exception e) {
                C2726m.m6274a(e);
            }
            if (System.currentTimeMillis() - C2719j.this.f6087k > 30000) {
                C2719j.this.m6246i();
            }
        }
    };

    /* renamed from: p */
    private final BroadcastReceiver f6092p = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            try {
                C2719j.this.m6235e();
            } catch (Exception e) {
                C2726m.m6274a(e);
            }
        }
    };

    /* renamed from: com.moat.analytics.mobile.inm.j$a */
    enum C2723a {
        WEBVIEW,
        NATIVE_DISPLAY,
        NATIVE_VIDEO
    }

    C2719j(WebView webView, C2723a aVar) {
        this.f6084h = new WeakReference<>(webView);
        this.f6090n = aVar;
        this.f6086j = new LinkedList<>();
        this.f6089m = new ArrayList();
        this.f6085i = new WeakHashMap();
        this.f6087k = System.currentTimeMillis();
        this.f6088l = String.format("javascript:(function(d,k){function l(){function d(a,b){var c=ipkn[b]||ipkn[kuea];if(c){var h=function(b){var c=b.b;c.ts=b.i;c.ticks=b.g;c.buffered=!0;a(c)};h(c.first);c.a.forEach(function(a){h(a)})}}function e(a){var b=a.a,c=a.c,h=a.b;a=a.f;var d=[];if(c)b[c]&&d.push(b[c].fn[0]);else for(key in b)if(b[key])for(var g=0,e=b[key].fn.length;g<e;g++)d.push(b[key].fn[g]);g=0;for(e=d.length;g<e;g++){var f=d[g];if('function'===typeof f)try{h?f(h):f()}catch(k){}a&&delete b[c]}}function f(a,b,c){'function'===typeof a&& (b===kuea&&c[b]?c[b].fn.push(a):c[b]={ts:+new Date,fn:[a]},c===yhgt&&d(a,b))}kuea=+new Date;iymv={};briz=!1;ewat=+new Date;bnkr=[];bjmk={};dptk={};uqaj={};ryup={};yhgt={};ipkn={};csif={};this.h=function(a){this.namespace=a.namespace;this.version=a.version;this.appName=a.appName;this.deviceOS=a.deviceOS;this.isNative=a.isNative;this.versionHash=a.versionHash;this.aqzx=a.aqzx;this.appId=a.appId;this.metadata=a};this.nvsj=function(a){briz||(f(a,ewat,iymv),briz=!0)};this.bpsy=function(a,b){var c=b||kuea; c!==kuea&&bjmk[c]||f(a,c,bjmk)};this.qmrv=function(a,b){var c=b||kuea;c!==kuea&&uqaj[c]||f(a,c,uqaj)};this.lgpr=function(a,b){f(a,b||kuea,yhgt)};this.hgen=function(a,b){f(a,b||kuea,csif)};this.xrnk=function(a){delete yhgt[a||kuea]};this.vgft=function(a){return dptk[a||kuea]||!1};this.lkpu=function(a){return ryup[a||kuea]||!1};this.crts=function(a){var b={a:iymv,b:a,c:ewat};briz?e(b):bnkr.push(a)};this.mqjh=function(a){var b=a||kuea;dptk[b]=!0;var c={a:bjmk,f:!0};b!==kuea&&(c.b=a,c.c=a);e(c)};this.egpw= function(a){var b=a||kuea;ryup[b]=!0;var c={a:uqaj,f:!0};b!==kuea&&(c.b=a,c.c=a);e(c)};this.sglu=function(a){var b=a.adKey||kuea,c={a:yhgt,b:a.event||a,g:1,i:+new Date,f:!1};b!==kuea&&(c.c=a.adKey);a=0<Object.keys(yhgt).length;if(!a||!this.isNative)if(ipkn[b]){var d=ipkn[b].a.slice(-1)[0]||ipkn[b].first;JSON.stringify(c.b)==JSON.stringify(d.b)?d.g+=1:(5<=ipkn[b].a.length&&ipkn[b].a.shift(),ipkn[b].a.push(c))}else ipkn[b]={first:c,a:[]};a&&e(c);return a};this.ucbx=function(a){e({c:a.adKey||kuea,a:csif, b:a.event,f:!1})}}'undefined'===typeof d.MoatMAK&&(d.MoatMAK=new l,d.MoatMAK.h(k),d.__zMoatInit__=!0)})(window,%s);", new Object[]{m6244h()});
        if (m6234d("Initialize")) {
            IntentFilter intentFilter = new IntentFilter("UPDATE_METADATA");
            IntentFilter intentFilter2 = new IntentFilter("UPDATE_VIEW_INFO");
            LocalBroadcastManager.getInstance(C2738s.m6323c()).registerReceiver(this.f6091o, intentFilter);
            LocalBroadcastManager.getInstance(C2738s.m6323c()).registerReceiver(this.f6092p, intentFilter2);
            m6231d();
            C2716i.m6212a().mo29045a(C2738s.m6323c(), this);
            C2735p.m6310a(3, "JavaScriptBridge", (Object) this, "bridge initialization succeeded");
        }
    }

    /* renamed from: a */
    private boolean m6225a(WebView webView) {
        return webView.getSettings().getJavaScriptEnabled();
    }

    /* renamed from: c */
    private void m6229c() {
        for (Entry key : this.f6085i.entrySet()) {
            C2701b bVar = (C2701b) key.getKey();
            if (bVar.mo29007e()) {
                m6243g(String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.mqjh(\"%s\");}", new Object[]{bVar.f6019e}));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m6231d() {
        String str = "JavaScriptBridge";
        try {
            if (C2750w.m6348a().f6155a != C2758d.OFF) {
                if (!this.f6079c) {
                    C2735p.m6310a(3, str, (Object) this, "Attempting to establish communication (setting environment variables).");
                    this.f6079c = true;
                }
                m6243g(this.f6088l);
            }
        } catch (Exception e) {
            C2735p.m6312a(str, (Object) this, "Attempt failed to establish communication (did not set environment variables).", (Throwable) e);
        }
    }

    /* renamed from: d */
    private void m6232d(C2701b bVar) {
        C2735p.m6310a(3, "JavaScriptBridge", (Object) this, "Stopping view update loop");
        if (bVar != null) {
            C2716i.m6212a().mo29046a(bVar);
        }
    }

    /* renamed from: d */
    private boolean m6234d(String str) {
        WebView g = m6241g();
        String str2 = "JavaScriptBridge";
        if (g == null) {
            C2735p.m6310a(6, str2, (Object) this, "WebView is null. Can't ".concat(String.valueOf(str)));
            throw new C2726m("WebView is null");
        } else if (m6225a(g)) {
            return true;
        } else {
            C2735p.m6310a(6, str2, (Object) this, "JavaScript is not enabled in the given WebView. Can't ".concat(String.valueOf(str)));
            throw new C2726m("JavaScript is not enabled in the WebView");
        }
    }

    /* access modifiers changed from: private */
    @TargetApi(19)
    /* renamed from: e */
    public void m6235e() {
        try {
            if (C2750w.m6348a().f6155a != C2758d.OFF) {
                String str = "JavaScriptBridge";
                if (this.f6083g) {
                    C2735p.m6310a(3, str, (Object) this, "Can't send info, already cleaned up");
                    return;
                }
                if (m6240f()) {
                    if (!this.f6078b || m6241g().getUrl() != null) {
                        if (m6241g().getUrl() != null) {
                            this.f6078b = true;
                        }
                        for (Entry key : this.f6085i.entrySet()) {
                            C2701b bVar = (C2701b) key.getKey();
                            if (bVar == null || bVar.mo29008f() == null) {
                                C2735p.m6310a(3, str, (Object) this, "Tracker has no subject");
                                if (bVar != null) {
                                    if (!bVar.f6020f) {
                                    }
                                }
                                mo29057c(bVar);
                            }
                            if (bVar.mo29007e()) {
                                if (!this.f6080d.get()) {
                                    m6243g(String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.mqjh(\"%s\");}", new Object[]{bVar.f6019e}));
                                }
                                String format = String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.sglu(%s);}", new Object[]{bVar.mo29010h()});
                                if (VERSION.SDK_INT >= 19) {
                                    m6241g().evaluateJavascript(format, new ValueCallback<String>() {
                                        /* renamed from: a */
                                        public void onReceiveValue(String str) {
                                            String str2 = "false";
                                            String str3 = "null";
                                            String str4 = "JavaScriptBridge";
                                            if (str == null || str.equalsIgnoreCase(str3) || str.equalsIgnoreCase(str2)) {
                                                C2719j jVar = C2719j.this;
                                                StringBuilder sb = new StringBuilder("Received value is:");
                                                if (str != null) {
                                                    str3 = "(String)".concat(String.valueOf(str));
                                                }
                                                sb.append(str3);
                                                C2735p.m6310a(3, str4, (Object) jVar, sb.toString());
                                                if (C2719j.this.f6077a >= 150) {
                                                    C2735p.m6310a(3, str4, (Object) C2719j.this, "Giving up on finding ad");
                                                    C2719j.this.mo29054b();
                                                }
                                                C2719j.this.f6077a = C2719j.this.f6077a + 1;
                                                if (str != null && str.equalsIgnoreCase(str2) && !C2719j.this.f6081e) {
                                                    C2719j.this.f6081e = true;
                                                    C2735p.m6310a(3, str4, (Object) C2719j.this, "Bridge connection established");
                                                }
                                            } else if (str.equalsIgnoreCase("true")) {
                                                if (!C2719j.this.f6082f) {
                                                    C2719j.this.f6082f = true;
                                                    C2735p.m6310a(3, str4, (Object) C2719j.this, "Javascript has found ad");
                                                    C2719j.this.mo29050a();
                                                }
                                                C2719j.this.f6077a = 0;
                                            } else {
                                                C2735p.m6310a(3, str4, (Object) C2719j.this, "Received unusual value from Javascript:".concat(String.valueOf(str)));
                                            }
                                        }
                                    });
                                } else {
                                    m6241g().loadUrl(format);
                                }
                            }
                        }
                        return;
                    }
                }
                StringBuilder sb = new StringBuilder("WebView became null");
                sb.append(m6241g() == null ? "" : "based on null url");
                sb.append(", stopping tracking loop");
                C2735p.m6310a(3, str, (Object) this, sb.toString());
                mo29054b();
            }
        } catch (Exception e) {
            C2726m.m6274a(e);
            mo29054b();
        }
    }

    /* renamed from: e */
    private void m6237e(String str) {
        if (this.f6089m.size() >= 50) {
            this.f6089m.subList(0, 25).clear();
        }
        this.f6089m.add(str);
    }

    /* renamed from: f */
    private void m6239f(String str) {
        if (this.f6080d.get()) {
            m6243g(str);
        } else {
            m6237e(str);
        }
    }

    /* renamed from: f */
    private boolean m6240f() {
        return m6241g() != null;
    }

    /* renamed from: g */
    private WebView m6241g() {
        return (WebView) this.f6084h.get();
    }

    @UiThread
    /* renamed from: g */
    private void m6243g(String str) {
        String str2 = "JavaScriptBridge";
        if (this.f6083g) {
            C2735p.m6310a(3, str2, (Object) this, "Can't send, already cleaned up");
            return;
        }
        if (m6240f()) {
            C2735p.m6314b(2, str2, this, str);
            if (VERSION.SDK_INT >= 19) {
                m6241g().evaluateJavascript(str, null);
                return;
            }
            m6241g().loadUrl(str);
        }
    }

    /* renamed from: h */
    private String m6244h() {
        try {
            C2740a d = C2738s.m6324d();
            C2741b e = C2738s.m6325e();
            HashMap hashMap = new HashMap();
            String a = d.mo29084a();
            String b = d.mo29085b();
            String c = d.mo29086c();
            String num = Integer.toString(VERSION.SDK_INT);
            String b2 = C2738s.m6321b();
            C2723a aVar = this.f6090n;
            C2723a aVar2 = C2723a.WEBVIEW;
            String str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            String str2 = "1";
            String str3 = aVar == aVar2 ? str : str2;
            String str4 = e.f6148e ? str2 : str;
            String str5 = e.f6147d ? str2 : str;
            if (!((C2724k) MoatAnalytics.getInstance()).mo29065b()) {
                str = str2;
            }
            hashMap.put("versionHash", "c334ae83accfebb8da23104450c896463c9cfab7");
            hashMap.put("appName", a);
            hashMap.put("namespace", "INM");
            hashMap.put("version", "2.5.0");
            hashMap.put("deviceOS", num);
            hashMap.put("isNative", str3);
            hashMap.put("appId", b);
            hashMap.put("source", c);
            hashMap.put("carrier", e.f6145b);
            hashMap.put("sim", e.f6144a);
            hashMap.put("phone", String.valueOf(e.f6146c));
            hashMap.put("buildFp", Build.FINGERPRINT);
            hashMap.put("buildModel", Build.MODEL);
            hashMap.put("buildMfg", Build.MANUFACTURER);
            hashMap.put("buildBrand", Build.BRAND);
            hashMap.put("buildProduct", Build.PRODUCT);
            hashMap.put("buildTags", Build.TAGS);
            hashMap.put("f1", str5);
            hashMap.put("f2", str4);
            hashMap.put("locationEnabled", str);
            if (b2 != null) {
                hashMap.put("aqzx", b2);
            }
            return new JSONObject(hashMap).toString();
        } catch (Exception unused) {
            return "{}";
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m6246i() {
        C2735p.m6310a(3, "JavaScriptBridge", (Object) this, "Stopping metadata reporting loop");
        C2716i.m6212a().mo29047a(this);
        LocalBroadcastManager.getInstance(C2738s.m6323c()).unregisterReceiver(this.f6091o);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo29050a() {
        String str = "JavaScriptBridge";
        C2735p.m6310a(3, str, (Object) this, "webViewReady");
        if (this.f6080d.compareAndSet(false, true)) {
            C2735p.m6310a(3, str, (Object) this, "webViewReady first time");
            m6246i();
            for (String g : this.f6089m) {
                m6243g(g);
            }
            this.f6089m.clear();
        }
        m6229c();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo29051a(C2701b bVar) {
        if (bVar != null) {
            StringBuilder sb = new StringBuilder("adding tracker");
            sb.append(bVar.f6019e);
            C2735p.m6310a(3, "JavaScriptBridge", (Object) this, sb.toString());
            this.f6085i.put(bVar, "");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo29052a(String str) {
        m6239f(String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.crts(%s);}", new Object[]{str}));
    }

    /* access modifiers changed from: 0000 */
    @UiThread
    /* renamed from: a */
    public void mo29053a(String str, JSONObject jSONObject) {
        if (this.f6083g) {
            C2735p.m6310a(3, "JavaScriptBridge", (Object) this, "Can't dispatch, already cleaned up");
            return;
        }
        String jSONObject2 = jSONObject.toString();
        if (!this.f6080d.get() || !m6240f()) {
            this.f6086j.add(jSONObject2);
            return;
        }
        m6243g(String.format("javascript:%s.dispatchEvent(%s);", new Object[]{str, jSONObject2}));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo29054b() {
        C2735p.m6310a(3, "JavaScriptBridge", (Object) this, "Cleaning up");
        this.f6083g = true;
        m6246i();
        for (Entry key : this.f6085i.entrySet()) {
            m6232d((C2701b) key.getKey());
        }
        this.f6085i.clear();
        LocalBroadcastManager.getInstance(C2738s.m6323c()).unregisterReceiver(this.f6092p);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo29055b(C2701b bVar) {
        if (m6234d("startTracking")) {
            StringBuilder sb = new StringBuilder("Starting tracking on tracker");
            sb.append(bVar.f6019e);
            C2735p.m6310a(3, "JavaScriptBridge", (Object) this, sb.toString());
            m6243g(String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.mqjh(\"%s\");}", new Object[]{bVar.f6019e}));
            C2716i.m6212a().mo29044a(C2738s.m6323c(), bVar);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo29056b(String str) {
        String str2 = "JavaScriptBridge";
        C2735p.m6310a(3, str2, (Object) this, "markUserInteractionEvent:".concat(String.valueOf(str)));
        m6239f(String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.ucbx(%s);}", new Object[]{str}));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo29057c(C2701b bVar) {
        String str = "JavaScriptBridge";
        Throwable th = null;
        if (!this.f6083g) {
            try {
                if (m6234d("stopTracking")) {
                    try {
                        StringBuilder sb = new StringBuilder("Ending tracking on tracker");
                        sb.append(bVar.f6019e);
                        C2735p.m6310a(3, str, (Object) this, sb.toString());
                        m6243g(String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.egpw(\"%s\");}", new Object[]{bVar.f6019e}));
                    } catch (Exception e) {
                        C2735p.m6312a(str, (Object) this, "Failed to end impression.", (Throwable) e);
                    }
                }
            } catch (C2726m e2) {
                th = e2;
            }
            if (this.f6090n == C2723a.NATIVE_DISPLAY) {
                m6232d(bVar);
            } else {
                mo29054b();
            }
            this.f6085i.remove(bVar);
        }
        if (th != null) {
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo29058c(String str) {
        C2735p.m6310a(3, "JavaScriptBridge", (Object) this, "flushDispatchQueue");
        if (this.f6086j.size() >= 200) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < 10; i++) {
                linkedList.addFirst((String) this.f6086j.removeFirst());
            }
            int min = Math.min(Math.min(this.f6086j.size() / Callback.DEFAULT_DRAG_ANIMATION_DURATION, 10) + Callback.DEFAULT_DRAG_ANIMATION_DURATION, this.f6086j.size());
            for (int i2 = 0; i2 < min; i2++) {
                this.f6086j.removeFirst();
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                this.f6086j.addFirst((String) it.next());
            }
        }
        if (!this.f6086j.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            String str2 = "";
            int i3 = 1;
            while (!this.f6086j.isEmpty() && i3 < 200) {
                i3++;
                String str3 = (String) this.f6086j.removeFirst();
                if (sb.length() + str3.length() > 2000) {
                    break;
                }
                sb.append(str2);
                sb.append(str3);
                str2 = ",";
            }
            m6243g(String.format("javascript:%s.dispatchMany([%s])", new Object[]{str, sb.toString()}));
        }
        this.f6086j.clear();
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        try {
            super.finalize();
            C2735p.m6310a(3, "JavaScriptBridge", (Object) this, "finalize");
            mo29054b();
        } catch (Exception e) {
            C2726m.m6274a(e);
        }
    }
}
