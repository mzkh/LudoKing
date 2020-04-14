package com.applovin.impl.p005a;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p018ad.C1079b;
import com.applovin.impl.sdk.p018ad.C1082d;
import com.applovin.impl.sdk.utils.C1243d;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.impl.sdk.utils.C1283q;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.facebook.appevents.AppEventsConstants;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.a.c */
public class C0775c {

    /* renamed from: c */
    private static final List<String> f1255c = Arrays.asList(new String[]{"video/mp4", "video/webm", "video/3gpp", "video/x-matroska"});

    /* renamed from: a */
    protected List<C1283q> f1256a = new ArrayList();

    /* renamed from: b */
    private final C1192i f1257b;

    /* renamed from: d */
    private final JSONObject f1258d;

    /* renamed from: e */
    private final JSONObject f1259e;

    /* renamed from: f */
    private final C1079b f1260f;

    /* renamed from: g */
    private final long f1261g = System.currentTimeMillis();

    public C0775c(JSONObject jSONObject, JSONObject jSONObject2, C1079b bVar, C1192i iVar) {
        this.f1257b = iVar;
        this.f1258d = jSONObject;
        this.f1259e = jSONObject2;
        this.f1260f = bVar;
    }

    /* renamed from: a */
    public int mo8920a() {
        return this.f1256a.size();
    }

    /* renamed from: b */
    public List<C1283q> mo8921b() {
        return this.f1256a;
    }

    /* renamed from: c */
    public JSONObject mo8922c() {
        return this.f1258d;
    }

    /* renamed from: d */
    public JSONObject mo8923d() {
        return this.f1259e;
    }

    /* renamed from: e */
    public C1079b mo8924e() {
        return this.f1260f;
    }

    /* renamed from: f */
    public long mo8925f() {
        return this.f1261g;
    }

    /* renamed from: g */
    public C1082d mo8926g() {
        String b = C1247h.m2985b(this.f1259e, AdColonyAdapterUtils.KEY_ZONE_ID, (String) null, this.f1257b);
        return C1082d.m1997a(AppLovinAdSize.fromString(C1247h.m2985b(this.f1259e, "ad_size", (String) null, this.f1257b)), AppLovinAdType.fromString(C1247h.m2985b(this.f1259e, AppEventsConstants.EVENT_PARAM_AD_TYPE, (String) null, this.f1257b)), b, this.f1257b);
    }

    /* renamed from: h */
    public List<String> mo8927h() {
        List<String> a = C1243d.m2924a(C1247h.m2985b(this.f1258d, "vast_preferred_video_types", (String) null, (C1192i) null));
        return !a.isEmpty() ? a : f1255c;
    }

    /* renamed from: i */
    public int mo8928i() {
        return C1281o.m3063a(this.f1258d);
    }
}
