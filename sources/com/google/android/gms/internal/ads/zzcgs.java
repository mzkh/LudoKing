package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcgs implements zzdwb<zzcgn> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<Executor> zzfdx;
    private final zzdwo<zzcwe> zzfef;
    private final zzdwo<zzbzl> zzfno;
    private final zzdwo<zzbjn> zzfxj;
    private final zzdwo<zzdal<zzcvr, zzavd>> zzfxo;

    public zzcgs(zzdwo<zzbjn> zzdwo, zzdwo<Context> zzdwo2, zzdwo<Executor> zzdwo3, zzdwo<zzbzl> zzdwo4, zzdwo<zzcwe> zzdwo5, zzdwo<zzdal<zzcvr, zzavd>> zzdwo6) {
        this.zzfxj = zzdwo;
        this.zzejy = zzdwo2;
        this.zzfdx = zzdwo3;
        this.zzfno = zzdwo4;
        this.zzfef = zzdwo5;
        this.zzfxo = zzdwo6;
    }

    public final /* synthetic */ Object get() {
        zzcgn zzcgn = new zzcgn((zzbjn) this.zzfxj.get(), (Context) this.zzejy.get(), (Executor) this.zzfdx.get(), (zzbzl) this.zzfno.get(), (zzcwe) this.zzfef.get(), (zzdal) this.zzfxo.get());
        return zzcgn;
    }
}
