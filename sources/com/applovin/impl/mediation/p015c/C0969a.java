package com.applovin.impl.mediation.p015c;

import android.app.Activity;
import com.applovin.impl.mediation.p014b.C0962e;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p019b.C1098e;
import com.applovin.impl.sdk.p020c.C1113g;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.p021d.C1122a;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.sdk.AppLovinMediationProvider;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.c.a */
public class C0969a extends C1122a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Activity f1857a;

    public C0969a(Activity activity, C1192i iVar) {
        super("TaskAutoInitAdapters", iVar, true);
        this.f1857a = activity;
    }

    /* renamed from: a */
    private List<C0962e> m1679a(JSONArray jSONArray, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new C0962e(C1247h.m2977a(jSONArray, i, (JSONObject) null, this.f2745b), jSONObject, this.f2745b));
        }
        return arrayList;
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2679A;
    }

    public void run() {
        String str;
        String str2 = (String) this.f2745b.mo10203a(C1098e.f2577w);
        if (C1277l.m3042b(str2)) {
            if (this.f1857a == null) {
                C1227o.m2841i("AppLovinSdk", "Failed to initialize 3rd-party SDKs. Please contact us at devsupport@applovin.com for more information.");
                this.f2745b.mo10186L().mo10041b(C1113g.f2670o, 1);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                boolean a = C1247h.m2982a(this.f2745b.mo10189O().mo10262d().f2977b, C1247h.m2988b(jSONObject, "test_mode_idfas", new JSONArray(), this.f2745b));
                List<C0962e> a2 = m1679a(C1247h.m2988b(jSONObject, a ? "test_mode_auto_init_adapters" : "auto_init_adapters", new JSONArray(), this.f2745b), jSONObject);
                if (a2.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Auto-initing ");
                    sb.append(a2.size());
                    sb.append(" adapters");
                    sb.append(a ? " in test mode" : "");
                    sb.append("...");
                    mo10068a(sb.toString());
                    this.f2745b.mo10228c(AppLovinMediationProvider.MAX);
                    for (final C0962e eVar : a2) {
                        this.f2745b.mo10185K().mo10135b().execute(new Runnable() {
                            public void run() {
                                C0969a aVar = C0969a.this;
                                StringBuilder sb = new StringBuilder();
                                sb.append("Auto-initing adapter: ");
                                sb.append(eVar);
                                aVar.mo10068a(sb.toString());
                                C0969a.this.f2745b.mo10251x().mo9542a(eVar, C0969a.this.f1857a);
                            }
                        });
                    }
                } else {
                    mo10072d("No auto-init adapters found");
                }
            } catch (JSONException e) {
                th = e;
                str = "Failed to parse auto-init adapters JSON";
                mo10069a(str, th);
            } catch (Throwable th) {
                th = th;
                str = "Failed to auto-init adapters";
                mo10069a(str, th);
            }
        }
    }
}
