package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcbw implements zzdwb<Set<zzbqs<zzbna>>> {
    private final zzdwo<Executor> zzfck;
    private final zzdwo<zzcch> zzfrj;
    private final zzcbx zzfsp;

    private zzcbw(zzcbx zzcbx, zzdwo<zzcch> zzdwo, zzdwo<Executor> zzdwo2) {
        this.zzfsp = zzcbx;
        this.zzfrj = zzdwo;
        this.zzfck = zzdwo2;
    }

    public static zzcbw zza(zzcbx zzcbx, zzdwo<zzcch> zzdwo, zzdwo<Executor> zzdwo2) {
        return new zzcbw(zzcbx, zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdwh.zza(zzcbx.zze((zzcch) this.zzfrj.get(), (Executor) this.zzfck.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
