package com.inmobi.media;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.ba */
/* compiled from: GMAManager */
public final class C2212ba {
    @NonNull

    /* renamed from: a */
    public C2620l f4514a;
    @NonNull

    /* renamed from: b */
    public String f4515b;
    @Nullable

    /* renamed from: c */
    public C2213bb f4516c;

    /* renamed from: d */
    private long f4517d;

    public C2212ba(@NonNull C2620l lVar, @NonNull String str) {
        this.f4514a = lVar;
        this.f4515b = str;
    }

    /* renamed from: a */
    public final byte[] mo27938a() throws C2209ay {
        this.f4516c = new C2213bb(this.f4514a.mo28791z());
        this.f4517d = System.currentTimeMillis();
        try {
            C2213bb bbVar = this.f4516c;
            HashMap hashMap = new HashMap();
            hashMap.put("h-user-agent", C2505gd.m5311i());
            JSONArray jSONArray = new JSONArray();
            if (bbVar.f4519b != null) {
                C2451ez ezVar = (C2451ez) C2438es.m5087a("pk", C2505gd.m5306f(), null);
                for (C2153ac acVar : bbVar.f4519b) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("adSetId", acVar.mo27814e());
                    C2276cf cfVar = bbVar.f4518a.f4657f;
                    float k = acVar.mo27820k();
                    String a = C2524gn.m5374a(String.valueOf(k), cfVar.f4781b, cfVar.f4780a, cfVar.f4782c, ezVar.f5295b, ezVar.f5294a);
                    String str = "bid";
                    if (a == null) {
                        a = "";
                    }
                    jSONObject.put(str, a);
                    JSONObject n = acVar.mo27823n();
                    String str2 = "cachedAdData";
                    if (n == null) {
                        n = new JSONObject();
                    }
                    jSONObject.put(str2, n);
                    jSONArray.put(jSONObject);
                }
            }
            hashMap.put("cachedAdInfos", jSONArray.toString());
            bbVar.f4518a.mo28410c(hashMap);
            bbVar.f4518a.mo27984a();
            if (bbVar.f4518a.f5447s == 1) {
                return bbVar.f4518a.mo28415h().getBytes();
            }
            throw new C2209ay();
        } catch (JSONException unused) {
            return null;
        }
    }
}
