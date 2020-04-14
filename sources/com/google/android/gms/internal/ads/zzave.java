package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzave {
    private float zzdjk = 1.0f;
    private boolean zzdjq = false;

    public final synchronized void setAppVolume(float f) {
        this.zzdjk = f;
    }

    public final synchronized float zzos() {
        if (!zzvy()) {
            return 1.0f;
        }
        return this.zzdjk;
    }

    public final synchronized void setAppMuted(boolean z) {
        this.zzdjq = z;
    }

    public final synchronized boolean zzot() {
        return this.zzdjq;
    }

    private final synchronized boolean zzvy() {
        return this.zzdjk >= 0.0f;
    }

    public static float zzbe(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return 0.0f;
        }
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        int streamVolume = audioManager.getStreamVolume(3);
        if (streamMaxVolume == 0) {
            return 0.0f;
        }
        return ((float) streamVolume) / ((float) streamMaxVolume);
    }
}
