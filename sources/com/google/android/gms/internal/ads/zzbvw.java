package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbvw implements zzdwb<zzbvr> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzbuz> zzetd;
    private final zzdwo<zzbyh> zzeuf;
    private final zzdwo<zzbzl> zzfno;
    private final zzdwo<zzbhx> zzfnp;

    public zzbvw(zzdwo<Context> zzdwo, zzdwo<zzbzl> zzdwo2, zzdwo<zzbyh> zzdwo3, zzdwo<zzbhx> zzdwo4, zzdwo<zzbuz> zzdwo5) {
        this.zzejy = zzdwo;
        this.zzfno = zzdwo2;
        this.zzeuf = zzdwo3;
        this.zzfnp = zzdwo4;
        this.zzetd = zzdwo5;
    }

    public final /* synthetic */ Object get() {
        zzbvr zzbvr = new zzbvr((Context) this.zzejy.get(), (zzbzl) this.zzfno.get(), (zzbyh) this.zzeuf.get(), (zzbhx) this.zzfnp.get(), (zzbuz) this.zzetd.get());
        return zzbvr;
    }
}
