package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbxq implements zzdwb<zzbxn> {
    private final zzdwo<Executor> zzfdx;
    private final zzdwo<zzbhx> zzfnp;
    private final zzdwo<zzbqv> zzfph;

    public zzbxq(zzdwo<Executor> zzdwo, zzdwo<zzbhx> zzdwo2, zzdwo<zzbqv> zzdwo3) {
        this.zzfdx = zzdwo;
        this.zzfnp = zzdwo2;
        this.zzfph = zzdwo3;
    }

    public final /* synthetic */ Object get() {
        return new zzbxn((Executor) this.zzfdx.get(), (zzbhx) this.zzfnp.get(), (zzbqv) this.zzfph.get());
    }
}
