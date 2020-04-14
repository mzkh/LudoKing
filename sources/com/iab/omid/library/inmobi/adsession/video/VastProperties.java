package com.iab.omid.library.inmobi.adsession.video;

import com.iab.omid.library.inmobi.p034d.C2095c;
import com.iab.omid.library.inmobi.p034d.C2097e;
import org.json.JSONException;
import org.json.JSONObject;

public final class VastProperties {
    private static final String TAG = "VastProperties: ";
    private final boolean isAutoPlay;
    private final boolean isSkippable;
    private final Position position;
    private final Float skipOffset;

    private VastProperties(boolean z, Float f, boolean z2, Position position2) {
        this.isSkippable = z;
        this.skipOffset = f;
        this.isAutoPlay = z2;
        this.position = position2;
    }

    public static VastProperties createVastPropertiesForNonSkippableVideo(boolean z, Position position2) {
        C2097e.m4047a((Object) position2, "Position is null");
        return new VastProperties(false, null, z, position2);
    }

    public static VastProperties createVastPropertiesForSkippableVideo(float f, boolean z, Position position2) {
        C2097e.m4047a((Object) position2, "Position is null");
        return new VastProperties(true, Float.valueOf(f), z, position2);
    }

    /* access modifiers changed from: 0000 */
    public final JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.isSkippable);
            if (this.isSkippable) {
                jSONObject.put("skipOffset", this.skipOffset);
            }
            jSONObject.put("autoPlay", this.isAutoPlay);
            jSONObject.put("position", this.position);
        } catch (JSONException e) {
            C2095c.m4042a("VastProperties: JSON error", e);
        }
        return jSONObject;
    }
}
