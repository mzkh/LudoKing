package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzccb implements zzdwb<Set<zzbqs<zzbog>>> {
    private final zzdwo<Executor> zzfck;
    private final zzdwo<zzcch> zzfrj;
    private final zzcbx zzfsp;

    private zzccb(zzcbx zzcbx, zzdwo<zzcch> zzdwo, zzdwo<Executor> zzdwo2) {
        this.zzfsp = zzcbx;
        this.zzfrj = zzdwo;
        this.zzfck = zzdwo2;
    }

    public static zzccb zzd(zzcbx zzcbx, zzdwo<zzcch> zzdwo, zzdwo<Executor> zzdwo2) {
        return new zzccb(zzcbx, zzdwo, zzdwo2);
    }

    public static Set<zzbqs<zzbog>> zzb(zzcbx zzcbx, zzcch zzcch, Executor executor) {
        return (Set) zzdwh.zza(zzcbx.zzc(zzcch, executor), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzb(this.zzfsp, (zzcch) this.zzfrj.get(), (Executor) this.zzfck.get());
    }
}
