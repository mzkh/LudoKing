package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcrq implements zzcru<zzcrr<Bundle>> {
    private final boolean zzggg;

    zzcrq(@Nullable zzcuf zzcuf) {
        if (zzcuf != null) {
            this.zzggg = zzcuf.zzggg;
        } else {
            this.zzggg = false;
        }
    }

    public final zzddi<zzcrr<Bundle>> zzalv() {
        return zzdcy.zzah(this.zzggg ? zzcrp.zzggf : null);
    }
}
