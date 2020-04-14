package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcok implements zzcru<zzcrr<Bundle>> {
    private final Executor executor;
    private final zzatr zzbml;

    zzcok(Executor executor2, zzatr zzatr) {
        this.executor = executor2;
        this.zzbml = zzatr;
    }

    public final zzddi<zzcrr<Bundle>> zzalv() {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcne)).booleanValue()) {
            return zzdcy.zzah(null);
        }
        return zzdcy.zzb(this.zzbml.zzui(), zzcoj.zzdos, this.executor);
    }
}
