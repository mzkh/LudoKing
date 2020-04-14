package com.adcolony.sdk;

import android.util.Log;
import com.appsflyer.ServerParameters;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.ai */
class C0492ai {

    /* renamed from: a */
    static final String f212a = "adcolony_android";

    /* renamed from: b */
    static final String f213b = "adcolony_fatal_reports";

    /* renamed from: c */
    C0747v f214c;

    /* renamed from: d */
    ScheduledExecutorService f215d;

    /* renamed from: e */
    List<C0750x> f216e = new ArrayList();

    /* renamed from: f */
    List<C0750x> f217f = new ArrayList();

    /* renamed from: g */
    HashMap<String, Object> f218g;

    /* renamed from: h */
    private C0745t f219h;

    /* renamed from: i */
    private C0745t f220i;

    C0492ai(C0747v vVar, ScheduledExecutorService scheduledExecutorService, HashMap<String, Object> hashMap) {
        this.f214c = vVar;
        this.f215d = scheduledExecutorService;
        this.f218g = hashMap;
        String str = "Production";
        String str2 = "4.1.0";
        this.f219h = new C0745t(f212a, str2, str);
        this.f220i = new C0745t(f213b, str2, str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized void mo8260a(String str) {
        this.f218g.put("controllerVersion", str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public synchronized void mo8263b(String str) {
        this.f218g.put("sessionId", str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized void mo8257a(long j, TimeUnit timeUnit) {
        try {
            if (!this.f215d.isShutdown() && !this.f215d.isTerminated()) {
                this.f215d.scheduleAtFixedRate(new Runnable() {
                    public void run() {
                        C0492ai.this.mo8261b();
                    }
                }, j, j, timeUnit);
            }
        } catch (RuntimeException unused) {
            Log.e("ADCLogError", "Internal error when submitting remote log to executor service");
        }
        return;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r4.f215d.shutdownNow();
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0040 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo8256a() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.concurrent.ScheduledExecutorService r0 = r4.f215d     // Catch:{ all -> 0x004e }
            r0.shutdown()     // Catch:{ all -> 0x004e }
            java.util.concurrent.ScheduledExecutorService r0 = r4.f215d     // Catch:{ InterruptedException -> 0x0040 }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x0040 }
            r2 = 1
            boolean r0 = r0.awaitTermination(r2, r1)     // Catch:{ InterruptedException -> 0x0040 }
            if (r0 != 0) goto L_0x004c
            java.util.concurrent.ScheduledExecutorService r0 = r4.f215d     // Catch:{ InterruptedException -> 0x0040 }
            r0.shutdownNow()     // Catch:{ InterruptedException -> 0x0040 }
            java.util.concurrent.ScheduledExecutorService r0 = r4.f215d     // Catch:{ InterruptedException -> 0x0040 }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x0040 }
            boolean r0 = r0.awaitTermination(r2, r1)     // Catch:{ InterruptedException -> 0x0040 }
            if (r0 != 0) goto L_0x004c
            java.io.PrintStream r0 = java.lang.System.err     // Catch:{ InterruptedException -> 0x0040 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0040 }
            r1.<init>()     // Catch:{ InterruptedException -> 0x0040 }
            java.lang.Class r2 = r4.getClass()     // Catch:{ InterruptedException -> 0x0040 }
            java.lang.String r2 = r2.getSimpleName()     // Catch:{ InterruptedException -> 0x0040 }
            r1.append(r2)     // Catch:{ InterruptedException -> 0x0040 }
            java.lang.String r2 = ": ScheduledExecutorService did not terminate"
            r1.append(r2)     // Catch:{ InterruptedException -> 0x0040 }
            java.lang.String r1 = r1.toString()     // Catch:{ InterruptedException -> 0x0040 }
            r0.println(r1)     // Catch:{ InterruptedException -> 0x0040 }
            goto L_0x004c
        L_0x0040:
            java.util.concurrent.ScheduledExecutorService r0 = r4.f215d     // Catch:{ all -> 0x004e }
            r0.shutdownNow()     // Catch:{ all -> 0x004e }
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x004e }
            r0.interrupt()     // Catch:{ all -> 0x004e }
        L_0x004c:
            monitor-exit(r4)
            return
        L_0x004e:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C0492ai.mo8256a():void");
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0039 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo8261b() {
        /*
            r2 = this;
            monitor-enter(r2)
            monitor-enter(r2)     // Catch:{ all -> 0x0049 }
            java.util.List<com.adcolony.sdk.x> r0 = r2.f216e     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            int r0 = r0.size()     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            if (r0 <= 0) goto L_0x001c
            com.adcolony.sdk.t r0 = r2.f219h     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            java.util.List<com.adcolony.sdk.x> r1 = r2.f216e     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            java.lang.String r0 = r2.mo8255a(r0, r1)     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            com.adcolony.sdk.v r1 = r2.f214c     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            r1.mo8721a(r0)     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            java.util.List<com.adcolony.sdk.x> r0 = r2.f216e     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            r0.clear()     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
        L_0x001c:
            java.util.List<com.adcolony.sdk.x> r0 = r2.f217f     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            int r0 = r0.size()     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            if (r0 <= 0) goto L_0x0044
            com.adcolony.sdk.t r0 = r2.f220i     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            java.util.List<com.adcolony.sdk.x> r1 = r2.f217f     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            java.lang.String r0 = r2.mo8255a(r0, r1)     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            com.adcolony.sdk.v r1 = r2.f214c     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            r1.mo8721a(r0)     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            java.util.List<com.adcolony.sdk.x> r0 = r2.f217f     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            r0.clear()     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            goto L_0x0044
        L_0x0037:
            r0 = move-exception
            goto L_0x0047
        L_0x0039:
            java.util.List<com.adcolony.sdk.x> r0 = r2.f216e     // Catch:{ all -> 0x0037 }
            r0.clear()     // Catch:{ all -> 0x0037 }
            goto L_0x0044
        L_0x003f:
            java.util.List<com.adcolony.sdk.x> r0 = r2.f216e     // Catch:{ all -> 0x0037 }
            r0.clear()     // Catch:{ all -> 0x0037 }
        L_0x0044:
            monitor-exit(r2)     // Catch:{ all -> 0x0037 }
            monitor-exit(r2)
            return
        L_0x0047:
            monitor-exit(r2)     // Catch:{ all -> 0x0037 }
            throw r0     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C0492ai.mo8261b():void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public synchronized void mo8264c(String str) {
        mo8259a(new C0751a().mo8737a(3).mo8738a(this.f219h).mo8739a(str).mo8740a());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public synchronized void mo8265d(String str) {
        mo8259a(new C0751a().mo8737a(2).mo8738a(this.f219h).mo8739a(str).mo8740a());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public synchronized void mo8266e(String str) {
        mo8259a(new C0751a().mo8737a(1).mo8738a(this.f219h).mo8739a(str).mo8740a());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public synchronized void mo8267f(String str) {
        mo8259a(new C0751a().mo8737a(0).mo8738a(this.f219h).mo8739a(str).mo8740a());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8258a(C0720q qVar) {
        qVar.mo8730a(this.f220i);
        qVar.mo8729a(-1);
        mo8262b((C0750x) qVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized void mo8259a(final C0750x xVar) {
        try {
            if (!this.f215d.isShutdown() && !this.f215d.isTerminated()) {
                this.f215d.submit(new Runnable() {
                    public void run() {
                        C0492ai.this.f216e.add(xVar);
                    }
                });
            }
        } catch (RejectedExecutionException unused) {
            Log.e("ADCLogError", "Internal error when submitting remote log to executor service");
        }
        return;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public synchronized void mo8262b(C0750x xVar) {
        this.f217f.add(xVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo8255a(C0745t tVar, List<C0750x> list) throws IOException, JSONException {
        String c = C0476a.m77a().mo8579m().mo8627c();
        HashMap<String, Object> hashMap = this.f218g;
        String str = ServerParameters.ADVERTISING_ID_PARAM;
        String str2 = hashMap.get(str) != null ? (String) this.f218g.get(str) : "unknown";
        if (c != null && c.length() > 0 && !c.equals(str2)) {
            this.f218g.put(str, c);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Param.INDEX, tVar.mo8718b());
        jSONObject.put("environment", tVar.mo8720d());
        jSONObject.put("version", tVar.mo8719c());
        JSONArray jSONArray = new JSONArray();
        for (C0750x c2 : list) {
            jSONArray.put(m147c(c2));
        }
        jSONObject.put("logs", jSONArray);
        return jSONObject.toString();
    }

    /* renamed from: c */
    private synchronized JSONObject m147c(C0750x xVar) throws JSONException {
        JSONObject jSONObject;
        jSONObject = new JSONObject(this.f218g);
        jSONObject.put("environment", xVar.mo8735f().mo8720d());
        jSONObject.put("level", xVar.mo8731b());
        jSONObject.put("message", xVar.mo8733d());
        jSONObject.put("clientTimestamp", xVar.mo8734e());
        JSONObject mediationInfo = C0476a.m77a().mo8567d().getMediationInfo();
        JSONObject pluginInfo = C0476a.m77a().mo8567d().getPluginInfo();
        double t = C0476a.m77a().mo8579m().mo8644t();
        jSONObject.put("mediation_network", C0746u.m908b(mediationInfo, "name"));
        jSONObject.put("mediation_network_version", C0746u.m908b(mediationInfo, "version"));
        jSONObject.put(TapjoyConstants.TJC_PLUGIN, C0746u.m908b(pluginInfo, "name"));
        jSONObject.put("plugin_version", C0746u.m908b(pluginInfo, "version"));
        jSONObject.put("batteryInfo", t);
        if (xVar instanceof C0720q) {
            jSONObject = C0746u.m896a(jSONObject, ((C0720q) xVar).mo8688a());
            jSONObject.put(TapjoyConstants.TJC_PLATFORM, "android");
        }
        return jSONObject;
    }
}
