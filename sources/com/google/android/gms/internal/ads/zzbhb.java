package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbhb implements zzbnm {
    private final zzcwm zzfbf;

    public zzbhb(zzcwm zzcwm) {
        this.zzfbf = zzcwm;
    }

    public final void zzbu(@Nullable Context context) {
        try {
            this.zzfbf.pause();
        } catch (zzcwh e) {
            zzaug.zzd("Cannot invoke onPause for the mediation adapter.", e);
        }
    }

    public final void zzbv(@Nullable Context context) {
        try {
            this.zzfbf.resume();
            if (context != null) {
                this.zzfbf.onContextChanged(context);
            }
        } catch (zzcwh e) {
            zzaug.zzd("Cannot invoke onResume for the mediation adapter.", e);
        }
    }

    public final void zzbw(@Nullable Context context) {
        try {
            this.zzfbf.destroy();
        } catch (zzcwh e) {
            zzaug.zzd("Cannot invoke onDestroy for the mediation adapter.", e);
        }
    }
}
