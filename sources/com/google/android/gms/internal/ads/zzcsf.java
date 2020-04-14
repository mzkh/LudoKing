package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcsf implements zzcrr<JSONObject> {
    private final Info zzggr;
    private final String zzggs;
    private final Context zzlk;

    public zzcsf(Info info, Context context, String str) {
        this.zzlk = context;
        this.zzggr = info;
        this.zzggs = str;
    }

    public final /* synthetic */ void zzr(Object obj) {
        try {
            JSONObject zzb = zzawg.zzb((JSONObject) obj, "pii");
            String str = null;
            boolean z = false;
            if (this.zzggr != null) {
                str = this.zzggr.getId();
                z = this.zzggr.isLimitAdTrackingEnabled();
            }
            if (!TextUtils.isEmpty(str)) {
                zzb.put("rdid", str);
                zzb.put("is_lat", z);
                zzb.put("idtype", "adid");
                return;
            }
            zzb.put("pdid", this.zzggs);
            zzb.put("pdidtype", "ssaid");
        } catch (JSONException e) {
            zzaug.zza("Failed putting Ad ID.", e);
        }
    }
}
