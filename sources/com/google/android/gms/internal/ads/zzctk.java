package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzctk implements zzcru<zzcth> {
    private ApplicationInfo applicationInfo;
    private boolean zzdmb;
    private ScheduledExecutorService zzffn;
    private zzajk zzghl;

    public zzctk(zzajk zzajk, ScheduledExecutorService scheduledExecutorService, boolean z, ApplicationInfo applicationInfo2) {
        this.zzghl = zzajk;
        this.zzffn = scheduledExecutorService;
        this.zzdmb = z;
        this.applicationInfo = applicationInfo2;
    }

    public final zzddi<zzcth> zzalv() {
        if (!this.zzdmb) {
            return zzdcy.zzi(new Exception("Auto Collect Location is false."));
        }
        return zzdcy.zzb(zzdcy.zza(this.zzghl.zza(this.applicationInfo), ((Long) zzuv.zzon().zzd(zzza.zzcor)).longValue(), TimeUnit.MILLISECONDS, this.zzffn), zzctj.zzdos, (Executor) zzaxn.zzdwi);
    }
}
