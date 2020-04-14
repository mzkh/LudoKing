package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcaa implements zzbnm {
    @Nullable
    private final zzbbw zzczi;

    zzcaa(@Nullable zzbbw zzbbw) {
        if (!((Boolean) zzuv.zzon().zzd(zzza.zzckg)).booleanValue()) {
            zzbbw = null;
        }
        this.zzczi = zzbbw;
    }

    public final void zzbu(@Nullable Context context) {
        zzbbw zzbbw = this.zzczi;
        if (zzbbw != null) {
            zzbbw.onPause();
        }
    }

    public final void zzbv(@Nullable Context context) {
        zzbbw zzbbw = this.zzczi;
        if (zzbbw != null) {
            zzbbw.onResume();
        }
    }

    public final void zzbw(@Nullable Context context) {
        zzbbw zzbbw = this.zzczi;
        if (zzbbw != null) {
            zzbbw.destroy();
        }
    }
}
