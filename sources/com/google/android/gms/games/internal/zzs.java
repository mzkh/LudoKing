package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.video.Videos.CaptureOverlayStateListener;

final class zzs extends zzu<CaptureOverlayStateListener> {
    zzs(ListenerHolder listenerHolder) {
        super(listenerHolder);
    }

    public final void onCaptureOverlayStateChanged(int i) {
        zzc(new zzt(i));
    }
}
