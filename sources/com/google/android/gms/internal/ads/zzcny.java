package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcny implements zzdwb<zzcnt> {
    private final zzdwo<Executor> zzfck;
    private final zzdwo<zzddi<String>> zzgec;

    private zzcny(zzdwo<zzddi<String>> zzdwo, zzdwo<Executor> zzdwo2) {
        this.zzgec = zzdwo;
        this.zzfck = zzdwo2;
    }

    public static zzcny zzaj(zzdwo<zzddi<String>> zzdwo, zzdwo<Executor> zzdwo2) {
        return new zzcny(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return new zzcnt((zzddi) this.zzgec.get(), (Executor) this.zzfck.get());
    }
}
