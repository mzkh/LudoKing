package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbhp implements zzdwb<zzbhk> {
    private final zzdwo<Executor> zzfck;
    private final zzdwo<zzajc> zzfcl;
    private final zzdwo<zzbhi> zzfcm;
    private final zzdwo<zzbhf> zzfcn;
    private final zzdwo<Clock> zzfco;

    private zzbhp(zzdwo<zzajc> zzdwo, zzdwo<zzbhi> zzdwo2, zzdwo<Executor> zzdwo3, zzdwo<zzbhf> zzdwo4, zzdwo<Clock> zzdwo5) {
        this.zzfcl = zzdwo;
        this.zzfcm = zzdwo2;
        this.zzfck = zzdwo3;
        this.zzfcn = zzdwo4;
        this.zzfco = zzdwo5;
    }

    public static zzbhp zza(zzdwo<zzajc> zzdwo, zzdwo<zzbhi> zzdwo2, zzdwo<Executor> zzdwo3, zzdwo<zzbhf> zzdwo4, zzdwo<Clock> zzdwo5) {
        zzbhp zzbhp = new zzbhp(zzdwo, zzdwo2, zzdwo3, zzdwo4, zzdwo5);
        return zzbhp;
    }

    public final /* synthetic */ Object get() {
        zzbhk zzbhk = new zzbhk((zzajc) this.zzfcl.get(), (zzbhi) this.zzfcm.get(), (Executor) this.zzfck.get(), (zzbhf) this.zzfcn.get(), (Clock) this.zzfco.get());
        return zzbhk;
    }
}
