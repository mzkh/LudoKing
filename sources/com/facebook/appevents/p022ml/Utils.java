package com.facebook.appevents.p022ml;

import android.text.TextUtils;
import java.nio.charset.Charset;

/* renamed from: com.facebook.appevents.ml.Utils */
public class Utils {
    static int[] vectorize(String str, int i) {
        int[] iArr = new int[i];
        byte[] bytes = normalizeString(str).getBytes(Charset.forName("UTF-8"));
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < bytes.length) {
                iArr[i2] = bytes[i2] & 255;
            } else {
                iArr[i2] = 0;
            }
        }
        return iArr;
    }

    static String normalizeString(String str) {
        return TextUtils.join(" ", str.trim().split("\\s+"));
    }
}
