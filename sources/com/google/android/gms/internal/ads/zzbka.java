package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbka implements zzdwb<zzbjv> {
    private final zzdwo<zzbkn> zzesy;
    private final zzdwo<Runnable> zzewv;
    private final zzdwo<zzada> zzfcs;
    private final zzdwo<Executor> zzfdx;

    public zzbka(zzdwo<zzbkn> zzdwo, zzdwo<zzada> zzdwo2, zzdwo<Runnable> zzdwo3, zzdwo<Executor> zzdwo4) {
        this.zzesy = zzdwo;
        this.zzfcs = zzdwo2;
        this.zzewv = zzdwo3;
        this.zzfdx = zzdwo4;
    }

    public final /* synthetic */ Object get() {
        return new zzbjv((zzbkn) this.zzesy.get(), (zzada) this.zzfcs.get(), (Runnable) this.zzewv.get(), (Executor) this.zzfdx.get());
    }
}
