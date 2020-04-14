package com.applovin.impl.mediation.p016d;

import android.text.TextUtils;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p021d.C1159r.C1161a;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdk;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.d.c */
public class C0990c {

    /* renamed from: a */
    private static final List<String> f1908a = new ArrayList();

    /* renamed from: b */
    private static C0992a f1909b;

    /* renamed from: com.applovin.impl.mediation.d.c$a */
    public static class C0992a {

        /* renamed from: a */
        private final JSONArray f1910a;

        /* renamed from: b */
        private final JSONArray f1911b;

        private C0992a(JSONArray jSONArray, JSONArray jSONArray2) {
            this.f1910a = jSONArray;
            this.f1911b = jSONArray2;
        }

        /* renamed from: a */
        public JSONArray mo9530a() {
            return this.f1910a;
        }

        /* renamed from: b */
        public JSONArray mo9531b() {
            return this.f1911b;
        }
    }

    static {
        f1908a.add("com.applovin.mediation.adapters.AdColonyMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.AmazonMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.AmazonBiddingMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.AppLovinMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.ChartboostMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.FacebookMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.GoogleMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.HyperMXMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.IMobileMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.InMobiMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.InneractiveMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.IronSourceMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.LeadboltMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.MadvertiseMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.MaioMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.MintegralMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.MoPubMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.MyTargetMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.NendMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.OguryMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.SmaatoMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.TapjoyMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.TencentMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.UnityAdsMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.VerizonAdsMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.VungleMediationAdapter");
        f1908a.add("com.applovin.mediation.adapters.YandexMediationAdapter");
    }

    /* renamed from: a */
    public static C0992a m1768a(C1192i iVar) {
        C0992a aVar = f1909b;
        if (aVar != null) {
            return aVar;
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (String str : f1908a) {
            MaxAdapter a = m1770a(str, iVar);
            if (a != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("class", str);
                    jSONObject.put("sdk_version", a.getSdkVersion());
                    jSONObject.put("version", a.getAdapterVersion());
                } catch (Throwable unused) {
                }
                jSONArray.put(jSONObject);
            } else {
                jSONArray2.put(str);
            }
        }
        f1909b = new C0992a(jSONArray, jSONArray2);
        return f1909b;
    }

    /* renamed from: a */
    public static C1161a m1769a(MaxAdFormat maxAdFormat) {
        return maxAdFormat == MaxAdFormat.INTERSTITIAL ? C1161a.MEDIATION_INTERSTITIAL : maxAdFormat == MaxAdFormat.REWARDED ? C1161a.MEDIATION_INCENTIVIZED : C1161a.MEDIATION_BANNER;
    }

    /* renamed from: a */
    public static MaxAdapter m1770a(String str, C1192i iVar) {
        String str2 = "AppLovinSdk";
        if (TextUtils.isEmpty(str)) {
            iVar.mo10249v().mo10382e(str2, "Failed to create adapter instance. No class name provided");
            return null;
        }
        try {
            Class cls = Class.forName(str);
            if (MaxAdapter.class.isAssignableFrom(cls)) {
                return (MaxAdapter) cls.getConstructor(new Class[]{AppLovinSdk.class}).newInstance(new Object[]{iVar.mo10193S()});
            }
            C1227o v = iVar.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" error: not an instance of '");
            sb.append(MaxAdapter.class.getName());
            sb.append("'.");
            v.mo10382e(str2, sb.toString());
            return null;
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            C1227o v2 = iVar.mo10249v();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to load: ");
            sb2.append(str);
            v2.mo10379b(str2, sb2.toString(), th);
        }
    }

    /* renamed from: b */
    public static String m1771b(MaxAdFormat maxAdFormat) {
        return maxAdFormat.getLabel();
    }
}
