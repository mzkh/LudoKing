package com.inmobi.media;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.inmobi.media.gt */
/* compiled from: IdentityInfo */
public class C2533gt {

    /* renamed from: a */
    private static final String f5547a = "gt";

    /* renamed from: a */
    public static Map<String, String> m5408a() {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("mk-version", C2506ge.m5316a());
            Boolean f = C2538gx.m5429a().mo28482f();
            if (f != null) {
                hashMap.put("u-id-adt", String.valueOf(f.booleanValue() ? 1 : 0));
            }
            hashMap.put("ts", String.valueOf(Calendar.getInstance().getTimeInMillis()));
            Calendar instance = Calendar.getInstance();
            hashMap.put("tz", String.valueOf(instance.get(15) + instance.get(16)));
            C2535gv a = C2535gv.m5426a();
            HashMap hashMap2 = new HashMap();
            if (a.f5565d && a.f5562a != null) {
                hashMap2.put("u-s-id", a.f5562a);
            }
            hashMap.putAll(hashMap2);
        } catch (Exception unused) {
        }
        return hashMap;
    }
}
