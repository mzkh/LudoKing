package com.tapjoy.internal;

import android.os.Build;
import android.os.Build.VERSION;
import android.webkit.WebView;
import com.tapjoy.TapjoyConstants;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.ds */
public abstract class C2964ds {

    /* renamed from: a */
    public C2963dr f6830a = new C2963dr(null);

    /* renamed from: b */
    public C2932cr f6831b;

    /* renamed from: c */
    public C2943dc f6832c;

    /* renamed from: d */
    public int f6833d;

    /* renamed from: e */
    public long f6834e;

    /* renamed from: com.tapjoy.internal.ds$a */
    public enum C2965a {
        ;
        

        /* renamed from: a */
        public static final int f6835a = 1;

        /* renamed from: b */
        public static final int f6836b = 2;

        /* renamed from: c */
        public static final int f6837c = 3;

        static {
            f6838d = new int[]{f6835a, f6836b, f6837c};
        }
    }

    public C2964ds() {
        mo29962d();
    }

    /* renamed from: a */
    public void mo29954a() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo29956a(WebView webView) {
        this.f6830a = new C2963dr(webView);
    }

    /* renamed from: a */
    public final void mo29958a(String str) {
        C2949dg.m6726a().mo29947a(mo29961c(), str, (JSONObject) null);
    }

    /* renamed from: a */
    public final void mo29959a(String str, JSONObject jSONObject) {
        C2949dg.m6726a().mo29947a(mo29961c(), str, jSONObject);
    }

    /* renamed from: b */
    public void mo29960b() {
        this.f6830a.clear();
    }

    /* renamed from: c */
    public final WebView mo29961c() {
        return (WebView) this.f6830a.get();
    }

    /* renamed from: a */
    public final void mo29957a(C2940cz czVar, C2935cu cuVar) {
        String str = czVar.f6784f;
        JSONObject jSONObject = new JSONObject();
        String str2 = TapjoyConstants.TJC_APP_PLACEMENT;
        C2957dm.m6746a(jSONObject, "environment", str2);
        C2957dm.m6746a(jSONObject, "adSessionType", cuVar.f6764f);
        JSONObject jSONObject2 = new JSONObject();
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER);
        sb.append("; ");
        sb.append(Build.MODEL);
        C2957dm.m6746a(jSONObject2, "deviceType", sb.toString());
        C2957dm.m6746a(jSONObject2, "osVersion", Integer.toString(VERSION.SDK_INT));
        C2957dm.m6746a(jSONObject2, "os", "Android");
        C2957dm.m6746a(jSONObject, "deviceInfo", jSONObject2);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        C2957dm.m6746a(jSONObject, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        C2957dm.m6746a(jSONObject3, "partnerName", cuVar.f6759a.f6774a);
        C2957dm.m6746a(jSONObject3, "partnerVersion", cuVar.f6759a.f6775b);
        C2957dm.m6746a(jSONObject, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        C2957dm.m6746a(jSONObject4, "libraryVersion", "1.2.19-Tapjoy");
        C2957dm.m6746a(jSONObject4, "appId", C2948df.m6725a().f6810a.getApplicationContext().getPackageName());
        C2957dm.m6746a(jSONObject, str2, jSONObject4);
        if (cuVar.f6763e != null) {
            C2957dm.m6746a(jSONObject, "customReferenceData", cuVar.f6763e);
        }
        JSONObject jSONObject5 = new JSONObject();
        for (C2939cy cyVar : Collections.unmodifiableList(cuVar.f6761c)) {
            C2957dm.m6746a(jSONObject5, cyVar.f6776a, cyVar.f6778c);
        }
        C2949dg.m6726a().mo29948a(mo29961c(), "startSession", str, jSONObject, jSONObject5);
    }

    /* renamed from: a */
    public final void mo29955a(float f) {
        C2949dg.m6726a().mo29948a(mo29961c(), "setDeviceVolume", Float.valueOf(f));
    }

    /* renamed from: d */
    public final void mo29962d() {
        this.f6834e = System.nanoTime();
        this.f6833d = C2965a.f6835a;
    }
}
