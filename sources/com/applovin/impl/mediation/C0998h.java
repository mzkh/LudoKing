package com.applovin.impl.mediation;

import android.text.TextUtils;
import com.applovin.impl.mediation.p014b.C0962e;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapters.MediationAdapterBase;
import com.applovin.sdk.AppLovinSdk;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.applovin.impl.mediation.h */
public class C0998h {

    /* renamed from: a */
    private final C1192i f1920a;

    /* renamed from: b */
    private final C1227o f1921b;

    /* renamed from: c */
    private final Object f1922c = new Object();

    /* renamed from: d */
    private final Map<String, Class<? extends MaxAdapter>> f1923d = new HashMap();

    /* renamed from: e */
    private final Set<String> f1924e = new HashSet();

    public C0998h(C1192i iVar) {
        if (iVar != null) {
            this.f1920a = iVar;
            this.f1921b = iVar.mo10249v();
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* renamed from: a */
    private C0999i m1786a(C0962e eVar, Class<? extends MaxAdapter> cls) {
        String str = "MediationAdapterManager";
        try {
            C0999i iVar = new C0999i(eVar, (MediationAdapterBase) cls.getConstructor(new Class[]{AppLovinSdk.class}).newInstance(new Object[]{this.f1920a.mo10193S()}), this.f1920a);
            if (iVar.mo9557c()) {
                return iVar;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Adapter is disabled after initialization: ");
            sb.append(eVar);
            C1227o.m2841i(str, sb.toString());
            return null;
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to load adapter: ");
            sb2.append(eVar);
            C1227o.m2837c(str, sb2.toString(), th);
        }
    }

    /* renamed from: a */
    private Class<? extends MaxAdapter> m1787a(String str) {
        String str2 = "MediationAdapterManager";
        try {
            Class cls = Class.forName(str);
            if (MaxAdapter.class.isAssignableFrom(cls)) {
                return cls.asSubclass(MaxAdapter.class);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" error: not an instance of '");
            sb.append(MaxAdapter.class.getName());
            sb.append("'.");
            C1227o.m2841i(str2, sb.toString());
            return null;
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to load: ");
            sb2.append(str);
            C1227o.m2837c(str2, sb2.toString(), th);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0999i mo9547a(C0962e eVar) {
        Class cls;
        C1227o oVar;
        String sb;
        if (eVar != null) {
            String z = eVar.mo9495z();
            String y = eVar.mo9494y();
            if (TextUtils.isEmpty(z)) {
                oVar = this.f1921b;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("No adapter name provided for ");
                sb2.append(y);
                sb2.append(", not loading the adapter ");
                sb = sb2.toString();
            } else if (TextUtils.isEmpty(y)) {
                oVar = this.f1921b;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Unable to find default classname for '");
                sb3.append(z);
                sb3.append("'");
                sb = sb3.toString();
            } else {
                synchronized (this.f1922c) {
                    if (!this.f1924e.contains(y)) {
                        if (this.f1923d.containsKey(y)) {
                            cls = (Class) this.f1923d.get(y);
                        } else {
                            cls = m1787a(y);
                            if (cls == null) {
                                this.f1924e.add(y);
                                return null;
                            }
                        }
                        C0999i a = m1786a(eVar, cls);
                        if (a != null) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("Loaded ");
                            sb4.append(z);
                            this.f1921b.mo10378b("MediationAdapterManager", sb4.toString());
                            this.f1923d.put(y, cls);
                            return a;
                        }
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Failed to load ");
                        sb5.append(z);
                        this.f1921b.mo10382e("MediationAdapterManager", sb5.toString());
                        this.f1924e.add(y);
                        return null;
                    }
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Not attempting to load ");
                    sb6.append(z);
                    sb6.append(" due to prior errors");
                    this.f1921b.mo10378b("MediationAdapterManager", sb6.toString());
                    return null;
                }
            }
            oVar.mo10382e("MediationAdapterManager", sb);
            return null;
        }
        throw new IllegalArgumentException("No adapter spec specified");
    }

    /* renamed from: a */
    public Collection<String> mo9548a() {
        Set unmodifiableSet;
        synchronized (this.f1922c) {
            HashSet hashSet = new HashSet(this.f1923d.size());
            for (Class name : this.f1923d.values()) {
                hashSet.add(name.getName());
            }
            unmodifiableSet = Collections.unmodifiableSet(hashSet);
        }
        return unmodifiableSet;
    }

    /* renamed from: b */
    public Collection<String> mo9549b() {
        Set unmodifiableSet;
        synchronized (this.f1922c) {
            unmodifiableSet = Collections.unmodifiableSet(this.f1924e);
        }
        return unmodifiableSet;
    }
}
