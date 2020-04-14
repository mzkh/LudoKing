package com.applovin.impl.mediation;

import android.app.Activity;
import com.applovin.impl.mediation.p014b.C0962e;
import com.applovin.impl.mediation.p015c.C0969a;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p021d.C1122a;
import com.applovin.impl.sdk.p021d.C1159r.C1161a;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.mediation.adapter.MaxAdapter.InitializationStatus;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.facebook.internal.AnalyticsEvents;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.g */
public class C0997g {

    /* renamed from: a */
    private final C1192i f1914a;

    /* renamed from: b */
    private final C1227o f1915b;

    /* renamed from: c */
    private final AtomicBoolean f1916c = new AtomicBoolean();

    /* renamed from: d */
    private final JSONArray f1917d = new JSONArray();

    /* renamed from: e */
    private final LinkedHashSet<String> f1918e = new LinkedHashSet<>();

    /* renamed from: f */
    private final Object f1919f = new Object();

    public C0997g(C1192i iVar) {
        this.f1914a = iVar;
        this.f1915b = iVar.mo10249v();
    }

    /* renamed from: a */
    public void mo9540a(Activity activity) {
        if (this.f1916c.compareAndSet(false, true)) {
            this.f1914a.mo10185K().mo10131a((C1122a) new C0969a(activity, this.f1914a), C1161a.MEDIATION_MAIN);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo9541a(C0962e eVar, long j, InitializationStatus initializationStatus, String str) {
        boolean z;
        if (initializationStatus != null && initializationStatus != InitializationStatus.INITIALIZING) {
            synchronized (this.f1919f) {
                z = !mo9544a(eVar);
                if (z) {
                    this.f1918e.add(eVar.mo9494y());
                    JSONObject jSONObject = new JSONObject();
                    C1247h.m2979a(jSONObject, "class", eVar.mo9494y(), this.f1914a);
                    C1247h.m2979a(jSONObject, "init_status", String.valueOf(initializationStatus.getCode()), this.f1914a);
                    C1247h.m2979a(jSONObject, AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, JSONObject.quote(str), this.f1914a);
                    this.f1917d.put(jSONObject);
                }
            }
            if (z) {
                this.f1914a.mo10208a(eVar);
                this.f1914a.mo10252y().maybeScheduleAdapterInitializationPostback(eVar, j, initializationStatus, str);
            }
        }
    }

    /* renamed from: a */
    public void mo9542a(C0962e eVar, Activity activity) {
        C0999i a = this.f1914a.mo10250w().mo9547a(eVar);
        if (a != null) {
            C1227o oVar = this.f1915b;
            StringBuilder sb = new StringBuilder();
            sb.append("Initializing adapter ");
            sb.append(eVar);
            oVar.mo10380c("MediationAdapterInitializationManager", sb.toString());
            a.mo9552a((MaxAdapterInitializationParameters) MaxAdapterParametersImpl.m1399a(eVar, activity.getApplicationContext()), activity);
        }
    }

    /* renamed from: a */
    public boolean mo9543a() {
        return this.f1916c.get();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo9544a(C0962e eVar) {
        boolean contains;
        synchronized (this.f1919f) {
            contains = this.f1918e.contains(eVar.mo9494y());
        }
        return contains;
    }

    /* renamed from: b */
    public LinkedHashSet<String> mo9545b() {
        LinkedHashSet<String> linkedHashSet;
        synchronized (this.f1919f) {
            linkedHashSet = this.f1918e;
        }
        return linkedHashSet;
    }

    /* renamed from: c */
    public JSONArray mo9546c() {
        JSONArray jSONArray;
        synchronized (this.f1919f) {
            jSONArray = this.f1917d;
        }
        return jSONArray;
    }
}
