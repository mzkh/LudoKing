package com.iab.omid.library.adcolony.adsession;

import com.iab.omid.library.adcolony.p028d.C2045b;
import com.iab.omid.library.adcolony.p028d.C2049e;
import org.json.JSONObject;

public class AdSessionConfiguration {

    /* renamed from: a */
    private final Owner f3974a;

    /* renamed from: b */
    private final Owner f3975b;

    /* renamed from: c */
    private final boolean f3976c;

    private AdSessionConfiguration(Owner owner, Owner owner2, boolean z) {
        this.f3974a = owner;
        if (owner2 == null) {
            this.f3975b = Owner.NONE;
        } else {
            this.f3975b = owner2;
        }
        this.f3976c = z;
    }

    @Deprecated
    public static AdSessionConfiguration createAdSessionConfiguration(Owner owner, Owner owner2) {
        return createAdSessionConfiguration(owner, owner2, true);
    }

    public static AdSessionConfiguration createAdSessionConfiguration(Owner owner, Owner owner2, boolean z) {
        C2049e.m3841a((Object) owner, "Impression owner is null");
        C2049e.m3839a(owner);
        return new AdSessionConfiguration(owner, owner2, z);
    }

    public boolean isNativeImpressionOwner() {
        return Owner.NATIVE == this.f3974a;
    }

    public boolean isNativeVideoEventsOwner() {
        return Owner.NATIVE == this.f3975b;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        C2045b.m3825a(jSONObject, "impressionOwner", this.f3974a);
        C2045b.m3825a(jSONObject, "videoEventsOwner", this.f3975b);
        C2045b.m3825a(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.f3976c));
        return jSONObject;
    }
}
