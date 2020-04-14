package com.iab.omid.library.adcolony.adsession.video;

import com.iab.omid.library.adcolony.p028d.C2047c;
import com.iab.omid.library.adcolony.p028d.C2049e;
import org.json.JSONException;
import org.json.JSONObject;

public final class VastProperties {

    /* renamed from: a */
    private static final String f4009a = "VastProperties: ";

    /* renamed from: b */
    private final boolean f4010b;

    /* renamed from: c */
    private final Float f4011c;

    /* renamed from: d */
    private final boolean f4012d;

    /* renamed from: e */
    private final Position f4013e;

    private VastProperties(boolean z, Float f, boolean z2, Position position) {
        this.f4010b = z;
        this.f4011c = f;
        this.f4012d = z2;
        this.f4013e = position;
    }

    public static VastProperties createVastPropertiesForNonSkippableVideo(boolean z, Position position) {
        C2049e.m3841a((Object) position, "Position is null");
        return new VastProperties(false, null, z, position);
    }

    public static VastProperties createVastPropertiesForSkippableVideo(float f, boolean z, Position position) {
        C2049e.m3841a((Object) position, "Position is null");
        return new VastProperties(true, Float.valueOf(f), z, position);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public JSONObject mo27376a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f4010b);
            if (this.f4010b) {
                jSONObject.put("skipOffset", this.f4011c);
            }
            jSONObject.put("autoPlay", this.f4012d);
            jSONObject.put("position", this.f4013e);
        } catch (JSONException e) {
            C2047c.m3836a("VastProperties: JSON error", e);
        }
        return jSONObject;
    }
}
