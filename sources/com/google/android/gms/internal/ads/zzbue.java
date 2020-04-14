package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbue implements zzdwb<zzbhx> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<Executor> zzfck;
    private final zzdwo<Clock> zzfco;
    private final zzdwo<zzpe> zzfkm;

    public zzbue(zzdwo<zzpe> zzdwo, zzdwo<Executor> zzdwo2, zzdwo<Context> zzdwo3, zzdwo<Clock> zzdwo4) {
        this.zzfkm = zzdwo;
        this.zzfck = zzdwo2;
        this.zzejy = zzdwo3;
        this.zzfco = zzdwo4;
    }

    public final /* synthetic */ Object get() {
        return (zzbhx) zzdwh.zza(new zzbhx((Executor) this.zzfck.get(), new zzbhi((Context) this.zzejy.get(), (zzpe) this.zzfkm.get()), (Clock) this.zzfco.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
