package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcol implements zzdwb<zzcok> {
    private final zzdwo<Executor> zzfck;
    private final zzdwo<zzatr> zzgeg;

    private zzcol(zzdwo<Executor> zzdwo, zzdwo<zzatr> zzdwo2) {
        this.zzfck = zzdwo;
        this.zzgeg = zzdwo2;
    }

    public static zzcol zzal(zzdwo<Executor> zzdwo, zzdwo<zzatr> zzdwo2) {
        return new zzcol(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return new zzcok((Executor) this.zzfck.get(), (zzatr) this.zzgeg.get());
    }
}
