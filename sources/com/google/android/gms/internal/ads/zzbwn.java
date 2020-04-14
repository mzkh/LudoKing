package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbwn implements zzdwb<zzbwl> {
    private final zzdwo<zzavy> zzepv;
    private final zzdwo<Executor> zzfck;
    private final zzdwo<Clock> zzfco;

    public zzbwn(zzdwo<zzavy> zzdwo, zzdwo<Clock> zzdwo2, zzdwo<Executor> zzdwo3) {
        this.zzepv = zzdwo;
        this.zzfco = zzdwo2;
        this.zzfck = zzdwo3;
    }

    public final /* synthetic */ Object get() {
        return new zzbwl((zzavy) this.zzepv.get(), (Clock) this.zzfco.get(), (Executor) this.zzfck.get());
    }
}
