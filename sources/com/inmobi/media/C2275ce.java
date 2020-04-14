package com.inmobi.media;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.ce */
/* compiled from: ResizeProperties */
public class C2275ce {

    /* renamed from: g */
    private static final String f4772g = "ce";

    /* renamed from: a */
    String f4773a = "top-right";

    /* renamed from: b */
    int f4774b;

    /* renamed from: c */
    int f4775c;

    /* renamed from: d */
    int f4776d = 0;

    /* renamed from: e */
    int f4777e = 0;

    /* renamed from: f */
    boolean f4778f = true;

    /* renamed from: a */
    public static C2275ce m4612a(String str, C2275ce ceVar) {
        C2275ce ceVar2 = new C2275ce();
        try {
            JSONObject jSONObject = new JSONObject(str);
            ceVar2.f4774b = jSONObject.getInt("width");
            ceVar2.f4775c = jSONObject.getInt("height");
            ceVar2.f4776d = jSONObject.getInt("offsetX");
            ceVar2.f4777e = jSONObject.getInt("offsetY");
            if (ceVar == null) {
                return ceVar2;
            }
            ceVar2.f4773a = jSONObject.optString("customClosePosition", ceVar.f4773a);
            ceVar2.f4778f = jSONObject.optBoolean("allowOffscreen", ceVar.f4778f);
            return ceVar2;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public final String mo28106a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.f4774b);
            jSONObject.put("height", this.f4775c);
            jSONObject.put("customClosePosition", this.f4773a);
            jSONObject.put("offsetX", this.f4776d);
            jSONObject.put("offsetY", this.f4777e);
            jSONObject.put("allowOffscreen", this.f4778f);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }
}
