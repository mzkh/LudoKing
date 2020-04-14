package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcry<T> implements zzdwb<zzcrt<T>> {
    private final zzdwo<Executor> zzfck;
    private final zzdwo<Set<zzcru<? extends zzcrr<T>>>> zzggo;

    private zzcry(zzdwo<Executor> zzdwo, zzdwo<Set<zzcru<? extends zzcrr<T>>>> zzdwo2) {
        this.zzfck = zzdwo;
        this.zzggo = zzdwo2;
    }

    public static <T> zzcry<T> zzat(zzdwo<Executor> zzdwo, zzdwo<Set<zzcru<? extends zzcrr<T>>>> zzdwo2) {
        return new zzcry<>(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return new zzcrt((Executor) this.zzfck.get(), (Set) this.zzggo.get());
    }
}
