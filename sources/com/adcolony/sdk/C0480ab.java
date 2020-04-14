package com.adcolony.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.ab */
class C0480ab {

    /* renamed from: a */
    private String f165a;

    /* renamed from: b */
    private JSONObject f166b;

    C0480ab(JSONObject jSONObject) {
        try {
            this.f166b = jSONObject;
            this.f165a = jSONObject.getString("m_type");
        } catch (JSONException e) {
            new C0749a().mo8726a("JSON Error in ADCMessage constructor: ").mo8726a(e.toString()).mo8728a(C0748w.f1172h);
        }
    }

    C0480ab(String str, int i) {
        try {
            this.f165a = str;
            this.f166b = new JSONObject();
            this.f166b.put("m_target", i);
        } catch (JSONException e) {
            new C0749a().mo8726a("JSON Error in ADCMessage constructor: ").mo8726a(e.toString()).mo8728a(C0748w.f1172h);
        }
    }

    C0480ab(String str, int i, String str2) {
        try {
            this.f165a = str;
            this.f166b = C0746u.m893a(str2);
            this.f166b.put("m_target", i);
        } catch (JSONException e) {
            new C0749a().mo8726a("JSON Error in ADCMessage constructor: ").mo8726a(e.toString()).mo8728a(C0748w.f1172h);
        }
    }

    C0480ab(String str, int i, JSONObject jSONObject) {
        try {
            this.f165a = str;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            this.f166b = jSONObject;
            this.f166b.put("m_target", i);
        } catch (JSONException e) {
            new C0749a().mo8726a("JSON Error in ADCMessage constructor: ").mo8726a(e.toString()).mo8728a(C0748w.f1172h);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0480ab mo8214a() {
        return mo8216a((JSONObject) null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0480ab mo8215a(String str) {
        return mo8216a(C0746u.m893a(str));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0480ab mo8216a(JSONObject jSONObject) {
        String str = "m_id";
        try {
            C0480ab abVar = new C0480ab("reply", this.f166b.getInt("m_origin"), jSONObject);
            abVar.f166b.put(str, this.f166b.getInt(str));
            return abVar;
        } catch (JSONException e) {
            new C0749a().mo8726a("JSON error in ADCMessage's createReply(): ").mo8726a(e.toString()).mo8728a(C0748w.f1172h);
            return new C0480ab("JSONException", 0);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8217b() {
        C0476a.m82a(this.f165a, this.f166b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public JSONObject mo8220c() {
        return this.f166b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8219b(JSONObject jSONObject) {
        this.f166b = jSONObject;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public String mo8221d() {
        return this.f165a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8218b(String str) {
        this.f165a = str;
    }
}
