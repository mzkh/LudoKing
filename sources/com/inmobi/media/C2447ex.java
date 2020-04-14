package com.inmobi.media;

import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import com.tapjoy.TJAdUnitConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.ex */
/* compiled from: ConfigNetworkResponse */
final class C2447ex {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f5270b = "ex";

    /* renamed from: a */
    Map<String, C2448a> f5271a = new HashMap();

    /* renamed from: c */
    private Map<String, C2436er> f5272c;

    /* renamed from: d */
    private C2487fs f5273d;

    /* renamed from: e */
    private C2443eu f5274e;

    /* renamed from: f */
    private long f5275f;

    /* renamed from: com.inmobi.media.ex$a */
    /* compiled from: ConfigNetworkResponse */
    public static class C2448a {

        /* renamed from: a */
        int f5276a;

        /* renamed from: b */
        C2436er f5277b;

        /* renamed from: c */
        C2443eu f5278c;

        C2448a(JSONObject jSONObject, C2436er erVar) {
            this.f5277b = erVar;
            if (jSONObject != null) {
                try {
                    int i = jSONObject.getInt("status");
                    int i2 = TJAdUnitConstants.DEFAULT_VOLUME_CHECK_INTERVAL;
                    if (i == 200) {
                        i2 = Callback.DEFAULT_DRAG_ANIMATION_DURATION;
                    } else if (i == 304) {
                        i2 = 304;
                    } else if (i == 404) {
                        i2 = 404;
                    } else if (i != 500) {
                        i2 = -1;
                    }
                    this.f5276a = i2;
                    if (this.f5276a == 200) {
                        this.f5277b.mo28341a(jSONObject.getJSONObject("content"));
                        if (!this.f5277b.mo28343c()) {
                            this.f5278c = new C2443eu(2, "The received config has failed validation.");
                            C2447ex.f5270b;
                            this.f5277b.mo28340a();
                        }
                    } else if (this.f5276a == 304) {
                        C2447ex.f5270b;
                        this.f5277b.mo28340a();
                    } else {
                        this.f5278c = new C2443eu(1, "Internal error");
                        C2447ex.f5270b;
                        this.f5277b.mo28340a();
                    }
                } catch (JSONException e) {
                    this.f5278c = new C2443eu(2, e.getLocalizedMessage());
                    C2447ex.f5270b;
                    this.f5277b.mo28340a();
                }
            }
        }

        /* renamed from: a */
        public final boolean mo28355a() {
            return this.f5278c != null;
        }
    }

    /* renamed from: a */
    private static boolean m5116a(int i) {
        return 500 <= i && i < 600;
    }

    C2447ex(C2446ew ewVar, C2487fs fsVar, long j) {
        this.f5272c = ewVar.f5269c;
        this.f5273d = fsVar;
        this.f5275f = j;
        m5118c();
    }

    /* renamed from: c */
    private void m5118c() {
        String str = "InvalidConfig";
        String str2 = "networkType";
        String str3 = "errorCode";
        String str4 = "name";
        if (!this.f5273d.mo28417a()) {
            try {
                JSONObject jSONObject = new JSONObject(this.f5273d.mo28418b());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str5 = (String) keys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str5);
                    if (this.f5272c.get(str5) != null) {
                        this.f5271a.put(str5, new C2448a(jSONObject2, (C2436er) this.f5272c.get(str5)));
                    }
                }
                HashMap hashMap = new HashMap();
                hashMap.put(str4, m5115a(this.f5272c));
                C2497ga.m5260a().mo28447a("ConfigFetched", hashMap);
            } catch (JSONException e) {
                this.f5274e = new C2443eu(2, e.getLocalizedMessage());
                HashMap hashMap2 = new HashMap();
                hashMap2.put(str3, Integer.valueOf(1));
                hashMap2.put(str4, m5115a(this.f5272c));
                hashMap2.put(str2, C2527gp.m5390b());
                C2497ga.m5260a().mo28447a(str, hashMap2);
            }
        } else {
            for (Entry entry : this.f5272c.entrySet()) {
                C2448a aVar = new C2448a(null, (C2436er) entry.getValue());
                aVar.f5278c = new C2443eu(0, "Network error in fetching config.");
                this.f5271a.put(entry.getKey(), aVar);
            }
            this.f5274e = new C2443eu(0, this.f5273d.f5452a.f5428b);
            HashMap hashMap3 = new HashMap();
            hashMap3.put(str3, String.valueOf(this.f5273d.f5452a.f5427a));
            hashMap3.put(str4, m5115a(this.f5272c));
            hashMap3.put(str2, C2527gp.m5390b());
            C2497ga.m5260a().mo28447a(str, hashMap3);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo28354a() {
        C2487fs fsVar = this.f5273d;
        return (fsVar == null || fsVar.f5452a == null || (this.f5273d.f5452a.f5427a != -7 && !m5116a(this.f5273d.f5452a.f5427a))) ? false : true;
    }

    /* renamed from: a */
    private static String m5115a(Map<String, C2436er> map) {
        StringBuilder sb = new StringBuilder();
        for (String append : map.keySet()) {
            sb.append(append);
            sb.append(",");
        }
        StringBuilder sb2 = new StringBuilder("[");
        sb2.append(sb.substring(0, sb.length() - 1));
        sb2.append("]");
        return sb2.toString();
    }
}
