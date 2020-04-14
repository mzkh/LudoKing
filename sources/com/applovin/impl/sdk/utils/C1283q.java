package com.applovin.impl.sdk.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.utils.q */
public class C1283q {

    /* renamed from: a */
    public static final C1283q f3224a = new C1283q();

    /* renamed from: b */
    protected String f3225b;

    /* renamed from: c */
    protected final List<C1283q> f3226c;

    /* renamed from: d */
    private final C1283q f3227d;

    /* renamed from: e */
    private final String f3228e;

    /* renamed from: f */
    private final Map<String, String> f3229f;

    private C1283q() {
        this.f3227d = null;
        String str = "";
        this.f3228e = str;
        this.f3229f = Collections.emptyMap();
        this.f3225b = str;
        this.f3226c = Collections.emptyList();
    }

    public C1283q(String str, Map<String, String> map, C1283q qVar) {
        this.f3227d = qVar;
        this.f3228e = str;
        this.f3229f = Collections.unmodifiableMap(map);
        this.f3226c = new ArrayList();
    }

    /* renamed from: a */
    public String mo10447a() {
        return this.f3228e;
    }

    /* renamed from: a */
    public List<C1283q> mo10448a(String str) {
        if (str != null) {
            ArrayList arrayList = new ArrayList(this.f3226c.size());
            for (C1283q qVar : this.f3226c) {
                if (str.equalsIgnoreCase(qVar.mo10447a())) {
                    arrayList.add(qVar);
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException("No name specified.");
    }

    /* renamed from: b */
    public C1283q mo10449b(String str) {
        if (str != null) {
            for (C1283q qVar : this.f3226c) {
                if (str.equalsIgnoreCase(qVar.mo10447a())) {
                    return qVar;
                }
            }
            return null;
        }
        throw new IllegalArgumentException("No name specified.");
    }

    /* renamed from: b */
    public Map<String, String> mo10450b() {
        return this.f3229f;
    }

    /* renamed from: c */
    public C1283q mo10451c(String str) {
        if (str != null) {
            if (this.f3226c.size() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this);
                while (!arrayList.isEmpty()) {
                    C1283q qVar = (C1283q) arrayList.get(0);
                    arrayList.remove(0);
                    if (str.equalsIgnoreCase(qVar.mo10447a())) {
                        return qVar;
                    }
                    arrayList.addAll(qVar.mo10453d());
                }
            }
            return null;
        }
        throw new IllegalArgumentException("No name specified.");
    }

    /* renamed from: c */
    public String mo10452c() {
        return this.f3225b;
    }

    /* renamed from: d */
    public List<C1283q> mo10453d() {
        return Collections.unmodifiableList(this.f3226c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("XmlNode{elementName='");
        sb.append(this.f3228e);
        sb.append('\'');
        sb.append(", text='");
        sb.append(this.f3225b);
        sb.append('\'');
        sb.append(", attributes=");
        sb.append(this.f3229f);
        sb.append('}');
        return sb.toString();
    }
}
