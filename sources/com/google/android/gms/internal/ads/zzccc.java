package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzccc implements zzdwb<Set<zzbqs<zztp>>> {
    private final zzdwo<Executor> zzfck;
    private final zzdwo<zzcch> zzfrj;
    private final zzcbx zzfsp;

    private zzccc(zzcbx zzcbx, zzdwo<zzcch> zzdwo, zzdwo<Executor> zzdwo2) {
        this.zzfsp = zzcbx;
        this.zzfrj = zzdwo;
        this.zzfck = zzdwo2;
    }

    public static zzccc zze(zzcbx zzcbx, zzdwo<zzcch> zzdwo, zzdwo<Executor> zzdwo2) {
        return new zzccc(zzcbx, zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdwh.zza(zzcbx.zzg((zzcch) this.zzfrj.get(), (Executor) this.zzfck.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
