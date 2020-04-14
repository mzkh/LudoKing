package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcfi implements Callable {
    private final zzcfh zzfvv;

    private zzcfi(zzcfh zzcfh) {
        this.zzfvv = zzcfh;
    }

    static Callable zza(zzcfh zzcfh) {
        return new zzcfi(zzcfh);
    }

    public final Object call() {
        return this.zzfvv.getWritableDatabase();
    }
}
