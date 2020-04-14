package com.tapjoy.internal;

import java.util.Collections;
import java.util.List;

/* renamed from: com.tapjoy.internal.eo */
public final class C3011eo {
    /* renamed from: a */
    public static List m6886a() {
        return new C3012ep(Collections.emptyList());
    }

    /* renamed from: a */
    public static List m6887a(String str, List list) {
        if (list != null) {
            if (list instanceof C3012ep) {
                list = ((C3012ep) list).f6929a;
            }
            if (list == Collections.emptyList() || (list instanceof C3010en)) {
                return list;
            }
            C3010en enVar = new C3010en(list);
            if (!enVar.contains(null)) {
                return enVar;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(".contains(null)");
            throw new IllegalArgumentException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" == null");
        throw new NullPointerException(sb2.toString());
    }

    /* renamed from: a */
    public static boolean m6888a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static IllegalStateException m6885a(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        String str = "";
        for (int i = 0; i < length; i += 2) {
            if (objArr[i] == null) {
                if (sb.length() > 0) {
                    str = "s";
                }
                sb.append("\n  ");
                sb.append(objArr[i + 1]);
            }
        }
        StringBuilder sb2 = new StringBuilder("Required field");
        sb2.append(str);
        sb2.append(" not set:");
        sb2.append(sb);
        throw new IllegalStateException(sb2.toString());
    }
}
