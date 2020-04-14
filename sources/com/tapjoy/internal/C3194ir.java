package com.tapjoy.internal;

import android.support.p000v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.nio.charset.Charset;

/* renamed from: com.tapjoy.internal.ir */
public final class C3194ir implements C3195is, C3196it, Cloneable {

    /* renamed from: c */
    private static final byte[] f7624c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a */
    C3203iy f7625a;

    /* renamed from: b */
    long f7626b;

    /* renamed from: a */
    public final C3195is mo30274a() {
        return this;
    }

    public final void close() {
    }

    public final void flush() {
    }

    /* renamed from: b */
    public final boolean mo30282b() {
        return this.f7626b == 0;
    }

    /* renamed from: a */
    public final void mo30275a(long j) {
        if (this.f7626b < j) {
            throw new EOFException();
        }
    }

    /* renamed from: c */
    public final byte mo30283c() {
        if (this.f7626b != 0) {
            C3203iy iyVar = this.f7625a;
            int i = iyVar.f7644b;
            int i2 = iyVar.f7645c;
            int i3 = i + 1;
            byte b = iyVar.f7643a[i];
            this.f7626b--;
            if (i3 == i2) {
                this.f7625a = iyVar.mo30318a();
                C3204iz.m7442a(iyVar);
            } else {
                iyVar.f7644b = i3;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    /* renamed from: d */
    public final int mo30288d() {
        if (this.f7626b >= 4) {
            C3203iy iyVar = this.f7625a;
            int i = iyVar.f7644b;
            int i2 = iyVar.f7645c;
            if (i2 - i < 4) {
                return ((mo30283c() & 255) << 24) | ((mo30283c() & 255) << 16) | ((mo30283c() & 255) << 8) | (mo30283c() & 255);
            }
            byte[] bArr = iyVar.f7643a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i5 = i4 + 1;
            byte b2 = b | ((bArr[i4] & 255) << 8);
            int i6 = i5 + 1;
            byte b3 = b2 | (bArr[i5] & 255);
            this.f7626b -= 4;
            if (i6 == i2) {
                this.f7625a = iyVar.mo30318a();
                C3204iz.m7442a(iyVar);
            } else {
                iyVar.f7644b = i6;
            }
            return b3;
        }
        StringBuilder sb = new StringBuilder("size < 4: ");
        sb.append(this.f7626b);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: e */
    public final int mo30291e() {
        return C3211je.m7458a(mo30288d());
    }

    /* renamed from: b */
    public final C3197iu mo30281b(long j) {
        return new C3197iu(m7365g(j));
    }

    /* renamed from: c */
    public final String mo30285c(long j) {
        Charset charset = C3211je.f7657a;
        C3211je.m7460a(this.f7626b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            StringBuilder sb = new StringBuilder("byteCount > Integer.MAX_VALUE: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (j == 0) {
            return "";
        } else {
            C3203iy iyVar = this.f7625a;
            if (((long) iyVar.f7644b) + j > ((long) iyVar.f7645c)) {
                return new String(m7365g(j), charset);
            }
            String str = new String(iyVar.f7643a, iyVar.f7644b, (int) j, charset);
            iyVar.f7644b = (int) (((long) iyVar.f7644b) + j);
            this.f7626b -= j;
            if (iyVar.f7644b == iyVar.f7645c) {
                this.f7625a = iyVar.mo30318a();
                C3204iz.m7442a(iyVar);
            }
            return str;
        }
    }

    /* renamed from: g */
    public final byte[] mo30298g() {
        try {
            return m7365g(this.f7626b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: g */
    private byte[] m7365g(long j) {
        C3211je.m7460a(this.f7626b, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            m7364a(bArr);
            return bArr;
        }
        StringBuilder sb = new StringBuilder("byteCount > Integer.MAX_VALUE: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    private void m7364a(byte[] bArr) {
        int i;
        int i2 = 0;
        while (i2 < bArr.length) {
            int length = bArr.length - i2;
            C3211je.m7460a((long) bArr.length, (long) i2, (long) length);
            C3203iy iyVar = this.f7625a;
            if (iyVar == null) {
                i = -1;
            } else {
                i = Math.min(length, iyVar.f7645c - iyVar.f7644b);
                System.arraycopy(iyVar.f7643a, iyVar.f7644b, bArr, i2, i);
                iyVar.f7644b += i;
                this.f7626b -= (long) i;
                if (iyVar.f7644b == iyVar.f7645c) {
                    this.f7625a = iyVar.mo30318a();
                    C3204iz.m7442a(iyVar);
                }
            }
            if (i != -1) {
                i2 += i;
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: d */
    public final void mo30290d(long j) {
        while (j > 0) {
            C3203iy iyVar = this.f7625a;
            if (iyVar != null) {
                int min = (int) Math.min(j, (long) (iyVar.f7645c - this.f7625a.f7644b));
                long j2 = (long) min;
                this.f7626b -= j2;
                j -= j2;
                this.f7625a.f7644b += min;
                if (this.f7625a.f7644b == this.f7625a.f7645c) {
                    C3203iy iyVar2 = this.f7625a;
                    this.f7625a = iyVar2.mo30318a();
                    C3204iz.m7442a(iyVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: a */
    public final C3194ir mo30279b(C3197iu iuVar) {
        if (iuVar != null) {
            iuVar.mo30305a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* renamed from: a */
    public final C3194ir mo30280b(String str) {
        char c;
        int length = str.length();
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (length < 0) {
            StringBuilder sb = new StringBuilder("endIndex < beginIndex: ");
            sb.append(length);
            sb.append(" < 0");
            throw new IllegalArgumentException(sb.toString());
        } else if (length <= str.length()) {
            int i = 0;
            while (i < length) {
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    C3203iy c2 = mo30284c(1);
                    byte[] bArr = c2.f7643a;
                    int i2 = c2.f7645c - i;
                    int min = Math.min(length, 8192 - i2);
                    int i3 = i + 1;
                    bArr[i + i2] = (byte) charAt;
                    while (true) {
                        i = i3;
                        if (i >= min) {
                            break;
                        }
                        char charAt2 = str.charAt(i);
                        if (charAt2 >= 128) {
                            break;
                        }
                        i3 = i + 1;
                        bArr[i + i2] = (byte) charAt2;
                    }
                    int i4 = (i2 + i) - c2.f7645c;
                    c2.f7645c += i4;
                    this.f7626b += (long) i4;
                } else {
                    if (charAt < 2048) {
                        mo30293e((charAt >> 6) | 192);
                        mo30293e((int) (charAt & '?') | 128);
                    } else if (charAt < 55296 || charAt > 57343) {
                        mo30293e((charAt >> 12) | 224);
                        mo30293e(((charAt >> 6) & 63) | 128);
                        mo30293e((int) (charAt & '?') | 128);
                    } else {
                        int i5 = i + 1;
                        if (i5 < length) {
                            c = str.charAt(i5);
                        } else {
                            c = 0;
                        }
                        if (charAt > 56319 || c < 56320 || c > 57343) {
                            mo30293e(63);
                            i = i5;
                        } else {
                            int i6 = (((charAt & 10239) << 10) | (9215 & c)) + 0;
                            mo30293e((i6 >> 18) | 240);
                            mo30293e(((i6 >> 12) & 63) | 128);
                            mo30293e(((i6 >> 6) & 63) | 128);
                            mo30293e((i6 & 63) | 128);
                            i += 2;
                        }
                    }
                    i++;
                }
            }
            return this;
        } else {
            StringBuilder sb2 = new StringBuilder("endIndex > string.length: ");
            sb2.append(length);
            sb2.append(" > ");
            sb2.append(str.length());
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    /* renamed from: a */
    public final C3194ir mo30273a(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            C3211je.m7460a((long) bArr.length, 0, j);
            int i3 = i2 + 0;
            while (i < i3) {
                C3203iy c = mo30284c(1);
                int min = Math.min(i3 - i, 8192 - c.f7645c);
                System.arraycopy(bArr, i, c.f7643a, c.f7645c, min);
                i += min;
                c.f7645c += min;
            }
            this.f7626b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public final C3194ir mo30293e(int i) {
        C3203iy c = mo30284c(1);
        byte[] bArr = c.f7643a;
        int i2 = c.f7645c;
        c.f7645c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f7626b++;
        return this;
    }

    /* renamed from: b */
    public final C3194ir mo30289d(int i) {
        int a = C3211je.m7458a(i);
        C3203iy c = mo30284c(4);
        byte[] bArr = c.f7643a;
        int i2 = c.f7645c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((a >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((a >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((a >>> 8) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (a & 255);
        c.f7645c = i6;
        this.f7626b += 4;
        return this;
    }

    /* renamed from: e */
    public final C3194ir mo30296f(long j) {
        long a = C3211je.m7459a(j);
        C3203iy c = mo30284c(8);
        byte[] bArr = c.f7643a;
        int i = c.f7645c;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) ((a >>> 56) & 255));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((a >>> 48) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((a >>> 40) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((a >>> 32) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((a >>> 24) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((a >>> 16) & 255));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) ((a >>> 8) & 255));
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((int) (a & 255));
        c.f7645c = i9;
        this.f7626b += 8;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final C3203iy mo30284c(int i) {
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        }
        C3203iy iyVar = this.f7625a;
        if (iyVar == null) {
            this.f7625a = C3204iz.m7441a();
            C3203iy iyVar2 = this.f7625a;
            iyVar2.f7649g = iyVar2;
            iyVar2.f7648f = iyVar2;
            return iyVar2;
        }
        C3203iy iyVar3 = iyVar.f7649g;
        if (iyVar3.f7645c + i > 8192 || !iyVar3.f7647e) {
            iyVar3 = iyVar3.mo30319a(C3204iz.m7441a());
        }
        return iyVar3;
    }

    /* renamed from: a */
    public final void mo30276a(C3194ir irVar, long j) {
        C3203iy iyVar;
        if (irVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (irVar != this) {
            C3211je.m7460a(irVar.f7626b, 0, j);
            while (j > 0) {
                int i = 0;
                if (j < ((long) (irVar.f7625a.f7645c - irVar.f7625a.f7644b))) {
                    C3203iy iyVar2 = this.f7625a;
                    C3203iy iyVar3 = iyVar2 != null ? iyVar2.f7649g : null;
                    if (iyVar3 != null && iyVar3.f7647e) {
                        if ((((long) iyVar3.f7645c) + j) - ((long) (iyVar3.f7646d ? 0 : iyVar3.f7644b)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            irVar.f7625a.mo30320a(iyVar3, (int) j);
                            irVar.f7626b -= j;
                            this.f7626b += j;
                            return;
                        }
                    }
                    C3203iy iyVar4 = irVar.f7625a;
                    int i2 = (int) j;
                    if (i2 <= 0 || i2 > iyVar4.f7645c - iyVar4.f7644b) {
                        throw new IllegalArgumentException();
                    }
                    if (i2 >= 1024) {
                        iyVar = new C3203iy(iyVar4);
                    } else {
                        iyVar = C3204iz.m7441a();
                        System.arraycopy(iyVar4.f7643a, iyVar4.f7644b, iyVar.f7643a, 0, i2);
                    }
                    iyVar.f7645c = iyVar.f7644b + i2;
                    iyVar4.f7644b += i2;
                    iyVar4.f7649g.mo30319a(iyVar);
                    irVar.f7625a = iyVar;
                }
                C3203iy iyVar5 = irVar.f7625a;
                long j2 = (long) (iyVar5.f7645c - iyVar5.f7644b);
                irVar.f7625a = iyVar5.mo30318a();
                C3203iy iyVar6 = this.f7625a;
                if (iyVar6 == null) {
                    this.f7625a = iyVar5;
                    C3203iy iyVar7 = this.f7625a;
                    iyVar7.f7649g = iyVar7;
                    iyVar7.f7648f = iyVar7;
                } else {
                    C3203iy a = iyVar6.f7649g.mo30319a(iyVar5);
                    if (a.f7649g == a) {
                        throw new IllegalStateException();
                    } else if (a.f7649g.f7647e) {
                        int i3 = a.f7645c - a.f7644b;
                        int i4 = 8192 - a.f7649g.f7645c;
                        if (!a.f7649g.f7646d) {
                            i = a.f7649g.f7644b;
                        }
                        if (i3 <= i4 + i) {
                            a.mo30320a(a.f7649g, i3);
                            a.mo30318a();
                            C3204iz.m7442a(a);
                        }
                    }
                }
                irVar.f7626b -= j2;
                this.f7626b += j2;
                j -= j2;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    /* renamed from: b */
    public final long mo30277b(C3194ir irVar, long j) {
        if (irVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j >= 0) {
            long j2 = this.f7626b;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            irVar.mo30276a(this, j);
            return j;
        } else {
            StringBuilder sb = new StringBuilder("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3194ir)) {
            return false;
        }
        C3194ir irVar = (C3194ir) obj;
        long j = this.f7626b;
        if (j != irVar.f7626b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        C3203iy iyVar = this.f7625a;
        C3203iy iyVar2 = irVar.f7625a;
        int i = iyVar.f7644b;
        int i2 = iyVar2.f7644b;
        while (j2 < this.f7626b) {
            long min = (long) Math.min(iyVar.f7645c - i, iyVar2.f7645c - i2);
            int i3 = i2;
            int i4 = i;
            int i5 = 0;
            while (((long) i5) < min) {
                int i6 = i4 + 1;
                int i7 = i3 + 1;
                if (iyVar.f7643a[i4] != iyVar2.f7643a[i3]) {
                    return false;
                }
                i5++;
                i4 = i6;
                i3 = i7;
            }
            if (i4 == iyVar.f7645c) {
                iyVar = iyVar.f7648f;
                i = iyVar.f7644b;
            } else {
                i = i4;
            }
            if (i3 == iyVar2.f7645c) {
                iyVar2 = iyVar2.f7648f;
                i2 = iyVar2.f7644b;
            } else {
                i2 = i3;
            }
            j2 += min;
        }
        return true;
    }

    public final int hashCode() {
        C3203iy iyVar = this.f7625a;
        if (iyVar == null) {
            return 0;
        }
        int i = 1;
        do {
            for (int i2 = iyVar.f7644b; i2 < iyVar.f7645c; i2++) {
                i = (i * 31) + iyVar.f7643a[i2];
            }
            iyVar = iyVar.f7648f;
        } while (iyVar != this.f7625a);
        return i;
    }

    /* renamed from: h */
    public final C3194ir clone() {
        C3194ir irVar = new C3194ir();
        if (this.f7626b == 0) {
            return irVar;
        }
        irVar.f7625a = new C3203iy(this.f7625a);
        C3203iy iyVar = irVar.f7625a;
        iyVar.f7649g = iyVar;
        iyVar.f7648f = iyVar;
        C3203iy iyVar2 = this.f7625a;
        while (true) {
            iyVar2 = iyVar2.f7648f;
            if (iyVar2 != this.f7625a) {
                irVar.f7625a.f7649g.mo30319a(new C3203iy(iyVar2));
            } else {
                irVar.f7626b = this.f7626b;
                return irVar;
            }
        }
    }

    /* renamed from: f */
    public final long mo30295f() {
        long j;
        if (this.f7626b >= 8) {
            C3203iy iyVar = this.f7625a;
            int i = iyVar.f7644b;
            int i2 = iyVar.f7645c;
            if (i2 - i < 8) {
                j = ((((long) mo30288d()) & 4294967295L) << 32) | (4294967295L & ((long) mo30288d()));
            } else {
                byte[] bArr = iyVar.f7643a;
                int i3 = i + 1;
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = i7 + 1;
                long j2 = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i3]) & 255) << 48) | ((((long) bArr[i4]) & 255) << 40) | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 24) | ((((long) bArr[i7]) & 255) << 16);
                int i9 = i8 + 1;
                long j3 = ((((long) bArr[i8]) & 255) << 8) | j2;
                int i10 = i9 + 1;
                long j4 = (((long) bArr[i9]) & 255) | j3;
                this.f7626b -= 8;
                if (i10 == i2) {
                    this.f7625a = iyVar.mo30318a();
                    C3204iz.m7442a(iyVar);
                } else {
                    iyVar.f7644b = i10;
                }
                j = j4;
            }
            return C3211je.m7459a(j);
        }
        StringBuilder sb = new StringBuilder("size < 8: ");
        sb.append(this.f7626b);
        throw new IllegalStateException(sb.toString());
    }

    public final String toString() {
        C3197iu iuVar;
        long j = this.f7626b;
        if (j <= 2147483647L) {
            int i = (int) j;
            if (i == 0) {
                iuVar = C3197iu.f7628b;
            } else {
                iuVar = new C3206ja(this, i);
            }
            return iuVar.toString();
        }
        StringBuilder sb = new StringBuilder("size > Integer.MAX_VALUE: ");
        sb.append(this.f7626b);
        throw new IllegalArgumentException(sb.toString());
    }
}
