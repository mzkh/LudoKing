package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcos implements zzcru<zzcop> {
    private final Executor executor;
    private final ScheduledExecutorService zzffn;
    private final Context zzlk;

    public zzcos(Context context, ScheduledExecutorService scheduledExecutorService, Executor executor2) {
        this.zzlk = context;
        this.zzffn = scheduledExecutorService;
        this.executor = executor2;
    }

    public final zzddi<zzcop> zzalv() {
        if (!((Boolean) zzuv.zzon().zzd(zzza.zzcth)).booleanValue()) {
            return zzdcy.zzah(null);
        }
        zzaxv zzaxv = new zzaxv();
        try {
            new zzcor(zzaxv).zzbc(false);
        } catch (Throwable unused) {
            zzaug.zzes("ArCoreApk is not ready.");
            zzaxv.set(Boolean.valueOf(false));
        }
        return zzdcy.zzb(zzdcy.zzb(zzdcy.zza(zzaxv, 200, TimeUnit.MILLISECONDS, this.zzffn), (zzdal<? super I, ? extends O>) new zzcou<Object,Object>(this), this.executor), Throwable.class, zzcot.zzbkv, this.executor);
    }
}
