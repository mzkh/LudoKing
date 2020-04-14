package com.applovin.impl.sdk.network;

import android.content.SharedPreferences;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p019b.C1098e;
import com.applovin.impl.sdk.utils.C1245f;
import com.applovin.impl.sdk.utils.C1248i;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.network.e */
public class C1220e {

    /* renamed from: a */
    private final C1192i f3084a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1227o f3085b;

    /* renamed from: c */
    private ArrayList<C1222f> f3086c;

    /* renamed from: d */
    private ArrayList<C1222f> f3087d;

    /* renamed from: e */
    private final Object f3088e;

    /* renamed from: f */
    private final SharedPreferences f3089f;

    public C1220e(C1192i iVar) {
        if (iVar != null) {
            this.f3084a = iVar;
            this.f3085b = iVar.mo10249v();
            this.f3089f = iVar.mo10179D().getSharedPreferences("com.applovin.sdk.impl.postbackQueue.domain", 0);
            this.f3088e = new Object();
            this.f3086c = m2778c();
            this.f3087d = new ArrayList<>();
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* renamed from: a */
    private void m2775a(final C1222f fVar, final AppLovinPostbackListener appLovinPostbackListener) {
        C1227o oVar = this.f3085b;
        StringBuilder sb = new StringBuilder();
        sb.append("Preparing to submit postback...");
        sb.append(fVar);
        oVar.mo10378b("PersistentPostbackManager", sb.toString());
        if (this.f3084a.mo10229c()) {
            this.f3085b.mo10378b("PersistentPostbackManager", "Skipping postback dispatch because SDK is still initializing - postback will be dispatched afterwards");
            return;
        }
        synchronized (this.f3088e) {
            fVar.mo10350h();
            m2780d();
        }
        int intValue = ((Integer) this.f3084a.mo10202a(C1096c.f2489du)).intValue();
        if (fVar.mo10349g() > intValue) {
            C1227o oVar2 = this.f3085b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Exceeded maximum persisted attempt count of ");
            sb2.append(intValue);
            sb2.append(". Dequeuing postback: ");
            sb2.append(fVar);
            oVar2.mo10381d("PersistentPostbackManager", sb2.toString());
            m2781d(fVar);
        } else {
            this.f3084a.mo10192R().dispatchPostbackRequest(C1225g.m2812b(this.f3084a).mo10324a(fVar.mo10342a()).mo10333c(fVar.mo10343b()).mo10325a(fVar.mo10344c()).mo10366c(fVar.mo10345d()).mo10326a(fVar.mo10346e() != null ? new JSONObject(fVar.mo10346e()) : null).mo10327a(fVar.mo10348f()).mo10328a(), new AppLovinPostbackListener() {
                public void onPostbackFailure(String str, int i) {
                    C1227o a = C1220e.this.f3085b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to submit postback with errorCode ");
                    sb.append(i);
                    sb.append(". Will retry later...  Postback: ");
                    sb.append(fVar);
                    a.mo10380c("PersistentPostbackManager", sb.toString());
                    C1220e.this.m2782e(fVar);
                    C1248i.m3006a(appLovinPostbackListener, str, i);
                }

                public void onPostbackSuccess(String str) {
                    C1220e.this.m2781d(fVar);
                    C1227o a = C1220e.this.f3085b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Successfully submitted postback: ");
                    sb.append(fVar);
                    a.mo10378b("PersistentPostbackManager", sb.toString());
                    C1220e.this.mo10341b();
                    C1248i.m3005a(appLovinPostbackListener, str);
                }
            });
        }
    }

    /* renamed from: b */
    private void m2777b(C1222f fVar) {
        synchronized (this.f3088e) {
            this.f3086c.add(fVar);
            m2780d();
            StringBuilder sb = new StringBuilder();
            sb.append("Enqueued postback: ");
            sb.append(fVar);
            this.f3085b.mo10378b("PersistentPostbackManager", sb.toString());
        }
    }

    /* renamed from: c */
    private ArrayList<C1222f> m2778c() {
        Set<String> set = (Set) this.f3084a.mo10223b(C1098e.f2565k, new LinkedHashSet(0), this.f3089f);
        ArrayList<C1222f> arrayList = new ArrayList<>(Math.max(1, set.size()));
        int intValue = ((Integer) this.f3084a.mo10202a(C1096c.f2489du)).intValue();
        C1227o oVar = this.f3085b;
        StringBuilder sb = new StringBuilder();
        sb.append("Deserializing ");
        sb.append(set.size());
        String str = " postback(s).";
        sb.append(str);
        String str2 = "PersistentPostbackManager";
        oVar.mo10378b(str2, sb.toString());
        for (String str3 : set) {
            try {
                C1222f fVar = new C1222f(new JSONObject(str3), this.f3084a);
                if (fVar.mo10349g() < intValue) {
                    arrayList.add(fVar);
                } else {
                    C1227o oVar2 = this.f3085b;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Skipping deserialization because maximum attempt count exceeded for postback: ");
                    sb2.append(fVar);
                    oVar2.mo10378b(str2, sb2.toString());
                }
            } catch (Throwable th) {
                C1227o oVar3 = this.f3085b;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Unable to deserialize postback request from json: ");
                sb3.append(str3);
                oVar3.mo10379b(str2, sb3.toString(), th);
            }
        }
        C1227o oVar4 = this.f3085b;
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Successfully loaded postback queue with ");
        sb4.append(arrayList.size());
        sb4.append(str);
        oVar4.mo10378b(str2, sb4.toString());
        return arrayList;
    }

    /* renamed from: c */
    private void m2779c(C1222f fVar) {
        m2775a(fVar, (AppLovinPostbackListener) null);
    }

    /* renamed from: d */
    private void m2780d() {
        String str;
        C1227o oVar;
        String str2 = "PersistentPostbackManager";
        if (C1245f.m2931b()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.f3086c.size());
            Iterator it = this.f3086c.iterator();
            while (it.hasNext()) {
                try {
                    linkedHashSet.add(((C1222f) it.next()).mo10353j().toString());
                } catch (Throwable th) {
                    this.f3085b.mo10379b(str2, "Unable to serialize postback request to JSON.", th);
                }
            }
            this.f3084a.mo10210a(C1098e.f2565k, linkedHashSet, this.f3089f);
            oVar = this.f3085b;
            str = "Wrote updated postback queue to disk.";
        } else {
            oVar = this.f3085b;
            str = "Skipping writing postback queue to disk due to old Android version...";
        }
        oVar.mo10378b(str2, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m2781d(C1222f fVar) {
        synchronized (this.f3088e) {
            this.f3086c.remove(fVar);
            m2780d();
        }
        C1227o oVar = this.f3085b;
        StringBuilder sb = new StringBuilder();
        sb.append("Dequeued successfully transmitted postback: ");
        sb.append(fVar);
        oVar.mo10378b("PersistentPostbackManager", sb.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m2782e(C1222f fVar) {
        synchronized (this.f3088e) {
            this.f3087d.add(fVar);
        }
    }

    /* renamed from: a */
    public void mo10337a() {
        synchronized (this.f3088e) {
            if (this.f3086c != null) {
                for (C1222f c : new ArrayList(this.f3086c)) {
                    m2779c(c);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo10338a(C1222f fVar) {
        mo10339a(fVar, true);
    }

    /* renamed from: a */
    public void mo10339a(C1222f fVar, boolean z) {
        mo10340a(fVar, z, null);
    }

    /* renamed from: a */
    public void mo10340a(C1222f fVar, boolean z, AppLovinPostbackListener appLovinPostbackListener) {
        if (C1277l.m3042b(fVar.mo10342a())) {
            if (z) {
                fVar.mo10352i();
            }
            synchronized (this.f3088e) {
                m2777b(fVar);
                m2775a(fVar, appLovinPostbackListener);
            }
        }
    }

    /* renamed from: b */
    public void mo10341b() {
        synchronized (this.f3088e) {
            Iterator it = this.f3087d.iterator();
            while (it.hasNext()) {
                m2779c((C1222f) it.next());
            }
            this.f3087d.clear();
        }
    }
}
