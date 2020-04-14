package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

/* renamed from: com.inmobi.media.co */
/* compiled from: VastProcessor */
public class C2291co {

    /* renamed from: b */
    private static final String f4829b = "co";

    /* renamed from: a */
    public ExecutorService f4830a;

    /* renamed from: c */
    private HashMap<String, List<WeakReference<C2295cp>>> f4831c;

    /* renamed from: com.inmobi.media.co$a */
    /* compiled from: VastProcessor */
    static final class C2294a {

        /* renamed from: a */
        static final C2291co f4840a = new C2291co(0);
    }

    /* synthetic */ C2291co(byte b) {
        this();
    }

    /* renamed from: a */
    public static C2291co m4660a() {
        return C2294a.f4840a;
    }

    private C2291co() {
        this.f4830a = Executors.newCachedThreadPool();
        this.f4831c = new HashMap<>(2);
    }

    /* renamed from: a */
    private synchronized boolean m4663a(String str, C2295cp cpVar) {
        List list = (List) this.f4831c.get(str);
        if (list != null) {
            list.add(new WeakReference(cpVar));
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new WeakReference(cpVar));
        this.f4831c.put(str, arrayList);
        return true;
    }

    /* renamed from: a */
    private synchronized void m4661a(final C2153ac acVar, final boolean z) {
        List<WeakReference> list = (List) this.f4831c.remove(acVar.mo27815f());
        if (list != null) {
            for (WeakReference weakReference : list) {
                final C2295cp cpVar = (C2295cp) weakReference.get();
                if (cpVar != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            cpVar.mo28134a(acVar, z);
                        }
                    });
                }
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m4662a(C2291co coVar, C2153ac acVar, C2426eq eqVar, C2295cp cpVar) {
        try {
            if (coVar.m4663a(acVar.mo27815f(), cpVar)) {
                C2153ac a = C2158ag.m4279a(acVar, eqVar);
                if (a == null) {
                    coVar.m4661a(acVar, false);
                    return;
                }
                coVar.m4661a(a, true);
            }
        } catch (JSONException unused) {
            coVar.m4661a(acVar, false);
        }
    }
}
