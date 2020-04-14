package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcbp implements zzdwb<zzcbn> {
    private final zzdwo<Clock> zzfco;
    private final zzdwo<zzcbl> zzfsf;
    private final zzdwo<Set<zzcbm>> zzfsg;

    private zzcbp(zzdwo<zzcbl> zzdwo, zzdwo<Set<zzcbm>> zzdwo2, zzdwo<Clock> zzdwo3) {
        this.zzfsf = zzdwo;
        this.zzfsg = zzdwo2;
        this.zzfco = zzdwo3;
    }

    public static zzcbp zzm(zzdwo<zzcbl> zzdwo, zzdwo<Set<zzcbm>> zzdwo2, zzdwo<Clock> zzdwo3) {
        return new zzcbp(zzdwo, zzdwo2, zzdwo3);
    }

    public final /* synthetic */ Object get() {
        return new zzcbn((zzcbl) this.zzfsf.get(), (Set) this.zzfsg.get(), (Clock) this.zzfco.get());
    }
}
