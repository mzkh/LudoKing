package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcbq implements zzdwb<zzcbo> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzaxm> zzepi;
    private final zzdwo<Executor> zzfck;

    public zzcbq(zzdwo<Executor> zzdwo, zzdwo<zzaxm> zzdwo2, zzdwo<Context> zzdwo3) {
        this.zzfck = zzdwo;
        this.zzepi = zzdwo2;
        this.zzejy = zzdwo3;
    }

    public final /* synthetic */ Object get() {
        return new zzcbo((Executor) this.zzfck.get(), (zzaxm) this.zzepi.get(), (Context) this.zzejy.get());
    }
}
