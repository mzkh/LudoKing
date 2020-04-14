package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcjg<AdT> implements zzdcj<zzcvz, AdT> {
    private final Executor executor;
    private final zzcyp zzfbe;
    private final ScheduledExecutorService zzfcx;
    private final zzcyg zzfgb;
    private final zzbmz zzfht;
    private final zzbkp<AdT> zzfzi;
    private final zzcjf zzfzj;

    public zzcjg(zzcyg zzcyg, zzcjf zzcjf, zzbmz zzbmz, zzcyp zzcyp, zzbkp<AdT> zzbkp, Executor executor2, ScheduledExecutorService scheduledExecutorService) {
        this.zzfgb = zzcyg;
        this.zzfzj = zzcjf;
        this.zzfht = zzbmz;
        this.zzfbe = zzcyp;
        this.zzfzi = zzbkp;
        this.executor = executor2;
        this.zzfcx = scheduledExecutorService;
    }

    public final /* synthetic */ zzddi zzf(Object obj) throws Exception {
        zzcvz zzcvz = (zzcvz) obj;
        zzcxp zzant = this.zzfgb.zzu(zzcyd.RENDER_CONFIG_INIT).zzb(zzdcy.zzi(new zzcjh("No ad configs", 3))).zzant();
        this.zzfht.zza(new zzbha(zzcvz, this.zzfbe), this.executor);
        int i = 0;
        for (zzcvr zzcvr : zzcvz.zzgkb.zzgjx) {
            Iterator it = zzcvr.zzgiy.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                zzcga zze = this.zzfzi.zze(zzcvr.zzfis, str);
                if (zze != null && zze.zza(zzcvz, zzcvr)) {
                    zzcxy zza = this.zzfgb.zza(zzcyd.RENDER_CONFIG_WATERFALL, (zzddi<I>) zzant);
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 26);
                    sb.append("render-config-");
                    sb.append(i);
                    sb.append("-");
                    sb.append(str);
                    zzant = zza.zzgi(sb.toString()).zza(Throwable.class, (zzdcj<T, O>) new zzcjj<T,O>(this, zzcvr, zze, zzcvz)).zzant();
                    break;
                }
            }
            i++;
        }
        return zzant;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzddi zza(zzcvr zzcvr, zzcga zzcga, zzcvz zzcvz, Throwable th) throws Exception {
        return this.zzfzj.zza(zzcvr, zzdcy.zza(zzcga.zzb(zzcvz, zzcvr), (long) zzcvr.zzgjn, TimeUnit.MILLISECONDS, this.zzfcx));
    }
}
