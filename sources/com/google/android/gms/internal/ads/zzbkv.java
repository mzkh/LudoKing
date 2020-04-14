package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbkv {
    private final Executor executor;
    private volatile boolean zzadc = true;
    private final ScheduledExecutorService zzffn;
    private final zzddi<zzbkq> zzffo;

    public zzbkv(Executor executor2, ScheduledExecutorService scheduledExecutorService, zzddi<zzbkq> zzddi) {
        this.executor = executor2;
        this.zzffn = scheduledExecutorService;
        this.zzffo = zzddi;
    }

    public final void zza(zzdcz<zzbkk> zzdcz) {
        zzdcy.zza(this.zzffo, new zzbky(this, zzdcz), this.executor);
    }

    /* access modifiers changed from: private */
    public final void zza(List<? extends zzddi<? extends zzbkk>> list, zzdcz<zzbkk> zzdcz) {
        if (list == null || list.isEmpty()) {
            this.executor.execute(new zzbku(zzdcz));
            return;
        }
        zzddi zzah = zzdcy.zzah(null);
        for (zzddi zzbkw : list) {
            zzah = zzdcy.zzb(zzdcy.zzb(zzah, Throwable.class, new zzbkx(zzdcz), this.executor), (zzdcj<? super I, ? extends O>) new zzbkw<Object,Object>(this, zzdcz, zzbkw), this.executor);
        }
        zzdcy.zza(zzah, new zzblb(this, zzdcz), this.executor);
    }

    public final boolean isLoading() {
        return this.zzadc;
    }

    /* access modifiers changed from: private */
    public final void zzafn() {
        zzaxn.zzdwm.execute(new zzbkz(this));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzafo() {
        this.zzadc = false;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzddi zza(zzdcz zzdcz, zzddi zzddi, zzbkk zzbkk) throws Exception {
        if (zzbkk != null) {
            zzdcz.onSuccess(zzbkk);
        }
        return zzdcy.zza(zzddi, ((Long) zzuv.zzon().zzd(zzza.zzcmn)).longValue(), TimeUnit.MILLISECONDS, this.zzffn);
    }
}
