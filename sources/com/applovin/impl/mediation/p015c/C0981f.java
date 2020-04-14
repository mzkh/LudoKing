package com.applovin.impl.mediation.p015c;

import android.app.Activity;
import com.applovin.impl.mediation.p016d.C0988a;
import com.applovin.impl.mediation.p016d.C0990c;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p020c.C1113g;
import com.applovin.impl.sdk.p020c.C1114h;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.p021d.C1122a;
import com.applovin.impl.sdk.p021d.C1159r;
import com.applovin.impl.sdk.utils.C1241c;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1248i;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.c.f */
public class C0981f extends C1122a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f1893a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final MaxAdFormat f1894c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final JSONObject f1895d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final MaxAdListener f1896e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Activity f1897f;

    /* renamed from: g */
    private C1241c f1898g;

    /* renamed from: com.applovin.impl.mediation.c.f$a */
    private class C0983a extends C1122a {

        /* renamed from: c */
        private final JSONArray f1901c;

        /* renamed from: d */
        private final int f1902d;

        C0983a(int i, JSONArray jSONArray) {
            super("TaskProcessNextWaterfallAd", C0981f.this.f2745b);
            if (i < 0 || i >= jSONArray.length()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid ad index specified: ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
            }
            this.f1901c = jSONArray;
            this.f1902d = i;
        }

        /* renamed from: a */
        private String m1740a(int i) {
            String str = "undefined";
            if (i < 0 || i >= this.f1901c.length()) {
                return str;
            }
            return C1247h.m2985b(C1247h.m2977a(this.f1901c, i, new JSONObject(), this.f2745b), "type", str, this.f2745b);
        }

        /* renamed from: b */
        private void m1743b() throws JSONException {
            JSONObject jSONObject = this.f1901c.getJSONObject(this.f1902d);
            String a = m1740a(this.f1902d);
            if ("adapter".equalsIgnoreCase(a)) {
                mo10068a("Starting task for adapter ad...");
                m1745e("started to load ad");
                C1159r K = this.f2745b.mo10185K();
                C0980e eVar = new C0980e(C0981f.this.f1893a, jSONObject, C0981f.this.f1895d, this.f2745b, C0981f.this.f1897f, new C0988a(C0981f.this.f1896e, this.f2745b) {
                    public void onAdLoadFailed(String str, int i) {
                        C0983a aVar = C0983a.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append("failed to load ad: ");
                        sb.append(i);
                        aVar.m1745e(sb.toString());
                        C0983a.this.m1744c();
                    }

                    public void onAdLoaded(MaxAd maxAd) {
                        C0983a.this.m1745e("loaded ad");
                        C0981f.this.m1731a(maxAd);
                    }
                });
                K.mo10130a((C1122a) eVar);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to process ad of unknown type: ");
            sb.append(a);
            mo10072d(sb.toString());
            C0981f.this.m1728a(-800);
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public void m1744c() {
            if (this.f1902d < this.f1901c.length() - 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("Attempting to load next ad (");
                sb.append(this.f1902d);
                sb.append(") after failure...");
                mo10070b(sb.toString());
                this.f2745b.mo10185K().mo10131a((C1122a) new C0983a(this.f1902d + 1, this.f1901c), C0990c.m1769a(C0981f.this.f1894c));
                return;
            }
            C0981f.this.m1732b();
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public void m1745e(String str) {
        }

        /* renamed from: a */
        public C1115i mo9338a() {
            return C1115i.f2684F;
        }

        public void run() {
            try {
                m1743b();
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("Encountered error while processing ad number ");
                sb.append(this.f1902d);
                mo10069a(sb.toString(), th);
                this.f2745b.mo10187M().mo10047a(mo9338a());
                C0981f.this.m1732b();
            }
        }
    }

    C0981f(String str, MaxAdFormat maxAdFormat, JSONObject jSONObject, Activity activity, C1192i iVar, MaxAdListener maxAdListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("TaskProcessMediationWaterfall ");
        sb.append(str);
        super(sb.toString(), iVar);
        this.f1893a = str;
        this.f1894c = maxAdFormat;
        this.f1895d = jSONObject;
        this.f1896e = maxAdListener;
        this.f1897f = activity;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1728a(int i) {
        C1114h L;
        C1113g gVar;
        if (i == 204) {
            L = this.f2745b.mo10186L();
            gVar = C1113g.f2671p;
        } else if (i == -5001) {
            L = this.f2745b.mo10186L();
            gVar = C1113g.f2672q;
        } else {
            L = this.f2745b.mo10186L();
            gVar = C1113g.f2673r;
        }
        L.mo10036a(gVar);
        StringBuilder sb = new StringBuilder();
        sb.append("Notifying parent of ad load failure for ad unit ");
        sb.append(this.f1893a);
        sb.append(": ");
        sb.append(i);
        mo10070b(sb.toString());
        C1248i.m2997a(this.f1896e, this.f1893a, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1731a(MaxAd maxAd) {
        StringBuilder sb = new StringBuilder();
        sb.append("Notifying parent of ad load success for ad unit ");
        sb.append(this.f1893a);
        mo10070b(sb.toString());
        C1248i.m2994a(this.f1896e, maxAd);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1732b() {
        m1728a((int) MaxErrorCodes.MEDIATION_ADAPTER_LOAD_FAILED);
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2683E;
    }

    public void run() {
        JSONArray optJSONArray = this.f1895d.optJSONArray("ads");
        int length = optJSONArray != null ? optJSONArray.length() : 0;
        if (length > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Loading the first out of ");
            sb.append(length);
            sb.append(" ads...");
            mo10068a(sb.toString());
            this.f2745b.mo10185K().mo10130a((C1122a) new C0983a(0, optJSONArray));
            return;
        }
        mo10071c("No ads were returned from the server");
        C1281o.m3086a(this.f1893a, this.f1895d, this.f2745b);
        JSONObject b = C1247h.m2989b(this.f1895d, "settings", new JSONObject(), this.f2745b);
        long a = C1247h.m2962a(b, "alfdcs", 0, this.f2745b);
        if (a > 0) {
            long millis = TimeUnit.SECONDS.toMillis(a);
            C09821 r4 = new Runnable() {
                public void run() {
                    C0981f.this.m1728a(204);
                }
            };
            if (C1247h.m2963a(b, "alfdcs_iba", Boolean.valueOf(false), this.f2745b).booleanValue()) {
                this.f1898g = C1241c.m2918a(millis, this.f2745b, r4);
            } else {
                AppLovinSdkUtils.runOnUiThreadDelayed(r4, millis);
            }
        } else {
            m1728a(204);
        }
    }
}
