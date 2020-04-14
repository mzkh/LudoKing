package com.google.android.gms.games.video;

import android.os.Bundle;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

public final class CaptureState {
    private final boolean zzst;
    private final int zzsu;
    private final int zzsv;
    private final boolean zzsw;
    private final boolean zzsx;

    private CaptureState(boolean z, int i, int i2, boolean z2, boolean z3) {
        Preconditions.checkArgument(VideoConfiguration.isValidCaptureMode(i, true));
        Preconditions.checkArgument(VideoConfiguration.isValidQualityLevel(i2, true));
        this.zzst = z;
        this.zzsu = i;
        this.zzsv = i2;
        this.zzsw = z2;
        this.zzsx = z3;
    }

    public final boolean isCapturing() {
        return this.zzst;
    }

    public final int getCaptureMode() {
        return this.zzsu;
    }

    public final int getCaptureQuality() {
        return this.zzsv;
    }

    public final boolean isOverlayVisible() {
        return this.zzsw;
    }

    public final boolean isPaused() {
        return this.zzsx;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("IsCapturing", Boolean.valueOf(this.zzst)).add("CaptureMode", Integer.valueOf(this.zzsu)).add("CaptureQuality", Integer.valueOf(this.zzsv)).add("IsOverlayVisible", Boolean.valueOf(this.zzsw)).add("IsPaused", Boolean.valueOf(this.zzsx)).toString();
    }

    public static CaptureState zzb(Bundle bundle) {
        if (bundle != null) {
            String str = "IsCapturing";
            if (bundle.get(str) != null) {
                CaptureState captureState = new CaptureState(bundle.getBoolean(str, false), bundle.getInt("CaptureMode", -1), bundle.getInt("CaptureQuality", -1), bundle.getBoolean("IsOverlayVisible", false), bundle.getBoolean("IsPaused", false));
                return captureState;
            }
        }
        return null;
    }
}
