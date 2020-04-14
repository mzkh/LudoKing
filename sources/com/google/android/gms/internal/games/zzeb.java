package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.video.Videos.CaptureAvailableResult;

final class zzeb implements CaptureAvailableResult {
    private final /* synthetic */ Status zzbd;

    zzeb(zzea zzea, Status status) {
        this.zzbd = status;
    }

    public final boolean isAvailable() {
        return false;
    }

    public final Status getStatus() {
        return this.zzbd;
    }
}
