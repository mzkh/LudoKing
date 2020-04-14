package com.appsflyer.internal;

/* renamed from: com.appsflyer.internal.ap */
public class C1358ap {
    /* renamed from: ˋ */
    public static void m3310(byte[] bArr, byte b, long j) {
        for (int i = 0; i < bArr.length; i++) {
            if (((1 << i) & j) != 0) {
                bArr[i] = (byte) (bArr[i] ^ b);
            }
        }
    }
}
