package com.iab.omid.library.inmobi;

import com.iab.omid.library.inmobi.p034d.C2097e;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.iab.omid.library.inmobi.b */
class C2078b {

    /* renamed from: a */
    private static final Pattern f4114a = Pattern.compile("<(head)( [^>]*)?>", 2);

    /* renamed from: b */
    private static final Pattern f4115b = Pattern.compile("<(head)( [^>]*)?/>", 2);

    /* renamed from: c */
    private static final Pattern f4116c = Pattern.compile("<(body)( [^>]*?)?>", 2);

    /* renamed from: d */
    private static final Pattern f4117d = Pattern.compile("<(body)( [^>]*?)?/>", 2);

    /* renamed from: e */
    private static final Pattern f4118e = Pattern.compile("<(html)( [^>]*?)?>", 2);

    /* renamed from: f */
    private static final Pattern f4119f = Pattern.compile("<(html)( [^>]*?)?/>", 2);

    /* renamed from: g */
    private static final Pattern f4120g = Pattern.compile("<!DOCTYPE [^>]*>", 2);

    /* renamed from: a */
    static String m3958a(String str, String str2) {
        StringBuilder sb = new StringBuilder("<script type=\"text/javascript\">");
        sb.append(str);
        sb.append("</script>");
        return m3962b(str2, sb.toString());
    }

    /* renamed from: a */
    private static boolean m3959a(int i, int[][] iArr) {
        if (iArr != null) {
            for (int[] iArr2 : iArr) {
                if (i >= iArr2[0] && i <= iArr2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m3960a(String str, StringBuilder sb, Pattern pattern, String str2, int[][] iArr) {
        Matcher matcher = pattern.matcher(str);
        int i = 0;
        while (matcher.find(i)) {
            int start = matcher.start();
            int end = matcher.end();
            if (!m3959a(start, iArr)) {
                sb.append(str.substring(0, matcher.end()));
                sb.append(str2);
                sb.append(str.substring(matcher.end()));
                return true;
            }
            i = end;
        }
        return false;
    }

    /* renamed from: a */
    private static int[][] m3961a(String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int indexOf = str.indexOf("<!--", i);
            if (indexOf >= 0) {
                int indexOf2 = str.indexOf("-->", indexOf);
                if (indexOf2 >= 0) {
                    arrayList.add(new int[]{indexOf, indexOf2});
                    i = indexOf2 + 3;
                } else {
                    arrayList.add(new int[]{indexOf, length});
                }
            }
            i = length;
        }
        return (int[][]) arrayList.toArray((int[][]) Array.newInstance(int.class, new int[]{0, 2}));
    }

    /* renamed from: b */
    static String m3962b(String str, String str2) {
        C2097e.m4049a(str, "HTML is null or empty");
        int[][] a = m3961a(str);
        StringBuilder sb = new StringBuilder(str.length() + str2.length() + 16);
        if (m3963b(str, sb, f4115b, str2, a)) {
            return sb.toString();
        }
        if (m3960a(str, sb, f4114a, str2, a)) {
            return sb.toString();
        }
        if (m3963b(str, sb, f4117d, str2, a)) {
            return sb.toString();
        }
        if (m3960a(str, sb, f4116c, str2, a)) {
            return sb.toString();
        }
        if (m3963b(str, sb, f4119f, str2, a)) {
            return sb.toString();
        }
        if (m3960a(str, sb, f4118e, str2, a)) {
            return sb.toString();
        }
        if (m3960a(str, sb, f4120g, str2, a)) {
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(str);
        return sb2.toString();
    }

    /* renamed from: b */
    private static boolean m3963b(String str, StringBuilder sb, Pattern pattern, String str2, int[][] iArr) {
        Matcher matcher = pattern.matcher(str);
        int i = 0;
        while (matcher.find(i)) {
            int start = matcher.start();
            int end = matcher.end();
            if (!m3959a(start, iArr)) {
                sb.append(str.substring(0, matcher.end() - 2));
                String str3 = ">";
                sb.append(str3);
                sb.append(str2);
                sb.append("</");
                sb.append(matcher.group(1));
                sb.append(str3);
                sb.append(str.substring(matcher.end()));
                return true;
            }
            i = end;
        }
        return false;
    }
}
