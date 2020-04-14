package com.unity3d.services.p040ar;

/* renamed from: com.unity3d.services.ar.ARCheck */
public class ARCheck {
    public static boolean isFrameworkPresent() {
        try {
            Class.forName("com.google.ar.core.Session");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
