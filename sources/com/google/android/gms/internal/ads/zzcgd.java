package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcgd<DelegateT, AdapterT> implements zzcga<AdapterT> {
    @VisibleForTesting
    private final zzcga<DelegateT> zzfxe;
    private final zzdal<DelegateT, AdapterT> zzfxf;

    public zzcgd(zzcga<DelegateT> zzcga, zzdal<DelegateT, AdapterT> zzdal) {
        this.zzfxe = zzcga;
        this.zzfxf = zzdal;
    }

    public final boolean zza(zzcvz zzcvz, zzcvr zzcvr) {
        return this.zzfxe.zza(zzcvz, zzcvr);
    }

    public final zzddi<AdapterT> zzb(zzcvz zzcvz, zzcvr zzcvr) {
        return zzdcy.zzb(this.zzfxe.zzb(zzcvz, zzcvr), this.zzfxf, (Executor) zzaxn.zzdwi);
    }
}
