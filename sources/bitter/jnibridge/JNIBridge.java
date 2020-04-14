package bitter.jnibridge;

import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JNIBridge {

    /* renamed from: bitter.jnibridge.JNIBridge$a */
    private static class C0432a implements InvocationHandler {

        /* renamed from: a */
        private Object f30a = new Object[0];

        /* renamed from: b */
        private long f31b;

        /* renamed from: c */
        private Constructor f32c;

        public C0432a(long j) {
            this.f31b = j;
            try {
                this.f32c = Lookup.class.getDeclaredConstructor(new Class[]{Class.class, Integer.TYPE});
                this.f32c.setAccessible(true);
            } catch (NoClassDefFoundError unused) {
                this.f32c = null;
            } catch (NoSuchMethodException unused2) {
                this.f32c = null;
            }
        }

        /* renamed from: a */
        private Object m8a(Object obj, Method method, Object[] objArr) {
            if (objArr == null) {
                objArr = new Object[0];
            }
            Class declaringClass = method.getDeclaringClass();
            return ((Lookup) this.f32c.newInstance(new Object[]{declaringClass, Integer.valueOf(2)})).in(declaringClass).unreflectSpecial(method, declaringClass).bindTo(obj).invokeWithArguments(objArr);
        }

        /* renamed from: a */
        public final void mo7919a() {
            synchronized (this.f30a) {
                this.f31b = 0;
            }
        }

        public final void finalize() {
            synchronized (this.f30a) {
                if (this.f31b != 0) {
                    JNIBridge.delete(this.f31b);
                }
            }
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            synchronized (this.f30a) {
                if (this.f31b == 0) {
                    return null;
                }
                try {
                    Object invoke = JNIBridge.invoke(this.f31b, method.getDeclaringClass(), method, objArr);
                    return invoke;
                } catch (NoSuchMethodError e) {
                    if (this.f32c == null) {
                        System.err.println("JNIBridge error: Java interface default methods are only supported since Android Oreo");
                        throw e;
                    } else if ((method.getModifiers() & 1024) == 0) {
                        return m8a(obj, method, objArr);
                    } else {
                        throw e;
                    }
                }
            }
        }
    }

    static native void delete(long j);

    static void disableInterfaceProxy(Object obj) {
        if (obj != null) {
            ((C0432a) Proxy.getInvocationHandler(obj)).mo7919a();
        }
    }

    static native Object invoke(long j, Class cls, Method method, Object[] objArr);

    static Object newInterfaceProxy(long j, Class[] clsArr) {
        return Proxy.newProxyInstance(JNIBridge.class.getClassLoader(), clsArr, new C0432a(j));
    }
}
