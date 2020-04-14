package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaio {
    private final Object zzdau = new Object();
    private final Object zzdav = new Object();
    @GuardedBy("lockClient")
    private zzaix zzdaw;
    @GuardedBy("lockService")
    private zzaix zzdax;

    public final zzaix zza(Context context, zzaxl zzaxl) {
        zzaix zzaix;
        synchronized (this.zzdav) {
            if (this.zzdax == null) {
                this.zzdax = new zzaix(zzl(context), zzaxl, (String) zzuv.zzon().zzd(zzza.zzcge));
            }
            zzaix = this.zzdax;
        }
        return zzaix;
    }

    public final zzaix zzb(Context context, zzaxl zzaxl) {
        zzaix zzaix;
        synchronized (this.zzdau) {
            if (this.zzdaw == null) {
                this.zzdaw = new zzaix(zzl(context), zzaxl, (String) zzuv.zzon().zzd(zzza.zzcgf));
            }
            zzaix = this.zzdaw;
        }
        return zzaix;
    }

    private static Context zzl(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }
}
