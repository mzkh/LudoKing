package com.iab.omid.library.inmobi.adsession;

import com.iab.omid.library.inmobi.p034d.C2093b;
import com.iab.omid.library.inmobi.p034d.C2097e;
import org.json.JSONObject;

public class AdSessionConfiguration {
    private final Owner impressionOwner;
    private final boolean isolateVerificationScripts;
    private final Owner videoEventsOwner;

    private AdSessionConfiguration(Owner owner, Owner owner2, boolean z) {
        this.impressionOwner = owner;
        if (owner2 == null) {
            this.videoEventsOwner = Owner.NONE;
        } else {
            this.videoEventsOwner = owner2;
        }
        this.isolateVerificationScripts = z;
    }

    @Deprecated
    public static AdSessionConfiguration createAdSessionConfiguration(Owner owner, Owner owner2) {
        return createAdSessionConfiguration(owner, owner2, true);
    }

    public static AdSessionConfiguration createAdSessionConfiguration(Owner owner, Owner owner2, boolean z) {
        C2097e.m4047a((Object) owner, "Impression owner is null");
        C2097e.m4045a(owner);
        return new AdSessionConfiguration(owner, owner2, z);
    }

    public boolean isNativeImpressionOwner() {
        return Owner.NATIVE == this.impressionOwner;
    }

    public boolean isNativeVideoEventsOwner() {
        return Owner.NATIVE == this.videoEventsOwner;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        C2093b.m4030a(jSONObject, "impressionOwner", this.impressionOwner);
        C2093b.m4030a(jSONObject, "videoEventsOwner", this.videoEventsOwner);
        C2093b.m4030a(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.isolateVerificationScripts));
        return jSONObject;
    }
}
