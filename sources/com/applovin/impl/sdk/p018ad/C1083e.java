package com.applovin.impl.sdk.p018ad;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p019b.C1098e;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1277l;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ad.e */
public class C1083e {

    /* renamed from: a */
    private final C1192i f2205a;

    /* renamed from: b */
    private final C1227o f2206b;

    /* renamed from: c */
    private LinkedHashSet<C1082d> f2207c;

    /* renamed from: d */
    private final Object f2208d = new Object();

    /* renamed from: e */
    private volatile boolean f2209e;

    public C1083e(C1192i iVar) {
        this.f2205a = iVar;
        this.f2206b = iVar.mo10249v();
        this.f2207c = m2023b();
    }

    /* renamed from: b */
    private LinkedHashSet<C1082d> m2023b() {
        String str = "Retrieved persisted zones: ";
        String str2 = "AdZoneManager";
        LinkedHashSet<C1082d> linkedHashSet = new LinkedHashSet<>();
        try {
            String str3 = (String) this.f2205a.mo10203a(C1098e.f2572r);
            if (C1277l.m3042b(str3)) {
                JSONArray jSONArray = new JSONArray(str3);
                if (jSONArray.length() > 0) {
                    linkedHashSet = m2024b(jSONArray);
                } else {
                    C1227o oVar = this.f2206b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unable to inflate json string: ");
                    sb.append(str3);
                    oVar.mo10378b(str2, sb.toString());
                }
            }
            if (!linkedHashSet.isEmpty()) {
                C1227o oVar2 = this.f2206b;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(linkedHashSet);
                oVar2.mo10378b(str2, sb2.toString());
                Iterator it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    ((C1082d) it.next()).mo9847a(this.f2205a);
                }
            }
        } catch (Throwable th) {
            if (!linkedHashSet.isEmpty()) {
                C1227o oVar3 = this.f2206b;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(linkedHashSet);
                oVar3.mo10378b(str2, sb3.toString());
                Iterator it2 = linkedHashSet.iterator();
                while (it2.hasNext()) {
                    ((C1082d) it2.next()).mo9847a(this.f2205a);
                }
            }
            throw th;
        }
        return linkedHashSet;
    }

    /* renamed from: b */
    private LinkedHashSet<C1082d> m2024b(JSONArray jSONArray) {
        LinkedHashSet<C1082d> linkedHashSet = new LinkedHashSet<>(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject a = C1247h.m2977a(jSONArray, i, (JSONObject) null, this.f2205a);
            C1227o oVar = this.f2206b;
            StringBuilder sb = new StringBuilder();
            sb.append("Loading zone: ");
            sb.append(C1247h.m2968a(a, this.f2205a));
            sb.append("...");
            oVar.mo10378b("AdZoneManager", sb.toString());
            linkedHashSet.add(C1082d.m1999a(C1247h.m2985b(a, "id", (String) null, this.f2205a), a, this.f2205a));
        }
        return linkedHashSet;
    }

    /* renamed from: c */
    private void m2025c(JSONArray jSONArray) {
        if (((Boolean) this.f2205a.mo10202a(C1096c.f2454dL)).booleanValue()) {
            this.f2206b.mo10378b("AdZoneManager", "Persisting zones...");
            this.f2205a.mo10209a(C1098e.f2572r, jSONArray.toString());
        }
    }

    /* renamed from: a */
    public LinkedHashSet<C1082d> mo9860a() {
        LinkedHashSet<C1082d> linkedHashSet;
        synchronized (this.f2208d) {
            linkedHashSet = this.f2207c;
        }
        return linkedHashSet;
    }

    /* renamed from: a */
    public LinkedHashSet<C1082d> mo9861a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return new LinkedHashSet<>();
        }
        LinkedHashSet<C1082d> linkedHashSet = new LinkedHashSet<>(jSONArray.length());
        LinkedHashSet<C1082d> linkedHashSet2 = null;
        synchronized (this.f2208d) {
            if (!this.f2209e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Found ");
                sb.append(jSONArray.length());
                sb.append(" zone(s)...");
                this.f2206b.mo10378b("AdZoneManager", sb.toString());
                linkedHashSet2 = m2024b(jSONArray);
                linkedHashSet = new LinkedHashSet<>(linkedHashSet2);
                linkedHashSet.removeAll(this.f2207c);
                this.f2207c = linkedHashSet2;
                this.f2209e = true;
            }
        }
        if (linkedHashSet2 != null) {
            m2025c(jSONArray);
            this.f2206b.mo10378b("AdZoneManager", "Finished loading zones");
        }
        return linkedHashSet;
    }

    /* renamed from: a */
    public boolean mo9862a(C1082d dVar) {
        boolean contains;
        synchronized (this.f2208d) {
            contains = this.f2207c.contains(dVar);
        }
        return contains;
    }
}
