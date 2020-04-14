package com.applovin.impl.sdk.utils;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p019b.C1096c;
import com.facebook.appevents.AppEventsConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.applovin.impl.sdk.utils.l */
public class C1277l {

    /* renamed from: a */
    private static final char[] f3209a = "0123456789abcdef".toCharArray();

    /* renamed from: a */
    public static int m3031a(String str) {
        return m3032a(str, 0);
    }

    /* renamed from: a */
    public static int m3032a(String str, int i) {
        return m3043c(str) ? Integer.parseInt(str) : i;
    }

    /* renamed from: a */
    public static String m3033a(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (i > str.length()) {
            i = str.length();
        }
        return str.substring(0, i);
    }

    /* renamed from: a */
    public static String m3034a(String str, C1192i iVar) {
        return m3035a(str, (Integer) iVar.mo10202a(C1096c.f2284Z), (String) iVar.mo10202a(C1096c.f2283Y));
    }

    /* renamed from: a */
    private static String m3035a(String str, Integer num, String str2) {
        if (str2 == null) {
            throw new IllegalArgumentException("No algorithm specified");
        } else if (str == null || str.length() < 1) {
            return "";
        } else {
            if (str2.length() < 1 || "none".equals(str2)) {
                return str;
            }
            try {
                MessageDigest instance = MessageDigest.getInstance(str2);
                instance.update(str.getBytes("UTF-8"));
                String a = m3039a(instance.digest());
                if (a != null && num.intValue() > 0) {
                    a = a.substring(0, Math.min(num.intValue(), a.length()));
                }
                return a;
            } catch (NoSuchAlgorithmException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown algorithm \"");
                sb.append(str2);
                sb.append("\"");
                throw new RuntimeException(sb.toString(), e);
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException("Programming error: UTF-8 is not know encoding", e2);
            }
        }
    }

    /* renamed from: a */
    public static String m3036a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter(str2, str3);
        return buildUpon.build().toString();
    }

    /* renamed from: a */
    public static String m3037a(String str, Map<String, String> map) {
        if (!(str == null || map == null)) {
            for (Entry entry : map.entrySet()) {
                str = str.replace((CharSequence) entry.getKey(), (CharSequence) entry.getValue());
            }
        }
        return str;
    }

    /* renamed from: a */
    public static String m3038a(boolean z) {
        return z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
    }

    /* renamed from: a */
    public static String m3039a(byte[] bArr) {
        if (bArr != null) {
            char[] cArr = new char[(bArr.length * 2)];
            for (int i = 0; i < bArr.length; i++) {
                int i2 = i * 2;
                char[] cArr2 = f3209a;
                cArr[i2] = cArr2[(bArr[i] & 240) >>> 4];
                cArr[i2 + 1] = cArr2[bArr[i] & 15];
            }
            return new String(cArr);
        }
        throw new IllegalArgumentException("No data specified");
    }

    /* renamed from: a */
    public static boolean m3040a(String str, String str2) {
        return m3042b(str) && m3042b(str2) && str.toLowerCase().contains(str2.toLowerCase());
    }

    /* renamed from: b */
    public static String m3041b(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (map != null && !map.isEmpty()) {
            Builder buildUpon = Uri.parse(str).buildUpon();
            for (Entry entry : map.entrySet()) {
                buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
            }
            str = buildUpon.build().toString();
        }
        return str;
    }

    /* renamed from: b */
    public static boolean m3042b(String str) {
        return !TextUtils.isEmpty(str);
    }

    /* renamed from: c */
    public static boolean m3043c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char charAt = str.charAt(0);
        int i = (charAt == '-' || charAt == '+') ? 1 : 0;
        int length = str.length();
        if (i == 1 && length == 1) {
            return false;
        }
        while (i < length) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
            i++;
        }
        return true;
    }

    /* renamed from: d */
    public static String m3044d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }
}
