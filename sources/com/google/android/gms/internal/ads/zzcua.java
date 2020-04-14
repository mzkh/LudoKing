package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcua implements zzcrr<JSONObject> {
    private final Map<String, Object> zzghs;

    public zzcua(Map<String, Object> map) {
        this.zzghs = map;
    }

    public final /* synthetic */ void zzr(Object obj) {
        try {
            ((JSONObject) obj).put("video_decoders", zzq.zzkj().zzi(this.zzghs));
        } catch (JSONException e) {
            String str = "Could not encode video decoder properties: ";
            String valueOf = String.valueOf(e.getMessage());
            zzaug.zzdy(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }
}
