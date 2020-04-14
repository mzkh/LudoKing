package com.applovin.impl.sdk;

import android.content.Context;
import com.applovin.impl.sdk.p019b.C1098e;
import com.applovin.impl.sdk.p019b.C1099f;

/* renamed from: com.applovin.impl.sdk.f */
public class C1179f {
    /* renamed from: a */
    public static Boolean m2526a(Context context) {
        return m2527a(C1098e.f2563i, context);
    }

    /* renamed from: a */
    private static Boolean m2527a(C1098e<Boolean> eVar, Context context) {
        return (Boolean) C1099f.m2152b(eVar, null, context);
    }

    /* renamed from: a */
    private static boolean m2528a(C1098e<Boolean> eVar, Boolean bool, Context context) {
        Boolean a = m2527a(eVar, context);
        C1099f.m2150a(eVar, bool, context);
        return a == null || a != bool;
    }

    /* renamed from: a */
    public static boolean m2529a(boolean z, Context context) {
        return m2528a(C1098e.f2563i, Boolean.valueOf(z), context);
    }

    /* renamed from: b */
    public static Boolean m2530b(Context context) {
        return m2527a(C1098e.f2564j, context);
    }

    /* renamed from: b */
    public static boolean m2531b(boolean z, Context context) {
        return m2528a(C1098e.f2564j, Boolean.valueOf(z), context);
    }
}
