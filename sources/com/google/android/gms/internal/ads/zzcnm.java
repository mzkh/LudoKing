package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcnm implements zzdwb<zzcnk> {
    private final zzdwo<Executor> zzfck;
    private final zzdwo<zzcee> zzgdt;

    public zzcnm(zzdwo<Executor> zzdwo, zzdwo<zzcee> zzdwo2) {
        this.zzfck = zzdwo;
        this.zzgdt = zzdwo2;
    }

    public final /* synthetic */ Object get() {
        return new zzcnk((Executor) this.zzfck.get(), (zzcee) this.zzgdt.get());
    }
}
