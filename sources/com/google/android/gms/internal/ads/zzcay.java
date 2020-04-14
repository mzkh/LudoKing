package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcay implements zzcym {
    private zzsd zzfrg;
    private Map<zzcyd, zzcba> zzfro;

    zzcay(zzsd zzsd, Map<zzcyd, zzcba> map) {
        this.zzfro = map;
        this.zzfrg = zzsd;
    }

    public final void zza(zzcyd zzcyd, String str) {
    }

    public final void zzb(zzcyd zzcyd, String str) {
        if (this.zzfro.containsKey(zzcyd)) {
            this.zzfrg.zza(((zzcba) this.zzfro.get(zzcyd)).zzfrr);
        }
    }

    public final void zza(zzcyd zzcyd, String str, Throwable th) {
        if (this.zzfro.containsKey(zzcyd)) {
            this.zzfrg.zza(((zzcba) this.zzfro.get(zzcyd)).zzfrt);
        }
    }

    public final void zzc(zzcyd zzcyd, String str) {
        if (this.zzfro.containsKey(zzcyd)) {
            this.zzfrg.zza(((zzcba) this.zzfro.get(zzcyd)).zzfrs);
        }
    }
}
