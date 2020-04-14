package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcto implements zzcru<zzctl> {
    private ScheduledExecutorService zzffn;
    private zzanu zzgho;
    private Context zzlk;

    public zzcto(zzanu zzanu, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.zzgho = zzanu;
        this.zzffn = scheduledExecutorService;
        this.zzlk = context;
    }

    public final zzddi<zzctl> zzalv() {
        return zzdcy.zzb(zzdcy.zza(this.zzgho.zzr(this.zzlk), ((Long) zzuv.zzon().zzd(zzza.zzcpg)).longValue(), TimeUnit.MILLISECONDS, this.zzffn), zzctn.zzdos, (Executor) zzaxn.zzdwi);
    }
}
