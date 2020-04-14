package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcdl implements zzdwb<zzbqs<zzbpc>> {
    private final zzdwo<Executor> zzfck;
    private final zzdwo<zzcej> zzfcs;

    private zzcdl(zzdwo<zzcej> zzdwo, zzdwo<Executor> zzdwo2) {
        this.zzfcs = zzdwo;
        this.zzfck = zzdwo2;
    }

    public static zzcdl zzac(zzdwo<zzcej> zzdwo, zzdwo<Executor> zzdwo2) {
        return new zzcdl(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return (zzbqs) zzdwh.zza(new zzbqs((zzcej) this.zzfcs.get(), (Executor) this.zzfck.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
