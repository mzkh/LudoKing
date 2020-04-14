package com.iab.omid.library.adcolony.p028d;

import android.text.TextUtils;
import com.iab.omid.library.adcolony.Omid;
import com.iab.omid.library.adcolony.adsession.C2029a;
import com.iab.omid.library.adcolony.adsession.Owner;

/* renamed from: com.iab.omid.library.adcolony.d.e */
public class C2049e {
    /* renamed from: a */
    public static void m3838a() {
        if (!Omid.isActive()) {
            throw new IllegalStateException("Method called before OM SDK activation");
        }
    }

    /* renamed from: a */
    public static void m3839a(Owner owner) {
        if (owner.equals(Owner.NONE)) {
            throw new IllegalArgumentException("Impression owner is none");
        }
    }

    /* renamed from: a */
    public static void m3840a(C2029a aVar) {
        if (aVar.mo27369e()) {
            throw new IllegalStateException("AdSession is started");
        }
    }

    /* renamed from: a */
    public static void m3841a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: a */
    public static void m3842a(String str, int i, String str2) {
        if (str.length() > i) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* renamed from: a */
    public static void m3843a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* renamed from: b */
    public static void m3844b(C2029a aVar) {
        if (aVar.mo27370f()) {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    /* renamed from: c */
    public static void m3845c(C2029a aVar) {
        m3850h(aVar);
        m3844b(aVar);
    }

    /* renamed from: d */
    public static void m3846d(C2029a aVar) {
        if (aVar.getAdSessionStatePublisher().mo27444c() != null) {
            throw new IllegalStateException("AdEvents already exists for AdSession");
        }
    }

    /* renamed from: e */
    public static void m3847e(C2029a aVar) {
        if (aVar.getAdSessionStatePublisher().mo27445d() != null) {
            throw new IllegalStateException("VideoEvents already exists for AdSession");
        }
    }

    /* renamed from: f */
    public static void m3848f(C2029a aVar) {
        if (!aVar.mo27371g()) {
            throw new IllegalStateException("Impression event is not expected from the Native AdSession");
        }
    }

    /* renamed from: g */
    public static void m3849g(C2029a aVar) {
        if (!aVar.mo27372h()) {
            throw new IllegalStateException("Cannot create VideoEvents for JavaScript AdSession");
        }
    }

    /* renamed from: h */
    private static void m3850h(C2029a aVar) {
        if (!aVar.mo27369e()) {
            throw new IllegalStateException("AdSession is not started");
        }
    }
}
