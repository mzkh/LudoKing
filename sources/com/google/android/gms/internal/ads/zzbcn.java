package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbcn implements Runnable {
    private final Map zzdwd;
    private final zzbco zzehk;

    zzbcn(zzbco zzbco, Map map) {
        this.zzehk = zzbco;
        this.zzdwd = map;
    }

    public final void run() {
        this.zzehk.zzj(this.zzdwd);
    }
}
