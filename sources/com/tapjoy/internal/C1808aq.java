package com.tapjoy.internal;

import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.aq */
public abstract class C1808aq implements C1807an {
    /* access modifiers changed from: protected */
    @Nullable
    /* renamed from: a */
    public abstract C2876ao mo18049a(Object obj, boolean z);

    /* renamed from: a */
    public final Object mo18047a(Object obj) {
        C2876ao a = mo18049a(obj, false);
        if (a != null) {
            return a.mo29811a();
        }
        return null;
    }

    /* renamed from: a */
    public void mo18048a(Object obj, Object obj2) {
        mo18049a(obj, true).mo29812a(obj2);
    }
}
