package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdoj {
    private static final ThreadLocal<SecureRandom> zzhew = new zzdom();

    /* access modifiers changed from: private */
    public static SecureRandom zzaxb() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }

    public static byte[] zzff(int i) {
        byte[] bArr = new byte[i];
        ((SecureRandom) zzhew.get()).nextBytes(bArr);
        return bArr;
    }
}
