package com.tapjoy.internal;

import java.util.Arrays;

/* renamed from: com.tapjoy.internal.ja */
final class C3206ja extends C3197iu {

    /* renamed from: f */
    final transient byte[][] f7652f;

    /* renamed from: g */
    final transient int[] f7653g;

    C3206ja(C3194ir irVar, int i) {
        super(null);
        C3211je.m7460a(irVar.f7626b, 0, (long) i);
        int i2 = 0;
        C3203iy iyVar = irVar.f7625a;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (iyVar.f7645c != iyVar.f7644b) {
                i3 += iyVar.f7645c - iyVar.f7644b;
                i4++;
                iyVar = iyVar.f7648f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f7652f = new byte[i4][];
        this.f7653g = new int[(i4 * 2)];
        C3203iy iyVar2 = irVar.f7625a;
        int i5 = 0;
        while (i2 < i) {
            this.f7652f[i5] = iyVar2.f7643a;
            i2 += iyVar2.f7645c - iyVar2.f7644b;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.f7653g;
            iArr[i5] = i2;
            iArr[this.f7652f.length + i5] = iyVar2.f7644b;
            iyVar2.f7646d = true;
            i5++;
            iyVar2 = iyVar2.f7648f;
        }
    }

    /* renamed from: a */
    public final String mo30304a() {
        return m7445e().mo30304a();
    }

    /* renamed from: b */
    public final String mo30307b() {
        return m7445e().mo30307b();
    }

    /* renamed from: a */
    public final C3197iu mo30303a(int i, int i2) {
        return m7445e().mo30303a(i, i2);
    }

    /* renamed from: a */
    public final byte mo30302a(int i) {
        int i2;
        C3211je.m7460a((long) this.f7653g[this.f7652f.length - 1], (long) i, 1);
        int b = m7444b(i);
        if (b == 0) {
            i2 = 0;
        } else {
            i2 = this.f7653g[b - 1];
        }
        int[] iArr = this.f7653g;
        byte[][] bArr = this.f7652f;
        return bArr[b][(i - i2) + iArr[bArr.length + b]];
    }

    /* renamed from: b */
    private int m7444b(int i) {
        int binarySearch = Arrays.binarySearch(this.f7653g, 0, this.f7652f.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ -1;
    }

    /* renamed from: c */
    public final int mo30308c() {
        return this.f7653g[this.f7652f.length - 1];
    }

    /* renamed from: d */
    public final byte[] mo30310d() {
        int[] iArr = this.f7653g;
        byte[][] bArr = this.f7652f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.f7653g;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.f7652f[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo30305a(C3194ir irVar) {
        int length = this.f7652f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.f7653g;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            C3203iy iyVar = new C3203iy(this.f7652f[i], i3, (i3 + i4) - i2);
            if (irVar.f7625a == null) {
                iyVar.f7649g = iyVar;
                iyVar.f7648f = iyVar;
                irVar.f7625a = iyVar;
            } else {
                irVar.f7625a.f7649g.mo30319a(iyVar);
            }
            i++;
            i2 = i4;
        }
        irVar.f7626b += (long) i2;
    }

    /* renamed from: a */
    public final boolean mo30306a(int i, byte[] bArr, int i2, int i3) {
        int i4;
        if (i < 0 || i > mo30308c() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int b = m7444b(i);
        while (i3 > 0) {
            if (b == 0) {
                i4 = 0;
            } else {
                i4 = this.f7653g[b - 1];
            }
            int min = Math.min(i3, ((this.f7653g[b] - i4) + i4) - i);
            int[] iArr = this.f7653g;
            byte[][] bArr2 = this.f7652f;
            if (!C3211je.m7462a(bArr2[b], (i - i4) + iArr[bArr2.length + b], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    /* renamed from: e */
    private C3197iu m7445e() {
        return new C3197iu(mo30310d());
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005c A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r12) {
        /*
            r11 = this;
            r0 = 1
            if (r12 != r11) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r12 instanceof com.tapjoy.internal.C3197iu
            r2 = 0
            if (r1 == 0) goto L_0x005d
            com.tapjoy.internal.iu r12 = (com.tapjoy.internal.C3197iu) r12
            int r1 = r12.mo30308c()
            int r3 = r11.mo30308c()
            if (r1 != r3) goto L_0x005d
            int r1 = r11.mo30308c()
            int r3 = r11.mo30308c()
            int r3 = r3 - r1
            if (r3 >= 0) goto L_0x0022
        L_0x0020:
            r12 = 0
            goto L_0x005a
        L_0x0022:
            int r3 = r11.m7444b(r2)
            r4 = 0
            r5 = 0
        L_0x0028:
            if (r1 <= 0) goto L_0x0059
            if (r3 != 0) goto L_0x002e
            r6 = 0
            goto L_0x0034
        L_0x002e:
            int[] r6 = r11.f7653g
            int r7 = r3 + -1
            r6 = r6[r7]
        L_0x0034:
            int[] r7 = r11.f7653g
            r7 = r7[r3]
            int r7 = r7 - r6
            int r7 = r7 + r6
            int r7 = r7 - r4
            int r7 = java.lang.Math.min(r1, r7)
            int[] r8 = r11.f7653g
            byte[][] r9 = r11.f7652f
            int r10 = r9.length
            int r10 = r10 + r3
            r8 = r8[r10]
            int r6 = r4 - r6
            int r6 = r6 + r8
            r8 = r9[r3]
            boolean r6 = r12.mo30306a(r5, r8, r6, r7)
            if (r6 != 0) goto L_0x0053
            goto L_0x0020
        L_0x0053:
            int r4 = r4 + r7
            int r5 = r5 + r7
            int r1 = r1 - r7
            int r3 = r3 + 1
            goto L_0x0028
        L_0x0059:
            r12 = 1
        L_0x005a:
            if (r12 == 0) goto L_0x005d
            return r0
        L_0x005d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3206ja.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i = this.f7630d;
        if (i != 0) {
            return i;
        }
        int length = this.f7652f.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.f7652f[i2];
            int[] iArr = this.f7653g;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.f7630d = i3;
        return i3;
    }

    public final String toString() {
        return m7445e().toString();
    }
}
