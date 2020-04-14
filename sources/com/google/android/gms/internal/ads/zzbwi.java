package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbwi implements zzdwb<zzbqs<VideoLifecycleCallbacks>> {
    private final zzdwo<zzbyv> zzfcs;
    private final zzdwo<Executor> zzfdx;
    private final zzbwc zzfnv;

    public zzbwi(zzbwc zzbwc, zzdwo<zzbyv> zzdwo, zzdwo<Executor> zzdwo2) {
        this.zzfnv = zzbwc;
        this.zzfcs = zzdwo;
        this.zzfdx = zzdwo2;
    }

    public final /* synthetic */ Object get() {
        return (zzbqs) zzdwh.zza(new zzbqs((zzbyv) this.zzfcs.get(), (Executor) this.zzfdx.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
