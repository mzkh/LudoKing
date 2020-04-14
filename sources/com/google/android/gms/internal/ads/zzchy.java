package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzchy implements zzdwb<zzchw> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzaxl> zzfcq;
    private final zzdwo<Executor> zzfdx;
    private final zzdwo<zzbso> zzfxj;

    public zzchy(zzdwo<Context> zzdwo, zzdwo<zzaxl> zzdwo2, zzdwo<zzbso> zzdwo3, zzdwo<Executor> zzdwo4) {
        this.zzejy = zzdwo;
        this.zzfcq = zzdwo2;
        this.zzfxj = zzdwo3;
        this.zzfdx = zzdwo4;
    }

    public final /* synthetic */ Object get() {
        return new zzchw((Context) this.zzejy.get(), (zzaxl) this.zzfcq.get(), (zzbso) this.zzfxj.get(), (Executor) this.zzfdx.get());
    }
}
