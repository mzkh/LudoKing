package com.tapjoy.internal;

import java.io.Serializable;
import java.util.Arrays;

/* renamed from: com.tapjoy.internal.iu */
public class C3197iu implements Serializable, Comparable {

    /* renamed from: a */
    static final char[] f7627a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    public static final C3197iu f7628b = new C3197iu((byte[]) new byte[0].clone());

    /* renamed from: c */
    final byte[] f7629c;

    /* renamed from: d */
    transient int f7630d;

    /* renamed from: e */
    transient String f7631e;

    public /* synthetic */ int compareTo(Object obj) {
        C3197iu iuVar = (C3197iu) obj;
        int c = mo30308c();
        int c2 = iuVar.mo30308c();
        int min = Math.min(c, c2);
        for (int i = 0; i < min; i++) {
            byte a = mo30302a(i) & 255;
            byte a2 = iuVar.mo30302a(i) & 255;
            if (a != a2) {
                return a < a2 ? -1 : 1;
            }
        }
        if (c == c2) {
            return 0;
        }
        return c < c2 ? -1 : 1;
    }

    public C3197iu(byte[] bArr) {
        this.f7629c = bArr;
    }

    /* renamed from: a */
    public String mo30304a() {
        String str = this.f7631e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f7629c, C3211je.f7657a);
        this.f7631e = str2;
        return str2;
    }

    /* renamed from: b */
    public String mo30307b() {
        byte[] bArr = this.f7629c;
        char[] cArr = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f7627a;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public C3197iu mo30303a(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.f7629c;
            if (i2 <= bArr.length) {
                int i3 = i2 - i;
                if (i3 < 0) {
                    throw new IllegalArgumentException("endIndex < beginIndex");
                } else if (i == 0 && i2 == bArr.length) {
                    return this;
                } else {
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(this.f7629c, i, bArr2, 0, i3);
                    return new C3197iu(bArr2);
                }
            } else {
                StringBuilder sb = new StringBuilder("endIndex > length(");
                sb.append(this.f7629c.length);
                sb.append(")");
                throw new IllegalArgumentException(sb.toString());
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0");
        }
    }

    /* renamed from: a */
    public byte mo30302a(int i) {
        return this.f7629c[i];
    }

    /* renamed from: c */
    public int mo30308c() {
        return this.f7629c.length;
    }

    /* renamed from: d */
    public byte[] mo30310d() {
        return (byte[]) this.f7629c.clone();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo30305a(C3194ir irVar) {
        byte[] bArr = this.f7629c;
        irVar.mo30273a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public boolean mo30306a(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.f7629c;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && C3211je.m7462a(bArr2, i, bArr, i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C3197iu) {
            C3197iu iuVar = (C3197iu) obj;
            int c = iuVar.mo30308c();
            byte[] bArr = this.f7629c;
            return c == bArr.length && iuVar.mo30306a(0, bArr, 0, bArr.length);
        }
    }

    public int hashCode() {
        int i = this.f7630d;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.f7629c);
        this.f7630d = hashCode;
        return hashCode;
    }

    public String toString() {
        if (this.f7629c.length == 0) {
            return "[size=0]";
        }
        String a = mo30304a();
        int length = a.length();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                i = a.length();
                break;
            } else if (i2 == 64) {
                break;
            } else {
                int codePointAt = a.codePointAt(i);
                if ((!Character.isISOControl(codePointAt) || codePointAt == 10 || codePointAt == 13) && codePointAt != 65533) {
                    i2++;
                    i += Character.charCount(codePointAt);
                }
            }
        }
        i = -1;
        String str = "…]";
        String str2 = "[size=";
        String str3 = "]";
        if (i != -1) {
            String replace = a.substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (i < a.length()) {
                StringBuilder sb = new StringBuilder(str2);
                sb.append(this.f7629c.length);
                sb.append(" text=");
                sb.append(replace);
                sb.append(str);
                return sb.toString();
            }
            StringBuilder sb2 = new StringBuilder("[text=");
            sb2.append(replace);
            sb2.append(str3);
            return sb2.toString();
        } else if (this.f7629c.length <= 64) {
            StringBuilder sb3 = new StringBuilder("[hex=");
            sb3.append(mo30307b());
            sb3.append(str3);
            return sb3.toString();
        } else {
            StringBuilder sb4 = new StringBuilder(str2);
            sb4.append(this.f7629c.length);
            sb4.append(" hex=");
            sb4.append(mo30303a(0, 64).mo30307b());
            sb4.append(str);
            return sb4.toString();
        }
    }
}
