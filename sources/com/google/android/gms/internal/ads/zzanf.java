package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzanf {
    private final boolean zzdgh;
    private final boolean zzdgi;
    private final boolean zzdgj;
    private final boolean zzdgk;
    private final boolean zzdgl;

    private zzanf(zzanh zzanh) {
        this.zzdgh = zzanh.zzdgh;
        this.zzdgi = zzanh.zzdgi;
        this.zzdgj = zzanh.zzdgj;
        this.zzdgk = zzanh.zzdgk;
        this.zzdgl = zzanh.zzdgl;
    }

    public final JSONObject toJson() {
        try {
            return new JSONObject().put("sms", this.zzdgh).put("tel", this.zzdgi).put("calendar", this.zzdgj).put("storePicture", this.zzdgk).put("inlineVideo", this.zzdgl);
        } catch (JSONException e) {
            zzaug.zzc("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
