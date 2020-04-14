package com.moat.analytics.mobile.inm;

import androidx.annotation.VisibleForTesting;
import com.moat.analytics.mobile.inm.p037a.p038a.C2697a;
import com.moat.analytics.mobile.inm.p037a.p039b.C2698a;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.inm.x */
class C2760x<T> implements InvocationHandler {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Object[] f6183a = new Object[0];

    /* renamed from: b */
    private final C2762a<T> f6184b;

    /* renamed from: c */
    private final Class<T> f6185c;

    /* renamed from: d */
    private final LinkedList<C2763b> f6186d = new LinkedList<>();

    /* renamed from: e */
    private boolean f6187e;

    /* renamed from: f */
    private T f6188f;

    /* renamed from: com.moat.analytics.mobile.inm.x$a */
    interface C2762a<T> {
        /* renamed from: a */
        C2698a<T> mo28975a();
    }

    /* renamed from: com.moat.analytics.mobile.inm.x$b */
    class C2763b {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final WeakReference[] f6191b;

        /* renamed from: c */
        private final LinkedList<Object> f6192c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final Method f6193d;

        private C2763b(Method method, Object... objArr) {
            this.f6192c = new LinkedList<>();
            if (objArr == null) {
                objArr = C2760x.f6183a;
            }
            WeakReference[] weakReferenceArr = new WeakReference[objArr.length];
            int length = objArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                Object obj = objArr[i];
                if ((obj instanceof Map) || (obj instanceof Integer) || (obj instanceof Double)) {
                    this.f6192c.add(obj);
                }
                int i3 = i2 + 1;
                weakReferenceArr[i2] = new WeakReference(obj);
                i++;
                i2 = i3;
            }
            this.f6191b = weakReferenceArr;
            this.f6193d = method;
        }
    }

    @VisibleForTesting
    C2760x(C2762a<T> aVar, Class<T> cls) {
        C2697a.m6149a(aVar);
        C2697a.m6149a(cls);
        this.f6184b = aVar;
        this.f6185c = cls;
        C2750w.m6348a().mo29087a((C2756b) new C2756b() {
            /* renamed from: c */
            public void mo29066c() {
                C2760x.this.m6376c();
            }

            /* renamed from: d */
            public void mo29067d() {
            }
        });
    }

    /* renamed from: a */
    static <T> T m6369a(C2762a<T> aVar, Class<T> cls) {
        ClassLoader classLoader = cls.getClassLoader();
        C2760x xVar = new C2760x(aVar, cls);
        return Proxy.newProxyInstance(classLoader, new Class[]{cls}, xVar);
    }

    /* renamed from: a */
    private Object m6370a(Method method) {
        try {
            if (Boolean.TYPE.equals(method.getReturnType())) {
                return Boolean.TRUE;
            }
        } catch (Exception e) {
            C2726m.m6274a(e);
        }
        return null;
    }

    /* renamed from: a */
    private Object m6371a(Method method, Object[] objArr) {
        Class declaringClass = method.getDeclaringClass();
        C2750w a = C2750w.m6348a();
        if (Object.class.equals(declaringClass)) {
            String name = method.getName();
            if ("getClass".equals(name)) {
                return this.f6185c;
            }
            if (!"toString".equals(name)) {
                return method.invoke(this, objArr);
            }
            Object invoke = method.invoke(this, objArr);
            return String.valueOf(invoke).replace(C2760x.class.getName(), this.f6185c.getName());
        } else if (!this.f6187e || this.f6188f != null) {
            if (a.f6155a == C2758d.ON) {
                m6376c();
                T t = this.f6188f;
                if (t != null) {
                    return method.invoke(t, objArr);
                }
            }
            if (a.f6155a == C2758d.OFF && (!this.f6187e || this.f6188f != null)) {
                m6375b(method, objArr);
            }
            return m6370a(method);
        } else {
            this.f6186d.clear();
            return m6370a(method);
        }
    }

    /* renamed from: b */
    private void m6374b() {
        if (!this.f6187e) {
            try {
                this.f6188f = this.f6184b.mo28975a().mo28993c(null);
            } catch (Exception e) {
                C2735p.m6312a("OnOffTrackerProxy", (Object) this, "Could not create instance", (Throwable) e);
                C2726m.m6274a(e);
            }
            this.f6187e = true;
        }
    }

    /* renamed from: b */
    private void m6375b(Method method, Object[] objArr) {
        if (this.f6186d.size() >= 15) {
            this.f6186d.remove(5);
        }
        this.f6186d.add(new C2763b(method, objArr));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m6376c() {
        m6374b();
        if (this.f6188f != null) {
            Iterator it = this.f6186d.iterator();
            while (it.hasNext()) {
                C2763b bVar = (C2763b) it.next();
                try {
                    Object[] objArr = new Object[bVar.f6191b.length];
                    WeakReference[] a = bVar.f6191b;
                    int length = a.length;
                    int i = 0;
                    int i2 = 0;
                    while (i < length) {
                        int i3 = i2 + 1;
                        objArr[i2] = a[i].get();
                        i++;
                        i2 = i3;
                    }
                    bVar.f6193d.invoke(this.f6188f, objArr);
                } catch (Exception e) {
                    C2726m.m6274a(e);
                }
            }
            this.f6186d.clear();
        }
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        try {
            return m6371a(method, objArr);
        } catch (Exception e) {
            C2726m.m6274a(e);
            return m6370a(method);
        }
    }
}
