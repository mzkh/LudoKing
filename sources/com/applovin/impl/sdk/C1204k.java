package com.applovin.impl.sdk;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.applovin.impl.sdk.k */
public class C1204k {

    /* renamed from: a */
    private final String f3026a = UUID.randomUUID().toString();

    /* renamed from: b */
    private final String f3027b;

    /* renamed from: c */
    private final Map<String, Object> f3028c;

    /* renamed from: d */
    private final long f3029d;

    public C1204k(String str, Map<String, String> map, Map<String, Object> map2) {
        this.f3027b = str;
        this.f3028c = new HashMap();
        this.f3028c.putAll(map);
        this.f3028c.put("applovin_sdk_super_properties", map2);
        this.f3029d = System.currentTimeMillis();
    }

    /* renamed from: a */
    public String mo10265a() {
        return this.f3027b;
    }

    /* renamed from: b */
    public Map<String, Object> mo10266b() {
        return this.f3028c;
    }

    /* renamed from: c */
    public long mo10267c() {
        return this.f3029d;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1204k kVar = (C1204k) obj;
        if (this.f3029d != kVar.f3029d) {
            return false;
        }
        String str = this.f3027b;
        if (str == null ? kVar.f3027b != null : !str.equals(kVar.f3027b)) {
            return false;
        }
        Map<String, Object> map = this.f3028c;
        if (map == null ? kVar.f3028c != null : !map.equals(kVar.f3028c)) {
            return false;
        }
        String str2 = this.f3026a;
        if (str2 == null ? kVar.f3026a != null : !str2.equals(kVar.f3026a)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        String str = this.f3027b;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, Object> map = this.f3028c;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        long j = this.f3029d;
        int i2 = (hashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
        String str2 = this.f3026a;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Event{name='");
        sb.append(this.f3027b);
        sb.append('\'');
        sb.append(", id='");
        sb.append(this.f3026a);
        sb.append('\'');
        sb.append(", creationTimestampMillis=");
        sb.append(this.f3029d);
        sb.append(", parameters=");
        sb.append(this.f3028c);
        sb.append('}');
        return sb.toString();
    }
}
