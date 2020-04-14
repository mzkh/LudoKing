package com.tapjoy.internal;

import java.lang.ref.WeakReference;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* renamed from: com.tapjoy.internal.by */
public final class C2915by {

    /* renamed from: a */
    public WeakReference f6741a;

    /* renamed from: a */
    public final Object mo29904a() {
        WeakReference weakReference = this.f6741a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* renamed from: a */
    public final void mo29905a(Object obj) {
        this.f6741a = new WeakReference(obj);
    }
}
