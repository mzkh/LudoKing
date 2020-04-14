package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzclr {
    private final Executor executor;
    private final Map<String, zzclu> zzgbh = new ConcurrentHashMap();
    private final Map<String, Map<String, List<zzclu>>> zzgbi = new ConcurrentHashMap();
    private JSONObject zzgbj;

    public zzclr(Executor executor2) {
        this.executor = executor2;
    }

    public final void zzaky() {
        zzq.zzkn().zzuh().zzb(new zzclq(this));
        this.executor.execute(new zzclt(this));
    }

    public final Map<String, List<Bundle>> zzs(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return Collections.emptyMap();
        }
        Map map = (Map) this.zzgbi.get(str);
        if (map == null) {
            return Collections.emptyMap();
        }
        List<zzclu> list = (List) map.get(str2);
        if (list == null) {
            String str3 = "";
            if (((Boolean) zzuv.zzon().zzd(zzza.zzcmk)).booleanValue()) {
                JSONObject jSONObject = this.zzgbj;
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray(str);
                    if (optJSONArray != null) {
                        int i = 0;
                        while (true) {
                            if (i >= optJSONArray.length()) {
                                break;
                            }
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                JSONArray optJSONArray2 = optJSONObject.optJSONArray("including");
                                JSONArray optJSONArray3 = optJSONObject.optJSONArray("excluding");
                                if (zza(optJSONArray2, str2) && !zza(optJSONArray3, str2)) {
                                    str3 = optJSONObject.optString("effective_ad_unit_id", str3);
                                    break;
                                }
                            }
                            i++;
                        }
                    }
                }
            }
            list = (List) map.get(str3);
        }
        if (list == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        for (zzclu zzclu : list) {
            String str4 = zzclu.zzffi;
            if (!hashMap.containsKey(str4)) {
                hashMap.put(str4, new ArrayList());
            }
            ((List) hashMap.get(str4)).add(zzclu.zzeik);
        }
        return hashMap;
    }

    public final void zzgd(String str) {
        if (!TextUtils.isEmpty(str) && !this.zzgbh.containsKey(str)) {
            this.zzgbh.put(str, new zzclu(str, "", new Bundle()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzakz */
    public final synchronized void zzalc() {
        JSONObject zzuq = zzq.zzkn().zzuh().zzve().zzuq();
        if (zzuq != null) {
            try {
                JSONArray optJSONArray = zzuq.optJSONArray("ad_unit_id_settings");
                this.zzgbj = zzuq.optJSONObject("ad_unit_patterns");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i);
                        String optString = jSONObject.optString("ad_unit_id", "");
                        String optString2 = jSONObject.optString("format", "");
                        ArrayList arrayList = new ArrayList();
                        JSONObject optJSONObject = jSONObject.optJSONObject("mediation_config");
                        if (optJSONObject != null) {
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("ad_networks");
                            if (optJSONArray2 != null) {
                                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                                    ArrayList arrayList2 = new ArrayList();
                                    if (jSONObject2 != null) {
                                        JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                                        Bundle bundle = new Bundle();
                                        if (optJSONObject2 != null) {
                                            Iterator keys = optJSONObject2.keys();
                                            while (keys.hasNext()) {
                                                String str = (String) keys.next();
                                                bundle.putString(str, optJSONObject2.optString(str, ""));
                                            }
                                        }
                                        JSONArray optJSONArray3 = jSONObject2.optJSONArray("rtb_adapters");
                                        if (optJSONArray3 != null) {
                                            ArrayList arrayList3 = new ArrayList();
                                            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                                                String optString3 = optJSONArray3.optString(i3, "");
                                                if (!TextUtils.isEmpty(optString3)) {
                                                    arrayList3.add(optString3);
                                                }
                                            }
                                            ArrayList arrayList4 = arrayList3;
                                            int size = arrayList4.size();
                                            int i4 = 0;
                                            while (i4 < size) {
                                                Object obj = arrayList4.get(i4);
                                                i4++;
                                                String str2 = (String) obj;
                                                zzgd(str2);
                                                if (((zzclu) this.zzgbh.get(str2)) != null) {
                                                    arrayList2.add(new zzclu(str2, optString2, bundle));
                                                }
                                            }
                                        }
                                    }
                                    arrayList.addAll(arrayList2);
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString)) {
                            Map map = (Map) this.zzgbi.get(optString2);
                            if (map == null) {
                                map = new ConcurrentHashMap();
                            }
                            this.zzgbi.put(optString2, map);
                            List list = (List) map.get(optString);
                            if (list == null) {
                                list = new ArrayList();
                            }
                            list.addAll(arrayList);
                            map.put(optString, list);
                        }
                    }
                }
            } catch (JSONException e) {
                zzaug.zza("Malformed config loading JSON.", e);
            }
        }
    }

    private static boolean zza(JSONArray jSONArray, String str) {
        if (!(jSONArray == null || str == null)) {
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    if (Pattern.compile(jSONArray.optString(i)).matcher(str).lookingAt()) {
                        return true;
                    }
                    i++;
                } catch (PatternSyntaxException e) {
                    zzq.zzkn().zza(e, "RtbAdapterMap.hasAtleastOneRegexMatch");
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzalb() {
        this.executor.execute(new zzcls(this));
    }
}
