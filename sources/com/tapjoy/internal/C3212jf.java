package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.jf */
public final class C3212jf {

    /* renamed from: a */
    public static C3212jf f7658a = new C3212jf(null);

    /* renamed from: b */
    public String f7659b;

    /* renamed from: c */
    public Throwable f7660c;

    /* renamed from: d */
    private Object[] f7661d;

    public C3212jf(String str) {
        this(str, null, null);
    }

    public C3212jf(String str, Object[] objArr, Throwable th) {
        this.f7659b = str;
        this.f7660c = th;
        if (th == null) {
            this.f7661d = objArr;
        } else if (objArr == null || objArr.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        } else {
            int length = objArr.length - 1;
            Object[] objArr2 = new Object[length];
            System.arraycopy(objArr, 0, objArr2, 0, length);
            this.f7661d = objArr2;
        }
    }
}
