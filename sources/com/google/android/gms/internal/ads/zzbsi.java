package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbsi implements zzdwb<Set<zzbqs<zzbqp>>> {
    private final zzdwo<zzbtb> zzfdd;

    private zzbsi(zzdwo<zzbtb> zzdwo) {
        this.zzfdd = zzdwo;
    }

    public static zzbsi zzu(zzdwo<zzbtb> zzdwo) {
        return new zzbsi(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdwh.zza(Collections.singleton(zzbqs.zzb((zzbtb) this.zzfdd.get(), zzaxn.zzdwn)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
