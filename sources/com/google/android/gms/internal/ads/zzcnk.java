package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcnk implements zzdcj<zzape, zzcnl> {
    private Executor executor;
    private zzcee zzgdq;

    public zzcnk(Executor executor2, zzcee zzcee) {
        this.executor = executor2;
        this.zzgdq = zzcee;
    }

    public final /* synthetic */ zzddi zzf(Object obj) throws Exception {
        zzape zzape = (zzape) obj;
        return zzdcy.zzb(this.zzgdq.zzg(zzape), (zzdcj<? super I, ? extends O>) new zzcnj<Object,Object>(zzape), this.executor);
    }
}
