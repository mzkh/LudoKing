package com.inmobi.media;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.hb */
/* compiled from: CarbGetListNetworkResponse */
public class C2554hb {

    /* renamed from: e */
    private static final String f5622e = "hb";

    /* renamed from: a */
    boolean f5623a = true;

    /* renamed from: b */
    List<C2555hc> f5624b;

    /* renamed from: c */
    String f5625c;

    /* renamed from: d */
    int f5626d = 0;

    /* renamed from: f */
    private C2487fs f5627f;

    C2554hb(C2487fs fsVar) {
        this.f5627f = fsVar;
        this.f5624b = new ArrayList();
        m5544a();
    }

    /* renamed from: a */
    private void m5544a() {
        if (!this.f5627f.mo28417a()) {
            try {
                JSONObject jSONObject = new JSONObject(this.f5627f.mo28418b());
                if (jSONObject.getBoolean("success")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    this.f5625c = jSONObject2.getString("req_id");
                    JSONArray jSONArray = jSONObject2.getJSONArray("p_apps");
                    int i = 0;
                    while (i < jSONArray.length()) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                        String optString = jSONObject3.optString("bid", null);
                        String optString2 = jSONObject3.optString("inm_id", null);
                        if (!(optString == null || optString2 == null || optString2.trim().length() <= 0)) {
                            this.f5624b.add(new C2555hc(optString, optString2));
                        }
                        i++;
                        this.f5626d = i;
                    }
                } else {
                    jSONObject.optInt("errorCode");
                }
                this.f5623a = false;
            } catch (JSONException unused) {
            }
        }
    }
}
