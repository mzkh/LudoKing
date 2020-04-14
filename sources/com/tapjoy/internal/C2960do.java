package com.tapjoy.internal;

import android.text.TextUtils;

/* renamed from: com.tapjoy.internal.do */
public final class C2960do {
    /* renamed from: a */
    public static void m6754a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: a */
    public static void m6755a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* renamed from: a */
    public static void m6753a(C2940cz czVar) {
        if (czVar.f6783e) {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    /* renamed from: b */
    public static void m6756b(C2940cz czVar) {
        if (czVar.f6782d) {
            m6753a(czVar);
            return;
        }
        throw new IllegalStateException("AdSession is not started");
    }
}
