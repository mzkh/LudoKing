package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdpj {
    private static final Class<?> zzhft = zzhg("libcore.io.Memory");
    private static final boolean zzhfu = (zzhg("org.robolectric.Robolectric") != null);

    static boolean zzaxl() {
        return zzhft != null && !zzhfu;
    }

    static Class<?> zzaxm() {
        return zzhft;
    }

    private static <T> Class<T> zzhg(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
