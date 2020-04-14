package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzche implements zzdwb<zzchd> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<Executor> zzfdx;
    private final zzdwo<zzbso> zzfxj;
    private final zzdwo<zzcvp> zzfxz;

    public zzche(zzdwo<Context> zzdwo, zzdwo<Executor> zzdwo2, zzdwo<zzbso> zzdwo3, zzdwo<zzcvp> zzdwo4) {
        this.zzejy = zzdwo;
        this.zzfdx = zzdwo2;
        this.zzfxj = zzdwo3;
        this.zzfxz = zzdwo4;
    }

    public final /* synthetic */ Object get() {
        return new zzchd((Context) this.zzejy.get(), (Executor) this.zzfdx.get(), (zzbso) this.zzfxj.get(), (zzcvp) this.zzfxz.get());
    }
}
