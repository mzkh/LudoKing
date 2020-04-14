package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzyg extends zzwv {
    private final VideoLifecycleCallbacks zzabo;

    public zzyg(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.zzabo = videoLifecycleCallbacks;
    }

    public final void onVideoStart() {
        this.zzabo.onVideoStart();
    }

    public final void onVideoPlay() {
        this.zzabo.onVideoPlay();
    }

    public final void onVideoPause() {
        this.zzabo.onVideoPause();
    }

    public final void onVideoEnd() {
        this.zzabo.onVideoEnd();
    }

    public final void onVideoMute(boolean z) {
        this.zzabo.onVideoMute(z);
    }
}
