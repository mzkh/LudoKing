package com.inmobi.media;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.bx */
/* compiled from: ExpandProperties */
public class C2256bx {

    /* renamed from: d */
    private static final String f4713d = "bx";

    /* renamed from: a */
    public boolean f4714a = false;

    /* renamed from: b */
    public boolean f4715b;

    /* renamed from: c */
    public String f4716c;

    /* renamed from: e */
    private boolean f4717e = true;

    public C2256bx() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", C2528gq.m5393a().f5541a);
            jSONObject.put("height", C2528gq.m5393a().f5542b);
            jSONObject.put("useCustomClose", this.f4714a);
            jSONObject.put("isModal", this.f4717e);
        } catch (JSONException unused) {
        }
        this.f4716c = jSONObject.toString();
    }

    /* renamed from: a */
    public static C2256bx m4574a(String str) {
        String str2 = "useCustomClose";
        C2256bx bxVar = new C2256bx();
        bxVar.f4716c = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            bxVar.f4717e = true;
            if (jSONObject.has(str2)) {
                bxVar.f4715b = true;
            }
            bxVar.f4714a = jSONObject.optBoolean(str2, false);
        } catch (JSONException unused) {
        }
        return bxVar;
    }
}
