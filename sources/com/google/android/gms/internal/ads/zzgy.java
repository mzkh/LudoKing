package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzgy {
    public static final zzgy zzagd = new zzhb();

    public abstract zzha zza(int i, zzha zzha, boolean z);

    public abstract zzhd zza(int i, zzhd zzhd, boolean z, long j);

    public abstract int zzc(Object obj);

    public abstract int zzep();

    public abstract int zzeq();

    public final boolean isEmpty() {
        return zzep() == 0;
    }

    public final zzhd zza(int i, zzhd zzhd, boolean z) {
        return zza(i, zzhd, false, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        if ((zzep() - 1) == 0) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(int r3, com.google.android.gms.internal.ads.zzha r4, com.google.android.gms.internal.ads.zzhd r5, int r6) {
        /*
            r2 = this;
            r0 = 0
            r2.zza(r3, r4, r0)
            r2.zza(r0, r5, r0)
            r4 = 1
            if (r3 != 0) goto L_0x0031
            r3 = -1
            if (r6 == 0) goto L_0x0022
            if (r6 == r4) goto L_0x0020
            r1 = 2
            if (r6 != r1) goto L_0x001a
            int r6 = r2.zzep()
            int r6 = r6 - r4
            if (r6 != 0) goto L_0x002a
            goto L_0x0020
        L_0x001a:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            r3.<init>()
            throw r3
        L_0x0020:
            r4 = 0
            goto L_0x002a
        L_0x0022:
            int r6 = r2.zzep()
            int r6 = r6 - r4
            if (r6 != 0) goto L_0x002a
            r4 = -1
        L_0x002a:
            if (r4 != r3) goto L_0x002d
            return r3
        L_0x002d:
            r2.zza(r4, r5, r0)
            return r0
        L_0x0031:
            int r3 = r3 + r4
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgy.zza(int, com.google.android.gms.internal.ads.zzha, com.google.android.gms.internal.ads.zzhd, int):int");
    }
}
