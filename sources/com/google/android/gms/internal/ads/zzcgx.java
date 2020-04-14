package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcgx implements zzdwb<zzcgv> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzaxl> zzfcq;
    private final zzdwo<Executor> zzfdx;
    private final zzdwo<zzbjn> zzfxj;

    public zzcgx(zzdwo<Context> zzdwo, zzdwo<zzaxl> zzdwo2, zzdwo<zzbjn> zzdwo3, zzdwo<Executor> zzdwo4) {
        this.zzejy = zzdwo;
        this.zzfcq = zzdwo2;
        this.zzfxj = zzdwo3;
        this.zzfdx = zzdwo4;
    }

    public final /* synthetic */ Object get() {
        return new zzcgv((Context) this.zzejy.get(), (zzaxl) this.zzfcq.get(), (zzbjn) this.zzfxj.get(), (Executor) this.zzfdx.get());
    }
}
