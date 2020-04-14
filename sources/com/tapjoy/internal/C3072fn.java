package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* renamed from: com.tapjoy.internal.fn */
public final class C3072fn {

    /* renamed from: com.tapjoy.internal.fn$a */
    static class C3073a implements InvocationHandler {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Object f7243a;

        /* renamed from: b */
        private final Thread f7244b;

        /* renamed from: c */
        private final Looper f7245c;

        public C3073a(Object obj, Thread thread, Looper looper) {
            this.f7243a = obj;
            this.f7244b = thread;
            this.f7245c = looper;
        }

        public final Object invoke(Object obj, final Method method, final Object[] objArr) {
            if (this.f7244b == Thread.currentThread()) {
                return method.invoke(this.f7243a, objArr);
            }
            if (method.getReturnType().equals(Void.TYPE)) {
                C30741 r4 = new Runnable() {
                    public final void run() {
                        try {
                            method.invoke(C3073a.this.f7243a, objArr);
                        } catch (IllegalArgumentException e) {
                            throw C1853jr.m3670a(e);
                        } catch (IllegalAccessException e2) {
                            throw C1853jr.m3670a(e2);
                        } catch (InvocationTargetException e3) {
                            throw C1853jr.m3670a(e3);
                        }
                    }
                };
                Looper looper = this.f7245c;
                if (looper != null && new Handler(looper).post(r4)) {
                    return null;
                }
                if (this.f7244b == C3114gr.m7197b() && C3114gr.f7346a.mo29867a(r4)) {
                    return null;
                }
                Looper mainLooper = Looper.getMainLooper();
                if (mainLooper == null || !new Handler(mainLooper).post(r4)) {
                    return method.invoke(this.f7243a, objArr);
                }
                return null;
            }
            StringBuilder sb = new StringBuilder("method not return void: ");
            sb.append(method.getName());
            throw new UnsupportedOperationException(sb.toString());
        }
    }

    /* renamed from: a */
    public static Object m7099a(Object obj, Class cls) {
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new C3073a(obj, Thread.currentThread(), Looper.myLooper()));
    }
}
