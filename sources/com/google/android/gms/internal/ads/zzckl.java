package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzckl implements zzdwb<zzcke> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<Executor> zzfdx;
    private final zzdwo<zzbzc> zzfxj;

    public zzckl(zzdwo<Context> zzdwo, zzdwo<Executor> zzdwo2, zzdwo<zzbzc> zzdwo3) {
        this.zzejy = zzdwo;
        this.zzfdx = zzdwo2;
        this.zzfxj = zzdwo3;
    }

    public final /* synthetic */ Object get() {
        return new zzcke((Context) this.zzejy.get(), (Executor) this.zzfdx.get(), (zzbzc) this.zzfxj.get());
    }
}
