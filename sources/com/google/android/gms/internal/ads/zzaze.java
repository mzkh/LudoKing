package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import java.util.concurrent.TimeUnit;

@TargetApi(14)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaze {
    private final long zzdyy = TimeUnit.MILLISECONDS.toNanos(((Long) zzuv.zzon().zzd(zzza.zzchq)).longValue());
    private long zzdyz;
    private boolean zzdza = true;

    zzaze() {
    }

    public final void zzww() {
        this.zzdza = true;
    }

    public final void zza(SurfaceTexture surfaceTexture, zzayr zzayr) {
        if (zzayr != null) {
            long timestamp = surfaceTexture.getTimestamp();
            if (this.zzdza || Math.abs(timestamp - this.zzdyz) >= this.zzdyy) {
                this.zzdza = false;
                this.zzdyz = timestamp;
                zzaul.zzdsu.post(new zzazd(this, zzayr));
            }
        }
    }
}
