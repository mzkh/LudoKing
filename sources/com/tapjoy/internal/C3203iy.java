package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.iy */
final class C3203iy {

    /* renamed from: a */
    final byte[] f7643a;

    /* renamed from: b */
    int f7644b;

    /* renamed from: c */
    int f7645c;

    /* renamed from: d */
    boolean f7646d;

    /* renamed from: e */
    boolean f7647e;

    /* renamed from: f */
    C3203iy f7648f;

    /* renamed from: g */
    C3203iy f7649g;

    C3203iy() {
        this.f7643a = new byte[8192];
        this.f7647e = true;
        this.f7646d = false;
    }

    C3203iy(C3203iy iyVar) {
        this(iyVar.f7643a, iyVar.f7644b, iyVar.f7645c);
        iyVar.f7646d = true;
    }

    C3203iy(byte[] bArr, int i, int i2) {
        this.f7643a = bArr;
        this.f7644b = i;
        this.f7645c = i2;
        this.f7647e = false;
        this.f7646d = true;
    }

    /* renamed from: a */
    public final C3203iy mo30318a() {
        C3203iy iyVar = this.f7648f;
        if (iyVar == this) {
            iyVar = null;
        }
        C3203iy iyVar2 = this.f7649g;
        iyVar2.f7648f = this.f7648f;
        this.f7648f.f7649g = iyVar2;
        this.f7648f = null;
        this.f7649g = null;
        return iyVar;
    }

    /* renamed from: a */
    public final C3203iy mo30319a(C3203iy iyVar) {
        iyVar.f7649g = this;
        iyVar.f7648f = this.f7648f;
        this.f7648f.f7649g = iyVar;
        this.f7648f = iyVar;
        return iyVar;
    }

    /* renamed from: a */
    public final void mo30320a(C3203iy iyVar, int i) {
        if (iyVar.f7647e) {
            int i2 = iyVar.f7645c;
            if (i2 + i > 8192) {
                if (!iyVar.f7646d) {
                    int i3 = i2 + i;
                    int i4 = iyVar.f7644b;
                    if (i3 - i4 <= 8192) {
                        byte[] bArr = iyVar.f7643a;
                        System.arraycopy(bArr, i4, bArr, 0, i2 - i4);
                        iyVar.f7645c -= iyVar.f7644b;
                        iyVar.f7644b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f7643a, this.f7644b, iyVar.f7643a, iyVar.f7645c, i);
            iyVar.f7645c += i;
            this.f7644b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
