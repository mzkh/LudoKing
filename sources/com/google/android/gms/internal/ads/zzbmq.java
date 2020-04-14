package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbmq implements zzdwb<Bundle> {
    private final zzbmk zzfgv;

    private zzbmq(zzbmk zzbmk) {
        this.zzfgv = zzbmk;
    }

    public static zzbmq zzh(zzbmk zzbmk) {
        return new zzbmq(zzbmk);
    }

    @Nullable
    public final /* synthetic */ Object get() {
        return this.zzfgv.zzafw();
    }
}
