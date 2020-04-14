package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcyl implements zzdwb<zzcyg> {
    private final zzdwo<zzcyf> zzene;
    private final zzdwo<zzddl> zzfck;
    private final zzdwo<ScheduledExecutorService> zzfdm;

    private zzcyl(zzdwo<zzddl> zzdwo, zzdwo<ScheduledExecutorService> zzdwo2, zzdwo<zzcyf> zzdwo3) {
        this.zzfck = zzdwo;
        this.zzfdm = zzdwo2;
        this.zzene = zzdwo3;
    }

    public static zzcyl zzs(zzdwo<zzddl> zzdwo, zzdwo<ScheduledExecutorService> zzdwo2, zzdwo<zzcyf> zzdwo3) {
        return new zzcyl(zzdwo, zzdwo2, zzdwo3);
    }

    public final /* synthetic */ Object get() {
        return new zzcyg((zzddl) this.zzfck.get(), (ScheduledExecutorService) this.zzfdm.get(), (zzcyf) this.zzene.get());
    }
}
