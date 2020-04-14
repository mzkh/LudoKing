package com.tapjoy.internal;

import android.content.Context;
import android.os.Handler;

/* renamed from: com.tapjoy.internal.ck */
public final class C2925ck {

    /* renamed from: a */
    private static C2926cl f6748a = new C2926cl();

    /* renamed from: a */
    public static String m6679a() {
        return "1.2.19-Tapjoy";
    }

    /* renamed from: b */
    public static boolean m6681b() {
        return f6748a.f6749a;
    }

    /* renamed from: a */
    public static boolean m6680a(Context context) {
        C2926cl clVar = f6748a;
        Context applicationContext = context.getApplicationContext();
        C2960do.m6754a((Object) applicationContext, "Application Context cannot be null");
        if (!clVar.f6749a) {
            clVar.f6749a = true;
            C2951dh a = C2951dh.m6732a();
            a.f6817b = new C2930cp(new Handler(), applicationContext, new C2927cm(), a);
            C2945de.m6720a().f6803a = applicationContext.getApplicationContext();
            C2957dm.m6743a(applicationContext);
            C2948df.m6725a().f6810a = applicationContext != null ? applicationContext.getApplicationContext() : null;
        }
        return true;
    }
}
