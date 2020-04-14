package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbup {
    @Nullable
    private zzabh zzcwp;

    public zzbup(zzbuh zzbuh) {
        this.zzcwp = zzbuh;
    }

    @Nullable
    public final synchronized zzabh zzqx() {
        return this.zzcwp;
    }

    public final synchronized void zza(@Nullable zzabh zzabh) {
        this.zzcwp = zzabh;
    }
}
