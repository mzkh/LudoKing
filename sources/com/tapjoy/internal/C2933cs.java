package com.tapjoy.internal;

import android.view.View;

/* renamed from: com.tapjoy.internal.cs */
public abstract class C2933cs {
    /* renamed from: a */
    public abstract void mo29921a();

    /* renamed from: a */
    public abstract void mo29922a(View view);

    /* renamed from: b */
    public abstract void mo29923b();

    /* renamed from: a */
    public static C2933cs m6687a(C2934ct ctVar, C2935cu cuVar) {
        if (C2925ck.m6681b()) {
            C2960do.m6754a((Object) ctVar, "AdSessionConfiguration is null");
            C2960do.m6754a((Object) cuVar, "AdSessionContext is null");
            return new C2940cz(ctVar, cuVar);
        }
        throw new IllegalStateException("Method called before OM SDK activation");
    }
}
