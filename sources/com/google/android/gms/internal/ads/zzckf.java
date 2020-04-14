package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzckf implements zzdwb<zzcju> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzaxl> zzfcq;
    private final zzdwo<Executor> zzfdx;
    private final zzdwo<zzcwe> zzfef;
    private final zzdwo<zzbzl> zzfno;
    private final zzdwo<zzbzc> zzfxj;

    public zzckf(zzdwo<Context> zzdwo, zzdwo<zzaxl> zzdwo2, zzdwo<zzcwe> zzdwo3, zzdwo<Executor> zzdwo4, zzdwo<zzbzc> zzdwo5, zzdwo<zzbzl> zzdwo6) {
        this.zzejy = zzdwo;
        this.zzfcq = zzdwo2;
        this.zzfef = zzdwo3;
        this.zzfdx = zzdwo4;
        this.zzfxj = zzdwo5;
        this.zzfno = zzdwo6;
    }

    public final /* synthetic */ Object get() {
        zzcju zzcju = new zzcju((Context) this.zzejy.get(), (zzaxl) this.zzfcq.get(), (zzcwe) this.zzfef.get(), (Executor) this.zzfdx.get(), (zzbzc) this.zzfxj.get(), (zzbzl) this.zzfno.get());
        return zzcju;
    }
}
