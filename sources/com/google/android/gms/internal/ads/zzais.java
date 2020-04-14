package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzais {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final zzait<JSONObject> zzday = new zzaiu();
    public static final zzair<InputStream> zzdaz = zzaiv.zzdba;

    static final /* synthetic */ InputStream zze(JSONObject jSONObject) throws JSONException {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(UTF_8));
    }
}
