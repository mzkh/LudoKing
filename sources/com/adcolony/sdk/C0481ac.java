package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tapjoy.TJAdUnitConstants.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"UseSparseArrays"})
/* renamed from: com.adcolony.sdk.ac */
class C0481ac {

    /* renamed from: a */
    private ArrayList<C0485ae> f167a = new ArrayList<>();

    /* renamed from: b */
    private HashMap<Integer, C0485ae> f168b = new HashMap<>();

    /* renamed from: c */
    private int f169c = 2;

    /* renamed from: d */
    private HashMap<String, ArrayList<C0484ad>> f170d = new HashMap<>();

    /* renamed from: e */
    private JSONArray f171e = C0746u.m909b();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f172f = 1;

    C0481ac() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8225a(String str, C0484ad adVar) {
        ArrayList arrayList = (ArrayList) this.f170d.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f170d.put(str, arrayList);
        }
        arrayList.add(adVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8229b(String str, C0484ad adVar) {
        synchronized (this.f170d) {
            ArrayList arrayList = (ArrayList) this.f170d.get(str);
            if (arrayList != null) {
                arrayList.remove(adVar);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8224a() {
        C0666j a = C0476a.m77a();
        if (!a.mo8573g() && !a.mo8574h()) {
            final Context c = C0476a.m85c();
            if (c != null) {
                C0543at.m309a((Runnable) new Runnable() {
                    public void run() {
                        AdColonyAppOptions d = C0476a.m77a().mo8567d();
                        d.mo8087e();
                        JSONObject d2 = d.mo8086d();
                        JSONObject a = C0746u.m892a();
                        C0746u.m902a(d2, "os_name", "android");
                        StringBuilder sb = new StringBuilder();
                        sb.append(C0476a.m77a().mo8581o().mo8318g());
                        sb.append("7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5");
                        C0746u.m902a(a, "filepath", sb.toString());
                        C0746u.m904a(a, String.VIDEO_INFO, d2);
                        C0746u.m912b(a, "m_origin", 0);
                        C0746u.m912b(a, "m_id", C0481ac.this.f172f = C0481ac.this.f172f + 1);
                        C0746u.m902a(a, "m_type", "Controller.create");
                        try {
                            new C0557av(c, 1, false).mo8405a(true, new C0480ab(a));
                        } catch (RuntimeException e) {
                            C0749a aVar = new C0749a();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(e.toString());
                            sb2.append(": during WebView initialization.");
                            aVar.mo8726a(sb2.toString()).mo8726a(" Disabling AdColony.").mo8728a(C0748w.f1171g);
                            AdColony.disable();
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0485ae mo8223a(C0485ae aeVar) {
        synchronized (this.f167a) {
            int b = aeVar.mo8238b();
            if (b <= 0) {
                b = aeVar.mo8236a();
            }
            this.f167a.add(aeVar);
            this.f168b.put(Integer.valueOf(b), aeVar);
        }
        return aeVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0485ae mo8222a(int i) {
        synchronized (this.f167a) {
            C0485ae aeVar = (C0485ae) this.f168b.get(Integer.valueOf(i));
            if (aeVar == null) {
                return null;
            }
            this.f167a.remove(aeVar);
            this.f168b.remove(Integer.valueOf(i));
            aeVar.mo8239c();
            return aeVar;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public synchronized void mo8228b() {
        synchronized (this.f167a) {
            for (int size = this.f167a.size() - 1; size >= 0; size--) {
                ((C0485ae) this.f167a.get(size)).mo8240d();
            }
        }
        JSONArray jSONArray = null;
        if (this.f171e.length() > 0) {
            jSONArray = this.f171e;
            this.f171e = C0746u.m909b();
        }
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    final JSONObject jSONObject = jSONArray.getJSONObject(i);
                    final String string = jSONObject.getString("m_type");
                    if (jSONObject.getInt("m_origin") >= 2) {
                        C0543at.m309a((Runnable) new Runnable() {
                            public void run() {
                                C0481ac.this.mo8226a(string, jSONObject);
                            }
                        });
                    } else {
                        mo8226a(string, jSONObject);
                    }
                } catch (JSONException e) {
                    new C0749a().mo8726a("JSON error from message dispatcher's updateModules(): ").mo8726a(e.toString()).mo8728a(C0748w.f1172h);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8226a(String str, JSONObject jSONObject) {
        synchronized (this.f170d) {
            ArrayList arrayList = (ArrayList) this.f170d.get(str);
            if (arrayList != null) {
                C0480ab abVar = new C0480ab(jSONObject);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    try {
                        ((C0484ad) it.next()).mo8235a(abVar);
                    } catch (RuntimeException e) {
                        new C0749a().mo8725a((Object) e).mo8728a(C0748w.f1172h);
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8227a(JSONObject jSONObject) {
        try {
            if (!jSONObject.has("m_id")) {
                int i = this.f172f;
                this.f172f = i + 1;
                jSONObject.put("m_id", i);
            }
            if (!jSONObject.has("m_origin")) {
                jSONObject.put("m_origin", 0);
            }
            int i2 = jSONObject.getInt("m_target");
            if (i2 == 0) {
                synchronized (this) {
                    this.f171e.put(jSONObject);
                }
                return;
            }
            C0485ae aeVar = (C0485ae) this.f168b.get(Integer.valueOf(i2));
            if (aeVar != null) {
                aeVar.mo8237a(jSONObject);
            }
        } catch (JSONException e) {
            new C0749a().mo8726a("JSON error in ADCMessageDispatcher's sendMessage(): ").mo8726a(e.toString()).mo8728a(C0748w.f1172h);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public ArrayList<C0485ae> mo8230c() {
        return this.f167a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public int mo8231d() {
        int i = this.f169c;
        this.f169c = i + 1;
        return i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public HashMap<Integer, C0485ae> mo8232e() {
        return this.f168b;
    }
}
