package com.unity3d.player;

import java.lang.reflect.Method;
import java.util.HashMap;

/* renamed from: com.unity3d.player.n */
final class C3356n {

    /* renamed from: a */
    private HashMap f8034a = new HashMap();

    /* renamed from: b */
    private Class f8035b = null;

    /* renamed from: c */
    private Object f8036c = null;

    /* renamed from: com.unity3d.player.n$a */
    class C3357a {

        /* renamed from: a */
        public Class[] f8037a;

        /* renamed from: b */
        public Method f8038b = null;

        public C3357a(Class[] clsArr) {
            this.f8037a = clsArr;
        }
    }

    public C3356n(Class cls, Object obj) {
        this.f8035b = cls;
        this.f8036c = obj;
    }

    /* renamed from: a */
    private void m7763a(String str, C3357a aVar) {
        try {
            aVar.f8038b = this.f8035b.getMethod(str, aVar.f8037a);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("Exception while trying to get method ");
            sb.append(str);
            sb.append(". ");
            sb.append(e.getLocalizedMessage());
            C3342f.Log(6, sb.toString());
            aVar.f8038b = null;
        }
    }

    /* renamed from: a */
    public final Object mo30750a(String str, Object... objArr) {
        StringBuilder sb;
        Object obj = null;
        if (!this.f8034a.containsKey(str)) {
            sb = new StringBuilder("No definition for method ");
            sb.append(str);
            str = " can be found";
        } else {
            C3357a aVar = (C3357a) this.f8034a.get(str);
            if (aVar.f8038b == null) {
                m7763a(str, aVar);
            }
            if (aVar.f8038b == null) {
                sb = new StringBuilder("Unable to create method: ");
            } else {
                try {
                    obj = objArr.length == 0 ? aVar.f8038b.invoke(this.f8036c, new Object[0]) : aVar.f8038b.invoke(this.f8036c, objArr);
                } catch (Exception e) {
                    StringBuilder sb2 = new StringBuilder("Error trying to call delegated method ");
                    sb2.append(str);
                    sb2.append(". ");
                    sb2.append(e.getLocalizedMessage());
                    C3342f.Log(6, sb2.toString());
                }
                return obj;
            }
        }
        sb.append(str);
        C3342f.Log(6, sb.toString());
        return null;
    }

    /* renamed from: a */
    public final void mo30751a(String str, Class[] clsArr) {
        this.f8034a.put(str, new C3357a(clsArr));
    }
}
