package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewParent;
import com.tapjoy.internal.C2952di.C2953a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.dv */
public final class C2969dv implements C2953a {

    /* renamed from: a */
    public static Handler f6844a = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private static C2969dv f6845c = new C2969dv();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static Handler f6846d = null;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final Runnable f6847j = new Runnable() {
        public final void run() {
            C2969dv.m6776b(C2969dv.m6771a());
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static final Runnable f6848k = new Runnable() {
        public final void run() {
            if (C2969dv.f6846d != null) {
                C2969dv.f6846d.post(C2969dv.f6847j);
                C2969dv.f6846d.postDelayed(C2969dv.f6848k, 200);
            }
        }
    };

    /* renamed from: b */
    public List f6849b = new ArrayList();

    /* renamed from: e */
    private int f6850e;

    /* renamed from: f */
    private C2954dj f6851f = new C2954dj();

    /* renamed from: g */
    private C2973dw f6852g = new C2973dw();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C2983ed f6853h = new C2983ed(new C2978dz());

    /* renamed from: i */
    private long f6854i;

    C2969dv() {
    }

    /* renamed from: a */
    public static C2969dv m6771a() {
        return f6845c;
    }

    /* renamed from: a */
    private void m6773a(long j) {
        if (this.f6849b.size() > 0) {
            Iterator it = this.f6849b.iterator();
            while (it.hasNext()) {
                it.next();
                TimeUnit.NANOSECONDS.toMillis(j);
            }
        }
    }

    /* renamed from: a */
    private void m6774a(View view, C2952di diVar, JSONObject jSONObject, int i) {
        diVar.mo29952a(view, jSONObject, this, i == C2984ee.f6882a);
    }

    /* renamed from: b */
    public static void m6775b() {
        if (f6846d == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f6846d = handler;
            handler.post(f6847j);
            f6846d.postDelayed(f6848k, 200);
        }
    }

    /* renamed from: c */
    public static void m6777c() {
        Handler handler = f6846d;
        if (handler != null) {
            handler.removeCallbacks(f6848k);
            f6846d = null;
        }
    }

    /* renamed from: a */
    public final void mo29953a(View view, C2952di diVar, JSONObject jSONObject) {
        String str;
        boolean z = false;
        if (C2961dp.m6759c(view) == null) {
            C2973dw dwVar = this.f6852g;
            int i = dwVar.f6859d.contains(view) ? C2984ee.f6882a : dwVar.f6863h ? C2984ee.f6883b : C2984ee.f6884c;
            if (i != C2984ee.f6884c) {
                JSONObject a = diVar.mo29951a(view);
                C2957dm.m6748a(jSONObject, a);
                C2973dw dwVar2 = this.f6852g;
                ArrayList arrayList = null;
                if (dwVar2.f6856a.size() == 0) {
                    str = null;
                } else {
                    str = (String) dwVar2.f6856a.get(view);
                    if (str != null) {
                        dwVar2.f6856a.remove(view);
                    }
                }
                if (str != null) {
                    C2957dm.m6745a(a, str);
                    this.f6852g.f6863h = true;
                    z = true;
                }
                if (!z) {
                    C2973dw dwVar3 = this.f6852g;
                    if (dwVar3.f6858c.size() != 0) {
                        arrayList = (ArrayList) dwVar3.f6858c.get(view);
                        if (arrayList != null) {
                            dwVar3.f6858c.remove(view);
                            Collections.sort(arrayList);
                        }
                    }
                    if (arrayList != null) {
                        C2957dm.m6747a(a, (List) arrayList);
                    }
                    m6774a(view, diVar, a, i);
                }
                this.f6850e++;
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m6776b(C2969dv dvVar) {
        Object obj;
        dvVar.f6850e = 0;
        dvVar.f6854i = System.nanoTime();
        C2973dw dwVar = dvVar.f6852g;
        C2944dd a = C2944dd.m6718a();
        if (a != null) {
            for (C2940cz czVar : Collections.unmodifiableCollection(a.f6801b)) {
                View c = czVar.mo29926c();
                if (czVar.mo29927d()) {
                    String str = czVar.f6784f;
                    if (c != null) {
                        if (c.hasWindowFocus()) {
                            HashSet hashSet = new HashSet();
                            View view = c;
                            while (true) {
                                if (view == null) {
                                    dwVar.f6859d.addAll(hashSet);
                                    obj = null;
                                    break;
                                }
                                String c2 = C2961dp.m6759c(view);
                                if (c2 != null) {
                                    obj = c2;
                                    break;
                                }
                                hashSet.add(view);
                                ViewParent parent = view.getParent();
                                view = parent instanceof View ? (View) parent : null;
                            }
                        } else {
                            obj = "noWindowFocus";
                        }
                        if (obj == null) {
                            dwVar.f6860e.add(str);
                            dwVar.f6856a.put(c, str);
                            dwVar.mo29967a(czVar);
                        } else {
                            dwVar.f6861f.add(str);
                            dwVar.f6857b.put(str, c);
                            dwVar.f6862g.put(str, obj);
                        }
                    } else {
                        dwVar.f6861f.add(str);
                        dwVar.f6862g.put(str, "noAdView");
                    }
                }
            }
        }
        long nanoTime = System.nanoTime();
        C2955dk dkVar = dvVar.f6851f.f6822b;
        if (dvVar.f6852g.f6861f.size() > 0) {
            Iterator it = dvVar.f6852g.f6861f.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                JSONObject a2 = dkVar.mo29951a(null);
                View view2 = (View) dvVar.f6852g.f6857b.get(str2);
                C2956dl dlVar = dvVar.f6851f.f6821a;
                String str3 = (String) dvVar.f6852g.f6862g.get(str2);
                if (str3 != null) {
                    JSONObject a3 = dlVar.mo29951a(view2);
                    C2957dm.m6745a(a3, str2);
                    C2957dm.m6750b(a3, str3);
                    C2957dm.m6748a(a2, a3);
                }
                C2957dm.m6744a(a2);
                HashSet hashSet2 = new HashSet();
                hashSet2.add(str2);
                C2983ed edVar = dvVar.f6853h;
                C2978dz dzVar = edVar.f6880a;
                C2981eb ebVar = new C2981eb(edVar, hashSet2, a2, nanoTime);
                dzVar.mo29973a(ebVar);
            }
        }
        if (dvVar.f6852g.f6860e.size() > 0) {
            JSONObject a4 = dkVar.mo29951a(null);
            dvVar.m6774a(null, dkVar, a4, C2984ee.f6882a);
            C2957dm.m6744a(a4);
            C2983ed edVar2 = dvVar.f6853h;
            HashSet hashSet3 = dvVar.f6852g.f6860e;
            C2978dz dzVar2 = edVar2.f6880a;
            C2982ec ecVar = new C2982ec(edVar2, hashSet3, a4, nanoTime);
            dzVar2.mo29973a(ecVar);
        } else {
            dvVar.f6853h.mo29977b();
        }
        C2973dw dwVar2 = dvVar.f6852g;
        dwVar2.f6856a.clear();
        dwVar2.f6857b.clear();
        dwVar2.f6858c.clear();
        dwVar2.f6859d.clear();
        dwVar2.f6860e.clear();
        dwVar2.f6861f.clear();
        dwVar2.f6862g.clear();
        dwVar2.f6863h = false;
        dvVar.m6773a(System.nanoTime() - dvVar.f6854i);
    }
}
