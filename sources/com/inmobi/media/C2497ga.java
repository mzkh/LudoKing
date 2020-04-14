package com.inmobi.media;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.ga */
/* compiled from: TelemetryComponent */
public class C2497ga implements C2480fn {

    /* renamed from: b */
    public static AtomicBoolean f5475b = new AtomicBoolean(false);
    @VisibleForTesting

    /* renamed from: c */
    public static double f5476c = Math.random();

    /* renamed from: d */
    private static final String f5477d = "ga";

    /* renamed from: h */
    private static final ArrayList<String> f5478h = new ArrayList<>(Arrays.asList(new String[]{"AdLoadSuccessful", "AdLoadFailed", "ServerFill", "ServerNoFill", "ServerError", "AssetDownloaded"}));

    /* renamed from: a */
    public ExecutorService f5479a;

    /* renamed from: e */
    private C2460fc f5480e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C2503gb f5481f;

    /* renamed from: g */
    private String f5482g;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C2474fk f5483i;

    /* renamed from: com.inmobi.media.ga$a */
    /* compiled from: TelemetryComponent */
    static class C2502a {

        /* renamed from: a */
        static final C2497ga f5489a = new C2497ga(0);
    }

    /* synthetic */ C2497ga(byte b) {
        this();
    }

    /* renamed from: a */
    public static C2497ga m5260a() {
        return C2502a.f5489a;
    }

    /* renamed from: c */
    public final void mo28448c() {
        f5475b.set(false);
        this.f5480e = (C2460fc) C2438es.m5087a("telemetry", C2505gd.m5306f(), null);
        this.f5482g = this.f5480e.f5338a;
        this.f5479a.execute(new Runnable() {
            public final void run() {
                C2497ga.this.f5479a.execute(new Runnable() {
                    public final void run() {
                        if (C2497ga.this.f5481f.mo28387a() > 0) {
                            C2497ga.m5266d(C2497ga.this);
                        }
                    }
                });
            }
        });
    }

    private C2497ga() {
        this.f5481f = new C2503gb();
        this.f5479a = Executors.newSingleThreadExecutor();
        this.f5480e = (C2460fc) C2436er.m5081a("telemetry", null);
        this.f5482g = this.f5480e.f5338a;
    }

    /* renamed from: a */
    public final void mo28447a(String str, @NonNull Map<String, Object> map) {
        try {
            C2504gc gcVar = new C2504gc(str);
            if (map != null && !map.isEmpty() && str.equals("AssetDownloaded")) {
                for (Entry entry : map.entrySet()) {
                    if ("assetType".equals(entry.getKey())) {
                        if (MessengerShareContentUtility.MEDIA_IMAGE.equals(entry.getKey()) && !this.f5480e.f5350o.f5352b) {
                            return;
                        }
                        if ("gif".equals(entry.getKey()) && !this.f5480e.f5350o.f5353c) {
                            return;
                        }
                        if ("video".equals(entry.getKey()) && !this.f5480e.f5350o.f5351a) {
                            return;
                        }
                    }
                }
            }
            map.put("eventType", gcVar.f5492b);
            map.put("eventId", UUID.randomUUID().toString());
            gcVar.f5494d = map.toString();
            m5264b(gcVar);
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    private void m5264b(final C2504gc gcVar) {
        if (this.f5480e.f5347j) {
            if (this.f5480e.f5343f && !this.f5480e.f5346i.contains(gcVar.f5492b)) {
                return;
            }
            if (!f5478h.contains(gcVar.f5492b) || f5476c >= this.f5480e.f5345h) {
                if ("CrashEventOccurred".equals(gcVar.f5492b)) {
                    mo28446a(gcVar);
                } else {
                    this.f5479a.execute(new Runnable() {
                        public final void run() {
                            C2497ga.this.mo28446a(gcVar);
                            C2497ga.m5266d(C2497ga.this);
                        }
                    });
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo28446a(C2504gc gcVar) {
        if (this.f5480e.f5347j) {
            int a = (this.f5481f.mo28387a() + 1) - this.f5480e.f5341d;
            if (a > 0) {
                this.f5481f.mo28453b(a);
            }
            C2503gb.m5273a(gcVar);
        }
    }

    /* renamed from: b */
    public final C2473fj mo28383b() {
        List<C2504gc> list;
        if (C2527gp.m5386a() != 1) {
            list = C2503gb.m5272a(this.f5480e.f5348k.f5356c);
        } else {
            list = C2503gb.m5272a(this.f5480e.f5349l.f5356c);
        }
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (C2504gc gcVar : list) {
                arrayList.add(Integer.valueOf(gcVar.f5491a));
            }
            String a = m5261a(list);
            if (a != null) {
                return new C2473fj(arrayList, a);
            }
        }
        return null;
    }

    @Nullable
    /* renamed from: a */
    private static String m5261a(List<C2504gc> list) {
        try {
            HashMap hashMap = new HashMap();
            String str = "";
            hashMap.put("im-accid", C2505gd.m5308g() != null ? C2505gd.m5308g() : str);
            String str2 = "as-accid";
            if (C2505gd.m5310h() != null) {
                str = C2505gd.m5310h();
            }
            hashMap.put(str2, str);
            hashMap.put("version", "4.0.0");
            hashMap.put("mk-version", C2506ge.m5316a());
            hashMap.put("u-appbid", C2525go.m5384a().f5532a);
            JSONObject jSONObject = new JSONObject(hashMap);
            JSONArray jSONArray = new JSONArray();
            for (C2504gc gcVar : list) {
                if (!gcVar.mo28454a().trim().isEmpty()) {
                    jSONArray.put(new JSONObject(gcVar.mo28454a()));
                }
            }
            jSONObject.put(MessengerShareContentUtility.ATTACHMENT_PAYLOAD, jSONArray);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m5266d(C2497ga gaVar) {
        C2497ga gaVar2 = gaVar;
        if (!f5475b.get()) {
            C2460fc fcVar = gaVar2.f5480e;
            int i = fcVar.f5340c;
            long j = fcVar.f5342e;
            long j2 = fcVar.f5339b;
            long j3 = fcVar.f5344g;
            int i2 = fcVar.f5349l.f5355b;
            int i3 = fcVar.f5349l.f5356c;
            int i4 = fcVar.f5348k.f5355b;
            int i5 = i4;
            int i6 = fcVar.f5348k.f5356c;
            long j4 = fcVar.f5349l.f5354a;
            long j5 = fcVar.f5348k.f5354a;
            C2471fh fhVar = r2;
            C2471fh fhVar2 = new C2471fh(i, j, j2, j3, i2, i3, i5, i6, j4, j5);
            fhVar.f5384e = gaVar2.f5482g;
            String str = "default";
            fhVar.f5381b = str;
            C2474fk fkVar = gaVar2.f5483i;
            if (fkVar == null) {
                gaVar2.f5483i = new C2474fk(gaVar2.f5481f, gaVar2, fhVar);
            } else {
                fkVar.mo28397a(fhVar);
            }
            gaVar2.f5483i.mo28400a(str, true);
        }
    }
}
