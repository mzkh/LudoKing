package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.internal.zzq;
import java.io.IOException;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcnl {
    public final String zzgdr;
    public String zzgds;

    public zzcnl(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        jsonReader.beginObject();
        String str = "";
        String str2 = str;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName == null) {
                nextName = str;
            }
            char c = 65535;
            if (nextName.hashCode() == -995427962 && nextName.equals(NativeProtocol.WEB_DIALOG_PARAMS)) {
                c = 0;
            }
            if (c != 0) {
                jsonReader.skipValue();
            } else {
                str2 = jsonReader.nextString();
            }
        }
        this.zzgdr = str2;
        jsonReader.endObject();
    }

    /* access modifiers changed from: 0000 */
    public final zzcnl zzn(Bundle bundle) {
        try {
            this.zzgds = zzq.zzkj().zzd(bundle).toString();
        } catch (JSONException unused) {
            this.zzgds = "{}";
        }
        return this;
    }
}
