package com.google.android.gms.ads.formats;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.VideoOptions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class NativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_ANY = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_LANDSCAPE = 2;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_PORTRAIT = 3;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_SQUARE = 4;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_UNKNOWN = 0;
    @Deprecated
    public static final int ORIENTATION_ANY = 0;
    @Deprecated
    public static final int ORIENTATION_LANDSCAPE = 2;
    @Deprecated
    public static final int ORIENTATION_PORTRAIT = 1;
    private final boolean zzbju;
    private final int zzbjv;
    private final int zzbjw;
    private final boolean zzbjx;
    private final int zzbjy;
    private final VideoOptions zzbjz;
    private final boolean zzbka;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public @interface AdChoicesPlacement {
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zzbju = false;
        /* access modifiers changed from: private */
        public int zzbjv = -1;
        /* access modifiers changed from: private */
        public int zzbjw = 0;
        /* access modifiers changed from: private */
        public boolean zzbjx = false;
        /* access modifiers changed from: private */
        public int zzbjy = 1;
        /* access modifiers changed from: private */
        public VideoOptions zzbjz;
        /* access modifiers changed from: private */
        public boolean zzbka = false;

        public final Builder setReturnUrlsForImageAssets(boolean z) {
            this.zzbju = z;
            return this;
        }

        @Deprecated
        public final Builder setImageOrientation(int i) {
            this.zzbjv = i;
            return this;
        }

        public final Builder setMediaAspectRatio(@NativeMediaAspectRatio int i) {
            this.zzbjw = i;
            return this;
        }

        public final Builder setRequestMultipleImages(boolean z) {
            this.zzbjx = z;
            return this;
        }

        public final Builder setAdChoicesPlacement(@AdChoicesPlacement int i) {
            this.zzbjy = i;
            return this;
        }

        public final Builder setVideoOptions(VideoOptions videoOptions) {
            this.zzbjz = videoOptions;
            return this;
        }

        public final Builder setRequestCustomMuteThisAd(boolean z) {
            this.zzbka = z;
            return this;
        }

        public final NativeAdOptions build() {
            return new NativeAdOptions(this);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public @interface NativeMediaAspectRatio {
    }

    private NativeAdOptions(Builder builder) {
        this.zzbju = builder.zzbju;
        this.zzbjv = builder.zzbjv;
        this.zzbjw = builder.zzbjw;
        this.zzbjx = builder.zzbjx;
        this.zzbjy = builder.zzbjy;
        this.zzbjz = builder.zzbjz;
        this.zzbka = builder.zzbka;
    }

    public final boolean shouldReturnUrlsForImageAssets() {
        return this.zzbju;
    }

    @Deprecated
    public final int getImageOrientation() {
        return this.zzbjv;
    }

    public final int getMediaAspectRatio() {
        return this.zzbjw;
    }

    public final boolean shouldRequestMultipleImages() {
        return this.zzbjx;
    }

    public final int getAdChoicesPlacement() {
        return this.zzbjy;
    }

    @Nullable
    public final VideoOptions getVideoOptions() {
        return this.zzbjz;
    }

    public final boolean zzje() {
        return this.zzbka;
    }
}
