package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.unity.purchasing.googleplay.Consts;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcvt {
    public final int responseCode;
    public final String zzbzn;
    public final List<String> zzdcb;
    public final String zzdlq;
    public final long zzfvu;
    public final int zzgju;

    zzcvt(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        List<String> emptyList = Collections.emptyList();
        jsonReader.beginObject();
        String str = "";
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str2 = str;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if ("nofill_urls".equals(nextName)) {
                emptyList = zzawg.zza(jsonReader);
            } else if ("refresh_interval".equals(nextName)) {
                i = jsonReader.nextInt();
            } else if ("gws_query_id".equals(nextName)) {
                str = jsonReader.nextString();
            } else if ("analytics_query_ad_event_id".equals(nextName)) {
                str2 = jsonReader.nextString();
            } else if (Consts.INAPP_RESPONSE_CODE.equals(nextName)) {
                i2 = jsonReader.nextInt();
            } else if ("latency".equals(nextName)) {
                j = jsonReader.nextLong();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        this.zzdcb = emptyList;
        this.zzgju = i;
        this.zzbzn = str;
        this.zzdlq = str2;
        this.responseCode = i2;
        this.zzfvu = j;
    }
}
