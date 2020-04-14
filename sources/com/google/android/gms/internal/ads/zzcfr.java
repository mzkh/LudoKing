package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcfr implements zzcym {
    private final zzcfp zzfwn;

    zzcfr(zzcfp zzcfp) {
        this.zzfwn = zzcfp;
    }

    public final void zza(zzcyd zzcyd, String str) {
    }

    public final void zzb(zzcyd zzcyd, String str) {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzctc)).booleanValue() && zzcyd.RENDERER == zzcyd) {
            this.zzfwn.zzey(zzq.zzkq().elapsedRealtime());
        }
    }

    public final void zza(zzcyd zzcyd, String str, Throwable th) {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzctc)).booleanValue() && zzcyd.RENDERER == zzcyd && this.zzfwn.zzakp() != 0) {
            this.zzfwn.zzel(zzq.zzkq().elapsedRealtime() - this.zzfwn.zzakp());
        }
    }

    public final void zzc(zzcyd zzcyd, String str) {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzctc)).booleanValue() && zzcyd.RENDERER == zzcyd && this.zzfwn.zzakp() != 0) {
            this.zzfwn.zzel(zzq.zzkq().elapsedRealtime() - this.zzfwn.zzakp());
        }
    }
}
