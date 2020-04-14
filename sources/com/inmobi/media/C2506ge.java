package com.inmobi.media;

import android.content.Context;
import androidx.annotation.NonNull;

/* renamed from: com.inmobi.media.ge */
/* compiled from: SdkInfo */
public final class C2506ge {
    /* renamed from: b */
    public static String m5320b() {
        return "9.0.1";
    }

    /* renamed from: c */
    public static String m5322c() {
        return "2.0";
    }

    /* renamed from: d */
    public static String m5323d() {
        return "android";
    }

    /* renamed from: e */
    public static String m5324e() {
        return "https://www.inmobi.com/products/sdk/#downloads";
    }

    /* renamed from: a */
    public static String m5316a() {
        char[] charArray;
        StringBuilder sb = new StringBuilder();
        for (char c : m5320b().toCharArray()) {
            if (c == '.') {
                sb.append("T");
            } else {
                sb.append((char) ((c - '0') + 65));
            }
        }
        StringBuilder sb2 = new StringBuilder("pr-SAND-");
        sb2.append(sb);
        sb2.append("-20191025");
        return sb2.toString();
    }

    /* renamed from: a */
    public static String m5317a(@NonNull Context context) {
        return C2494fy.m5249a(context, "sdk_version_store").mo28442b("sdk_version");
    }

    /* renamed from: a */
    public static void m5318a(@NonNull Context context, String str) {
        C2494fy.m5249a(context, "sdk_version_store").mo28439a("sdk_version", str);
    }

    /* renamed from: b */
    public static boolean m5321b(@NonNull Context context) {
        return C2494fy.m5249a(context, "sdk_version_store").mo28443b("db_deletion_failed", false);
    }

    /* renamed from: a */
    public static void m5319a(@NonNull Context context, boolean z) {
        C2494fy.m5249a(context, "sdk_version_store").mo28440a("db_deletion_failed", z);
    }
}
