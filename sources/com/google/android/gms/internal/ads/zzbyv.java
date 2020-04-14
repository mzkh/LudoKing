package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbyv extends VideoLifecycleCallbacks {
    private final zzbur zzfjl;

    public zzbyv(zzbur zzbur) {
        this.zzfjl = zzbur;
    }

    public final void onVideoStart() {
        zzws zza = zza(this.zzfjl);
        if (zza != null) {
            try {
                zza.onVideoStart();
            } catch (RemoteException e) {
                zzaug.zzd("Unable to call onVideoEnd()", e);
            }
        }
    }

    public final void onVideoPause() {
        zzws zza = zza(this.zzfjl);
        if (zza != null) {
            try {
                zza.onVideoPause();
            } catch (RemoteException e) {
                zzaug.zzd("Unable to call onVideoEnd()", e);
            }
        }
    }

    public final void onVideoEnd() {
        zzws zza = zza(this.zzfjl);
        if (zza != null) {
            try {
                zza.onVideoEnd();
            } catch (RemoteException e) {
                zzaug.zzd("Unable to call onVideoEnd()", e);
            }
        }
    }

    private static zzws zza(zzbur zzbur) {
        zzwr videoController = zzbur.getVideoController();
        if (videoController == null) {
            return null;
        }
        try {
            return videoController.zzoz();
        } catch (RemoteException unused) {
            return null;
        }
    }
}
