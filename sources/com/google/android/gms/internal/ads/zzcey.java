package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcey implements zzdwb<zzcen> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<Executor> zzfdx;
    private final zzdwo<zzapr> zzfvp;
    private final zzdwo<zzbgq> zzfvq;
    private final zzdwo<zzaps> zzfvr;

    private zzcey(zzdwo<Context> zzdwo, zzdwo<Executor> zzdwo2, zzdwo<zzapr> zzdwo3, zzdwo<zzbgq> zzdwo4, zzdwo<zzaps> zzdwo5) {
        this.zzejy = zzdwo;
        this.zzfdx = zzdwo2;
        this.zzfvp = zzdwo3;
        this.zzfvq = zzdwo4;
        this.zzfvr = zzdwo5;
    }

    public static zzcey zzg(zzdwo<Context> zzdwo, zzdwo<Executor> zzdwo2, zzdwo<zzapr> zzdwo3, zzdwo<zzbgq> zzdwo4, zzdwo<zzaps> zzdwo5) {
        zzcey zzcey = new zzcey(zzdwo, zzdwo2, zzdwo3, zzdwo4, zzdwo5);
        return zzcey;
    }

    public final /* synthetic */ Object get() {
        zzcen zzcen = new zzcen((Context) this.zzejy.get(), (Executor) this.zzfdx.get(), (zzapr) this.zzfvp.get(), (zzbgq) this.zzfvq.get(), (zzaps) this.zzfvr.get());
        return zzcen;
    }
}
