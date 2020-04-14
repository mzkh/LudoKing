package com.applovin.impl.sdk.p019b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.utils.C1243d;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkSettings;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.b.d */
public class C1097d {

    /* renamed from: a */
    protected final C1192i f2549a;

    /* renamed from: b */
    protected final C1227o f2550b;

    /* renamed from: c */
    protected final Context f2551c;

    /* renamed from: d */
    protected final SharedPreferences f2552d;

    /* renamed from: e */
    private final Map<String, Object> f2553e = new HashMap();

    /* renamed from: f */
    private Map<String, Object> f2554f;

    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0035 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C1097d(com.applovin.impl.sdk.C1192i r4) {
        /*
            r3 = this;
            r3.<init>()
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r3.f2553e = r0
            r3.f2549a = r4
            com.applovin.impl.sdk.o r0 = r4.mo10249v()
            r3.f2550b = r0
            android.content.Context r0 = r4.mo10179D()
            r3.f2551c = r0
            android.content.Context r0 = r3.f2551c
            java.lang.String r1 = "com.applovin.sdk.1"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            r3.f2552d = r0
            java.lang.Class<com.applovin.impl.sdk.b.c> r0 = com.applovin.impl.sdk.p019b.C1096c.class
            java.lang.String r0 = r0.getName()     // Catch:{ Throwable -> 0x0035 }
            java.lang.Class.forName(r0)     // Catch:{ Throwable -> 0x0035 }
            java.lang.Class<com.applovin.impl.sdk.b.b> r0 = com.applovin.impl.sdk.p019b.C1095b.class
            java.lang.String r0 = r0.getName()     // Catch:{ Throwable -> 0x0035 }
            java.lang.Class.forName(r0)     // Catch:{ Throwable -> 0x0035 }
        L_0x0035:
            com.applovin.sdk.AppLovinSdkSettings r0 = r4.mo10238l()     // Catch:{ Throwable -> 0x0053 }
            java.lang.Class r0 = r0.getClass()     // Catch:{ Throwable -> 0x0053 }
            java.lang.String r1 = "localSettings"
            java.lang.reflect.Field r0 = com.applovin.impl.sdk.utils.C1281o.m3077a(r0, r1)     // Catch:{ Throwable -> 0x0053 }
            r1 = 1
            r0.setAccessible(r1)     // Catch:{ Throwable -> 0x0053 }
            com.applovin.sdk.AppLovinSdkSettings r4 = r4.mo10238l()     // Catch:{ Throwable -> 0x0053 }
            java.lang.Object r4 = r0.get(r4)     // Catch:{ Throwable -> 0x0053 }
            java.util.HashMap r4 = (java.util.HashMap) r4     // Catch:{ Throwable -> 0x0053 }
            r3.f2554f = r4     // Catch:{ Throwable -> 0x0053 }
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.p019b.C1097d.<init>(com.applovin.impl.sdk.i):void");
    }

    /* renamed from: a */
    private static Object m2132a(String str, JSONObject jSONObject, Object obj) throws JSONException {
        if (obj instanceof Boolean) {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        }
        if (obj instanceof Float) {
            return Float.valueOf((float) jSONObject.getDouble(str));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(jSONObject.getInt(str));
        }
        if (obj instanceof Long) {
            return Long.valueOf(jSONObject.getLong(str));
        }
        if (obj instanceof String) {
            return jSONObject.getString(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SDK Error: unknown value type: ");
        sb.append(obj.getClass());
        throw new RuntimeException(sb.toString());
    }

    /* renamed from: c */
    private <T> T m2133c(C1096c<T> cVar) {
        try {
            return cVar.mo9946a(this.f2554f.get(cVar.mo9947a()));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: e */
    private String m2134e() {
        StringBuilder sb = new StringBuilder();
        sb.append("com.applovin.sdk.");
        sb.append(C1281o.m3075a(this.f2549a.mo10246t()));
        sb.append(".");
        return sb.toString();
    }

    /* renamed from: a */
    public <ST> C1096c<ST> mo9950a(String str, C1096c<ST> cVar) {
        for (C1096c<ST> cVar2 : C1096c.m2128c()) {
            if (cVar2.mo9947a().equals(str)) {
                return cVar2;
            }
        }
        return cVar;
    }

    /* renamed from: a */
    public <T> T mo9951a(C1096c<T> cVar) {
        if (cVar != null) {
            synchronized (this.f2553e) {
                try {
                    T c = m2133c(cVar);
                    if (c != null) {
                        return c;
                    }
                    Object obj = this.f2553e.get(cVar.mo9947a());
                    if (obj != null) {
                        T a = cVar.mo9946a(obj);
                        return a;
                    }
                    T b = cVar.mo9948b();
                    return b;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else {
            throw new IllegalArgumentException("No setting type specified");
        }
    }

    /* renamed from: a */
    public void mo9952a() {
        if (this.f2551c != null) {
            String e = m2134e();
            synchronized (this.f2553e) {
                Editor edit = this.f2552d.edit();
                for (C1096c cVar : C1096c.m2128c()) {
                    Object obj = this.f2553e.get(cVar.mo9947a());
                    if (obj != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(e);
                        sb.append(cVar.mo9947a());
                        this.f2549a.mo10215a(sb.toString(), obj, edit);
                    }
                }
                edit.apply();
            }
            return;
        }
        throw new IllegalArgumentException("No context specified");
    }

    /* renamed from: a */
    public <T> void mo9953a(C1096c<?> cVar, Object obj) {
        if (cVar == null) {
            throw new IllegalArgumentException("No setting type specified");
        } else if (obj != null) {
            synchronized (this.f2553e) {
                this.f2553e.put(cVar.mo9947a(), obj);
            }
        } else {
            throw new IllegalArgumentException("No new value specified");
        }
    }

    /* renamed from: a */
    public void mo9954a(AppLovinSdkSettings appLovinSdkSettings) {
        boolean z;
        boolean z2;
        if (appLovinSdkSettings != null) {
            synchronized (this.f2553e) {
                if (((Boolean) this.f2549a.mo10202a(C1096c.f2279U)).booleanValue()) {
                    this.f2553e.put(C1096c.f2279U.mo9947a(), Boolean.valueOf(appLovinSdkSettings.isVerboseLoggingEnabled()));
                }
                if (((Boolean) this.f2549a.mo10202a(C1096c.f2340bB)).booleanValue()) {
                    String autoPreloadSizes = appLovinSdkSettings.getAutoPreloadSizes();
                    if (!C1277l.m3042b(autoPreloadSizes)) {
                        autoPreloadSizes = "NONE";
                    }
                    if (autoPreloadSizes.equals("NONE")) {
                        this.f2553e.put(C1096c.f2366bb.mo9947a(), "");
                    } else {
                        this.f2553e.put(C1096c.f2366bb.mo9947a(), autoPreloadSizes);
                    }
                }
                if (((Boolean) this.f2549a.mo10202a(C1096c.f2341bC)).booleanValue()) {
                    String autoPreloadTypes = appLovinSdkSettings.getAutoPreloadTypes();
                    if (!C1277l.m3042b(autoPreloadTypes)) {
                        autoPreloadTypes = "NONE";
                    }
                    boolean z3 = false;
                    if (!"NONE".equals(autoPreloadTypes)) {
                        z2 = false;
                        z = false;
                        for (String str : C1243d.m2924a(autoPreloadTypes)) {
                            if (str.equals(AppLovinAdType.REGULAR.getLabel())) {
                                z3 = true;
                            } else {
                                if (!str.equals(AppLovinAdType.INCENTIVIZED.getLabel()) && !str.contains("INCENT")) {
                                    if (!str.contains("REWARD")) {
                                        if (str.equals(AppLovinAdType.NATIVE.getLabel())) {
                                            z = true;
                                        }
                                    }
                                }
                                z2 = true;
                            }
                        }
                    } else {
                        z2 = false;
                        z = false;
                    }
                    if (!z3) {
                        this.f2553e.put(C1096c.f2366bb.mo9947a(), "");
                    }
                    this.f2553e.put(C1096c.f2367bc.mo9947a(), Boolean.valueOf(z2));
                    this.f2553e.put(C1096c.f2368bd.mo9947a(), Boolean.valueOf(z));
                }
            }
        }
    }

    /* renamed from: a */
    public void mo9955a(JSONObject jSONObject) {
        C1227o oVar;
        String str;
        String str2;
        synchronized (this.f2553e) {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                if (str3 != null && str3.length() > 0) {
                    try {
                        C1096c<Long> a = mo9950a(str3, null);
                        if (a != null) {
                            this.f2553e.put(a.mo9947a(), m2132a(str3, jSONObject, a.mo9948b()));
                            if (a == C1096c.f2509eO) {
                                this.f2553e.put(C1096c.f2510eP.mo9947a(), Long.valueOf(System.currentTimeMillis()));
                            }
                        }
                    } catch (JSONException e) {
                        th = e;
                        oVar = this.f2550b;
                        str = "SettingsManager";
                        str2 = "Unable to parse JSON settingsValues array";
                        oVar.mo10379b(str, str2, th);
                    } catch (Throwable th) {
                        th = th;
                        oVar = this.f2550b;
                        str = "SettingsManager";
                        str2 = "Unable to convert setting object ";
                        oVar.mo10379b(str, str2, th);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public List<String> mo9956b(C1096c<String> cVar) {
        return C1243d.m2924a((String) mo9951a(cVar));
    }

    /* renamed from: b */
    public void mo9957b() {
        if (this.f2551c != null) {
            String e = m2134e();
            synchronized (this.f2553e) {
                for (C1096c cVar : C1096c.m2128c()) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append(e);
                        sb.append(cVar.mo9947a());
                        Object a = this.f2549a.mo10204a(sb.toString(), null, cVar.mo9948b().getClass(), this.f2552d);
                        if (a != null) {
                            this.f2553e.put(cVar.mo9947a(), a);
                        }
                    } catch (Exception e2) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Unable to load \"");
                        sb2.append(cVar.mo9947a());
                        sb2.append("\"");
                        this.f2550b.mo10379b("SettingsManager", sb2.toString(), e2);
                    }
                }
            }
            return;
        }
        throw new IllegalArgumentException("No context specified");
    }

    /* renamed from: c */
    public void mo9958c() {
        synchronized (this.f2553e) {
            this.f2553e.clear();
        }
        this.f2549a.mo10207a(this.f2552d);
    }

    /* renamed from: d */
    public boolean mo9959d() {
        return this.f2549a.mo10238l().isVerboseLoggingEnabled() || ((Boolean) mo9951a(C1096c.f2279U)).booleanValue();
    }
}
