package com.iab.omid.library.inmobi;

import android.content.Context;

public final class Omid {
    private static C2071a INSTANCE = new C2071a();

    private Omid() {
    }

    public static boolean activateWithOmidApiVersion(String str, Context context) {
        INSTANCE.mo27490a(context.getApplicationContext());
        return true;
    }

    public static String getVersion() {
        return INSTANCE.mo27489a();
    }

    public static boolean isActive() {
        return INSTANCE.mo27493b();
    }

    public static boolean isCompatibleWithOmidApiVersion(String str) {
        return INSTANCE.mo27492a(str);
    }
}
