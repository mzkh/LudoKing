package com.inmobi.media;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@VisibleForTesting(otherwise = 3)
/* renamed from: com.inmobi.media.ew */
/* compiled from: ConfigNetworkRequest */
public final class C2446ew extends C2486fr {

    /* renamed from: d */
    private static final String f5264d = "ew";

    /* renamed from: e */
    private static String f5265e = "https://config.inmobi.com/config-server/v1/config/secure.cfg";

    /* renamed from: f */
    private static Map<String, String> f5266f;

    /* renamed from: a */
    int f5267a;

    /* renamed from: b */
    int f5268b;

    /* renamed from: c */
    Map<String, C2436er> f5269c;

    C2446ew(Map<String, C2436er> map, C2540gy gyVar, String str, int i, int i2, int i3, @NonNull String str2) {
        this(map, gyVar, str, i, i2, false, i3, str2);
    }

    /* renamed from: a */
    public final void mo27984a() {
        super.mo27984a();
        this.f5439k.put("p", m5112j());
        this.f5439k.put("im-accid", this.f5449u);
        Map<String, String> map = f5266f;
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                if (!this.f5437i.containsKey(entry.getKey())) {
                    this.f5437i.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    /* renamed from: j */
    private String m5112j() {
        new C2442et();
        try {
            JSONArray jSONArray = new JSONArray();
            for (Entry entry : this.f5269c.entrySet()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("n", entry.getKey());
                jSONObject.put("t", ((C2436er) entry.getValue()).f5244n == null ? 0 : C2442et.m5105c((String) entry.getKey(), ((C2436er) entry.getValue()).f5244n));
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    /* renamed from: c */
    public final String mo28353c() {
        return this.f5449u;
    }

    C2446ew(Map<String, C2436er> map, C2540gy gyVar, String str, int i, int i2, boolean z, int i3, @NonNull String str2) {
        String str3 = z ? "https://config.inmobi.com/config-server/v1/config/secure.cfg" : f5265e;
        if ((map.get("root") != null) || str == null || str.trim().length() == 0) {
            str = str3;
        }
        super("POST", str, gyVar, i3);
        this.f5269c = map;
        this.f5267a = i;
        this.f5268b = i2;
        this.f5449u = str2;
    }
}
