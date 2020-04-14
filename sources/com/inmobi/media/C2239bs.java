package com.inmobi.media;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.inmobi.unification.sdk.model.ASRequestParams;
import java.util.Map;

/* renamed from: com.inmobi.media.bs */
/* compiled from: AdNetworkRequest */
public final class C2239bs extends C2486fr {

    /* renamed from: w */
    private static final String f4648w = "bs";
    @Nullable

    /* renamed from: x */
    private static String f4649x = null;
    @Nullable

    /* renamed from: y */
    private static Map<String, String> f4650y = null;

    /* renamed from: z */
    private static boolean f4651z = false;
    @NonNull

    /* renamed from: a */
    public C2159ai f4652a;

    /* renamed from: b */
    public String f4653b;

    /* renamed from: c */
    public String f4654c;

    /* renamed from: d */
    public String f4655d;

    /* renamed from: e */
    public Map<String, String> f4656e;

    /* renamed from: f */
    public final C2276cf f4657f;

    /* renamed from: g */
    public boolean f4658g;
    @Nullable

    /* renamed from: h */
    public ASRequestParams f4659h;

    @TargetApi(29)
    public C2239bs(String str, C2540gy gyVar, String str2, @NonNull C2159ai aiVar) {
        String str3 = f4649x;
        String str4 = str3 == null ? str : str3;
        f4649x = str4;
        super("POST", str4, m4559a(str4), gyVar, m4559a(f4649x), 0);
        this.f4653b = "json";
        boolean z = false;
        this.f4658g = false;
        this.f4652a = aiVar;
        this.f5449u = C2505gd.m5306f();
        this.f5439k.putAll(C2534gu.m5417c());
        this.f5439k.putAll(C2528gq.m5397c());
        this.f5439k.put("u-appIS", C2525go.m5384a().f5533b);
        this.f5439k.putAll(C2572hm.m5593a());
        this.f5439k.putAll(C2572hm.m5596b());
        this.f5439k.put("client-request-id", this.f4652a.mo27858l());
        Context c = C2505gd.m5298c();
        Map map = this.f5439k;
        C2426eq eqVar = (C2426eq) C2438es.m5087a("ads", this.f5449u, null);
        if ((eqVar != null && eqVar.f5178e) && C2361e.m4920a(c) != null) {
            z = true;
        }
        map.put("cct-enabled", String.valueOf(z));
        if (str2 != null) {
            this.f5439k.put("u-appcache", str2);
        }
        this.f5439k.put("sdk-flavor", "row");
        this.f4657f = new C2276cf();
    }

    /* renamed from: a */
    private static boolean m4559a(String str) {
        if (str == null) {
            return true;
        }
        Uri parse = Uri.parse(str);
        if (!"http".equals(parse.getScheme())) {
            if ("https".equals(parse.getScheme())) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02b0  */
    /* JADX WARNING: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x025d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo27984a() {
        /*
            r11 = this;
            super.mo27984a()
            java.util.Map r0 = r11.f5439k
            java.lang.String r1 = r11.f4653b
            java.lang.String r2 = "format"
            r0.put(r2, r1)
            java.util.Map r0 = r11.f5439k
            java.lang.String r1 = r11.f4654c
            java.lang.String r2 = "adtype"
            r0.put(r2, r1)
            java.util.Map r0 = r11.f5439k
            com.inmobi.media.hh r1 = com.inmobi.media.C2562hh.m5557a()
            java.util.HashMap r1 = r1.mo28558d()
            r0.putAll(r1)
            java.util.Map r0 = r11.f5439k
            com.inmobi.media.hh r1 = com.inmobi.media.C2562hh.m5557a()
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            boolean r3 = com.inmobi.media.C2562hh.m5561c()
            java.lang.String r4 = "DENIED"
            if (r3 == 0) goto L_0x003d
            boolean r1 = r1.mo28559e()
            if (r1 == 0) goto L_0x003d
            java.lang.String r4 = "AUTHORISED"
        L_0x003d:
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r1 = r4.toLowerCase(r1)
            java.lang.String r3 = "loc-consent-status"
            r2.put(r3, r1)
            r0.putAll(r2)
            java.util.Map r0 = r11.f5439k
            com.inmobi.media.C2568hj.m5581a()
            java.lang.String r1 = com.inmobi.media.C2505gd.m5314l()
            com.inmobi.media.hq r2 = com.inmobi.media.C2579hs.m5621b()
            r3 = 0
            if (r2 == 0) goto L_0x0060
            java.lang.String r4 = r2.mo28576e()
            goto L_0x0061
        L_0x0060:
            r4 = r3
        L_0x0061:
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L_0x006d
            boolean r7 = r2.mo28575d()
            if (r7 == 0) goto L_0x006d
            r7 = 1
            goto L_0x006e
        L_0x006d:
            r7 = 0
        L_0x006e:
            if (r1 == 0) goto L_0x007b
            com.inmobi.media.fb$b r1 = com.inmobi.media.C2568hj.m5580a(r1)
            boolean r1 = r1.f5331g
            if (r1 == 0) goto L_0x0079
            goto L_0x007b
        L_0x0079:
            r1 = 0
            goto L_0x007c
        L_0x007b:
            r1 = 1
        L_0x007c:
            if (r4 == 0) goto L_0x0087
            boolean r2 = r2.mo28573b()
            if (r2 == 0) goto L_0x0085
            goto L_0x0087
        L_0x0085:
            r2 = 0
            goto L_0x0088
        L_0x0087:
            r2 = 1
        L_0x0088:
            if (r7 == 0) goto L_0x0095
            com.inmobi.media.fb$b r4 = com.inmobi.media.C2568hj.m5580a(r4)
            boolean r4 = r4.f5331g
            if (r4 == 0) goto L_0x0093
            goto L_0x0095
        L_0x0093:
            r4 = 0
            goto L_0x0096
        L_0x0095:
            r4 = 1
        L_0x0096:
            if (r1 == 0) goto L_0x009e
            if (r2 == 0) goto L_0x009e
            if (r4 == 0) goto L_0x009e
            r1 = 1
            goto L_0x009f
        L_0x009e:
            r1 = 0
        L_0x009f:
            r2 = 29
            if (r1 == 0) goto L_0x00e2
            boolean r1 = com.inmobi.media.C2505gd.m5292a()
            if (r1 == 0) goto L_0x00c8
            android.content.Context r1 = com.inmobi.media.C2505gd.m5298c()
            java.lang.String r4 = "android.permission.ACCESS_WIFI_STATE"
            boolean r1 = com.inmobi.media.C2516gj.m5357a(r1, r4)
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 >= r2) goto L_0x00b8
            goto L_0x00c9
        L_0x00b8:
            android.content.Context r4 = com.inmobi.media.C2505gd.m5298c()
            java.lang.String r7 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r4 = com.inmobi.media.C2516gj.m5357a(r4, r7)
            if (r1 == 0) goto L_0x00c8
            if (r4 == 0) goto L_0x00c8
            r1 = 1
            goto L_0x00c9
        L_0x00c8:
            r1 = 0
        L_0x00c9:
            if (r1 != 0) goto L_0x00cc
            goto L_0x00e2
        L_0x00cc:
            com.inmobi.media.C2568hj.m5581a()
            com.inmobi.media.fb$b r1 = com.inmobi.media.C2568hj.m5583e()
            int r1 = r1.f5329e
            boolean r4 = com.inmobi.media.C2574ho.m5601a(r1)
            boolean r1 = com.inmobi.media.C2574ho.m5602a(r1, r6)
            com.inmobi.media.hn r1 = com.inmobi.media.C2574ho.m5600a(r4, r1)
            goto L_0x00e3
        L_0x00e2:
            r1 = r3
        L_0x00e3:
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            if (r1 == 0) goto L_0x00f5
            long r7 = r1.f5675a
            java.lang.String r1 = java.lang.String.valueOf(r7)
            java.lang.String r7 = "c-ap-bssid"
            r4.put(r7, r1)
        L_0x00f5:
            r0.putAll(r4)
            java.util.Map r0 = r11.f5439k
            com.inmobi.media.C2568hj.m5581a()
            boolean r1 = com.inmobi.media.C2568hj.m5586h()
            if (r1 == 0) goto L_0x010a
            java.util.List r1 = com.inmobi.media.C2575hp.m5607b()
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            goto L_0x010b
        L_0x010a:
            r1 = r3
        L_0x010b:
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            if (r1 == 0) goto L_0x012e
            int r7 = r1.size()
            if (r7 <= 0) goto L_0x012e
            int r7 = r1.size()
            int r7 = r7 - r6
            java.lang.Object r1 = r1.get(r7)
            com.inmobi.media.hn r1 = (com.inmobi.media.C2573hn) r1
            long r7 = r1.f5675a
            java.lang.String r1 = java.lang.String.valueOf(r7)
            java.lang.String r7 = "v-ap-bssid"
            r4.put(r7, r1)
        L_0x012e:
            r0.putAll(r4)
            java.util.Map r0 = r11.f5439k
            com.inmobi.media.ai r1 = r11.f4652a
            java.lang.String r1 = r1.mo27841a()
            java.util.Map r1 = com.inmobi.media.C2572hm.m5594a(r1)
            r0.putAll(r1)
            java.util.Map r0 = r11.f5439k
            com.inmobi.media.ez r1 = r11.mo28411d()
            java.lang.String r1 = r1.f5296c
            java.lang.String r4 = "skdv"
            r0.put(r4, r1)
            java.util.Map r0 = r11.f5439k
            com.inmobi.media.cf r1 = r11.f4657f
            com.inmobi.media.ez r4 = r11.mo28411d()
            java.lang.String r4 = r4.f5295b
            com.inmobi.media.ez r7 = r11.mo28411d()
            java.lang.String r7 = r7.f5294a
            java.lang.String r1 = r1.mo28108a(r4, r7)
            java.lang.String r4 = "skdm"
            r0.put(r4, r1)
            java.lang.String r0 = r11.f4655d
            if (r0 == 0) goto L_0x0173
            java.util.Map r0 = r11.f5439k
            java.lang.String r1 = r11.f4655d
            java.lang.String r4 = "p-keywords"
            r0.put(r4, r1)
        L_0x0173:
            com.inmobi.media.ai r0 = r11.f4652a
            java.lang.String r0 = r0.mo27857k()
            java.lang.String r1 = "M10N_CONTEXT_ACTIVITY"
            if (r0 == 0) goto L_0x018d
            com.inmobi.media.ai r0 = r11.f4652a
            java.lang.String r0 = r0.mo27857k()
            java.lang.String r4 = "others"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x018d
            java.lang.String r1 = "M10N_CONTEXT_OTHER"
        L_0x018d:
            java.util.Map r0 = r11.f5439k
            java.lang.String r4 = "m10n_context"
            r0.put(r4, r1)
            com.inmobi.media.ai r0 = r11.f4652a
            java.util.Map r0 = r0.mo27846c()
            if (r0 == 0) goto L_0x01d0
            com.inmobi.media.ai r0 = r11.f4652a
            java.util.Map r0 = r0.mo27846c()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x01aa:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01d0
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.util.Map r4 = r11.f5439k
            java.lang.Object r7 = r1.getKey()
            boolean r4 = r4.containsKey(r7)
            if (r4 != 0) goto L_0x01aa
            java.util.Map r4 = r11.f5439k
            java.lang.Object r7 = r1.getKey()
            java.lang.Object r1 = r1.getValue()
            r4.put(r7, r1)
            goto L_0x01aa
        L_0x01d0:
            java.util.Map<java.lang.String, java.lang.String> r0 = r11.f4656e
            if (r0 == 0) goto L_0x01db
            java.util.Map r0 = r11.f5439k
            java.util.Map<java.lang.String, java.lang.String> r1 = r11.f4656e
            r0.putAll(r1)
        L_0x01db:
            com.inmobi.media.ai r0 = r11.f4652a
            long r0 = r0.mo27852g()
            r7 = -9223372036854775808
            int r4 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x01f8
            java.util.Map r0 = r11.f5439k
            com.inmobi.media.ai r1 = r11.f4652a
            long r9 = r1.mo27852g()
            java.lang.String r1 = java.lang.String.valueOf(r9)
            java.lang.String r4 = "im-plid"
            r0.put(r4, r1)
        L_0x01f8:
            com.inmobi.media.ai r0 = r11.f4652a
            long r0 = r0.mo27851f()
            int r4 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x0213
            java.util.Map r0 = r11.f5439k
            com.inmobi.media.ai r1 = r11.f4652a
            long r9 = r1.mo27851f()
            java.lang.String r1 = java.lang.String.valueOf(r9)
            java.lang.String r4 = "as-plid"
            r0.put(r4, r1)
        L_0x0213:
            java.util.Map r0 = r11.f5439k
            com.inmobi.media.ai r1 = r11.f4652a
            java.lang.String r1 = r1.mo27843b()
            java.lang.String r4 = "int-origin"
            r0.put(r4, r1)
            java.lang.String r0 = r11.f5449u
            java.lang.String r1 = "signals"
            com.inmobi.media.er r0 = com.inmobi.media.C2438es.m5087a(r1, r0, r3)
            com.inmobi.media.fb r0 = (com.inmobi.media.C2457fb) r0
            org.json.JSONObject r0 = r0.f5316c
            if (r0 == 0) goto L_0x023f
            int r1 = r0.length()
            if (r1 <= 0) goto L_0x023f
            java.util.Map r1 = r11.f5439k
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "im-ext"
            r1.put(r4, r0)
        L_0x023f:
            java.util.Map r0 = r11.f5439k
            com.inmobi.unification.sdk.model.ASRequestParams r1 = r11.f4659h
            if (r1 == 0) goto L_0x024a
            boolean r1 = r1.f5975d
            if (r1 == 0) goto L_0x024a
            r5 = 1
        L_0x024a:
            java.lang.String r1 = java.lang.String.valueOf(r5)
            java.lang.String r4 = "has-dynamic-mediation"
            r0.put(r4, r1)
            com.inmobi.media.ai r0 = r11.f4652a
            long r0 = r0.mo27851f()
            int r4 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x0270
            com.inmobi.media.hq r0 = com.inmobi.media.C2579hs.m5621b()
            if (r0 == 0) goto L_0x0267
            java.lang.String r3 = r0.mo28578g()
        L_0x0267:
            if (r3 == 0) goto L_0x0270
            java.util.Map r0 = r11.f5439k
            java.lang.String r1 = "as-ext"
            r0.put(r1, r3)
        L_0x0270:
            com.inmobi.unification.sdk.model.ASRequestParams r0 = r11.f4659h
            if (r0 == 0) goto L_0x02a5
            java.lang.String r0 = r0.f5973b
            if (r0 == 0) goto L_0x0283
            java.util.Map r0 = r11.f5439k
            com.inmobi.unification.sdk.model.ASRequestParams r1 = r11.f4659h
            java.lang.String r1 = r1.f5973b
            java.lang.String r3 = "a9_params"
            r0.put(r3, r1)
        L_0x0283:
            com.inmobi.unification.sdk.model.ASRequestParams r0 = r11.f4659h
            java.lang.String r0 = r0.f5972a
            if (r0 == 0) goto L_0x0294
            java.util.Map r0 = r11.f5439k
            com.inmobi.unification.sdk.model.ASRequestParams r1 = r11.f4659h
            java.lang.String r1 = r1.f5972a
            java.lang.String r3 = "publisher_keys"
            r0.put(r3, r1)
        L_0x0294:
            com.inmobi.unification.sdk.model.ASRequestParams r0 = r11.f4659h
            java.lang.String r0 = r0.f5974c
            if (r0 == 0) goto L_0x02a5
            java.util.Map r0 = r11.f5439k
            com.inmobi.unification.sdk.model.ASRequestParams r1 = r11.f4659h
            java.lang.String r1 = r1.f5974c
            java.lang.String r3 = "vc_user_id"
            r0.put(r3, r1)
        L_0x02a5:
            java.util.Map<java.lang.String, java.lang.String> r0 = f4650y
            if (r0 == 0) goto L_0x02ac
            r11.mo28407a(r0)
        L_0x02ac:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r2) goto L_0x02bd
            java.lang.String r0 = com.inmobi.media.C2528gq.m5398d()
            if (r0 == 0) goto L_0x02bd
            java.util.Map r1 = r11.f5439k
            java.lang.String r2 = "d-device-gesture-margins"
            r1.put(r2, r0)
        L_0x02bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2239bs.mo27984a():void");
    }

    /* renamed from: b */
    public final boolean mo27985b() {
        return this.f4658g || super.mo27985b();
    }
}
