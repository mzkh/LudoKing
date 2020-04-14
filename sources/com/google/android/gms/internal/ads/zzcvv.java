package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import android.util.JsonWriter;
import androidx.annotation.Nullable;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcvv implements zzawh {
    @Nullable
    public final String zzdhz = this.zzgjw.optString("ad_base_url", null);
    @Nullable
    public final String zzdib = this.zzgjw.optString("ad_html", null);
    public final JSONObject zzfjj = this.zzgjw.optJSONObject("ad_json");
    private final JSONObject zzgjw;

    zzcvv(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        this.zzgjw = zzawg.zzc(jsonReader);
    }

    public final void zza(JsonWriter jsonWriter) throws IOException {
        zzawg.zza(jsonWriter, this.zzgjw);
    }
}
