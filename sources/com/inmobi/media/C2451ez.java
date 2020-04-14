package com.inmobi.media;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.ez */
/* compiled from: PkConfig */
public final class C2451ez extends C2436er {

    /* renamed from: a */
    public String f5294a = "010001";

    /* renamed from: b */
    public String f5295b = "E72409364B865B757E1D6B8DB73011BBB1D20C1A9F931ADD3C4C09E2794CE102F8AA7F2D50EB88F9880A576E6C7B0E95712CAE9416F7BACB798564627846E93B";

    /* renamed from: c */
    public String f5296c = "1";

    /* renamed from: d */
    private String f5297d = "rsa";

    /* renamed from: a */
    public final String mo28340a() {
        return "pk";
    }

    C2451ez(@Nullable String str) {
        super(str);
    }

    /* renamed from: a */
    public final void mo28341a(JSONObject jSONObject) throws JSONException {
        super.mo28341a(jSONObject);
        this.f5294a = jSONObject.getString("e");
        this.f5295b = jSONObject.getString("m");
        this.f5297d = jSONObject.getString("alg");
        this.f5296c = jSONObject.getString("ver");
    }

    /* renamed from: b */
    public final JSONObject mo28342b() throws JSONException {
        JSONObject b = super.mo28342b();
        b.put("e", this.f5294a);
        b.put("m", this.f5295b);
        b.put("alg", this.f5297d);
        b.put("ver", this.f5296c);
        return b;
    }

    /* renamed from: c */
    public final boolean mo28343c() {
        return (this.f5294a.trim().length() == 0 || this.f5295b.trim().length() == 0 || this.f5297d.trim().length() == 0 || this.f5296c.trim().length() == 0) ? false : true;
    }
}
