package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzayb implements zzdcz<T> {
    private final /* synthetic */ zzayc zzdwu;

    zzayb(zzayc zzayc) {
        this.zzdwu = zzayc;
    }

    public final void onSuccess(@Nullable T t) {
        this.zzdwu.zzdww.set(1);
    }

    public final void zzb(Throwable th) {
        this.zzdwu.zzdww.set(-1);
    }
}
