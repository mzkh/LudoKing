package com.google.android.gms.games.internal;

import com.google.android.gms.games.video.Videos.CaptureOverlayStateListener;

final /* synthetic */ class zzt implements zzap {
    private final int zzhc;

    zzt(int i) {
        this.zzhc = i;
    }

    public final void accept(Object obj) {
        ((CaptureOverlayStateListener) obj).onCaptureOverlayStateChanged(this.zzhc);
    }
}
