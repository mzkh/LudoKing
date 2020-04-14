package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcca implements zzdwb<Set<zzbqs<zzbpc>>> {
    public static Set<zzbqs<zzbpc>> zza(zzcbx zzcbx, zzcch zzcch, Executor executor) {
        return (Set) zzdwh.zza(zzcbx.zzi(zzcch, executor), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        throw new NoSuchMethodError();
    }
}
