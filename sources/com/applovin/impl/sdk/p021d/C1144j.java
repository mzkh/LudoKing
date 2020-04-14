package com.applovin.impl.sdk.p021d;

import android.text.TextUtils;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.network.C1225g;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.p021d.C1159r.C1161a;
import com.applovin.impl.sdk.utils.C1246g;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.j */
public class C1144j extends C1122a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1225g f2779a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final AppLovinPostbackListener f2780c;

    /* renamed from: d */
    private final C1161a f2781d;

    public C1144j(C1225g gVar, C1161a aVar, C1192i iVar, AppLovinPostbackListener appLovinPostbackListener) {
        super("TaskDispatchPostback", iVar);
        if (gVar != null) {
            this.f2779a = gVar;
            this.f2780c = appLovinPostbackListener;
            this.f2781d = aVar;
            return;
        }
        throw new IllegalArgumentException("No request specified");
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2694c;
    }

    public void run() {
        final String a = this.f2779a.mo10302a();
        if (!C1277l.m3042b(a)) {
            mo10070b("Requested URL is not valid; nothing to do...");
            AppLovinPostbackListener appLovinPostbackListener = this.f2780c;
            if (appLovinPostbackListener != null) {
                appLovinPostbackListener.onPostbackFailure(a, AppLovinErrorCodes.INVALID_URL);
            }
            return;
        }
        C11451 r1 = new C1173x<Object>(this.f2779a, mo10073e()) {
            /* renamed from: a */
            public void mo9301a(int i) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to dispatch postback. Error code: ");
                sb.append(i);
                sb.append(" URL: ");
                sb.append(a);
                mo10072d(sb.toString());
                if (C1144j.this.f2780c != null) {
                    C1144j.this.f2780c.onPostbackFailure(a, i);
                }
            }

            /* renamed from: a */
            public void mo9302a(Object obj, int i) {
                StringBuilder sb = new StringBuilder();
                sb.append("Successfully dispatched postback to URL: ");
                sb.append(a);
                mo10068a(sb.toString());
                String str = "Updating settings from: ";
                if (((Boolean) this.f2745b.mo10202a(C1096c.f2519eY)).booleanValue()) {
                    if (obj != null && (obj instanceof JSONObject)) {
                        JSONObject jSONObject = (JSONObject) obj;
                        Iterator it = this.f2745b.mo10224b((C1096c) C1096c.f2291aF).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (C1144j.this.f2779a.mo10302a().startsWith((String) it.next())) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(str);
                                sb2.append(C1144j.this.f2779a.mo10302a());
                                mo10068a(sb2.toString());
                                C1246g.m2952d(jSONObject, this.f2745b);
                                C1246g.m2951c(jSONObject, this.f2745b);
                                break;
                            }
                        }
                    }
                } else if (obj != null && (obj instanceof String)) {
                    for (String startsWith : this.f2745b.mo10224b((C1096c) C1096c.f2291aF)) {
                        if (C1144j.this.f2779a.mo10302a().startsWith(startsWith)) {
                            String str2 = (String) obj;
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append(str);
                                    sb3.append(C1144j.this.f2779a.mo10302a());
                                    mo10068a(sb3.toString());
                                    JSONObject jSONObject2 = new JSONObject(str2);
                                    C1246g.m2952d(jSONObject2, this.f2745b);
                                    C1246g.m2951c(jSONObject2, this.f2745b);
                                    break;
                                } catch (JSONException unused) {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                if (C1144j.this.f2780c != null) {
                    C1144j.this.f2780c.onPostbackSuccess(a);
                }
            }
        };
        r1.mo10154a(this.f2781d);
        mo10073e().mo10185K().mo10130a((C1122a) r1);
    }
}
