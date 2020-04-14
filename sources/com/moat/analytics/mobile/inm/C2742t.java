package com.moat.analytics.mobile.inm;

import android.graphics.Rect;
import android.view.View;
import com.moat.analytics.mobile.inm.NativeDisplayTracker.MoatUserInteractionType;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.inm.t */
class C2742t extends C2701b implements NativeDisplayTracker {

    /* renamed from: g */
    private final Map<String, String> f6150g;

    /* renamed from: h */
    private final Set<MoatUserInteractionType> f6151h = new HashSet();

    C2742t(View view, Map<String, String> map) {
        C2726m mVar;
        super(view, true, false);
        String str = "NativeDisplayTracker";
        C2735p.m6310a(3, str, (Object) this, "Initializing.");
        this.f6150g = map;
        String str2 = "[ERROR] ";
        String str3 = "NativeDisplayTracker initialization not successful, ";
        if (view == null) {
            String str4 = "Target view is null";
            C2735p.m6311a(str2, 3, str, this, str3.concat(str4));
            mVar = new C2726m(str4);
        } else if (map == null || map.isEmpty()) {
            String str5 = "AdIds is null or empty";
            C2735p.m6311a(str2, 3, str, this, str3.concat(str5));
            mVar = new C2726m(str5);
        } else {
            C2707g gVar = ((C2724k) C2724k.getInstance()).f6103d;
            if (gVar == null) {
                String str6 = "prepareNativeDisplayTracking was not called successfully";
                C2735p.m6311a(str2, 3, str, this, str3.concat(str6));
                mVar = new C2726m(str6);
            } else {
                super.mo29000a(gVar.f6041b);
                try {
                    super.mo28999a(gVar.f6040a);
                    m6335i();
                    StringBuilder sb = new StringBuilder();
                    sb.append(mo28998a());
                    sb.append(" created for ");
                    sb.append(mo29009g());
                    sb.append(", with adIds:");
                    sb.append(map.toString());
                    C2735p.m6313a("[SUCCESS] ", sb.toString());
                    return;
                } catch (C2726m e) {
                    this.f6015a = e;
                    return;
                }
            }
        }
        this.f6015a = mVar;
    }

    /* renamed from: a */
    private static String m6334a(Map<String, String> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < 8; i++) {
            String concat = "moatClientLevel".concat(String.valueOf(i));
            if (map.containsKey(concat)) {
                linkedHashMap.put(concat, map.get(concat));
            }
        }
        for (int i2 = 0; i2 < 8; i2++) {
            String concat2 = "moatClientSlicer".concat(String.valueOf(i2));
            if (map.containsKey(concat2)) {
                linkedHashMap.put(concat2, map.get(concat2));
            }
        }
        for (String str : map.keySet()) {
            if (!linkedHashMap.containsKey(str)) {
                linkedHashMap.put(str, (String) map.get(str));
            }
        }
        return new JSONObject(linkedHashMap).toString();
    }

    /* renamed from: i */
    private void m6335i() {
        if (this.f6017c != null) {
            this.f6017c.mo29052a(m6336j());
        }
    }

    /* renamed from: j */
    private String m6336j() {
        try {
            String a = m6334a(this.f6150g);
            C2735p.m6310a(3, "NativeDisplayTracker", (Object) this, "Parsed ad ids = ".concat(String.valueOf(a)));
            StringBuilder sb = new StringBuilder("{\"adIds\":");
            sb.append(a);
            sb.append(", \"adKey\":\"");
            sb.append(this.f6019e);
            sb.append("\", \"adSize\":");
            sb.append(m6337k());
            sb.append("}");
            return sb.toString();
        } catch (Exception e) {
            C2726m.m6274a(e);
            return "";
        }
    }

    /* renamed from: k */
    private String m6337k() {
        try {
            Rect a = C2765z.m6388a(super.mo29008f());
            int width = a.width();
            int height = a.height();
            HashMap hashMap = new HashMap();
            hashMap.put("width", Integer.toString(width));
            hashMap.put("height", Integer.toString(height));
            return new JSONObject(hashMap).toString();
        } catch (Exception e) {
            C2726m.m6274a(e);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo28998a() {
        return "NativeDisplayTracker";
    }

    public void reportUserInteractionEvent(MoatUserInteractionType moatUserInteractionType) {
        String str = "NativeDisplayTracker";
        try {
            StringBuilder sb = new StringBuilder("reportUserInteractionEvent:");
            sb.append(moatUserInteractionType.name());
            C2735p.m6310a(3, str, (Object) this, sb.toString());
            if (!this.f6151h.contains(moatUserInteractionType)) {
                this.f6151h.add(moatUserInteractionType);
                JSONObject jSONObject = new JSONObject();
                jSONObject.accumulate("adKey", this.f6019e);
                jSONObject.accumulate("event", moatUserInteractionType.name().toLowerCase());
                if (this.f6017c != null) {
                    this.f6017c.mo29056b(jSONObject.toString());
                }
            }
        } catch (JSONException e) {
            C2735p.m6314b(2, str, this, "Got JSON exception");
            C2726m.m6274a(e);
        } catch (Exception e2) {
            C2726m.m6274a(e2);
        }
    }
}
