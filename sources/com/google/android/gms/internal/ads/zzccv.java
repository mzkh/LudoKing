package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzccv implements zzdwb<zzccj> {
    private final zzdwo<zzchm> zzejw;
    private final zzdwo<zzcbt> zzekr;
    private final zzdwo<Executor> zzfck;
    private final zzdwo<zzaxl> zzfcq;
    private final zzdwo<Executor> zzfdx;
    private final zzdwo<ScheduledExecutorService> zzfoz;
    private final zzdwo<Context> zzftn;
    private final zzdwo<WeakReference<Context>> zzfto;

    public zzccv(zzdwo<Executor> zzdwo, zzdwo<Context> zzdwo2, zzdwo<WeakReference<Context>> zzdwo3, zzdwo<Executor> zzdwo4, zzdwo<zzchm> zzdwo5, zzdwo<ScheduledExecutorService> zzdwo6, zzdwo<zzcbt> zzdwo7, zzdwo<zzaxl> zzdwo8) {
        this.zzfdx = zzdwo;
        this.zzftn = zzdwo2;
        this.zzfto = zzdwo3;
        this.zzfck = zzdwo4;
        this.zzejw = zzdwo5;
        this.zzfoz = zzdwo6;
        this.zzekr = zzdwo7;
        this.zzfcq = zzdwo8;
    }

    public final /* synthetic */ Object get() {
        zzccj zzccj = new zzccj((Executor) this.zzfdx.get(), (Context) this.zzftn.get(), (WeakReference) this.zzfto.get(), (Executor) this.zzfck.get(), (zzchm) this.zzejw.get(), (ScheduledExecutorService) this.zzfoz.get(), (zzcbt) this.zzekr.get(), (zzaxl) this.zzfcq.get());
        return zzccj;
    }
}
