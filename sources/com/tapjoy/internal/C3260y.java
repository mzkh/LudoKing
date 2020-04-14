package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.y */
public final class C3260y {
    /* renamed from: a */
    public static Object m7572a(C2890bb bbVar) {
        int i = 1;
        while (true) {
            try {
                return bbVar.call();
            } catch (OutOfMemoryError e) {
                if (i < 10) {
                    System.gc();
                    i++;
                } else {
                    throw e;
                }
            }
        }
    }
}
