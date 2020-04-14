package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p019b.C1096c;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.network.b */
public class C1215b<T> {

    /* renamed from: a */
    private String f3055a;

    /* renamed from: b */
    private String f3056b;

    /* renamed from: c */
    private Map<String, String> f3057c;

    /* renamed from: d */
    private Map<String, String> f3058d;

    /* renamed from: e */
    private final JSONObject f3059e;

    /* renamed from: f */
    private String f3060f;

    /* renamed from: g */
    private final T f3061g;

    /* renamed from: h */
    private final boolean f3062h;

    /* renamed from: i */
    private final int f3063i;

    /* renamed from: j */
    private int f3064j;

    /* renamed from: k */
    private final int f3065k;

    /* renamed from: l */
    private final int f3066l;

    /* renamed from: m */
    private final boolean f3067m;

    /* renamed from: n */
    private final boolean f3068n;

    /* renamed from: com.applovin.impl.sdk.network.b$a */
    public static class C1216a<T> {

        /* renamed from: a */
        String f3069a;

        /* renamed from: b */
        String f3070b;

        /* renamed from: c */
        String f3071c;

        /* renamed from: d */
        Map<String, String> f3072d;

        /* renamed from: e */
        Map<String, String> f3073e;

        /* renamed from: f */
        JSONObject f3074f;

        /* renamed from: g */
        T f3075g;

        /* renamed from: h */
        boolean f3076h = true;

        /* renamed from: i */
        int f3077i = 1;

        /* renamed from: j */
        int f3078j;

        /* renamed from: k */
        int f3079k;

        /* renamed from: l */
        boolean f3080l;

        /* renamed from: m */
        boolean f3081m;

        public C1216a(C1192i iVar) {
            this.f3078j = ((Integer) iVar.mo10202a(C1096c.f2491dw)).intValue();
            this.f3079k = ((Integer) iVar.mo10202a(C1096c.f2490dv)).intValue();
            this.f3080l = ((Boolean) iVar.mo10202a(C1096c.f2507eM)).booleanValue();
            this.f3072d = new HashMap();
        }

        /* renamed from: a */
        public C1216a<T> mo10322a(int i) {
            this.f3077i = i;
            return this;
        }

        /* renamed from: a */
        public C1216a<T> mo10323a(T t) {
            this.f3075g = t;
            return this;
        }

        /* renamed from: a */
        public C1216a<T> mo10324a(String str) {
            this.f3070b = str;
            return this;
        }

        /* renamed from: a */
        public C1216a<T> mo10325a(Map<String, String> map) {
            this.f3072d = map;
            return this;
        }

        /* renamed from: a */
        public C1216a<T> mo10326a(JSONObject jSONObject) {
            this.f3074f = jSONObject;
            return this;
        }

        /* renamed from: a */
        public C1216a<T> mo10327a(boolean z) {
            this.f3080l = z;
            return this;
        }

        /* renamed from: a */
        public C1215b<T> mo10328a() {
            return new C1215b<>(this);
        }

        /* renamed from: b */
        public C1216a<T> mo10329b(int i) {
            this.f3078j = i;
            return this;
        }

        /* renamed from: b */
        public C1216a<T> mo10330b(String str) {
            this.f3069a = str;
            return this;
        }

        /* renamed from: b */
        public C1216a<T> mo10331b(boolean z) {
            this.f3081m = z;
            return this;
        }

        /* renamed from: c */
        public C1216a<T> mo10332c(int i) {
            this.f3079k = i;
            return this;
        }

        /* renamed from: c */
        public C1216a<T> mo10333c(String str) {
            this.f3071c = str;
            return this;
        }
    }

    protected C1215b(C1216a<T> aVar) {
        this.f3055a = aVar.f3070b;
        this.f3056b = aVar.f3069a;
        this.f3057c = aVar.f3072d;
        this.f3058d = aVar.f3073e;
        this.f3059e = aVar.f3074f;
        this.f3060f = aVar.f3071c;
        this.f3061g = aVar.f3075g;
        this.f3062h = aVar.f3076h;
        this.f3063i = aVar.f3077i;
        this.f3064j = aVar.f3077i;
        this.f3065k = aVar.f3078j;
        this.f3066l = aVar.f3079k;
        this.f3067m = aVar.f3080l;
        this.f3068n = aVar.f3081m;
    }

    /* renamed from: a */
    public static <T> C1216a<T> m2733a(C1192i iVar) {
        return new C1216a<>(iVar);
    }

    /* renamed from: a */
    public String mo10302a() {
        return this.f3055a;
    }

    /* renamed from: a */
    public void mo10303a(int i) {
        this.f3064j = i;
    }

    /* renamed from: a */
    public void mo10304a(String str) {
        this.f3055a = str;
    }

    /* renamed from: b */
    public String mo10305b() {
        return this.f3056b;
    }

    /* renamed from: b */
    public void mo10306b(String str) {
        this.f3056b = str;
    }

    /* renamed from: c */
    public Map<String, String> mo10307c() {
        return this.f3057c;
    }

    /* renamed from: d */
    public Map<String, String> mo10308d() {
        return this.f3058d;
    }

    /* renamed from: e */
    public JSONObject mo10309e() {
        return this.f3059e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1215b)) {
            return false;
        }
        C1215b bVar = (C1215b) obj;
        String str = this.f3055a;
        if (str == null ? bVar.f3055a != null : !str.equals(bVar.f3055a)) {
            return false;
        }
        Map<String, String> map = this.f3057c;
        if (map == null ? bVar.f3057c != null : !map.equals(bVar.f3057c)) {
            return false;
        }
        Map<String, String> map2 = this.f3058d;
        if (map2 == null ? bVar.f3058d != null : !map2.equals(bVar.f3058d)) {
            return false;
        }
        String str2 = this.f3060f;
        if (str2 == null ? bVar.f3060f != null : !str2.equals(bVar.f3060f)) {
            return false;
        }
        String str3 = this.f3056b;
        if (str3 == null ? bVar.f3056b != null : !str3.equals(bVar.f3056b)) {
            return false;
        }
        JSONObject jSONObject = this.f3059e;
        if (jSONObject == null ? bVar.f3059e != null : !jSONObject.equals(bVar.f3059e)) {
            return false;
        }
        T t = this.f3061g;
        if (t == null ? bVar.f3061g == null : t.equals(bVar.f3061g)) {
            return this.f3062h == bVar.f3062h && this.f3063i == bVar.f3063i && this.f3064j == bVar.f3064j && this.f3065k == bVar.f3065k && this.f3066l == bVar.f3066l && this.f3067m == bVar.f3067m && this.f3068n == bVar.f3068n;
        }
        return false;
    }

    /* renamed from: f */
    public String mo10311f() {
        return this.f3060f;
    }

    /* renamed from: g */
    public T mo10312g() {
        return this.f3061g;
    }

    /* renamed from: h */
    public boolean mo10313h() {
        return this.f3062h;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f3055a;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f3060f;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f3056b;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        T t = this.f3061g;
        if (t != null) {
            i = t.hashCode();
        }
        int i2 = ((((((((((((((hashCode4 + i) * 31) + (this.f3062h ? 1 : 0)) * 31) + this.f3063i) * 31) + this.f3064j) * 31) + this.f3065k) * 31) + this.f3066l) * 31) + (this.f3067m ? 1 : 0)) * 31) + (this.f3068n ? 1 : 0);
        Map<String, String> map = this.f3057c;
        if (map != null) {
            i2 = (i2 * 31) + map.hashCode();
        }
        Map<String, String> map2 = this.f3058d;
        if (map2 != null) {
            i2 = (i2 * 31) + map2.hashCode();
        }
        JSONObject jSONObject = this.f3059e;
        if (jSONObject == null) {
            return i2;
        }
        char[] charArray = jSONObject.toString().toCharArray();
        Arrays.sort(charArray);
        return (i2 * 31) + new String(charArray).hashCode();
    }

    /* renamed from: i */
    public int mo10315i() {
        return this.f3063i - this.f3064j;
    }

    /* renamed from: j */
    public int mo10316j() {
        return this.f3064j;
    }

    /* renamed from: k */
    public int mo10317k() {
        return this.f3065k;
    }

    /* renamed from: l */
    public int mo10318l() {
        return this.f3066l;
    }

    /* renamed from: m */
    public boolean mo10319m() {
        return this.f3067m;
    }

    /* renamed from: n */
    public boolean mo10320n() {
        return this.f3068n;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HttpRequest {endpoint=");
        sb.append(this.f3055a);
        sb.append(", backupEndpoint=");
        sb.append(this.f3060f);
        sb.append(", httpMethod=");
        sb.append(this.f3056b);
        sb.append(", httpHeaders=");
        sb.append(this.f3058d);
        sb.append(", body=");
        sb.append(this.f3059e);
        sb.append(", emptyResponse=");
        sb.append(this.f3061g);
        sb.append(", requiresResponse=");
        sb.append(this.f3062h);
        sb.append(", initialRetryAttempts=");
        sb.append(this.f3063i);
        sb.append(", retryAttemptsLeft=");
        sb.append(this.f3064j);
        sb.append(", timeoutMillis=");
        sb.append(this.f3065k);
        sb.append(", retryDelayMillis=");
        sb.append(this.f3066l);
        sb.append(", encodingEnabled=");
        sb.append(this.f3067m);
        sb.append(", trackConnectionSpeed=");
        sb.append(this.f3068n);
        sb.append('}');
        return sb.toString();
    }
}
