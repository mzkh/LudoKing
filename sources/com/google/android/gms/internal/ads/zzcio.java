package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcio implements zzdwb<zzcip> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<Executor> zzfdx;
    private final zzdwo<zzbtl> zzfxj;

    public zzcio(zzdwo<Context> zzdwo, zzdwo<zzbtl> zzdwo2, zzdwo<Executor> zzdwo3) {
        this.zzejy = zzdwo;
        this.zzfxj = zzdwo2;
        this.zzfdx = zzdwo3;
    }

    public final /* synthetic */ Object get() {
        return new zzcip((Context) this.zzejy.get(), (zzbtl) this.zzfxj.get(), (Executor) this.zzfdx.get());
    }
}
