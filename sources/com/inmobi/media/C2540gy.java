package com.inmobi.media;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.gy */
/* compiled from: UidMap */
public class C2540gy {

    /* renamed from: a */
    private Map<String, Boolean> f5572a;

    public C2540gy(Map<String, Boolean> map) {
        this.f5572a = map;
    }

    /* renamed from: a */
    public final HashMap<String, String> mo28483a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("u-id-map", m5438b());
        return hashMap;
    }

    /* renamed from: b */
    private String m5438b() {
        return new JSONObject(m5439c()).toString();
    }

    /* renamed from: c */
    private Map<String, String> m5439c() {
        String str = "GPID";
        HashMap hashMap = new HashMap();
        String str2 = null;
        try {
            if (((Boolean) this.f5572a.get(str)).booleanValue()) {
                C2537gw e = C2538gx.m5429a().mo28481e();
                if (e != null) {
                    str2 = e.mo28478b();
                    if (str2 != null) {
                        hashMap.put(str, str2);
                    }
                }
            }
            m5437a(hashMap, str2);
        } catch (Exception unused) {
            C2540gy.class.getSimpleName();
            m5437a(hashMap, null);
        }
        return hashMap;
    }

    /* renamed from: a */
    private void m5437a(Map<String, String> map, String str) {
        String str2 = "O1";
        String str3 = "UM5";
        try {
            if (((Boolean) this.f5572a.get(str3)).booleanValue() && str == null) {
                C2538gx.m5429a();
                C2538gx.m5429a();
                map.put(str3, C2538gx.m5430a(C2538gx.m5431d(), "MD5"));
            }
            if (((Boolean) this.f5572a.get(str2)).booleanValue() && str == null) {
                C2538gx.m5429a();
                C2538gx.m5429a();
                map.put(str2, C2538gx.m5430a(C2538gx.m5431d(), "SHA-1"));
            }
        } catch (Exception unused) {
            C2540gy.class.getSimpleName();
        }
    }
}
