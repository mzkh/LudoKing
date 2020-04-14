package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzq;
import com.tapjoy.TapjoyConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzctl implements zzcrr<JSONObject> {
    private Bundle zzghm;

    public zzctl(Bundle bundle) {
        this.zzghm = bundle;
    }

    public final /* synthetic */ void zzr(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (this.zzghm != null) {
            try {
                zzawg.zzb(zzawg.zzb(jSONObject, TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX), "play_store").put("parental_controls", zzq.zzkj().zzd(this.zzghm));
            } catch (JSONException unused) {
                zzaug.zzdy("Failed putting parental controls bundle.");
            }
        }
    }
}
