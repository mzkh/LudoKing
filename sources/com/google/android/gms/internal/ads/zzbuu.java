package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbuu extends zzbuv {
    private final boolean zzdcl;
    private final boolean zzdcm;
    private final boolean zzdlo;
    private final JSONObject zzflv;
    private final boolean zzflw;

    public zzbuu(zzcvr zzcvr, JSONObject jSONObject) {
        super(zzcvr);
        boolean z = false;
        this.zzflv = zzawg.zza(jSONObject, "tracking_urls_and_actions", "active_view");
        this.zzdcm = zzawg.zza(false, jSONObject, "allow_pub_owned_ad_view");
        this.zzdcl = zzawg.zza(false, jSONObject, "attribution", "allow_pub_rendering");
        this.zzdlo = zzawg.zza(false, jSONObject, "enable_omid");
        if (!(jSONObject == null || jSONObject.optJSONObject("overlay") == null)) {
            z = true;
        }
        this.zzflw = z;
    }

    public final JSONObject zzaia() {
        JSONObject jSONObject = this.zzflv;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.zzflx.zzdky);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final boolean zzaib() {
        return this.zzflw;
    }

    public final boolean zzaic() {
        return this.zzdcm;
    }

    public final boolean zzahl() {
        return this.zzdlo;
    }

    public final boolean zzaid() {
        return this.zzdcl;
    }
}
