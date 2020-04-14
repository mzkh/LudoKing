package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbhz {
    @Nullable
    public static JSONObject zza(zzcvr zzcvr) {
        try {
            return new JSONObject(zzcvr.zzdky);
        } catch (JSONException unused) {
            return null;
        }
    }
}
