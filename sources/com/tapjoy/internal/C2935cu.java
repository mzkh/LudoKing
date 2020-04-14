package com.tapjoy.internal;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tapjoy.internal.cu */
public final class C2935cu {

    /* renamed from: a */
    public final C2938cx f6759a;

    /* renamed from: b */
    final WebView f6760b;

    /* renamed from: c */
    public final List f6761c = new ArrayList();

    /* renamed from: d */
    final String f6762d;

    /* renamed from: e */
    public final String f6763e;

    /* renamed from: f */
    public final C2936cv f6764f;

    private C2935cu(C2938cx cxVar, String str, List list, String str2) {
        C2936cv cvVar;
        this.f6759a = cxVar;
        this.f6760b = null;
        this.f6762d = str;
        if (list != null) {
            this.f6761c.addAll(list);
            cvVar = C2936cv.NATIVE;
        } else {
            cvVar = C2936cv.HTML;
        }
        this.f6764f = cvVar;
        this.f6763e = str2;
    }

    /* renamed from: a */
    public static C2935cu m6692a(C2938cx cxVar, String str, List list, String str2) {
        C2960do.m6754a((Object) cxVar, "Partner is null");
        C2960do.m6754a((Object) str, "OM SDK JS script content is null");
        C2960do.m6754a((Object) list, "VerificationScriptResources is null");
        if (str2.length() <= 256) {
            return new C2935cu(cxVar, str, list, str2);
        }
        throw new IllegalArgumentException("CustomReferenceData is greater than 256 characters");
    }
}
