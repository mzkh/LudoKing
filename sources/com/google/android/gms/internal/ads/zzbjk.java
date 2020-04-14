package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbjk implements zzdwb<zzcru<zzcno>> {
    private final zzdwo<ScheduledExecutorService> zzfdm;
    private final zzdwo<zzcnn> zzfeh;

    public zzbjk(zzdwo<zzcnn> zzdwo, zzdwo<ScheduledExecutorService> zzdwo2) {
        this.zzfeh = zzdwo;
        this.zzfdm = zzdwo2;
    }

    public final /* synthetic */ Object get() {
        return (zzcru) zzdwh.zza(new zzcqq((zzcnn) this.zzfeh.get(), 0, (ScheduledExecutorService) this.zzfdm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
