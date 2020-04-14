package com.inmobi.media;

import androidx.annotation.Nullable;
import com.inmobi.media.C2438es.C2441c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.fd */
/* compiled from: CrashComponent */
public class C2463fd implements C2441c, C2480fn {

    /* renamed from: b */
    public static AtomicBoolean f5358b = new AtomicBoolean(false);

    /* renamed from: e */
    private static final String f5359e = "fd";

    /* renamed from: a */
    public ExecutorService f5360a;

    /* renamed from: c */
    public C2449ey f5361c;

    /* renamed from: d */
    public String f5362d;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C2468fe f5363f;

    /* renamed from: g */
    private C2474fk f5364g;

    /* renamed from: com.inmobi.media.fd$a */
    /* compiled from: CrashComponent */
    static class C2467a {

        /* renamed from: a */
        static final C2463fd f5369a = new C2463fd(0);
    }

    /* synthetic */ C2463fd(byte b) {
        this();
    }

    /* renamed from: a */
    public static C2463fd m5161a() {
        return C2467a.f5369a;
    }

    private C2463fd() {
        Thread.setDefaultUncaughtExceptionHandler(new C2470fg(Thread.getDefaultUncaughtExceptionHandler()));
        this.f5363f = new C2468fe();
        this.f5361c = (C2449ey) C2436er.m5081a("crashReporting", null);
        this.f5360a = Executors.newSingleThreadExecutor();
    }

    /* renamed from: a */
    public void mo27896a(C2436er erVar) {
        this.f5361c = (C2449ey) erVar;
        this.f5362d = this.f5361c.f5280a;
    }

    /* renamed from: a */
    public final void mo28382a(final C2495fz fzVar) {
        if (this.f5361c.f5287h) {
            this.f5360a.execute(new Runnable() {
                public final void run() {
                    C2463fd.this.mo28381a((C2469ff) fzVar);
                    C2463fd.m5163a(C2463fd.this);
                }
            });
        }
    }

    /* renamed from: a */
    public final void mo28381a(C2469ff ffVar) {
        if (!(ffVar instanceof C2495fz)) {
            if (this.f5361c.f5286g) {
                C2497ga.m5260a().mo28447a("CrashEventOccurred", new HashMap());
            } else {
                return;
            }
        }
        this.f5363f.mo28391b(this.f5361c.f5284e);
        if ((this.f5363f.mo28387a() + 1) - this.f5361c.f5283d >= 0) {
            C2468fe.m5172b();
        }
        C2468fe.m5171a(ffVar);
    }

    /* renamed from: b */
    public final C2473fj mo28383b() {
        List<C2469ff> list;
        if (C2527gp.m5386a() != 1) {
            list = C2468fe.m5170a(this.f5361c.f5288i.f5292c);
        } else {
            list = C2468fe.m5170a(this.f5361c.f5289j.f5292c);
        }
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (C2469ff ffVar : list) {
                arrayList.add(Integer.valueOf(ffVar.f5372a));
            }
            String a = m5162a(list);
            if (a != null) {
                return new C2473fj(arrayList, a);
            }
        }
        return null;
    }

    @Nullable
    /* renamed from: a */
    private static String m5162a(List<C2469ff> list) {
        String str = "crash";
        try {
            HashMap hashMap = new HashMap(C2527gp.m5388a(false));
            hashMap.put("im-accid", C2505gd.m5306f());
            hashMap.put("version", "2.0.0");
            hashMap.put("component", str);
            hashMap.put("mk-version", C2506ge.m5316a());
            hashMap.putAll(C2525go.m5384a().f5534c);
            JSONObject jSONObject = new JSONObject(hashMap);
            JSONArray jSONArray = new JSONArray();
            for (C2469ff ffVar : list) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("eventId", ffVar.f5373b);
                jSONObject2.put("eventType", ffVar.f5374c);
                if (!ffVar.mo28394a().trim().isEmpty()) {
                    jSONObject2.put("crash_report", ffVar.mo28394a());
                }
                jSONObject2.put("ts", ffVar.f5376e);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put(str, jSONArray);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m5163a(C2463fd fdVar) {
        C2463fd fdVar2 = fdVar;
        if (!f5358b.get()) {
            C2449ey eyVar = fdVar2.f5361c;
            int i = eyVar.f5282c;
            long j = eyVar.f5284e;
            long j2 = eyVar.f5281b;
            long j3 = eyVar.f5285f;
            int i2 = eyVar.f5289j.f5291b;
            int i3 = eyVar.f5289j.f5292c;
            int i4 = eyVar.f5288i.f5291b;
            int i5 = i4;
            int i6 = eyVar.f5288i.f5292c;
            long j4 = eyVar.f5289j.f5290a;
            long j5 = eyVar.f5288i.f5290a;
            C2471fh fhVar = r2;
            C2471fh fhVar2 = new C2471fh(i, j, j2, j3, i2, i3, i5, i6, j4, j5);
            fhVar.f5384e = fdVar2.f5362d;
            String str = "default";
            fhVar.f5381b = str;
            C2474fk fkVar = fdVar2.f5364g;
            if (fkVar == null) {
                fdVar2.f5364g = new C2474fk(fdVar2.f5363f, fdVar2, fhVar);
            } else {
                fkVar.mo28397a(fhVar);
            }
            fdVar2.f5364g.mo28400a(str, false);
        }
    }
}
