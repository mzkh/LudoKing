package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final /* synthetic */ class zzagu {
    public static void zza(zzagv zzagv, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zzagv.zzk(str, jSONObject.toString());
    }

    public static void zza(zzagv zzagv, String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("(");
        sb.append(str2);
        sb.append(");");
        zzagv.zzct(sb.toString());
    }

    public static void zzb(zzagv zzagv, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String str2 = "Dispatching AFMA event: ";
        String valueOf = String.valueOf(sb.toString());
        zzaug.zzdv(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        zzagv.zzct(sb.toString());
    }

    public static void zza(zzagv zzagv, String str, Map map) {
        try {
            zzagv.zzb(str, zzq.zzkj().zzi(map));
        } catch (JSONException unused) {
            zzaug.zzeu("Could not convert parameters to JSON.");
        }
    }
}
