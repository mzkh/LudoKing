package com.iab.omid.library.inmobi.p034d;

import android.text.TextUtils;
import com.iab.omid.library.inmobi.Omid;
import com.iab.omid.library.inmobi.adsession.C2077a;
import com.iab.omid.library.inmobi.adsession.Owner;

/* renamed from: com.iab.omid.library.inmobi.d.e */
public class C2097e {
    /* renamed from: a */
    public static void m4044a() {
        if (!Omid.isActive()) {
            throw new IllegalStateException("Method called before OM SDK activation");
        }
    }

    /* renamed from: a */
    public static void m4045a(Owner owner) {
        if (owner.equals(Owner.NONE)) {
            throw new IllegalArgumentException("Impression owner is none");
        }
    }

    /* renamed from: a */
    public static void m4046a(C2077a aVar) {
        if (aVar.mo27532e()) {
            throw new IllegalStateException("AdSession is started");
        }
    }

    /* renamed from: a */
    public static void m4047a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: a */
    public static void m4048a(String str, int i, String str2) {
        if (str.length() > i) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* renamed from: a */
    public static void m4049a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* renamed from: b */
    public static void m4050b(C2077a aVar) {
        if (aVar.mo27533f()) {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    /* renamed from: c */
    public static void m4051c(C2077a aVar) {
        m4056h(aVar);
        m4050b(aVar);
    }

    /* renamed from: d */
    public static void m4052d(C2077a aVar) {
        if (aVar.getAdSessionStatePublisher().mo27608c() != null) {
            throw new IllegalStateException("AdEvents already exists for AdSession");
        }
    }

    /* renamed from: e */
    public static void m4053e(C2077a aVar) {
        if (aVar.getAdSessionStatePublisher().mo27609d() != null) {
            throw new IllegalStateException("VideoEvents already exists for AdSession");
        }
    }

    /* renamed from: f */
    public static void m4054f(C2077a aVar) {
        if (!aVar.mo27534g()) {
            throw new IllegalStateException("Impression event is not expected from the Native AdSession");
        }
    }

    /* renamed from: g */
    public static void m4055g(C2077a aVar) {
        if (!aVar.mo27535h()) {
            throw new IllegalStateException("Cannot create VideoEvents for JavaScript AdSession");
        }
    }

    /* renamed from: h */
    private static void m4056h(C2077a aVar) {
        if (!aVar.mo27532e()) {
            throw new IllegalStateException("AdSession is not started");
        }
    }
}
