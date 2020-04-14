package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.cj */
public final class C2924cj {

    /* renamed from: a */
    private final String[] f6747a = new String[512];

    /* renamed from: a */
    public final String mo29915a(char[] cArr, int i, int i2) {
        boolean z = false;
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 = (i3 * 31) + cArr[i4];
        }
        int i5 = ((i3 >>> 20) ^ (i3 >>> 12)) ^ i3;
        int i6 = i5 ^ ((i5 >>> 7) ^ (i5 >>> 4));
        String[] strArr = this.f6747a;
        int length = i6 & (strArr.length - 1);
        String str = strArr[length];
        if (str != null) {
            if (str.length() == i2) {
                int i7 = 0;
                while (true) {
                    if (i7 >= i2) {
                        z = true;
                        break;
                    } else if (cArr[i + i7] != str.charAt(i7)) {
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            if (z) {
                return str;
            }
        }
        String str2 = new String(cArr, i, i2);
        this.f6747a[length] = str2;
        return str2;
    }
}
