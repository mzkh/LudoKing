package com.applovin.impl.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.impl.sdk.p019b.C1098e;
import com.applovin.impl.sdk.p021d.C1122a;
import com.applovin.impl.sdk.p021d.C1154p;
import com.applovin.impl.sdk.p021d.C1154p.C1156a;
import com.applovin.impl.sdk.p021d.C1159r.C1161a;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.sdk.AppLovinVariableService;
import com.applovin.sdk.AppLovinVariableService.OnVariablesUpdateListener;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class VariableServiceImpl implements AppLovinVariableService {

    /* renamed from: a */
    private final C1192i f2090a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final AtomicBoolean f2091b = new AtomicBoolean();

    /* renamed from: c */
    private final AtomicBoolean f2092c = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OnVariablesUpdateListener f2093d;

    /* renamed from: e */
    private Bundle f2094e;

    /* renamed from: f */
    private final Object f2095f = new Object();

    VariableServiceImpl(C1192i iVar) {
        this.f2090a = iVar;
        String str = (String) iVar.mo10203a(C1098e.f2562h);
        if (C1277l.m3042b(str)) {
            updateVariables(C1247h.m2974a(str, iVar));
        }
    }

    /* renamed from: a */
    private Object m1909a(String str, Object obj, Class<?> cls) {
        if (TextUtils.isEmpty(str)) {
            C1227o.m2841i("AppLovinVariableService", "Unable to retrieve variable value for empty name");
            return obj;
        }
        if (!this.f2090a.mo10230d()) {
            C1227o.m2840h("AppLovinSdk", "Attempted to retrieve variable before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        synchronized (this.f2095f) {
            if (this.f2094e == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to retrieve variable value for name \"");
                sb.append(str);
                sb.append("\", none retrieved from server yet. Please set a listener to be notified when values are retrieved from the server.");
                C1227o.m2841i("AppLovinVariableService", sb.toString());
                return obj;
            } else if (cls.equals(String.class)) {
                String string = this.f2094e.getString(str, (String) obj);
                return string;
            } else if (cls.equals(Boolean.class)) {
                Boolean valueOf = Boolean.valueOf(this.f2094e.getBoolean(str, ((Boolean) obj).booleanValue()));
                return valueOf;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to retrieve variable value for ");
                sb2.append(str);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1911a() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f2095f
            monitor-enter(r0)
            com.applovin.sdk.AppLovinVariableService$OnVariablesUpdateListener r1 = r4.f2093d     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x001f
            android.os.Bundle r1 = r4.f2094e     // Catch:{ all -> 0x0021 }
            if (r1 != 0) goto L_0x000c
            goto L_0x001f
        L_0x000c:
            android.os.Bundle r1 = r4.f2094e     // Catch:{ all -> 0x0021 }
            java.lang.Object r1 = r1.clone()     // Catch:{ all -> 0x0021 }
            android.os.Bundle r1 = (android.os.Bundle) r1     // Catch:{ all -> 0x0021 }
            r2 = 1
            com.applovin.impl.sdk.VariableServiceImpl$2 r3 = new com.applovin.impl.sdk.VariableServiceImpl$2     // Catch:{ all -> 0x0021 }
            r3.<init>(r1)     // Catch:{ all -> 0x0021 }
            com.applovin.sdk.AppLovinSdkUtils.runOnUiThread(r2, r3)     // Catch:{ all -> 0x0021 }
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            return
        L_0x001f:
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            return
        L_0x0021:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.VariableServiceImpl.m1911a():void");
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        return ((Boolean) m1909a(str, Boolean.valueOf(z), Boolean.class)).booleanValue();
    }

    public String getString(String str) {
        return getString(str, null);
    }

    public String getString(String str, String str2) {
        return (String) m1909a(str, str2, String.class);
    }

    public void loadVariables() {
        String str;
        String str2 = "AppLovinVariableService";
        if (!this.f2090a.mo10230d()) {
            str = "The AppLovin SDK is waiting for the initial variables to be returned upon completing initialization.";
        } else if (this.f2091b.compareAndSet(false, true)) {
            this.f2090a.mo10185K().mo10131a((C1122a) new C1154p(this.f2090a, new C1156a() {
                /* renamed from: a */
                public void mo9733a() {
                    VariableServiceImpl.this.f2091b.set(false);
                }
            }), C1161a.BACKGROUND);
            return;
        } else {
            str = "Ignored explicit variables load. Service is already in the process of retrieving the latest set of variables.";
        }
        C1227o.m2841i(str2, str);
    }

    public void setOnVariablesUpdateListener(OnVariablesUpdateListener onVariablesUpdateListener) {
        this.f2093d = onVariablesUpdateListener;
        synchronized (this.f2095f) {
            if (onVariablesUpdateListener != null) {
                if (this.f2094e != null && this.f2092c.compareAndSet(false, true)) {
                    this.f2090a.mo10249v().mo10378b("AppLovinVariableService", "Setting initial listener");
                    m1911a();
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VariableService{variables=");
        sb.append(this.f2094e);
        sb.append(", listener=");
        sb.append(this.f2093d);
        sb.append('}');
        return sb.toString();
    }

    public void updateVariables(JSONObject jSONObject) {
        C1227o v = this.f2090a.mo10249v();
        StringBuilder sb = new StringBuilder();
        sb.append("Updating variables: ");
        sb.append(jSONObject);
        sb.append("...");
        v.mo10378b("AppLovinVariableService", sb.toString());
        synchronized (this.f2095f) {
            this.f2094e = C1247h.m2991c(jSONObject);
            m1911a();
            this.f2090a.mo10209a(C1098e.f2562h, jSONObject.toString());
        }
    }
}
