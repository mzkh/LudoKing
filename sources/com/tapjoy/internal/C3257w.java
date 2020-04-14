package com.tapjoy.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.tapjoy.internal.w */
public final class C3257w {

    /* renamed from: a */
    private static final ThreadLocal f7787a = new ThreadLocal() {
        /* access modifiers changed from: protected */
        public final /* synthetic */ Object initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
        }
    };

    /* renamed from: b */
    private static final ThreadLocal f7788b = new ThreadLocal() {
        /* access modifiers changed from: protected */
        public final /* synthetic */ Object initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        }
    };

    /* renamed from: a */
    public static String m7571a(Date date) {
        return ((DateFormat) f7787a.get()).format(date);
    }
}
