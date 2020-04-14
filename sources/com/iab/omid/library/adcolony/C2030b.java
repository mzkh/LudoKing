package com.iab.omid.library.adcolony;

import com.iab.omid.library.adcolony.p028d.C2049e;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.iab.omid.library.adcolony.b */
class C2030b {

    /* renamed from: a */
    private static final Pattern f4015a = Pattern.compile("<(head)( [^>]*)?>", 2);

    /* renamed from: b */
    private static final Pattern f4016b = Pattern.compile("<(head)( [^>]*)?/>", 2);

    /* renamed from: c */
    private static final Pattern f4017c = Pattern.compile("<(body)( [^>]*?)?>", 2);

    /* renamed from: d */
    private static final Pattern f4018d = Pattern.compile("<(body)( [^>]*?)?/>", 2);

    /* renamed from: e */
    private static final Pattern f4019e = Pattern.compile("<(html)( [^>]*?)?>", 2);

    /* renamed from: f */
    private static final Pattern f4020f = Pattern.compile("<(html)( [^>]*?)?/>", 2);

    /* renamed from: g */
    private static final Pattern f4021g = Pattern.compile("<!DOCTYPE [^>]*>", 2);

    /* renamed from: a */
    static String m3754a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("<script type=\"text/javascript\">");
        sb.append(str);
        sb.append("</script>");
        return m3758b(str2, sb.toString());
    }

    /* renamed from: a */
    private static boolean m3755a(int i, int[][] iArr) {
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
    private static boolean m3756a(String str, StringBuilder sb, Pattern pattern, String str2, int[][] iArr) {
        Matcher matcher = pattern.matcher(str);
        int i = 0;
        while (matcher.find(i)) {
            int start = matcher.start();
            int end = matcher.end();
            if (!m3755a(start, iArr)) {
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
    private static int[][] m3757a(String str) {
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
    static String m3758b(String str, String str2) {
        C2049e.m3843a(str, "HTML is null or empty");
        int[][] a = m3757a(str);
        StringBuilder sb = new StringBuilder(str.length() + str2.length() + 16);
        if (m3759b(str, sb, f4016b, str2, a)) {
            return sb.toString();
        }
        if (m3756a(str, sb, f4015a, str2, a)) {
            return sb.toString();
        }
        if (m3759b(str, sb, f4018d, str2, a)) {
            return sb.toString();
        }
        if (m3756a(str, sb, f4017c, str2, a)) {
            return sb.toString();
        }
        if (m3759b(str, sb, f4020f, str2, a)) {
            return sb.toString();
        }
        if (m3756a(str, sb, f4019e, str2, a)) {
            return sb.toString();
        }
        if (m3756a(str, sb, f4021g, str2, a)) {
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(str);
        return sb2.toString();
    }

    /* renamed from: b */
    private static boolean m3759b(String str, StringBuilder sb, Pattern pattern, String str2, int[][] iArr) {
        Matcher matcher = pattern.matcher(str);
        int i = 0;
        while (matcher.find(i)) {
            int start = matcher.start();
            int end = matcher.end();
            if (!m3755a(start, iArr)) {
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
