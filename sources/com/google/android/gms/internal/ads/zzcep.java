package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcep implements zzcxn {
    static final zzcxn zzftu = new zzcep();

    private zzcep() {
    }

    public final Object apply(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        zzaug.zzdy("Ad request signals:");
        zzaug.zzdy(jSONObject.toString(2));
        return jSONObject;
    }
}
