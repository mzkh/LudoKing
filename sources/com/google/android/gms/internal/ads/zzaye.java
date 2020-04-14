package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzaye implements zzdcz<T> {
    private final /* synthetic */ zzaxz zzdwx;
    private final /* synthetic */ zzaxx zzdwy;

    zzaye(zzayc zzayc, zzaxz zzaxz, zzaxx zzaxx) {
        this.zzdwx = zzaxz;
        this.zzdwy = zzaxx;
    }

    public final void onSuccess(@Nullable T t) {
        this.zzdwx.zzh(t);
    }

    public final void zzb(Throwable th) {
        this.zzdwy.run();
    }
}
