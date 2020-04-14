package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzny {
    public static boolean zzbc(String str) {
        return "audio".equals(zzbe(str));
    }

    public static boolean zzbd(String str) {
        return "video".equals(zzbe(str));
    }

    private static String zzbe(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        String str2 = "Invalid mime type: ";
        String valueOf = String.valueOf(str);
        throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }
}
