package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzgd extends Exception {
    private final int type;
    private final int zzack;

    public static zzgd zza(Exception exc, int i) {
        return new zzgd(1, null, exc, i);
    }

    public static zzgd zza(IOException iOException) {
        return new zzgd(0, null, iOException, -1);
    }

    static zzgd zza(RuntimeException runtimeException) {
        return new zzgd(2, null, runtimeException, -1);
    }

    private zzgd(int i, String str, Throwable th, int i2) {
        super(null, th);
        this.type = i;
        this.zzack = i2;
    }
}
