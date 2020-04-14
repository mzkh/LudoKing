package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Class(creator = "VideoConfigurationCreator")
@Reserved({1000})
public final class VideoConfiguration extends AbstractSafeParcelable {
    public static final int CAPTURE_MODE_FILE = 0;
    public static final int CAPTURE_MODE_STREAM = 1;
    public static final int CAPTURE_MODE_UNKNOWN = -1;
    public static final Creator<VideoConfiguration> CREATOR = new zzb();
    public static final int NUM_CAPTURE_MODE = 2;
    public static final int NUM_QUALITY_LEVEL = 4;
    public static final int QUALITY_LEVEL_FULLHD = 3;
    public static final int QUALITY_LEVEL_HD = 1;
    public static final int QUALITY_LEVEL_SD = 0;
    public static final int QUALITY_LEVEL_UNKNOWN = -1;
    public static final int QUALITY_LEVEL_XHD = 2;
    @Field(getter = "getCaptureMode", mo15151id = 2)
    private final int zzsu;
    @Field(getter = "getQualityLevel", mo15151id = 1)
    private final int zztd;
    @Field(getter = "shouldShowToastAfterRecording", mo15151id = 7)
    private final boolean zzte;
    @Field(getter = "getCameraEnabled", mo15151id = 8)
    private final boolean zztf;
    @Field(getter = "getMicEnabled", mo15151id = 9)
    private final boolean zztg;

    public static final class Builder {
        private int zzsu;
        private int zztd;
        private boolean zzte = true;
        private boolean zztf = true;
        private boolean zztg = true;

        public Builder(int i, int i2) {
            this.zztd = i;
            this.zzsu = i2;
        }

        public final Builder setQualityLevel(int i) {
            this.zztd = i;
            return this;
        }

        public final Builder setCaptureMode(int i) {
            this.zzsu = i;
            return this;
        }

        public final Builder setMicEnabled(boolean z) {
            this.zztg = z;
            return this;
        }

        public final Builder setCameraEnabled(boolean z) {
            this.zztf = z;
            return this;
        }

        public final VideoConfiguration build() {
            VideoConfiguration videoConfiguration = new VideoConfiguration(this.zztd, this.zzsu, this.zzte, this.zztf, this.zztg);
            return videoConfiguration;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ValidCaptureModes {
    }

    @Constructor
    public VideoConfiguration(@Param(mo15154id = 1) int i, @Param(mo15154id = 2) int i2, @Param(mo15154id = 7) boolean z, @Param(mo15154id = 8) boolean z2, @Param(mo15154id = 9) boolean z3) {
        Preconditions.checkArgument(isValidQualityLevel(i, false));
        Preconditions.checkArgument(isValidCaptureMode(i2, false));
        this.zztd = i;
        this.zzsu = i2;
        this.zzte = z;
        this.zztf = z2;
        this.zztg = z3;
    }

    public static boolean isValidCaptureMode(int i, boolean z) {
        if (i != -1) {
            if (i == 0) {
                return true;
            }
            if (i != 1) {
                return false;
            }
        }
        return z;
    }

    public static boolean isValidQualityLevel(int i, boolean z) {
        if (i != -1) {
            z = true;
            if (!(i == 0 || i == 1 || i == 2 || i == 3)) {
                return false;
            }
        }
        return z;
    }

    public final int getQualityLevel() {
        return this.zztd;
    }

    public final int getCaptureMode() {
        return this.zzsu;
    }

    public final boolean getCameraEnabled() {
        return this.zztf;
    }

    public final boolean getMicEnabled() {
        return this.zztg;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getQualityLevel());
        SafeParcelWriter.writeInt(parcel, 2, getCaptureMode());
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzte);
        SafeParcelWriter.writeBoolean(parcel, 8, getCameraEnabled());
        SafeParcelWriter.writeBoolean(parcel, 9, getMicEnabled());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
