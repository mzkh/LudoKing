package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.ib */
public final class C3172ib {

    /* renamed from: a */
    public float f7528a;

    /* renamed from: b */
    public int f7529b;

    /* renamed from: a */
    public static C3172ib m7320a(String str) {
        if (C1852jq.m3669c(str)) {
            return null;
        }
        try {
            C3172ib ibVar = new C3172ib();
            int length = str.length() - 1;
            char charAt = str.charAt(length);
            if (charAt == 'w') {
                ibVar.f7528a = Float.valueOf(str.substring(0, length)).floatValue();
                ibVar.f7529b = 1;
            } else if (charAt == 'h') {
                ibVar.f7528a = Float.valueOf(str.substring(0, length)).floatValue();
                ibVar.f7529b = 2;
            } else {
                ibVar.f7528a = Float.valueOf(str).floatValue();
                ibVar.f7529b = 0;
            }
            return ibVar;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public final float mo30234a(float f, float f2) {
        int i = this.f7529b;
        if (i == 1) {
            return (this.f7528a * f) / 100.0f;
        }
        if (i == 2) {
            return (this.f7528a * f2) / 100.0f;
        }
        return this.f7528a;
    }
}
