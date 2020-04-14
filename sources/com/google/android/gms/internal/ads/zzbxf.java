package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbxf implements zzdwb<zzbxb> {
    private final zzdwo<Executor> zzfck;
    private final zzdwo<zzbwq> zzfor;

    public zzbxf(zzdwo<Executor> zzdwo, zzdwo<zzbwq> zzdwo2) {
        this.zzfck = zzdwo;
        this.zzfor = zzdwo2;
    }

    public final /* synthetic */ Object get() {
        return new zzbxb((Executor) this.zzfck.get(), (zzbwq) this.zzfor.get());
    }
}
