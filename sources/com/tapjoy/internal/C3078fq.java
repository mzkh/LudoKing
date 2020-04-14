package com.tapjoy.internal;

import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.C1823gf.C1825a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tapjoy.internal.fq */
public abstract class C3078fq {

    /* renamed from: c */
    private static final String f7260c = "fq";

    /* renamed from: a */
    public final Map f7261a = new HashMap();

    /* renamed from: b */
    public final Map f7262b = new HashMap();

    protected C3078fq(String str, String str2, String str3) {
        this.f7261a.put("placement", str);
        this.f7261a.put("placement_type", str2);
        this.f7261a.put(Param.CONTENT_TYPE, str3);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C1825a mo30142a(String str, Map map, Map map2) {
        C1825a b = C1823gf.m3524e(str).mo18096a().mo18100a(this.f7261a).mo18100a(map).mo18103b(map2);
        this.f7262b.put(str, b);
        return b;
    }

    /* renamed from: a */
    public final void mo30143a(String str, Object obj) {
        this.f7261a.put(str, obj);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final C1825a mo30145b(String str, Map map, Map map2) {
        C1825a aVar = !C2874al.m6573a(str) ? (C1825a) this.f7262b.remove(str) : null;
        if (aVar == null) {
            String str2 = f7260c;
            StringBuilder sb = new StringBuilder("Error when calling endTrackingEvent -- ");
            sb.append(str);
            sb.append(" tracking has not been started.");
            TapjoyLog.m6552e(str2, sb.toString());
        } else {
            aVar.mo18100a(this.f7261a).mo18100a(map).mo18103b(map2).mo18101b().mo18104c();
        }
        return aVar;
    }

    /* renamed from: a */
    public final C1825a mo30141a() {
        return mo30142a("Content.rendered", null, null);
    }

    /* renamed from: b */
    public final C1825a mo30144b() {
        return mo30145b("Content.rendered", null, null);
    }
}
