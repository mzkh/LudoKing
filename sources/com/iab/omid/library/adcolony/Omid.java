package com.iab.omid.library.adcolony;

import android.content.Context;

public final class Omid {

    /* renamed from: a */
    private static C2023a f3966a = new C2023a();

    private Omid() {
    }

    public static boolean activateWithOmidApiVersion(String str, Context context) {
        f3966a.mo27327a(context.getApplicationContext());
        return true;
    }

    public static String getVersion() {
        return f3966a.mo27326a();
    }

    public static boolean isActive() {
        return f3966a.mo27330b();
    }

    public static boolean isCompatibleWithOmidApiVersion(String str) {
        return f3966a.mo27329a(str);
    }
}
