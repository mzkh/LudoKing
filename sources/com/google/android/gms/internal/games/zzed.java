package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.Videos.CaptureCapabilitiesResult;

final class zzed implements CaptureCapabilitiesResult {
    private final /* synthetic */ Status zzbd;

    zzed(zzec zzec, Status status) {
        this.zzbd = status;
    }

    public final VideoCapabilities getCapabilities() {
        return null;
    }

    public final Status getStatus() {
        return this.zzbd;
    }
}
