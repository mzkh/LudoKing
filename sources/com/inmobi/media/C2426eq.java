package com.inmobi.media;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.inmobi.media.C2591hu.C2593b;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import com.unity3d.ads.BuildConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.eq */
/* compiled from: AdConfig */
public final class C2426eq extends C2436er {

    /* renamed from: o */
    private static final String f5172o = "eq";

    /* renamed from: p */
    private static final Object f5173p = new Object();

    /* renamed from: a */
    public String f5174a = "https://ads.inmobi.com/sdk";

    /* renamed from: b */
    public int f5175b = 20;

    /* renamed from: c */
    public int f5176c = 60;

    /* renamed from: d */
    public int f5177d = 60;

    /* renamed from: e */
    public boolean f5178e = true;

    /* renamed from: f */
    public C2430d f5179f = new C2430d();

    /* renamed from: g */
    public C2433g f5180g = new C2433g();

    /* renamed from: h */
    public C2431e f5181h = new C2431e();

    /* renamed from: i */
    public C2435i f5182i = new C2435i();

    /* renamed from: j */
    public C2434h f5183j = new C2434h();

    /* renamed from: k */
    public C2427a f5184k = new C2427a();

    /* renamed from: l */
    public C2591hu f5185l = C2591hu.m5639b().mo28610a();

    /* renamed from: q */
    private C2429c f5186q;

    /* renamed from: r */
    private Map<String, C2429c> f5187r;

    /* renamed from: com.inmobi.media.eq$a */
    /* compiled from: AdConfig */
    public static final class C2427a {

        /* renamed from: a */
        public int f5188a = 3;

        /* renamed from: b */
        public int f5189b = 1;

        /* renamed from: c */
        int f5190c = 10;

        /* renamed from: d */
        public long f5191d = 104857600;

        /* renamed from: e */
        public long f5192e = 259200;
    }

    /* renamed from: com.inmobi.media.eq$b */
    /* compiled from: AdConfig */
    public static final class C2428b {

        /* renamed from: a */
        public boolean f5193a = false;

        /* renamed from: b */
        public int f5194b = 2000;
    }

    /* renamed from: com.inmobi.media.eq$c */
    /* compiled from: AdConfig */
    public static final class C2429c {

        /* renamed from: a */
        public long f5195a;

        /* renamed from: a */
        public final boolean mo28344a() {
            return this.f5195a >= 0;
        }
    }

    /* renamed from: com.inmobi.media.eq$d */
    /* compiled from: AdConfig */
    public static final class C2430d {

        /* renamed from: a */
        public int f5196a = 3;

        /* renamed from: b */
        public int f5197b = 60;

        /* renamed from: c */
        public int f5198c = 120;

        /* renamed from: d */
        public int f5199d = TJAdUnitConstants.DEFAULT_VOLUME_CHECK_INTERVAL;

        /* renamed from: e */
        public int f5200e = 10;

        /* renamed from: f */
        public long f5201f = 10800;
    }

    /* renamed from: com.inmobi.media.eq$e */
    /* compiled from: AdConfig */
    public static final class C2431e {

        /* renamed from: a */
        public long f5202a = 432000;

        /* renamed from: b */
        public int f5203b = 3;

        /* renamed from: c */
        public int f5204c = 60;

        /* renamed from: d */
        public String f5205d = "https://i.l.inmobicdn.net/sdk/sdk/500/android/mraid.js";
    }

    /* renamed from: com.inmobi.media.eq$f */
    /* compiled from: AdConfig */
    public static final class C2432f {

        /* renamed from: a */
        public long f5206a = 432000;

        /* renamed from: b */
        public int f5207b = 3;

        /* renamed from: c */
        public int f5208c = 60;

        /* renamed from: d */
        public String f5209d = "Inmobi";

        /* renamed from: e */
        public String f5210e = "https://i.l.inmobicdn.net/sdk/sdk/OMID/omsdk-v1.js";

        /* renamed from: f */
        public boolean f5211f = true;

        /* renamed from: g */
        public long f5212g = 1000;
    }

    /* renamed from: com.inmobi.media.eq$g */
    /* compiled from: AdConfig */
    public static final class C2433g {

        /* renamed from: a */
        int f5213a = 320;

        /* renamed from: b */
        int f5214b = 480;

        /* renamed from: c */
        int f5215c = 100;

        /* renamed from: d */
        String f5216d;

        /* renamed from: e */
        public int f5217e;

        /* renamed from: f */
        public boolean f5218f;

        /* renamed from: g */
        int f5219g;

        /* renamed from: h */
        int f5220h;

        /* renamed from: i */
        long f5221i;

        /* renamed from: j */
        long f5222j;

        /* renamed from: k */
        ArrayList<String> f5223k;

        /* renamed from: l */
        public boolean f5224l;

        /* renamed from: m */
        public boolean f5225m;

        public C2433g() {
            String str = "#00000000";
            this.f5216d = str;
            this.f5217e = Color.parseColor(str);
            this.f5218f = true;
            this.f5219g = 5;
            this.f5220h = 20;
            this.f5221i = 5;
            this.f5222j = 5242880;
            this.f5223k = new ArrayList<>(Arrays.asList(new String[]{"video/mp4"}));
            this.f5224l = false;
            this.f5225m = false;
        }
    }

    /* renamed from: com.inmobi.media.eq$h */
    /* compiled from: AdConfig */
    public static final class C2434h {

        /* renamed from: a */
        public int f5226a = 3;

        /* renamed from: b */
        public long f5227b = 3145728;

        /* renamed from: c */
        public long f5228c = 31457280;

        /* renamed from: d */
        public C2428b f5229d = new C2428b();

        /* renamed from: e */
        public ArrayList<String> f5230e = new ArrayList<>(Arrays.asList(new String[]{"video/mp4", "image/jpeg", "image/jpg", "image/gif", "image/png"}));
    }

    /* renamed from: com.inmobi.media.eq$i */
    /* compiled from: AdConfig */
    public static final class C2435i {

        /* renamed from: a */
        public int f5231a = 50;

        /* renamed from: b */
        public int f5232b = 1000;

        /* renamed from: c */
        public int f5233c = 100;

        /* renamed from: d */
        public int f5234d = Callback.DEFAULT_SWIPE_ANIMATION_DURATION;

        /* renamed from: e */
        public int f5235e = 67;

        /* renamed from: f */
        public int f5236f = 50;

        /* renamed from: g */
        public int f5237g = 2000;

        /* renamed from: h */
        public int f5238h = 50;

        /* renamed from: i */
        public int f5239i = 50;

        /* renamed from: j */
        public int f5240j = 1000;

        /* renamed from: k */
        public boolean f5241k = true;

        /* renamed from: l */
        public C2432f f5242l = new C2432f();
    }

    /* renamed from: a */
    public final String mo28340a() {
        return "ads";
    }

    C2426eq(@Nullable String str) {
        String str2 = TapjoyConstants.TJC_TIME_TO_LIVE;
        super(str);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str2, BuildConfig.VERSION_CODE);
            jSONObject.put("base", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(str2, BuildConfig.VERSION_CODE);
            jSONObject.put("banner", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(str2, BuildConfig.VERSION_CODE);
            jSONObject.put("int", jSONObject4);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(str2, BuildConfig.VERSION_CODE);
            jSONObject.put("native", jSONObject5);
            m5074b(jSONObject);
        } catch (JSONException unused) {
        }
    }

    /* renamed from: a */
    public final void mo28341a(JSONObject jSONObject) throws JSONException {
        super.mo28341a(jSONObject);
        if (jSONObject.has("url")) {
            this.f5174a = jSONObject.getString("url");
        }
        if (jSONObject.has("cctEnabled")) {
            this.f5178e = jSONObject.getBoolean("cctEnabled");
        }
        this.f5175b = jSONObject.getInt("minimumRefreshInterval");
        this.f5176c = jSONObject.getInt("defaultRefreshInterval");
        this.f5177d = jSONObject.getInt("fetchTimeout");
        m5074b(jSONObject.getJSONObject("cache"));
        JSONObject jSONObject2 = jSONObject.getJSONObject("imai");
        this.f5179f.f5196a = jSONObject2.getInt("maxRetries");
        this.f5179f.f5197b = jSONObject2.getInt("pingInterval");
        this.f5179f.f5198c = jSONObject2.getInt("pingTimeout");
        this.f5179f.f5199d = jSONObject2.getInt("maxDbEvents");
        this.f5179f.f5200e = jSONObject2.getInt("maxEventBatch");
        this.f5179f.f5201f = jSONObject2.getLong("pingCacheExpiry");
        JSONObject jSONObject3 = jSONObject.getJSONObject("timeouts");
        C2593b b = C2591hu.m5639b();
        int i = jSONObject3.getInt(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        if (i <= 0) {
            i = 6300;
        }
        b.f5740g = i;
        int i2 = jSONObject3.getInt("bitmap");
        if (i2 <= 0) {
            i2 = 5000;
        }
        b.f5734a = i2;
        int i3 = jSONObject3.getInt("step1a");
        if (i3 <= 0) {
            i3 = 15000;
        }
        b.f5735b = i3;
        int i4 = jSONObject3.getInt("step1b");
        if (i4 <= 0) {
            i4 = 15000;
        }
        b.f5736c = i4;
        int i5 = jSONObject3.getInt("step2u");
        if (i5 <= 0) {
            i5 = 15000;
        }
        b.f5737d = i5;
        int i6 = jSONObject3.getInt("step3r");
        if (i6 <= 0) {
            i6 = 15000;
        }
        b.f5738e = i6;
        int i7 = jSONObject3.getInt("step4s");
        if (i7 <= 0) {
            i7 = 15000;
        }
        b.f5739f = i7;
        int i8 = jSONObject3.getInt("renderTimeout");
        if (i8 <= 0) {
            i8 = 15000;
        }
        b.f5741h = i8;
        this.f5185l = b.mo28610a();
        JSONObject jSONObject4 = jSONObject.getJSONObject("rendering");
        this.f5180g.f5214b = jSONObject4.getInt("picHeight");
        this.f5180g.f5213a = jSONObject4.getInt("picWidth");
        this.f5180g.f5215c = jSONObject4.getInt("picQuality");
        this.f5180g.f5216d = jSONObject4.getString("webviewBackground");
        this.f5180g.f5218f = jSONObject4.getBoolean("autoRedirectionEnforcement");
        this.f5180g.f5219g = jSONObject4.getInt("maxVibrationDuration");
        this.f5180g.f5220h = jSONObject4.getInt("maxVibrationPatternLength");
        this.f5180g.f5221i = (long) jSONObject4.getInt("delayedRedirection");
        this.f5180g.f5225m = jSONObject4.optBoolean("enablePubMuteControl", false);
        this.f5180g.f5222j = (long) jSONObject4.getJSONObject("savecontent").getInt("maxSaveSize");
        synchronized (f5173p) {
            this.f5180g.f5223k.clear();
            JSONArray jSONArray = jSONObject4.getJSONObject("savecontent").getJSONArray("allowedContentType");
            for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                this.f5180g.f5223k.add(jSONArray.getString(i9));
            }
        }
        this.f5180g.f5224l = jSONObject4.getBoolean("shouldRenderPopup");
        JSONObject jSONObject5 = jSONObject.getJSONObject("mraid");
        this.f5181h.f5202a = jSONObject5.getLong("expiry");
        this.f5181h.f5203b = jSONObject5.getInt("maxRetries");
        this.f5181h.f5204c = jSONObject5.getInt("retryInterval");
        this.f5181h.f5205d = jSONObject5.getString("url");
        JSONObject jSONObject6 = jSONObject.getJSONObject("viewability");
        this.f5182i.f5231a = jSONObject6.getInt("impressionMinPercentageViewed");
        this.f5182i.f5232b = jSONObject6.getInt("impressionMinTimeViewed");
        this.f5182i.f5235e = jSONObject6.optInt("displayMinPercentageAnimate", 67);
        this.f5182i.f5233c = jSONObject6.optInt("visibilityThrottleMillis", 100);
        this.f5182i.f5234d = jSONObject6.optInt("impressionPollIntervalMillis", Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        this.f5182i.f5241k = jSONObject6.optBoolean("moatEnabled", false);
        JSONObject jSONObject7 = jSONObject6.getJSONObject("omidConfig");
        C2432f fVar = this.f5182i.f5242l;
        fVar.f5206a = jSONObject7.getLong("expiry");
        fVar.f5209d = jSONObject7.getString("partnerKey");
        fVar.f5207b = jSONObject7.getInt("maxRetries");
        fVar.f5208c = jSONObject7.getInt("retryInterval");
        fVar.f5210e = jSONObject7.getString("url");
        fVar.f5211f = jSONObject7.optBoolean("omidEnabled", false);
        fVar.f5212g = jSONObject7.getLong("webViewRetainTime");
        JSONObject optJSONObject = jSONObject6.optJSONObject(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB);
        if (optJSONObject != null) {
            this.f5182i.f5239i = optJSONObject.getInt("impressionMinPercentageViewed");
            this.f5182i.f5240j = optJSONObject.getInt("impressionPollIntervalMillis");
        }
        JSONObject jSONObject8 = jSONObject6.getJSONObject("video");
        this.f5182i.f5236f = jSONObject8.getInt("impressionMinPercentageViewed");
        this.f5182i.f5237g = jSONObject8.getInt("impressionMinTimeViewed");
        this.f5182i.f5238h = jSONObject8.optInt("videoMinPercentagePlay", 50);
        JSONObject jSONObject9 = jSONObject.getJSONObject("vastVideo");
        this.f5183j.f5226a = jSONObject9.getInt("maxWrapperLimit");
        this.f5183j.f5227b = jSONObject9.getLong("optimalVastVideoSize");
        this.f5183j.f5228c = jSONObject9.getLong("vastMaxAssetSize");
        synchronized (f5173p) {
            this.f5183j.f5230e.clear();
            JSONArray jSONArray2 = jSONObject9.getJSONArray("allowedContentType");
            for (int i10 = 0; i10 < jSONArray2.length(); i10++) {
                this.f5183j.f5230e.add(jSONArray2.getString(i10));
            }
        }
        C2428b bVar = this.f5183j.f5229d;
        JSONObject jSONObject10 = jSONObject9.getJSONObject("bitRate");
        bVar.f5193a = jSONObject10.getBoolean("bitrate_mandatory");
        bVar.f5194b = jSONObject10.getInt("headerTimeout");
        JSONObject jSONObject11 = jSONObject.getJSONObject("assetCache");
        this.f5184k.f5189b = jSONObject11.getInt("retryInterval");
        this.f5184k.f5188a = jSONObject11.getInt("maxRetries");
        this.f5184k.f5190c = jSONObject11.getInt("maxCachedAssets");
        this.f5184k.f5191d = (long) jSONObject11.getInt("maxCacheSize");
        this.f5184k.f5192e = jSONObject11.getLong(TapjoyConstants.TJC_TIME_TO_LIVE);
    }

    /* renamed from: b */
    private void m5074b(JSONObject jSONObject) throws JSONException {
        String str = "base";
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        this.f5186q = new C2429c();
        C2429c cVar = this.f5186q;
        String str2 = TapjoyConstants.TJC_TIME_TO_LIVE;
        cVar.f5195a = jSONObject2.getLong(str2);
        jSONObject.remove(str);
        this.f5187r = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str3 = (String) keys.next();
            JSONObject jSONObject3 = jSONObject.getJSONObject(str3);
            C2429c cVar2 = new C2429c();
            cVar2.f5195a = jSONObject3.optLong(str2, this.f5186q.f5195a);
            this.f5187r.put(str3, cVar2);
        }
    }

    /* renamed from: b */
    public final JSONObject mo28342b() throws JSONException {
        JSONObject b = super.mo28342b();
        String str = "url";
        b.put(str, this.f5174a);
        b.put("cctEnabled", this.f5178e);
        b.put("minimumRefreshInterval", this.f5175b);
        b.put("defaultRefreshInterval", this.f5176c);
        b.put("fetchTimeout", this.f5177d);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        long j = this.f5186q.f5195a;
        String str2 = TapjoyConstants.TJC_TIME_TO_LIVE;
        jSONObject2.put(str2, j);
        jSONObject.put("base", jSONObject2);
        for (Entry entry : this.f5187r.entrySet()) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(str2, ((C2429c) entry.getValue()).f5195a);
            jSONObject.put((String) entry.getKey(), jSONObject3);
        }
        b.put("cache", jSONObject);
        JSONObject jSONObject4 = new JSONObject();
        String str3 = "maxRetries";
        jSONObject4.put(str3, this.f5179f.f5196a);
        jSONObject4.put("pingInterval", this.f5179f.f5197b);
        jSONObject4.put("pingTimeout", this.f5179f.f5198c);
        jSONObject4.put("maxDbEvents", this.f5179f.f5199d);
        jSONObject4.put("maxEventBatch", this.f5179f.f5200e);
        jSONObject4.put("pingCacheExpiry", this.f5179f.f5201f);
        b.put("imai", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, this.f5185l.mo28597k());
        jSONObject5.put("bitmap", this.f5185l.mo28589c());
        jSONObject5.put("step1a", this.f5185l.mo28592f());
        jSONObject5.put("step1b", this.f5185l.mo28593g());
        jSONObject5.put("step2u", this.f5185l.mo28594h());
        jSONObject5.put("step3r", this.f5185l.mo28595i());
        jSONObject5.put("step4s", this.f5185l.mo28596j());
        jSONObject5.put("renderTimeout", this.f5185l.mo28598l());
        b.put("timeouts", jSONObject5);
        JSONObject jSONObject6 = new JSONObject();
        jSONObject6.put("picWidth", this.f5180g.f5213a);
        jSONObject6.put("picHeight", this.f5180g.f5214b);
        jSONObject6.put("picQuality", this.f5180g.f5215c);
        jSONObject6.put("webviewBackground", this.f5180g.f5216d);
        jSONObject6.put("autoRedirectionEnforcement", this.f5180g.f5218f);
        jSONObject6.put("maxVibrationDuration", this.f5180g.f5219g);
        jSONObject6.put("maxVibrationPatternLength", this.f5180g.f5220h);
        jSONObject6.put("delayedRedirection", this.f5180g.f5221i);
        jSONObject6.put("enablePubMuteControl", this.f5180g.f5225m);
        JSONObject jSONObject7 = new JSONObject();
        jSONObject7.put("maxSaveSize", this.f5180g.f5222j);
        String str4 = "allowedContentType";
        jSONObject7.put(str4, new JSONArray(this.f5180g.f5223k));
        jSONObject6.put("savecontent", jSONObject7);
        jSONObject6.put("shouldRenderPopup", this.f5180g.f5224l);
        b.put("rendering", jSONObject6);
        JSONObject jSONObject8 = new JSONObject();
        String str5 = "expiry";
        jSONObject8.put(str5, this.f5181h.f5202a);
        jSONObject8.put(str3, this.f5181h.f5203b);
        String str6 = "retryInterval";
        jSONObject8.put(str6, this.f5181h.f5204c);
        jSONObject8.put(str, this.f5181h.f5205d);
        b.put("mraid", jSONObject8);
        JSONObject jSONObject9 = new JSONObject();
        String str7 = "impressionMinPercentageViewed";
        jSONObject9.put(str7, this.f5182i.f5231a);
        String str8 = "impressionMinTimeViewed";
        jSONObject9.put(str8, this.f5182i.f5232b);
        jSONObject9.put("displayMinPercentageAnimate", this.f5182i.f5235e);
        jSONObject9.put("visibilityThrottleMillis", this.f5182i.f5233c);
        String str9 = "impressionPollIntervalMillis";
        jSONObject9.put(str9, this.f5182i.f5234d);
        jSONObject9.put("moatEnabled", this.f5182i.f5241k);
        C2432f fVar = this.f5182i.f5242l;
        JSONObject jSONObject10 = new JSONObject();
        jSONObject10.put(str5, fVar.f5206a);
        jSONObject10.put("partnerKey", fVar.f5209d);
        jSONObject10.put(str3, fVar.f5207b);
        jSONObject10.put(str6, fVar.f5208c);
        jSONObject10.put(str, fVar.f5210e);
        jSONObject10.put("omidEnabled", fVar.f5211f);
        jSONObject10.put("webViewRetainTime", fVar.f5212g);
        jSONObject9.put("omidConfig", jSONObject10);
        JSONObject jSONObject11 = new JSONObject();
        jSONObject11.put(str7, this.f5182i.f5236f);
        jSONObject11.put(str8, this.f5182i.f5237g);
        jSONObject11.put("videoMinPercentagePlay", this.f5182i.f5238h);
        jSONObject9.put("video", jSONObject11);
        JSONObject jSONObject12 = new JSONObject();
        jSONObject12.put(str7, this.f5182i.f5239i);
        jSONObject12.put(str9, this.f5182i.f5240j);
        jSONObject9.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB, jSONObject12);
        b.put("viewability", jSONObject9);
        JSONObject jSONObject13 = new JSONObject();
        jSONObject13.put("maxWrapperLimit", this.f5183j.f5226a);
        jSONObject13.put("optimalVastVideoSize", this.f5183j.f5227b);
        jSONObject13.put("vastMaxAssetSize", this.f5183j.f5228c);
        jSONObject13.put(str4, new JSONArray(this.f5183j.f5230e));
        C2428b bVar = this.f5183j.f5229d;
        JSONObject jSONObject14 = new JSONObject();
        jSONObject14.put("headerTimeout", bVar.f5194b);
        jSONObject14.put("bitrate_mandatory", bVar.f5193a);
        jSONObject13.put("bitRate", jSONObject14);
        b.put("vastVideo", jSONObject13);
        JSONObject jSONObject15 = new JSONObject();
        jSONObject15.put(str6, this.f5184k.f5189b);
        jSONObject15.put(str3, this.f5184k.f5188a);
        jSONObject15.put("maxCachedAssets", this.f5184k.f5190c);
        jSONObject15.put("maxCacheSize", this.f5184k.f5191d);
        jSONObject15.put(str2, this.f5184k.f5192e);
        b.put("assetCache", jSONObject15);
        return b;
    }

    /* renamed from: c */
    public final boolean mo28343c() {
        boolean z;
        String str = "http://";
        String str2 = "https://";
        if (this.f5174a.startsWith(str) || this.f5174a.startsWith(str2)) {
            int i = this.f5175b;
            if (i >= 0) {
                int i2 = this.f5176c;
                if (i2 >= 0 && i <= i2 && this.f5177d > 0) {
                    C2429c cVar = this.f5186q;
                    if (cVar != null && cVar.mo28344a()) {
                        for (Entry value : this.f5187r.entrySet()) {
                            if (!((C2429c) value.getValue()).mo28344a()) {
                                return false;
                            }
                        }
                        if (this.f5179f.f5199d >= 0 && this.f5179f.f5200e >= 0 && this.f5179f.f5196a >= 0 && this.f5179f.f5197b >= 0 && this.f5179f.f5198c > 0 && this.f5179f.f5201f > 0 && this.f5181h.f5202a >= 0 && this.f5181h.f5204c >= 0 && this.f5181h.f5203b >= 0 && ((this.f5181h.f5205d.startsWith(str) || this.f5181h.f5205d.startsWith(str2)) && this.f5185l.mo28597k() >= 0 && this.f5185l.mo28589c() >= 0 && this.f5185l.mo28592f() >= 0 && this.f5185l.mo28593g() >= 0 && this.f5185l.mo28594h() >= 0 && this.f5185l.mo28595i() >= 0 && this.f5185l.mo28596j() >= 0 && this.f5185l.mo28598l() >= 0 && this.f5180g.f5214b >= 0 && this.f5180g.f5213a >= 0 && this.f5180g.f5215c >= 0 && this.f5180g.f5219g >= 0 && this.f5180g.f5220h >= 0 && this.f5180g.f5222j >= 0 && this.f5180g.f5216d != null && this.f5180g.f5216d.trim().length() != 0 && this.f5180g.f5221i > 0)) {
                            try {
                                this.f5180g.f5217e = Color.parseColor(this.f5180g.f5216d);
                                if (this.f5181h.f5203b >= 0 && this.f5181h.f5204c >= 0 && this.f5181h.f5205d != null && this.f5181h.f5205d.trim().length() != 0) {
                                    if (this.f5182i.f5231a > 0 && this.f5182i.f5231a <= 100 && this.f5182i.f5232b >= 0 && this.f5182i.f5235e > 0 && this.f5182i.f5235e <= 100 && this.f5182i.f5236f > 0 && this.f5182i.f5236f <= 100 && this.f5182i.f5239i > 0 && this.f5182i.f5239i <= 100 && this.f5182i.f5240j > 0 && this.f5182i.f5237g >= 0 && this.f5182i.f5238h > 0 && this.f5182i.f5238h <= 100 && this.f5182i.f5233c >= 50 && this.f5182i.f5233c * 5 <= this.f5182i.f5232b && this.f5182i.f5234d >= 50 && this.f5182i.f5234d * 4 <= this.f5182i.f5232b) {
                                        C2432f fVar = this.f5182i.f5242l;
                                        if (!(fVar == null || fVar.f5207b < 0 || fVar.f5208c < 0 || fVar.f5210e == null || fVar.f5210e.trim().length() == 0 || TextUtils.isEmpty(fVar.f5209d))) {
                                            z = false;
                                            if (z && this.f5183j.f5227b <= 31457280 && this.f5183j.f5227b > 0 && this.f5183j.f5226a >= 0 && this.f5183j.f5228c > 0 && this.f5183j.f5228c <= 31457280 && this.f5184k.f5189b >= 0 && this.f5184k.f5190c <= 20 && this.f5184k.f5190c >= 0 && this.f5184k.f5192e >= 0 && this.f5184k.f5191d >= 0 && this.f5184k.f5188a >= 0) {
                                                return true;
                                            }
                                        }
                                    }
                                    z = true;
                                    if (z) {
                                        return false;
                                    }
                                    return true;
                                }
                            } catch (IllegalArgumentException unused) {
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public final C2429c mo28339a(String str) {
        C2429c cVar = (C2429c) this.f5187r.get(str);
        return cVar == null ? this.f5186q : cVar;
    }
}
