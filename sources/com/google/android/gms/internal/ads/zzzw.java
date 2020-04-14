package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzzw extends zzzv {
    zzzw() {
    }

    public final String zzi(@Nullable String str, String str2) {
        String zzcn = zzcn(str);
        String zzcn2 = zzcn(str2);
        if (TextUtils.isEmpty(zzcn)) {
            return zzcn2;
        }
        if (TextUtils.isEmpty(zzcn2)) {
            return zzcn;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(zzcn).length() + 1 + String.valueOf(zzcn2).length());
        sb.append(zzcn);
        sb.append(",");
        sb.append(zzcn2);
        return sb.toString();
    }

    @Nullable
    private static String zzcn(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i = 0;
        int length = str.length();
        while (i < str.length() && str.charAt(i) == ',') {
            i++;
        }
        while (length > 0 && str.charAt(length - 1) == ',') {
            length--;
        }
        if (length < i) {
            return null;
        }
        if (i == 0 && length == str.length()) {
            return str;
        }
        return str.substring(i, length);
    }
}
