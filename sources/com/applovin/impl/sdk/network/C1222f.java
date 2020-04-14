package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.utils.C1247h;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.network.f */
public class C1222f {

    /* renamed from: a */
    private String f3093a;

    /* renamed from: b */
    private String f3094b;

    /* renamed from: c */
    private Map<String, String> f3095c;

    /* renamed from: d */
    private Map<String, String> f3096d;

    /* renamed from: e */
    private Map<String, Object> f3097e;

    /* renamed from: f */
    private boolean f3098f;

    /* renamed from: g */
    private int f3099g;

    /* renamed from: com.applovin.impl.sdk.network.f$a */
    public static class C1224a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public String f3100a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public String f3101b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public Map<String, String> f3102c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public Map<String, String> f3103d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public Map<String, Object> f3104e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public boolean f3105f;

        /* renamed from: a */
        public C1224a mo10355a(String str) {
            this.f3100a = str;
            return this;
        }

        /* renamed from: a */
        public C1224a mo10356a(Map<String, String> map) {
            this.f3102c = map;
            return this;
        }

        /* renamed from: a */
        public C1224a mo10357a(boolean z) {
            this.f3105f = z;
            return this;
        }

        /* renamed from: a */
        public C1222f mo10358a() {
            return new C1222f(this);
        }

        /* renamed from: b */
        public C1224a mo10359b(String str) {
            this.f3101b = str;
            return this;
        }

        /* renamed from: b */
        public C1224a mo10360b(Map<String, String> map) {
            this.f3103d = map;
            return this;
        }

        /* renamed from: c */
        public C1224a mo10361c(Map<String, Object> map) {
            this.f3104e = map;
            return this;
        }
    }

    private C1222f(C1224a aVar) {
        this.f3093a = aVar.f3100a;
        this.f3094b = aVar.f3101b;
        this.f3095c = aVar.f3102c;
        this.f3096d = aVar.f3103d;
        this.f3097e = aVar.f3104e;
        this.f3098f = aVar.f3105f;
        this.f3099g = 0;
    }

    C1222f(JSONObject jSONObject, C1192i iVar) throws Exception {
        String string = jSONObject.getString("targetUrl");
        String b = C1247h.m2985b(jSONObject, "backupUrl", "", iVar);
        int i = jSONObject.getInt("attemptNumber");
        String str = "parameters";
        Map<String, String> a = C1247h.m2983a(jSONObject, str) ? C1247h.m2973a(jSONObject.getJSONObject(str)) : Collections.EMPTY_MAP;
        String str2 = "httpHeaders";
        Map<String, String> a2 = C1247h.m2983a(jSONObject, str2) ? C1247h.m2973a(jSONObject.getJSONObject(str2)) : Collections.EMPTY_MAP;
        String str3 = "requestBody";
        Map<String, Object> b2 = C1247h.m2983a(jSONObject, str3) ? C1247h.m2987b(jSONObject.getJSONObject(str3)) : Collections.EMPTY_MAP;
        this.f3093a = string;
        this.f3094b = b;
        this.f3095c = a;
        this.f3096d = a2;
        this.f3097e = b2;
        this.f3098f = jSONObject.optBoolean("isEncodingEnabled", false);
        this.f3099g = i;
    }

    /* renamed from: k */
    public static C1224a m2788k() {
        return new C1224a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo10342a() {
        return this.f3093a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo10343b() {
        return this.f3094b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Map<String, String> mo10344c() {
        return this.f3095c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public Map<String, String> mo10345d() {
        return this.f3096d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public Map<String, Object> mo10346e() {
        return this.f3097e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1222f fVar = (C1222f) obj;
        String str = this.f3093a;
        if (str == null ? fVar.f3093a != null : !str.equals(fVar.f3093a)) {
            return false;
        }
        String str2 = this.f3094b;
        if (str2 == null ? fVar.f3094b != null : !str2.equals(fVar.f3094b)) {
            return false;
        }
        Map<String, String> map = this.f3095c;
        if (map == null ? fVar.f3095c != null : !map.equals(fVar.f3095c)) {
            return false;
        }
        Map<String, String> map2 = this.f3096d;
        if (map2 == null ? fVar.f3096d != null : !map2.equals(fVar.f3096d)) {
            return false;
        }
        Map<String, Object> map3 = this.f3097e;
        if (map3 == null ? fVar.f3097e == null : map3.equals(fVar.f3097e)) {
            return this.f3098f == fVar.f3098f;
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public boolean mo10348f() {
        return this.f3098f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public int mo10349g() {
        return this.f3099g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo10350h() {
        this.f3099g++;
    }

    public int hashCode() {
        String str = this.f3093a;
        int i = 0;
        int hashCode = ((str != null ? str.hashCode() : 0) + 0) * 31;
        String str2 = this.f3094b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Map<String, String> map = this.f3095c;
        int hashCode3 = (hashCode2 + (map != null ? map.hashCode() : 0)) * 31;
        Map<String, String> map2 = this.f3096d;
        int hashCode4 = (hashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<String, Object> map3 = this.f3097e;
        if (map3 != null) {
            i = map3.hashCode();
        }
        return (hashCode4 + i + (this.f3098f ? 1 : 0)) * 31;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public void mo10352i() {
        HashMap hashMap = new HashMap();
        Map<String, String> map = this.f3095c;
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("postback_ts", String.valueOf(System.currentTimeMillis()));
        this.f3095c = hashMap;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public JSONObject mo10353j() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("targetUrl", this.f3093a);
        jSONObject.put("backupUrl", this.f3094b);
        jSONObject.put("isEncodingEnabled", this.f3098f);
        jSONObject.put("attemptNumber", this.f3099g);
        Map<String, String> map = this.f3095c;
        if (map != null) {
            jSONObject.put("parameters", new JSONObject(map));
        }
        Map<String, String> map2 = this.f3096d;
        if (map2 != null) {
            jSONObject.put("httpHeaders", new JSONObject(map2));
        }
        Map<String, Object> map3 = this.f3097e;
        if (map3 != null) {
            jSONObject.put("requestBody", new JSONObject(map3));
        }
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PostbackRequest{targetUrl='");
        sb.append(this.f3093a);
        sb.append('\'');
        sb.append(", backupUrl='");
        sb.append(this.f3094b);
        sb.append('\'');
        sb.append(", attemptNumber=");
        sb.append(this.f3099g);
        sb.append(", isEncodingEnabled=");
        sb.append(this.f3098f);
        sb.append('}');
        return sb.toString();
    }
}
