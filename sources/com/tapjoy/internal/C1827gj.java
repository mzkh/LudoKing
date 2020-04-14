package com.tapjoy.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tapjoy.internal.gj */
public class C1827gj extends Observable {

    /* renamed from: b */
    public final List f3804b = new ArrayList();

    /* renamed from: com.tapjoy.internal.gj$a */
    public class C1828a {

        /* renamed from: a */
        public final String f3805a;

        /* renamed from: b */
        public volatile Map f3806b = new ConcurrentHashMap();

        C1828a(String str) {
            this.f3805a = str;
        }

        /* renamed from: a */
        public final Object mo18111a(String str) {
            Map map = this.f3806b;
            if (map != null) {
                return map.get(str);
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C1828a mo18106a(String str) {
        C1828a aVar = new C1828a(str);
        this.f3804b.add(aVar);
        return aVar;
    }

    /* access modifiers changed from: protected */
    public void setChanged() {
        super.setChanged();
        notifyObservers();
    }

    /* renamed from: a */
    public final boolean mo18107a(String str, boolean z) {
        for (C1828a a : this.f3804b) {
            Object a2 = a.mo18111a(str);
            if (a2 != null) {
                if (a2 instanceof Boolean) {
                    return ((Boolean) a2).booleanValue();
                }
                if (!(a2 instanceof String)) {
                    continue;
                } else if ("true".equals(a2)) {
                    return true;
                } else {
                    if ("false".equals(a2)) {
                        return false;
                    }
                }
            }
        }
        return z;
    }

    /* renamed from: b */
    public final long mo18108b(String str) {
        for (C1828a a : this.f3804b) {
            Object a2 = a.mo18111a(str);
            if (a2 != null) {
                if (a2 instanceof Number) {
                    return ((Number) a2).longValue();
                }
                if (a2 instanceof String) {
                    try {
                        return Long.parseLong((String) a2);
                    } catch (IllegalArgumentException unused) {
                    }
                } else {
                    continue;
                }
            }
        }
        return 0;
    }

    /* renamed from: a */
    private static long m3541a(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        if (obj instanceof String) {
            return Long.parseLong((String) obj);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: c */
    public final C3107gi mo18109c(String str) {
        double parseDouble;
        for (C1828a a : this.f3804b) {
            Object a2 = a.mo18111a(str);
            if (a2 instanceof List) {
                List list = (List) a2;
                try {
                    long a3 = m3541a(list.get(0));
                    long a4 = m3541a(list.get(1));
                    long a5 = m3541a(list.get(2));
                    Object obj = list.get(3);
                    if (obj instanceof Number) {
                        parseDouble = ((Number) obj).doubleValue();
                    } else if (obj instanceof String) {
                        parseDouble = Double.parseDouble((String) obj);
                    } else {
                        throw new IllegalArgumentException();
                    }
                    C3107gi giVar = new C3107gi(a3, a4, a5, parseDouble);
                    return giVar;
                } catch (RuntimeException unused) {
                }
            }
        }
        return C3107gi.f7337a;
    }
}
