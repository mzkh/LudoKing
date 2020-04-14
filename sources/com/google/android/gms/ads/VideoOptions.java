package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzyj;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class VideoOptions {
    private final boolean zzabp;
    private final boolean zzabq;
    private final boolean zzabr;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zzabp = true;
        /* access modifiers changed from: private */
        public boolean zzabq = false;
        /* access modifiers changed from: private */
        public boolean zzabr = false;

        public final Builder setStartMuted(boolean z) {
            this.zzabp = z;
            return this;
        }

        public final Builder setCustomControlsRequested(boolean z) {
            this.zzabq = z;
            return this;
        }

        public final Builder setClickToExpandRequested(boolean z) {
            this.zzabr = z;
            return this;
        }

        public final VideoOptions build() {
            return new VideoOptions(this);
        }
    }

    public VideoOptions(zzyj zzyj) {
        this.zzabp = zzyj.zzabp;
        this.zzabq = zzyj.zzabq;
        this.zzabr = zzyj.zzabr;
    }

    private VideoOptions(Builder builder) {
        this.zzabp = builder.zzabp;
        this.zzabq = builder.zzabq;
        this.zzabr = builder.zzabr;
    }

    public final boolean getStartMuted() {
        return this.zzabp;
    }

    public final boolean getCustomControlsRequested() {
        return this.zzabq;
    }

    public final boolean getClickToExpandRequested() {
        return this.zzabr;
    }
}
