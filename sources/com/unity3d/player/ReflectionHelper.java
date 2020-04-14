package com.unity3d.player;

import androidx.exifinterface.media.ExifInterface;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;

final class ReflectionHelper {
    protected static boolean LOG = false;
    protected static final boolean LOGV = false;

    /* renamed from: a */
    private static C3296a[] f7838a = new C3296a[4096];
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static long f7839b = 0;

    /* renamed from: com.unity3d.player.ReflectionHelper$a */
    private static class C3296a {

        /* renamed from: a */
        public volatile Member f7845a;

        /* renamed from: b */
        private final Class f7846b;

        /* renamed from: c */
        private final String f7847c;

        /* renamed from: d */
        private final String f7848d;

        /* renamed from: e */
        private final int f7849e = (((((this.f7846b.hashCode() + 527) * 31) + this.f7847c.hashCode()) * 31) + this.f7848d.hashCode());

        C3296a(Class cls, String str, String str2) {
            this.f7846b = cls;
            this.f7847c = str;
            this.f7848d = str2;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof C3296a) {
                C3296a aVar = (C3296a) obj;
                return this.f7849e == aVar.f7849e && this.f7848d.equals(aVar.f7848d) && this.f7847c.equals(aVar.f7847c) && this.f7846b.equals(aVar.f7846b);
            }
        }

        public final int hashCode() {
            return this.f7849e;
        }
    }

    /* renamed from: com.unity3d.player.ReflectionHelper$b */
    protected interface C3297b extends InvocationHandler {
        /* renamed from: a */
        void mo30593a(long j, boolean z);
    }

    ReflectionHelper() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:8|9|(2:11|12)|13|14|(2:16|17)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001e */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0024  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static float m7606a(java.lang.Class r1, java.lang.Class r2) {
        /*
            boolean r0 = r1.equals(r2)
            if (r0 == 0) goto L_0x0009
            r1 = 1065353216(0x3f800000, float:1.0)
            return r1
        L_0x0009:
            boolean r0 = r1.isPrimitive()
            if (r0 != 0) goto L_0x0028
            boolean r0 = r2.isPrimitive()
            if (r0 != 0) goto L_0x0028
            java.lang.Class r0 = r1.asSubclass(r2)     // Catch:{ ClassCastException -> 0x001e }
            if (r0 == 0) goto L_0x001e
            r1 = 1056964608(0x3f000000, float:0.5)
            return r1
        L_0x001e:
            java.lang.Class r1 = r2.asSubclass(r1)     // Catch:{ ClassCastException -> 0x0028 }
            if (r1 == 0) goto L_0x0028
            r1 = 1036831949(0x3dcccccd, float:0.1)
            return r1
        L_0x0028:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.ReflectionHelper.m7606a(java.lang.Class, java.lang.Class):float");
    }

    /* renamed from: a */
    private static float m7607a(Class cls, Class[] clsArr, Class[] clsArr2) {
        if (clsArr2.length == 0) {
            return 0.1f;
        }
        int i = 0;
        if ((clsArr == null ? 0 : clsArr.length) + 1 != clsArr2.length) {
            return 0.0f;
        }
        float f = 1.0f;
        if (clsArr != null) {
            int i2 = 0;
            while (i < clsArr.length) {
                f *= m7606a(clsArr[i], clsArr2[i2]);
                i++;
                i2++;
            }
        }
        return f * m7606a(cls, clsArr2[clsArr2.length - 1]);
    }

    /* renamed from: a */
    private static Class m7609a(String str, int[] iArr) {
        while (true) {
            if (iArr[0] >= str.length()) {
                break;
            }
            int i = iArr[0];
            iArr[0] = i + 1;
            char charAt = str.charAt(i);
            if (charAt != '(' && charAt != ')') {
                if (charAt == 'L') {
                    int indexOf = str.indexOf(59, iArr[0]);
                    if (indexOf != -1) {
                        String substring = str.substring(iArr[0], indexOf);
                        iArr[0] = indexOf + 1;
                        try {
                            return Class.forName(substring.replace('/', '.'));
                        } catch (ClassNotFoundException unused) {
                        }
                    }
                } else if (charAt == 'Z') {
                    return Boolean.TYPE;
                } else {
                    if (charAt == 'I') {
                        return Integer.TYPE;
                    }
                    if (charAt == 'F') {
                        return Float.TYPE;
                    }
                    if (charAt == 'V') {
                        return Void.TYPE;
                    }
                    if (charAt == 'B') {
                        return Byte.TYPE;
                    }
                    if (charAt == 'C') {
                        return Character.TYPE;
                    }
                    if (charAt == 'S') {
                        return Short.TYPE;
                    }
                    if (charAt == 'J') {
                        return Long.TYPE;
                    }
                    if (charAt == 'D') {
                        return Double.TYPE;
                    }
                    if (charAt == '[') {
                        return Array.newInstance(m7609a(str, iArr), 0).getClass();
                    }
                    StringBuilder sb = new StringBuilder("! parseType; ");
                    sb.append(charAt);
                    sb.append(" is not known!");
                    C3342f.Log(5, sb.toString());
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private static synchronized void m7612a(C3296a aVar, Member member) {
        synchronized (ReflectionHelper.class) {
            aVar.f7845a = member;
            f7838a[aVar.hashCode() & (f7838a.length - 1)] = aVar;
        }
    }

    /* renamed from: a */
    private static synchronized boolean m7613a(C3296a aVar) {
        synchronized (ReflectionHelper.class) {
            C3296a aVar2 = f7838a[aVar.hashCode() & (f7838a.length - 1)];
            if (!aVar.equals(aVar2)) {
                return false;
            }
            aVar.f7845a = aVar2.f7845a;
            return true;
        }
    }

    /* renamed from: a */
    private static Class[] m7614a(String str) {
        int i = 0;
        int[] iArr = {0};
        ArrayList arrayList = new ArrayList();
        while (iArr[0] < str.length()) {
            Class a = m7609a(str, iArr);
            if (a == null) {
                break;
            }
            arrayList.add(a);
        }
        Class[] clsArr = new Class[arrayList.size()];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int i2 = i + 1;
            clsArr[i] = (Class) it.next();
            i = i2;
        }
        return clsArr;
    }

    protected static void endUnityLaunch() {
        f7839b++;
    }

    protected static Constructor getConstructorID(Class cls, String str) {
        Constructor constructor;
        C3296a aVar = new C3296a(cls, "", str);
        if (m7613a(aVar)) {
            constructor = (Constructor) aVar.f7845a;
        } else {
            Class[] a = m7614a(str);
            float f = 0.0f;
            Constructor[] constructors = cls.getConstructors();
            int length = constructors.length;
            int i = 0;
            Constructor constructor2 = null;
            while (true) {
                if (i >= length) {
                    break;
                }
                Constructor constructor3 = constructors[i];
                float a2 = m7607a(Void.TYPE, constructor3.getParameterTypes(), a);
                if (a2 > f) {
                    if (a2 == 1.0f) {
                        constructor2 = constructor3;
                        break;
                    }
                    constructor2 = constructor3;
                    f = a2;
                }
                i++;
            }
            m7612a(aVar, (Member) constructor2);
            constructor = constructor2;
        }
        if (constructor != null) {
            return constructor;
        }
        StringBuilder sb = new StringBuilder("<init>");
        sb.append(str);
        sb.append(" in class ");
        sb.append(cls.getName());
        throw new NoSuchMethodError(sb.toString());
    }

    protected static Field getFieldID(Class cls, String str, String str2, boolean z) {
        Field field;
        String str3 = str;
        String str4 = str2;
        boolean z2 = z;
        Class cls2 = cls;
        C3296a aVar = new C3296a(cls2, str3, str4);
        if (m7613a(aVar)) {
            field = (Field) aVar.f7845a;
        } else {
            Class[] a = m7614a(str2);
            float f = 0.0f;
            Field field2 = null;
            while (cls2 != null) {
                Field[] declaredFields = cls2.getDeclaredFields();
                int length = declaredFields.length;
                Field field3 = field2;
                float f2 = f;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        f = f2;
                        field2 = field3;
                        break;
                    }
                    Field field4 = declaredFields[i];
                    if (z2 == Modifier.isStatic(field4.getModifiers()) && field4.getName().compareTo(str3) == 0) {
                        float a2 = m7607a(field4.getType(), (Class[]) null, a);
                        if (a2 > f2) {
                            if (a2 == 1.0f) {
                                field2 = field4;
                                f = a2;
                                break;
                            }
                            field3 = field4;
                            f2 = a2;
                        } else {
                            continue;
                        }
                    }
                    i++;
                }
                if (f == 1.0f || cls2.isPrimitive() || cls2.isInterface() || cls2.equals(Object.class) || cls2.equals(Void.TYPE)) {
                    break;
                }
                cls2 = cls2.getSuperclass();
            }
            m7612a(aVar, (Member) field2);
            field = field2;
        }
        if (field != null) {
            return field;
        }
        Object[] objArr = new Object[4];
        objArr[0] = z2 ? "static" : "non-static";
        objArr[1] = str3;
        objArr[2] = str4;
        objArr[3] = cls2.getName();
        throw new NoSuchFieldError(String.format("no %s field with name='%s' signature='%s' in class L%s;", objArr));
    }

    protected static String getFieldSignature(Field field) {
        Class type = field.getType();
        if (type.isPrimitive()) {
            String name = type.getName();
            if ("boolean".equals(name)) {
                return "Z";
            }
            if ("byte".equals(name)) {
                return "B";
            }
            if ("char".equals(name)) {
                return "C";
            }
            if ("double".equals(name)) {
                return "D";
            }
            if ("float".equals(name)) {
                return "F";
            }
            if ("int".equals(name)) {
                return "I";
            }
            if ("long".equals(name)) {
                return "J";
            }
            if ("short".equals(name)) {
                name = ExifInterface.LATITUDE_SOUTH;
            }
            return name;
        } else if (type.isArray()) {
            return type.getName().replace('.', '/');
        } else {
            StringBuilder sb = new StringBuilder("L");
            sb.append(type.getName().replace('.', '/'));
            sb.append(";");
            return sb.toString();
        }
    }

    protected static Method getMethodID(Class cls, String str, String str2, boolean z) {
        Method method;
        String str3 = str;
        String str4 = str2;
        boolean z2 = z;
        Class cls2 = cls;
        C3296a aVar = new C3296a(cls2, str3, str4);
        if (m7613a(aVar)) {
            method = (Method) aVar.f7845a;
        } else {
            Class[] a = m7614a(str2);
            float f = 0.0f;
            Method method2 = null;
            while (cls2 != null) {
                Method[] declaredMethods = cls2.getDeclaredMethods();
                int length = declaredMethods.length;
                Method method3 = method2;
                float f2 = f;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        f = f2;
                        method2 = method3;
                        break;
                    }
                    Method method4 = declaredMethods[i];
                    if (z2 == Modifier.isStatic(method4.getModifiers()) && method4.getName().compareTo(str3) == 0) {
                        float a2 = m7607a(method4.getReturnType(), method4.getParameterTypes(), a);
                        if (a2 > f2) {
                            if (a2 == 1.0f) {
                                f = a2;
                                method2 = method4;
                                break;
                            }
                            f2 = a2;
                            method3 = method4;
                        } else {
                            continue;
                        }
                    }
                    i++;
                }
                if (f == 1.0f || cls2.isPrimitive() || cls2.isInterface() || cls2.equals(Object.class) || cls2.equals(Void.TYPE)) {
                    break;
                }
                cls2 = z2 ? null : cls2.getSuperclass();
            }
            m7612a(aVar, (Member) method2);
            method = method2;
        }
        if (method != null) {
            return method;
        }
        Object[] objArr = new Object[4];
        objArr[0] = z2 ? "static" : "non-static";
        objArr[1] = str3;
        objArr[2] = str4;
        objArr[3] = cls2.getName();
        throw new NoSuchMethodError(String.format("no %s method with name='%s' signature='%s' in class L%s;", objArr));
    }

    /* access modifiers changed from: private */
    public static native void nativeProxyFinalize(long j);

    /* access modifiers changed from: private */
    public static native Object nativeProxyInvoke(long j, String str, Object[] objArr);

    /* access modifiers changed from: private */
    public static native void nativeProxyLogJNIInvokeException(long j);

    protected static Object newProxyInstance(long j, Class cls) {
        return newProxyInstance(j, new Class[]{cls});
    }

    protected static Object newProxyInstance(final long j, final Class[] clsArr) {
        return Proxy.newProxyInstance(ReflectionHelper.class.getClassLoader(), clsArr, new C3297b() {

            /* renamed from: c */
            private long f7842c = ReflectionHelper.f7839b;

            /* renamed from: d */
            private long f7843d;

            /* renamed from: e */
            private boolean f7844e;

            /* renamed from: a */
            private Object m7616a(Object obj, Method method, Object[] objArr) {
                if (objArr == null) {
                    try {
                        objArr = new Object[0];
                    } catch (NoClassDefFoundError unused) {
                        C3342f.Log(6, String.format("Java interface default methods are only supported since Android Oreo", new Object[0]));
                        ReflectionHelper.nativeProxyLogJNIInvokeException(this.f7843d);
                        return null;
                    }
                }
                Class declaringClass = method.getDeclaringClass();
                Constructor declaredConstructor = Lookup.class.getDeclaredConstructor(new Class[]{Class.class, Integer.TYPE});
                declaredConstructor.setAccessible(true);
                return ((Lookup) declaredConstructor.newInstance(new Object[]{declaringClass, Integer.valueOf(2)})).in(declaringClass).unreflectSpecial(method, declaringClass).bindTo(obj).invokeWithArguments(objArr);
            }

            /* renamed from: a */
            public final void mo30593a(long j, boolean z) {
                this.f7843d = j;
                this.f7844e = z;
            }

            /* access modifiers changed from: protected */
            public final void finalize() {
                try {
                    if (this.f7842c == ReflectionHelper.f7839b) {
                        ReflectionHelper.nativeProxyFinalize(j);
                    }
                } finally {
                    super.finalize();
                }
            }

            /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
                if (r6 != 0) goto L_0x003d;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invoke(java.lang.Object r6, java.lang.reflect.Method r7, java.lang.Object[] r8) {
                /*
                    r5 = this;
                    long r0 = r5.f7842c
                    long r2 = com.unity3d.player.ReflectionHelper.f7839b
                    int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r4 == 0) goto L_0x0012
                    r6 = 6
                    java.lang.String r7 = "Scripting proxy object was destroyed, because Unity player was unloaded."
                    com.unity3d.player.C3342f.Log(r6, r7)
                    r6 = 0
                    return r6
                L_0x0012:
                    r0 = 0
                    r5.f7843d = r0
                    r2 = 0
                    r5.f7844e = r2
                    long r2 = r2
                    java.lang.String r4 = r7.getName()
                    java.lang.Object r2 = com.unity3d.player.ReflectionHelper.nativeProxyInvoke(r2, r4, r8)
                    boolean r3 = r5.f7844e
                    if (r3 == 0) goto L_0x0037
                    int r0 = r7.getModifiers()
                    r0 = r0 & 1024(0x400, float:1.435E-42)
                    if (r0 != 0) goto L_0x0034
                    java.lang.Object r6 = r5.m7616a(r6, r7, r8)
                    return r6
                L_0x0034:
                    long r6 = r5.f7843d
                    goto L_0x003d
                L_0x0037:
                    long r6 = r5.f7843d
                    int r8 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
                    if (r8 == 0) goto L_0x0040
                L_0x003d:
                    com.unity3d.player.ReflectionHelper.nativeProxyLogJNIInvokeException(r6)
                L_0x0040:
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.ReflectionHelper.C32951.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
            }
        });
    }

    protected static void setNativeExceptionOnProxy(Object obj, long j, boolean z) {
        ((C3297b) Proxy.getInvocationHandler(obj)).mo30593a(j, z);
    }
}
