package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbbg implements zzaer<zzazj> {
    private static Integer zzb(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt((String) map.get(str)));
        } catch (NumberFormatException unused) {
            String str2 = (String) map.get(str);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 39 + String.valueOf(str2).length());
            sb.append("Precache invalid numeric parameter '");
            sb.append(str);
            sb.append("': ");
            sb.append(str2);
            zzaug.zzeu(sb.toString());
            return null;
        }
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbax zzbax;
        zzazj zzazj = (zzazj) obj;
        if (zzaug.isLoggable(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String valueOf = String.valueOf(jSONObject);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 15);
            sb.append("Precache GMSG: ");
            sb.append(valueOf);
            zzaug.zzdv(sb.toString());
        }
        zzq.zzlf();
        if (map.containsKey("abort")) {
            if (!zzbay.zzc(zzazj)) {
                zzaug.zzeu("Precache abort but no precache task running.");
            }
            return;
        }
        String str = (String) map.get("src");
        if (str != null) {
            String[] strArr = {str};
            String str2 = (String) map.get("demuxed");
            if (str2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str2);
                    String[] strArr2 = new String[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        strArr2[i] = jSONArray.getString(i);
                    }
                    strArr = strArr2;
                } catch (JSONException unused) {
                    String str3 = "Malformed demuxed URL list for precache: ";
                    String valueOf2 = String.valueOf(str2);
                    zzaug.zzeu(valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
                    strArr = null;
                }
            }
            if (strArr == null) {
                strArr = new String[]{str};
            }
            if (zzbay.zzd(zzazj) != null) {
                zzaug.zzeu("Precache task is already running.");
                return;
            } else if (zzazj.zzxo() == null) {
                zzaug.zzeu("Precache requires a dependency provider.");
                return;
            } else {
                zzazk zzazk = new zzazk((String) map.get("flags"));
                Integer zzb = zzb(map, "player");
                if (zzb == null) {
                    zzb = Integer.valueOf(0);
                }
                zzbax = zzazj.zzxo().zzbkn.zza(zzazj, zzb.intValue(), null, zzazk);
                new zzbaw(zzazj, zzbax, str, strArr).zzut();
            }
        } else {
            zzbaw zzd = zzbay.zzd(zzazj);
            if (zzd != null) {
                zzbax = zzd.zzede;
            } else {
                zzaug.zzeu("Precache must specify a source.");
                return;
            }
        }
        Integer zzb2 = zzb(map, "minBufferMs");
        if (zzb2 != null) {
            zzbax.zzcs(zzb2.intValue());
        }
        Integer zzb3 = zzb(map, "maxBufferMs");
        if (zzb3 != null) {
            zzbax.zzct(zzb3.intValue());
        }
        Integer zzb4 = zzb(map, "bufferForPlaybackMs");
        if (zzb4 != null) {
            zzbax.zzcu(zzb4.intValue());
        }
        Integer zzb5 = zzb(map, "bufferForPlaybackAfterRebufferMs");
        if (zzb5 != null) {
            zzbax.zzcv(zzb5.intValue());
        }
    }
}
