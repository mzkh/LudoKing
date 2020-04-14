package com.tapjoy.internal;

import java.util.Arrays;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.ho */
abstract class C1843ho implements C1829gl {

    /* renamed from: a */
    private static final String[] f3864a;

    C1843ho() {
    }

    static {
        String[] strArr = {"reward", "purchase", "custom_action"};
        f3864a = strArr;
        Arrays.sort(strArr);
    }

    /* renamed from: a */
    public final void mo18112a(C3109gm gmVar) {
        if (this instanceof C3112gp) {
            C3112gp gpVar = (C3112gp) this;
            gmVar.mo29409a(gpVar.mo30188a(), gpVar.mo30189b());
            return;
        }
        if (this instanceof C3113gq) {
            C3113gq gqVar = (C3113gq) this;
            gmVar.mo29410a(gqVar.mo30190a(), gqVar.mo30191b(), gqVar.mo30192c(), gqVar.mo30193d());
        }
    }

    /* renamed from: a */
    public static boolean m3639a(String str) {
        return Arrays.binarySearch(f3864a, str) >= 0;
    }

    @Nullable
    /* renamed from: a */
    public static C1843ho m3638a(String str, C1812bn bnVar) {
        if ("reward".equals(str)) {
            return (C1843ho) bnVar.mo18052a(C3165hy.f7504a);
        }
        if ("purchase".equals(str)) {
            return (C1843ho) bnVar.mo18052a(C3161hw.f7495a);
        }
        return null;
    }
}
