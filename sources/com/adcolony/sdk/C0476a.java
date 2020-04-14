package com.adcolony.sdk;

import android.content.Context;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.a */
class C0476a {

    /* renamed from: a */
    static boolean f150a;

    /* renamed from: b */
    static boolean f151b;

    /* renamed from: c */
    private static WeakReference<Context> f152c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static C0666j f153d;

    C0476a() {
    }

    /* renamed from: a */
    static void m79a(final Context context, AdColonyAppOptions adColonyAppOptions, boolean z) {
        m78a(context);
        f151b = true;
        C0666j jVar = f153d;
        if (jVar == null) {
            f153d = new C0666j();
            f153d.mo8550a(adColonyAppOptions, z);
        } else {
            jVar.mo8549a(adColonyAppOptions);
        }
        C0543at.f402b.execute(new Runnable() {
            public void run() {
                C0476a.f153d.mo8558a(context, (C0480ab) null);
            }
        });
        new C0749a().mo8726a("Configuring AdColony").mo8728a(C0748w.f1167c);
        f153d.mo8563b(false);
        f153d.mo8577k().mo8297d(true);
        f153d.mo8577k().mo8299e(true);
        f153d.mo8577k().mo8301f(false);
        C0666j jVar2 = f153d;
        jVar2.f958f = true;
        jVar2.mo8577k().mo8292a(false);
    }

    /* renamed from: a */
    static C0666j m77a() {
        if (!m84b()) {
            Context c = m85c();
            if (c == null) {
                return new C0666j();
            }
            f153d = new C0666j();
            StringBuilder sb = new StringBuilder();
            sb.append(c.getFilesDir().getAbsolutePath());
            sb.append("/adc3/AppInfo");
            JSONObject c2 = C0746u.m916c(sb.toString());
            JSONArray g = C0746u.m922g(c2, "zoneIds");
            f153d.mo8550a(new AdColonyAppOptions().mo8081a(C0746u.m908b(c2, "appId")).mo8082a(C0746u.m906a(g)), false);
        }
        return f153d;
    }

    /* renamed from: b */
    static boolean m84b() {
        return f153d != null;
    }

    /* renamed from: a */
    static void m78a(Context context) {
        if (context == null) {
            f152c.clear();
        } else {
            f152c = new WeakReference<>(context);
        }
    }

    /* renamed from: c */
    static Context m85c() {
        WeakReference<Context> weakReference = f152c;
        if (weakReference == null) {
            return null;
        }
        return (Context) weakReference.get();
    }

    /* renamed from: d */
    static boolean m86d() {
        WeakReference<Context> weakReference = f152c;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    /* renamed from: e */
    static boolean m87e() {
        return f150a;
    }

    /* renamed from: a */
    static void m81a(String str, C0484ad adVar) {
        m77a().mo8583q().mo8225a(str, adVar);
    }

    /* renamed from: a */
    static C0484ad m76a(String str, C0484ad adVar, boolean z) {
        m77a().mo8583q().mo8225a(str, adVar);
        return adVar;
    }

    /* renamed from: b */
    static void m83b(String str, C0484ad adVar) {
        m77a().mo8583q().mo8229b(str, adVar);
    }

    /* renamed from: f */
    static void m88f() {
        m77a().mo8583q().mo8228b();
    }

    /* renamed from: a */
    static void m82a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = C0746u.m892a();
        }
        C0746u.m902a(jSONObject, "m_type", str);
        m77a().mo8583q().mo8227a(jSONObject);
    }

    /* renamed from: a */
    static void m80a(String str) {
        try {
            C0480ab abVar = new C0480ab("CustomMessage.send", 0);
            abVar.mo8220c().put("message", str);
            abVar.mo8217b();
        } catch (JSONException e) {
            new C0749a().mo8726a("JSON error from ADC.java's send_custom_message(): ").mo8726a(e.toString()).mo8728a(C0748w.f1172h);
        }
    }
}
