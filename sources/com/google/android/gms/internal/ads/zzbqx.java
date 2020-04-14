package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbqx implements zzdwb<zzbqv> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<Set<zzbqs<zzpj>>> zzfed;
    private final zzdwo<zzcvr> zzfes;

    private zzbqx(zzdwo<Context> zzdwo, zzdwo<Set<zzbqs<zzpj>>> zzdwo2, zzdwo<zzcvr> zzdwo3) {
        this.zzejy = zzdwo;
        this.zzfed = zzdwo2;
        this.zzfes = zzdwo3;
    }

    public static zzbqx zzi(zzdwo<Context> zzdwo, zzdwo<Set<zzbqs<zzpj>>> zzdwo2, zzdwo<zzcvr> zzdwo3) {
        return new zzbqx(zzdwo, zzdwo2, zzdwo3);
    }

    public final /* synthetic */ Object get() {
        return new zzbqv((Context) this.zzejy.get(), (Set) this.zzfed.get(), (zzcvr) this.zzfes.get());
    }
}
