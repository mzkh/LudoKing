package com.google.android.gms.internal.ads;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbxb {
    private final Executor executor;
    private final zzbwq zzfob;

    public zzbxb(Executor executor2, zzbwq zzbwq) {
        this.executor = executor2;
        this.zzfob = zzbwq;
    }

    public final zzddi<List<zzbxc>> zzg(JSONObject jSONObject, String str) {
        zzddi zzddi;
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return zzdcy.zzah(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("name");
                if (optString != null) {
                    String optString2 = optJSONObject.optString("type");
                    char c = "string".equals(optString2) ? 1 : MessengerShareContentUtility.MEDIA_IMAGE.equals(optString2) ? (char) 2 : 0;
                    if (c == 1) {
                        zzddi = zzdcy.zzah(new zzbxc(optString, optJSONObject.optString("string_value")));
                    } else if (c == 2) {
                        zzddi = zzdcy.zzb(this.zzfob.zzc(optJSONObject, "image_value"), (zzdal<? super I, ? extends O>) new zzbxd<Object,Object>(optString), this.executor);
                    }
                    arrayList.add(zzddi);
                }
            }
            zzddi = zzdcy.zzah(null);
            arrayList.add(zzddi);
        }
        return zzdcy.zzb(zzdcy.zzg(arrayList), zzbxa.zzdos, this.executor);
    }
}
