package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzchl implements zzdwb<zzchh> {
    private final zzdwo<zzbjn> zzewa;
    private final zzdwo<zzcgn> zzewe;
    private final zzdwo<zzddl> zzfck;
    private final zzdwo<ScheduledExecutorService> zzfoz;
    private final zzdwo<zzbmz> zzfyf;

    public zzchl(zzdwo<zzbjn> zzdwo, zzdwo<zzcgn> zzdwo2, zzdwo<zzbmz> zzdwo3, zzdwo<ScheduledExecutorService> zzdwo4, zzdwo<zzddl> zzdwo5) {
        this.zzewa = zzdwo;
        this.zzewe = zzdwo2;
        this.zzfyf = zzdwo3;
        this.zzfoz = zzdwo4;
        this.zzfck = zzdwo5;
    }

    public final /* synthetic */ Object get() {
        zzchh zzchh = new zzchh((zzbjn) this.zzewa.get(), (zzcgn) this.zzewe.get(), (zzbmz) this.zzfyf.get(), (ScheduledExecutorService) this.zzfoz.get(), (zzddl) this.zzfck.get());
        return zzchh;
    }
}
