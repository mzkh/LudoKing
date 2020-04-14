package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcgk implements zzdwb<zzcgg> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<Executor> zzfdx;
    private final zzdwo<zzcwe> zzfef;
    private final zzdwo<zzbzl> zzfno;
    private final zzdwo<zzbie> zzfxj;

    public zzcgk(zzdwo<zzbie> zzdwo, zzdwo<Context> zzdwo2, zzdwo<Executor> zzdwo3, zzdwo<zzbzl> zzdwo4, zzdwo<zzcwe> zzdwo5) {
        this.zzfxj = zzdwo;
        this.zzejy = zzdwo2;
        this.zzfdx = zzdwo3;
        this.zzfno = zzdwo4;
        this.zzfef = zzdwo5;
    }

    public final /* synthetic */ Object get() {
        zzcgg zzcgg = new zzcgg((zzbie) this.zzfxj.get(), (Context) this.zzejy.get(), (Executor) this.zzfdx.get(), (zzbzl) this.zzfno.get(), (zzcwe) this.zzfef.get());
        return zzcgg;
    }
}
