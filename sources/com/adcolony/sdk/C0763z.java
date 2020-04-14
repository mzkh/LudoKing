package com.adcolony.sdk;

/* renamed from: com.adcolony.sdk.z */
class C0763z {

    /* renamed from: a */
    static float[] f1202a = new float[16];

    /* renamed from: b */
    static C0763z f1203b = new C0763z();

    /* renamed from: c */
    double[] f1204c = new double[16];

    /* renamed from: d */
    boolean f1205d;

    C0763z() {
        mo8753b();
    }

    C0763z(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16) {
        mo8756b(d, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, d16);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0763z mo8744a() {
        C0763z zVar = new C0763z();
        zVar.mo8757b(this);
        return zVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0763z mo8750a(C0763z zVar) {
        C0763z zVar2 = zVar;
        if (zVar2.f1205d) {
            return this;
        }
        double[] dArr = zVar2.f1204c;
        return mo8747a(dArr[0], dArr[1], dArr[2], dArr[3], dArr[4], dArr[5], dArr[6], dArr[7], dArr[8], dArr[9], dArr[10], dArr[11], dArr[12], dArr[13], dArr[14], dArr[15]);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0763z mo8747a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16) {
        return mo8748a(d, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, d16, this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0763z mo8748a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, C0763z zVar) {
        C0763z zVar2 = zVar;
        if (this.f1205d) {
            return zVar.mo8756b(d, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, d16);
        }
        double[] dArr = this.f1204c;
        double d17 = dArr[0];
        double d18 = dArr[1];
        double d19 = dArr[2];
        double d20 = dArr[3];
        double d21 = dArr[4];
        double d22 = dArr[5];
        double d23 = dArr[6];
        double d24 = dArr[7];
        double d25 = dArr[8];
        double d26 = dArr[9];
        double d27 = dArr[10];
        double d28 = dArr[11];
        double d29 = dArr[12];
        double d30 = dArr[13];
        double d31 = dArr[14];
        double d32 = dArr[15];
        double[] dArr2 = zVar2.f1204c;
        dArr2[0] = (d17 * d) + (d18 * d5) + (d19 * d9) + (d20 * d13);
        dArr2[1] = (d17 * d2) + (d18 * d6) + (d19 * d10) + (d20 * d14);
        dArr2[2] = (d17 * d3) + (d18 * d7) + (d19 * d11) + (d20 * d15);
        dArr2[3] = (d17 * d4) + (d18 * d8) + (d19 * d12) + (d20 * d16);
        dArr2[4] = (d21 * d) + (d22 * d5) + (d23 * d9) + (d24 * d13);
        dArr2[5] = (d21 * d2) + (d22 * d6) + (d23 * d10) + (d24 * d14);
        dArr2[6] = (d21 * d3) + (d22 * d7) + (d23 * d11) + (d24 * d15);
        dArr2[7] = (d21 * d4) + (d22 * d8) + (d23 * d12) + (d24 * d16);
        dArr2[8] = (d25 * d) + (d26 * d5) + (d27 * d9) + (d28 * d13);
        dArr2[9] = (d25 * d2) + (d26 * d6) + (d27 * d10) + (d28 * d14);
        dArr2[10] = (d25 * d3) + (d26 * d7) + (d27 * d11) + (d28 * d15);
        dArr2[11] = (d25 * d4) + (d26 * d8) + (d27 * d12) + (d28 * d16);
        dArr2[12] = (d29 * d) + (d30 * d5) + (d31 * d9) + (d32 * d13);
        dArr2[13] = (d29 * d2) + (d30 * d6) + (d31 * d10) + (d32 * d14);
        dArr2[14] = (d29 * d3) + (d30 * d7) + (d31 * d11) + (d32 * d15);
        dArr2[15] = (d29 * d4) + (d30 * d8) + (d31 * d12) + (d32 * d16);
        this.f1205d = false;
        return zVar2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0763z mo8751a(C0763z zVar, C0763z zVar2) {
        C0763z zVar3 = zVar;
        if (zVar3.f1205d) {
            return zVar2.mo8757b(this);
        }
        C0763z zVar4 = zVar2;
        double[] dArr = zVar3.f1204c;
        return mo8748a(dArr[0], dArr[1], dArr[2], dArr[3], dArr[4], dArr[5], dArr[6], dArr[7], dArr[8], dArr[9], dArr[10], dArr[11], dArr[12], dArr[13], dArr[14], dArr[15], zVar2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0763z mo8745a(double d) {
        f1203b.mo8753b();
        double cos = Math.cos(d);
        double sin = Math.sin(d);
        C0763z zVar = f1203b;
        double[] dArr = zVar.f1204c;
        dArr[0] = cos;
        dArr[1] = sin;
        dArr[4] = -sin;
        dArr[5] = cos;
        zVar.f1205d = false;
        return mo8750a(zVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C0763z mo8754b(double d) {
        return mo8745a((d * 3.141592653589793d) / 180.0d);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0763z mo8746a(double d, double d2, double d3) {
        f1203b.mo8753b();
        C0763z zVar = f1203b;
        double[] dArr = zVar.f1204c;
        dArr[0] = d;
        dArr[5] = d2;
        dArr[10] = d3;
        zVar.f1205d = false;
        return mo8750a(zVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C0763z mo8757b(C0763z zVar) {
        for (int i = 15; i >= 0; i--) {
            this.f1204c[i] = zVar.f1204c[i];
        }
        this.f1205d = zVar.f1205d;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C0763z mo8756b(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16) {
        this.f1205d = false;
        double[] dArr = this.f1204c;
        dArr[0] = d;
        dArr[1] = d2;
        dArr[2] = d3;
        dArr[3] = d4;
        dArr[4] = d5;
        dArr[5] = d6;
        dArr[6] = d7;
        dArr[7] = d8;
        dArr[8] = d9;
        dArr[9] = d10;
        dArr[10] = d11;
        dArr[11] = d12;
        dArr[12] = d13;
        dArr[13] = d14;
        dArr[14] = d15;
        dArr[15] = d16;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C0763z mo8753b() {
        for (int i = 15; i >= 0; i--) {
            this.f1204c[i] = 0.0d;
        }
        double[] dArr = this.f1204c;
        dArr[0] = 1.0d;
        dArr[5] = 1.0d;
        dArr[10] = 1.0d;
        dArr[15] = 1.0d;
        this.f1205d = true;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0763z mo8749a(int i, int i2, double d) {
        mo8753b();
        double[] dArr = this.f1204c;
        double d2 = (double) i;
        Double.isNaN(d2);
        dArr[0] = 2.0d / d2;
        double d3 = (double) i2;
        Double.isNaN(d3);
        dArr[5] = -2.0d / d3;
        dArr[10] = -2.0d / d;
        dArr[12] = -1.0d;
        dArr[13] = 1.0d;
        dArr[14] = -1.0d;
        this.f1205d = false;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C0763z mo8755b(double d, double d2, double d3) {
        f1203b.mo8753b();
        C0763z zVar = f1203b;
        double[] dArr = zVar.f1204c;
        dArr[12] = d;
        dArr[13] = d2;
        dArr[14] = d3;
        zVar.f1205d = false;
        return mo8750a(zVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C0763z mo8758c(double d) {
        for (int i = 15; i >= 0; i--) {
            this.f1204c[i] = d;
        }
        this.f1205d = false;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public float[] mo8759c() {
        return mo8752a(f1202a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public float[] mo8752a(float[] fArr) {
        for (int i = 15; i >= 0; i--) {
            fArr[i] = (float) this.f1204c[i];
        }
        return fArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1204c[0]);
        sb.append(' ');
        sb.append(this.f1204c[1]);
        sb.append(' ');
        sb.append(this.f1204c[2]);
        sb.append(' ');
        sb.append(this.f1204c[3]);
        sb.append(10);
        sb.append(this.f1204c[4]);
        sb.append(' ');
        sb.append(this.f1204c[5]);
        sb.append(' ');
        sb.append(this.f1204c[6]);
        sb.append(' ');
        sb.append(this.f1204c[7]);
        sb.append(10);
        sb.append(this.f1204c[8]);
        sb.append(' ');
        sb.append(this.f1204c[9]);
        sb.append(' ');
        sb.append(this.f1204c[10]);
        sb.append(' ');
        sb.append(this.f1204c[11]);
        sb.append(10);
        sb.append(this.f1204c[12]);
        sb.append(' ');
        sb.append(this.f1204c[13]);
        sb.append(' ');
        sb.append(this.f1204c[14]);
        sb.append(' ');
        sb.append(this.f1204c[15]);
        sb.append(10);
        return sb.toString();
    }
}
