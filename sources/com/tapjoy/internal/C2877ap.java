package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.ap */
public final class C2877ap {

    /* renamed from: com.tapjoy.internal.ap$a */
    public static final class C2878a implements C2880as {

        /* renamed from: a */
        private final C1808aq f6677a;

        public C2878a(C1808aq aqVar) {
            this.f6677a = aqVar;
        }

        /* renamed from: a */
        public final Object mo18047a(Object obj) {
            C2876ao a;
            Object a2;
            synchronized (this.f6677a) {
                a = this.f6677a.mo18049a(obj, false);
            }
            if (a == null) {
                return null;
            }
            synchronized (a) {
                a2 = a.mo29811a();
            }
            return a2;
        }

        /* renamed from: a */
        public final void mo18048a(Object obj, Object obj2) {
            C2876ao a;
            synchronized (this.f6677a) {
                a = this.f6677a.mo18049a(obj, true);
            }
            synchronized (a) {
                a.mo29812a(obj2);
            }
        }
    }
}
