package com.applovin.impl.sdk.utils;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.utils.d */
public class C1243d {
    /* renamed from: a */
    public static String m2921a(Collection<String> collection, int i) {
        return m2922a(collection, ",", i);
    }

    /* renamed from: a */
    static String m2922a(Collection<String> collection, String str, int i) {
        if (str == null) {
            throw new IllegalArgumentException("No glue specified");
        } else if (collection == null || collection.size() < 1) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            for (String str2 : collection) {
                if (i2 >= i) {
                    break;
                }
                i2++;
                sb.append(str2);
                sb.append(str);
            }
            if (sb.length() > str.length()) {
                sb.setLength(sb.length() - str.length());
            }
            return sb.toString();
        }
    }

    /* renamed from: a */
    public static <T> List<T> m2923a(int i) {
        return Collections.synchronizedList(new ArrayList(i));
    }

    /* renamed from: a */
    public static List<String> m2924a(String str) {
        return m2925a(str, ",\\s*");
    }

    /* renamed from: a */
    public static List<String> m2925a(String str, String str2) {
        return TextUtils.isEmpty(str) ? Collections.emptyList() : Arrays.asList(str.split(str2));
    }

    /* renamed from: a */
    public static List<String> m2926a(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String trim : list) {
            String trim2 = trim.trim();
            if (!TextUtils.isEmpty(trim2)) {
                arrayList.add(trim2);
            }
        }
        return arrayList;
    }
}
