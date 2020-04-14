package com.tapjoy.internal;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.db */
public final class C2942db {

    /* renamed from: a */
    private final boolean f6794a = false;

    /* renamed from: b */
    private final Float f6795b = null;

    /* renamed from: c */
    private final boolean f6796c = false;

    /* renamed from: d */
    private final C2941da f6797d;

    private C2942db(C2941da daVar) {
        this.f6797d = daVar;
    }

    /* renamed from: a */
    public static C2942db m6702a(C2941da daVar) {
        C2960do.m6754a((Object) daVar, "Position is null");
        return new C2942db(daVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final JSONObject mo29929a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f6794a);
            if (this.f6794a) {
                jSONObject.put("skipOffset", this.f6795b);
            }
            jSONObject.put("autoPlay", this.f6796c);
            jSONObject.put("position", this.f6797d);
        } catch (JSONException e) {
            C2959dn.m6752a("VastProperties: JSON error", e);
        }
        return jSONObject;
    }
}
