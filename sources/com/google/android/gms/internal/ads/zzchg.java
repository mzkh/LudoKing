package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzchg implements Callable {
    private final zzcvr zzfea;
    private final zzcvz zzfom;
    private final zzchh zzfya;

    zzchg(zzchh zzchh, zzcvz zzcvz, zzcvr zzcvr) {
        this.zzfya = zzchh;
        this.zzfom = zzcvz;
        this.zzfea = zzcvr;
    }

    public final Object call() {
        return this.zzfya.zzc(this.zzfom, this.zzfea);
    }
}
