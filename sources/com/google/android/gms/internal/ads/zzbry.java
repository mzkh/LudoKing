package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbry implements zzdwb<View> {
    private final zzbrx zzfin;

    private zzbry(zzbrx zzbrx) {
        this.zzfin = zzbrx;
    }

    public static zzbry zza(zzbrx zzbrx) {
        return new zzbry(zzbrx);
    }

    @Nullable
    public final /* synthetic */ Object get() {
        return this.zzfin.zzagv();
    }
}
