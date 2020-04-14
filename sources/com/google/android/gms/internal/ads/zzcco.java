package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcco implements Runnable {
    private final String zzeft;
    private final zzccj zzfsr;
    private final zzcwm zzfte;
    private final zzaft zzftf;
    private final List zzftg;

    zzcco(zzccj zzccj, zzcwm zzcwm, zzaft zzaft, List list, String str) {
        this.zzfsr = zzccj;
        this.zzfte = zzcwm;
        this.zzftf = zzaft;
        this.zzftg = list;
        this.zzeft = str;
    }

    public final void run() {
        this.zzfsr.zza(this.zzfte, this.zzftf, this.zzftg, this.zzeft);
    }
}
