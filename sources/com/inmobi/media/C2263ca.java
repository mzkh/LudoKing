package com.inmobi.media;

import android.content.Context;

/* renamed from: com.inmobi.media.ca */
/* compiled from: MraidJsFetcher */
public class C2263ca {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final String f4738c = "ca";

    /* renamed from: a */
    public String f4739a;

    /* renamed from: b */
    public C2486fr f4740b;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f4741d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f4742e;

    /* renamed from: f */
    private long f4743f;

    public C2263ca(String str, int i, int i2, long j) {
        this.f4739a = str;
        this.f4741d = i;
        this.f4742e = i2;
        this.f4743f = j;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m4586a(C2263ca caVar) {
        Context c = C2505gd.m5298c();
        if (c != null) {
            if ((System.currentTimeMillis() / 1000) - new C2517gk(c, "mraid_js_store").mo28466a() > caVar.f4743f) {
                return true;
            }
        }
        return false;
    }
}
