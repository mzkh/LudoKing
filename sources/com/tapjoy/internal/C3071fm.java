package com.tapjoy.internal;

import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.C1823gf.C1825a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.fm */
public class C3071fm extends C3078fq {

    /* renamed from: c */
    private static final String f7242c = "fm";

    public C3071fm(String str, String str2) {
        super(str, str2, "ad");
    }

    /* renamed from: a */
    public final C1825a mo30130a(String str, JSONObject jSONObject) {
        return mo30142a(str, m7095a(jSONObject), m7096b(jSONObject));
    }

    /* renamed from: b */
    public final C1825a mo30131b(String str, JSONObject jSONObject) {
        return mo30145b(str, m7095a(jSONObject), m7096b(jSONObject));
    }

    /* renamed from: a */
    public static Map m7095a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(String.USAGE_TRACKER_DIMENSIONS);
                Iterator keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    hashMap.put(str, jSONObject2.get(str));
                }
            } catch (JSONException e) {
                String str2 = f7242c;
                StringBuilder sb = new StringBuilder("Unable to getAdUnitDimensions. Invalid params: ");
                sb.append(e);
                TapjoyLog.m6550d(str2, sb.toString());
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    public static Map m7096b(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(String.USAGE_TRACKER_VALUES);
                Iterator keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    hashMap.put(str, Long.valueOf(jSONObject2.getLong(str)));
                }
            } catch (JSONException e) {
                String str2 = f7242c;
                StringBuilder sb = new StringBuilder("Unable to getAdUnitValues. Invalid params: ");
                sb.append(e);
                TapjoyLog.m6550d(str2, sb.toString());
            }
        }
        return hashMap;
    }
}
