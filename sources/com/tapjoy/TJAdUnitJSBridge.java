package com.tapjoy;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.TapjoyErrorMessage.ErrorType;
import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.C1852jq;
import com.tapjoy.internal.C2874al;
import com.tapjoy.internal.C3013eq;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"SetJavaScriptEnabled"})
public class TJAdUnitJSBridge implements TJWebViewJSInterfaceListener {

    /* renamed from: a */
    public TJAdUnit f6237a;
    public boolean allowRedirect;

    /* renamed from: b */
    public WebView f6238b;

    /* renamed from: c */
    final ConcurrentLinkedQueue f6239c;
    public boolean closeRequested;
    public boolean customClose;

    /* renamed from: d */
    private TJWebViewJSInterface f6240d;
    public boolean didLaunchOtherActivity;

    /* renamed from: e */
    private TJAdUnitJSBridge f6241e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Context f6242f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TJAdUnitActivity f6243g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TJSplitWebView f6244h;

    /* renamed from: i */
    private ProgressDialog f6245i;

    /* renamed from: j */
    private View f6246j;

    /* renamed from: k */
    private boolean f6247k;

    /* renamed from: l */
    private C3013eq f6248l;
    public String otherActivityCallbackID;
    public String splitWebViewCallbackID;

    public interface AdUnitAsyncTaskListner {
        void onComplete(boolean z);
    }

    @TargetApi(11)
    /* renamed from: com.tapjoy.TJAdUnitJSBridge$a */
    class C2807a extends AsyncTask {

        /* renamed from: a */
        WebView f6287a;

        /* access modifiers changed from: protected */
        public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
            return (Boolean[]) objArr;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            Boolean[] boolArr = (Boolean[]) obj;
            final boolean booleanValue = boolArr[0].booleanValue();
            final boolean booleanValue2 = boolArr[1].booleanValue();
            if (TJAdUnitJSBridge.this.f6242f instanceof Activity) {
                TapjoyUtil.runOnMainThread(new Runnable() {
                    public final void run() {
                        if (booleanValue) {
                            C2807a.this.f6287a.setVisibility(0);
                            if (booleanValue2) {
                                if (C2807a.this.f6287a.getParent() instanceof RelativeLayout) {
                                    ((RelativeLayout) C2807a.this.f6287a.getParent()).getBackground().setAlpha(0);
                                    ((RelativeLayout) C2807a.this.f6287a.getParent()).setBackgroundColor(0);
                                }
                                if (VERSION.SDK_INT >= 11) {
                                    C2807a.this.f6287a.setLayerType(1, null);
                                }
                            } else {
                                if (C2807a.this.f6287a.getParent() instanceof RelativeLayout) {
                                    ((RelativeLayout) C2807a.this.f6287a.getParent()).getBackground().setAlpha(255);
                                    ((RelativeLayout) C2807a.this.f6287a.getParent()).setBackgroundColor(-1);
                                }
                                if (VERSION.SDK_INT >= 11) {
                                    C2807a.this.f6287a.setLayerType(0, null);
                                }
                            }
                        } else {
                            C2807a.this.f6287a.setVisibility(4);
                            if (C2807a.this.f6287a.getParent() instanceof RelativeLayout) {
                                ((RelativeLayout) C2807a.this.f6287a.getParent()).getBackground().setAlpha(0);
                                ((RelativeLayout) C2807a.this.f6287a.getParent()).setBackgroundColor(0);
                            }
                        }
                    }
                });
            } else {
                TapjoyLog.m6552e("TJAdUnitJSBridge", "Unable to present offerwall. No Activity context provided.");
            }
        }

        public C2807a(WebView webView) {
            this.f6287a = webView;
        }
    }

    public void destroy() {
    }

    public TJAdUnitJSBridge(Context context, TJAdUnit tJAdUnit) {
        this(context, (WebView) tJAdUnit.getWebView());
        this.f6237a = tJAdUnit;
    }

    public TJAdUnitJSBridge(Context context, WebView webView) {
        this.f6246j = null;
        this.didLaunchOtherActivity = false;
        this.allowRedirect = true;
        this.otherActivityCallbackID = null;
        this.customClose = false;
        this.closeRequested = false;
        this.splitWebViewCallbackID = null;
        this.f6248l = new C3013eq(this);
        this.f6239c = new ConcurrentLinkedQueue();
        String str = "TJAdUnitJSBridge";
        TapjoyLog.m6553i(str, "creating AdUnit/JS Bridge");
        this.f6242f = context;
        this.f6238b = webView;
        this.f6241e = this;
        WebView webView2 = this.f6238b;
        if (webView2 == null) {
            TapjoyLog.m6551e(str, new TapjoyErrorMessage(ErrorType.SDK_ERROR, "Cannot create AdUnitJSBridge -- webview is NULL"));
            return;
        }
        this.f6240d = new TJWebViewJSInterface(webView2, this);
        this.f6238b.addJavascriptInterface(this.f6240d, TJAdUnitConstants.JAVASCRIPT_INTERFACE_ID);
        setEnabled(true);
    }

    public void onDispatchMethod(String str, JSONObject jSONObject) {
        String str2 = "TJAdUnitJSBridge";
        if (this.f6247k) {
            String str3 = null;
            try {
                str3 = jSONObject.optString(String.CALLBACK_ID, null);
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                Method method = TJAdUnitJSBridge.class.getMethod(str, new Class[]{JSONObject.class, String.class});
                StringBuilder sb = new StringBuilder("Dispatching method: ");
                sb.append(method);
                sb.append(" with data=");
                sb.append(jSONObject2);
                sb.append("; callbackID=");
                sb.append(str3);
                TapjoyLog.m6550d(str2, sb.toString());
                method.invoke(this.f6241e, new Object[]{jSONObject2, str3});
            } catch (Exception e) {
                e.printStackTrace();
                invokeJSCallback(str3, Boolean.FALSE);
            }
        } else {
            StringBuilder sb2 = new StringBuilder("Bridge currently disabled. Adding ");
            sb2.append(str);
            sb2.append(" to message queue");
            TapjoyLog.m6550d(str2, sb2.toString());
            this.f6239c.add(new Pair(str, jSONObject));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void alert(org.json.JSONObject r9, final java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "alert_method: "
            r1.<init>(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "TJAdUnitJSBridge"
            com.tapjoy.TapjoyLog.m6550d(r2, r1)
            r1 = 1
            r3 = 0
            java.lang.String r4 = "title"
            java.lang.String r4 = r9.getString(r4)     // Catch:{ Exception -> 0x002c }
            java.lang.String r5 = "message"
            java.lang.String r0 = r9.getString(r5)     // Catch:{ Exception -> 0x002a }
            java.lang.String r5 = "buttons"
            org.json.JSONArray r9 = r9.getJSONArray(r5)     // Catch:{ Exception -> 0x002a }
            goto L_0x003b
        L_0x002a:
            r9 = move-exception
            goto L_0x002e
        L_0x002c:
            r9 = move-exception
            r4 = r0
        L_0x002e:
            java.lang.Object[] r5 = new java.lang.Object[r1]
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r5[r3] = r6
            r8.invokeJSCallback(r10, r5)
            r9.printStackTrace()
            r9 = 0
        L_0x003b:
            com.tapjoy.TJAdUnitActivity r5 = r8.f6243g
            if (r5 == 0) goto L_0x00ba
            int r2 = android.os.Build.VERSION.SDK_INT
            r6 = 21
            if (r2 < r6) goto L_0x005a
            android.app.AlertDialog$Builder r2 = new android.app.AlertDialog$Builder
            r6 = 16974394(0x103023a, float:2.4062497E-38)
            r2.<init>(r5, r6)
            android.app.AlertDialog$Builder r2 = r2.setTitle(r4)
            android.app.AlertDialog$Builder r0 = r2.setMessage(r0)
            android.app.AlertDialog r0 = r0.create()
            goto L_0x006b
        L_0x005a:
            android.app.AlertDialog$Builder r2 = new android.app.AlertDialog$Builder
            r2.<init>(r5)
            android.app.AlertDialog$Builder r2 = r2.setTitle(r4)
            android.app.AlertDialog$Builder r0 = r2.setMessage(r0)
            android.app.AlertDialog r0 = r0.create()
        L_0x006b:
            if (r9 == 0) goto L_0x00b0
            int r2 = r9.length()
            if (r2 != 0) goto L_0x0074
            goto L_0x00b0
        L_0x0074:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r4 = 0
        L_0x007a:
            int r5 = r9.length()
            if (r4 >= r5) goto L_0x00a6
            if (r4 == 0) goto L_0x0088
            if (r4 == r1) goto L_0x0086
            r5 = -1
            goto L_0x0089
        L_0x0086:
            r5 = -3
            goto L_0x0089
        L_0x0088:
            r5 = -2
        L_0x0089:
            java.lang.String r6 = r9.getString(r4)     // Catch:{ Exception -> 0x0091 }
            r2.add(r6)     // Catch:{ Exception -> 0x0091 }
            goto L_0x0095
        L_0x0091:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0095:
            java.lang.Object r6 = r2.get(r4)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            com.tapjoy.TJAdUnitJSBridge$1 r7 = new com.tapjoy.TJAdUnitJSBridge$1
            r7.<init>(r10)
            r0.setButton(r5, r6, r7)
            int r4 = r4 + 1
            goto L_0x007a
        L_0x00a6:
            r0.setCancelable(r3)
            r0.setCanceledOnTouchOutside(r3)
            r0.show()
            return
        L_0x00b0:
            java.lang.Object[] r9 = new java.lang.Object[r1]
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r9[r3] = r0
            r8.invokeJSCallback(r10, r9)
            return
        L_0x00ba:
            java.lang.String r9 = "Cannot alert -- TJAdUnitActivity is null"
            com.tapjoy.TapjoyLog.m6550d(r2, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TJAdUnitJSBridge.alert(org.json.JSONObject, java.lang.String):void");
    }

    public void closeRequested(Boolean bool) {
        TJSplitWebView tJSplitWebView = this.f6244h;
        if (tJSplitWebView == null) {
            this.closeRequested = true;
            HashMap hashMap = new HashMap();
            hashMap.put(String.FORCE_CLOSE, bool);
            invokeJSAdunitMethod(String.CLOSE_REQUESTED, (Map) hashMap);
        } else if (!tJSplitWebView.goBack()) {
            this.f6244h.mo29644a();
        }
    }

    public void getVolume(JSONObject jSONObject, String str) {
        HashMap volumeArgs = getVolumeArgs();
        if (volumeArgs != null) {
            invokeJSCallback(str, (Map) volumeArgs);
            return;
        }
        invokeJSCallback(str, Boolean.valueOf(false));
    }

    public void onVolumeChanged() {
        invokeJSAdunitMethod(String.VOLUME_CHANGED, (Map) getVolumeArgs());
    }

    public HashMap getVolumeArgs() {
        TJAdUnit tJAdUnit = this.f6237a;
        String str = "TJAdUnitJSBridge";
        if (tJAdUnit == null) {
            TapjoyLog.m6550d(str, "No ad unit provided");
            return null;
        }
        String format = String.format("%.2f", new Object[]{Float.valueOf(tJAdUnit.getVolume())});
        boolean isMuted = this.f6237a.isMuted();
        StringBuilder sb = new StringBuilder("getVolumeArgs: volume=");
        sb.append(format);
        sb.append("; isMuted=");
        sb.append(isMuted);
        TapjoyLog.m6550d(str, sb.toString());
        HashMap hashMap = new HashMap();
        hashMap.put(String.CURRENT_VOLUME, format);
        hashMap.put(String.IS_MUTED, Boolean.valueOf(isMuted));
        return hashMap;
    }

    public void dismiss(JSONObject jSONObject, String str) {
        TJAdUnitActivity tJAdUnitActivity = this.f6243g;
        if (tJAdUnitActivity != null) {
            invokeJSCallback(str, Boolean.valueOf(true));
            tJAdUnitActivity.finish();
            return;
        }
        TapjoyLog.m6550d("TJAdUnitJSBridge", "Cannot dismiss -- TJAdUnitActivity is null");
        invokeJSCallback(str, Boolean.valueOf(false));
    }

    public void display() {
        invokeJSAdunitMethod("display", new Object[0]);
    }

    public void displayStoreURL(JSONObject jSONObject, String str) {
        displayURL(jSONObject, str);
    }

    public void dismissStoreView(JSONObject jSONObject, String str) {
        dismissSplitView(jSONObject, str);
    }

    public void displayURL(JSONObject jSONObject, String str) {
        final String str2;
        final String str3;
        try {
            String optString = jSONObject.optString("style");
            final String string = jSONObject.getString("url");
            final JSONObject optJSONObject = jSONObject.optJSONObject(String.SPLIT_VIEW_LAYOUT);
            final JSONArray optJSONArray = jSONObject.optJSONArray(String.SPLIT_VIEW_EXIT_HOSTS);
            final String optString2 = jSONObject.optString(String.USER_AGENT, null);
            JSONObject optJSONObject2 = jSONObject.optJSONObject(String.SPLIT_VIEW_TRIGGER);
            if (optJSONObject2 != null) {
                String optString3 = optJSONObject2.optString(String.SPLIT_VIEW_TRIGGER_ON, null);
                str2 = optJSONObject2.optString("to", null);
                str3 = optString3;
            } else {
                str3 = null;
                str2 = null;
            }
            if (String.STYLE_SPLIT.equals(optString)) {
                final JSONObject jSONObject2 = jSONObject;
                final String str4 = str;
                C28036 r3 = new Runnable() {
                    public final void run() {
                        if (TJAdUnitJSBridge.this.f6238b != null) {
                            if (TJAdUnitJSBridge.this.f6244h == null) {
                                ViewParent parent = TJAdUnitJSBridge.this.f6238b.getParent();
                                if (parent instanceof ViewGroup) {
                                    ViewGroup viewGroup = (ViewGroup) parent;
                                    TJAdUnitJSBridge tJAdUnitJSBridge = TJAdUnitJSBridge.this;
                                    tJAdUnitJSBridge.f6244h = new TJSplitWebView(tJAdUnitJSBridge.f6243g, jSONObject2, TJAdUnitJSBridge.this);
                                    viewGroup.addView(TJAdUnitJSBridge.this.f6244h, new LayoutParams(-1, -1));
                                    TJAdUnitJSBridge.this.f6244h.animateOpen(viewGroup);
                                }
                            } else {
                                TJAdUnitJSBridge.this.f6244h.setExitHosts(optJSONArray);
                                TJAdUnitJSBridge.this.f6244h.applyLayoutOption(optJSONObject);
                            }
                            if (TJAdUnitJSBridge.this.f6244h != null) {
                                if (optString2 != null) {
                                    TJAdUnitJSBridge.this.f6244h.setUserAgent(optString2);
                                }
                                TJAdUnitJSBridge.this.f6244h.setTrigger(str3, str2);
                                TJAdUnitJSBridge tJAdUnitJSBridge2 = TJAdUnitJSBridge.this;
                                tJAdUnitJSBridge2.splitWebViewCallbackID = str4;
                                tJAdUnitJSBridge2.f6244h.loadUrl(string);
                                return;
                            }
                        }
                        TJAdUnitJSBridge.this.f6244h = null;
                        TJAdUnitJSBridge tJAdUnitJSBridge3 = TJAdUnitJSBridge.this;
                        tJAdUnitJSBridge3.splitWebViewCallbackID = null;
                        tJAdUnitJSBridge3.invokeJSCallback(str4, Boolean.FALSE);
                    }
                };
                TapjoyUtil.runOnMainThread(r3);
                return;
            }
            this.didLaunchOtherActivity = true;
            this.otherActivityCallbackID = str;
            this.f6242f.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(string)));
        } catch (Exception e) {
            invokeJSCallback(str, Boolean.TRUE);
            e.printStackTrace();
        }
    }

    public void clearCache(JSONObject jSONObject, String str) {
        if (TapjoyCache.getInstance() != null) {
            TapjoyCache.getInstance().clearTapjoyCache();
            invokeJSCallback(str, Boolean.TRUE);
            return;
        }
        invokeJSCallback(str, Boolean.FALSE);
    }

    public void setPrerenderLimit(JSONObject jSONObject, String str) {
        try {
            TJPlacementManager.setPreRenderedPlacementLimit(jSONObject.getInt(String.TJC_PLACEMENT_PRE_RENDERED_LIMIT));
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception unused) {
            TapjoyLog.m6555w("TJAdUnitJSBridge", "Unable to set Tapjoy placement pre-render limit. Invalid parameters.");
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void setEventPreloadLimit(JSONObject jSONObject, String str) {
        if (TapjoyCache.getInstance() != null) {
            try {
                TJPlacementManager.setCachedPlacementLimit(jSONObject.getInt(String.TJC_PLACEMENT_CACHE_LIMIT));
                invokeJSCallback(str, Boolean.TRUE);
            } catch (Exception unused) {
                TapjoyLog.m6555w("TJAdUnitJSBridge", "Unable to set Tapjoy cache's event preload limit. Invalid parameters.");
                invokeJSCallback(str, Boolean.FALSE);
            }
        } else {
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void removeAssetFromCache(JSONObject jSONObject, String str) {
        try {
            String string = jSONObject.getString("url");
            if (TapjoyCache.getInstance() != null) {
                invokeJSCallback(str, Boolean.valueOf(TapjoyCache.getInstance().removeAssetFromCache(string)));
                return;
            }
            invokeJSCallback(str, Boolean.FALSE);
        } catch (Exception unused) {
            TapjoyLog.m6555w("TJAdUnitJSBridge", "Unable to cache video. Invalid parameters.");
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void cacheAsset(JSONObject jSONObject, String str) {
        String str2;
        Long valueOf = Long.valueOf(0);
        try {
            String string = jSONObject.getString("url");
            try {
                str2 = jSONObject.getString(TapjoyConstants.TJC_PLACEMENT_OFFER_ID);
            } catch (Exception unused) {
                str2 = "";
            }
            try {
                valueOf = Long.valueOf(jSONObject.getLong(TapjoyConstants.TJC_TIME_TO_LIVE));
            } catch (Exception unused2) {
            }
            if (TapjoyCache.getInstance() != null) {
                invokeJSCallback(str, TapjoyCache.getInstance().cacheAssetFromURL(string, str2, valueOf.longValue()));
                return;
            }
            invokeJSCallback(str, Boolean.FALSE);
        } catch (Exception unused3) {
            TapjoyLog.m6555w("TJAdUnitJSBridge", "Unable to cache video. Invalid parameters.");
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void cachePathForURL(JSONObject jSONObject, String str) {
        String str2 = "";
        try {
            String string = jSONObject.getString("url");
            if (TapjoyCache.getInstance() != null) {
                invokeJSCallback(str, TapjoyCache.getInstance().getPathOfCachedURL(string));
                return;
            }
            invokeJSCallback(str, str2);
        } catch (Exception unused) {
            invokeJSCallback(str, str2);
        }
    }

    public void getCachedAssets(JSONObject jSONObject, String str) {
        if (TapjoyCache.getInstance() != null) {
            invokeJSCallback(str, TapjoyCache.getInstance().cachedAssetsToJSON());
            return;
        }
        invokeJSCallback(str, "");
    }

    public void contentReady(JSONObject jSONObject, String str) {
        TJAdUnit tJAdUnit = this.f6237a;
        if (tJAdUnit != null) {
            tJAdUnit.fireContentReady();
            invokeJSCallback(str, Boolean.valueOf(true));
            return;
        }
        invokeJSCallback(str, Boolean.valueOf(false));
    }

    public void getOrientation(JSONObject jSONObject, String str) {
        TJAdUnit tJAdUnit = this.f6237a;
        if (tJAdUnit == null) {
            TapjoyLog.m6550d("TJAdUnitJSBridge", "No ad unit provided");
            invokeJSCallback(str, JSONObject.NULL);
            return;
        }
        String screenOrientationString = tJAdUnit.getScreenOrientationString();
        HashMap hashMap = new HashMap();
        hashMap.put("orientation", screenOrientationString);
        hashMap.put("width", Integer.valueOf(this.f6237a.getScreenWidth()));
        hashMap.put("height", Integer.valueOf(this.f6237a.getScreenHeight()));
        invokeJSCallback(str, (Map) hashMap);
    }

    public void setOrientation(JSONObject jSONObject, String str) {
        int i;
        TJAdUnit tJAdUnit = this.f6237a;
        Boolean valueOf = Boolean.valueOf(false);
        if (tJAdUnit == null) {
            TapjoyLog.m6550d("TJAdUnitJSBridge", "No ad unit provided");
            invokeJSCallback(str, valueOf);
            return;
        }
        try {
            String string = jSONObject.getString("orientation");
            if (!string.equals(String.LANDSCAPE)) {
                if (!string.equals(String.LANDSCAPE_LEFT)) {
                    i = string.equals(String.LANDSCAPE_RIGHT) ? 8 : 1;
                    this.f6237a.setOrientation(i);
                    invokeJSCallback(str, Boolean.valueOf(true));
                }
            }
            i = 0;
            this.f6237a.setOrientation(i);
            invokeJSCallback(str, Boolean.valueOf(true));
        } catch (Exception unused) {
            invokeJSCallback(str, valueOf);
        }
    }

    public void unsetOrientation(JSONObject jSONObject, String str) {
        TJAdUnit tJAdUnit = this.f6237a;
        Boolean valueOf = Boolean.valueOf(false);
        if (tJAdUnit == null) {
            TapjoyLog.m6550d("TJAdUnitJSBridge", "No ad unit provided");
            invokeJSCallback(str, valueOf);
            return;
        }
        try {
            tJAdUnit.unsetOrientation();
            invokeJSCallback(str, Boolean.valueOf(true));
        } catch (Exception unused) {
            invokeJSCallback(str, valueOf);
        }
    }

    public void setBackgroundColor(JSONObject jSONObject, final String str) {
        try {
            String string = jSONObject.getString(String.BACKGROUND_COLOR);
            TJAdUnit tJAdUnit = this.f6237a;
            if (tJAdUnit != null) {
                tJAdUnit.setBackgroundColor(string, new AdUnitAsyncTaskListner() {
                    public final void onComplete(boolean z) {
                        TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.valueOf(z));
                    }
                });
                return;
            }
            invokeJSCallback(str, Boolean.valueOf(false));
        } catch (Exception unused) {
            TapjoyLog.m6555w("TJAdUnitJSBridge", "Unable to set background color. Invalid parameters.");
            invokeJSCallback(str, Boolean.valueOf(false));
        }
    }

    public void setBackgroundWebViewContent(JSONObject jSONObject, final String str) {
        String str2 = "TJAdUnitJSBridge";
        TapjoyLog.m6550d(str2, "setBackgroundWebViewContent");
        try {
            String string = jSONObject.getString(String.BACKGROUND_CONTENT);
            TJAdUnit tJAdUnit = this.f6237a;
            if (tJAdUnit != null) {
                tJAdUnit.setBackgroundContent(string, new AdUnitAsyncTaskListner() {
                    public final void onComplete(boolean z) {
                        TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.valueOf(z));
                    }
                });
                return;
            }
            invokeJSCallback(str, Boolean.valueOf(false));
        } catch (Exception unused) {
            TapjoyLog.m6555w(str2, "Unable to set background content. Invalid parameters.");
            invokeJSCallback(str, Boolean.valueOf(false));
        }
    }

    public void displayVideo(JSONObject jSONObject, final String str) {
        try {
            String string = jSONObject.getString("url");
            if (string.length() <= 0 || string == "") {
                invokeJSCallback(str, Boolean.FALSE);
                return;
            }
            this.f6237a.loadVideoUrl(string, new AdUnitAsyncTaskListner() {
                public final void onComplete(boolean z) {
                    TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.valueOf(z));
                }
            });
        } catch (Exception e) {
            invokeJSCallback(str, Boolean.FALSE);
            e.printStackTrace();
        }
    }

    public void playVideo(JSONObject jSONObject, String str) {
        TJAdUnit tJAdUnit = this.f6237a;
        if (tJAdUnit != null) {
            invokeJSCallback(str, Boolean.valueOf(tJAdUnit.playVideo()));
        }
    }

    public void pauseVideo(JSONObject jSONObject, String str) {
        TJAdUnit tJAdUnit = this.f6237a;
        if (tJAdUnit != null) {
            invokeJSCallback(str, Boolean.valueOf(tJAdUnit.pauseVideo()));
        }
    }

    public void clearVideo(JSONObject jSONObject, final String str) {
        if (this.f6237a != null) {
            this.f6237a.clearVideo(new AdUnitAsyncTaskListner() {
                public final void onComplete(boolean z) {
                    TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.valueOf(z));
                }
            }, jSONObject.optBoolean(String.VISIBLE, false));
        }
    }

    public void setVideoMute(JSONObject jSONObject, String str) {
        try {
            this.f6237a.mo17971a(jSONObject.getBoolean(String.ENABLED));
            invokeJSCallback(str, Boolean.TRUE);
        } catch (JSONException unused) {
            TapjoyLog.m6550d("TJAdUnitJSBridge", "Failed to parse 'enabled' from json params.");
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void setVideoMargins(JSONObject jSONObject, String str) {
        JSONObject jSONObject2 = jSONObject;
        String str2 = str;
        try {
            final float optDouble = (float) jSONObject.optDouble("top", 0.0d);
            final float optDouble2 = (float) jSONObject.optDouble(String.RIGHT, 0.0d);
            final float optDouble3 = (float) jSONObject.optDouble(String.BOTTOM, 0.0d);
            final float optDouble4 = (float) jSONObject.optDouble("left", 0.0d);
            final TJAdUnitActivity tJAdUnitActivity = this.f6243g;
            if (tJAdUnitActivity != null) {
                C279611 r1 = new Runnable() {
                    public final void run() {
                        TJAdUnitActivity tJAdUnitActivity = tJAdUnitActivity;
                        float f = optDouble4;
                        float f2 = optDouble;
                        float f3 = optDouble2;
                        float f4 = optDouble3;
                        DisplayMetrics displayMetrics = tJAdUnitActivity.getResources().getDisplayMetrics();
                        ViewGroup viewGroup = (ViewGroup) tJAdUnitActivity.f6225a.getVideoView().getParent();
                        ((MarginLayoutParams) viewGroup.getLayoutParams()).setMargins((int) TypedValue.applyDimension(1, f, displayMetrics), (int) TypedValue.applyDimension(1, f2, displayMetrics), (int) TypedValue.applyDimension(1, f3, displayMetrics), (int) TypedValue.applyDimension(1, f4, displayMetrics));
                        viewGroup.requestLayout();
                    }
                };
                TapjoyUtil.runOnMainThread(r1);
                invokeJSCallback(str2, Boolean.valueOf(true));
                return;
            }
            TapjoyLog.m6550d("TJAdUnitJSBridge", "Cannot setVideoMargins -- TJAdUnitActivity is null");
            invokeJSCallback(str2, Boolean.valueOf(false));
        } catch (Exception e) {
            invokeJSCallback(str2, Boolean.valueOf(false));
            e.printStackTrace();
        }
    }

    public void log(JSONObject jSONObject, String str) {
        String str2 = "TJAdUnitJSBridge";
        try {
            StringBuilder sb = new StringBuilder("Logging message=");
            sb.append(jSONObject.getString("message"));
            TapjoyLog.m6550d(str2, sb.toString());
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception e) {
            invokeJSCallback(str, Boolean.FALSE);
            e.printStackTrace();
        }
    }

    public void openApp(JSONObject jSONObject, String str) {
        try {
            this.f6242f.startActivity(this.f6242f.getPackageManager().getLaunchIntentForPackage(jSONObject.getString(String.BUNDLE)));
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception e) {
            invokeJSCallback(str, Boolean.FALSE);
            e.printStackTrace();
        }
    }

    @TargetApi(19)
    public void nativeEval(final JSONObject jSONObject, final String str) {
        TapjoyUtil.runOnMainThread(new Runnable() {
            public final void run() {
                try {
                    int i = VERSION.SDK_INT;
                    String str = String.COMMAND;
                    if (i >= 19) {
                        TJAdUnitJSBridge.this.f6238b.evaluateJavascript(jSONObject.getString(str), null);
                    } else {
                        WebView webView = TJAdUnitJSBridge.this.f6238b;
                        StringBuilder sb = new StringBuilder("javascript:");
                        sb.append(jSONObject.getString(str));
                        webView.loadUrl(sb.toString());
                    }
                    TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.TRUE);
                } catch (Exception unused) {
                    TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.FALSE);
                }
            }
        });
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|(2:4|5)|6|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void present(org.json.JSONObject r6, java.lang.String r7) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x0048 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r3 = "visible"
            java.lang.String r3 = r6.getString(r3)     // Catch:{ Exception -> 0x0048 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r4 = "transparent"
            java.lang.String r4 = r6.getString(r4)     // Catch:{ Exception -> 0x001d }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r4)     // Catch:{ Exception -> 0x001d }
        L_0x001d:
            java.lang.String r4 = "customClose"
            java.lang.String r6 = r6.getString(r4)     // Catch:{ Exception -> 0x002d }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ Exception -> 0x002d }
            boolean r6 = r6.booleanValue()     // Catch:{ Exception -> 0x002d }
            r5.customClose = r6     // Catch:{ Exception -> 0x002d }
        L_0x002d:
            com.tapjoy.TJAdUnitJSBridge$a r6 = new com.tapjoy.TJAdUnitJSBridge$a     // Catch:{ Exception -> 0x0048 }
            android.webkit.WebView r4 = r5.f6238b     // Catch:{ Exception -> 0x0048 }
            r6.<init>(r4)     // Catch:{ Exception -> 0x0048 }
            r4 = 2
            java.lang.Boolean[] r4 = new java.lang.Boolean[r4]     // Catch:{ Exception -> 0x0048 }
            r4[r1] = r3     // Catch:{ Exception -> 0x0048 }
            r4[r0] = r2     // Catch:{ Exception -> 0x0048 }
            r6.execute(r4)     // Catch:{ Exception -> 0x0048 }
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0048 }
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0048 }
            r6[r1] = r2     // Catch:{ Exception -> 0x0048 }
            r5.invokeJSCallback(r7, r6)     // Catch:{ Exception -> 0x0048 }
            return
        L_0x0048:
            r6 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r0[r1] = r2
            r5.invokeJSCallback(r7, r0)
            r6.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TJAdUnitJSBridge.present(org.json.JSONObject, java.lang.String):void");
    }

    public void triggerEvent(JSONObject jSONObject, String str) {
        if (this.f6237a != null) {
            try {
                String string = jSONObject.getString("eventName");
                if (string.equals(String.VIDEO_START)) {
                    this.f6237a.fireOnVideoStart();
                } else if (string.equals(String.VIDEO_COMPLETE)) {
                    this.f6237a.fireOnVideoComplete();
                } else if (string.equals("error")) {
                    this.f6237a.fireOnVideoError("Error while trying to play video.");
                } else if (string.equals(String.CLICK)) {
                    this.f6237a.fireOnClick();
                }
            } catch (Exception unused) {
                TapjoyLog.m6555w("TJAdUnitJSBridge", "Unable to triggerEvent. No event name.");
            }
        }
    }

    public void invokeJSAdunitMethod(String str, Object... objArr) {
        this.f6240d.callback(new ArrayList(Arrays.asList(objArr)), str, (String) null);
    }

    public void invokeJSAdunitMethod(String str, Map map) {
        this.f6240d.callback(map, str, (String) null);
    }

    public void invokeJSCallback(String str, Object... objArr) {
        if (C1852jq.m3669c(str)) {
            TapjoyLog.m6550d("TJAdUnitJSBridge", "invokeJSCallback -- no callbackID provided");
            return;
        }
        this.f6240d.callback(new ArrayList(Arrays.asList(objArr)), "", str);
    }

    public void invokeJSCallback(String str, Map map) {
        this.f6240d.callback(map, "", str);
    }

    public void flushBacklogMessageQueue() {
        while (true) {
            Pair pair = (Pair) this.f6239c.poll();
            if (pair != null) {
                onDispatchMethod((String) pair.first, (JSONObject) pair.second);
            } else {
                return;
            }
        }
    }

    public void flushMessageQueue() {
        this.f6240d.flushMessageQueue();
    }

    public void setAllowRedirect(JSONObject jSONObject, String str) {
        boolean z;
        try {
            z = jSONObject.getBoolean(String.ENABLED);
        } catch (Exception unused) {
            z = true;
        }
        this.allowRedirect = z;
        invokeJSCallback(str, Boolean.TRUE);
    }

    public void setAdUnitActivity(TJAdUnitActivity tJAdUnitActivity) {
        this.f6243g = tJAdUnitActivity;
    }

    public void setSpinnerVisible(JSONObject jSONObject, String str) {
        try {
            boolean z = jSONObject.getBoolean(String.VISIBLE);
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("message");
            TJAdUnitActivity tJAdUnitActivity = this.f6243g;
            if (tJAdUnitActivity != null) {
                if (z) {
                    this.f6245i = ProgressDialog.show(tJAdUnitActivity, optString, optString2);
                } else if (this.f6245i != null) {
                    this.f6245i.dismiss();
                }
                invokeJSCallback(str, Boolean.TRUE);
                return;
            }
            TapjoyLog.m6550d("TJAdUnitJSBridge", "Cannot setSpinnerVisible -- TJAdUnitActivity is null");
            invokeJSCallback(str, Boolean.FALSE);
        } catch (Exception e) {
            invokeJSCallback(str, Boolean.FALSE);
            e.printStackTrace();
        }
    }

    public void setCloseButtonVisible(JSONObject jSONObject, String str) {
        try {
            final boolean z = jSONObject.getBoolean(String.VISIBLE);
            TapjoyUtil.runOnMainThread(new Runnable() {
                public final void run() {
                    TJAdUnitActivity b = TJAdUnitJSBridge.this.f6243g;
                    if (b != null) {
                        b.setCloseButtonVisibility(z);
                    } else {
                        TapjoyLog.m6550d("TJAdUnitJSBridge", "Cannot setCloseButtonVisible -- TJAdUnitActivity is null");
                    }
                }
            });
            invokeJSCallback(str, Boolean.valueOf(true));
        } catch (Exception e) {
            invokeJSCallback(str, Boolean.valueOf(false));
            e.printStackTrace();
        }
    }

    public void setCloseButtonClickable(JSONObject jSONObject, String str) {
        try {
            final boolean optBoolean = jSONObject.optBoolean(String.CLICKABLE);
            TapjoyUtil.runOnMainThread(new Runnable() {
                public final void run() {
                    TJAdUnitActivity b = TJAdUnitJSBridge.this.f6243g;
                    if (b != null) {
                        b.setCloseButtonClickable(optBoolean);
                    } else {
                        TapjoyLog.m6550d("TJAdUnitJSBridge", "Cannot setCloseButtonClickable -- TJAdUnitActivity is null");
                    }
                }
            });
            invokeJSCallback(str, Boolean.valueOf(true));
        } catch (Exception e) {
            invokeJSCallback(str, Boolean.valueOf(false));
            e.printStackTrace();
        }
    }

    public void shouldClose(JSONObject jSONObject, String str) {
        TJAdUnitActivity tJAdUnitActivity = this.f6243g;
        try {
            Boolean.valueOf(false);
            if (Boolean.valueOf(jSONObject.getString(String.CLOSE)).booleanValue() && tJAdUnitActivity != null) {
                tJAdUnitActivity.finish();
            }
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception e) {
            invokeJSCallback(str, Boolean.FALSE);
            if (tJAdUnitActivity != null) {
                tJAdUnitActivity.finish();
            }
            e.printStackTrace();
        }
        this.closeRequested = false;
    }

    public void setLoggingLevel(JSONObject jSONObject, String str) {
        try {
            TapjoyAppSettings.getInstance().saveLoggingLevel(String.valueOf(jSONObject.getString(String.LOGGING_LEVEL)));
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("setLoggingLevel exception ");
            sb.append(e.getLocalizedMessage());
            TapjoyLog.m6550d("TJAdUnitJSBridge", sb.toString());
            invokeJSCallback(str, Boolean.valueOf(false));
            e.printStackTrace();
        }
    }

    public void clearLoggingLevel(JSONObject jSONObject, String str) {
        TapjoyAppSettings.getInstance().clearLoggingLevel();
    }

    public void attachVolumeListener(JSONObject jSONObject, String str) {
        String str2 = "TJAdUnitJSBridge";
        try {
            boolean z = jSONObject.getBoolean(String.ATTACH);
            int optInt = jSONObject.optInt(String.INTERVAL, TJAdUnitConstants.DEFAULT_VOLUME_CHECK_INTERVAL);
            if (optInt > 0) {
                this.f6237a.attachVolumeListener(z, optInt);
                invokeJSCallback(str, Boolean.valueOf(true));
                return;
            }
            StringBuilder sb = new StringBuilder("Invalid `interval` value passed to attachVolumeListener(): interval=");
            sb.append(optInt);
            TapjoyLog.m6550d(str2, sb.toString());
            invokeJSCallback(str, Boolean.valueOf(false));
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder("attachVolumeListener exception ");
            sb2.append(e.toString());
            TapjoyLog.m6550d(str2, sb2.toString());
            invokeJSCallback(str, Boolean.valueOf(false));
            e.printStackTrace();
        }
    }

    public void initMoatVideoTracker(JSONObject jSONObject, String str) {
        invokeJSCallback(str, Boolean.valueOf(true));
    }

    public void startMoatVideoTracker(JSONObject jSONObject, String str) {
        invokeJSCallback(str, Boolean.valueOf(true));
    }

    public void triggerMoatVideoEvent(JSONObject jSONObject, String str) {
        invokeJSCallback(str, Boolean.valueOf(true));
    }

    public void initViewabilityTracker(JSONObject jSONObject, String str) {
        C3013eq eqVar = this.f6248l;
        boolean a = eqVar.mo30018a(jSONObject);
        Boolean valueOf = Boolean.valueOf(false);
        if (!a) {
            eqVar.f6932a.invokeJSCallback(str, valueOf);
            return;
        }
        C3013eq.m6898b(jSONObject);
        if (C2874al.m6573a(C3013eq.f6931b)) {
            eqVar.f6932a.invokeJSCallback(str, valueOf);
            return;
        }
        TapjoyUtil.runOnMainThread(new Runnable(jSONObject, str) {

            /* renamed from: a */
            final /* synthetic */ JSONObject f6938a;

            /* renamed from: b */
            final /* synthetic */ String f6939b;

            {
                this.f6938a = r2;
                this.f6939b = r3;
            }

            public final void run() {
                String str = "TJOMViewabilityAgent";
                try {
                    if (!C3013eq.this.f6933c) {
                        C3013eq eqVar = C3013eq.this;
                        C2925ck.m6679a();
                        eqVar.f6933c = C2925ck.m6680a(C3013eq.this.f6932a.f6238b.getContext());
                    }
                    if (C3013eq.this.f6933c) {
                        TapjoyLog.m6550d(str, "initialized");
                        C2935cu a = C2935cu.m6692a(C3013eq.this.f6936f, C3013eq.f6931b, C3013eq.m6897b(this.f6938a.optJSONArray(String.VENDORS)), "");
                        C3013eq.this.f6935e = C2933cs.m6687a(C2934ct.m6691a(C2937cw.f6769a, C2937cw.f6769a), a);
                        C3013eq.this.f6935e.mo29922a(C3013eq.this.f6932a.f6237a.getWebView());
                        C3013eq.this.f6937g = C2943dc.m6704a(C3013eq.this.f6935e);
                        C3013eq.this.f6934d = C2932cr.m6685a(C3013eq.this.f6935e);
                        C3013eq.this.f6932a.invokeJSCallback(this.f6939b, Boolean.valueOf(true));
                        return;
                    }
                    TapjoyLog.m6550d(str, "Failed to initialize");
                    C3013eq.this.f6932a.invokeJSCallback(this.f6939b, Boolean.valueOf(false));
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder("Failed to init with exception: ");
                    sb.append(e.getMessage());
                    TapjoyLog.m6550d(str, sb.toString());
                    C3013eq.this.f6932a.invokeJSCallback(this.f6939b, Boolean.valueOf(false));
                }
            }
        });
    }

    public void startViewabilityTracker(JSONObject jSONObject, String str) {
        C3013eq eqVar = this.f6248l;
        if (!eqVar.f6933c) {
            TapjoyLog.m6550d("TJOMViewabilityAgent", "Can not start -- TJOMViewabilityAgent is not initialized");
            eqVar.f6932a.invokeJSCallback(str, Boolean.valueOf(false));
            return;
        }
        eqVar.f6932a.invokeJSCallback(str, Boolean.valueOf(true));
        TapjoyUtil.runOnMainThread(new Runnable() {
            public final void run() {
                try {
                    C3013eq.this.f6935e.mo29921a();
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder("Failed to start with exception: ");
                    sb.append(e.getMessage());
                    TapjoyLog.m6550d("TJOMViewabilityAgent", sb.toString());
                }
            }
        });
    }

    public void triggerViewabilityEvent(JSONObject jSONObject, String str) {
        C3013eq eqVar = this.f6248l;
        boolean z = eqVar.f6933c;
        String str2 = "TJOMViewabilityAgent";
        Boolean valueOf = Boolean.valueOf(false);
        if (!z) {
            TapjoyLog.m6550d(str2, "Can not triggerEvent -- TJOMViewabilityAgent is not initialized");
            eqVar.f6932a.invokeJSCallback(str, valueOf);
        } else if (jSONObject == null) {
            TapjoyLog.m6550d(str2, "Can not triggerEvent -- json parameter is null");
            eqVar.f6932a.invokeJSCallback(str, valueOf);
        } else {
            String optString = jSONObject.optString("eventName", null);
            if (optString == null) {
                TapjoyLog.m6550d(str2, "triggerEvent: params json did not contain 'eventName'");
                eqVar.f6932a.invokeJSCallback(str, valueOf);
                return;
            }
            TapjoyUtil.runOnMainThread(new Runnable(optString, str) {

                /* renamed from: a */
                final /* synthetic */ String f6942a;

                /* renamed from: b */
                final /* synthetic */ String f6943b;

                {
                    this.f6942a = r2;
                    this.f6943b = r3;
                }

                public final void run() {
                    String str = "TJOMViewabilityAgent";
                    try {
                        String str2 = "triggerEvent: event name '";
                        if (this.f6942a.equals(String.VIDEO_RENDERED)) {
                            C3013eq.this.f6937g.mo29933a(C2942db.m6702a(C2941da.f6791d));
                            C3013eq.this.f6934d.mo29920a();
                        } else if (this.f6942a.equals(String.VIDEO_BUFFER_START)) {
                            C3013eq.this.f6937g.mo29939g();
                        } else if (this.f6942a.equals(String.VIDEO_BUFFER_END)) {
                            C3013eq.this.f6937g.mo29940h();
                        } else if (this.f6942a.equals(String.VIDEO_START)) {
                            C3013eq.this.f6937g.mo29932a((float) C3013eq.this.f6932a.f6237a.getVideoView().getDuration(), C3013eq.this.f6932a.f6237a.getVolume());
                        } else if (this.f6942a.equals(String.VIDEO_FIRST_QUARTILE)) {
                            C3013eq.this.f6937g.mo29930a();
                        } else if (this.f6942a.equals(String.VIDEO_MIDPOINT)) {
                            C3013eq.this.f6937g.mo29934b();
                        } else if (this.f6942a.equals(String.VIDEO_THIRD_QUARTILE)) {
                            C3013eq.this.f6937g.mo29935c();
                        } else if (this.f6942a.equals(String.VIDEO_PAUSED)) {
                            C3013eq.this.f6937g.mo29937e();
                        } else if (this.f6942a.equals(String.VIDEO_PLAYING)) {
                            C3013eq.this.f6937g.mo29938f();
                        } else if (this.f6942a.equals(String.VIDEO_SKIPPED)) {
                            C3013eq.this.f6937g.mo29941i();
                        } else if (this.f6942a.equals(String.VOLUME_CHANGED)) {
                            C3013eq.this.f6937g.mo29931a(C3013eq.this.f6932a.f6237a.getVolume());
                        } else if (this.f6942a.equals(String.VIDEO_COMPLETE)) {
                            C3013eq.this.f6937g.mo29936d();
                            C3013eq.this.f6935e.mo29923b();
                            C3013eq.this.f6935e = null;
                        } else {
                            StringBuilder sb = new StringBuilder(str2);
                            sb.append(this.f6942a);
                            sb.append("' not found");
                            TapjoyLog.m6550d(str, sb.toString());
                            C3013eq.this.f6932a.invokeJSCallback(this.f6943b, Boolean.valueOf(false));
                            return;
                        }
                        StringBuilder sb2 = new StringBuilder(str2);
                        sb2.append(this.f6942a);
                        sb2.append("'");
                        TapjoyLog.m6550d(str, sb2.toString());
                        C3013eq.this.f6932a.invokeJSCallback(this.f6943b, Boolean.valueOf(true));
                    } catch (Exception e) {
                        StringBuilder sb3 = new StringBuilder("triggerEvent exception:");
                        sb3.append(e.getMessage());
                        TapjoyLog.m6550d(str, sb3.toString());
                        C3013eq.this.f6932a.invokeJSCallback(this.f6943b, Boolean.valueOf(false));
                    }
                }
            });
        }
    }

    public void startUsageTrackingEvent(JSONObject jSONObject, String str) {
        String str2 = "TJAdUnitJSBridge";
        try {
            String string = jSONObject.getString("name");
            if (string.isEmpty()) {
                TapjoyLog.m6550d(str2, "Empty name for startUsageTrackingEvent");
                invokeJSCallback(str, Boolean.valueOf(false));
                return;
            }
            if (this.f6237a != null) {
                this.f6237a.startAdContentTracking(string, jSONObject);
                invokeJSCallback(str, Boolean.valueOf(true));
                return;
            }
            invokeJSCallback(str, Boolean.valueOf(false));
        } catch (JSONException e) {
            StringBuilder sb = new StringBuilder("Unable to startUsageTrackingEvent. Invalid parameters: ");
            sb.append(e);
            TapjoyLog.m6555w(str2, sb.toString());
        }
    }

    public void endUsageTrackingEvent(JSONObject jSONObject, String str) {
        String str2 = "TJAdUnitJSBridge";
        try {
            String string = jSONObject.getString("name");
            if (string.isEmpty()) {
                TapjoyLog.m6550d(str2, "Empty name for endUsageTrackingEvent");
                invokeJSCallback(str, Boolean.valueOf(false));
                return;
            }
            if (this.f6237a != null) {
                this.f6237a.endAdContentTracking(string, jSONObject);
                invokeJSCallback(str, Boolean.valueOf(true));
                return;
            }
            invokeJSCallback(str, Boolean.valueOf(false));
        } catch (JSONException e) {
            StringBuilder sb = new StringBuilder("Unable to endUsageTrackingEvent. Invalid parameters: ");
            sb.append(e);
            TapjoyLog.m6555w(str2, sb.toString());
        }
    }

    public void sendUsageTrackingEvent(JSONObject jSONObject, String str) {
        String str2 = "TJAdUnitJSBridge";
        try {
            String string = jSONObject.getString("name");
            if (string.isEmpty()) {
                TapjoyLog.m6550d(str2, "Empty name for sendUsageTrackingEvent");
                invokeJSCallback(str, Boolean.valueOf(false));
                return;
            }
            if (this.f6237a != null) {
                this.f6237a.sendAdContentTracking(string, jSONObject);
                invokeJSCallback(str, Boolean.valueOf(true));
                return;
            }
            invokeJSCallback(str, Boolean.valueOf(false));
        } catch (JSONException e) {
            StringBuilder sb = new StringBuilder("Unable to sendUsageTrackingEvent. Invalid parameters: ");
            sb.append(e);
            TapjoyLog.m6555w(str2, sb.toString());
        }
    }

    public void hasSplitView(JSONObject jSONObject, final String str) {
        TapjoyUtil.runOnMainThread(new Runnable() {
            public final void run() {
                if (TJAdUnitJSBridge.this.f6244h != null) {
                    TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.TRUE);
                    return;
                }
                TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.FALSE);
            }
        });
    }

    public void dismissSplitView(JSONObject jSONObject, final String str) {
        TapjoyUtil.runOnMainThread(new Runnable() {
            public final void run() {
                if (TJAdUnitJSBridge.this.f6244h != null) {
                    String str = str;
                    if (str != null) {
                        TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.TRUE);
                    }
                    if (TJAdUnitJSBridge.this.splitWebViewCallbackID != null) {
                        TJAdUnitJSBridge tJAdUnitJSBridge = TJAdUnitJSBridge.this;
                        tJAdUnitJSBridge.invokeJSCallback(tJAdUnitJSBridge.splitWebViewCallbackID, Boolean.TRUE);
                        TJAdUnitJSBridge.this.splitWebViewCallbackID = null;
                    }
                    ((ViewGroup) TJAdUnitJSBridge.this.f6244h.getParent()).removeView(TJAdUnitJSBridge.this.f6244h);
                    TJAdUnitJSBridge.this.f6244h = null;
                    return;
                }
                String str2 = str;
                if (str2 != null) {
                    TJAdUnitJSBridge.this.invokeJSCallback(str2, Boolean.FALSE);
                }
            }
        });
    }

    public void getSplitViewURL(JSONObject jSONObject, final String str) {
        TapjoyUtil.runOnMainThread(new Runnable() {
            public final void run() {
                if (TJAdUnitJSBridge.this.f6244h != null) {
                    TJAdUnitJSBridge tJAdUnitJSBridge = TJAdUnitJSBridge.this;
                    tJAdUnitJSBridge.invokeJSCallback(str, tJAdUnitJSBridge.f6244h.getLastUrl());
                    return;
                }
                TJAdUnitJSBridge.this.invokeJSCallback(str, JSONObject.NULL);
            }
        });
    }

    public void isNetworkAvailable(JSONObject jSONObject, String str) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f6242f.getSystemService("connectivity")).getActiveNetworkInfo();
            invokeJSCallback(str, Boolean.valueOf(activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()));
        } catch (Exception unused) {
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void setEnabled(boolean z) {
        this.f6247k = z;
        if (this.f6247k) {
            flushBacklogMessageQueue();
        }
    }

    public void onVideoReady(int i, int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put(String.VIDEO_EVENT_NAME, String.VIDEO_READY_EVENT);
        hashMap.put(String.VIDEO_DURATION, Integer.valueOf(i));
        hashMap.put(String.VIDEO_WIDTH, Integer.valueOf(i2));
        hashMap.put(String.VIDEO_HEIGHT, Integer.valueOf(i3));
        invokeJSAdunitMethod(String.VIDEO_EVENT, (Map) hashMap);
    }

    public void onVideoStarted(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(String.VIDEO_EVENT_NAME, String.VIDEO_START_EVENT);
        hashMap.put(String.VIDEO_CURRENT_TIME, Integer.valueOf(i));
        invokeJSAdunitMethod(String.VIDEO_EVENT, (Map) hashMap);
    }

    public void onVideoProgress(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(String.VIDEO_EVENT_NAME, String.VIDEO_PROGRESS_EVENT);
        hashMap.put(String.VIDEO_CURRENT_TIME, Integer.valueOf(i));
        invokeJSAdunitMethod(String.VIDEO_EVENT, (Map) hashMap);
    }

    public void onVideoPaused(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(String.VIDEO_EVENT_NAME, String.VIDEO_PAUSE_EVENT);
        hashMap.put(String.VIDEO_CURRENT_TIME, Integer.valueOf(i));
        invokeJSAdunitMethod(String.VIDEO_EVENT, (Map) hashMap);
    }

    public void onVideoCompletion() {
        HashMap hashMap = new HashMap();
        hashMap.put(String.VIDEO_EVENT_NAME, String.VIDEO_COMPLETE_EVENT);
        invokeJSAdunitMethod(String.VIDEO_EVENT, (Map) hashMap);
    }

    public void onVideoInfo(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(String.VIDEO_EVENT_NAME, String.VIDEO_INFO_EVENT);
        hashMap.put(String.VIDEO_INFO, str);
        invokeJSAdunitMethod(String.VIDEO_EVENT, (Map) hashMap);
    }

    public void onVideoError(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(String.VIDEO_EVENT_NAME, String.VIDEO_ERROR_EVENT);
        hashMap.put("error", str);
        invokeJSAdunitMethod(String.VIDEO_EVENT, (Map) hashMap);
    }

    public void notifyOrientationChanged(String str, int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("orientation", str);
        hashMap.put("width", Integer.valueOf(i));
        hashMap.put("height", Integer.valueOf(i2));
        invokeJSAdunitMethod(String.ORIENTATION_CHANGED_EVENT, (Map) hashMap);
    }
}
