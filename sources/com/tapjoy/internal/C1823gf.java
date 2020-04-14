package com.tapjoy.internal;

import android.os.SystemClock;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.gf */
public abstract class C1823gf {
    @Nullable

    /* renamed from: a */
    static Set f3790a = null;

    /* renamed from: b */
    private static final ThreadLocal f3791b = new ThreadLocal() {
        /* access modifiers changed from: protected */
        public final /* synthetic */ Object initialValue() {
            return new HashMap();
        }
    };

    /* renamed from: c */
    private static C1823gf f3792c;

    /* renamed from: d */
    private static volatile boolean f3793d = false;

    /* renamed from: com.tapjoy.internal.gf$a */
    public static final class C1825a {

        /* renamed from: a */
        final String f3794a;

        /* renamed from: b */
        private final TreeMap f3795b = new TreeMap();

        /* renamed from: c */
        private final Map f3796c = new HashMap();

        /* renamed from: d */
        private volatile long f3797d;

        C1825a(String str) {
            this.f3794a = str;
        }

        /* renamed from: a */
        public final C1825a mo18096a() {
            try {
                this.f3797d = SystemClock.elapsedRealtime();
            } catch (NullPointerException unused) {
                this.f3797d = -1;
            }
            return this;
        }

        /* renamed from: b */
        public final C1825a mo18101b() {
            long j = this.f3797d;
            if (j != -1) {
                try {
                    mo18098a("spent_time", SystemClock.elapsedRealtime() - j);
                } catch (NullPointerException unused) {
                }
            }
            return this;
        }

        /* renamed from: a */
        public final C1825a mo18099a(String str, Object obj) {
            this.f3795b.put(str, obj);
            return this;
        }

        /* renamed from: a */
        public final C1825a mo18100a(Map map) {
            if (map != null) {
                this.f3795b.putAll(map);
            }
            return this;
        }

        /* renamed from: a */
        public final C1825a mo18097a(String str) {
            this.f3795b.put("failure", str);
            return this;
        }

        /* renamed from: b */
        public final C1825a mo18102b(String str) {
            this.f3795b.put("misuse", str);
            return this;
        }

        /* renamed from: a */
        public final C1825a mo18098a(String str, long j) {
            this.f3796c.put(str, Long.valueOf(j));
            return this;
        }

        /* renamed from: b */
        public final C1825a mo18103b(Map map) {
            if (map != null) {
                this.f3796c.putAll(map);
            }
            return this;
        }

        /* renamed from: c */
        public final void mo18104c() {
            String str = this.f3794a;
            Map map = null;
            String a = this.f3795b.size() > 0 ? C2895bh.m6597a((Object) this.f3795b) : null;
            if (this.f3796c.size() > 0) {
                map = this.f3796c;
            }
            C1823gf.m3521b(str, a, map);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo18092a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo18093a(long j);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo18094a(long j, String str, @Nullable String str2, @Nullable Map map);

    /* renamed from: a */
    public static void m3514a(C3105gh ghVar) {
        if (f3792c == null) {
            f3792c = ghVar;
            if (f3793d) {
                ghVar.mo18093a(C3256v.m7569b());
            }
        }
    }

    /* renamed from: a */
    public static void m3519a(boolean z) {
        if (f3793d != z) {
            f3793d = z;
            C1823gf gfVar = f3792c;
            if (gfVar != null) {
                if (z) {
                    gfVar.mo18093a(C3256v.m7569b());
                    return;
                }
                gfVar.mo18092a();
            }
        }
    }

    /* renamed from: a */
    public static void m3518a(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            f3790a = null;
        } else {
            f3790a = new HashSet(collection);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m3521b(String str, @Nullable String str2, @Nullable Map map) {
        Set set = f3790a;
        if ((set == null || !set.contains(str)) && f3793d) {
            C1823gf gfVar = f3792c;
            if (gfVar != null) {
                gfVar.mo18094a(C3256v.m7569b(), str, str2, map);
            }
        }
    }

    /* renamed from: a */
    public static void m3517a(String str, @Nullable TreeMap treeMap, @Nullable Map map) {
        m3521b(str, treeMap != null ? C2895bh.m6597a((Object) treeMap) : null, map);
    }

    /* renamed from: a */
    public static C1825a m3513a(String str) {
        C1825a a = new C1825a(str).mo18096a();
        ((Map) f3791b.get()).put(str, a);
        return a;
    }

    /* renamed from: b */
    public static C1825a m3520b(String str) {
        C1825a aVar = (C1825a) ((Map) f3791b.get()).remove(str);
        return aVar != null ? aVar.mo18101b() : new C1825a(str);
    }

    /* renamed from: c */
    public static C1825a m3522c(String str) {
        return (C1825a) ((Map) f3791b.get()).get(str);
    }

    /* renamed from: d */
    public static C1825a m3523d(String str) {
        return (C1825a) ((Map) f3791b.get()).remove(str);
    }

    /* renamed from: a */
    public static void m3515a(String str, C1825a aVar) {
        if (aVar == null) {
            new Object[1][0] = str;
        } else if (str.equals(aVar.f3794a)) {
            ((Map) f3791b.get()).put(str, aVar);
        } else {
            Object[] objArr = {str, aVar.f3794a};
        }
    }

    /* renamed from: e */
    public static C1825a m3524e(String str) {
        return new C1825a(str);
    }
}
