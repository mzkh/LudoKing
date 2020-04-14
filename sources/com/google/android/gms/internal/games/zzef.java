package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.Videos.CaptureStateResult;

final class zzef implements CaptureStateResult {
    private final /* synthetic */ Status zzbd;

    zzef(zzee zzee, Status status) {
        this.zzbd = status;
    }

    public final CaptureState getCaptureState() {
        return null;
    }

    public final Status getStatus() {
        return this.zzbd;
    }
}
