package com.applovin.impl.mediation.p015c;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.impl.mediation.p014b.C0963f;
import com.applovin.impl.mediation.p014b.C0963f.C0964a;
import com.applovin.impl.mediation.p014b.C0965g;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p019b.C1095b;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p019b.C1098e;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.p021d.C1122a;
import com.applovin.impl.sdk.utils.C1243d;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.mediation.MaxAdFormat;
import com.facebook.internal.AnalyticsEvents;
import com.tapjoy.TapjoyConstants;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.c.b */
public class C0971b extends C1122a {

    /* renamed from: a */
    private static String f1860a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final MaxAdFormat f1861c;

    /* renamed from: d */
    private final boolean f1862d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Activity f1863e;

    /* renamed from: f */
    private final C0975a f1864f;

    /* renamed from: com.applovin.impl.mediation.c.b$a */
    public interface C0975a {
        /* renamed from: a */
        void mo9279a(JSONArray jSONArray);
    }

    static {
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(m1685a("APPLOVIN_NETWORK", "com.applovin.mediation.adapters.AppLovinMediationAdapter"));
            m1685a("FACEBOOK_NETWORK", "com.applovin.mediation.adapters.FacebookMediationAdapter").put("run_on_ui_thread", false);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("signal_providers", jSONArray);
            f1860a = jSONObject.toString();
        } catch (JSONException unused) {
        }
    }

    public C0971b(MaxAdFormat maxAdFormat, boolean z, Activity activity, C1192i iVar, C0975a aVar) {
        super("TaskCollectSignals", iVar);
        this.f1861c = maxAdFormat;
        this.f1862d = z;
        this.f1863e = activity;
        this.f1864f = aVar;
    }

    /* renamed from: a */
    private String m1684a(String str, C1096c<Integer> cVar) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        int intValue = ((Integer) this.f2745b.mo10202a(cVar)).intValue();
        return intValue > 0 ? str.substring(0, Math.min(str.length(), intValue)) : str2;
    }

    /* renamed from: a */
    private static JSONObject m1685a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", str);
        jSONObject.put("class", str2);
        jSONObject.put("adapter_timeout_ms", TapjoyConstants.TJC_PLACEMENT_RESPONSE_TIMEOUT);
        jSONObject.put("max_signal_length", 32768);
        jSONObject.put("scode", "");
        return jSONObject;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1686a(final C0965g gVar, final C0964a aVar) {
        C09742 r0 = new Runnable() {
            public void run() {
                C0971b.this.f2745b.mo10252y().collectSignal(C0971b.this.f1861c, gVar, C0971b.this.f1863e, aVar);
            }
        };
        String str = "Running signal collection for ";
        if (gVar.mo9465B()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(gVar);
            sb.append(" on the main thread");
            mo10068a(sb.toString());
            this.f1863e.runOnUiThread(r0);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(gVar);
        sb2.append(" on the background thread");
        mo10068a(sb2.toString());
        r0.run();
    }

    /* renamed from: a */
    private void m1688a(Collection<C0963f> collection) {
        String str;
        String a;
        JSONArray jSONArray = new JSONArray();
        for (C0963f fVar : collection) {
            try {
                JSONObject jSONObject = new JSONObject();
                C0965g a2 = fVar.mo9496a();
                jSONObject.put("name", a2.mo9495z());
                jSONObject.put("class", a2.mo9494y());
                jSONObject.put(TapjoyConstants.TJC_ADAPTER_VERSION, m1684a(fVar.mo9498c(), C1095b.f2261l));
                jSONObject.put("sdk_version", m1684a(fVar.mo9497b(), C1095b.f2262m));
                JSONObject jSONObject2 = new JSONObject();
                if (C1277l.m3042b(fVar.mo9500e())) {
                    str = AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE;
                    a = fVar.mo9500e();
                } else {
                    str = "signal";
                    a = m1684a(fVar.mo9499d(), C1095b.f2263n);
                }
                jSONObject2.put(str, a);
                jSONObject.put("data", jSONObject2);
                jSONArray.put(jSONObject);
                StringBuilder sb = new StringBuilder();
                sb.append("Collected signal from ");
                sb.append(a2);
                mo10068a(sb.toString());
            } catch (JSONException e) {
                mo10069a("Failed to create signal data", e);
            }
        }
        m1689a(jSONArray);
    }

    /* renamed from: a */
    private void m1689a(JSONArray jSONArray) {
        C0975a aVar = this.f1864f;
        if (aVar != null) {
            aVar.mo9279a(jSONArray);
        }
    }

    /* renamed from: a */
    private void m1690a(JSONArray jSONArray, JSONObject jSONObject) throws JSONException, InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Collecting signals from ");
        sb.append(jSONArray.length());
        sb.append(" signal providers(s)...");
        mo10068a(sb.toString());
        List a = C1243d.m2923a(jSONArray.length());
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        CountDownLatch countDownLatch = new CountDownLatch(jSONArray.length());
        ScheduledExecutorService b = this.f2745b.mo10185K().mo10135b();
        for (int i = 0; i < jSONArray.length(); i++) {
            final C0965g gVar = new C0965g(jSONArray.getJSONObject(i), jSONObject, this.f2745b);
            final AtomicBoolean atomicBoolean2 = atomicBoolean;
            final List list = a;
            final CountDownLatch countDownLatch2 = countDownLatch;
            C09721 r1 = new Runnable() {
                public void run() {
                    C0971b.this.m1686a(gVar, (C0964a) new C0964a() {
                        /* renamed from: a */
                        public void mo9502a(C0963f fVar) {
                            if (atomicBoolean2.get() && fVar != null) {
                                list.add(fVar);
                            }
                            countDownLatch2.countDown();
                        }
                    });
                }
            };
            b.execute(r1);
        }
        countDownLatch.await(((Long) this.f2745b.mo10202a(C1095b.f2260k)).longValue(), TimeUnit.MILLISECONDS);
        atomicBoolean.set(false);
        m1688a((Collection<C0963f>) a);
    }

    /* renamed from: b */
    private void m1692b(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("No signals collected: ");
        sb.append(str);
        mo10069a(sb.toString(), th);
        m1689a(new JSONArray());
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2680B;
    }

    public void run() {
        String str;
        try {
            JSONObject jSONObject = new JSONObject((String) this.f2745b.mo10222b(C1098e.f2576v, f1860a));
            JSONArray b = C1247h.m2988b(jSONObject, "signal_providers", (JSONArray) null, this.f2745b);
            if (this.f1862d) {
                List b2 = this.f2745b.mo10224b((C1096c) C1095b.f2248P);
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < b.length(); i++) {
                    JSONObject a = C1247h.m2977a(b, i, (JSONObject) null, this.f2745b);
                    if (b2.contains(C1247h.m2985b(a, "class", (String) null, this.f2745b))) {
                        jSONArray.put(a);
                    }
                }
                b = jSONArray;
            }
            if (b.length() == 0) {
                m1692b("No signal providers found", null);
            } else {
                m1690a(b, jSONObject);
            }
        } catch (JSONException e) {
            th = e;
            str = "Failed to parse signals JSON";
            m1692b(str, th);
        } catch (InterruptedException e2) {
            th = e2;
            str = "Failed to wait for signals";
            m1692b(str, th);
        } catch (Throwable th) {
            th = th;
            str = "Failed to collect signals";
            m1692b(str, th);
        }
    }
}
