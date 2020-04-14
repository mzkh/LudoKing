package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzq;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaex implements zzaer<Object> {
    private final Object lock = new Object();
    @GuardedBy("lock")
    private final Map<String, zzaez> zzcye = new HashMap();

    public final void zza(String str, zzaez zzaez) {
        synchronized (this.lock) {
            this.zzcye.put(str, zzaez);
        }
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str;
        String str2 = (String) map.get("id");
        String str3 = (String) map.get("fail");
        String str4 = (String) map.get("fail_reason");
        String str5 = (String) map.get("fail_stack");
        String str6 = (String) map.get("result");
        if (TextUtils.isEmpty(str5)) {
            str4 = "Unknown Fail Reason.";
        }
        if (TextUtils.isEmpty(str5)) {
            str = "";
        } else {
            String str7 = "\n";
            String valueOf = String.valueOf(str5);
            str = valueOf.length() != 0 ? str7.concat(valueOf) : new String(str7);
        }
        synchronized (this.lock) {
            zzaez zzaez = (zzaez) this.zzcye.remove(str2);
            if (zzaez == null) {
                String str8 = "Received result for unexpected method invocation: ";
                String valueOf2 = String.valueOf(str2);
                zzaug.zzeu(valueOf2.length() != 0 ? str8.concat(valueOf2) : new String(str8));
            } else if (!TextUtils.isEmpty(str3)) {
                String valueOf3 = String.valueOf(str4);
                String valueOf4 = String.valueOf(str);
                zzaez.onFailure(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3));
            } else if (str6 == null) {
                zzaez.zzc(null);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str6);
                    if (zzaug.zzuu()) {
                        String str9 = "Result GMSG: ";
                        String valueOf5 = String.valueOf(jSONObject.toString(2));
                        zzaug.zzdy(valueOf5.length() != 0 ? str9.concat(valueOf5) : new String(str9));
                    }
                    zzaez.zzc(jSONObject);
                } catch (JSONException e) {
                    zzaez.onFailure(e.getMessage());
                }
            }
        }
    }

    public final <EngineT extends zzahk> zzddi<JSONObject> zza(EngineT enginet, String str, JSONObject jSONObject) {
        zzaxv zzaxv = new zzaxv();
        zzq.zzkj();
        String zzvm = zzaul.zzvm();
        zza(zzvm, (zzaez) new zzaew(this, zzaxv));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", zzvm);
            jSONObject2.put("args", jSONObject);
            enginet.zza(str, jSONObject2);
        } catch (Exception e) {
            zzaxv.setException(e);
        }
        return zzaxv;
    }
}
