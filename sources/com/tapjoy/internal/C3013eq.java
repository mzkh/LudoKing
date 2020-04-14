package com.tapjoy.internal;

import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.TJAdUnitJSBridge;
import com.tapjoy.Tapjoy;
import com.tapjoy.TapjoyCache;
import com.tapjoy.TapjoyCachedAssetData;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyUtil;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.eq */
public final class C3013eq {

    /* renamed from: b */
    public static String f6931b = "";

    /* renamed from: a */
    public TJAdUnitJSBridge f6932a;

    /* renamed from: c */
    public boolean f6933c = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C2932cr f6934d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C2933cs f6935e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C2938cx f6936f = C2938cx.m6693a("Tapjoy", Tapjoy.getVersion());
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C2943dc f6937g;

    public C3013eq(TJAdUnitJSBridge tJAdUnitJSBridge) {
        this.f6932a = tJAdUnitJSBridge;
    }

    /* renamed from: a */
    public final boolean mo30018a(JSONObject jSONObject) {
        String str = "TJOMViewabilityAgent";
        if (this.f6932a.f6238b == null) {
            TapjoyLog.m6550d(str, "Can not init -- WebView is null");
            return false;
        } else if (this.f6932a.f6237a == null) {
            TapjoyLog.m6550d(str, "Can not init -- TJAdUnit is null");
            return false;
        } else if (this.f6932a.f6237a.getVideoView() == null) {
            TapjoyLog.m6550d(str, "Can not init -- VideoView is null");
            return false;
        } else if (jSONObject == null) {
            TapjoyLog.m6550d(str, "Can not init -- json parameter is null");
            return false;
        } else if (!jSONObject.has(String.OM_JAVASCRIPT_URL)) {
            TapjoyLog.m6550d(str, "Can not init -- unable to parse om javascript url from json");
            return false;
        } else {
            try {
                jSONObject.getJSONArray(String.VENDORS);
                return true;
            } catch (JSONException unused) {
                TapjoyLog.m6550d(str, "Can not init -- unable to parse vendors from json");
                return false;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static List m6897b(JSONArray jSONArray) {
        C2939cy cyVar;
        String str = "TJOMViewabilityAgent";
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String optString = jSONObject.optString(String.VENDOR_JS_URL, null);
                if (optString == null) {
                    TapjoyLog.m6550d(str, "Vendor JS URL not found. Skipping.");
                } else {
                    try {
                        URL url = new URL(optString);
                        String optString2 = jSONObject.optString(String.VENDOR_NAME, null);
                        String optString3 = jSONObject.optString(String.VENDOR_PARAMETERS, null);
                        if (optString3 == null || optString2 == null) {
                            cyVar = C2939cy.m6695a(url);
                        } else {
                            cyVar = C2939cy.m6694a(optString2, url, optString3);
                        }
                        arrayList.add(cyVar);
                    } catch (Exception unused) {
                        StringBuilder sb = new StringBuilder("Malformed vendor JS URL. Skipping ");
                        sb.append(optString);
                        TapjoyLog.m6550d(str, sb.toString());
                    }
                }
            } catch (JSONException unused2) {
                TapjoyLog.m6550d(str, "Malformed vendor object. Skipping.");
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static void m6898b(JSONObject jSONObject) {
        if (C2874al.m6573a(f6931b)) {
            String optString = jSONObject.optString(String.OM_JAVASCRIPT_URL, null);
            String str = "TJOMViewabilityAgent";
            if (optString == null) {
                TapjoyLog.m6550d(str, "Open Mediation JavaScript name not found in json.");
                return;
            }
            try {
                TapjoyCachedAssetData cachedDataForURL = TapjoyCache.getInstance().getCachedDataForURL(optString);
                String str2 = "";
                if (cachedDataForURL == null) {
                    TapjoyCache.getInstance().cacheAssetFromURL(optString, str2, 30).get();
                    cachedDataForURL = TapjoyCache.getInstance().getCachedDataForURL(optString);
                }
                if (cachedDataForURL != null) {
                    str2 = TapjoyUtil.getFileContents(new File(cachedDataForURL.getLocalFilePath()));
                }
                f6931b = str2;
            } catch (Exception unused) {
                TapjoyLog.m6550d(str, "Failed downloading Open Mediation JavaScript");
            }
        }
    }
}
