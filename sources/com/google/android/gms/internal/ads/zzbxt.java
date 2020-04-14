package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbxt implements zzdwb<zzbxe> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<Executor> zzfdx;
    private final zzdwo<zzcwe> zzfef;
    private final zzdwo<zzbzl> zzfno;

    public zzbxt(zzdwo<Context> zzdwo, zzdwo<zzcwe> zzdwo2, zzdwo<Executor> zzdwo3, zzdwo<zzbzl> zzdwo4) {
        this.zzejy = zzdwo;
        this.zzfef = zzdwo2;
        this.zzfdx = zzdwo3;
        this.zzfno = zzdwo4;
    }

    public final /* synthetic */ Object get() {
        return new zzbxe((Context) this.zzejy.get(), (zzcwe) this.zzfef.get(), (Executor) this.zzfdx.get(), (zzbzl) this.zzfno.get());
    }
}
