package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcar implements zzdwb<Set<zzbqs<zzcym>>> {
    private final zzdwo<Executor> zzfck;
    private final zzdwo<zzcay> zzfcs;

    private zzcar(zzdwo<Executor> zzdwo, zzdwo<zzcay> zzdwo2) {
        this.zzfck = zzdwo;
        this.zzfcs = zzdwo2;
    }

    public static zzcar zzr(zzdwo<Executor> zzdwo, zzdwo<zzcay> zzdwo2) {
        return new zzcar(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        Set set;
        Executor executor = (Executor) this.zzfck.get();
        zzcay zzcay = (zzcay) this.zzfcs.get();
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcql)).booleanValue()) {
            set = Collections.singleton(new zzbqs(zzcay, executor));
        } else {
            set = Collections.emptySet();
        }
        return (Set) zzdwh.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }
}
