package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzchh implements zzcga<zzbio> {
    private final ScheduledExecutorService zzffn;
    /* access modifiers changed from: private */
    public final zzbmz zzfht;
    private final zzddl zzfoa;
    private final zzbjn zzfyb;
    private final zzcgn zzfyc;

    public zzchh(zzbjn zzbjn, zzcgn zzcgn, zzbmz zzbmz, ScheduledExecutorService scheduledExecutorService, zzddl zzddl) {
        this.zzfyb = zzbjn;
        this.zzfyc = zzcgn;
        this.zzfht = zzbmz;
        this.zzffn = scheduledExecutorService;
        this.zzfoa = zzddl;
    }

    public final boolean zza(zzcvz zzcvz, zzcvr zzcvr) {
        return zzcvz.zzgka.zzfga.zzana() != null && this.zzfyc.zza(zzcvz, zzcvr);
    }

    public final zzddi<zzbio> zzb(zzcvz zzcvz, zzcvr zzcvr) {
        return this.zzfoa.zzd(new zzchg(this, zzcvz, zzcvr));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzbio zzc(zzcvz zzcvz, zzcvr zzcvr) throws Exception {
        return this.zzfyb.zza(new zzbla(zzcvz, zzcvr, null), new zzbjz(zzcvz.zzgka.zzfga.zzana(), new zzchj(this, zzcvz, zzcvr))).zzada();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzd(zzcvz zzcvz, zzcvr zzcvr) {
        zzdcy.zza(zzdcy.zza(this.zzfyc.zzb(zzcvz, zzcvr), (long) zzcvr.zzgjn, TimeUnit.SECONDS, this.zzffn), new zzchi(this), this.zzfoa);
    }
}
